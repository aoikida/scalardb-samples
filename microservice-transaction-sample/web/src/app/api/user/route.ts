import { getAllUser } from "@/services/requests/get-all-user";
import { NextResponse } from "next/server";

export const GET = async (request: Request) => {
  const response = await getAllUser();
  return NextResponse.json({ response });
};
