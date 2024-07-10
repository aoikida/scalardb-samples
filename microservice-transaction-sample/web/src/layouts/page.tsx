import { SideBar } from "./SideBar/page";
import { FC } from "react";

type Props = {
  children: React.ReactNode;
};

export const Layout: FC<Props> = ({ children }) => {
  return (
    <div className="flex">
      <SideBar />
      <div className="pl-12 w-4/5">
        <div className="pt-5">{children}</div>
      </div>
    </div>
  );
};
