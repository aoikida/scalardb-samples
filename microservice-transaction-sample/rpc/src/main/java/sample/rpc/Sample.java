// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: sample.proto

package sample.rpc;

public final class Sample {
  private Sample() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_CreateUserOnCassandraRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_CreateUserOnCassandraRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_CreateUserOnCassandraResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_CreateUserOnCassandraResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_Post_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_Post_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_User_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_GetUserRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_GetUserRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_GetUserResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_GetUserResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_CreatePostRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_CreatePostRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_CreatePostResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_CreatePostResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_GetPostRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_GetPostRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_GetPostResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_GetPostResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_GetAllPostsRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_GetAllPostsRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_GetAllPostsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_GetAllPostsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_GetAllUsersRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_GetAllUsersRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_GetAllUsersResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_GetAllUsersResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_CreateUserOnMysqlRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_CreateUserOnMysqlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_PrepareRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_PrepareRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_ValidateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_ValidateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_CommitRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_CommitRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_rpc_RollbackRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_rpc_RollbackRequest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014sample.proto\022\003rpc\032\033google/protobuf/emp" +
      "ty.proto\"O\n\034CreateUserOnCassandraRequest" +
      "\022\017\n\007user_id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\022\020\n\010passw" +
      "ord\030\003 \001(\t\"\037\n\035CreateUserOnCassandraRespon" +
      "se\"G\n\004Post\022\017\n\007post_id\030\001 \001(\005\022\017\n\007user_id\030\002" +
      " \001(\005\022\014\n\004name\030\003 \001(\t\022\017\n\007content\030\004 \001(\t\"7\n\004U" +
      "ser\022\017\n\007user_id\030\001 \001(\005\022\014\n\004name\030\002 \001(\t\022\020\n\010pa" +
      "ssword\030\003 \001(\t\"!\n\016GetUserRequest\022\017\n\007user_i" +
      "d\030\001 \001(\005\"B\n\017GetUserResponse\022\017\n\007user_id\030\001 " +
      "\001(\005\022\014\n\004name\030\002 \001(\t\022\020\n\010password\030\003 \001(\t\"F\n\021C" +
      "reatePostRequest\022\017\n\007post_id\030\001 \001(\005\022\017\n\007use" +
      "r_id\030\002 \001(\005\022\017\n\007content\030\003 \001(\t\"\024\n\022CreatePos" +
      "tResponse\"!\n\016GetPostRequest\022\017\n\007post_id\030\001" +
      " \001(\005\"R\n\017GetPostResponse\022\017\n\007post_id\030\001 \001(\005" +
      "\022\017\n\007user_id\030\002 \001(\005\022\014\n\004name\030\003 \001(\t\022\017\n\007conte" +
      "nt\030\004 \001(\t\"\024\n\022GetAllPostsRequest\"/\n\023GetAll" +
      "PostsResponse\022\030\n\005posts\030\001 \003(\0132\t.rpc.Post\"" +
      "\024\n\022GetAllUsersRequest\"/\n\023GetAllUsersResp" +
      "onse\022\030\n\005users\030\001 \003(\0132\t.rpc.User\"c\n\030Create" +
      "UserOnMysqlRequest\022\017\n\007user_id\030\001 \001(\005\022\014\n\004n" +
      "ame\030\002 \001(\t\022\020\n\010password\030\003 \001(\t\022\026\n\016transacti" +
      "on_id\030\004 \001(\t\"(\n\016PrepareRequest\022\026\n\016transac" +
      "tion_id\030\001 \001(\t\")\n\017ValidateRequest\022\026\n\016tran" +
      "saction_id\030\001 \001(\t\"\'\n\rCommitRequest\022\026\n\016tra" +
      "nsaction_id\030\001 \001(\t\")\n\017RollbackRequest\022\026\n\016" +
      "transaction_id\030\001 \001(\t2\252\003\n\tCassandra\022`\n\025Cr" +
      "eateUserOnCassandra\022!.rpc.CreateUserOnCa" +
      "ssandraRequest\032\".rpc.CreateUserOnCassand" +
      "raResponse\"\000\0226\n\007GetUser\022\023.rpc.GetUserReq" +
      "uest\032\024.rpc.GetUserResponse\"\000\022?\n\nCreatePo" +
      "st\022\026.rpc.CreatePostRequest\032\027.rpc.CreateP" +
      "ostResponse\"\000\0226\n\007GetPost\022\023.rpc.GetPostRe" +
      "quest\032\024.rpc.GetPostResponse\"\000\022D\n\013GetAllP" +
      "osts\022\027.rpc.GetAllPostsRequest\032\030.rpc.GetA" +
      "llPostsResponse\"\0000\001\022D\n\013GetAllUsers\022\027.rpc" +
      ".GetAllUsersRequest\032\030.rpc.GetAllUsersRes" +
      "ponse\"\0000\0012\374\004\n\005Mysql\0226\n\007GetUser\022\023.rpc.Get" +
      "UserRequest\032\024.rpc.GetUserResponse\"\000\022?\n\nC" +
      "reatePost\022\026.rpc.CreatePostRequest\032\027.rpc." +
      "CreatePostResponse\"\000\0226\n\007GetPost\022\023.rpc.Ge" +
      "tPostRequest\032\024.rpc.GetPostResponse\"\000\022D\n\013" +
      "GetAllPosts\022\027.rpc.GetAllPostsRequest\032\030.r" +
      "pc.GetAllPostsResponse\"\0000\001\022D\n\013GetAllUser" +
      "s\022\027.rpc.GetAllUsersRequest\032\030.rpc.GetAllU" +
      "sersResponse\"\0000\001\022L\n\021CreateUserOnMysql\022\035." +
      "rpc.CreateUserOnMysqlRequest\032\026.google.pr" +
      "otobuf.Empty\"\000\0228\n\007Prepare\022\023.rpc.PrepareR" +
      "equest\032\026.google.protobuf.Empty\"\000\022:\n\010Vali" +
      "date\022\024.rpc.ValidateRequest\032\026.google.prot" +
      "obuf.Empty\"\000\0226\n\006Commit\022\022.rpc.CommitReque" +
      "st\032\026.google.protobuf.Empty\"\000\022:\n\010Rollback" +
      "\022\024.rpc.RollbackRequest\032\026.google.protobuf" +
      ".Empty\"\000B\026\n\nsample.rpcB\006SampleP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
        });
    internal_static_rpc_CreateUserOnCassandraRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_rpc_CreateUserOnCassandraRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_CreateUserOnCassandraRequest_descriptor,
        new java.lang.String[] { "UserId", "Name", "Password", });
    internal_static_rpc_CreateUserOnCassandraResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_rpc_CreateUserOnCassandraResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_CreateUserOnCassandraResponse_descriptor,
        new java.lang.String[] { });
    internal_static_rpc_Post_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_rpc_Post_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_Post_descriptor,
        new java.lang.String[] { "PostId", "UserId", "Name", "Content", });
    internal_static_rpc_User_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_rpc_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_User_descriptor,
        new java.lang.String[] { "UserId", "Name", "Password", });
    internal_static_rpc_GetUserRequest_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_rpc_GetUserRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_GetUserRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_rpc_GetUserResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_rpc_GetUserResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_GetUserResponse_descriptor,
        new java.lang.String[] { "UserId", "Name", "Password", });
    internal_static_rpc_CreatePostRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_rpc_CreatePostRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_CreatePostRequest_descriptor,
        new java.lang.String[] { "PostId", "UserId", "Content", });
    internal_static_rpc_CreatePostResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_rpc_CreatePostResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_CreatePostResponse_descriptor,
        new java.lang.String[] { });
    internal_static_rpc_GetPostRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_rpc_GetPostRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_GetPostRequest_descriptor,
        new java.lang.String[] { "PostId", });
    internal_static_rpc_GetPostResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_rpc_GetPostResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_GetPostResponse_descriptor,
        new java.lang.String[] { "PostId", "UserId", "Name", "Content", });
    internal_static_rpc_GetAllPostsRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_rpc_GetAllPostsRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_GetAllPostsRequest_descriptor,
        new java.lang.String[] { });
    internal_static_rpc_GetAllPostsResponse_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_rpc_GetAllPostsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_GetAllPostsResponse_descriptor,
        new java.lang.String[] { "Posts", });
    internal_static_rpc_GetAllUsersRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_rpc_GetAllUsersRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_GetAllUsersRequest_descriptor,
        new java.lang.String[] { });
    internal_static_rpc_GetAllUsersResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_rpc_GetAllUsersResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_GetAllUsersResponse_descriptor,
        new java.lang.String[] { "Users", });
    internal_static_rpc_CreateUserOnMysqlRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_rpc_CreateUserOnMysqlRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_CreateUserOnMysqlRequest_descriptor,
        new java.lang.String[] { "UserId", "Name", "Password", "TransactionId", });
    internal_static_rpc_PrepareRequest_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_rpc_PrepareRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_PrepareRequest_descriptor,
        new java.lang.String[] { "TransactionId", });
    internal_static_rpc_ValidateRequest_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_rpc_ValidateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_ValidateRequest_descriptor,
        new java.lang.String[] { "TransactionId", });
    internal_static_rpc_CommitRequest_descriptor =
      getDescriptor().getMessageTypes().get(17);
    internal_static_rpc_CommitRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_CommitRequest_descriptor,
        new java.lang.String[] { "TransactionId", });
    internal_static_rpc_RollbackRequest_descriptor =
      getDescriptor().getMessageTypes().get(18);
    internal_static_rpc_RollbackRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_rpc_RollbackRequest_descriptor,
        new java.lang.String[] { "TransactionId", });
    com.google.protobuf.EmptyProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
