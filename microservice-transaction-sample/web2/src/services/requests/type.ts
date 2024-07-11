"use server";

export interface UserResponse {
  id: number;
  name: string;
  password: string;
}

export interface PostResponse {
  post_id: number;
  user_id: number;
  name: string;
  content: string;
}
