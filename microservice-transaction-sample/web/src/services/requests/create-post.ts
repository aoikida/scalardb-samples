"use server";

import { $ } from "zx";
import { getUserId } from "./authentication-util";

export const createPost = async (
  userId: number,
  message: string,
  serverName: string
): Promise<void> => {
  let commandName = "";
  switch (serverName) {
    case "サーバーA":
      commandName = "CreatePostOnMysql";
      break;
    case "サーバーB":
      commandName = "CreatePostOnCassandra";
  }
  message = message.replace(/ /g, "_");
  const exec =
    await $`cd ..; ./gradlew :client:run --args="${commandName} ${userId} ${message}"`;
  if (exec.exitCode !== 0) {
    throw new Error(exec.stderr);
  }
};
