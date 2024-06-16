package sample;

import com.scalar.db.api.DistributedTransaction;
import com.scalar.db.api.DistributedTransactionManager;
import com.scalar.db.api.Get;
import com.scalar.db.api.Put;
import com.scalar.db.api.Result;
import com.scalar.db.api.Scan;
import com.scalar.db.exception.transaction.TransactionException;
import com.scalar.db.io.Key;
import com.scalar.db.service.TransactionFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//コマンドの実装がこのファイルで行われている
//そのコマンドを呼び出すためのインタフェースが../commandディレクトリ以下のファイル

public class Sample implements AutoCloseable {

  private final DistributedTransactionManager manager;

  public Sample() throws IOException {
    // Create a transaction manager object
    TransactionFactory factory = TransactionFactory.create("database.properties");
    manager = factory.getTransactionManager();
  }

  //初期データのロード
  public void loadInitialData() throws TransactionException {

    DistributedTransaction transaction = null;
    try {
      transaction = manager.start();
      transaction.put(
          Put.newBuilder()
              .namespace("user")
              .table("users")
              .partitionKey(Key.ofInt("user_id", 1))
              .textValue("name", "A")
              .textValue("password", "a")
              .build());
      transaction.put(
          Put.newBuilder()
              .namespace("user")
              .table("users")
              .partitionKey(Key.ofInt("user_id", 2))
              .textValue("name", "B")
              .textValue("password", "b")
              .build());
      transaction.put(
          Put.newBuilder()
              .namespace("user")
              .table("users")
              .partitionKey(Key.ofInt("user_id", 3))
              .textValue("name", "C")
              .textValue("password", "c")
              .build());
      transaction.put(
          Put.newBuilder()
              .namespace("post")
              .table("posts")
              .partitionKey(Key.ofInt("post_id", 1))
              .intValue("user_id", 1)
              .textValue("content", "a hello")
              .intValue("timestamp", 0)
              .build());
      transaction.put(
          Put.newBuilder()
              .namespace("post")
              .table("posts")
              .partitionKey(Key.ofInt("post_id", 2))
              .intValue("user_id", 2)
              .textValue("content", "b hello")
              .intValue("timestamp", 0)
              .build());
      transaction.put(
          Put.newBuilder()
              .namespace("post")
              .table("posts")
              .partitionKey(Key.ofInt("post_id", 3))
              .intValue("user_id", 3)
              .textValue("content", "c hello")
              .intValue("timestamp", 0)
              .build());
      transaction.commit();
    } catch (TransactionException e) {
      if (transaction != null) {
        transaction.abort();
      }
      throw e;
    }
  }



  //ユーザー登録
  public void createNewUserAccount(
      int userId,
      String name,
      String password)
      throws TransactionException {
      DistributedTransaction transaction = null;
      try {
        transaction = manager.start();
        transaction.put(
          Put.newBuilder()
              .namespace("user")
              .table("users")
              .partitionKey(Key.ofInt("user_id", userId))
              .textValue("name", name)
              .textValue("password", password)
              .build());
        transaction.commit();
      }catch (TransactionException e) {
        if (transaction != null) {
          transaction.abort();
        }
        throw e;
      }
  }

  //ユーザー情報の読み込み
  public String getUser(int userId) throws TransactionException {
    DistributedTransaction transaction = null;
    try {
      transaction = manager.start();
      Optional<Result> user =
          transaction.get(
              Get.newBuilder()
                  .namespace("user")
                  .table("users")
                  .partitionKey(Key.ofInt("user_id", userId))
                  .build());

      if (!user.isPresent()) {
        throw new RuntimeException("User not found");
      }
      transaction.commit();
      return String.format(
          "{User ID: %d, Name: %s, Password: %s}",
          userId, user.get().getText("name"), user.get().getText("password"));
    } catch (TransactionException e) {
      if (transaction != null) {
        transaction.abort();
      }
      throw e;
    }
  }

  //投稿
  public void createNewPost(
      int postId,
      int userId,
      String content,
      int timestamp)
      throws TransactionException {
      DistributedTransaction transaction = null;
      try {
        transaction = manager.start();
        transaction.put(
          Put.newBuilder()
              .namespace("post")
              .table("posts")
              .partitionKey(Key.ofInt("post_id", postId))
              .intValue("user_id", userId)
              .textValue("content", content)
              .intValue("timestamp", timestamp)
              .build());
        transaction.commit();
      }catch (TransactionException e) {
        if (transaction != null) {
          transaction.abort();
        }
        throw e;
      }
    }

  //投稿の読み込み
  public String getPost(int postId) throws TransactionException {
    DistributedTransaction transaction = null;
    try {
      transaction = manager.start();
      Optional<Result> post =
          transaction.get(
              Get.newBuilder()
                  .namespace("post")
                  .table("posts")
                  .partitionKey(Key.ofInt("post_id", postId))
                  .build());

      if (!post.isPresent()) {
        throw new RuntimeException("Post not found");
      }
      transaction.commit();
      return String.format(
          "{Post ID: %d, User ID: %d, Content: %s, Timestamp: %d}",
          postId, post.get().getInt("user_id"), post.get().getText("content"), post.get().getInt("timestamp"));
    } catch (TransactionException e) {
      if (transaction != null) {
        transaction.abort();
      }
      throw e;
    }
  }



  @Override
  public void close() {
    manager.close();
  }
}
