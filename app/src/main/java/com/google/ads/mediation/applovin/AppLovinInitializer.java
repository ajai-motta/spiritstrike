package com.google.ads.mediation.applovin;

import android.content.Context;
import com.applovin.mediation.BuildConfig;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;

/* JADX INFO: loaded from: classes8.dex */
public class AppLovinInitializer {
    private static final String TAG = "AppLovinInitializer";
    private static AppLovinInitializer instance;
    private final AppLovinSdkWrapper appLovinSdkWrapper;

    public interface OnInitializeSuccessListener {
        void onInitializeSuccess();
    }

    private AppLovinInitializer() {
        this.appLovinSdkWrapper = new AppLovinSdkWrapper();
    }

    AppLovinInitializer(AppLovinSdkWrapper appLovinSdkWrapper) {
        this.appLovinSdkWrapper = appLovinSdkWrapper;
    }

    public static AppLovinInitializer getInstance() {
        if (instance == null) {
            instance = new AppLovinInitializer();
        }
        return instance;
    }

    public void initialize(Context context, String str, final OnInitializeSuccessListener onInitializeSuccessListener) {
        this.appLovinSdkWrapper.getInstance(context).initialize(AppLovinSdkInitializationConfiguration.builder(str).setMediationProvider("admob").setPluginVersion(BuildConfig.ADAPTER_VERSION).build(), new AppLovinSdk.SdkInitializationListener() { // from class: com.google.ads.mediation.applovin.AppLovinInitializer.1
            @Override // com.applovin.sdk.AppLovinSdk.SdkInitializationListener
            public void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                onInitializeSuccessListener.onInitializeSuccess();
            }
        });
    }

    public AppLovinSdk retrieveSdk(Context context) {
        return this.appLovinSdkWrapper.getInstance(context);
    }
}
