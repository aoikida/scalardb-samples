import Image from "next/image";
import { FC } from "react";
import { Textarea } from "@/components/ui/textarea";
import { zodResolver } from "@hookform/resolvers/zod";
import { useForm } from "react-hook-form";
import { Button } from "@/components/ui/button";
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from "@/components/ui/form";
import { toast } from "@/components/ui/use-toast";
import { AddPostInput } from "@/services/schema/types";
import { PostSchema } from "@/services/schema";
import { createPost } from "@/services/requests/create-post";

type Props = {
  onClose: () => void;
  userId: number;
  server: string;
  isOpen: boolean;
};

export const AddPostDialog: FC<Props> = ({
  onClose,
  userId,
  server,
  isOpen,
}) => {
  const form = useForm<AddPostInput>({
    resolver: zodResolver(PostSchema),
    defaultValues: {
      userId,
      server,
    },
  });

  const { getValues } = form;

  const onSubmit = async () => {
    const data = getValues();
    const userId = 2;
    const message = data.message;

    try {
      console.log({ userId, server, message });
      await createPost(userId, message, server);
      toast({
        title: "Success",
        description: "Your post has been added.",
      });
      form.reset();
      onClose();
    } catch (error: any) {
      toast({
        title: "Error",
        description: error.message || "An error occurred",
      });
    }
  };

  const onSubmitError = (error: any) => {
    console.error(error);
  };

  if (!isOpen) return null;

  return (
    <div className="fixed inset-0 z-50 overflow-y-auto bg-black-modal">
      <div className="flex min-h-screen items-center justify-center px-4 pb-20 pt-4 text-center">
        <div className="flex justify-center pt-20">
          <div className="relative mx-auto my-5 h-auto w-[327px] rounded-lg bg-white md:w-[464px]">
            <div className="flex items-center justify-between border-b border-black-lightest px-4 pb-4.75 pt-5.75 lg:py-4 lg:pl-8">
              <h2 className="flex items-center font-default text-lg font-normal leading-1.6 text-black-darkest lg:h-13.75 lg:text-xl lg:leading-1.3">
                Create a new post
              </h2>
              <button
                className="absolute right-4 top-4 h-8 w-8 rounded-full bg-green-faint lg:h-9.656855 lg:w-9.656855"
                onClick={onClose}
              >
                <div className="flex items-center justify-center">
                  <Image
                    src="/Icon/close_icon.svg"
                    width={23}
                    height={23}
                    alt="close_icon"
                  />
                </div>
              </button>
            </div>
            <Form {...form}>
              <form
                onSubmit={form.handleSubmit(onSubmit, onSubmitError)}
                className="w-full px-4 pb-4 pt-4 lg:px-8 lg:pb-6 lg:pt-6"
              >
                <FormField
                  control={form.control}
                  name="message"
                  render={({ field }) => (
                    <FormItem>
                      <FormLabel>Message</FormLabel>
                      <FormControl>
                        <Textarea
                          placeholder="Tell us a little bit about yourself"
                          className="resize-none"
                          {...field}
                        />
                      </FormControl>
                      <FormMessage />
                    </FormItem>
                  )}
                />
                <p className="mt-2 text-red-400">
                  {form.formState.errors.message?.message}
                </p>
                <Button type="submit" className="mt-4">
                  Submit
                </Button>
              </form>
            </Form>
          </div>
        </div>
      </div>
    </div>
  );
};
