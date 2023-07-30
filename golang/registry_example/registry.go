package main

import (
	"context"
	"fmt"
	"log"
	"math/rand"
	"net"
	"strconv"
	"time"

	"github.com/joshting/golang_grpc/proto_generated/microservice"
	"github.com/joshting/golang_grpc/proto_generated/registry"
	"github.com/madflojo/tasks"
	"google.golang.org/grpc"
	"google.golang.org/grpc/connectivity"
	"google.golang.org/grpc/credentials/insecure"
)

type Registration struct {
	ServiceId  string
	Host       string
	Port       uint32
	RegKey     uint64
	Client     microservice.MicroserviceServiceClient
	Connection *grpc.ClientConn
}

var registryMap = make(map[string]Registration)

func randomUint64() uint64 {
	return uint64(rand.Uint32())<<32 + uint64(rand.Uint32())
}

// type myCommandServiceServer struct {
// 	command.UnimplementedCommandServiceServer
// }

// func (s myCommandServiceServer) Create(ctx context.Context, req *command.CommandRequest) (*command.CommandResponse, error) {
// 	fmt.Printf("Received request: %v\n", req.Arguments)
// 	return &command.CommandResponse{
// 		Command: "testing",
// 		Results: req.Arguments,
// 	}, nil
// }

func CheckAlive(reg Registration) {
	fmt.Printf("state %v", reg.Connection.GetState())
	if reg.Connection.GetState() != connectivity.Ready {
		// if connectivity not ready, close it so that service can reconnect
		reg.Connection.Close()
		// delete from map
		delete(registryMap, reg.ServiceId)
	}
}

type grpcRegistryServiceServer struct {
	registry.UnimplementedRegistryServiceServer
}

func (s grpcRegistryServiceServer) Register(ctx context.Context, req *registry.RegisterRequest) (*registry.RegisterResponse, error) {
	fmt.Printf("Received registration request: %v\n", req.ServiceId)
	_, ok := registryMap[req.ServiceId]
	// If the key exists
	if !ok {
		var conn *grpc.ClientConn
		conn, err := grpc.Dial(":"+strconv.FormatInt(int64(req.Port), 10), grpc.WithTransportCredentials(insecure.NewCredentials()))
		if err != nil {
			log.Fatalf("did not connect: %s", err)
		} else {
			log.Printf("state after dial: " + conn.GetState().String())
		}

		var client = microservice.NewMicroserviceServiceClient(conn)
		registryMap[req.ServiceId] = Registration{
			ServiceId:  req.ServiceId,
			Host:       req.Host,
			Port:       req.Port,
			RegKey:     randomUint64(),
			Client:     client,
			Connection: conn,
		}
	}
	fmt.Printf("%v\n", registryMap)
	return &registry.RegisterResponse{
		Success: true,
		RegKey:  registryMap[req.ServiceId].RegKey,
	}, nil
}

func main() {

	// Check on registered microservices every 5 seconds
	// Start the Scheduler
	scheduler := tasks.New()
	defer scheduler.Stop()

	// Add a task
	id, err := scheduler.Add(&tasks.Task{
		Interval:   time.Duration(5 * time.Second),
		StartAfter: time.Now().Add(1 * time.Second),
		TaskFunc: func() error {
			for _, val := range registryMap {
				CheckAlive(val)
			}
			fmt.Printf("Registered services:\n%v\n", registryMap)
			return nil
		},
	})
	if err != nil {
		// Do Stuff
		fmt.Printf("id: %v\n", id)
	}

	fmt.Println("setup tcp listener")
	lis, err := net.Listen("tcp", ":8321")
	if err != nil {
		log.Fatalf("Cannot create listener: %s", err)
	}
	serverRegistrar := grpc.NewServer()
	service := &grpcRegistryServiceServer{}
	registry.RegisterRegistryServiceServer(serverRegistrar, service)
	err = serverRegistrar.Serve(lis)
	if err != nil {
		log.Fatalf("Failed to serve grpc: %s", err)
	}
}
