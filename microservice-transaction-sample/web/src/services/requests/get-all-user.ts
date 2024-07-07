"use server";

import { $ } from "zx";
import { UserResponse } from "./type";
import { extractResponseFromStdout } from "./extract-response";

export const getAllUser = async (): Promise<UserResponse[]> => {
  const exec =
    await $`cd ..; ./gradlew :client:run --args="GetAllUsersFromCassandra"; cd -`;
  const response = exec.stdout;
  const user = extractResponseFromStdout<UserResponse[]>(response);
  return user;
};
