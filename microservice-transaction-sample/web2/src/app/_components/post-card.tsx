import { Post } from "../_models/post";

export const PostCard = (props: { post: Post }) => {
  const { userName, content } = props.post;

  let decodedContent;
  if (content.startsWith("$")) {
    decodedContent = content.substring(1);
  }

  decodedContent = content.replaceAll("_", " ").split(".").join(".\n");

  return (
    <div className="bg-gradient-to-br from-slate-50 to-[#bfdbfe] p-4 rounded-md shadow-md w-1/2 mb-4">
      <div className="font-bold">{userName}</div>
      <div className="mt-2">{decodedContent}</div>
    </div>
  );
};
