"use client";

import { FC } from "react";
import Link from "next/link";

import Image from "next/image";
import { usePathname } from "next/navigation";

type Props = {
  items: {
    href: string;
    title: string;
    svg: string;
  }[];
};

export const SidebarNav: FC<Props> = ({ items }) => {
  const pathname = usePathname();

  return (
    <nav className="flex space-x-2 lg:flex-col lg:space-x-0 lg:space-y-1 w-[210px]">
      {items.map((item) => (
        <Link
          key={item.href}
          href={item.href}
          className={`py-3 h-12 flex justify-start gap-4 pl-5 hover:underline ${
            item.href === pathname
              ? "bg-muted rounded-br-[24px] rounded-tr-[24px]"
              : ""
          }`}
        >
          <Image
            src="/Icon/post_icon.svg"
            quality={100}
            width={16}
            height={16}
            alt=""
          />
          <p className="flex items-center text-gray-900 font-Inter text-md">
            {item.title}
          </p>
        </Link>
      ))}
    </nav>
  );
};
