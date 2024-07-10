"use client";

import { useState } from "react";
import { AddPostButton } from "./_components/add-post-button";
import { AddPostDialog } from "./_components/add-post-dialog";
import type { NextPage } from "next";
import { Layout } from "../layouts/page";

const Home: NextPage = () => {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <Layout>
      <AddPostDialog
        isOpen={isOpen}
        onClose={() => setIsOpen(false)}
        server="サーバーA"
      />
      <div className="flex flex-col items-center justify-center mt-28 w-full -ml-16">
        <div className="bg-gradient-to-br from-slate-50 to-[#bfdbfe] p-4 rounded-md shadow-md w-1/2 mb-4">
          <div className="font-bold">山田太郎</div>
          <div className="mt-2">
            新しいカフェを見つけました。コーヒーが美味しくて、店内も落ち着いた雰囲気。ここで勉強するのが楽しみです！☕📚
            #カフェ巡り #新しいお気に入り
          </div>
        </div>
        <div className="bg-gradient-to-br from-slate-50 to-[#bfdbfe] p-4 rounded-md shadow-md w-1/2 mb-4">
          <div className="font-bold">山田太郎</div>
          <div className="mt-2">
            新しいカフェを見つけました。コーヒーが美味しくて、店内も落ち着いた雰囲気。ここで勉強するのが楽しみです！☕📚
            #カフェ巡り #新しいお気に入り
          </div>
        </div>
      </div>
      <div className="absolute bottom-5 right-5">
        <AddPostButton onClick={() => setIsOpen(true)} />
      </div>
    </Layout>
  );
};

export default Home;
