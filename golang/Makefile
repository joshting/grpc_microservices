.PHONY: proto

proto:
	@echo "generating grpc protobuf code inside proto_generated directory"
	@protoc --proto_path=proto_definition \
		--go_out=. \
		--go-grpc_out=. \
		command.proto registry.proto microservice.proto
	

run-registry:
	@echo "starting the example registry service"
	@cd registry_example && \
		go run registry.go

run-microservice:
	@echo "starting the example microservice"
	@cd microservice_example && \
		go run microservice.go