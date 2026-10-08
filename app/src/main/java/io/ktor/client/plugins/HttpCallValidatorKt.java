package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.plugins.api.SetupRequest;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.slf4j.Logger;

/* JADX INFO: compiled from: HttpCallValidator.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a.\u0010\u000b\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00052\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0004\b\u000b\u0010\f\"\u0018\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"(\u0010\u001c\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00168F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\" \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!*`\u0010)\"-\b\u0001\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"2-\b\u0001\u0012\u0013\u0012\u00110#¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"*`\u0010,\"-\b\u0001\u0012\u0013\u0012\u00110*¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"2-\b\u0001\u0012\u0013\u0012\u00110*¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0\"*\u008a\u0001\u0010/\"B\b\u0001\u0012\u0013\u0012\u00110*¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0-2B\b\u0001\u0012\u0013\u0012\u00110*¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(+\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0-¨\u00060"}, d2 = {"Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/request/HttpRequest;", "HttpRequest", "(Lio/ktor/client/request/HttpRequestBuilder;)Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/HttpClientConfig;", "Lkotlin/Function1;", "Lio/ktor/client/plugins/HttpCallValidatorConfig;", "", "Lkotlin/ExtensionFunctionType;", "block", "HttpResponseValidator", "(Lio/ktor/client/HttpClientConfig;Lkotlin/jvm/functions/Function1;)V", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/client/plugins/api/ClientPlugin;", "HttpCallValidator", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpCallValidator", "()Lio/ktor/client/plugins/api/ClientPlugin;", "", "value", "getExpectSuccess", "(Lio/ktor/client/request/HttpRequestBuilder;)Z", "setExpectSuccess", "(Lio/ktor/client/request/HttpRequestBuilder;Z)V", "expectSuccess", "Lio/ktor/util/AttributeKey;", "ExpectSuccessAttributeKey", "Lio/ktor/util/AttributeKey;", "getExpectSuccessAttributeKey", "()Lio/ktor/util/AttributeKey;", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "", "ResponseValidator", "", "cause", "CallExceptionHandler", "Lkotlin/Function3;", "request", "CallRequestExceptionHandler", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HttpCallValidatorKt {
    private static final AttributeKey<Boolean> ExpectSuccessAttributeKey;
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCallValidator");
    private static final ClientPlugin<HttpCallValidatorConfig> HttpCallValidator = CreatePluginUtilsKt.createClientPlugin("HttpResponseValidator", HttpCallValidatorKt$HttpCallValidator$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.HttpCallValidatorKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return HttpCallValidatorKt.HttpCallValidator$lambda$2((ClientPluginBuilder) obj);
        }
    });

    static {
        KType kTypeTypeOf;
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Boolean.class);
        try {
            kTypeTypeOf = Reflection.typeOf(Boolean.TYPE);
        } catch (Throwable unused) {
            kTypeTypeOf = null;
        }
        ExpectSuccessAttributeKey = new AttributeKey<>("ExpectSuccessAttributeKey", new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
    }

    public static final ClientPlugin<HttpCallValidatorConfig> getHttpCallValidator() {
        return HttpCallValidator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpCallValidator$lambda$2(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        List listReversed = CollectionsKt.reversed(((HttpCallValidatorConfig) createClientPlugin.getPluginConfig()).getResponseValidators$ktor_client_core());
        List listReversed2 = CollectionsKt.reversed(((HttpCallValidatorConfig) createClientPlugin.getPluginConfig()).getResponseExceptionHandlers$ktor_client_core());
        createClientPlugin.on(SetupRequest.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$1(((HttpCallValidatorConfig) createClientPlugin.getPluginConfig()).getExpectSuccess(), null));
        createClientPlugin.on(Send.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$2(listReversed, null));
        createClientPlugin.on(RequestError.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$3(listReversed2, null));
        createClientPlugin.on(ReceiveError.INSTANCE, new HttpCallValidatorKt$HttpCallValidator$2$4(listReversed2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object HttpCallValidator$lambda$2$validateResponse(java.util.List<? extends kotlin.jvm.functions.Function2<? super io.ktor.client.statement.HttpResponse, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>> r5, io.ktor.client.statement.HttpResponse r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1 r0 = (io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1 r0 = new io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$validateResponse$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.client.statement.HttpResponse r6 = (io.ktor.client.statement.HttpResponse) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L62
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            org.slf4j.Logger r7 = io.ktor.client.plugins.HttpCallValidatorKt.LOGGER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Validating response for request "
            r2.<init>(r4)
            io.ktor.client.call.HttpClientCall r4 = r6.getCall()
            io.ktor.client.request.HttpRequest r4 = r4.getRequest()
            io.ktor.http.Url r4 = r4.getUrl()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r7.trace(r2)
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L62:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L7b
            java.lang.Object r7 = r5.next()
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r0.L$0 = r6
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r7.invoke(r6, r0)
            if (r7 != r1) goto L62
            return r1
        L7b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidatorKt.HttpCallValidator$lambda$2$validateResponse(java.util.List, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
    
        r6 = r9;
        r9 = r8;
        r8 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object HttpCallValidator$lambda$2$processException(java.util.List<? extends io.ktor.client.plugins.HandlerWrapper> r7, java.lang.Throwable r8, io.ktor.client.request.HttpRequest r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$processException$1
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$processException$1 r0 = (io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$processException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$processException$1 r0 = new io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$processException$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            goto L32
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            java.lang.Object r7 = r0.L$2
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r0.L$1
            io.ktor.client.request.HttpRequest r8 = (io.ktor.client.request.HttpRequest) r8
            java.lang.Object r9 = r0.L$0
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L92
        L42:
            kotlin.ResultKt.throwOnFailure(r10)
            org.slf4j.Logger r10 = io.ktor.client.plugins.HttpCallValidatorKt.LOGGER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Processing exception "
            r2.<init>(r5)
            r2.append(r8)
            java.lang.String r5 = " for request "
            r2.append(r5)
            io.ktor.http.Url r5 = r9.getUrl()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            r10.trace(r2)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L6a:
            boolean r10 = r7.hasNext()
            if (r10 == 0) goto Lb5
            java.lang.Object r10 = r7.next()
            io.ktor.client.plugins.HandlerWrapper r10 = (io.ktor.client.plugins.HandlerWrapper) r10
            boolean r2 = r10 instanceof io.ktor.client.plugins.ExceptionHandlerWrapper
            if (r2 == 0) goto L96
            io.ktor.client.plugins.ExceptionHandlerWrapper r10 = (io.ktor.client.plugins.ExceptionHandlerWrapper) r10
            kotlin.jvm.functions.Function2 r10 = r10.getHandler()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r10 = r10.invoke(r8, r0)
            if (r10 != r1) goto L8f
            return r1
        L8f:
            r6 = r9
            r9 = r8
            r8 = r6
        L92:
            r6 = r9
            r9 = r8
            r8 = r6
            goto L6a
        L96:
            boolean r2 = r10 instanceof io.ktor.client.plugins.RequestExceptionHandlerWrapper
            if (r2 == 0) goto Laf
            io.ktor.client.plugins.RequestExceptionHandlerWrapper r10 = (io.ktor.client.plugins.RequestExceptionHandlerWrapper) r10
            kotlin.jvm.functions.Function3 r10 = r10.getHandler()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r10 = r10.invoke(r8, r9, r0)
            if (r10 != r1) goto L8f
            return r1
        Laf:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        Lb5:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpCallValidatorKt.HttpCallValidator$lambda$2$processException(java.util.List, java.lang.Throwable, io.ktor.client.request.HttpRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HttpRequest HttpRequest(HttpRequestBuilder httpRequestBuilder) {
        return new HttpRequest() { // from class: io.ktor.client.plugins.HttpCallValidatorKt.HttpRequest.1
            private final Attributes attributes;
            private final Headers headers;
            private final HttpMethod method;
            private final Url url;

            {
                this.method = this.$builder.getMethod();
                this.url = this.$builder.getUrl().build();
                this.attributes = this.$builder.getAttributes();
                this.headers = this.$builder.getHeaders().build();
            }

            @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
            public CoroutineContext getCoroutineContext() {
                return HttpRequest.DefaultImpls.getCoroutineContext(this);
            }

            @Override // io.ktor.client.request.HttpRequest
            public HttpClientCall getCall() {
                throw new IllegalStateException("Call is not initialized".toString());
            }

            @Override // io.ktor.client.request.HttpRequest
            public HttpMethod getMethod() {
                return this.method;
            }

            @Override // io.ktor.client.request.HttpRequest
            public Url getUrl() {
                return this.url;
            }

            @Override // io.ktor.client.request.HttpRequest
            public Attributes getAttributes() {
                return this.attributes;
            }

            @Override // io.ktor.http.HttpMessage
            public Headers getHeaders() {
                return this.headers;
            }

            @Override // io.ktor.client.request.HttpRequest
            public OutgoingContent getContent() {
                Object body = this.$builder.getBody();
                OutgoingContent outgoingContent = body instanceof OutgoingContent ? (OutgoingContent) body : null;
                if (outgoingContent != null) {
                    return outgoingContent;
                }
                throw new IllegalStateException(("Content was not transformed to OutgoingContent yet. Current body is " + this.$builder.getBody()).toString());
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void HttpResponseValidator(HttpClientConfig<?> httpClientConfig, Function1<? super HttpCallValidatorConfig, Unit> block) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        httpClientConfig.install(HttpCallValidator, block);
    }

    public static final boolean getExpectSuccess(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Boolean bool = (Boolean) httpRequestBuilder.getAttributes().getOrNull(ExpectSuccessAttributeKey);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public static final void setExpectSuccess(HttpRequestBuilder httpRequestBuilder, boolean z) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        httpRequestBuilder.getAttributes().put(ExpectSuccessAttributeKey, Boolean.valueOf(z));
    }

    public static final AttributeKey<Boolean> getExpectSuccessAttributeKey() {
        return ExpectSuccessAttributeKey;
    }
}
