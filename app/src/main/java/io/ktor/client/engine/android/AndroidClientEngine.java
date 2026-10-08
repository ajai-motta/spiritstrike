package io.ktor.client.engine.android;

import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.plugins.sse.SSECapability;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidClientEngine.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/client/engine/android/AndroidClientEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", "Lio/ktor/client/engine/android/AndroidEngineConfig;", "config", "<init>", "(Lio/ktor/client/engine/android/AndroidEngineConfig;)V", "Lio/ktor/client/request/HttpRequestData;", "data", "Lio/ktor/client/request/HttpResponseData;", "execute", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "urlString", "Ljava/net/HttpURLConnection;", "getProxyAwareConnection", "(Ljava/lang/String;)Ljava/net/HttpURLConnection;", "Lio/ktor/client/engine/android/AndroidEngineConfig;", "getConfig", "()Lio/ktor/client/engine/android/AndroidEngineConfig;", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "supportedCapabilities", "Ljava/util/Set;", "getSupportedCapabilities", "()Ljava/util/Set;", "ktor-client-android"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidClientEngine extends HttpClientEngineBase {
    private final AndroidEngineConfig config;
    private final Set<HttpClientEngineCapability<?>> supportedCapabilities;

    /* JADX INFO: renamed from: io.ktor.client.engine.android.AndroidClientEngine$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidClientEngine.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.android.AndroidClientEngine", f = "AndroidClientEngine.kt", i = {0, 1, 1, 1, 1}, l = {38, 80, 83}, m = "execute", n = {"data", "data", "callContext", "requestTime", "outgoingContent"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidClientEngine.this.execute(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidClientEngine(AndroidEngineConfig config) {
        super("ktor-android");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.supportedCapabilities = SetsKt.setOf((Object[]) new HttpClientEngineCapability[]{HttpTimeoutCapability.INSTANCE, SSECapability.INSTANCE});
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public AndroidEngineConfig getConfig() {
        return this.config;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x01b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b2 A[PHI: r1
  0x01b2: PHI (r1v11 java.lang.Object) = (r1v9 java.lang.Object), (r1v1 java.lang.Object) binds: [B:54:0x01af, B:13:0x0031] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // io.ktor.client.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(io.ktor.client.request.HttpRequestData r18, kotlin.coroutines.Continuation<? super io.ktor.client.request.HttpResponseData> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.android.AndroidClientEngine.execute(io.ktor.client.request.HttpRequestData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final io.ktor.client.request.HttpResponseData execute$lambda$5(kotlin.coroutines.CoroutineContext r11, io.ktor.client.request.HttpRequestData r12, io.ktor.http.content.OutgoingContent r13, io.ktor.util.date.GMTDate r14, java.net.HttpURLConnection r15) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.android.AndroidClientEngine.execute$lambda$5(kotlin.coroutines.CoroutineContext, io.ktor.client.request.HttpRequestData, io.ktor.http.content.OutgoingContent, io.ktor.util.date.GMTDate, java.net.HttpURLConnection):io.ktor.client.request.HttpResponseData");
    }

    private final HttpURLConnection getProxyAwareConnection(String urlString) throws IOException {
        URLConnection uRLConnectionOpenConnection;
        URL url = new URL(urlString);
        Proxy proxy = getConfig().getProxy();
        if (proxy == null || (uRLConnectionOpenConnection = url.openConnection(proxy)) == null) {
            uRLConnectionOpenConnection = url.openConnection();
            Intrinsics.checkNotNullExpressionValue(uRLConnectionOpenConnection, "openConnection(...)");
        }
        return (HttpURLConnection) uRLConnectionOpenConnection;
    }
}
