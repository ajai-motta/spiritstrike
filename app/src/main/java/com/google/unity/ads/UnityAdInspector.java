package com.google.unity.ads;

import android.app.Activity;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class UnityAdInspector {
    private UnityAdInspector() {
    }

    public static void openAdInspector(final Activity activity, final UnityAdInspectorListener adInspectorListener) {
        activity.runOnUiThread(new Runnable() { // from class: com.google.unity.ads.UnityAdInspector.1
            @Override // java.lang.Runnable
            public void run() {
                Activity activity2 = activity;
                final UnityAdInspectorListener unityAdInspectorListener = adInspectorListener;
                MobileAds.openAdInspector(activity2, new OnAdInspectorClosedListener(this) { // from class: com.google.unity.ads.UnityAdInspector.1.1
                    {
                        Objects.requireNonNull(this);
                    }

                    @Override // com.google.android.gms.ads.OnAdInspectorClosedListener
                    public void onAdInspectorClosed(AdInspectorError adInspectorError) {
                        UnityAdInspectorListener unityAdInspectorListener2 = unityAdInspectorListener;
                        if (unityAdInspectorListener2 != null) {
                            unityAdInspectorListener2.onAdInspectorClosed(adInspectorError);
                        }
                    }
                });
            }
        });
    }
}
