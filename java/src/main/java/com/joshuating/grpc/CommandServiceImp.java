package com.joshuating.grpc;

import com.joshuating.grpc.proto.CommandProto;
import com.joshuating.grpc.proto.CommandServiceGrpc.CommandServiceImplBase;

import io.grpc.stub.StreamObserver;

public class CommandServiceImp extends CommandServiceImplBase {

    @Override
    public void create(CommandProto.CommandRequest request,
            StreamObserver<CommandProto.CommandResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);

        CommandProto.CommandResponse response = CommandProto.CommandResponse.newBuilder()
                .setCommand(request.getCommand())
                .addResults("result 1")
                .addResults("result 2")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
