"use client";

import { Layout } from "../layouts/page";
import Head from "next/head";
import { useEffect, useState } from "react";
import { AddPostButton } from "./_components/add-post-button";
import { AddPostDialog } from "./_components/add-post-dialog";
import type { NextPage } from "next";
import { getAllPost } from "@/services/requests/get-all-post";
import { PostCard } from "./_components/post-card";
import { Post } from "./_models/post";
import { useServerName } from "./context/server";

const Home: NextPage = () => {
  const [isOpen, setIsOpen] = useState(false);
  const [posts, setPosts] = useState<Post[]>([]);
  const { server, setServer } = useServerName();
  const [refreshPosts, setRefreshPosts] = useState<Date>();

  useEffect(() => {
    new Promise(async () => {
      console.log(`fetching posts of ${server}`);
      const response = await getAllPost(server);

      const posts = await Promise.all(
        response.posts.reverse().map(async (post) => {
          const { post_id: postId, content, name } = post;
          return {
            id: postId,
            content,
            userName: name,
            serverName: server,
          };
        })
      );
      setPosts(posts);
    });
  }, [server, refreshPosts]);

  return (
    <Layout>
      <AddPostDialog
        isOpen={isOpen}
        onClose={() => {
          setRefreshPosts(new Date());
          setIsOpen(false);
        }}
        // TODO: ユーザーIDはログインユーザーのIDを取得する
        userId={1}
        server={server}
      />
      <Head>
        <title>投稿一覧</title>
      </Head>
      <header className="w-full bg-green-500 text-white text-center py-4 text-2xl font-bold fixed top-0">
        Server A
      </header>
      <main className="flex flex-col items-center justify-center mt-20 w-full">
        {posts.map((post) => (
          <PostCard key={post.id} post={post}></PostCard>
        ))}
      </main>
      <AddPostButton onClick={() => setIsOpen(true)} />
    </Layout>
  );
};

export default Home;
