package sample.client.command;

import io.grpc.ManagedChannel;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import sample.rpc.CassandraGrpc;
import sample.rpc.CreateUserOnCassandraRequest;
import sample.rpc.CreateUserOnCassandraResponse;

@Command(name = "CreateUser", description = "Create user on MySQL and Cassandra")

//分散トランザクション
public class CreateUserCommand implements Callable<Integer> {

  @Parameters(index = "0", paramLabel = "USER_ID", description = "user id")
  private int userId;

  @Parameters(index = "1", paramLabel = "NAME", description = "name")
  private String name;

  @Parameters(index = "2", paramLabel = "PASSWORD", description = "password")
  private String password;

  @Override
  public Integer call() {
    ManagedChannel channel = Utils.getCassandraChannel();
    try {
      CassandraGrpc.CassandraBlockingStub stub = CassandraGrpc.newBlockingStub(channel);
      System.out.println("CreateUserCommand.call() userId=" + userId + " name=" + name + " password=" + password + "channel=" + channel);
      CreateUserOnCassandraResponse response  = stub.createUserOnCassandra(
          CreateUserOnCassandraRequest.newBuilder()
              .setUserId(userId)
              .setName(name)
              .setPassword(password)
              .build());

      Utils.printJsonString(response);
      return 0;
    } catch (Exception e) {
      System.err.println("Exception occurred: " + e.getMessage());
      e.printStackTrace();
      return 1;
    } finally {
      Utils.shutdownChannel(channel);
    }
  }
}
