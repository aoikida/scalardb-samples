import { $ } from "zx";
import { UserResponse } from "./authenticationUtil";
import { extractResponseFromStdout } from "./extractResponse";

export const getUser = async (userId: number): Promise<UserResponse> => {
  const exec =
    await $`cd ..; ./gradlew :client:run --args="GetUserFromCassandra ${userId}"; cd -`;
  const response = exec.stdout;
  const user = extractResponseFromStdout<UserResponse>(
    response
  ) satisfies UserResponse;
  return user;
};
