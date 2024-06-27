package sample.client.command;

import io.grpc.ManagedChannel;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import sample.rpc.MysqlGrpc;
import sample.rpc.GetUserRequest;
import sample.rpc.GetUserResponse;

@Command(name = "GetUserFromMysql", description = "Get user information")
public class GetUserFromMysqlCommand implements Callable<Integer> {

  @Parameters(index = "0", paramLabel = "USER_ID", description = "user id")
  private int userId;

  @Override
  public Integer call() {
    ManagedChannel channel = Utils.getMysqlChannel();
    try {
      MysqlGrpc.MysqlBlockingStub stub =
          MysqlGrpc.newBlockingStub(channel);
      GetUserResponse response =
          stub.getUser(
              GetUserRequest.newBuilder().setUserId(userId).build());
      Utils.printJsonString(response);
      return 0;
    } catch (Exception e) {
      e.printStackTrace();
      return 1;
    } finally {
      Utils.shutdownChannel(channel);
    }
  }
}
