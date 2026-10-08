package com.google.unity.ads.decagon;

import android.app.Activity;
import com.google.android.libraries.ads.mobile.sdk.MobileAds;
import com.google.android.libraries.ads.mobile.sdk.common.AdInspectorError;
import com.google.android.libraries.ads.mobile.sdk.common.OnAdInspectorClosedListener;

/* JADX INFO: loaded from: classes5.dex */
public final class UnityAdInspector {
    private UnityAdInspector() {
    }

    public static void openAdInspector(final Activity activity, final UnityAdInspectorListener adInspectorListener) {
        MobileAds.openAdInspector(new OnAdInspectorClosedListener() { // from class: com.google.unity.ads.decagon.UnityAdInspector.1
            public void onAdInspectorClosed(AdInspectorError adInspectorError) {
                UnityAdInspectorListener unityAdInspectorListener = adInspectorListener;
                if (unityAdInspectorListener != null) {
                    unityAdInspectorListener.onAdInspectorClosed(adInspectorError);
                }
            }
        });
    }
}
