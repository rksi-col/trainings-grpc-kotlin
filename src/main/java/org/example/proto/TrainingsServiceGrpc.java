package org.example.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.9.1)",
    comments = "Source: trainings.proto")
public final class TrainingsServiceGrpc {

  private TrainingsServiceGrpc() {}

  public static final String SERVICE_NAME = "org.example.proto.TrainingsService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateTrainingMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.example.proto.CreateTrainingReq,
      org.example.proto.Empty> METHOD_CREATE_TRAINING = getCreateTrainingMethod();

  private static volatile io.grpc.MethodDescriptor<org.example.proto.CreateTrainingReq,
      org.example.proto.Empty> getCreateTrainingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.example.proto.CreateTrainingReq,
      org.example.proto.Empty> getCreateTrainingMethod() {
    io.grpc.MethodDescriptor<org.example.proto.CreateTrainingReq, org.example.proto.Empty> getCreateTrainingMethod;
    if ((getCreateTrainingMethod = TrainingsServiceGrpc.getCreateTrainingMethod) == null) {
      synchronized (TrainingsServiceGrpc.class) {
        if ((getCreateTrainingMethod = TrainingsServiceGrpc.getCreateTrainingMethod) == null) {
          TrainingsServiceGrpc.getCreateTrainingMethod = getCreateTrainingMethod = 
              io.grpc.MethodDescriptor.<org.example.proto.CreateTrainingReq, org.example.proto.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.example.proto.TrainingsService", "CreateTraining"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.proto.CreateTrainingReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.proto.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new TrainingsServiceMethodDescriptorSupplier("CreateTraining"))
                  .build();
          }
        }
     }
     return getCreateTrainingMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTrainingMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.example.proto.GetTrainingReq,
      org.example.proto.GetTrainingResp> METHOD_GET_TRAINING = getGetTrainingMethod();

  private static volatile io.grpc.MethodDescriptor<org.example.proto.GetTrainingReq,
      org.example.proto.GetTrainingResp> getGetTrainingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.example.proto.GetTrainingReq,
      org.example.proto.GetTrainingResp> getGetTrainingMethod() {
    io.grpc.MethodDescriptor<org.example.proto.GetTrainingReq, org.example.proto.GetTrainingResp> getGetTrainingMethod;
    if ((getGetTrainingMethod = TrainingsServiceGrpc.getGetTrainingMethod) == null) {
      synchronized (TrainingsServiceGrpc.class) {
        if ((getGetTrainingMethod = TrainingsServiceGrpc.getGetTrainingMethod) == null) {
          TrainingsServiceGrpc.getGetTrainingMethod = getGetTrainingMethod = 
              io.grpc.MethodDescriptor.<org.example.proto.GetTrainingReq, org.example.proto.GetTrainingResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.example.proto.TrainingsService", "GetTraining"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.proto.GetTrainingReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.proto.GetTrainingResp.getDefaultInstance()))
                  .setSchemaDescriptor(new TrainingsServiceMethodDescriptorSupplier("GetTraining"))
                  .build();
          }
        }
     }
     return getGetTrainingMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAddExerciseToTrainingMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.example.proto.AddExerciseReq,
      org.example.proto.AddExerciseResp> METHOD_ADD_EXERCISE_TO_TRAINING = getAddExerciseToTrainingMethod();

  private static volatile io.grpc.MethodDescriptor<org.example.proto.AddExerciseReq,
      org.example.proto.AddExerciseResp> getAddExerciseToTrainingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.example.proto.AddExerciseReq,
      org.example.proto.AddExerciseResp> getAddExerciseToTrainingMethod() {
    io.grpc.MethodDescriptor<org.example.proto.AddExerciseReq, org.example.proto.AddExerciseResp> getAddExerciseToTrainingMethod;
    if ((getAddExerciseToTrainingMethod = TrainingsServiceGrpc.getAddExerciseToTrainingMethod) == null) {
      synchronized (TrainingsServiceGrpc.class) {
        if ((getAddExerciseToTrainingMethod = TrainingsServiceGrpc.getAddExerciseToTrainingMethod) == null) {
          TrainingsServiceGrpc.getAddExerciseToTrainingMethod = getAddExerciseToTrainingMethod = 
              io.grpc.MethodDescriptor.<org.example.proto.AddExerciseReq, org.example.proto.AddExerciseResp>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.example.proto.TrainingsService", "AddExerciseToTraining"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.proto.AddExerciseReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.proto.AddExerciseResp.getDefaultInstance()))
                  .setSchemaDescriptor(new TrainingsServiceMethodDescriptorSupplier("AddExerciseToTraining"))
                  .build();
          }
        }
     }
     return getAddExerciseToTrainingMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRemoveExerciseFromTrainingMethod()} instead. 
  public static final io.grpc.MethodDescriptor<org.example.proto.RemoveExerciseReq,
      org.example.proto.Empty> METHOD_REMOVE_EXERCISE_FROM_TRAINING = getRemoveExerciseFromTrainingMethod();

  private static volatile io.grpc.MethodDescriptor<org.example.proto.RemoveExerciseReq,
      org.example.proto.Empty> getRemoveExerciseFromTrainingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<org.example.proto.RemoveExerciseReq,
      org.example.proto.Empty> getRemoveExerciseFromTrainingMethod() {
    io.grpc.MethodDescriptor<org.example.proto.RemoveExerciseReq, org.example.proto.Empty> getRemoveExerciseFromTrainingMethod;
    if ((getRemoveExerciseFromTrainingMethod = TrainingsServiceGrpc.getRemoveExerciseFromTrainingMethod) == null) {
      synchronized (TrainingsServiceGrpc.class) {
        if ((getRemoveExerciseFromTrainingMethod = TrainingsServiceGrpc.getRemoveExerciseFromTrainingMethod) == null) {
          TrainingsServiceGrpc.getRemoveExerciseFromTrainingMethod = getRemoveExerciseFromTrainingMethod = 
              io.grpc.MethodDescriptor.<org.example.proto.RemoveExerciseReq, org.example.proto.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "org.example.proto.TrainingsService", "RemoveExerciseFromTraining"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.proto.RemoveExerciseReq.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.example.proto.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new TrainingsServiceMethodDescriptorSupplier("RemoveExerciseFromTraining"))
                  .build();
          }
        }
     }
     return getRemoveExerciseFromTrainingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TrainingsServiceStub newStub(io.grpc.Channel channel) {
    return new TrainingsServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TrainingsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TrainingsServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TrainingsServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TrainingsServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TrainingsServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createTraining(org.example.proto.CreateTrainingReq request,
        io.grpc.stub.StreamObserver<org.example.proto.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTrainingMethod(), responseObserver);
    }

    /**
     */
    public void getTraining(org.example.proto.GetTrainingReq request,
        io.grpc.stub.StreamObserver<org.example.proto.GetTrainingResp> responseObserver) {
      asyncUnimplementedUnaryCall(getGetTrainingMethod(), responseObserver);
    }

    /**
     */
    public void addExerciseToTraining(org.example.proto.AddExerciseReq request,
        io.grpc.stub.StreamObserver<org.example.proto.AddExerciseResp> responseObserver) {
      asyncUnimplementedUnaryCall(getAddExerciseToTrainingMethod(), responseObserver);
    }

    /**
     */
    public void removeExerciseFromTraining(org.example.proto.RemoveExerciseReq request,
        io.grpc.stub.StreamObserver<org.example.proto.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getRemoveExerciseFromTrainingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTrainingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.proto.CreateTrainingReq,
                org.example.proto.Empty>(
                  this, METHODID_CREATE_TRAINING)))
          .addMethod(
            getGetTrainingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.proto.GetTrainingReq,
                org.example.proto.GetTrainingResp>(
                  this, METHODID_GET_TRAINING)))
          .addMethod(
            getAddExerciseToTrainingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.proto.AddExerciseReq,
                org.example.proto.AddExerciseResp>(
                  this, METHODID_ADD_EXERCISE_TO_TRAINING)))
          .addMethod(
            getRemoveExerciseFromTrainingMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                org.example.proto.RemoveExerciseReq,
                org.example.proto.Empty>(
                  this, METHODID_REMOVE_EXERCISE_FROM_TRAINING)))
          .build();
    }
  }

  /**
   */
  public static final class TrainingsServiceStub extends io.grpc.stub.AbstractStub<TrainingsServiceStub> {
    private TrainingsServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrainingsServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainingsServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrainingsServiceStub(channel, callOptions);
    }

    /**
     */
    public void createTraining(org.example.proto.CreateTrainingReq request,
        io.grpc.stub.StreamObserver<org.example.proto.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTrainingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTraining(org.example.proto.GetTrainingReq request,
        io.grpc.stub.StreamObserver<org.example.proto.GetTrainingResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTrainingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addExerciseToTraining(org.example.proto.AddExerciseReq request,
        io.grpc.stub.StreamObserver<org.example.proto.AddExerciseResp> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddExerciseToTrainingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void removeExerciseFromTraining(org.example.proto.RemoveExerciseReq request,
        io.grpc.stub.StreamObserver<org.example.proto.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRemoveExerciseFromTrainingMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TrainingsServiceBlockingStub extends io.grpc.stub.AbstractStub<TrainingsServiceBlockingStub> {
    private TrainingsServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrainingsServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainingsServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrainingsServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.example.proto.Empty createTraining(org.example.proto.CreateTrainingReq request) {
      return blockingUnaryCall(
          getChannel(), getCreateTrainingMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.proto.GetTrainingResp getTraining(org.example.proto.GetTrainingReq request) {
      return blockingUnaryCall(
          getChannel(), getGetTrainingMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.proto.AddExerciseResp addExerciseToTraining(org.example.proto.AddExerciseReq request) {
      return blockingUnaryCall(
          getChannel(), getAddExerciseToTrainingMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.example.proto.Empty removeExerciseFromTraining(org.example.proto.RemoveExerciseReq request) {
      return blockingUnaryCall(
          getChannel(), getRemoveExerciseFromTrainingMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TrainingsServiceFutureStub extends io.grpc.stub.AbstractStub<TrainingsServiceFutureStub> {
    private TrainingsServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TrainingsServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TrainingsServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TrainingsServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.proto.Empty> createTraining(
        org.example.proto.CreateTrainingReq request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTrainingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.proto.GetTrainingResp> getTraining(
        org.example.proto.GetTrainingReq request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTrainingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.proto.AddExerciseResp> addExerciseToTraining(
        org.example.proto.AddExerciseReq request) {
      return futureUnaryCall(
          getChannel().newCall(getAddExerciseToTrainingMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.example.proto.Empty> removeExerciseFromTraining(
        org.example.proto.RemoveExerciseReq request) {
      return futureUnaryCall(
          getChannel().newCall(getRemoveExerciseFromTrainingMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TRAINING = 0;
  private static final int METHODID_GET_TRAINING = 1;
  private static final int METHODID_ADD_EXERCISE_TO_TRAINING = 2;
  private static final int METHODID_REMOVE_EXERCISE_FROM_TRAINING = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TrainingsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TrainingsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TRAINING:
          serviceImpl.createTraining((org.example.proto.CreateTrainingReq) request,
              (io.grpc.stub.StreamObserver<org.example.proto.Empty>) responseObserver);
          break;
        case METHODID_GET_TRAINING:
          serviceImpl.getTraining((org.example.proto.GetTrainingReq) request,
              (io.grpc.stub.StreamObserver<org.example.proto.GetTrainingResp>) responseObserver);
          break;
        case METHODID_ADD_EXERCISE_TO_TRAINING:
          serviceImpl.addExerciseToTraining((org.example.proto.AddExerciseReq) request,
              (io.grpc.stub.StreamObserver<org.example.proto.AddExerciseResp>) responseObserver);
          break;
        case METHODID_REMOVE_EXERCISE_FROM_TRAINING:
          serviceImpl.removeExerciseFromTraining((org.example.proto.RemoveExerciseReq) request,
              (io.grpc.stub.StreamObserver<org.example.proto.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TrainingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TrainingsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.example.proto.Trainings.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TrainingsService");
    }
  }

  private static final class TrainingsServiceFileDescriptorSupplier
      extends TrainingsServiceBaseDescriptorSupplier {
    TrainingsServiceFileDescriptorSupplier() {}
  }

  private static final class TrainingsServiceMethodDescriptorSupplier
      extends TrainingsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TrainingsServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TrainingsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TrainingsServiceFileDescriptorSupplier())
              .addMethod(getCreateTrainingMethod())
              .addMethod(getGetTrainingMethod())
              .addMethod(getAddExerciseToTrainingMethod())
              .addMethod(getRemoveExerciseFromTrainingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
