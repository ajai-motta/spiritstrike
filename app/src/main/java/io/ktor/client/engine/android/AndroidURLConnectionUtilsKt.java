package io.ktor.client.engine.android;

import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AndroidURLConnectionUtils.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\t\u001a6\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00028\u00000\fH\u0080@¢\u0006\u0004\b\u000e\u0010\u000f\u001a#\u0010\u0015\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0013\u0010\u0019\u001a\u00020\u0018*\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ljava/net/HttpURLConnection;", "Lio/ktor/client/request/HttpRequestData;", "requestData", "", "setupTimeoutAttributes", "(Ljava/net/HttpURLConnection;Lio/ktor/client/request/HttpRequestData;)V", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "timeoutAttributes", "setupRequestTimeoutAttributes", "(Ljava/net/HttpURLConnection;Lio/ktor/client/plugins/HttpTimeoutConfig;)V", "T", "request", "Lkotlin/Function1;", "block", "timeoutAwareConnection", "(Ljava/net/HttpURLConnection;Lio/ktor/client/request/HttpRequestData;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "status", "Lkotlin/coroutines/CoroutineContext;", "callContext", "Lio/ktor/utils/io/ByteReadChannel;", "content", "(Ljava/net/HttpURLConnection;ILkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "", "", "isTimeoutException", "(Ljava/lang/Throwable;)Z", "ktor-client-android"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AndroidURLConnectionUtilsKt {

    /* JADX INFO: renamed from: io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidURLConnectionUtils.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.android.AndroidURLConnectionUtilsKt", f = "AndroidURLConnectionUtils.kt", i = {0, 0}, l = {61}, m = "timeoutAwareConnection", n = {"request", "cause"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidURLConnectionUtilsKt.timeoutAwareConnection(null, null, null, this);
        }
    }

    public static final void setupTimeoutAttributes(HttpURLConnection httpURLConnection, HttpRequestData requestData) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) requestData.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
        if (httpTimeoutConfig != null) {
            Long l = httpTimeoutConfig.get_connectTimeoutMillis();
            if (l != null) {
                httpURLConnection.setConnectTimeout(HttpTimeoutKt.convertLongTimeoutToIntWithInfiniteAsZero(l.longValue()));
            }
            Long l2 = httpTimeoutConfig.get_socketTimeoutMillis();
            if (l2 != null) {
                httpURLConnection.setReadTimeout(HttpTimeoutKt.convertLongTimeoutToIntWithInfiniteAsZero(l2.longValue()));
            }
            setupRequestTimeoutAttributes(httpURLConnection, httpTimeoutConfig);
        }
    }

    private static final void setupRequestTimeoutAttributes(HttpURLConnection httpURLConnection, HttpTimeoutConfig httpTimeoutConfig) {
        Long l = httpTimeoutConfig.get_requestTimeoutMillis();
        if (l != null) {
            long jLongValue = l.longValue();
            if (jLongValue != Long.MAX_VALUE) {
                if (httpURLConnection.getConnectTimeout() == 0 || httpURLConnection.getConnectTimeout() > jLongValue) {
                    httpURLConnection.setConnectTimeout(HttpTimeoutKt.convertLongTimeoutToIntWithInfiniteAsZero(jLongValue));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object timeoutAwareConnection(java.net.HttpURLConnection r4, io.ktor.client.request.HttpRequestData r5, kotlin.jvm.functions.Function1<? super java.net.HttpURLConnection, ? extends T> r6, kotlin.coroutines.Continuation<? super T> r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.client.engine.android.AndroidURLConnectionUtilsKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1 r0 = (io.ktor.client.engine.android.AndroidURLConnectionUtilsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1 r0 = new io.ktor.client.engine.android.AndroidURLConnectionUtilsKt$timeoutAwareConnection$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$1
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.client.request.HttpRequestData r5 = (io.ktor.client.request.HttpRequestData) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L50
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r4 = r6.invoke(r4)     // Catch: java.lang.Throwable -> L42
            return r4
        L42:
            r4 = move-exception
            r0.L$0 = r5
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.YieldKt.yield(r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            boolean r6 = isTimeoutException(r4)
            if (r6 == 0) goto L5c
            io.ktor.client.network.sockets.ConnectTimeoutException r4 = io.ktor.client.plugins.HttpTimeoutKt.ConnectTimeoutException(r5, r4)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
        L5c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.engine.android.AndroidURLConnectionUtilsKt.timeoutAwareConnection(java.net.HttpURLConnection, io.ktor.client.request.HttpRequestData, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final ByteReadChannel content(HttpURLConnection httpURLConnection, int i, CoroutineContext callContext) {
        ByteReadChannel byteReadChannel;
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        if (CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(HttpStatusCode.INSTANCE.getNotModified().getValue()), Integer.valueOf(HttpStatusCode.INSTANCE.getNoContent().getValue())}).contains(Integer.valueOf(i))) {
            return ByteReadChannel.INSTANCE.getEmpty();
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedInputStream = inputStream != null ? inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, 8192) : null;
        } catch (IOException unused) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                bufferedInputStream = errorStream instanceof BufferedInputStream ? (BufferedInputStream) errorStream : new BufferedInputStream(errorStream, 8192);
            }
        }
        return (bufferedInputStream == null || (byteReadChannel = ReadingKt.toByteReadChannel(bufferedInputStream, callContext, ByteBufferPoolKt.getKtorDefaultPool())) == null) ? ByteReadChannel.INSTANCE.getEmpty() : byteReadChannel;
    }

    private static final boolean isTimeoutException(Throwable th) {
        String message;
        return (th instanceof SocketTimeoutException) || ((th instanceof ConnectException) && (message = th.getMessage()) != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "timed out", false, 2, (Object) null));
    }
}
