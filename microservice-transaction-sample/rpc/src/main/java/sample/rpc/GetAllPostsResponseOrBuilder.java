// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sample.proto

package sample.rpc;

public interface GetAllPostsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:rpc.GetAllPostsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .rpc.Post posts = 1;</code>
   */
  java.util.List<sample.rpc.Post> 
      getPostsList();
  /**
   * <code>repeated .rpc.Post posts = 1;</code>
   */
  sample.rpc.Post getPosts(int index);
  /**
   * <code>repeated .rpc.Post posts = 1;</code>
   */
  int getPostsCount();
  /**
   * <code>repeated .rpc.Post posts = 1;</code>
   */
  java.util.List<? extends sample.rpc.PostOrBuilder> 
      getPostsOrBuilderList();
  /**
   * <code>repeated .rpc.Post posts = 1;</code>
   */
  sample.rpc.PostOrBuilder getPostsOrBuilder(
      int index);
}
