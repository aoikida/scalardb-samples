package sample.command;

import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import sample.Sample;

@Command(name = "CreateNewUserAccount", description = "Create New User Acount")
public class CreateNewUserAccountCommand implements Callable<Integer> {

  @Parameters(index = "0", paramLabel = "USER_ID", description = "user ID")
  private int userId;

  @Parameters(index = "1", paramLabel = "NAME", description = "user name")
  private String name;

  @Parameters(index = "2", paramLabel = "PASSWORD", description = "password")
  private String password;

  @Override
  public Integer call() throws Exception {
    try (Sample sample = new Sample()) {
      sample.createNewUserAccount(userId, name, password);
    }
    return 0;
  }
}
