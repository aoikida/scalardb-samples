package sample.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * for Mysql
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: sample.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MysqlGrpc {

  private MysqlGrpc() {}

  public static final String SERVICE_NAME = "rpc.Mysql";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sample.rpc.GetUserRequest,
      sample.rpc.GetUserResponse> getGetUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUser",
      requestType = sample.rpc.GetUserRequest.class,
      responseType = sample.rpc.GetUserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sample.rpc.GetUserRequest,
      sample.rpc.GetUserResponse> getGetUserMethod() {
    io.grpc.MethodDescriptor<sample.rpc.GetUserRequest, sample.rpc.GetUserResponse> getGetUserMethod;
    if ((getGetUserMethod = MysqlGrpc.getGetUserMethod) == null) {
      synchronized (MysqlGrpc.class) {
        if ((getGetUserMethod = MysqlGrpc.getGetUserMethod) == null) {
          MysqlGrpc.getGetUserMethod = getGetUserMethod =
              io.grpc.MethodDescriptor.<sample.rpc.GetUserRequest, sample.rpc.GetUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MysqlMethodDescriptorSupplier("GetUser"))
              .build();
        }
      }
    }
    return getGetUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sample.rpc.CreatePostRequest,
      sample.rpc.CreatePostResponse> getCreatePostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePost",
      requestType = sample.rpc.CreatePostRequest.class,
      responseType = sample.rpc.CreatePostResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sample.rpc.CreatePostRequest,
      sample.rpc.CreatePostResponse> getCreatePostMethod() {
    io.grpc.MethodDescriptor<sample.rpc.CreatePostRequest, sample.rpc.CreatePostResponse> getCreatePostMethod;
    if ((getCreatePostMethod = MysqlGrpc.getCreatePostMethod) == null) {
      synchronized (MysqlGrpc.class) {
        if ((getCreatePostMethod = MysqlGrpc.getCreatePostMethod) == null) {
          MysqlGrpc.getCreatePostMethod = getCreatePostMethod =
              io.grpc.MethodDescriptor.<sample.rpc.CreatePostRequest, sample.rpc.CreatePostResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.CreatePostRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.CreatePostResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MysqlMethodDescriptorSupplier("CreatePost"))
              .build();
        }
      }
    }
    return getCreatePostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sample.rpc.GetPostRequest,
      sample.rpc.GetPostResponse> getGetPostMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPost",
      requestType = sample.rpc.GetPostRequest.class,
      responseType = sample.rpc.GetPostResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sample.rpc.GetPostRequest,
      sample.rpc.GetPostResponse> getGetPostMethod() {
    io.grpc.MethodDescriptor<sample.rpc.GetPostRequest, sample.rpc.GetPostResponse> getGetPostMethod;
    if ((getGetPostMethod = MysqlGrpc.getGetPostMethod) == null) {
      synchronized (MysqlGrpc.class) {
        if ((getGetPostMethod = MysqlGrpc.getGetPostMethod) == null) {
          MysqlGrpc.getGetPostMethod = getGetPostMethod =
              io.grpc.MethodDescriptor.<sample.rpc.GetPostRequest, sample.rpc.GetPostResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetPostRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetPostResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MysqlMethodDescriptorSupplier("GetPost"))
              .build();
        }
      }
    }
    return getGetPostMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sample.rpc.GetAllPostsRequest,
      sample.rpc.GetAllPostsResponse> getGetAllPostsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAllPosts",
      requestType = sample.rpc.GetAllPostsRequest.class,
      responseType = sample.rpc.GetAllPostsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<sample.rpc.GetAllPostsRequest,
      sample.rpc.GetAllPostsResponse> getGetAllPostsMethod() {
    io.grpc.MethodDescriptor<sample.rpc.GetAllPostsRequest, sample.rpc.GetAllPostsResponse> getGetAllPostsMethod;
    if ((getGetAllPostsMethod = MysqlGrpc.getGetAllPostsMethod) == null) {
      synchronized (MysqlGrpc.class) {
        if ((getGetAllPostsMethod = MysqlGrpc.getGetAllPostsMethod) == null) {
          MysqlGrpc.getGetAllPostsMethod = getGetAllPostsMethod =
              io.grpc.MethodDescriptor.<sample.rpc.GetAllPostsRequest, sample.rpc.GetAllPostsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllPosts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetAllPostsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetAllPostsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MysqlMethodDescriptorSupplier("GetAllPosts"))
              .build();
        }
      }
    }
    return getGetAllPostsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sample.rpc.CreateUserOnMysqlRequest,
      com.google.protobuf.Empty> getCreateUserOnMysqlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserOnMysql",
      requestType = sample.rpc.CreateUserOnMysqlRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sample.rpc.CreateUserOnMysqlRequest,
      com.google.protobuf.Empty> getCreateUserOnMysqlMethod() {
    io.grpc.MethodDescriptor<sample.rpc.CreateUserOnMysqlRequest, com.google.protobuf.Empty> getCreateUserOnMysqlMethod;
    if ((getCreateUserOnMysqlMethod = MysqlGrpc.getCreateUserOnMysqlMethod) == null) {
      synchronized (MysqlGrpc.class) {
        if ((getCreateUserOnMysqlMethod = MysqlGrpc.getCreateUserOnMysqlMethod) == null) {
          MysqlGrpc.getCreateUserOnMysqlMethod = getCreateUserOnMysqlMethod =
              io.grpc.MethodDescriptor.<sample.rpc.CreateUserOnMysqlRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUserOnMysql"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.CreateUserOnMysqlRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MysqlMethodDescriptorSupplier("CreateUserOnMysql"))
              .build();
        }
      }
    }
    return getCreateUserOnMysqlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sample.rpc.PrepareRequest,
      com.google.protobuf.Empty> getPrepareMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Prepare",
      requestType = sample.rpc.PrepareRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sample.rpc.PrepareRequest,
      com.google.protobuf.Empty> getPrepareMethod() {
    io.grpc.MethodDescriptor<sample.rpc.PrepareRequest, com.google.protobuf.Empty> getPrepareMethod;
    if ((getPrepareMethod = MysqlGrpc.getPrepareMethod) == null) {
      synchronized (MysqlGrpc.class) {
        if ((getPrepareMethod = MysqlGrpc.getPrepareMethod) == null) {
          MysqlGrpc.getPrepareMethod = getPrepareMethod =
              io.grpc.MethodDescriptor.<sample.rpc.PrepareRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Prepare"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.PrepareRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MysqlMethodDescriptorSupplier("Prepare"))
              .build();
        }
      }
    }
    return getPrepareMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sample.rpc.ValidateRequest,
      com.google.protobuf.Empty> getValidateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Validate",
      requestType = sample.rpc.ValidateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sample.rpc.ValidateRequest,
      com.google.protobuf.Empty> getValidateMethod() {
    io.grpc.MethodDescriptor<sample.rpc.ValidateRequest, com.google.protobuf.Empty> getValidateMethod;
    if ((getValidateMethod = MysqlGrpc.getValidateMethod) == null) {
      synchronized (MysqlGrpc.class) {
        if ((getValidateMethod = MysqlGrpc.getValidateMethod) == null) {
          MysqlGrpc.getValidateMethod = getValidateMethod =
              io.grpc.MethodDescriptor.<sample.rpc.ValidateRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Validate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.ValidateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MysqlMethodDescriptorSupplier("Validate"))
              .build();
        }
      }
    }
    return getValidateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sample.rpc.CommitRequest,
      com.google.protobuf.Empty> getCommitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Commit",
      requestType = sample.rpc.CommitRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sample.rpc.CommitRequest,
      com.google.protobuf.Empty> getCommitMethod() {
    io.grpc.MethodDescriptor<sample.rpc.CommitRequest, com.google.protobuf.Empty> getCommitMethod;
    if ((getCommitMethod = MysqlGrpc.getCommitMethod) == null) {
      synchronized (MysqlGrpc.class) {
        if ((getCommitMethod = MysqlGrpc.getCommitMethod) == null) {
          MysqlGrpc.getCommitMethod = getCommitMethod =
              io.grpc.MethodDescriptor.<sample.rpc.CommitRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Commit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.CommitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MysqlMethodDescriptorSupplier("Commit"))
              .build();
        }
      }
    }
    return getCommitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sample.rpc.RollbackRequest,
      com.google.protobuf.Empty> getRollbackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Rollback",
      requestType = sample.rpc.RollbackRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sample.rpc.RollbackRequest,
      com.google.protobuf.Empty> getRollbackMethod() {
    io.grpc.MethodDescriptor<sample.rpc.RollbackRequest, com.google.protobuf.Empty> getRollbackMethod;
    if ((getRollbackMethod = MysqlGrpc.getRollbackMethod) == null) {
      synchronized (MysqlGrpc.class) {
        if ((getRollbackMethod = MysqlGrpc.getRollbackMethod) == null) {
          MysqlGrpc.getRollbackMethod = getRollbackMethod =
              io.grpc.MethodDescriptor.<sample.rpc.RollbackRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Rollback"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.RollbackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MysqlMethodDescriptorSupplier("Rollback"))
              .build();
        }
      }
    }
    return getRollbackMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MysqlStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MysqlStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MysqlStub>() {
        @java.lang.Override
        public MysqlStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MysqlStub(channel, callOptions);
        }
      };
    return MysqlStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MysqlBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MysqlBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MysqlBlockingStub>() {
        @java.lang.Override
        public MysqlBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MysqlBlockingStub(channel, callOptions);
        }
      };
    return MysqlBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MysqlFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MysqlFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MysqlFutureStub>() {
        @java.lang.Override
        public MysqlFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MysqlFutureStub(channel, callOptions);
        }
      };
    return MysqlFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * for Mysql
   * </pre>
   */
  public static abstract class MysqlImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Get user information
     * </pre>
     */
    public void getUser(sample.rpc.GetUserRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.GetUserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserMethod(), responseObserver);
    }

    /**
     * <pre>
     *Create post information
     * </pre>
     */
    public void createPost(sample.rpc.CreatePostRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.CreatePostResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePostMethod(), responseObserver);
    }

    /**
     * <pre>
     *Get post information
     * </pre>
     */
    public void getPost(sample.rpc.GetPostRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.GetPostResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPostMethod(), responseObserver);
    }

    /**
     */
    public void getAllPosts(sample.rpc.GetAllPostsRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.GetAllPostsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllPostsMethod(), responseObserver);
    }

    /**
     * <pre>
     *Create user infomation
     * </pre>
     */
    public void createUserOnMysql(sample.rpc.CreateUserOnMysqlRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserOnMysqlMethod(), responseObserver);
    }

    /**
     * <pre>
     * Prepare the transaction
     * </pre>
     */
    public void prepare(sample.rpc.PrepareRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrepareMethod(), responseObserver);
    }

    /**
     * <pre>
     * Validate the transaction
     * </pre>
     */
    public void validate(sample.rpc.ValidateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Commit the transaction
     * </pre>
     */
    public void commit(sample.rpc.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCommitMethod(), responseObserver);
    }

    /**
     * <pre>
     * Rollback the transaction
     * </pre>
     */
    public void rollback(sample.rpc.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRollbackMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sample.rpc.GetUserRequest,
                sample.rpc.GetUserResponse>(
                  this, METHODID_GET_USER)))
          .addMethod(
            getCreatePostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sample.rpc.CreatePostRequest,
                sample.rpc.CreatePostResponse>(
                  this, METHODID_CREATE_POST)))
          .addMethod(
            getGetPostMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sample.rpc.GetPostRequest,
                sample.rpc.GetPostResponse>(
                  this, METHODID_GET_POST)))
          .addMethod(
            getGetAllPostsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                sample.rpc.GetAllPostsRequest,
                sample.rpc.GetAllPostsResponse>(
                  this, METHODID_GET_ALL_POSTS)))
          .addMethod(
            getCreateUserOnMysqlMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sample.rpc.CreateUserOnMysqlRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CREATE_USER_ON_MYSQL)))
          .addMethod(
            getPrepareMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sample.rpc.PrepareRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_PREPARE)))
          .addMethod(
            getValidateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sample.rpc.ValidateRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_VALIDATE)))
          .addMethod(
            getCommitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sample.rpc.CommitRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_COMMIT)))
          .addMethod(
            getRollbackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sample.rpc.RollbackRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_ROLLBACK)))
          .build();
    }
  }

  /**
   * <pre>
   * for Mysql
   * </pre>
   */
  public static final class MysqlStub extends io.grpc.stub.AbstractAsyncStub<MysqlStub> {
    private MysqlStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MysqlStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MysqlStub(channel, callOptions);
    }

    /**
     * <pre>
     *Get user information
     * </pre>
     */
    public void getUser(sample.rpc.GetUserRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.GetUserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Create post information
     * </pre>
     */
    public void createPost(sample.rpc.CreatePostRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.CreatePostResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Get post information
     * </pre>
     */
    public void getPost(sample.rpc.GetPostRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.GetPostResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPostMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllPosts(sample.rpc.GetAllPostsRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.GetAllPostsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllPostsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *Create user infomation
     * </pre>
     */
    public void createUserOnMysql(sample.rpc.CreateUserOnMysqlRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserOnMysqlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Prepare the transaction
     * </pre>
     */
    public void prepare(sample.rpc.PrepareRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPrepareMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Validate the transaction
     * </pre>
     */
    public void validate(sample.rpc.ValidateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Commit the transaction
     * </pre>
     */
    public void commit(sample.rpc.CommitRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Rollback the transaction
     * </pre>
     */
    public void rollback(sample.rpc.RollbackRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * for Mysql
   * </pre>
   */
  public static final class MysqlBlockingStub extends io.grpc.stub.AbstractBlockingStub<MysqlBlockingStub> {
    private MysqlBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MysqlBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MysqlBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Get user information
     * </pre>
     */
    public sample.rpc.GetUserResponse getUser(sample.rpc.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Create post information
     * </pre>
     */
    public sample.rpc.CreatePostResponse createPost(sample.rpc.CreatePostRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePostMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Get post information
     * </pre>
     */
    public sample.rpc.GetPostResponse getPost(sample.rpc.GetPostRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPostMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<sample.rpc.GetAllPostsResponse> getAllPosts(
        sample.rpc.GetAllPostsRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllPostsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *Create user infomation
     * </pre>
     */
    public com.google.protobuf.Empty createUserOnMysql(sample.rpc.CreateUserOnMysqlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserOnMysqlMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Prepare the transaction
     * </pre>
     */
    public com.google.protobuf.Empty prepare(sample.rpc.PrepareRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPrepareMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Validate the transaction
     * </pre>
     */
    public com.google.protobuf.Empty validate(sample.rpc.ValidateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Commit the transaction
     * </pre>
     */
    public com.google.protobuf.Empty commit(sample.rpc.CommitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Rollback the transaction
     * </pre>
     */
    public com.google.protobuf.Empty rollback(sample.rpc.RollbackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRollbackMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * for Mysql
   * </pre>
   */
  public static final class MysqlFutureStub extends io.grpc.stub.AbstractFutureStub<MysqlFutureStub> {
    private MysqlFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MysqlFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MysqlFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Get user information
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<sample.rpc.GetUserResponse> getUser(
        sample.rpc.GetUserRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Create post information
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<sample.rpc.CreatePostResponse> createPost(
        sample.rpc.CreatePostRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePostMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Get post information
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<sample.rpc.GetPostResponse> getPost(
        sample.rpc.GetPostRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPostMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *Create user infomation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> createUserOnMysql(
        sample.rpc.CreateUserOnMysqlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserOnMysqlMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Prepare the transaction
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> prepare(
        sample.rpc.PrepareRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPrepareMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Validate the transaction
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> validate(
        sample.rpc.ValidateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Commit the transaction
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> commit(
        sample.rpc.CommitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCommitMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Rollback the transaction
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> rollback(
        sample.rpc.RollbackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRollbackMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER = 0;
  private static final int METHODID_CREATE_POST = 1;
  private static final int METHODID_GET_POST = 2;
  private static final int METHODID_GET_ALL_POSTS = 3;
  private static final int METHODID_CREATE_USER_ON_MYSQL = 4;
  private static final int METHODID_PREPARE = 5;
  private static final int METHODID_VALIDATE = 6;
  private static final int METHODID_COMMIT = 7;
  private static final int METHODID_ROLLBACK = 8;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MysqlImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MysqlImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER:
          serviceImpl.getUser((sample.rpc.GetUserRequest) request,
              (io.grpc.stub.StreamObserver<sample.rpc.GetUserResponse>) responseObserver);
          break;
        case METHODID_CREATE_POST:
          serviceImpl.createPost((sample.rpc.CreatePostRequest) request,
              (io.grpc.stub.StreamObserver<sample.rpc.CreatePostResponse>) responseObserver);
          break;
        case METHODID_GET_POST:
          serviceImpl.getPost((sample.rpc.GetPostRequest) request,
              (io.grpc.stub.StreamObserver<sample.rpc.GetPostResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_POSTS:
          serviceImpl.getAllPosts((sample.rpc.GetAllPostsRequest) request,
              (io.grpc.stub.StreamObserver<sample.rpc.GetAllPostsResponse>) responseObserver);
          break;
        case METHODID_CREATE_USER_ON_MYSQL:
          serviceImpl.createUserOnMysql((sample.rpc.CreateUserOnMysqlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PREPARE:
          serviceImpl.prepare((sample.rpc.PrepareRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_VALIDATE:
          serviceImpl.validate((sample.rpc.ValidateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_COMMIT:
          serviceImpl.commit((sample.rpc.CommitRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_ROLLBACK:
          serviceImpl.rollback((sample.rpc.RollbackRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MysqlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MysqlBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sample.rpc.Sample.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Mysql");
    }
  }

  private static final class MysqlFileDescriptorSupplier
      extends MysqlBaseDescriptorSupplier {
    MysqlFileDescriptorSupplier() {}
  }

  private static final class MysqlMethodDescriptorSupplier
      extends MysqlBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MysqlMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MysqlGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MysqlFileDescriptorSupplier())
              .addMethod(getGetUserMethod())
              .addMethod(getCreatePostMethod())
              .addMethod(getGetPostMethod())
              .addMethod(getGetAllPostsMethod())
              .addMethod(getCreateUserOnMysqlMethod())
              .addMethod(getPrepareMethod())
              .addMethod(getValidateMethod())
              .addMethod(getCommitMethod())
              .addMethod(getRollbackMethod())
              .build();
        }
      }
    }
    return result;
  }
}
