"use client";
import { createContext, ReactNode, useContext, useState } from "react";

export const serverContext = createContext({
  server: "Server A",
  setServer: (server: string) => {
    console.log(`${server} is set.`);
  },
});

export const ServerProvider = ({ children }: { children: ReactNode }) => {
  const [server, setServer] = useState("Server A");

  return (
    <serverContext.Provider value={{ server, setServer }}>
      {children}
    </serverContext.Provider>
  );
};

export const useServerName = () => {
  const { server, setServer } = useContext(serverContext);
  return { server, setServer };
};
