package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.InterfaceC3005f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.publisher.RewardedInterstitialAdShowListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class G {

    public static final class a implements RewardedInterstitialAdShowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2158a = "RewardedInterstitialAdShowListenerImpl";
        public boolean b;
        public final /* synthetic */ Function0<Boolean> c;
        public final /* synthetic */ RewardedInterstitialAdShowListener d;
        public final /* synthetic */ boolean e;

        public a(Function0<Boolean> function0, RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, boolean z) {
            this.c = function0;
            this.d = rewardedInterstitialAdShowListener;
            this.e = z;
        }

        public final void a(MolocoAd molocoAd) {
            if (this.b) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f2158a, "issuing of reward is already handled", false, 4, null);
                return;
            }
            this.b = true;
            if (!Intrinsics.areEqual(this.c.invoke(), Boolean.FALSE)) {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f2158a, "reward can't be issued: ad was forcibly closed or ad was missing", false, 4, null);
            } else {
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, this.f2158a, "issuing of reward...", false, 4, null);
                onUserRewarded(molocoAd);
            }
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdClicked(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            this.d.onAdClicked(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdHidden(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            a(molocoAd);
            this.d.onAdHidden(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowFailed(MolocoAdError molocoAdError) {
            Intrinsics.checkNotNullParameter(molocoAdError, "molocoAdError");
            this.d.onAdShowFailed(molocoAdError);
        }

        @Override // com.moloco.sdk.publisher.AdShowListener
        public void onAdShowSuccess(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            this.d.onAdShowSuccess(molocoAd);
            if (this.e) {
                onRewardedVideoStarted(molocoAd);
            }
        }

        @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
        public void onRewardedVideoCompleted(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            a(molocoAd);
            this.d.onRewardedVideoCompleted(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
        public void onRewardedVideoStarted(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            this.d.onRewardedVideoStarted(molocoAd);
        }

        @Override // com.moloco.sdk.publisher.RewardedInterstitialAdShowListener
        public void onUserRewarded(MolocoAd molocoAd) {
            Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
            this.d.onUserRewarded(molocoAd);
        }
    }

    public static final RewardedInterstitialAd a(Context context, InterfaceC3005f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adUnitId, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, t<RewardedInterstitialAdShowListener> adDataHolder, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C2990a adCreateLoadTimeoutManager, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(adDataHolder, "adDataHolder");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        return new F(new u(context, appLifecycleTrackerService, customUserEventBuilderService, adUnitId, persistentHttpRequest, externalLinkHandler, new Function1() { // from class: com.moloco.sdk.internal.publisher.G$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return G.a((com.moloco.sdk.internal.ortb.model.v) obj);
            }
        }, adDataHolder, AdFormatType.REWARDED, watermark, adCreateLoadTimeoutManager, metricsRecorder), adUnitId);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h a(com.moloco.sdk.internal.ortb.model.v vVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h hVarB;
        return (vVar == null || (hVarB = com.moloco.sdk.internal.d.b(vVar)) == null) ? com.moloco.sdk.internal.d.b() : hVarB;
    }

    public static final RewardedInterstitialAdShowListener a(RewardedInterstitialAdShowListener listenerTracker, boolean z, Function0<Boolean> isAdForciblyClosed) {
        Intrinsics.checkNotNullParameter(listenerTracker, "listenerTracker");
        Intrinsics.checkNotNullParameter(isAdForciblyClosed, "isAdForciblyClosed");
        return new a(isAdForciblyClosed, listenerTracker, z);
    }

    public static final RewardedInterstitialAdShowListener a(RewardedInterstitialAdShowListener rewardedInterstitialAdShowListener, Function0<com.moloco.sdk.internal.ortb.model.x> provideSdkEvents) {
        Intrinsics.checkNotNullParameter(provideSdkEvents, "provideSdkEvents");
        return new H(rewardedInterstitialAdShowListener, provideSdkEvents, com.moloco.sdk.internal.y.b());
    }
}
