package com.joshuating.grpc;

import java.io.IOException;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class Microservice {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8323)
                .addService(new CommandServiceImp()).build();
        server.start();
        System.out.println("Microservice started!");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8321)
                .usePlaintext()
                .build();

        RegistryServiceGrpc.RegistryServiceBlockingStub stub = RegistryServiceGrpc.newBlockingStub(channel);

        RegistryProto.RegisterResponse response = stub.register(RegistryProto.RegisterRequest.newBuilder()
                .setServiceId("java-microservice")
                .setHost("localhost")
                .setPort(8323)
                .build());

        System.out.println("Response received from registry:\n" + response);
        channel.shutdown();

        server.awaitTermination();
    }
}