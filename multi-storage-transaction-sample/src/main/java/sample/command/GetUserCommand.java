package sample.command;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import sample.Sample;

@Command(name = "GetUser", description = "Get user information by post ID")
public class GetUserCommand implements Callable<Integer> {

  @Parameters(index = "0", paramLabel = "USER_ID", description = "user ID")
  private int userId;

  @Override
  public Integer call() throws Exception {
    try (Sample sample = new Sample()) {
      System.out.println(sample.getUser(userId));
    }
    return 0;
  }
}
