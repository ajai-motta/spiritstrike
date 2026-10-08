package com.moloco.sdk.internal.services.bidtoken;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.moloco.sdk.internal.services.I;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class i implements h {
    public static final int e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f2304a;
    public final com.moloco.sdk.internal.publisher.v b;
    public final I c;
    public final String d;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenHandlerImpl", f = "BidTokenHandler.kt", i = {0, 0, 0, 0}, l = {60}, m = "handleBidTokenRequest", n = {"this", "metricsRecorder", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "bidTokenLoadStart"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2305a;
        public Object b;
        public Object c;
        public long d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return i.this.a(null, null, null, this);
        }
    }

    public i(l bidTokenService, com.moloco.sdk.internal.publisher.v initializationHandler, I timeProviderService) {
        Intrinsics.checkNotNullParameter(bidTokenService, "bidTokenService");
        Intrinsics.checkNotNullParameter(initializationHandler, "initializationHandler");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.f2304a = bidTokenService;
        this.b = initializationHandler;
        this.c = timeProviderService;
        this.d = "BidTokenHandlerImpl";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // com.moloco.sdk.internal.services.bidtoken.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(com.moloco.sdk.acm.recorder.MetricsRecorder r18, com.moloco.sdk.publisher.MediationInfo r19, com.moloco.sdk.publisher.MolocoBidTokenListener r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.i.a(com.moloco.sdk.acm.recorder.MetricsRecorder, com.moloco.sdk.publisher.MediationInfo, com.moloco.sdk.publisher.MolocoBidTokenListener, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
