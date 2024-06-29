package sample.client.command;

import io.grpc.ManagedChannel;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import sample.rpc.CassandraGrpc;
import sample.rpc.GetAllPostsRequest;
import sample.rpc.GetAllPostsResponse;
import java.util.Iterator;


@Command(name = "GetAllPostsFromCassandra", description = "Get post information from Cassandra")
public class GetAllPostsFromCassandraCommand implements Callable<Integer> {

  @Override
  public Integer call() {
    ManagedChannel channel = Utils.getCassandraChannel();
    try {
      CassandraGrpc.CassandraBlockingStub stub = CassandraGrpc.newBlockingStub(channel);
      Iterator<GetAllPostsResponse> response =
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
