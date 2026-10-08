package com.google.ads.mediation.unity;

import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.banners.BannerView;

/* JADX INFO: loaded from: classes8.dex */
class UnityBannerViewWrapper {
    private final BannerView bannerView;

    UnityBannerViewWrapper(BannerView bannerView) {
        this.bannerView = bannerView;
    }

    public void setListener(BannerView.IListener iListener) {
        this.bannerView.setListener(iListener);
    }

    public void load(UnityAdsLoadOptions unityAdsLoadOptions) {
        this.bannerView.load(unityAdsLoadOptions);
    }

    public BannerView getBannerView() {
        return this.bannerView;
    }
}
