package com.moloco.sdk.internal.services.bidtoken;

import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes6.dex */
public final class m implements l {
    public static final int e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f2308a;
    public final q b;
    public final String c;
    public final Mutex d;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.BidTokenServiceImpl", f = "BidTokenService.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {117, 53, 60}, m = "bidToken", n = {"this", "metricsRecorder", "$this$withLock_u24default$iv", "this", "metricsRecorder", "$this$withLock_u24default$iv", "bidTokenTimer", "this", "metricsRecorder", "$this$withLock_u24default$iv", "bidTokenTimer", "serverBidToken"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2309a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public int h;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return m.this.a(null, this);
        }
    }

    public m(y serverBidTokenService, q clientBidTokenService) {
        Intrinsics.checkNotNullParameter(serverBidTokenService, "serverBidTokenService");
        Intrinsics.checkNotNullParameter(clientBidTokenService, "clientBidTokenService");
        this.f2308a = serverBidTokenService;
        this.b = clientBidTokenService;
        this.c = "BidTokenServiceImpl";
        this.d = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d0 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:21:0x006c, B:34:0x00c4, B:36:0x00d0), top: B:59:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100 A[Catch: all -> 0x0051, TryCatch #1 {all -> 0x0051, blocks: (B:14:0x0046, B:40:0x00f1, B:43:0x00f8, B:45:0x0100, B:51:0x012e, B:46:0x0112), top: B:61:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0112 A[Catch: all -> 0x0051, TRY_LEAVE, TryCatch #1 {all -> 0x0051, blocks: (B:14:0x0046, B:40:0x00f1, B:43:0x00f8, B:45:0x0100, B:51:0x012e, B:46:0x0112), top: B:61:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.moloco.sdk.internal.services.bidtoken.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(com.moloco.sdk.acm.recorder.MetricsRecorder r19, kotlin.coroutines.Continuation<? super java.lang.String> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.m.a(com.moloco.sdk.acm.recorder.MetricsRecorder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(TimerEvent timerEvent, MetricsRecorder metricsRecorder, String str) {
        if (str != null) {
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.r.c());
            com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
            CountEvent countEventWithTag = countEvent.withTag(dVar.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.d dVar2 = com.moloco.sdk.internal.client_metrics_data.d.b;
            metricsRecorder.recordCountEvent(countEventWithTag.withTag(dVar2.c(), str));
            metricsRecorder.recordTimerEvent(timerEvent.withTag(dVar.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(dVar2.c(), str));
            return;
        }
        CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.r.c());
        com.moloco.sdk.internal.client_metrics_data.d dVar3 = com.moloco.sdk.internal.client_metrics_data.d.d;
        metricsRecorder.recordCountEvent(countEvent2.withTag(dVar3.c(), "success"));
        metricsRecorder.recordTimerEvent(timerEvent.withTag(dVar3.c(), "success"));
    }
}
