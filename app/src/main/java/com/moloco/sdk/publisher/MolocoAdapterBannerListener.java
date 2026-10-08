package com.moloco.sdk.publisher;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/moloco/sdk/publisher/MolocoAdapterBannerListener;", "Lcom/moloco/sdk/publisher/BannerAdShowListener;", "onAdLoaded", "", "ad", "Lcom/moloco/sdk/publisher/MolocoAd;", "view", "Lcom/moloco/sdk/publisher/Banner;", "onAdLoadFailed", "error", "Lcom/moloco/sdk/publisher/MolocoAdError;", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MolocoAdapterBannerListener extends BannerAdShowListener {
    void onAdLoadFailed(MolocoAdError error);

    void onAdLoaded(MolocoAd ad, Banner view);
}
