"use server";

import { $ } from "zx";

export const createPost = async (
  userId: number,
  message: string,
  serverName: string
): Promise<void> => {
  let commandName = "";
  switch (serverName) {
    case "Server A":
      commandName = "CreatePostOnMysql";
      break;
    case "Server B":
      commandName = "CreatePostOnCassandra";
  }
  message = message.replace(/ /g, "_");
  const exec =
    await $`cd ..; ./gradlew :client:run --args="${commandName} ${userId} ${message}"`;
  if (exec.exitCode !== 0) {
    throw new Error(exec.stderr);
  }
};
