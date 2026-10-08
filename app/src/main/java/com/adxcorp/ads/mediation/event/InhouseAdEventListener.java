package com.adxcorp.ads.mediation.event;

import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.mediation.common.AdResponse;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public interface InhouseAdEventListener {
    void notifyAdClicked();

    void notifyAdDismissed();

    void notifyAdFailedToLoad(int i);

    void notifyAdLoaded(Object... objArr);

    void notifyAdShown();

    void notifyMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings, NewsFeed newsFeed);

    void notifyVideoAdCompleted();

    void notifyVideoAdError();

    void notifyVideoAdPaused();

    void notifyVideoAdSkipped();

    void notifyVideoAdStarted();

    void notifyVideoAdStopped();

    void receivedResponse(AdResponse adResponse);
}
