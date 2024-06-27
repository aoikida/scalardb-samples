import { NextResponse } from "next/server";
import { $ } from "zx";

export const GET = async (request: Request) => {
  const { searchParams } = new URL(request.url);
  const message = searchParams.get("message");
  const serverId = searchParams.get("server_id");
  console.log({ message, serverId });
  const exec =
    await $`cd ..; ./gradlew :client:run --args="GetUserFromCassandra 4"`;
  const response = exec.stdout;
  return NextResponse.json({ response });
};
