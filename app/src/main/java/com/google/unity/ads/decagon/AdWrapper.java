package com.google.unity.ads.decagon;

import com.google.android.libraries.ads.mobile.sdk.appopen.AppOpenAd;
import com.google.android.libraries.ads.mobile.sdk.common.AdLoadCallback;
import com.google.android.libraries.ads.mobile.sdk.common.AdRequest;
import com.google.android.libraries.ads.mobile.sdk.interstitial.InterstitialAd;
import com.google.android.libraries.ads.mobile.sdk.rewarded.RewardedAd;
import com.google.android.libraries.ads.mobile.sdk.rewardedinterstitial.RewardedInterstitialAd;

/* JADX INFO: loaded from: classes5.dex */
class AdWrapper<T> {
    private final AdLoader<T> adLoader;

    interface AdLoader<T> {
        void load(AdRequest adRequest, AdLoadCallback<T> callback);
    }

    public AdWrapper(AdLoader<T> adLoader) {
        this.adLoader = adLoader;
    }

    public void load(AdRequest adRequest, AdLoadCallback<T> callback) {
        this.adLoader.load(adRequest, callback);
    }

    public static AdWrapper<AppOpenAd> forAppOpen() {
        return new AdWrapper<>(new AdLoader() { // from class: com.google.unity.ads.decagon.AdWrapper$$ExternalSyntheticLambda3
            @Override // com.google.unity.ads.decagon.AdWrapper.AdLoader
            public final void load(AdRequest adRequest, AdLoadCallback adLoadCallback) {
                AppOpenAd.load(adRequest, adLoadCallback);
            }
        });
    }

    public static AdWrapper<InterstitialAd> forInterstitial() {
        return new AdWrapper<>(new AdLoader() { // from class: com.google.unity.ads.decagon.AdWrapper$$ExternalSyntheticLambda1
            @Override // com.google.unity.ads.decagon.AdWrapper.AdLoader
            public final void load(AdRequest adRequest, AdLoadCallback adLoadCallback) {
                InterstitialAd.load(adRequest, adLoadCallback);
            }
        });
    }

    public static AdWrapper<RewardedAd> forRewarded() {
        return new AdWrapper<>(new AdLoader() { // from class: com.google.unity.ads.decagon.AdWrapper$$ExternalSyntheticLambda2
            @Override // com.google.unity.ads.decagon.AdWrapper.AdLoader
            public final void load(AdRequest adRequest, AdLoadCallback adLoadCallback) {
                RewardedAd.load(adRequest, adLoadCallback);
            }
        });
    }

    public static AdWrapper<RewardedInterstitialAd> forRewardedInterstitial() {
        return new AdWrapper<>(new AdLoader() { // from class: com.google.unity.ads.decagon.AdWrapper$$ExternalSyntheticLambda0
            @Override // com.google.unity.ads.decagon.AdWrapper.AdLoader
            public final void load(AdRequest adRequest, AdLoadCallback adLoadCallback) {
                RewardedInterstitialAd.load(adRequest, adLoadCallback);
            }
        });
    }
}
