package sample.client.command;

import io.grpc.ManagedChannel;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import sample.rpc.MysqlGrpc;
import sample.rpc.GetAllUsersRequest;
import sample.rpc.GetAllUsersResponse;
import java.util.Iterator;

@Command(name = "GetAllUsersFromMysql", description = "Get all users information")
public class GetAllUsersFromMysqlCommand implements Callable<Integer> {


  @Override
  public Integer call() {
    ManagedChannel channel = Utils.getMysqlChannel();
    try {
      MysqlGrpc.MysqlBlockingStub stub =
          MysqlGrpc.newBlockingStub(channel);
      Iterator<GetAllUsersResponse> response =
          stub.getAllUsers(
              GetAllUsersRequest.newBuilder().build());
      while (response.hasNext()) {
        Utils.printJsonString(response.next());
      }
      return 0;
    } catch (Exception e) {
      e.printStackTrace();
      return 1;
    } finally {
      Utils.shutdownChannel(channel);
    }
  }
}
