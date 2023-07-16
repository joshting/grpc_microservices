Run the following to generate protobuf protocol defintions

It is possible to run protoc multiple times to achieve code generated in the correct directory corresponding to its golang package such as follows:
```
protoc --proto_path=proto_definition \
--go_out=<package_or_directory_name> \
--go_opt=paths=source_relative \
--go-grpc_out=<package_or_directory_name> \
--go-grpc_opt=paths=source_relative <input_file>
```

option go_package = "proto_generated/command";
However, we can make use of the fact that by not specifying _paths=source_relative_, it will generate directory tree based on the _go_package_ in the input files.  The command is then simplified to the following:

```
protoc --proto_path=proto_definition \
--go_out=. \
--go-grpc_out=. \
command.proto registry.proto
```