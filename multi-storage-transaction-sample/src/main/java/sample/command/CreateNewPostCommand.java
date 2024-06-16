package sample.command;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import sample.Sample;

@Command(name = "CreateNewPost", description = "Create New Post")
public class CreateNewPostCommand implements Callable<Integer> {

  @Parameters(index = "0", paramLabel = "POST_ID", description = "post ID")
  private int postId;

  @Parameters(index = "1", paramLabel = "USER_ID", description = "user ID")
  private int userId;

  @Parameters(index = "2", paramLabel = "content", description = "post content")
  private String content;

  @Parameters(index = "3", paramLabel = "timestamp", description = "timestamp")
  private int timestamp;


  @Override
  public Integer call() throws Exception {
    try (Sample sample = new Sample()) {
      sample.createNewPost(postId, userId, content, timestamp);
    }
    return 0;
  }
}
