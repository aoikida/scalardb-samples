"use client";

import { FC } from "react";
import { IconButton } from "@mui/material";
import AddIcon from "@mui/icons-material/Add";

type Props = {
  onClick: () => void;
};

export const AddPostButton: FC<Props> = ({ onClick }) => {
  // Implement the create post button
  return (
    <IconButton
      color="primary"
      aria-label="add"
      onClick={onClick}
      className="fixed bottom-4 bg-sky-500 right-4 text-white p-4 rounded-full shadow-md"
      sx={{ backgroundColor: "#bfdbfe" }}
    >
      <AddIcon />
    </IconButton>
  );
};
