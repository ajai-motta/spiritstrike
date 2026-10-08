package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngine;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ClientEventsKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.reflect.TypeInfo;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: HttpClientEngine.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000b\u0010!\u001a\u00020 8BX\u0082\u0004¨\u0006\""}, d2 = {"Lio/ktor/client/engine/HttpClientEngine;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "Lio/ktor/client/request/HttpRequestData;", "data", "Lio/ktor/client/request/HttpResponseData;", "execute", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/HttpClient;", "client", "", "install", "(Lio/ktor/client/HttpClient;)V", "requestData", "executeWithinCallContext", "(Lio/ktor/client/request/HttpRequestData;)Lio/ktor/client/request/HttpResponseData;", "checkExtensions", "(Lio/ktor/client/request/HttpRequestData;)V", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "config", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "supportedCapabilities", "", "closed", "ktor-client-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HttpClientEngine extends CoroutineScope, Closeable {
    Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation);

    HttpClientEngineConfig getConfig();

    CoroutineDispatcher getDispatcher();

    Set<HttpClientEngineCapability<?>> getSupportedCapabilities();

    void install(HttpClient client);

    /* JADX INFO: compiled from: HttpClientEngine.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Set<HttpClientEngineCapability<?>> getSupportedCapabilities(HttpClientEngine httpClientEngine) {
            return SetsKt.emptySet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean getClosed(HttpClientEngine httpClientEngine) {
            return !(((Job) httpClientEngine.getCoroutineContext().get(Job.INSTANCE)) != null ? r1.isActive() : false);
        }

        public static void install(HttpClientEngine httpClientEngine, HttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            client.getSendPipeline().intercept(HttpSendPipeline.INSTANCE.getEngine(), new AnonymousClass1(client, httpClientEngine, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object executeWithinCallContext(io.ktor.client.engine.HttpClientEngine r10, io.ktor.client.request.HttpRequestData r11, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r12) throws java.lang.Throwable {
            /*
                boolean r0 = r12 instanceof io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                if (r0 == 0) goto L14
                r0 = r12
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = (io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r12 = r0.label
                int r12 = r12 - r2
                r0.label = r12
                goto L19
            L14:
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1 r0 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$1
                r0.<init>(r12)
            L19:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L42
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.throwOnFailure(r12)
                goto L83
            L2d:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L35:
                java.lang.Object r10 = r0.L$1
                r11 = r10
                io.ktor.client.request.HttpRequestData r11 = (io.ktor.client.request.HttpRequestData) r11
                java.lang.Object r10 = r0.L$0
                io.ktor.client.engine.HttpClientEngine r10 = (io.ktor.client.engine.HttpClientEngine) r10
                kotlin.ResultKt.throwOnFailure(r12)
                goto L56
            L42:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.Job r12 = r11.getExecutionContext()
                r0.L$0 = r10
                r0.L$1 = r11
                r0.label = r4
                java.lang.Object r12 = io.ktor.client.engine.HttpClientEngineKt.createCallContext(r10, r12, r0)
                if (r12 != r1) goto L56
                return r1
            L56:
                kotlin.coroutines.CoroutineContext r12 = (kotlin.coroutines.CoroutineContext) r12
                io.ktor.client.engine.KtorCallContextElement r2 = new io.ktor.client.engine.KtorCallContextElement
                r2.<init>(r12)
                kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
                kotlin.coroutines.CoroutineContext r5 = r12.plus(r2)
                r4 = r10
                kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
                io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2 r12 = new io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2
                r2 = 0
                r12.<init>(r10, r11, r2)
                r7 = r12
                kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
                r8 = 2
                r9 = 0
                r6 = 0
                kotlinx.coroutines.Deferred r10 = kotlinx.coroutines.BuildersKt.async$default(r4, r5, r6, r7, r8, r9)
                r0.L$0 = r2
                r0.L$1 = r2
                r0.label = r3
                java.lang.Object r12 = r10.await(r0)
                if (r12 != r1) goto L83
                return r1
            L83:
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.HttpClientEngine.DefaultImpls.executeWithinCallContext(io.ktor.client.engine.HttpClientEngine, io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void checkExtensions(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData) {
            for (HttpClientEngineCapability<?> httpClientEngineCapability : httpRequestData.getRequiredCapabilities$ktor_client_core()) {
                if (!httpClientEngine.getSupportedCapabilities().contains(httpClientEngineCapability)) {
                    throw new IllegalArgumentException(("Engine doesn't support " + httpClientEngineCapability).toString());
                }
            }
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.engine.HttpClientEngine$install$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpClientEngine.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "content"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$install$1", f = "HttpClientEngine.kt", i = {0, 0}, l = {154, 166}, m = "invokeSuspend", n = {"$this$intercept", "requestData"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PipelineContext<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
        final /* synthetic */ HttpClient $client;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ HttpClientEngine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HttpClient httpClient, HttpClientEngine httpClientEngine, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.$client = httpClient;
            this.this$0 = httpClientEngine;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(PipelineContext<Object, HttpRequestBuilder> pipelineContext, Object obj, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$client, this.this$0, continuation);
            anonymousClass1.L$0 = pipelineContext;
            anonymousClass1.L$1 = obj;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            KType kTypeTypeOf;
            HttpRequestData httpRequestDataBuild;
            PipelineContext pipelineContext;
            KType kTypeTypeOf2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PipelineContext pipelineContext2 = (PipelineContext) this.L$0;
                Object obj2 = this.L$1;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                httpRequestBuilder.takeFromWithExecutionContext((HttpRequestBuilder) pipelineContext2.getContext());
                if (obj2 == null) {
                    httpRequestBuilder.setBody(NullBody.INSTANCE);
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                    try {
                        kTypeTypeOf2 = Reflection.typeOf(Object.class);
                    } catch (Throwable unused) {
                        kTypeTypeOf2 = null;
                    }
                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf2));
                } else if (obj2 instanceof OutgoingContent) {
                    httpRequestBuilder.setBody(obj2);
                    httpRequestBuilder.setBodyType(null);
                } else {
                    httpRequestBuilder.setBody(obj2);
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                    try {
                        kTypeTypeOf = Reflection.typeOf(Object.class);
                    } catch (Throwable unused2) {
                        kTypeTypeOf = null;
                    }
                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kTypeTypeOf));
                }
                this.$client.getMonitor().raise(ClientEventsKt.getHttpRequestIsReadyForSending(), httpRequestBuilder);
                httpRequestDataBuild = httpRequestBuilder.build();
                httpRequestDataBuild.getAttributes().put(HttpClientEngineKt.getCLIENT_CONFIG(), this.$client.getConfig$ktor_client_core());
                HttpClientEngineKt.validateHeaders(httpRequestDataBuild);
                DefaultImpls.checkExtensions(this.this$0, httpRequestDataBuild);
                this.L$0 = pipelineContext2;
                this.L$1 = httpRequestDataBuild;
                this.label = 1;
                Object objExecuteWithinCallContext = DefaultImpls.executeWithinCallContext(this.this$0, httpRequestDataBuild, this);
                if (objExecuteWithinCallContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pipelineContext = pipelineContext2;
                obj = objExecuteWithinCallContext;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                httpRequestDataBuild = (HttpRequestData) this.L$1;
                pipelineContext = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            HttpClientCall httpClientCall = new HttpClientCall(this.$client, httpRequestDataBuild, (HttpResponseData) obj);
            final HttpResponse response = httpClientCall.getResponse();
            this.$client.getMonitor().raise(ClientEventsKt.getHttpResponseReceived(), response);
            Job job = JobKt.getJob(response.getCoroutineContext());
            final HttpClient httpClient = this.$client;
            job.invokeOnCompletion(new Function1() { // from class: io.ktor.client.engine.HttpClientEngine$install$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return HttpClientEngine.AnonymousClass1.invokeSuspend$lambda$2(httpClient, response, (Throwable) obj3);
                }
            });
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (pipelineContext.proceedWith(httpClientCall, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(HttpClient httpClient, HttpResponse httpResponse, Throwable th) {
            if (th != null) {
                httpClient.getMonitor().raise(ClientEventsKt.getHttpResponseCancelled(), httpResponse);
            }
            return Unit.INSTANCE;
        }
    }
}
