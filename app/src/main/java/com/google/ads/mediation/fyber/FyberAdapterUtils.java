package com.google.ads.mediation.fyber;

import android.os.Bundle;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;

/* JADX INFO: loaded from: classes8.dex */
class FyberAdapterUtils {
    private FyberAdapterUtils() {
    }

    public static String getSdkVersion() {
        return InneractiveAdManager.getVersion();
    }

    public static String getAdapterVersion() {
        return BuildConfig.ADAPTER_VERSION;
    }

    static void updateFyberExtraParams(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        InneractiveUserConfig inneractiveUserConfig = new InneractiveUserConfig();
        if (bundle.containsKey(InneractiveMediationDefs.KEY_AGE)) {
            inneractiveUserConfig.setAge(bundle.getInt(InneractiveMediationDefs.KEY_AGE, 0));
        }
        InneractiveAdManager.setUserParams(inneractiveUserConfig);
        InneractiveAdManager.setMuteVideo(true);
    }
}
