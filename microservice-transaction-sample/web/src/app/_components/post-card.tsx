import { Post } from "../_models/post";

export const PostCard = (props: { post: Post }) => {
  const { userName, content } = props.post;

  return (
    <div className="bg-white p-4 rounded-md shadow-md w-1/2 mb-4">
      <div className="font-bold">{userName}</div>
      <div className="mt-2">{content}</div>
    </div>
  );
};
