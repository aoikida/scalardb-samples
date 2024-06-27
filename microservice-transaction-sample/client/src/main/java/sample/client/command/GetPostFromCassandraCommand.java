package sample.client.command;

import io.grpc.ManagedChannel;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import sample.rpc.CassandraGrpc;
import sample.rpc.GetPostRequest;
import sample.rpc.GetPostResponse;


@Command(name = "GetPostFromCassandra", description = "Get post information from Cassandra")
public class GetPostFromCassandraCommand implements Callable<Integer> {

@Parameters(index = "0", paramLabel = "POST_ID", description = "post id")
  private int postId;


  @Override
  public Integer call() {
    ManagedChannel channel = Utils.getCassandraChannel();
    try {
      CassandraGrpc.CassandraBlockingStub stub = CassandraGrpc.newBlockingStub(channel);
      GetPostResponse response =
          stub.getPost(GetPostRequest.newBuilder().setPostId(postId).build());
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
