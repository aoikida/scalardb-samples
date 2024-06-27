package sample.client.command;

import io.grpc.ManagedChannel;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import sample.rpc.CassandraGrpc;
import sample.rpc.CreatePostRequest;
import sample.rpc.CreatePostResponse;

@Command(name = "CreatePostOnCassandra", description = "Create post")

public class CreatePostOnCassandraCommand implements Callable<Integer> {

  @Parameters(index = "0", paramLabel = "POST_ID", description = "post id")
  private int postId;

  @Parameters(index = "1", paramLabel = "USER_ID", description = "user id")
  private int userId;

  @Parameters(index = "2", paramLabel = "CONTENT", description = "content")
  private String content;

  @Override
  public Integer call() {
    ManagedChannel channel = Utils.getCassandraChannel();
    try {
      CassandraGrpc.CassandraBlockingStub stub = CassandraGrpc.newBlockingStub(channel);
      System.out.println("CreatePostOnCassandraCommand.call() postId=" + postId + " userId=" + userId + " content=" + content +"channel=" + channel);
      CreatePostResponse response = stub.createPost(
          CreatePostRequest.newBuilder()
              .setPostId(postId)
              .setUserId(userId)
              .setContent(content)
              .build());
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