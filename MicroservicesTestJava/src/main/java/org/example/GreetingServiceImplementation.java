package org.example;

import io.grpc.stub.StreamObserver;
import org.example.grpc.GreetingServiceGrpc;
import org.example.grpc.GreetingServiceOuterClass;

public class GreetingServiceImplementation extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver){
        System.out.println("REQUEST: " + request);

        GreetingServiceOuterClass.HelloResponse.Builder responseBuilder = GreetingServiceOuterClass.HelloResponse.newBuilder();
        GreetingServiceOuterClass.HelloResponse response = responseBuilder
                .setGreeting("Hello from server, " + request.getName())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
