package io.ktor.client.plugins.sse;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.AttributeKey;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.logging.LoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.slf4j.Logger;

/* JADX INFO: compiled from: SSE.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a1\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u001e\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"#\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\" \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\" \u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f¨\u0006#"}, d2 = {"", "T", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/util/AttributeKey;", "attributeKey", "getAttributeValue", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/util/AttributeKey;)Ljava/lang/Object;", "Lio/ktor/client/statement/HttpResponse;", "response", "", "checkResponse", "(Lio/ktor/client/statement/HttpResponse;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "getLOGGER", "()Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/sse/SSEConfig;", "SSE", "Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getSSE$annotations", "()V", "Lio/ktor/client/HttpClient;", "SSEClientForReconnectionAttr", "Lio/ktor/util/AttributeKey;", "getSSEClientForReconnectionAttr", "()Lio/ktor/util/AttributeKey;", "", "SSEReconnectionRequestAttr", "getSSEReconnectionRequestAttr", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SSEKt {
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.sse.SSE");
    private static final ClientPlugin<SSEConfig> SSE = CreatePluginUtilsKt.createClientPlugin("SSE", SSEKt$SSE$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.sse.SSEKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SSEKt.SSE$lambda$0((ClientPluginBuilder) obj);
        }
    });
    private static final AttributeKey<HttpClient> SSEClientForReconnectionAttr;
    private static final AttributeKey<Boolean> SSEReconnectionRequestAttr;

    public static /* synthetic */ void getSSE$annotations() {
    }

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HttpClient.class);
        KType kTypeTypeOf2 = null;
        try {
            kTypeTypeOf = Reflection.typeOf(HttpClient.class);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        SSEClientForReconnectionAttr = new AttributeKey<>("SSEClientForReconnection", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kTypeTypeOf2 = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused2) {
        }
        SSEReconnectionRequestAttr = new AttributeKey<>("SSEReconnectionRequestAttr", new TypeInfo(orCreateKotlinClass2, kTypeTypeOf2));
    }

    public static final Logger getLOGGER() {
        return LOGGER;
    }

    public static final ClientPlugin<SSEConfig> getSSE() {
        return SSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SSE$lambda$0(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.on(AfterRender.INSTANCE, new SSEKt$SSE$2$1(createClientPlugin, ((SSEConfig) createClientPlugin.getPluginConfig()).getReconnectionTime(), ((SSEConfig) createClientPlugin.getPluginConfig()).getShowCommentEvents(), ((SSEConfig) createClientPlugin.getPluginConfig()).getShowRetryEvents(), ((SSEConfig) createClientPlugin.getPluginConfig()).getMaxReconnectionAttempts(), null));
        createClientPlugin.getClient().getResponsePipeline().intercept(HttpResponsePipeline.INSTANCE.getTransform(), new SSEKt$SSE$2$2(null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T getAttributeValue(HttpRequestBuilder httpRequestBuilder, AttributeKey<T> attributeKey) {
        return (T) httpRequestBuilder.getAttributes().getOrNull(attributeKey);
    }

    public static final AttributeKey<HttpClient> getSSEClientForReconnectionAttr() {
        return SSEClientForReconnectionAttr;
    }

    public static final AttributeKey<Boolean> getSSEReconnectionRequestAttr() {
        return SSEReconnectionRequestAttr;
    }

    public static final void checkResponse(HttpResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        HttpStatusCode status = response.getStatus();
        ContentType contentType = HttpMessagePropertiesKt.contentType(response);
        if (Intrinsics.areEqual(status, HttpStatusCode.INSTANCE.getNoContent())) {
            Logger logger = LOGGER;
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Receive status code NoContent for SSE request to " + HttpResponseKt.getRequest(response).getUrl());
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(status, HttpStatusCode.INSTANCE.getOK())) {
            throw new SSEClientException(response, null, "Expected status code " + HttpStatusCode.INSTANCE.getOK().getValue() + " but was " + status.getValue(), 2, null);
        }
        if (Intrinsics.areEqual(contentType != null ? contentType.withoutParameters() : null, ContentType.Text.INSTANCE.getEventStream())) {
            return;
        }
        throw new SSEClientException(response, null, "Expected Content-Type " + ContentType.Text.INSTANCE.getEventStream() + " but was " + contentType, 2, null);
    }
}
