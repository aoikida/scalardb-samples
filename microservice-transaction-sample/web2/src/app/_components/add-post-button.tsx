"use client";

import { FC } from "react";
// import { IconButton } from "@mui/material";
import AddIcon from "@mui/icons-material/Add";

type Props = {
  onClick: () => void;
};

export const AddPostButton: FC<Props> = ({ onClick }) => {
  // Implement the create post button
  return (
    <button
      aria-label="add"
      onClick={onClick}
      className="fixed bottom-6 h-16 w-16 hover:opacity-70 bg-sky-500 right-10 text-white p-4 rounded-full shadow-md"
    >
      <AddIcon />
    </button>
  );
};
