import { z } from "zod";

export const PostSchema = z.object({
  userId: z.number(),
  server: z.string().min(1),
  message: z.string().min(1, "message is required.").max(100),
});
