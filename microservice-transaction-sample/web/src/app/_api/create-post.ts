import { $ } from "zx";
import { getUserId } from "./authentication-util";

export const createPost = async (
  message: string,
  serverId: number
): Promise<void> => {
  const userId = await getUserId();
  let commandName = "";
  switch (serverId) {
    case 1:
      commandName = "CreatePostOnMysql";
      break;
    case 2:
      commandName = "CreatePostOnCassandra";
  }
  const exec =
    await $`cd ..; ./gradlew :client:run --args='${commandName} ${userId} "${message}"'`;
  if (exec.exitCode !== 0) {
    throw new Error(exec.stderr);
  }
};
