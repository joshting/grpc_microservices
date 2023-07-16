package com.joshuating.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: registry.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegistryServiceGrpc {

  private RegistryServiceGrpc() {}

  public static final String SERVICE_NAME = "RegistryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.joshuating.grpc.RegistryProto.RegisterRequest,
      com.joshuating.grpc.RegistryProto.RegisterResponse> getRegisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Register",
      requestType = com.joshuating.grpc.RegistryProto.RegisterRequest.class,
      responseType = com.joshuating.grpc.RegistryProto.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.joshuating.grpc.RegistryProto.RegisterRequest,
      com.joshuating.grpc.RegistryProto.RegisterResponse> getRegisterMethod() {
    io.grpc.MethodDescriptor<com.joshuating.grpc.RegistryProto.RegisterRequest, com.joshuating.grpc.RegistryProto.RegisterResponse> getRegisterMethod;
    if ((getRegisterMethod = RegistryServiceGrpc.getRegisterMethod) == null) {
      synchronized (RegistryServiceGrpc.class) {
        if ((getRegisterMethod = RegistryServiceGrpc.getRegisterMethod) == null) {
          RegistryServiceGrpc.getRegisterMethod = getRegisterMethod =
              io.grpc.MethodDescriptor.<com.joshuating.grpc.RegistryProto.RegisterRequest, com.joshuating.grpc.RegistryProto.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Register"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joshuating.grpc.RegistryProto.RegisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joshuating.grpc.RegistryProto.RegisterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RegistryServiceMethodDescriptorSupplier("Register"))
              .build();
        }
      }
    }
    return getRegisterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.joshuating.grpc.RegistryProto.DeregisterRequest,
      com.joshuating.grpc.RegistryProto.DeregisterResponse> getDeregisterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Deregister",
      requestType = com.joshuating.grpc.RegistryProto.DeregisterRequest.class,
      responseType = com.joshuating.grpc.RegistryProto.DeregisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.joshuating.grpc.RegistryProto.DeregisterRequest,
      com.joshuating.grpc.RegistryProto.DeregisterResponse> getDeregisterMethod() {
    io.grpc.MethodDescriptor<com.joshuating.grpc.RegistryProto.DeregisterRequest, com.joshuating.grpc.RegistryProto.DeregisterResponse> getDeregisterMethod;
    if ((getDeregisterMethod = RegistryServiceGrpc.getDeregisterMethod) == null) {
      synchronized (RegistryServiceGrpc.class) {
        if ((getDeregisterMethod = RegistryServiceGrpc.getDeregisterMethod) == null) {
          RegistryServiceGrpc.getDeregisterMethod = getDeregisterMethod =
              io.grpc.MethodDescriptor.<com.joshuating.grpc.RegistryProto.DeregisterRequest, com.joshuating.grpc.RegistryProto.DeregisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Deregister"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joshuating.grpc.RegistryProto.DeregisterRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joshuating.grpc.RegistryProto.DeregisterResponse.getDefaultInstance()))
              .setSchemaDescriptor(new RegistryServiceMethodDescriptorSupplier("Deregister"))
              .build();
        }
      }
    }
    return getDeregisterMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static RegistryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistryServiceStub>() {
        @java.lang.Override
        public RegistryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistryServiceStub(channel, callOptions);
        }
      };
    return RegistryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegistryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistryServiceBlockingStub>() {
        @java.lang.Override
        public RegistryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistryServiceBlockingStub(channel, callOptions);
        }
      };
    return RegistryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static RegistryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<RegistryServiceFutureStub>() {
        @java.lang.Override
        public RegistryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new RegistryServiceFutureStub(channel, callOptions);
        }
      };
    return RegistryServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class RegistryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void register(com.joshuating.grpc.RegistryProto.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.joshuating.grpc.RegistryProto.RegisterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterMethod(), responseObserver);
    }

    /**
     */
    public void deregister(com.joshuating.grpc.RegistryProto.DeregisterRequest request,
        io.grpc.stub.StreamObserver<com.joshuating.grpc.RegistryProto.DeregisterResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeregisterMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.joshuating.grpc.RegistryProto.RegisterRequest,
                com.joshuating.grpc.RegistryProto.RegisterResponse>(
                  this, METHODID_REGISTER)))
          .addMethod(
            getDeregisterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.joshuating.grpc.RegistryProto.DeregisterRequest,
                com.joshuating.grpc.RegistryProto.DeregisterResponse>(
                  this, METHODID_DEREGISTER)))
          .build();
    }
  }

  /**
   */
  public static final class RegistryServiceStub extends io.grpc.stub.AbstractAsyncStub<RegistryServiceStub> {
    private RegistryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryServiceStub(channel, callOptions);
    }

    /**
     */
    public void register(com.joshuating.grpc.RegistryProto.RegisterRequest request,
        io.grpc.stub.StreamObserver<com.joshuating.grpc.RegistryProto.RegisterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deregister(com.joshuating.grpc.RegistryProto.DeregisterRequest request,
        io.grpc.stub.StreamObserver<com.joshuating.grpc.RegistryProto.DeregisterResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeregisterMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class RegistryServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<RegistryServiceBlockingStub> {
    private RegistryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.joshuating.grpc.RegistryProto.RegisterResponse register(com.joshuating.grpc.RegistryProto.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.joshuating.grpc.RegistryProto.DeregisterResponse deregister(com.joshuating.grpc.RegistryProto.DeregisterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeregisterMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class RegistryServiceFutureStub extends io.grpc.stub.AbstractFutureStub<RegistryServiceFutureStub> {
    private RegistryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.joshuating.grpc.RegistryProto.RegisterResponse> register(
        com.joshuating.grpc.RegistryProto.RegisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.joshuating.grpc.RegistryProto.DeregisterResponse> deregister(
        com.joshuating.grpc.RegistryProto.DeregisterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeregisterMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER = 0;
  private static final int METHODID_DEREGISTER = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegistryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegistryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER:
          serviceImpl.register((com.joshuating.grpc.RegistryProto.RegisterRequest) request,
              (io.grpc.stub.StreamObserver<com.joshuating.grpc.RegistryProto.RegisterResponse>) responseObserver);
          break;
        case METHODID_DEREGISTER:
          serviceImpl.deregister((com.joshuating.grpc.RegistryProto.DeregisterRequest) request,
              (io.grpc.stub.StreamObserver<com.joshuating.grpc.RegistryProto.DeregisterResponse>) responseObserver);
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

  private static abstract class RegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegistryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.joshuating.grpc.RegistryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegistryService");
    }
  }

  private static final class RegistryServiceFileDescriptorSupplier
      extends RegistryServiceBaseDescriptorSupplier {
    RegistryServiceFileDescriptorSupplier() {}
  }

  private static final class RegistryServiceMethodDescriptorSupplier
      extends RegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegistryServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegistryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new RegistryServiceFileDescriptorSupplier())
              .addMethod(getRegisterMethod())
              .addMethod(getDeregisterMethod())
              .build();
        }
      }
    }
    return result;
  }
}
