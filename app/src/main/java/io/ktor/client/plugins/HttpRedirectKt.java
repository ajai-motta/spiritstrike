package io.ktor.client.plugins;

import io.ktor.client.plugins.api.ClientPlugin;
import io.ktor.client.plugins.api.ClientPluginBuilder;
import io.ktor.client.plugins.api.CreatePluginUtilsKt;
import io.ktor.client.plugins.api.Send;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

/* JADX INFO: compiled from: HttpRedirect.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00060\bj\u0002`\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lio/ktor/http/HttpStatusCode;", "", "isRedirect", "(Lio/ktor/http/HttpStatusCode;)Z", "", "Lio/ktor/http/HttpMethod;", "ALLOWED_FOR_REDIRECT", "Ljava/util/Set;", "Lorg/slf4j/Logger;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lorg/slf4j/Logger;", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "HttpResponseRedirectEvent", "Lio/ktor/events/EventDefinition;", "getHttpResponseRedirectEvent", "()Lio/ktor/events/EventDefinition;", "Lio/ktor/client/plugins/api/ClientPlugin;", "Lio/ktor/client/plugins/HttpRedirectConfig;", "HttpRedirect", "Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRedirect", "()Lio/ktor/client/plugins/api/ClientPlugin;", "getHttpRedirect$annotations", "()V", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HttpRedirectKt {
    private static final Set<HttpMethod> ALLOWED_FOR_REDIRECT = SetsKt.setOf((Object[]) new HttpMethod[]{HttpMethod.INSTANCE.getGet(), HttpMethod.INSTANCE.getHead()});
    private static final Logger LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpRedirect");
    private static final EventDefinition<HttpResponse> HttpResponseRedirectEvent = new EventDefinition<>();
    private static final ClientPlugin<HttpRedirectConfig> HttpRedirect = CreatePluginUtilsKt.createClientPlugin("HttpRedirect", HttpRedirectKt$HttpRedirect$1.INSTANCE, new Function1() { // from class: io.ktor.client.plugins.HttpRedirectKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return HttpRedirectKt.HttpRedirect$lambda$2((ClientPluginBuilder) obj);
        }
    });

    public static /* synthetic */ void getHttpRedirect$annotations() {
    }

    public static final EventDefinition<HttpResponse> getHttpResponseRedirectEvent() {
        return HttpResponseRedirectEvent;
    }

    public static final ClientPlugin<HttpRedirectConfig> getHttpRedirect() {
        return HttpRedirect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HttpRedirect$lambda$2(ClientPluginBuilder createClientPlugin) {
        Intrinsics.checkNotNullParameter(createClientPlugin, "$this$createClientPlugin");
        createClientPlugin.on(Send.INSTANCE, new HttpRedirectKt$HttpRedirect$2$1(((HttpRedirectConfig) createClientPlugin.getPluginConfig()).getCheckHttpMethod(), ((HttpRedirectConfig) createClientPlugin.getPluginConfig()).getAllowHttpsDowngrade(), createClientPlugin, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0183 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r11v0, types: [T, io.ktor.client.request.HttpRequestBuilder] */
    /* JADX WARN: Type inference failed for: r12v0, types: [T, io.ktor.client.call.HttpClientCall, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [io.ktor.client.request.HttpRequestBuilder, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9, types: [T] */
    /* JADX WARN: Type inference failed for: r7v5, types: [T, io.ktor.client.request.HttpRequestBuilder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0184 -> B:35:0x0189). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object HttpRedirect$lambda$2$handleCall(io.ktor.client.plugins.api.Send.Sender r10, io.ktor.client.request.HttpRequestBuilder r11, io.ktor.client.call.HttpClientCall r12, boolean r13, io.ktor.client.HttpClient r14, kotlin.coroutines.Continuation<? super io.ktor.client.call.HttpClientCall> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRedirectKt.HttpRedirect$lambda$2$handleCall(io.ktor.client.plugins.api.Send$Sender, io.ktor.client.request.HttpRequestBuilder, io.ktor.client.call.HttpClientCall, boolean, io.ktor.client.HttpClient, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final boolean isRedirect(HttpStatusCode httpStatusCode) {
        int value = httpStatusCode.getValue();
        return value == HttpStatusCode.INSTANCE.getMovedPermanently().getValue() || value == HttpStatusCode.INSTANCE.getFound().getValue() || value == HttpStatusCode.INSTANCE.getTemporaryRedirect().getValue() || value == HttpStatusCode.INSTANCE.getPermanentRedirect().getValue() || value == HttpStatusCode.INSTANCE.getSeeOther().getValue();
    }
}
