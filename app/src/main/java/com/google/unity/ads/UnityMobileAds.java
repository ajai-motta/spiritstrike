package com.google.unity.ads;

import android.app.Activity;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class UnityMobileAds {
    public static void initialize(Activity activity, OnInitializationCompleteListener listener) {
        if (activity == null) {
            return;
        }
        MobileAds.initialize(activity, listener);
    }

    public static void setAppVolume(float volume) {
        MobileAds.setAppVolume(volume);
    }

    public static void disableMediationAdapterInitialization(Activity activity) {
        if (activity == null) {
            return;
        }
        MobileAds.disableMediationAdapterInitialization(activity);
    }

    public static void setAppMuted(boolean muted) {
        MobileAds.setAppMuted(muted);
    }

    public static boolean putPublisherFirstPartyIdEnabled(boolean enabled) {
        return MobileAds.putPublisherFirstPartyIdEnabled(enabled);
    }

    public static void setRequestConfiguration(RequestConfiguration config) {
        if (config == null) {
            return;
        }
        MobileAds.setRequestConfiguration(config);
    }

    public static RequestConfiguration getRequestConfiguration() {
        return MobileAds.getRequestConfiguration();
    }

    public static void openAdInspector(Activity activity, UnityAdInspectorListener listener) {
        if (activity == null) {
            return;
        }
        UnityAdInspector.openAdInspector(activity, listener);
    }

    public static void startPreload(Activity activity, List<PreloadConfiguration> configs, PreloadCallback callback) {
        if (activity == null) {
            return;
        }
        MobileAds.startPreload(activity, configs, callback);
    }

    public static void setPlugin(String version) {
        try {
            Method declaredMethod = MobileAds.class.getDeclaredMethod("setPlugin", String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, version);
        } catch (Exception unused) {
        }
    }

    public static String getSdkVersionString() {
        return MobileAds.getVersion().toString();
    }

    private UnityMobileAds() {
    }
}
