import { NextApiRequest, NextApiResponse } from "next";
import { $ } from "zx";

export default async function handler(
  req: NextApiRequest,
  res: NextApiResponse
) {
  // TODO: 厳密ではないが今回はこの実装にする（サーバーAの場合はMySQL、サーバーBの場合はCassandraに投稿する）
  try {
    const { userId, message, server } = req.body;

    if (server === "サーバーA") {
      // コマンドを構築
      const command = `../../../../../../gradlew :client:run --args="CreatePostOnMysql ${userId} ${message.replace(
        / /g,
        ","
      )} "`;

      // zxを使ってコマンドを実行
      await $`${command}`;
    } else if (server === "サーバーB") {
      // コマンドを構築
      const command = `../../../../../../gradlew :client:run --args="CreatePostOnCassandra ${userId} ${message.replace(
        / /g,
        ","
      )} "`;

      // zxを使ってコマンドを実行
      await $`${command}`;
    }

    res
      .status(200)
      .json({ status: "Success", message: "Post created successfully." });
  } catch (error) {
    console.error(error);
    res
      .status(500)
      .json({ status: "Error", message: "Failed to create post." });
  }
}
