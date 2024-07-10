"use server";

import { $ } from "zx";
import { UserResponse } from "./type";
import { extractResponseFromStdout } from "./extract-response";

export const getUser = async (userId: number): Promise<UserResponse> => {
  const exec =
    await $`cd ..; ./gradlew :client:run --args="GetUserFromCassandra ${userId}"; cd -`;
  const response = exec.stdout;
  const user = extractResponseFromStdout<UserResponse>(response);
  return user;
};
