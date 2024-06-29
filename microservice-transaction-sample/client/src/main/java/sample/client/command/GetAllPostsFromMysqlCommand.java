package sample.client.command;

import io.grpc.ManagedChannel;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import sample.rpc.MysqlGrpc;
import sample.rpc.GetAllPostsRequest;
import sample.rpc.GetAllPostsResponse;
import java.util.Iterator;


@Command(name = "GetAllPostsFromMysql", description = "Get post information from Mysql")
public class GetAllPostsFromMysqlCommand implements Callable<Integer> {

  @Override
  public Integer call() {
    ManagedChannel channel = Utils.getMysqlChannel();
    try {
      MysqlGrpc.MysqlBlockingStub stub = MysqlGrpc.newBlockingStub(channel);
      Iterator<sample.rpc.GetAllPostsResponse> response =
          stub.getAllPosts(GetAllPostsRequest.newBuilder().build());
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
