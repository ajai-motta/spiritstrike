package com.moloco.sdk.internal.services.bidtoken;

import android.util.Base64;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.BidToken;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.I;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes6.dex */
public final class r implements q {
    public static final int k = 8;
    public final I b;
    public final o c;
    public final com.moloco.sdk.internal.services.encryption.a d;
    public final com.moloco.sdk.internal.services.bidtoken.providers.l e;
    public final String f;
    public String g;
    public String h;
    public f i;
    public final Mutex j;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ClientBidTokenServiceImpl", f = "ClientBidTokenService.kt", i = {0, 0, 0, 0, 0}, l = {191}, m = "bidToken-BWLJW6A", n = {"this", "metricsRecorder", "publicKey", "bidTokenConfig", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2327a;
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
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            Object objA = r.this.a(null, null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7414boximpl(objA);
        }
    }

    public r(I timeProviderService, o clientBidTokenBuilder, com.moloco.sdk.internal.services.encryption.a encryptionService, com.moloco.sdk.internal.services.bidtoken.providers.l signalProvider) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        Intrinsics.checkNotNullParameter(clientBidTokenBuilder, "clientBidTokenBuilder");
        Intrinsics.checkNotNullParameter(encryptionService, "encryptionService");
        Intrinsics.checkNotNullParameter(signalProvider, "signalProvider");
        this.b = timeProviderService;
        this.c = clientBidTokenBuilder;
        this.d = encryptionService;
        this.e = signalProvider;
        this.f = "ClientBidTokenServiceImpl";
        this.g = "";
        this.h = "";
        this.i = e.a();
        this.j = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.bidtoken.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(com.moloco.sdk.acm.recorder.MetricsRecorder r12, java.lang.String r13, com.moloco.sdk.internal.services.bidtoken.f r14, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.r.a(com.moloco.sdk.acm.recorder.MetricsRecorder, java.lang.String, com.moloco.sdk.internal.services.bidtoken.f, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean a(f fVar) {
        f fVar2 = this.i;
        this.i = fVar;
        boolean z = !Intrinsics.areEqual(fVar2, fVar);
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, z ? "config updated" : "config didn't change", false, 4, null);
        return z;
    }

    public final boolean a(String str, f fVar) {
        if (!Intrinsics.areEqual(this.g, str)) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "rp changed, needs refresh", false, 4, null);
            return true;
        }
        if (a(fVar)) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "config changed, needs refresh", false, 4, null);
            return true;
        }
        if (this.h.length() == 0) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "cached bidToken is empty, needs refresh", false, 4, null);
            return true;
        }
        if (this.e.b()) {
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "signal provider updated, needs refresh", false, 4, null);
            return true;
        }
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f, "Bid token doesn't need refresh", false, 4, null);
        return false;
    }

    public final String a(String str, MetricsRecorder metricsRecorder) {
        Exception exc;
        String str2;
        if (str.length() == 0) {
            metricsRecorder.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.y.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), "empty_public_key"));
            return "";
        }
        TimerEvent timerEventStartTimerEvent = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.o.c());
        try {
            long jA = this.b.a();
            str2 = "rsa";
            try {
                byte[] bArrA = this.d.a(str);
                String str3 = "update_signal_state";
                try {
                    this.e.a();
                    str3 = "provide_signal";
                    BidToken.ClientBidTokenComponents clientBidTokenComponentsA = this.c.a(this.e.d(), this.i);
                    MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                    MolocoLogger.debugBuildLog$default(molocoLogger, this.f, "BidToken Component: " + clientBidTokenComponentsA, false, 4, null);
                    byte[] bArrEncode = Base64.encode(clientBidTokenComponentsA.toByteArray(), 0);
                    try {
                        com.moloco.sdk.internal.services.encryption.a aVar = this.d;
                        Intrinsics.checkNotNull(bArrEncode);
                        byte[] bArrEncode2 = Base64.encode(aVar.a(bArrEncode), 0);
                        o oVar = this.c;
                        Intrinsics.checkNotNull(bArrEncode2);
                        String strEncodeToString = Base64.encodeToString(oVar.a(bArrEncode2, bArrA), 0);
                        com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
                        metricsRecorder.recordTimerEvent(timerEventStartTimerEvent.withTag(dVar.c(), "success"));
                        metricsRecorder.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.y.c()).withTag(dVar.c(), "success"));
                        MolocoLogger.info$default(molocoLogger, this.f, "Client bid token build time: " + (this.b.a() - jA) + " ms", null, false, 12, null);
                        return "v2:" + strEncodeToString;
                    } catch (Exception e) {
                        exc = e;
                        str2 = "aes";
                        String simpleName = exc.getClass().getSimpleName();
                        MolocoLogger molocoLogger2 = MolocoLogger.INSTANCE;
                        MolocoLogger.warn$default(molocoLogger2, this.f, "Client bid token build failed: " + simpleName, exc, false, 8, null);
                        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.y.c());
                        com.moloco.sdk.internal.client_metrics_data.d dVar2 = com.moloco.sdk.internal.client_metrics_data.d.d;
                        CountEvent countEventWithTag = countEvent.withTag(dVar2.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
                        com.moloco.sdk.internal.client_metrics_data.d dVar3 = com.moloco.sdk.internal.client_metrics_data.d.b;
                        CountEvent countEventWithTag2 = countEventWithTag.withTag(dVar3.c(), simpleName);
                        if (str2.length() > 0) {
                            countEventWithTag2.withTag(com.moloco.sdk.internal.client_metrics_data.d.g.c(), str2);
                        }
                        MolocoLogger.debugBuildLog$default(molocoLogger2, this.f, "Recording metric failure: " + countEventWithTag2.getName() + ", tags: " + CollectionsKt.joinToString$default(countEventWithTag2.getEventTags(), ",", null, null, 0, null, null, 62, null), false, 4, null);
                        metricsRecorder.recordCountEvent(countEventWithTag2);
                        metricsRecorder.recordTimerEvent(timerEventStartTimerEvent.withTag(dVar2.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(dVar3.c(), simpleName));
                        return "";
                    }
                } catch (Exception e2) {
                    exc = e2;
                    str2 = str3;
                }
            } catch (Exception e3) {
                exc = e3;
            }
        } catch (Exception e4) {
            exc = e4;
            str2 = "";
        }
    }
}
