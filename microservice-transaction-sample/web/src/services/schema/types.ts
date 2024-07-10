import { z } from "zod";

import { PostSchema } from ".";

// ポストを作成するために必要なデータの型
export type AddPostInput = z.infer<typeof PostSchema>;
