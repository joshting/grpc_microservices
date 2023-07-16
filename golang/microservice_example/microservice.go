package main

import (
	"errors"
	"fmt"
	"io/ioutil"
	"log"
	"net"
	"strconv"
	"time"

	"github.com/joshting/golang_grpc/proto_generated/microservice"
	"github.com/joshting/golang_grpc/proto_generated/registry"
	"golang.org/x/net/context"
	"google.golang.org/grpc"
	"google.golang.org/grpc/connectivity"
	"google.golang.org/grpc/credentials/insecure"
	"gopkg.in/yaml.v3"
)

var config DiscoveryConfig
var regKey uint64
var registered bool = false

type DiscoveryConfig struct {
	ServiceId string `yaml:"serviceId"`
	Host      string `yaml:"host"`
	Port      int16  `yaml:"port"`
}

type grpcMicroserviceServer struct {
	microservice.UnimplementedMicroserviceServiceServer
}

func (s grpcMicroserviceServer) CheckStatus(ctx context.Context, req *microservice.CheckStatusRequest) (*microservice.CheckStatusResponse, error) {
	// check if regKey matches
	var err error = nil
	fmt.Printf("The request %v\n", req)
	if regKey != req.RegKey {
		err = errors.New("registration key does not match")
	}
	return &microservice.CheckStatusResponse{
		Status: 0,
	}, err
}

type ConnectionStatus struct {
	Conn          *grpc.ClientConn
	AfterRegister bool
}

func dialRegistry() ConnectionStatus {
	conn, err := grpc.Dial(":8321", grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		log.Fatalf("did not connect: %s\n", err)
	}

	// wait for 500 millisec, then it is a good indication if connection is successful or not
	time.Sleep(500 * time.Millisecond)
	if conn.GetState() != connectivity.Ready {
		return ConnectionStatus{Conn: conn, AfterRegister: false}
	}

	return ConnectionStatus{Conn: conn, AfterRegister: true}
}

func main() {

	yfile, err := ioutil.ReadFile("config.yaml")
	if err != nil {
		log.Fatalf("Cannot read yaml file: %s\n", err)
	}

	err2 := yaml.Unmarshal(yfile, &config)
	if err2 != nil {
		log.Fatalf("Cannot unmarshall yaml file: %s\n", err2)
	}

	var connStat ConnectionStatus = dialRegistry()
	var notReadyCount = 0
	go func() {
		for {
			select {
			case <-context.Background().Done():
				return
			default:
				if connStat.Conn.GetState() != connectivity.Ready {
					// if connectivity not ready, consider as not registered
					registered = false
					if connStat.AfterRegister {
						// if unable to connect after register - e.g. registry down after registering
						// if not ready status after count to 5, then reconnect
						if notReadyCount > 5 {
							fmt.Println("Connection lost! Possibly registry is down, attempt to reconnect")
							connStat = dialRegistry()
						} else {
							notReadyCount += 1
						}
					} else {
						// dial fail
						fmt.Println("Connectivity not ready! Attempting to reconnect")
						connStat = dialRegistry()
					}
				} else if !registered {
					fmt.Println("Connectivity ready! Connect")
					reg := registry.NewRegistryServiceClient(connStat.Conn)
					response, err4 := reg.Register(context.Background(),
						&registry.RegisterRequest{
							ServiceId: config.ServiceId,
							Host:      config.Host,
							Port:      uint32(config.Port),
							Timestamp: time.Now().UnixMilli(),
						})
					if err4 != nil {
						log.Fatalf("Error when calling Create: %s\n", err4)
					}
					log.Printf("Response received from registry: %v\n", response)
					regKey = response.RegKey
					registered = true
				}

				// wait for 2 seconds and try again
				time.Sleep(2 * time.Second)
			}
		}
	}()

	lis, err := net.Listen("tcp", ":"+strconv.FormatInt(int64(config.Port), 10))
	if err != nil {
		log.Fatalf("Cannot create listener: %s\n", err)
	}
	serverRegistrar := grpc.NewServer()
	service := &grpcMicroserviceServer{}
	microservice.RegisterMicroserviceServiceServer(serverRegistrar, service)
	err = serverRegistrar.Serve(lis)
	if err != nil {
		log.Fatalf("Failed to serve grpc: %s\n", err)
	}
}
