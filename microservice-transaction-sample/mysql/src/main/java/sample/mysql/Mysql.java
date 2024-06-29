package sample.mysql;

import com.google.protobuf.Empty;
import com.scalar.db.api.DistributedTransaction;
import com.scalar.db.api.DistributedTransactionManager;
import com.scalar.db.api.TransactionCrudOperable;
import com.scalar.db.api.TwoPhaseCommitTransaction;
import com.scalar.db.api.TwoPhaseCommitTransactionManager;
import com.scalar.db.exception.transaction.AbortException;
import com.scalar.db.exception.transaction.CrudException;
import com.scalar.db.exception.transaction.TransactionException;
import com.scalar.db.exception.transaction.TransactionNotFoundException;
import com.scalar.db.service.TransactionFactory;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.mysql.model.User;
import sample.mysql.model.Post;
import sample.rpc.CommitRequest;
import sample.rpc.MysqlGrpc;
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

public class Mysql extends MysqlGrpc.MysqlImplBase implements Closeable {
  private static final Logger logger = LoggerFactory.getLogger(Mysql.class);

  // For normal transactions
  private final DistributedTransactionManager transactionManager;

  // For two-phase commit transactions
  private final TwoPhaseCommitTransactionManager twoPhaseCommitTransactionManager;

  private interface TransactionFunction<T, R> {
    R apply(T t) throws TransactionException;
  }

  public Mysql(String configFile) throws TransactionException, IOException{
    // Initialize the transaction managers
    TransactionFactory factory = TransactionFactory.create(configFile);
    if (factory == null) {
      throw new IOException("Failed to create a transaction factory");
    }
    transactionManager = factory.getTransactionManager();
    twoPhaseCommitTransactionManager = factory.getTwoPhaseCommitTransactionManager();

    loadInitialData();
  }


  private void loadInitialData() throws TransactionException {
    DistributedTransaction transaction = null;
    try {
      transaction = transactionManager.start();
      loadUserIfNotExists(transaction, NextId.userId, "Andy", "passwordandy");
      loadUserIfNotExists(transaction, NextId.userId, "Bill", "passwordbill");
      loadUserIfNotExists(transaction, NextId.userId, "Carlie", "passwordcarlie");
      loadPostIfNotExists(transaction, NextId.postId, 1, "MySQL,Aloha!");
      loadPostIfNotExists(transaction, NextId.postId, 2, "MySQL,Bonjour!");
      loadPostIfNotExists(transaction, NextId.postId, 3, "MySQL,Ciao!");
      transaction.commit();
    } catch (TransactionException e) {
      logger.error("Loading initial data failed", e);
      abortTransaction(transaction);
      throw e;
    }
  }

  private void loadUserIfNotExists(
      DistributedTransaction transaction, int userId, String name, String password) 
      throws CrudException {
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

  //create user which spans mysql and cassandra
  @Override
  public void createUserOnMysql (CreateUserOnMysqlRequest request, StreamObserver<Empty> responseObserver) {
    execOperationsAsParticipant("CreateUserOnMysql", request.getTransactionId(),
    transaction -> {
      User.put(transaction, NextId.userId, request.getName(), request.getPassword());
      NextId.userId++;

      return Empty.getDefaultInstance();
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
      if (!post.isPresent()) {
        throw Status.NOT_FOUND.withDescription("Post not found").asRuntimeException();
      }
      return GetPostResponse.newBuilder()
          .setPostId(post.get().postId)
          .setUserId(post.get().userId)
          .setContent(post.get().content)
          .build();
    };
    execOperations(funcName, operations, responseObserver);
  }

  @Override
  public void getAllPosts(GetAllPostsRequest request, io.grpc.stub.StreamObserver<GetAllPostsResponse> responseObserver) {
    String funcName = "getAllPosts";
    //This function processing operations can be used in nomal transactions
    //interface transactions.
    TransactionFunction<TransactionCrudOperable, GetAllPostsResponse> operations = transaction -> {
      // Get all posts
      GetAllPostsResponse.Builder response = GetAllPostsResponse.newBuilder();
      for (int i = 1; i < NextId.postId; i++) {
        Optional<Post> post = Post.get(transaction, i);
        if (post.isPresent()) {
          response.addPosts(
            sample.rpc.Post.newBuilder()
                  .setPostId(post.get().postId)
                  .setUserId(post.get().userId)
                  .setContent(post.get().content)
                  .build());
        }
      }
      return response.build();
    };
    execOperations(funcName, operations, responseObserver);
  }

  @Override
  public void prepare(PrepareRequest request, StreamObserver<Empty> responseObserver) {
    try {
      // Resume the transaction
      TwoPhaseCommitTransaction transaction =
          twoPhaseCommitTransactionManager.resume(request.getTransactionId());

      // Prepare the transaction
      transaction.prepare();

      responseObserver.onNext(Empty.getDefaultInstance());
      responseObserver.onCompleted();
    } catch (Exception e) {
      String message = "Prepare failed";
      logger.error(message, e);
      responseObserver.onError(
          Status.INTERNAL.withDescription(message).withCause(e).asRuntimeException());
    }
  }

  @Override
  public void validate(ValidateRequest request, StreamObserver<Empty> responseObserver) {
    try {
      // Resume the transaction
      TwoPhaseCommitTransaction transaction =
          twoPhaseCommitTransactionManager.resume(request.getTransactionId());

      // Validate the transaction
      transaction.validate();

      responseObserver.onNext(Empty.getDefaultInstance());
      responseObserver.onCompleted();
    } catch (Exception e) {
      String message = "Validate failed";
      logger.error(message, e);
      responseObserver.onError(
          Status.INTERNAL.withDescription(message).withCause(e).asRuntimeException());
    }
  }

  @Override
  public void commit(CommitRequest request, StreamObserver<Empty> responseObserver) {
    try {
      // Resume the transaction
      TwoPhaseCommitTransaction transaction =
          twoPhaseCommitTransactionManager.resume(request.getTransactionId());

      // Commit the transaction
      transaction.commit();

      responseObserver.onNext(Empty.getDefaultInstance());
      responseObserver.onCompleted();
    } catch (Exception e) {
      String message = "Commit failed";
      logger.error(message, e);
      responseObserver.onError(
          Status.INTERNAL.withDescription(message).withCause(e).asRuntimeException());
    }
  }

  @Override
  public void rollback(RollbackRequest request, StreamObserver<Empty> responseObserver) {
    try {
      // Resume the transaction
      TwoPhaseCommitTransaction transaction =
          twoPhaseCommitTransactionManager.resume(request.getTransactionId());

      // Rollback the transaction
      transaction.rollback();

      responseObserver.onNext(Empty.getDefaultInstance());
      responseObserver.onCompleted();
    } catch (TransactionNotFoundException e) {
      // If the transaction is not found, ignore it
      responseObserver.onNext(Empty.getDefaultInstance());
      responseObserver.onCompleted();
    } catch (Exception e) {
      String message = "Rollback failed";
      logger.error(message, e);
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

  private <T> void execOperationsAsParticipant(String funcName, String transactionId,
      TransactionFunction<TransactionCrudOperable, T> operations,
      StreamObserver<T> responseObserver) {
    try {
      // Join the transaction
      TwoPhaseCommitTransaction transaction = twoPhaseCommitTransactionManager.join(transactionId);

      // Execute operations
      T response = operations.apply(transaction);

      // Return the response
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    } catch (StatusRuntimeException e) {
      logger.error("{} failed", funcName, e);
      responseObserver.onError(e);
    } catch (Exception e) {
      String message = funcName + " failed";
      logger.error(message, e);
      responseObserver.onError(
          Status.INTERNAL.withDescription(message).withCause(e).asRuntimeException());
    }
  }

  @Override
  public void close() {
    transactionManager.close();
    twoPhaseCommitTransactionManager.close();
  }
}
