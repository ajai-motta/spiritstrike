package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
class FacebookInitializer implements AudienceNetworkAds.InitListener {
    private static FacebookInitializer instance;
    private boolean isInitializing = false;
    private boolean isInitialized = false;
    private final ArrayList<Listener> listeners = new ArrayList<>();

    interface Listener {
        void onInitializeError(AdError adError);

        void onInitializeSuccess();
    }

    static FacebookInitializer getInstance() {
        if (instance == null) {
            instance = new FacebookInitializer();
        }
        return instance;
    }

    private FacebookInitializer() {
    }

    void initialize(Context context, String str, Listener listener) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        getInstance().initialize(context, arrayList, listener);
    }

    void initialize(Context context, ArrayList<String> arrayList, Listener listener) {
        if (this.isInitializing) {
            this.listeners.add(listener);
            return;
        }
        if (this.isInitialized) {
            listener.onInitializeSuccess();
            return;
        }
        this.isInitializing = true;
        getInstance().listeners.add(listener);
        AudienceNetworkAds.buildInitSettings(context).withMediationService("GOOGLE:" + BuildConfig.ADAPTER_VERSION).withPlacementIds(arrayList).withInitListener(this).initialize();
    }

    @Override // com.facebook.ads.AudienceNetworkAds.InitListener
    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        this.isInitializing = false;
        this.isInitialized = initResult.isSuccess();
        for (Listener listener : this.listeners) {
            if (initResult.isSuccess()) {
                listener.onInitializeSuccess();
            } else {
                listener.onInitializeError(new AdError(104, initResult.getMessage(), FacebookMediationAdapter.ERROR_DOMAIN));
            }
        }
        this.listeners.clear();
    }
}
