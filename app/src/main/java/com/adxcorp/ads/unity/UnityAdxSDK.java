package com.adxcorp.ads.unity;

import android.util.Log;
import com.adxcorp.ads.ADXConfiguration;
import com.adxcorp.ads.ADXSdk;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.unity3d.player.UnityPlayer;

/* JADX INFO: loaded from: classes2.dex */
public class UnityAdxSDK {
    private static String TAG = "UnityAdxSDK";
    private static UnityAdxSDK instance;

    public interface OnInitializedListener {
        void onCompleted(boolean z, int i);
    }

    public interface OnPrivacyOptionsFormListener {
        void onCompleted(boolean z);
    }

    public static UnityAdxSDK getInstance() {
        if (instance == null) {
            instance = new UnityAdxSDK();
        }
        return instance;
    }

    public static ADXConfiguration.GdprType getGdprType(int i) {
        if (i == 1) {
            return ADXConfiguration.GdprType.POPUP_LOCATION;
        }
        if (i == 2) {
            return ADXConfiguration.GdprType.POPUP_DEBUG;
        }
        if (i == 3) {
            return ADXConfiguration.GdprType.DIRECT_NOT_REQUIRED;
        }
        if (i == 4) {
            return ADXConfiguration.GdprType.DIRECT_DENIED;
        }
        if (i == 5) {
            return ADXConfiguration.GdprType.DIRECT_CONFIRM;
        }
        return ADXConfiguration.GdprType.DIRECT_UNKNOWN;
    }

    public static int getADXConsentStateInt(ADXGDPR.ADXConsentState aDXConsentState) {
        if (aDXConsentState == ADXGDPR.ADXConsentState.ADXConsentStateUnknown) {
            return 0;
        }
        if (aDXConsentState == ADXGDPR.ADXConsentState.ADXConsentStateNotRequired) {
            return 1;
        }
        if (aDXConsentState == ADXGDPR.ADXConsentState.ADXConsentStateDenied) {
            return 2;
        }
        return aDXConsentState == ADXGDPR.ADXConsentState.ADXConsentStateConfirm ? 3 : 0;
    }

    public void initialize(final ADXConfiguration aDXConfiguration) {
        Log.d(TAG, "initialize : " + aDXConfiguration.getAppId() + ", " + aDXConfiguration.getGdprType());
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityAdxSDK.1
            @Override // java.lang.Runnable
            public void run() {
                ADXSdk.getInstance().initialize(UnityPlayer.currentActivity, aDXConfiguration, null);
            }
        });
    }

    public void initialize(final ADXConfiguration aDXConfiguration, final OnInitializedListener onInitializedListener) {
        Log.d(TAG, "initialize : " + aDXConfiguration.getAppId() + ", " + aDXConfiguration.getGdprType());
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityAdxSDK.2
            @Override // java.lang.Runnable
            public void run() {
                ADXSdk.getInstance().initialize(UnityPlayer.currentActivity, aDXConfiguration, new ADXSdk.OnInitializedListener() { // from class: com.adxcorp.ads.unity.UnityAdxSDK.2.1
                    @Override // com.adxcorp.ads.ADXSdk.OnInitializedListener
                    public void onCompleted(boolean z, ADXGDPR.ADXConsentState aDXConsentState) {
                        if (onInitializedListener != null) {
                            onInitializedListener.onCompleted(z, UnityAdxSDK.getADXConsentStateInt(aDXConsentState));
                        }
                    }
                });
            }
        });
    }

    public void setLogEnabled(boolean z) {
        ADXLogUtil.setLogEnable(z);
    }

    public boolean isInitialized() {
        return ADXSdk.getInstance().isInitialized();
    }

    public void showGDPRForm(final OnPrivacyOptionsFormListener onPrivacyOptionsFormListener) {
        Log.d(TAG, "showGDPRForm");
        UnityUtils.runSafelyOnUiThread(new Runnable() { // from class: com.adxcorp.ads.unity.UnityAdxSDK.3
            @Override // java.lang.Runnable
            public void run() {
                ADXSdk.getInstance().showGDPRForm(UnityPlayer.currentActivity, new ADXSdk.OnPrivacyOptionsFormListener() { // from class: com.adxcorp.ads.unity.UnityAdxSDK.3.1
                    @Override // com.adxcorp.ads.ADXSdk.OnPrivacyOptionsFormListener
                    public void onCompleted(boolean z) {
                        if (onPrivacyOptionsFormListener != null) {
                            onPrivacyOptionsFormListener.onCompleted(z);
                        }
                    }
                });
            }
        });
    }
}
