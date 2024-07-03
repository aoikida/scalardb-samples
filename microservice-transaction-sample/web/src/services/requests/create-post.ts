"use server";

import { $ } from "zx";
import { getUserId } from "./authentication-util";

export const createPost = async (
  message: string,
  serverName: string
): Promise<void> => {
  const userId = await getUserId();
  let commandName = "";
  switch (serverName) {
    case "サーバー A":
      commandName = "CreatePostOnMysql";
      break;
    case "サーバー B":
      commandName = "CreatePostOnCassandra";
  }

  const exec =
    await $`cd ..; ./gradlew :client:run --args=\"${commandName} ${userId} ${message}\"`;
  if (exec.exitCode !== 0) {
    throw new Error(exec.stderr);
  }
};
