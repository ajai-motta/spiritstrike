package com.moloco.sdk.internal.services.bidtoken;

import com.adxcorp.ads.mediation.util.ReportUtil;
import com.moloco.sdk.BidToken;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import io.ktor.client.HttpClient;
import io.ktor.http.HeadersBuilder;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements InterfaceC3000a {
    public static final int f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2297a;
    public final HttpClient b;
    public final j c;
    public final g d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenApiImpl$fetchBidToken$2", f = "BidTokenApi.kt", i = {0, 0, 0, 1}, l = {80, 127}, m = "invokeSuspend", n = {"lastResult", "serverBidTokenApiTimer", ReportUtil.EVENT_TYPE_ATTEMPT, "lastResult"}, s = {"L$0", "L$3", "I$2", "L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2298a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public int f;
        public int g;
        public int h;
        public final /* synthetic */ MetricsRecorder j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MetricsRecorder metricsRecorder, Continuation<? super a> continuation) {
            super(2, continuation);
            this.j = metricsRecorder;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new a(this.j, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00f9  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x01f7  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0241  */
        /* JADX WARN: Type inference failed for: r10v1, types: [T, com.moloco.sdk.internal.v, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, com.moloco.sdk.internal.v$a] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x01ec -> B:30:0x01ef). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 580
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenApiImpl", f = "BidTokenApi.kt", i = {0}, l = {209, 210}, m = "fetchBidTokenWork", n = {"this"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2299a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return c.this.a((String) null, this);
        }
    }

    public c(String sdkVersion, HttpClient httpClient, j httpRequestInfo, g deviceRequestInfo) {
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(httpRequestInfo, "httpRequestInfo");
        Intrinsics.checkNotNullParameter(deviceRequestInfo, "deviceRequestInfo");
        this.f2297a = sdkVersion;
        this.b = httpClient;
        this.c = httpRequestInfo;
        this.d = deviceRequestInfo;
        this.e = "BidTokenApi";
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.InterfaceC3000a
    public Object a(MetricsRecorder metricsRecorder, Continuation<? super com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m>> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new a(metricsRecorder, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0107 A[Catch: InvalidProtocolBufferException -> 0x0030, TryCatch #3 {InvalidProtocolBufferException -> 0x0030, blocks: (B:12:0x002b, B:58:0x0107, B:59:0x0131, B:60:0x0138, B:50:0x00e7, B:54:0x00f5), top: B:82:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0131 A[Catch: InvalidProtocolBufferException -> 0x0030, TryCatch #3 {InvalidProtocolBufferException -> 0x0030, blocks: (B:12:0x002b, B:58:0x0107, B:59:0x0131, B:60:0x0138, B:50:0x00e7, B:54:0x00f5), top: B:82:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r10, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.services.bidtoken.k, com.moloco.sdk.internal.m>> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 475
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.c.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Unit a(c cVar, HeadersBuilder headers) {
        Intrinsics.checkNotNullParameter(headers, "$this$headers");
        com.moloco.sdk.internal.n.a(headers, cVar.f2297a, cVar.d.j(), null, 4, null);
        return Unit.INSTANCE;
    }

    public final byte[] a() {
        byte[] byteArray = BidToken.BidTokenRequestV3.newBuilder().build().toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
