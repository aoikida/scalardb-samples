"use client";

import type { NextPage } from "next";
import Head from "next/head";
import { AddPostButton } from "./_components/add-post-button";
import { useEffect, useState } from "react";
import { AddPostDialog } from "./_components/add-post-dialog";
import { Post } from "./_models/post";
import { PostCard } from "./_components/post-card";
import { getAllPost } from "@/services/requests/get-all-post";

const Home: NextPage = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [posts, setPosts] = useState<Post[]>([]);
  const [serverName, setServerName] = useState("サーバーA");
  const [refreshPosts, setRefreshPosts] = useState<Date>();

  useEffect(() => {
    new Promise(async () => {
      console.log("fetching posts");
      const response = await getAllPost(serverName);

      const posts = await Promise.all(
        response.posts.map(async (post) => {
          const {
            post_id: postId,
            content,
            user_id: userId,
            name: userName,
          } = post;
          return {
            id: postId,
            content,
            userName,
            serverName,
          };
        })
      );
      setPosts(posts);
    });
  }, [serverName, refreshPosts]);

  return (
    <div className="min-h-screen bg-green-400 flex flex-col items-center">
      {/* TODO: サーバー名は動的に変更する */}
      <AddPostDialog
        onClose={() => setIsOpen(false)}
        // TODO: ユーザーIDはログインユーザーのIDを取得する
        userId={1}
        server="サーバーA"
        isOpen={isOpen}
      />
      <Head>
        <title>投稿一覧</title>
      </Head>
      <header className="w-full bg-green-500 text-white text-center py-4 text-2xl font-bold fixed top-0">
        サーバーA
      </header>
      <main className="flex flex-col items-center justify-center mt-20 w-full">
        {posts.map((post) => (
          <PostCard key={post.id} post={post}></PostCard>
        ))}
      </main>
      <AddPostButton onClick={() => setIsOpen(true)} />
    </div>
  );
};

export default Home;
