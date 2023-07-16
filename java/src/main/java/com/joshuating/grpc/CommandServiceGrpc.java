package com.joshuating.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: command.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CommandServiceGrpc {

  private CommandServiceGrpc() {}

  public static final String SERVICE_NAME = "CommandService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.joshuating.grpc.CommandProto.CommandRequest,
      com.joshuating.grpc.CommandProto.CommandResponse> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.joshuating.grpc.CommandProto.CommandRequest.class,
      responseType = com.joshuating.grpc.CommandProto.CommandResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.joshuating.grpc.CommandProto.CommandRequest,
      com.joshuating.grpc.CommandProto.CommandResponse> getCreateMethod() {
    io.grpc.MethodDescriptor<com.joshuating.grpc.CommandProto.CommandRequest, com.joshuating.grpc.CommandProto.CommandResponse> getCreateMethod;
    if ((getCreateMethod = CommandServiceGrpc.getCreateMethod) == null) {
      synchronized (CommandServiceGrpc.class) {
        if ((getCreateMethod = CommandServiceGrpc.getCreateMethod) == null) {
          CommandServiceGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<com.joshuating.grpc.CommandProto.CommandRequest, com.joshuating.grpc.CommandProto.CommandResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joshuating.grpc.CommandProto.CommandRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.joshuating.grpc.CommandProto.CommandResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommandServiceMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommandServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommandServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommandServiceStub>() {
        @java.lang.Override
        public CommandServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommandServiceStub(channel, callOptions);
        }
      };
    return CommandServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommandServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommandServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommandServiceBlockingStub>() {
        @java.lang.Override
        public CommandServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommandServiceBlockingStub(channel, callOptions);
        }
      };
    return CommandServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommandServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommandServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommandServiceFutureStub>() {
        @java.lang.Override
        public CommandServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommandServiceFutureStub(channel, callOptions);
        }
      };
    return CommandServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommandServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void create(com.joshuating.grpc.CommandProto.CommandRequest request,
        io.grpc.stub.StreamObserver<com.joshuating.grpc.CommandProto.CommandResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.joshuating.grpc.CommandProto.CommandRequest,
                com.joshuating.grpc.CommandProto.CommandResponse>(
                  this, METHODID_CREATE)))
          .build();
    }
  }

  /**
   */
  public static final class CommandServiceStub extends io.grpc.stub.AbstractAsyncStub<CommandServiceStub> {
    private CommandServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommandServiceStub(channel, callOptions);
    }

    /**
     */
    public void create(com.joshuating.grpc.CommandProto.CommandRequest request,
        io.grpc.stub.StreamObserver<com.joshuating.grpc.CommandProto.CommandResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommandServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommandServiceBlockingStub> {
    private CommandServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommandServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.joshuating.grpc.CommandProto.CommandResponse create(com.joshuating.grpc.CommandProto.CommandRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommandServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CommandServiceFutureStub> {
    private CommandServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommandServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommandServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.joshuating.grpc.CommandProto.CommandResponse> create(
        com.joshuating.grpc.CommandProto.CommandRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommandServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommandServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((com.joshuating.grpc.CommandProto.CommandRequest) request,
              (io.grpc.stub.StreamObserver<com.joshuating.grpc.CommandProto.CommandResponse>) responseObserver);
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

  private static abstract class CommandServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommandServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.joshuating.grpc.CommandProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommandService");
    }
  }

  private static final class CommandServiceFileDescriptorSupplier
      extends CommandServiceBaseDescriptorSupplier {
    CommandServiceFileDescriptorSupplier() {}
  }

  private static final class CommandServiceMethodDescriptorSupplier
      extends CommandServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommandServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CommandServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommandServiceFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
