package sample.cassandra;

import com.scalar.db.api.DistributedTransaction;
import com.scalar.db.api.DistributedTransactionManager;
import com.scalar.db.api.TransactionCrudOperable;
import com.scalar.db.api.TwoPhaseCommitTransaction;
import com.scalar.db.api.TwoPhaseCommitTransactionManager;
import com.scalar.db.exception.transaction.AbortException;
import com.scalar.db.exception.transaction.CrudException;
import com.scalar.db.exception.transaction.RollbackException;
import com.scalar.db.exception.transaction.TransactionException;
import com.scalar.db.service.TransactionFactory;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.io.Closeable;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.cassandra.model.User;
import sample.cassandra.model.Post;
import sample.rpc.CommitRequest;
import sample.rpc.CassandraGrpc;
import sample.rpc.MysqlGrpc;
import sample.rpc.CreateUserOnCassandraRequest;
import sample.rpc.CreateUserOnCassandraResponse;
import sample.rpc.CreateUserOnMysqlRequest;
import sample.rpc.GetPostRequest;
import sample.rpc.GetPostResponse;
import sample.rpc.CreatePostRequest;
import sample.rpc.CreatePostResponse;
import sample.rpc.GetUserRequest;
import sample.rpc.GetUserResponse;
import sample.rpc.PrepareRequest;
import sample.rpc.RollbackRequest;
import sample.rpc.ValidateRequest;
import sample.rpc.GetAllPostsRequest;
import sample.rpc.GetAllPostsResponse;
import sample.rpc.GetAllUsersRequest;
import sample.rpc.GetAllUsersResponse;

public class Cassandra extends CassandraGrpc.CassandraImplBase implements Closeable {
  private static final Logger logger = LoggerFactory.getLogger(Cassandra.class);

  // For normal transactions
  private final DistributedTransactionManager transactionManager;

  // For two-phase commit transactions
  private final TwoPhaseCommitTransactionManager twoPhaseCommitTransactionManager;

  // For gRPC connection to mysql
  private final ManagedChannel channel;
  private final MysqlGrpc.MysqlBlockingStub mysqlStub;

  private interface TransactionFunction<T, R> {
    R apply(T t) throws TransactionException;
  }

  public Cassandra(String configFile) throws TransactionException, IOException {
    // Initialize the transaction manager
    TransactionFactory factory = TransactionFactory.create(configFile);
    transactionManager = factory.getTransactionManager();
    twoPhaseCommitTransactionManager = factory.getTwoPhaseCommitTransactionManager();

    // Initialize the gRPC connection to mysql
    channel = NettyChannelBuilder.forAddress("mysql-server", 10010).usePlaintext().build();
    mysqlStub = MysqlGrpc.newBlockingStub(channel);

    loadInitialData();
  }


  private void loadInitialData() throws TransactionException {
    DistributedTransaction transaction = null;
    try {
      transaction = transactionManager.start();
      loadUserIfNotExists(transaction, NextId.userId, "Andy", "passwordandy");
      loadUserIfNotExists(transaction, NextId.userId, "Bill", "passwordbill");
      loadUserIfNotExists(transaction, NextId.userId, "Carlie", "passwordcarlie");
      loadPostIfNotExists(transaction, NextId.postId, 1, "Cassandra,Aloha!");
      loadPostIfNotExists(transaction, NextId.postId, 2, "Cassandra,Bonjour!");
      loadPostIfNotExists(transaction, NextId.postId, 3, "Casasndra,Ciao!");
      transaction.commit();
    } catch (TransactionException e) {
      logger.error("Loading initial data failed", e);
      abortTransaction(transaction);
      throw e;
    }
  }

  private void loadUserIfNotExists(
      DistributedTransaction transaction, int userId, String name, String password) throws CrudException {
    Optional<User> user = User.get(transaction, userId);
    if (!user.isPresent()) {
      User.put(transaction, userId, name, password);
      NextId.userId++;
    }
  }

  private void loadPostIfNotExists(
      DistributedTransaction transaction, int postId, int userId, String content)
      throws CrudException {
    Optional<Post> post = Post.get(transaction, postId);
    if (!post.isPresent()) {
      Post.put(transaction, postId, userId, content);
      NextId.postId++;
    }
  }


  /** createUser. It's a transaction that spans mysql and cassandra */
  @Override
  public void createUserOnCassandra(CreateUserOnCassandraRequest request, StreamObserver<CreateUserOnCassandraResponse> responseObserver) {
    //This function processing operations can be used in normal transactions
    //interface transactions.
    execOperationsAsCoordinator(
        "createUser",
        transaction -> {
          User.put(transaction, NextId.userId, request.getName(), request.getPassword());
          callCreateUserEndpoint(NextId.userId, request.getName(), request.getPassword(), transaction.getId());
          NextId.userId++;
          return CreateUserOnCassandraResponse.newBuilder().build();
        }, responseObserver);
  }

  @Override
  public void getUser(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
    String funcName = "getUser";
    //This function processing operations can be used in normal transactions
    //interface transactions.
    TransactionFunction<TransactionCrudOperable, GetUserResponse> operations =
    transaction -> {
      // Retrive user information from cassandra
      Optional<User> user = User.get(transaction, request.getUserId());

      if (!user.isPresent()) {
        throw Status.NOT_FOUND.withDescription("User not found").asRuntimeException();
      }

      // Reterun the customer information
      return GetUserResponse.newBuilder()
          .setUserId(user.get().userId)
          .setName(user.get().name)
          .setPassword(user.get().password)
          .build();
    };

    execOperations(funcName, operations, responseObserver);
  }

  @Override
  public void getAllUsers(GetAllUsersRequest request, StreamObserver<GetAllUsersResponse> responseObserver) {
    String funcName = "getAllUsers";
    //This function processing operations can be used in normal transactions
    //interface transactions.
    TransactionFunction<TransactionCrudOperable, GetAllUsersResponse> operations = transaction -> {
      // Get all users
      GetAllUsersResponse.Builder response = GetAllUsersResponse.newBuilder();
      for (int i = 1; i < NextId.userId; i++) {
        Optional<User> user = User.get(transaction, i);
        if (user.isPresent()) {
          response.addUsers(
            sample.rpc.User.newBuilder()
                  .setUserId(user.get().userId)
                  .setName(user.get().name)
                  .setPassword(user.get().password)
                  .build());
        }
      }
      return response.build();
    };
    execOperations(funcName, operations, responseObserver);
  }

  @Override
  public void createPost(CreatePostRequest request, StreamObserver<CreatePostResponse> responseObserver){
    String funcName = "createPost";
    //This function processing operations can be used in nomal transactions
    //interface transactions.
    TransactionFunction<TransactionCrudOperable, CreatePostResponse> operations = transaction -> {
      Post.put(transaction, NextId.postId, request.getUserId(), request.getContent());
      NextId.postId++;
      return CreatePostResponse.newBuilder().build();
    };
    execOperations(funcName, operations, responseObserver);
  }

  @Override
  public void getPost(GetPostRequest request, StreamObserver<GetPostResponse> responseObserver){
    String funcName = "getPost";
    //This function processing operations can be used in nomal transactions
    //interface transactions.
    TransactionFunction<TransactionCrudOperable, GetPostResponse> operations = transaction -> {
      Optional<Post> post = Post.get(transaction, request.getPostId());
      Optional<User> user = User.get(transaction, post.get().userId);
      if (!post.isPresent()) {
        throw Status.NOT_FOUND.withDescription("Post not found").asRuntimeException();
      }
      return GetPostResponse.newBuilder()
          .setPostId(post.get().postId)
          .setUserId(post.get().userId)
          .setName(user.get().name)
          .setContent(post.get().content)
          .build();
    };
    execOperations(funcName, operations, responseObserver);
  }

  @Override
  public void getAllPosts(GetAllPostsRequest request, StreamObserver<GetAllPostsResponse> responseObserver) {
    String funcName = "getAllPosts";
    //This function processing operations can be used in nomal transactions
    //interface transactions.
    TransactionFunction<TransactionCrudOperable, GetAllPostsResponse> operations = transaction -> {
      // Get all posts
      GetAllPostsResponse.Builder response =GetAllPostsResponse.newBuilder();
      for (int i = 1; i < NextId.postId; i++) {
        Optional<Post> post = Post.get(transaction, i);
        Optional<User> user = User.get(transaction, post.get().userId);
        if (post.isPresent()) {
          response.addPosts(
              sample.rpc.Post.newBuilder()
                  .setPostId(post.get().postId)
                  .setUserId(post.get().userId)
                  .setName(user.get().name)
                  .setContent(post.get().content)
                  .build());
        }
      }
      return response.build();
    };
    execOperations(funcName, operations, responseObserver);
  }

  private void rollbackTransaction(@Nullable TwoPhaseCommitTransaction transaction) {
    if (transaction == null) {
      return;
    }

    try {
      transaction.rollback();
    } catch (RollbackException ex) {
      logger.warn("Rollback failed", ex);
    }
    try {
      callRollbackEndpoint(transaction.getId());
    } catch (StatusRuntimeException ex) {
      logger.warn("Rollback failed", ex);
    }
  }

  private void callCreateUserEndpoint(int userId, String name, String password, String transactionId) {
    mysqlStub.createUserOnMysql(
        CreateUserOnMysqlRequest.newBuilder()
            .setUserId(userId)
            .setName(name)
            .setPassword(password)
            .setTransactionId(transactionId)
            .build());
  }

  private void callPrepareEndpoint(String transactionId) {
    mysqlStub.prepare(
        PrepareRequest.newBuilder().setTransactionId(transactionId).build());
  }

  private void callValidateEndpoint(String transactionId) {
    mysqlStub.validate(
        ValidateRequest.newBuilder().setTransactionId(transactionId).build());
  }

  private void callCommitEndpoint(String transactionId) {
    mysqlStub.commit(CommitRequest.newBuilder().setTransactionId(transactionId).build());
  }

  private void callRollbackEndpoint(String transactionId) {
    mysqlStub.rollback(
        RollbackRequest.newBuilder().setTransactionId(transactionId).build());
  }

  private void abortTransaction(@Nullable DistributedTransaction transaction) {
    if (transaction == null) {
      return;
    }
    try {
      transaction.abort();
    } catch (AbortException e) {
      logger.warn("Abort failed", e);
    }
  }

  private <T> void execOperationsAsCoordinator(String funcName,
      TransactionFunction<TwoPhaseCommitTransaction, T> operations,
      StreamObserver<T> responseObserver) {
    TwoPhaseCommitTransaction transaction = null;
    try {
      // Start a two-phase commit interface transaction
      transaction = twoPhaseCommitTransactionManager.start();

      // Execute operations
      T result = operations.apply(transaction);

      // Prepare the transaction
      transaction.prepare();
      callPrepareEndpoint(transaction.getId());

      // Validate the transaction. Depending on the concurrency control protocol, you need to call
      // validate(). Currently, you need to call it when you use the Consensus Commit transaction
      // manager and EXTRA_READ serializable strategy in SERIALIZABLE isolation level. In other
      // cases, validate() does nothing.
      transaction.validate();
      callValidateEndpoint(transaction.getId());

      // Commit the transaction. If any of services succeed in committing the transaction, you can
      // consider the transaction as committed.
      boolean committed = false;
      Exception exception = null;
      try {
        transaction.commit();
        committed = true;
      } catch (TransactionException e) {
        exception = e;
      }
      try {
        callCommitEndpoint(transaction.getId());
        committed = true;
      } catch (StatusRuntimeException e) {
        exception = e;
      }
      if (!committed) {
        throw exception;
      }

      // Return the response
      responseObserver.onNext(result);
      responseObserver.onCompleted();
    } catch (StatusRuntimeException e) {
      logger.error("{} failed", funcName, e);
      rollbackTransaction(transaction);
      responseObserver.onError(e);
    } catch (Exception e) {
      String message = funcName + " failed";
      logger.error(message, e);
      rollbackTransaction(transaction);
      responseObserver.onError(
          Status.INTERNAL.withDescription(message).withCause(e).asRuntimeException());
    }
  }

  private <T> void execOperations(String funcName,
      TransactionFunction<TransactionCrudOperable, T> operations, StreamObserver<T> responseObserver) {
    DistributedTransaction transaction = null;
    try {
      // Start a transaction
      transaction = transactionManager.start();

      // Execute operations
      T response = operations.apply(transaction);

      // Commit the transaction (even when the transaction is read-only, we need to commit)
      transaction.commit();

      // Return the response
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    } catch (StatusRuntimeException e) {
      logger.error("{} failed", funcName, e);
      abortTransaction(transaction);
      responseObserver.onError(e);
    } catch (Exception e) {
      String message = funcName + " failed";
      logger.error(message, e);
      abortTransaction(transaction);
      responseObserver.onError(
          Status.INTERNAL.withDescription(message).withCause(e).asRuntimeException());
    }
  }

  @Override
  public void close() {
    try {
      channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      logger.warn("Failed to shutdown the channel", e);
    }

    transactionManager.close();
    twoPhaseCommitTransactionManager.close();
  }
}
