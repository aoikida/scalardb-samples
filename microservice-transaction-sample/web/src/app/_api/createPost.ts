import { $ } from "zx";

const createPost = async (message: string, serverId: number) => {
  const userId = await getUserId();
  switch (serverId) {
    case 1:
      const postId = 1;
      const exec1 =
        await $`cd ..; ./gradlew :client:run --args="CreatePostOnMysql ${postId} ${userId} ${message}"`;
      break;
    case 2:
      const exec2 =
        await $`cd ..; ./gradlew :client:run --args="CreatePost ${message}"`;
      break;
  }
  const exec =
    await $`cd ..; ./gradlew :client:run --args="GetUserFromCassandra 4"`;
};
