"use server";

import { $ } from "zx";
import { PostResponse } from "./authentication-util";
import { extractResponseFromStdout } from "./extract-response";

export const getAllPost = async (
  serverName: string
): Promise<{ posts: PostResponse[] }> => {
  let commandName = "";
  switch (serverName) {
    case "サーバー A":
      commandName = "GetAllPostsFromMysql";
      break;
    case "サーバー B":
      commandName = "GetAllPostsFromCassandra";
  }
  const exec = await $`cd ..; ./gradlew :client:run --args="${commandName}"`;
  return extractResponseFromStdout<{ posts: PostResponse[] }>(exec.stdout);
};
