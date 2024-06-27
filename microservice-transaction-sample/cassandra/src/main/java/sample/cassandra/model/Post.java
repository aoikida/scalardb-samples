package sample.cassandra.model;

import com.scalar.db.api.Put;
import com.scalar.db.api.Get;
import com.scalar.db.api.TransactionCrudOperable;
import com.scalar.db.exception.transaction.CrudException;
import com.scalar.db.io.Key;
import java.util.Optional;

public class Post {

  private static final String NAMESPACE = "cassandra";
  private static final String TABLE = "posts";
  private static final String POST_ID = "post_id";
  private static final String USER_ID = "user_id";
  private static final String COL_CONTENT = "content";

  public final int postId;
  public final int userId;
  public final String content;

  public Post(int postId, int userId, String content) {
    this.postId = postId;
    this.userId = userId;
    this.content = content;
  }

  public static void put(TransactionCrudOperable transaction, int postId, int userId, String content)
      throws CrudException {
    transaction.put(
        Put.newBuilder()
            .namespace(NAMESPACE)
            .table(TABLE)
            .partitionKey(Key.ofInt(POST_ID, postId))
            .intValue(USER_ID, userId)
            .textValue(COL_CONTENT, content)
            .build());
  }

  public static Optional<Post> get(TransactionCrudOperable transaction, int postId) throws CrudException {
    return transaction
        .get(
            Get.newBuilder()
                .namespace(NAMESPACE)
                .table(TABLE)
                .partitionKey(Key.ofInt(POST_ID, postId))
                .build())
        .map(r -> new Post(r.getInt(POST_ID), r.getInt(USER_ID), r.getText(COL_CONTENT)));
  }

}
