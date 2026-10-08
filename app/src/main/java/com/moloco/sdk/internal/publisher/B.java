package com.moloco.sdk.internal.publisher;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.services.InterfaceC3005f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.BannerAdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class B implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f2153a;
    public final BannerAdShowListener b;

    public B(BannerAdShowListener bannerAdShowListener, InterfaceC3005f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, Function0<com.moloco.sdk.internal.ortb.model.x> provideSdkEvents, Function0<j> provideBUrlData, AdFormatType adType, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(provideSdkEvents, "provideSdkEvents");
        Intrinsics.checkNotNullParameter(provideBUrlData, "provideBUrlData");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f2153a = A.a(bannerAdShowListener, appLifecycleTrackerService, customUserEventBuilderService, provideSdkEvents, provideBUrlData, (TypedValues.MotionType.TYPE_DRAW_PATH & 32) != 0 ? com.moloco.sdk.internal.y.b() : null, (TypedValues.MotionType.TYPE_DRAW_PATH & 64) != 0 ? com.moloco.sdk.internal.h.a() : null, adType, metricsRecorder, (TypedValues.MotionType.TYPE_DRAW_PATH & 512) != 0 ? new com.moloco.sdk.internal.client_metrics_data.a(metricsRecorder) : null);
        this.b = bannerAdShowListener;
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void a(com.moloco.sdk.internal.s internalError) {
        Intrinsics.checkNotNullParameter(internalError, "internalError");
        this.f2153a.a(internalError);
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdClicked(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.f2153a.onAdClicked(molocoAd);
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdHidden(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.f2153a.onAdHidden(molocoAd);
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdShowSuccess(MolocoAd molocoAd) {
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        this.f2153a.onAdShowSuccess(molocoAd);
    }

    public final BannerAdShowListener a() {
        return this.b;
    }
}
