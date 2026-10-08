package com.google.unity.ads.decagon;

import com.google.android.libraries.ads.mobile.sdk.MobileAds;
import com.google.android.libraries.ads.mobile.sdk.common.RequestConfiguration;

/* JADX INFO: loaded from: classes5.dex */
class MobileAdsWrapper {
    MobileAdsWrapper() {
    }

    RequestConfiguration getRequestConfiguration() {
        return MobileAds.getRequestConfiguration();
    }

    String getVersionString() {
        return MobileAds.getVersion().toString();
    }
}
