package com.joshuating.grpc;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8321)
                .addService(new CommandServiceImp()).build();

        System.out.println("Starting GRPC server...");
        server.start();
        System.out.println("Server GRPC started!");
        server.awaitTermination();
    }
}