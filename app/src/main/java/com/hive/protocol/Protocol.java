package com.hive.protocol;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.widget.Toast;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.HiveKeys;
import com.hive.core.Logger;
import com.hive.core.Network;
import com.hive.core.OauthToken;
import com.hive.core.Platform;
import com.hive.core.Request;
import com.hive.core.Response;
import com.hive.core.Result;
import com.hive.protocol.ProtocolRequest;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002./B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010 \u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0019J\u000b\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u001a\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\"0$J\r\u0010%\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u001c\u0010\b\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020'H\u0002J\b\u0010-\u001a\u00020\u0019H\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0010\u0010\u0011\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012¨\u00060"}, d2 = {"Lcom/hive/protocol/Protocol;", "T", "Lcom/hive/protocol/ProtocolRequest;", "", "createT", "Lkotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "retryNetwork", "", "getRetryNetwork", "()Z", "setRetryNetwork", "(Z)V", "autoRefreshOauthToken", "getAutoRefreshOauthToken", "setAutoRefreshOauthToken", "x", "Lcom/hive/protocol/ProtocolRequest;", "getProtocol", "()Lcom/hive/protocol/ProtocolRequest;", "setHeader", "key", "Lcom/hive/core/HiveKeys;", "value", "", "name", "setParam", "setOauthToken", "token", "Lcom/hive/core/OauthToken;", "hasParam", "isNull", "request", "", "callback", "Lkotlin/Function1;", "innerRequest", "mirrorUrl", "Lcom/hive/core/Response;", "coreRequest", "Lcom/hive/core/Request;", "retryRequest", "refreshOauthTokenAndRequest", "response", InAppPurchaseConstants.METHOD_TO_STRING, k.M, "RetryHandlerThread", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Protocol<T extends ProtocolRequest> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean autoRefreshOauthToken;
    private boolean retryNetwork;
    private T x;

    public Protocol(Function0<? extends T> createT) {
        Intrinsics.checkNotNullParameter(createT, "createT");
        this.retryNetwork = Configuration.INSTANCE.getRetryNetwork();
        this.autoRefreshOauthToken = true;
        this.x = createT.invoke();
    }

    /* JADX INFO: compiled from: Protocol.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\n\b\u0001\u0010\u0006\u0018\u0001*\u00020\u0007H\u0086\n¨\u0006\b"}, d2 = {"Lcom/hive/protocol/Protocol$Companion;", "", "<init>", "()V", "invoke", "Lcom/hive/protocol/Protocol;", "T", "Lcom/hive/protocol/ProtocolRequest;", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ <T extends ProtocolRequest> Protocol<T> invoke() {
            Intrinsics.needClassReification();
            return new Protocol<>(Protocol$Companion$invoke$1.INSTANCE);
        }
    }

    public final boolean getRetryNetwork() {
        return this.retryNetwork;
    }

    public final void setRetryNetwork(boolean z) {
        this.retryNetwork = z;
    }

    public final boolean getAutoRefreshOauthToken() {
        return this.autoRefreshOauthToken;
    }

    public final void setAutoRefreshOauthToken(boolean z) {
        this.autoRefreshOauthToken = z;
    }

    public final T getProtocol() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Protocol.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/hive/protocol/Protocol$RetryHandlerThread;", "Landroid/os/HandlerThread;", "name", "", "<init>", "(Lcom/hive/protocol/Protocol;Ljava/lang/String;)V", "response", "Lcom/hive/core/Response;", "getResponse", "()Lcom/hive/core/Response;", "setResponse", "(Lcom/hive/core/Response;)V", "mHandler", "Landroid/os/Handler;", "getThreadHandler", "hive-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    final class RetryHandlerThread extends HandlerThread {
        private Handler mHandler;
        private Response response;
        final /* synthetic */ Protocol<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RetryHandlerThread(Protocol protocol, String name) {
            super(name);
            Intrinsics.checkNotNullParameter(name, "name");
            this.this$0 = protocol;
        }

        public final Response getResponse() {
            return this.response;
        }

        public final void setResponse(Response response) {
            this.response = response;
        }

        public final Handler getThreadHandler() {
            Handler handler = this.mHandler;
            if (handler != null) {
                return handler;
            }
            Handler handler2 = new Handler(getLooper());
            this.mHandler = handler2;
            return handler2;
        }
    }

    public final Protocol<T> setHeader(HiveKeys key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.x.setHeader$hive_protocol_release(key, value);
        return this;
    }

    public final Protocol<T> setHeader(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.x.setHeader$hive_protocol_release(name, value);
        return this;
    }

    public final Protocol<T> setParam(HiveKeys key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.x.setParam$hive_protocol_release(key, value);
        return this;
    }

    public final Protocol<T> setParam(String name, Object value) throws JSONException {
        Intrinsics.checkNotNullParameter(name, "name");
        this.x.setParam$hive_protocol_release(name, value);
        return this;
    }

    public final Protocol<T> setOauthToken(OauthToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.x.setOauthToken$hive_protocol_release(token);
        return this;
    }

    public final boolean hasParam(HiveKeys key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.x.hasParam$hive_protocol_release(key);
    }

    public final boolean hasParam(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.x.hasParam$hive_protocol_release(name);
    }

    public final boolean isNull(HiveKeys key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.x.isNull$hive_protocol_release(key);
    }

    public final boolean isNull(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.x.isNull$hive_protocol_release(name);
    }

    public final T request() {
        return (T) innerRequest();
    }

    public final void request(final Function1<? super T, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final HandlerThread handlerThread = new HandlerThread("ProtocolRequestThread_" + hashCode());
        handlerThread.setDaemon(true);
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.hive.protocol.Protocol$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Protocol.request$lambda$1$lambda$0(callback, this, handlerThread);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void request$lambda$1$lambda$0(Function1 function1, Protocol protocol, HandlerThread handlerThread) {
        function1.invoke(protocol.innerRequest());
        handlerThread.quit();
    }

    private final T innerRequest() {
        if (this.autoRefreshOauthToken && this.x.isExpireOauthToken$hive_protocol_release(60)) {
            this.x.refreshOauthToken$hive_protocol_release();
        }
        T t = this.x;
        t.toResponse$hive_protocol_release(refreshOauthTokenAndRequest(mirrorUrl(t.toCoreRequest$hive_protocol_release())));
        return this.x;
    }

    private final Response mirrorUrl(Request coreRequest) {
        final String mirrorUrl;
        String mirrorUrl2;
        Request requestCopyMirrorInstance = null;
        if (Intrinsics.areEqual(Platform.readNetworkType$default(Platform.INSTANCE, null, 1, null), "notConnected")) {
            Response response = new Response(0, null, null, coreRequest, new Result(Result.Code.NotConnected, "Network not connected."), 7, null);
            Logger.INSTANCE.protocolLog("[HiveProtocol] Network not connected. " + response, Logger.LogType.Warning);
            return response;
        }
        if (Configuration.INSTANCE.isMirrorUrlDirect() && (mirrorUrl2 = UrlManager.INSTANCE.getMirrorUrl(coreRequest.getUrl())) != null) {
            requestCopyMirrorInstance = coreRequest.copyMirrorInstance(mirrorUrl2);
        }
        Response responseRetryNetwork = retryNetwork(coreRequest, requestCopyMirrorInstance);
        if (responseRetryNetwork.isSuccess() || requestCopyMirrorInstance != null || (mirrorUrl = UrlManager.INSTANCE.getMirrorUrl(coreRequest.getUrl())) == null) {
            return responseRetryNetwork;
        }
        Request requestCopyMirrorInstance2 = coreRequest.copyMirrorInstance(mirrorUrl);
        Logger.INSTANCE.protocolLog("\n[HiveProtocol] Mirror Url: " + mirrorUrl, Logger.LogType.Warning);
        if (Logger.INSTANCE.getLogEnable()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.protocol.Protocol$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    Protocol.mirrorUrl$lambda$4(mirrorUrl);
                }
            });
        }
        return retryNetwork(coreRequest, requestCopyMirrorInstance2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mirrorUrl$lambda$4(String str) {
        Toast.makeText(HiveCoreInitializer.INSTANCE.getInitContext(), "[HIVEProtocol] Mirror Url: " + str, 1).show();
    }

    static /* synthetic */ Response retryNetwork$default(Protocol protocol, Request request, Request request2, int i, Object obj) {
        if ((i & 2) != 0) {
            request2 = null;
        }
        return protocol.retryNetwork(request, request2);
    }

    private final Response retryNetwork(final Request coreRequest, final Request retryRequest) {
        Object objM7415constructorimpl;
        Object objM7415constructorimpl2;
        int iHashCode = hashCode();
        if (this.retryNetwork) {
            final RetryHandlerThread retryHandlerThread = new RetryHandlerThread(this, "httpRetryThread_" + iHashCode + "-A");
            retryHandlerThread.setDaemon(true);
            final RetryHandlerThread retryHandlerThread2 = new RetryHandlerThread(this, "httpRetryThread_" + iHashCode + "-B");
            retryHandlerThread2.setDaemon(true);
            try {
                Result.Companion companion = kotlin.Result.INSTANCE;
                retryHandlerThread.start();
                retryHandlerThread2.start();
                Handler threadHandler = retryHandlerThread.getThreadHandler();
                final Handler threadHandler2 = retryHandlerThread2.getThreadHandler();
                final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
                final Runnable runnable = new Runnable() { // from class: com.hive.protocol.Protocol$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Protocol.retryNetwork$lambda$14$lambda$7(atomicBoolean, retryHandlerThread2, retryRequest, coreRequest, retryHandlerThread);
                    }
                };
                if (!threadHandler.post(new Runnable() { // from class: com.hive.protocol.Protocol$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        Protocol.retryNetwork$lambda$14$lambda$9(retryHandlerThread, coreRequest, retryHandlerThread2, threadHandler2, runnable);
                    }
                })) {
                    Logger.INSTANCE.protocolLog("[HiveProtocol] retryNetwork " + iHashCode + "-A handler post failed.", Logger.LogType.Warning);
                }
                if (!threadHandler2.postDelayed(runnable, 5000L)) {
                    Logger.INSTANCE.protocolLog("[HiveProtocol] retryNetwork " + iHashCode + "-B handler postDelayed failed.", Logger.LogType.Warning);
                }
                try {
                    Result.Companion companion2 = kotlin.Result.INSTANCE;
                    retryHandlerThread.join();
                    kotlin.Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion3 = kotlin.Result.INSTANCE;
                    kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                try {
                    Result.Companion companion4 = kotlin.Result.INSTANCE;
                    retryHandlerThread2.join();
                    objM7415constructorimpl2 = kotlin.Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion5 = kotlin.Result.INSTANCE;
                    objM7415constructorimpl2 = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th2));
                }
                objM7415constructorimpl = kotlin.Result.m7415constructorimpl(kotlin.Result.m7414boximpl(objM7415constructorimpl2));
            } catch (Throwable th3) {
                Result.Companion companion6 = kotlin.Result.INSTANCE;
                objM7415constructorimpl = kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th3));
            }
            Throwable thM7418exceptionOrNullimpl = kotlin.Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                Logger.INSTANCE.protocolLog("[HiveProtocol] retryNetwork " + iHashCode + " Exception: " + thM7418exceptionOrNullimpl, Logger.LogType.Warning);
            }
            try {
                Result.Companion companion7 = kotlin.Result.INSTANCE;
                retryHandlerThread.interrupt();
                kotlin.Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th4) {
                Result.Companion companion8 = kotlin.Result.INSTANCE;
                kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th4));
            }
            try {
                Result.Companion companion9 = kotlin.Result.INSTANCE;
                retryHandlerThread2.interrupt();
                kotlin.Result.m7415constructorimpl(Unit.INSTANCE);
            } catch (Throwable th5) {
                Result.Companion companion10 = kotlin.Result.INSTANCE;
                kotlin.Result.m7415constructorimpl(ResultKt.createFailure(th5));
            }
            Response response = retryHandlerThread2.getResponse();
            if (response != null) {
                return response;
            }
            Response response2 = retryHandlerThread.getResponse();
            return response2 == null ? new Response(0, null, null, coreRequest, new com.hive.core.Result(Result.Code.Failed), 7, null) : response2;
        }
        Network network = Network.INSTANCE;
        if (retryRequest != null) {
            coreRequest = retryRequest;
        }
        return network.sync(coreRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retryNetwork$lambda$14$lambda$7(AtomicBoolean atomicBoolean, RetryHandlerThread retryHandlerThread, Request request, Request request2, RetryHandlerThread retryHandlerThread2) {
        if (atomicBoolean.getAndSet(false)) {
            Network network = Network.INSTANCE;
            if (request == null) {
                request = request2;
            }
            retryHandlerThread.setResponse(network.sync(request));
            retryHandlerThread2.quit();
            retryHandlerThread.quit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retryNetwork$lambda$14$lambda$9(RetryHandlerThread retryHandlerThread, Request request, RetryHandlerThread retryHandlerThread2, Handler handler, Runnable runnable) {
        Response responseSync = Network.INSTANCE.sync(request);
        if (responseSync.isSuccess()) {
            retryHandlerThread2.quit();
        } else {
            handler.post(runnable);
        }
        retryHandlerThread.setResponse(responseSync);
        retryHandlerThread.quit();
    }

    private final Response refreshOauthTokenAndRequest(Response response) {
        if (!this.autoRefreshOauthToken || response.getHttpStatusCode() != 401) {
            return response;
        }
        this.autoRefreshOauthToken = false;
        if (!this.x.refreshOauthToken$hive_protocol_release()) {
            return response;
        }
        Logger.INSTANCE.protocolLog("[HiveProtocol] Refresh OAuth-Token and 2nd Request.", Logger.LogType.Debug);
        return mirrorUrl(this.x.toCoreRequest$hive_protocol_release());
    }

    public String toString() {
        return this.x.toString();
    }
}
