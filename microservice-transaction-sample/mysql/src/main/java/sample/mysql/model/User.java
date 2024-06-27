package sample.mysql.model;

import com.scalar.db.api.Get;
import com.scalar.db.api.Put;
import com.scalar.db.api.TransactionCrudOperable;
import com.scalar.db.exception.transaction.CrudException;
import com.scalar.db.io.Key;
import java.util.Optional;

public class User {

  private static final String NAMESPACE = "mysql";
  private static final String TABLE = "users";
  private static final String USER_ID = "user_id";
  private static final String COL_NAME = "name";
  private static final String COL_PASSWORD = "password";

  public final int userId;
  public final String name;
  public final String password;

  public User(int userId, String name, String password) {
    this.userId = userId;
    this.name = name;
    this.password = password;
  }

  public static void put(TransactionCrudOperable transaction, int userId, String name, String password)
      throws CrudException {
    transaction.put(
        Put.newBuilder()
            .namespace(NAMESPACE)
            .table(TABLE)
            .partitionKey(Key.ofInt(USER_ID, userId))
            .textValue(COL_NAME, name)
            .textValue(COL_PASSWORD, password)
            .build());
  }

  public static Optional<User> get(TransactionCrudOperable transaction, int userId)
      throws CrudException {
    return transaction
        .get(
            Get.newBuilder()
                .namespace(NAMESPACE)
                .table(TABLE)
                .partitionKey(Key.ofInt(USER_ID, userId))
                .build())
        .map(r -> new User(r.getInt(USER_ID), r.getText(COL_NAME), r.getText(COL_PASSWORD)));
  }

}
