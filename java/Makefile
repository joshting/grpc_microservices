.PHONY: proto

proto:
	@echo "generating grpc protobuf code and packaging executable jar"
	mvn clean package

run-microservice:
	@echo "starting the example microservice"
	@mvn compile exec:java -Dexec.mainClass=com.joshuating.grpc.Microservice