package org.example.proto

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import org.example.proto.TrainingsServiceGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for org.example.proto.TrainingsService.
 */
public object TrainingsServiceGrpcKt {
  public const val SERVICE_NAME: String = TrainingsServiceGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = getServiceDescriptor()

  public val createTrainingMethod: MethodDescriptor<CreateTrainingReq, Empty>
    @JvmStatic
    get() = TrainingsServiceGrpc.getCreateTrainingMethod()

  public val getTrainingMethod: MethodDescriptor<GetTrainingReq, GetTrainingResp>
    @JvmStatic
    get() = TrainingsServiceGrpc.getGetTrainingMethod()

  public val addExerciseToTrainingMethod: MethodDescriptor<AddExerciseReq, AddExerciseResp>
    @JvmStatic
    get() = TrainingsServiceGrpc.getAddExerciseToTrainingMethod()

  public val removeExerciseFromTrainingMethod: MethodDescriptor<RemoveExerciseReq, Empty>
    @JvmStatic
    get() = TrainingsServiceGrpc.getRemoveExerciseFromTrainingMethod()

  /**
   * A stub for issuing RPCs to a(n) org.example.proto.TrainingsService service as suspending
   * coroutines.
   */
  @StubFor(TrainingsServiceGrpc::class)
  public class TrainingsServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<TrainingsServiceCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): TrainingsServiceCoroutineStub =
        TrainingsServiceCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun createTraining(request: CreateTrainingReq, headers: Metadata = Metadata()):
        Empty = unaryRpc(
      channel,
      TrainingsServiceGrpc.getCreateTrainingMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getTraining(request: GetTrainingReq, headers: Metadata = Metadata()):
        GetTrainingResp = unaryRpc(
      channel,
      TrainingsServiceGrpc.getGetTrainingMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun addExerciseToTraining(request: AddExerciseReq, headers: Metadata =
        Metadata()): AddExerciseResp = unaryRpc(
      channel,
      TrainingsServiceGrpc.getAddExerciseToTrainingMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun removeExerciseFromTraining(request: RemoveExerciseReq, headers: Metadata =
        Metadata()): Empty = unaryRpc(
      channel,
      TrainingsServiceGrpc.getRemoveExerciseFromTrainingMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the org.example.proto.TrainingsService service based on Kotlin
   * coroutines.
   */
  public abstract class TrainingsServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for org.example.proto.TrainingsService.CreateTraining.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun createTraining(request: CreateTrainingReq): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.example.proto.TrainingsService.CreateTraining is unimplemented"))

    /**
     * Returns the response to an RPC for org.example.proto.TrainingsService.GetTraining.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getTraining(request: GetTrainingReq): GetTrainingResp = throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.example.proto.TrainingsService.GetTraining is unimplemented"))

    /**
     * Returns the response to an RPC for org.example.proto.TrainingsService.AddExerciseToTraining.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun addExerciseToTraining(request: AddExerciseReq): AddExerciseResp = throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.example.proto.TrainingsService.AddExerciseToTraining is unimplemented"))

    /**
     * Returns the response to an RPC for
     * org.example.proto.TrainingsService.RemoveExerciseFromTraining.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun removeExerciseFromTraining(request: RemoveExerciseReq): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method org.example.proto.TrainingsService.RemoveExerciseFromTraining is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = TrainingsServiceGrpc.getCreateTrainingMethod(),
      implementation = ::createTraining
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = TrainingsServiceGrpc.getGetTrainingMethod(),
      implementation = ::getTraining
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = TrainingsServiceGrpc.getAddExerciseToTrainingMethod(),
      implementation = ::addExerciseToTraining
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = TrainingsServiceGrpc.getRemoveExerciseFromTrainingMethod(),
      implementation = ::removeExerciseFromTraining
    )).build()
  }
}
