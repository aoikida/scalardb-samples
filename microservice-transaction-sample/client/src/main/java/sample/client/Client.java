package sample.client;
import sample.client.command.CreateUserCommand;
import sample.client.command.GetUserFromMysqlCommand;
import sample.client.command.GetUserFromCassandraCommand;
import sample.client.command.CreatePostOnMysqlCommand;
import sample.client.command.CreatePostOnCassandraCommand;
import sample.client.command.GetPostFromMysqlCommand;
import sample.client.command.GetPostFromCassandraCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
    name = "bin/client",
    description = "Sample application for Microservice Transaction",
    subcommands = {
      CreateUserCommand.class,
      GetUserFromMysqlCommand.class,
      GetUserFromCassandraCommand.class,
      CreatePostOnMysqlCommand.class,
      CreatePostOnCassandraCommand.class,
      GetPostFromMysqlCommand.class,
      GetPostFromCassandraCommand.class,
    })
public class Client implements Runnable {

  @Option(
      names = {"-h", "--help"},
      usageHelp = true,
      description = "Displays this help message and quits.",
      defaultValue = "true")
  private Boolean showHelp;

  @Override
  public void run() {
    if (showHelp) {
      CommandLine.usage(this, System.out);
    }
  }

  public static void main(String[] args) {
    new CommandLine(new Client()).execute(args);
  }
}
