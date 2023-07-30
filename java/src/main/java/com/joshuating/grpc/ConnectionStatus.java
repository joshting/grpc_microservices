package com.joshuating.grpc;

import com.joshuating.grpc.proto.RegistryServiceGrpc;

import io.grpc.ManagedChannel;

public class ConnectionStatus {

    private ManagedChannel channel;
    // private boolean afterRegister;
    private RegistryServiceGrpc.RegistryServiceBlockingStub stub;

    public ConnectionStatus(ManagedChannel channel,
            RegistryServiceGrpc.RegistryServiceBlockingStub stub) {
        this.channel = channel;
        // this.afterRegister = afterRegister;
        this.stub = stub;
    }

    public ManagedChannel getChannel() {
        return channel;
    }

    // public boolean isAfterRegister() {
    // return afterRegister;
    // }

    public RegistryServiceGrpc.RegistryServiceBlockingStub getStub() {
        return stub;
    }

}
