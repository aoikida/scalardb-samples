import type { NextPage } from "next";
import Head from "next/head";

const Home: NextPage = () => {
  return (
    <div className="min-h-screen bg-green-400 flex flex-col items-center justify-center">
      <Head>
        <title>サーバー A</title>
      </Head>
      <header className="w-full bg-green-500 text-white text-center py-4 text-2xl font-bold">
        サーバー A
      </header>
      <main className="flex flex-col items-center justify-center mt-8 w-full">
        <div className="bg-white p-4 rounded-md shadow-md w-1/2 mb-4">
          <div className="font-bold">山田太郎</div>
          <div className="mt-2">
            新しいカフェを見つけました。コーヒーが美味しくて、店内も落ち着いた雰囲気。ここで勉強するのが楽しみです！☕📚
            #カフェ巡り #新しいお気に入り
          </div>
        </div>
        <div className="bg-white p-4 rounded-md shadow-md w-1/2">
          <div className="font-bold">山田太郎</div>
          <div className="mt-2">
            新しいカフェを見つけました。コーヒーが美味しくて、店内も落ち着いた雰囲気。ここで勉強するのが楽しみです！☕📚
            #カフェ巡り #新しいお気に入り
          </div>
        </div>
      </main>
      <button className="fixed bottom-4 right-4 bg-green-500 text-white p-4 rounded-full shadow-md">
        +
      </button>
    </div>
  );
};

export default Home;
