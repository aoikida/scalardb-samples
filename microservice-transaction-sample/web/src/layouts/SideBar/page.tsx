import { FC } from "react";
import { SidebarNav } from "../SideBar/Link/page";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";

const sidebarNavItems = [
  {
    title: "Post",
    href: "/",
    svg: "post",
  },
];

export const SideBar: FC = () => {
  return (
    <div className="h-screen bg-[#D1E5FE] w-[228px] pt-28">
      <div className="flex justify-center">
        <Select>
          <SelectTrigger className="w-4/5">
            <SelectValue placeholder="" />
          </SelectTrigger>
          <SelectContent>
            <SelectItem value="server-A">Server A</SelectItem>
            <SelectItem value="server-B">Server B</SelectItem>
          </SelectContent>
        </Select>
      </div>
      <aside className="mt-20">
        <SidebarNav items={sidebarNavItems} />
      </aside>
    </div>
  );
};
