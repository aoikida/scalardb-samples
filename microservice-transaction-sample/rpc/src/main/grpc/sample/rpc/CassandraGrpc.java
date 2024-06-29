package sample.rpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * for Cassandra
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: sample.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CassandraGrpc {

  private CassandraGrpc() {}

  public static final String SERVICE_NAME = "rpc.Cassandra";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sample.rpc.CreateUserOnCassandraRequest,
      sample.rpc.CreateUserOnCassandraResponse> getCreateUserOnCassandraMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateUserOnCassandra",
      requestType = sample.rpc.CreateUserOnCassandraRequest.class,
      responseType = sample.rpc.CreateUserOnCassandraResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<sample.rpc.CreateUserOnCassandraRequest,
      sample.rpc.CreateUserOnCassandraResponse> getCreateUserOnCassandraMethod() {
    io.grpc.MethodDescriptor<sample.rpc.CreateUserOnCassandraRequest, sample.rpc.CreateUserOnCassandraResponse> getCreateUserOnCassandraMethod;
    if ((getCreateUserOnCassandraMethod = CassandraGrpc.getCreateUserOnCassandraMethod) == null) {
      synchronized (CassandraGrpc.class) {
        if ((getCreateUserOnCassandraMethod = CassandraGrpc.getCreateUserOnCassandraMethod) == null) {
          CassandraGrpc.getCreateUserOnCassandraMethod = getCreateUserOnCassandraMethod =
              io.grpc.MethodDescriptor.<sample.rpc.CreateUserOnCassandraRequest, sample.rpc.CreateUserOnCassandraResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateUserOnCassandra"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.CreateUserOnCassandraRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.CreateUserOnCassandraResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CassandraMethodDescriptorSupplier("CreateUserOnCassandra"))
              .build();
        }
      }
    }
    return getCreateUserOnCassandraMethod;
  }

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
    if ((getGetUserMethod = CassandraGrpc.getGetUserMethod) == null) {
      synchronized (CassandraGrpc.class) {
        if ((getGetUserMethod = CassandraGrpc.getGetUserMethod) == null) {
          CassandraGrpc.getGetUserMethod = getGetUserMethod =
              io.grpc.MethodDescriptor.<sample.rpc.GetUserRequest, sample.rpc.GetUserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetUserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CassandraMethodDescriptorSupplier("GetUser"))
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
    if ((getCreatePostMethod = CassandraGrpc.getCreatePostMethod) == null) {
      synchronized (CassandraGrpc.class) {
        if ((getCreatePostMethod = CassandraGrpc.getCreatePostMethod) == null) {
          CassandraGrpc.getCreatePostMethod = getCreatePostMethod =
              io.grpc.MethodDescriptor.<sample.rpc.CreatePostRequest, sample.rpc.CreatePostResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.CreatePostRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.CreatePostResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CassandraMethodDescriptorSupplier("CreatePost"))
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
    if ((getGetPostMethod = CassandraGrpc.getGetPostMethod) == null) {
      synchronized (CassandraGrpc.class) {
        if ((getGetPostMethod = CassandraGrpc.getGetPostMethod) == null) {
          CassandraGrpc.getGetPostMethod = getGetPostMethod =
              io.grpc.MethodDescriptor.<sample.rpc.GetPostRequest, sample.rpc.GetPostResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPost"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetPostRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetPostResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CassandraMethodDescriptorSupplier("GetPost"))
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
    if ((getGetAllPostsMethod = CassandraGrpc.getGetAllPostsMethod) == null) {
      synchronized (CassandraGrpc.class) {
        if ((getGetAllPostsMethod = CassandraGrpc.getGetAllPostsMethod) == null) {
          CassandraGrpc.getGetAllPostsMethod = getGetAllPostsMethod =
              io.grpc.MethodDescriptor.<sample.rpc.GetAllPostsRequest, sample.rpc.GetAllPostsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllPosts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetAllPostsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sample.rpc.GetAllPostsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CassandraMethodDescriptorSupplier("GetAllPosts"))
              .build();
        }
      }
    }
    return getGetAllPostsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CassandraStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CassandraStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CassandraStub>() {
        @java.lang.Override
        public CassandraStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CassandraStub(channel, callOptions);
        }
      };
    return CassandraStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CassandraBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CassandraBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CassandraBlockingStub>() {
        @java.lang.Override
        public CassandraBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CassandraBlockingStub(channel, callOptions);
        }
      };
    return CassandraBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CassandraFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CassandraFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CassandraFutureStub>() {
        @java.lang.Override
        public CassandraFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CassandraFutureStub(channel, callOptions);
        }
      };
    return CassandraFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * for Cassandra
   * </pre>
   */
  public static abstract class CassandraImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *Create user infomation which spans mulitple databases
     * </pre>
     */
    public void createUserOnCassandra(sample.rpc.CreateUserOnCassandraRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.CreateUserOnCassandraResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateUserOnCassandraMethod(), responseObserver);
    }

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

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateUserOnCassandraMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                sample.rpc.CreateUserOnCassandraRequest,
                sample.rpc.CreateUserOnCassandraResponse>(
                  this, METHODID_CREATE_USER_ON_CASSANDRA)))
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
          .build();
    }
  }

  /**
   * <pre>
   * for Cassandra
   * </pre>
   */
  public static final class CassandraStub extends io.grpc.stub.AbstractAsyncStub<CassandraStub> {
    private CassandraStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CassandraStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CassandraStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create user infomation which spans mulitple databases
     * </pre>
     */
    public void createUserOnCassandra(sample.rpc.CreateUserOnCassandraRequest request,
        io.grpc.stub.StreamObserver<sample.rpc.CreateUserOnCassandraResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateUserOnCassandraMethod(), getCallOptions()), request, responseObserver);
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
  }

  /**
   * <pre>
   * for Cassandra
   * </pre>
   */
  public static final class CassandraBlockingStub extends io.grpc.stub.AbstractBlockingStub<CassandraBlockingStub> {
    private CassandraBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CassandraBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CassandraBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create user infomation which spans mulitple databases
     * </pre>
     */
    public sample.rpc.CreateUserOnCassandraResponse createUserOnCassandra(sample.rpc.CreateUserOnCassandraRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateUserOnCassandraMethod(), getCallOptions(), request);
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
  }

  /**
   * <pre>
   * for Cassandra
   * </pre>
   */
  public static final class CassandraFutureStub extends io.grpc.stub.AbstractFutureStub<CassandraFutureStub> {
    private CassandraFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CassandraFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CassandraFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *Create user infomation which spans mulitple databases
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<sample.rpc.CreateUserOnCassandraResponse> createUserOnCassandra(
        sample.rpc.CreateUserOnCassandraRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateUserOnCassandraMethod(), getCallOptions()), request);
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
  }

  private static final int METHODID_CREATE_USER_ON_CASSANDRA = 0;
  private static final int METHODID_GET_USER = 1;
  private static final int METHODID_CREATE_POST = 2;
  private static final int METHODID_GET_POST = 3;
  private static final int METHODID_GET_ALL_POSTS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CassandraImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CassandraImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_USER_ON_CASSANDRA:
          serviceImpl.createUserOnCassandra((sample.rpc.CreateUserOnCassandraRequest) request,
              (io.grpc.stub.StreamObserver<sample.rpc.CreateUserOnCassandraResponse>) responseObserver);
          break;
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

  private static abstract class CassandraBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CassandraBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sample.rpc.Sample.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Cassandra");
    }
  }

  private static final class CassandraFileDescriptorSupplier
      extends CassandraBaseDescriptorSupplier {
    CassandraFileDescriptorSupplier() {}
  }

  private static final class CassandraMethodDescriptorSupplier
      extends CassandraBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CassandraMethodDescriptorSupplier(String methodName) {
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
      synchronized (CassandraGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CassandraFileDescriptorSupplier())
              .addMethod(getCreateUserOnCassandraMethod())
              .addMethod(getGetUserMethod())
              .addMethod(getCreatePostMethod())
              .addMethod(getGetPostMethod())
              .addMethod(getGetAllPostsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
