package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.events.EventDefinition;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import org.slf4j.Logger;

/* JADX INFO: compiled from: HttpRequestRetry.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\r\u001a\u00020\t*\u00020\fH\u0082@¢\u0006\u0004\b\r\u0010\u000e\"\u0018\u0010\u0011\u001a\u00060\u000fj\u0002`\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012\"\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d\"\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\"7\u0010'\u001a%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0$¢\u0006\u0002\b\u00040 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010#\"7\u0010(\u001a%\u0012!\u0012\u001f\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0$¢\u0006\u0002\b\u00040 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010#\"1\u0010+\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030)¢\u0006\u0002\b\u00040 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010#\"1\u0010.\u001a\u001f\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020-0)¢\u0006\u0002\b\u00040 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010#¨\u0006/"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpRequestRetryConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "retry", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/jvm/functions/Function1;)V", "", "", "isTimeoutException", "(Ljava/lang/Throwable;)Z", "Lio/ktor/client/statement/HttpResponse;", "throwOnInvalidResponseBody", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/HttpRetryEventData;", "HttpRequestRetryEvent", "Lio/ktor/events/EventDefinition;", "getHttpRequestRetryEvent", "()Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpRequestRetry", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestRetry", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRequestRetry$annotations", "()V", "Lio/ktor/util/AttributeKey;", "", "MaxRetriesPerRequestAttributeKey", "Lio/ktor/util/AttributeKey;", "Lkotlin/Function3;", "Lio/ktor/client/plugins/HttpRetryShouldRetryContext;", "Lio/ktor/client/request/HttpRequest;", "ShouldRetryPerRequestAttributeKey", "ShouldRetryOnExceptionPerRequestAttributeKey", "Lkotlin/Function2;", "Lio/ktor/client/plugins/HttpRetryModifyRequestContext;", "ModifyRequestPerRequestAttributeKey", "Lio/ktor/client/plugins/HttpRetryDelayContext;", "", "RetryDelayPerRequestAttributeKey", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HttpRequestRetryKt {
    private static final AttributeKey<Integer> MaxRetriesPerRequestAttributeKey;
    private static final AttributeKey<Function2<HttpRetryModifyRequestContext, HttpRequestBuilder, Unit>> ModifyRequestPerRequestAttributeKey;
    private static final AttributeKey<Function2<HttpRetryDelayContext, Integer, Long>> RetryDelayPerRequestAttributeKey;
    private static final AttributeKey<Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean>> ShouldRetryOnExceptionPerRequestAttributeKey;
    private static final AttributeKey<Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean>> ShouldRetryPerRequestAttributeKey;
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRequestRetry");
    private static final EventDefinition<HttpRetryEventData> HttpRequestRetryEvent = new EventDefinition<>();
    private static final ClientPlugin<HttpRequestRetryConfig> HttpRequestRetry = CreatePluginUtilsKt.createClientPlugin("RetryFeature", HttpRequestRetryKt$HttpRequestRetry$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.HttpRequestRetryKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return HttpRequestRetryKt.HttpRequestRetry$lambda$1((ClientPluginBuilder) obj);
        }
    });

    public static /* synthetic */ void getHttpRequestRetry$annotations() {
    }

    static {
        KType kTypeTypeOf;
        KType kTypeTypeOf2;
        KType kTypeTypeOf3;
        KType kTypeTypeOf4;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Integer.class);
        KType kTypeTypeOf5 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(Integer.TYPE);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        MaxRetriesPerRequestAttributeKey = new AttributeKey<>("MaxRetriesPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Function3.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(Function3.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(HttpRetryShouldRetryContext.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(HttpRequest.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(HttpResponse.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Boolean.TYPE)));
        } catch (Throwable unused2) {
            kTypeTypeOf2 = null;
        }
        ShouldRetryPerRequestAttributeKey = new AttributeKey<>("ShouldRetryPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Function3.class);
        try {
            kTypeTypeOf3 = Reflection.typeOf(Function3.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(HttpRetryShouldRetryContext.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(HttpRequestBuilder.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Throwable.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Boolean.TYPE)));
        } catch (Throwable unused3) {
            kTypeTypeOf3 = null;
        }
        ShouldRetryOnExceptionPerRequestAttributeKey = new AttributeKey<>("ShouldRetryOnExceptionPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass3, kTypeTypeOf3));
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Function2.class);
        try {
            kTypeTypeOf4 = Reflection.typeOf(Function2.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(HttpRetryModifyRequestContext.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(HttpRequestBuilder.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Unit.class)));
        } catch (Throwable unused4) {
            kTypeTypeOf4 = null;
        }
        ModifyRequestPerRequestAttributeKey = new AttributeKey<>("ModifyRequestPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass4, kTypeTypeOf4));
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Function2.class);
        try {
            kTypeTypeOf5 = Reflection.typeOf(Function2.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(HttpRetryDelayContext.class)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Long.TYPE)));
        } catch (Throwable unused5) {
        }
        RetryDelayPerRequestAttributeKey = new AttributeKey<>("RetryDelayPerRequestAttributeKey", new TypeInfo(orCreateKotlinClass5, kTypeTypeOf5));
    }

    public static final EventDefinition<HttpRetryEventData> getHttpRequestRetryEvent() {
        return HttpRequestRetryEvent;
    }

    public static final ClientPlugin<HttpRequestRetryConfig> getHttpRequestRetry() {
        return HttpRequestRetry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRequestRetry$lambda$1(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        Function3<HttpRetryShouldRetryContext, HttpRequest, HttpResponse, Boolean> shouldRetry$ktor_client_core = ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getShouldRetry$ktor_client_core();
        Function3<HttpRetryShouldRetryContext, HttpRequestBuilder, Throwable, Boolean> shouldRetryOnException$ktor_client_core = ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getShouldRetryOnException$ktor_client_core();
        Function2<HttpRetryDelayContext, Integer, Long> delayMillis$ktor_client_core = ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getDelayMillis$ktor_client_core();
        Function2<Long, Continuation<? super Unit>, Object> delay$ktor_client_core = ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getDelay$ktor_client_core();
        createClientPlugin.on(Send.INSTANCE, new HttpRequestRetryKt$HttpRequestRetry$2$1(shouldRetry$ktor_client_core, shouldRetryOnException$ktor_client_core, ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getMaxRetries(), delayMillis$ktor_client_core, ((HttpRequestRetryConfig) createClientPlugin.getPluginConfig()).getModifyRequest(), createClientPlugin, delay$ktor_client_core, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpRequestRetry$lambda$1$shouldRetry(int i, int i2, Function3<? super HttpRetryShouldRetryContext, ? super HttpRequest, ? super HttpResponse, Boolean> function3, HttpClientCall httpClientCall) {
        return i < i2 && function3.invoke(new HttpRetryShouldRetryContext(i + 1), httpClientCall.getRequest(), httpClientCall.getResponse()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HttpRequestRetry$lambda$1$shouldRetryOnException(int i, int i2, Function3<? super HttpRetryShouldRetryContext, ? super HttpRequestBuilder, ? super Throwable, Boolean> function3, HttpRequestBuilder httpRequestBuilder, Throwable th) {
        return i < i2 && function3.invoke(new HttpRetryShouldRetryContext(i + 1), httpRequestBuilder, th).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpRequestBuilder HttpRequestRetry$lambda$1$prepareRequest(HttpRequestBuilder httpRequestBuilder) {
        final HttpRequestBuilder httpRequestBuilderTakeFrom = new HttpRequestBuilder().takeFrom(httpRequestBuilder);
        httpRequestBuilder.getExecutionContext().invokeOnCompletion(new Function1() { // from class: io.ktor.client.plugins.HttpRequestRetryKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HttpRequestRetryKt.HttpRequestRetry$lambda$1$prepareRequest$lambda$0(httpRequestBuilderTakeFrom, (Throwable) obj);
            }
        });
        return httpRequestBuilderTakeFrom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRequestRetry$lambda$1$prepareRequest$lambda$0(HttpRequestBuilder httpRequestBuilder, Throwable th) {
        Job executionContext = httpRequestBuilder.getExecutionContext();
        Intrinsics.checkNotNull(executionContext, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        CompletableJob completableJob = (CompletableJob) executionContext;
        if (th == null) {
            completableJob.complete();
        } else {
            completableJob.completeExceptionally(th);
        }
        return Unit.INSTANCE;
    }

    public static final void retry(HttpRequestBuilder httpRequestBuilder, Function1<? super HttpRequestRetryConfig, Unit> block) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        HttpRequestRetryConfig httpRequestRetryConfig = new HttpRequestRetryConfig();
        block.invoke(httpRequestRetryConfig);
        httpRequestBuilder.getAttributes().put(ShouldRetryPerRequestAttributeKey, httpRequestRetryConfig.getShouldRetry$ktor_client_core());
        httpRequestBuilder.getAttributes().put(ShouldRetryOnExceptionPerRequestAttributeKey, httpRequestRetryConfig.getShouldRetryOnException$ktor_client_core());
        httpRequestBuilder.getAttributes().put(RetryDelayPerRequestAttributeKey, httpRequestRetryConfig.getDelayMillis$ktor_client_core());
        httpRequestBuilder.getAttributes().put(MaxRetriesPerRequestAttributeKey, Integer.valueOf(httpRequestRetryConfig.getMaxRetries()));
        httpRequestBuilder.getAttributes().put(ModifyRequestPerRequestAttributeKey, httpRequestRetryConfig.getModifyRequest());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isTimeoutException(Throwable th) {
        Throwable thUnwrapCancellationException = ExceptionUtilsJvmKt.unwrapCancellationException(th);
        return (thUnwrapCancellationException instanceof HttpRequestTimeoutException) || (thUnwrapCancellationException instanceof ConnectTimeoutException) || (thUnwrapCancellationException instanceof SocketTimeoutException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object throwOnInvalidResponseBody(HttpResponse httpResponse, Continuation<? super Boolean> continuation) {
        return DoubleReceivePluginKt.isSaved(httpResponse) ? ByteReadChannel.DefaultImpls.awaitContent$default(httpResponse.getRawContent(), 0, continuation, 1, null) : Boxing.boxBoolean(false);
    }
}
