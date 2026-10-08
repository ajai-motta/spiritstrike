package com.adxcorp.ads.unity;

import com.adxcorp.ads.InterstitialAd;
import com.adxcorp.ads.common.OnPaidEventListener;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class UnityInterstitialAd {
    private InterstitialAd mInterstitialAd;

    public UnityInterstitialAd(final String str, final InterstitialAd.InterstitialListener interstitialListener) {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityInterstitialAd.1
            @Override // java.lang.Runnable
            public void run() {
                UnityInterstitialAd.this.mInterstitialAd = new InterstitialAd(UnityPlayer.currentActivity, str);
                UnityInterstitialAd.this.mInterstitialAd.setInterstitialListener(interstitialListener);
            }
        });
    }

    public void destroy() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityInterstitialAd.2
            @Override // java.lang.Runnable
            public void run() {
                if (UnityInterstitialAd.this.mInterstitialAd != null) {
                    UnityInterstitialAd.this.mInterstitialAd.destroy();
                    UnityInterstitialAd.this.mInterstitialAd = null;
                }
            }
        });
    }

    public void loadAd() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityInterstitialAd.3
            @Override // java.lang.Runnable
            public void run() {
                if (UnityInterstitialAd.this.mInterstitialAd != null) {
                    UnityInterstitialAd.this.mInterstitialAd.loadAd();
                }
            }
        });
    }

    public void show() {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityInterstitialAd.4
            @Override // java.lang.Runnable
            public void run() {
                if (UnityInterstitialAd.this.mInterstitialAd == null || !UnityInterstitialAd.this.mInterstitialAd.isLoaded()) {
                    return;
                }
                UnityInterstitialAd.this.mInterstitialAd.show();
            }
        });
    }

    public boolean isLoaded() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            return interstitialAd.isLoaded();
        }
        return false;
    }

    public void setOnPaidEventListener(final OnPaidEventListener onPaidEventListener) {
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityInterstitialAd.5
            @Override // java.lang.Runnable
            public void run() {
                if (UnityInterstitialAd.this.mInterstitialAd != null) {
                    UnityInterstitialAd.this.mInterstitialAd.setOnPaidEventListener(onPaidEventListener);
                }
            }
        });
    }
}
