package com.bytedance.sdk.openadsdk.component.lnr;

import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.fco;

/* JADX INFO: loaded from: classes3.dex */
public class ud implements PAGInterstitialAdLoadListener {
    final PAGInterstitialAdLoadListener qdl;

    public ud(PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        this.qdl = pAGInterstitialAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.mo
    public void onError(final int i, final String str) {
        if (this.qdl != null) {
            fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.lnr.ud.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ud.this.qdl != null) {
                        ud.this.qdl.onError(i, str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGInterstitialAd pAGInterstitialAd) {
        if (this.qdl != null) {
            fco.qdl(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.lnr.ud.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ud.this.qdl != null) {
                        ud.this.qdl.onAdLoaded(pAGInterstitialAd);
                    }
                }
            });
        }
    }
}
