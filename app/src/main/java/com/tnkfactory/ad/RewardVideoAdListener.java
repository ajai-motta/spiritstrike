package com.tnkfactory.ad;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RewardVideoAdListener extends AdListener {
    public void onShowFail(AdItem adItem, AdError adError) {
        Logger.d(adItem.getPlacementId() + " onError : " + adError.getMessage());
    }
}
