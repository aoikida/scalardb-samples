import { NextResponse } from "next/server";
import { getUser } from "../_api/getUser";

export const GET = async (request: Request) => {
  const response = await getUser(1);
  return NextResponse.json({ response });
};
