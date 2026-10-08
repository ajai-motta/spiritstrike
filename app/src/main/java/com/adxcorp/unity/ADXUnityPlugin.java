package com.adxcorp.unity;

import android.app.Activity;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.gdpr.ADXGDPR;
import com.unity3d.player.UnityPlayer;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class ADXUnityPlugin {
    public static void UnitySendMessage(String str, String... strArr) {
        JSONArray jSONArray = new JSONArray();
        for (String str2 : strArr) {
            jSONArray.put(str2);
        }
        UnityPlayer.UnitySendMessage("ADXGDPR", str, jSONArray.toString());
    }

    public static int getConsentState() {
        return ADXGdprManager.getResultGDPR(getActivity());
    }

    public static void setConsentState(final int i) {
        runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.unity.ADXUnityPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                ADXGdprManager.saveResultGDPR(ADXUnityPlugin.getActivity(), ADXGDPR.ADXConsentState.values()[i]);
            }
        });
    }

    public static String getPrivacyURL() {
        return ADXGdprManager.getPrivacyURL();
    }

    protected static Activity getActivity() {
        return UnityPlayer.currentActivity;
    }

    protected static void runSafelyOnUiThread(final Runnable runnable) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.adxcorp.unity.ADXUnityPlugin.2
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
