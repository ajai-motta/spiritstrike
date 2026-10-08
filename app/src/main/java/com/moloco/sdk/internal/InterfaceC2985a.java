package com.moloco.sdk.internal;

import android.content.Context;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.publisher.C2990a;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.InterfaceC3005f;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.P;

/* JADX INFO: renamed from: com.moloco.sdk.internal.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public interface InterfaceC2985a {
    Banner a(Context context, InterfaceC3005f interfaceC3005f, String str, P p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C2990a c2990a, A a2, i iVar, MetricsRecorder metricsRecorder);

    InterstitialAd a(Context context, InterfaceC3005f interfaceC3005f, String str, P p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C2990a c2990a, MetricsRecorder metricsRecorder);

    NativeAd a(Context context, InterfaceC3005f interfaceC3005f, com.moloco.sdk.internal.services.n nVar, String str, P p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, A a2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C2990a c2990a, I i, MetricsRecorder metricsRecorder);

    Banner b(Context context, InterfaceC3005f interfaceC3005f, String str, P p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C2990a c2990a, A a2, i iVar, MetricsRecorder metricsRecorder);

    RewardedInterstitialAd b(Context context, InterfaceC3005f interfaceC3005f, String str, P p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C2990a c2990a, MetricsRecorder metricsRecorder);

    Banner c(Context context, InterfaceC3005f interfaceC3005f, String str, P p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C2990a c2990a, A a2, i iVar, MetricsRecorder metricsRecorder);
}
