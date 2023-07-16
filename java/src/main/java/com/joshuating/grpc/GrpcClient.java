package com.joshuating.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8321)
                .usePlaintext()
                .build();

        CommandServiceGrpc.CommandServiceBlockingStub stub = CommandServiceGrpc.newBlockingStub(channel);

        CommandProto.CommandResponse response = stub.create(CommandProto.CommandRequest.newBuilder()
                .setCommand("testing")
                .addArguments("first argument")
                .addArguments("second argument")
                .build());

        System.out.println("Response received from server:\n" + response);

        channel.shutdown();
    }
}