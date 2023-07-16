package com.joshuating.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: microservice.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MicroserviceServiceGrpc {

  private MicroserviceServiceGrpc() {}

  public static final String SERVICE_NAME = "MicroserviceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.joshuating.grpc.MicroserviceProto.CheckStatusRequest,
      com.joshuating.grpc.MicroserviceProto.CheckStatusResponse> getCheckStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckStatus",
      requestType = com.joshuating.grpc.MicroserviceProto.CheckStatusRequest.class,
      responseType = com.joshuating.grpc.MicroserviceProto.CheckStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.joshuating.grpc.MicroserviceProto.CheckStatusRequest,
      com.joshuating.grpc.MicroserviceProto.CheckStatusResponse> getCheckStatusMethod() {
    io.grpc.MethodDescriptor<com.joshuating.grpc.MicroserviceProto.CheckStatusRequest, com.joshuating.grpc.MicroserviceProto.CheckStatusResponse> getCheckStatusMethod;
    if ((getCheckStatusMethod = MicroserviceServiceGrpc.getCheckStatusMethod) == null) {
      synchronized (MicroserviceServiceGrpc.class) {
        if ((getCheckStatusMethod = MicroserviceServiceGrpc.getCheckStatusMethod) == null) {
          MicroserviceServiceGrpc.getCheckStatusMethod = getCheckStatusMethod =
              io.grpc.MethodDescriptor.<com.joshuating.grpc.MicroserviceProto.CheckStatusRequest, com.joshuating.grpc.MicroserviceProto.CheckStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joshuating.grpc.MicroserviceProto.CheckStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joshuating.grpc.MicroserviceProto.CheckStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MicroserviceServiceMethodDescriptorSupplier("CheckStatus"))
              .build();
        }
      }
    }
    return getCheckStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MicroserviceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MicroserviceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MicroserviceServiceStub>() {
        @java.lang.Override
        public MicroserviceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MicroserviceServiceStub(channel, callOptions);
        }
      };
    return MicroserviceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MicroserviceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MicroserviceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MicroserviceServiceBlockingStub>() {
        @java.lang.Override
        public MicroserviceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MicroserviceServiceBlockingStub(channel, callOptions);
        }
      };
    return MicroserviceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MicroserviceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MicroserviceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MicroserviceServiceFutureStub>() {
        @java.lang.Override
        public MicroserviceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MicroserviceServiceFutureStub(channel, callOptions);
        }
      };
    return MicroserviceServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class MicroserviceServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void checkStatus(com.joshuating.grpc.MicroserviceProto.CheckStatusRequest request,
        io.grpc.stub.StreamObserver<com.joshuating.grpc.MicroserviceProto.CheckStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.joshuating.grpc.MicroserviceProto.CheckStatusRequest,
                com.joshuating.grpc.MicroserviceProto.CheckStatusResponse>(
                  this, METHODID_CHECK_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class MicroserviceServiceStub extends io.grpc.stub.AbstractAsyncStub<MicroserviceServiceStub> {
    private MicroserviceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MicroserviceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MicroserviceServiceStub(channel, callOptions);
    }

    /**
     */
    public void checkStatus(com.joshuating.grpc.MicroserviceProto.CheckStatusRequest request,
        io.grpc.stub.StreamObserver<com.joshuating.grpc.MicroserviceProto.CheckStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class MicroserviceServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MicroserviceServiceBlockingStub> {
    private MicroserviceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MicroserviceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MicroserviceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.joshuating.grpc.MicroserviceProto.CheckStatusResponse checkStatus(com.joshuating.grpc.MicroserviceProto.CheckStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class MicroserviceServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MicroserviceServiceFutureStub> {
    private MicroserviceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MicroserviceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MicroserviceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.joshuating.grpc.MicroserviceProto.CheckStatusResponse> checkStatus(
        com.joshuating.grpc.MicroserviceProto.CheckStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MicroserviceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MicroserviceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_STATUS:
          serviceImpl.checkStatus((com.joshuating.grpc.MicroserviceProto.CheckStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.joshuating.grpc.MicroserviceProto.CheckStatusResponse>) responseObserver);
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

  private static abstract class MicroserviceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MicroserviceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.joshuating.grpc.MicroserviceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MicroserviceService");
    }
  }

  private static final class MicroserviceServiceFileDescriptorSupplier
      extends MicroserviceServiceBaseDescriptorSupplier {
    MicroserviceServiceFileDescriptorSupplier() {}
  }

  private static final class MicroserviceServiceMethodDescriptorSupplier
      extends MicroserviceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MicroserviceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (MicroserviceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MicroserviceServiceFileDescriptorSupplier())
              .addMethod(getCheckStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
