"use client";

import { IconButton } from "@mui/material";
import AddIcon from "@mui/icons-material/Add";

export const AddPostButton = () => {
  // Implement the create post button
  return (
    <IconButton
      color="primary"
      aria-label="add"
      onClick={onClick}
      className="fixed bottom-4 right-4 bg-green-500 text-white p-4 rounded-full shadow-md"
    >
      <AddIcon />
    </IconButton>
  );
};

const onClick = () => {};
