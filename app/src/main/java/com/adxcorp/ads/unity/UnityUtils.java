package com.adxcorp.ads.unity;

import android.app.Activity;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class UnityUtils {
    public static Activity getActivity() {
        return UnityPlayer.currentActivity;
    }

    public static void runSafelyOnUiThread(final Runnable runnable) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
