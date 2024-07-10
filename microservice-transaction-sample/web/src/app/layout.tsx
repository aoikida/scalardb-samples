import { Inter } from "next/font/google";
import "./globals.css";
import Head from "next/head";

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
      <div className="flex w-full">
        <header className="w-full bg-white shadow-md  text-black text-center py-4 text-2xl font-bold fixed top-0 z-10">
          Server A
        </header>
        <body className="flex w-full">
          <main className="flex-1 bg-slate-100">{children}</main>
        </body>
      </div>
    </html>
  );
}
