package com.joshuating.grpc;

import java.io.IOException;
import java.math.BigInteger;

import com.google.protobuf.UInt64Value;
import com.joshuating.grpc.proto.RegistryProto;
import com.joshuating.grpc.proto.RegistryServiceGrpc;

import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.StatusRuntimeException;

public class Microservice {

        private static ConnectionStatus stat;
        private static boolean registered = false;
        private static boolean statusRuntimeException = false;
        private static long regKey;

        private static ConnectionStatus dialRegistry() throws InterruptedException {
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8321)
                                .usePlaintext()
                                .build();
                RegistryServiceGrpc.RegistryServiceBlockingStub stub = RegistryServiceGrpc
                                .newBlockingStub(channel);
                return new ConnectionStatus(channel, stub);
        }

        public static void main(String[] args) throws IOException, InterruptedException {

                Server server = ServerBuilder.forPort(8323)
                                .addService(new CommandServiceImp()).build();
                server.start();
                System.out.println("Microservice started!");

                stat = dialRegistry();
                // server.awaitTermination();

                while (true) {
                        System.out.println("STATE: " + stat.getChannel().getState(false));
                        ConnectivityState currentState = stat.getChannel().getState(false);
                        if (currentState != ConnectivityState.READY || statusRuntimeException) {
                                System.out.println("Connectivity idle! Attempting to register");
                                try {
                                        RegistryProto.RegisterResponse response = stat.getStub()
                                                        .register(RegistryProto.RegisterRequest.newBuilder()
                                                                        .setServiceId("java-microservice")
                                                                        .setHost("localhost")
                                                                        .setPort(8323)
                                                                        .build());
                                        regKey = response.getRegKey();
                                        statusRuntimeException = false;
                                        registered = true;
                                        System.out.println("REGISTERED:\n" + response);
                                } catch (StatusRuntimeException e) {
                                        statusRuntimeException = true;
                                        System.out.println("StatusRuntimeException: " + e.getMessage());
                                }
                        } else {
                                // DO SOMETHING after registered
                        }
                        Thread.sleep(2000);
                }

        }
}