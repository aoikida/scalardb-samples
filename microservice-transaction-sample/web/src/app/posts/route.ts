import { getAllPost } from "@/services/requests/get-all-post";
import { NextResponse } from "next/server";

export const GET = async (request: Request) => {
  const response = await getAllPost("サーバー A");
  return NextResponse.json({ response });
};
