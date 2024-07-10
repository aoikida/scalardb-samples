import { Inter } from "next/font/google";
import "./globals.css";
import Head from "next/head";
import Image from "next/image";

const inter = Inter({ subsets: ["latin"] });

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <Head>
        <title>投稿一覧</title>
      </Head>
      <body className="flex w-full">
        <header className="w-full px-10 justify-end bg-white shadow-md py-4 fixed top-0 z-10 text-black text-center text-2xl font-bold">
          Server A
          <button className="hover:opacity-70 absolute top-4 right-10">
            <Image
              src="Icon/reload.svg"
              alt="reload"
              width={24}
              height={24}
              className="inline-block"
            />
          </button>
        </header>
        <main className="flex-1 bg-slate-100">{children}</main>
      </body>
    </html>
  );
}
