"use client";

import { useEffect, useState } from "react";
import { AddPostButton } from "./_components/add-post-button";
import { AddPostDialog } from "./_components/add-post-dialog";
import type { NextPage } from "next";
import { getAllPost } from "@/services/requests/get-all-post";
import { PostCard } from "./_components/post-card";
import { Post } from "./_models/post";

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
          const { post_id: postId, content, name } = post;
          return {
            id: postId,
            content,
            userName: name,
            serverName,
          };
        })
      );
      setPosts(posts);
    });
  }, [serverName, refreshPosts]);

  return (
    <>
      <AddPostDialog
        isOpen={isOpen}
        onClose={() => setIsOpen(false)}
        // TODO: ユーザーIDはログインユーザーのIDを取得する
        userId={1}
        server="サーバーA"
      />
      <div className="flex flex-col items-center justify-center mt-28 w-full -ml-16">
        {posts.map((post) => (
          <PostCard key={post.id} post={post} />
        ))}
      </div>
      <div className="absolute bottom-5 right-5">
        <AddPostButton onClick={() => setIsOpen(true)} />
      </div>
    </>
  );
};

export default Home;
