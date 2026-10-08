package com.moloco.sdk.internal.publisher;

import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.w;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAd;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C2995f implements x {
    public static final a f = new a(null);
    public static final int g = 8;
    public static final String h = "AdLoadListenerTrackerImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdLoad.Listener f2181a;
    public final com.moloco.sdk.internal.w b;
    public final TimerEvent c;
    public final AdFormatType d;
    public final MetricsRecorder e;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.f$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public C2995f(AdLoad.Listener listener, com.moloco.sdk.internal.w sdkEventUrlTracker, TimerEvent acmLoadTimerEvent, AdFormatType adFormatType, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(sdkEventUrlTracker, "sdkEventUrlTracker");
        Intrinsics.checkNotNullParameter(acmLoadTimerEvent, "acmLoadTimerEvent");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f2181a = listener;
        this.b = sdkEventUrlTracker;
        this.c = acmLoadTimerEvent;
        this.d = adFormatType;
        this.e = metricsRecorder;
    }

    @Override // com.moloco.sdk.internal.publisher.x
    public void a(MolocoAd molocoAd, long j, com.moloco.sdk.internal.ortb.model.x xVar) {
        String onAdLoadStart;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "onAdLoadStarted: " + molocoAd + ", " + j, null, false, 12, null);
        if (xVar == null || (onAdLoadStart = xVar.getOnAdLoadStart()) == null) {
            return;
        }
        w.a.a(this.b, onAdLoadStart, j, null, 4, null);
    }

    @Override // com.moloco.sdk.internal.publisher.x
    public void a(MolocoAd molocoAd, com.moloco.sdk.internal.ortb.model.x xVar) {
        String onAdLoadSuccess;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "onAdLoadSuccess: " + molocoAd, null, false, 12, null);
        if (xVar != null && (onAdLoadSuccess = xVar.getOnAdLoadSuccess()) != null) {
            w.a.a(this.b, onAdLoadSuccess, System.currentTimeMillis(), null, 4, null);
        }
        MetricsRecorder metricsRecorder = this.e;
        TimerEvent timerEventWithTag = this.c.withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), "success");
        com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.c;
        String strC = dVar.c();
        String strName = this.d.name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordTimerEvent(timerEventWithTag.withTag(strC, lowerCase));
        MetricsRecorder metricsRecorder2 = this.e;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.l.c());
        String strC2 = dVar.c();
        String lowerCase2 = this.d.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        metricsRecorder2.recordCountEvent(countEvent.withTag(strC2, lowerCase2));
        AdLoad.Listener listener = this.f2181a;
        if (listener != null) {
            listener.onAdLoadSuccess(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.x
    public void a(com.moloco.sdk.internal.s internalError, com.moloco.sdk.internal.ortb.model.x xVar) {
        String onAdLoadFailed;
        Intrinsics.checkNotNullParameter(internalError, "internalError");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, h, "onAdLoadFailed: " + internalError, null, false, 12, null);
        if (xVar != null && (onAdLoadFailed = xVar.getOnAdLoadFailed()) != null) {
            this.b.a(onAdLoadFailed, System.currentTimeMillis(), internalError);
        }
        MetricsRecorder metricsRecorder = this.e;
        TimerEvent timerEventWithTag = this.c.withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
        com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.b;
        TimerEvent timerEventWithTag2 = timerEventWithTag.withTag(dVar.c(), internalError.d().a());
        com.moloco.sdk.internal.client_metrics_data.d dVar2 = com.moloco.sdk.internal.client_metrics_data.d.c;
        String strC = dVar2.c();
        String strName = this.d.name();
        Locale locale = Locale.ROOT;
        String lowerCase = strName.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordTimerEvent(timerEventWithTag2.withTag(strC, lowerCase));
        MetricsRecorder metricsRecorder2 = this.e;
        CountEvent countEventWithTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.m.c()).withTag("network", internalError.c().getNetworkName()).withTag(dVar.c(), internalError.d().a());
        String strC2 = dVar2.c();
        String lowerCase2 = this.d.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        metricsRecorder2.recordCountEvent(countEventWithTag.withTag(strC2, lowerCase2));
        AdLoad.Listener listener = this.f2181a;
        if (listener != null) {
            listener.onAdLoadFailed(internalError.c());
        }
    }
}
