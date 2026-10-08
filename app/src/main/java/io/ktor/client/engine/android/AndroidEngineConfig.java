package io.ktor.client.engine.android;

import io.ktor.client.engine.HttpClientEngineConfig;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidEngineConfig.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR.\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R3\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016¨\u0006\u001c"}, d2 = {"Lio/ktor/client/engine/android/AndroidEngineConfig;", "Lio/ktor/client/engine/HttpClientEngineConfig;", "<init>", "()V", "", "connectTimeout", "I", "getConnectTimeout", "()I", "setConnectTimeout", "(I)V", "socketTimeout", "getSocketTimeout", "setSocketTimeout", "Lkotlin/Function1;", "Ljavax/net/ssl/HttpsURLConnection;", "", "sslManager", "Lkotlin/jvm/functions/Function1;", "getSslManager", "()Lkotlin/jvm/functions/Function1;", "setSslManager", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/net/HttpURLConnection;", "Lkotlin/ExtensionFunctionType;", "requestConfig", "getRequestConfig", "setRequestConfig", "ktor-client-android"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AndroidEngineConfig extends HttpClientEngineConfig {
    private int connectTimeout = 100000;
    private int socketTimeout = 100000;
    private Function1<? super HttpsURLConnection, Unit> sslManager = new Function1() { // from class: io.ktor.client.engine.android.AndroidEngineConfig$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AndroidEngineConfig.sslManager$lambda$0((HttpsURLConnection) obj);
        }
    };
    private Function1<? super HttpURLConnection, Unit> requestConfig = new Function1() { // from class: io.ktor.client.engine.android.AndroidEngineConfig$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return AndroidEngineConfig.requestConfig$lambda$1((HttpURLConnection) obj);
        }
    };

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final void setConnectTimeout(int i) {
        this.connectTimeout = i;
    }

    public final int getSocketTimeout() {
        return this.socketTimeout;
    }

    public final void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sslManager$lambda$0(HttpsURLConnection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<HttpsURLConnection, Unit> getSslManager() {
        return this.sslManager;
    }

    public final void setSslManager(Function1<? super HttpsURLConnection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.sslManager = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestConfig$lambda$1(HttpURLConnection httpURLConnection) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        return Unit.INSTANCE;
    }

    public final Function1<HttpURLConnection, Unit> getRequestConfig() {
        return this.requestConfig;
    }

    public final void setRequestConfig(Function1<? super HttpURLConnection, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.requestConfig = function1;
    }
}
