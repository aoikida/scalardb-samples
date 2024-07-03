"use server";

export const getUserId = async () => {
  // TODO: implement this function
  return 1;
};

export interface UserResponse {
  id: number;
  name: string;
  password: string;
}

export interface PostResponse {
  post_id: number;
  user_id: number;
  content: string;
}
