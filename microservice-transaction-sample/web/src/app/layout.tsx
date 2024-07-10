"use client";
import { Inter } from "next/font/google";
import "./globals.css";
import Head from "next/head";
import Image from "next/image";
import { ServerProvider, useServerName } from "./context/server";

const inter = Inter({ subsets: ["latin"] });

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <Head>
        <title>Timeline</title>
      </Head>
      <body className="flex w-full">
        <ServerProvider>
          <Header></Header>
          <Body>{children}</Body>
        </ServerProvider>
      </body>
    </html>
  );
}

const Body = ({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) => {
  return <main className="flex-1 bg-slate-100">{children}</main>;
};

const Header = () => {
  const { server } = useServerName();
  return (
    <header className="w-full px-10 justify-end bg-white shadow-md py-4 fixed top-0 z-10 text-black text-center text-2xl font-bold">
      {server}
    </header>
  );
};
