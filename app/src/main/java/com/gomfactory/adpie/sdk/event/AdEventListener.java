package com.gomfactory.adpie.sdk.event;

import com.gomfactory.adpie.sdk.common.AdResponse;

/* JADX INFO: loaded from: classes3.dex */
public interface AdEventListener {
    void notifyAdClicked();

    void notifyAdDismissed();

    void notifyAdFailedToLoad(int i);

    void notifyAdLoaded(Object... objArr);

    void notifyAdShown();

    void notifyVideoAdCompleted();

    void notifyVideoAdError();

    void notifyVideoAdPaused();

    void notifyVideoAdSkipped();

    void notifyVideoAdStarted();

    void notifyVideoAdStopped();

    void receivedResponse(AdResponse adResponse);
}
