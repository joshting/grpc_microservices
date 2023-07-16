.PHONY: proto

proto:
	protoc --proto_path=proto_definition \
		--go_out=. \
		--go-grpc_out=. \
		command.proto registry.proto microservice.proto