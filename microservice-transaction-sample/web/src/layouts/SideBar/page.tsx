import { FC } from "react";
import { SidebarNav } from "../SideBar/Link/page";
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from "@/components/ui/select";
import { useServerName } from "@/app/context/server";

const sidebarNavItems = [
  {
    title: "Post",
    href: "/",
    svg: "post",
  },
];

export const SideBar: FC = () => {
  const { server, setServer } = useServerName();
  return (
    <div className="h-screen bg-[#D1E5FE] w-[228px] pt-28">
      <div className="flex justify-center">
        <Select
          defaultValue={server}
          onValueChange={(value) => setServer(value)}
        >
          <SelectTrigger className="w-4/5">
            <SelectValue placeholder="" />
          </SelectTrigger>
          <SelectContent>
            <SelectItem value="Server A">Server A</SelectItem>
            <SelectItem value="Server B">Server B</SelectItem>
          </SelectContent>
        </Select>
      </div>
      <aside className="mt-20">
        <SidebarNav items={sidebarNavItems} />
      </aside>
    </div>
  );
};
