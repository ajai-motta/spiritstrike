package com.google.unity.ads.decagon;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.libraries.ads.mobile.sdk.MobileAds;
import com.google.android.libraries.ads.mobile.sdk.common.RequestConfiguration;
import com.google.android.libraries.ads.mobile.sdk.initialization.InitializationConfig;
import com.google.android.libraries.ads.mobile.sdk.initialization.InitializationStatus;
import com.google.android.libraries.ads.mobile.sdk.initialization.OnAdapterInitializationCompleteListener;

/* JADX INFO: loaded from: classes5.dex */
public final class UnityMobileAds {
    private static final String APPLICATION_ID_KEY = "com.google.android.gms.ads.APPLICATION_ID";
    private static final String TAG = "UnityMobileAds";
    private static volatile RequestConfiguration requestConfiguration;
    private static MobileAdsWrapper mobileAdsWrapper = new MobileAdsWrapper();
    private static final Object stateLock = new Object();
    private static volatile boolean isMobileAdsInitialized = false;
    private static volatile float userVolume = -1.0f;
    private static volatile boolean isMuted = false;
    private static volatile boolean isPublisherFirstPartyIdEnabled = false;

    private UnityMobileAds() {
    }

    static void setMobileAdsWrapper(MobileAdsWrapper wrapper) {
        mobileAdsWrapper = wrapper;
    }

    public static void initialize(final Activity activity, final OnAdapterInitializationCompleteListener callback) {
        String applicationMetaData = getApplicationMetaData(activity, APPLICATION_ID_KEY);
        if (applicationMetaData == null) {
            Log.e(TAG, "Application ID is null. Cannot initialize the Google Mobile Ads SDK.");
            return;
        }
        InitializationConfig.Builder builder = new InitializationConfig.Builder(applicationMetaData);
        synchronized (stateLock) {
            if (requestConfiguration != null) {
                builder = builder.setRequestConfiguration(requestConfiguration);
            }
        }
        final InitializationConfig initializationConfigBuild = builder.build();
        new Thread(new Runnable() { // from class: com.google.unity.ads.decagon.UnityMobileAds$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MobileAds.initialize(activity, initializationConfigBuild, new OnAdapterInitializationCompleteListener() { // from class: com.google.unity.ads.decagon.UnityMobileAds$$ExternalSyntheticLambda0
                    public final void onAdapterInitializationComplete(InitializationStatus initializationStatus) {
                        UnityMobileAds.lambda$initialize$1(onAdapterInitializationCompleteListener, initializationStatus);
                    }
                });
            }
        }).start();
    }

    static /* synthetic */ void lambda$initialize$1(OnAdapterInitializationCompleteListener onAdapterInitializationCompleteListener, InitializationStatus initializationStatus) {
        synchronized (stateLock) {
            isMobileAdsInitialized = true;
            requestConfiguration = null;
            if (isPublisherFirstPartyIdEnabled) {
                MobileAds.putPublisherFirstPartyIdEnabled(true);
                isPublisherFirstPartyIdEnabled = false;
            }
            if (userVolume >= 0.0f) {
                MobileAds.setUserControlledAppVolume(userVolume);
                userVolume = -1.0f;
            }
            if (isMuted) {
                MobileAds.setUserMutedApp(isMuted);
                isMuted = false;
            }
        }
        onAdapterInitializationCompleteListener.onAdapterInitializationComplete(initializationStatus);
    }

    public static void setRequestConfiguration(RequestConfiguration config) {
        synchronized (stateLock) {
            if (!isMobileAdsInitialized) {
                requestConfiguration = config;
            } else {
                MobileAds.setRequestConfiguration(config);
            }
        }
    }

    public static RequestConfiguration getRequestConfiguration() {
        return mobileAdsWrapper.getRequestConfiguration();
    }

    public static boolean putPublisherFirstPartyIdEnabled(boolean enabled) {
        synchronized (stateLock) {
            if (!isMobileAdsInitialized) {
                isPublisherFirstPartyIdEnabled = enabled;
                return true;
            }
            return MobileAds.putPublisherFirstPartyIdEnabled(enabled);
        }
    }

    public static void setUserControlledAppVolume(float volume) {
        synchronized (stateLock) {
            if (!isMobileAdsInitialized) {
                userVolume = volume;
            } else {
                MobileAds.setUserControlledAppVolume(volume);
            }
        }
    }

    public static void setApplicationMuted(boolean muted) {
        synchronized (stateLock) {
            if (!isMobileAdsInitialized) {
                isMuted = muted;
            } else {
                MobileAds.setUserMutedApp(muted);
            }
        }
    }

    public static String getSdkVersionString() {
        return mobileAdsWrapper.getVersionString();
    }

    private static String getApplicationMetaData(Activity activity, String key) {
        Bundle bundle;
        if (activity == null) {
            Log.e(TAG, "Unity Activity is null. Cannot read Application ID.");
            return null;
        }
        try {
            bundle = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128).metaData;
        } catch (Exception e) {
            Log.e(TAG, "Error reading application ID from manifest: " + e.getMessage());
        }
        if (bundle == null || !bundle.containsKey(key)) {
            Log.e(TAG, "Application ID not found in manifest!");
            return null;
        }
        return bundle.getString(key);
    }
}
