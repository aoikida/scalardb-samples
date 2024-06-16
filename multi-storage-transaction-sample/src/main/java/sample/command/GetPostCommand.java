package sample.command;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import sample.Sample;

@Command(name = "GetPost", description = "Get post information by post ID")
public class GetPostCommand implements Callable<Integer> {

  @Parameters(index = "0", paramLabel = "POST_ID", description = "post ID")
  private int postId;

  @Override
  public Integer call() throws Exception {
    try (Sample sample = new Sample()) {
      System.out.println(sample.getPost(postId));
    }
    return 0;
  }
}
