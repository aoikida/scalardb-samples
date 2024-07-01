import { z } from "zod";

import { PostSchema } from ".";

export type Post = z.infer<typeof PostSchema>;
