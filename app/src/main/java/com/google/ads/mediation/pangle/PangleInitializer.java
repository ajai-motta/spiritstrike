package com.google.ads.mediation.pangle;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes8.dex */
public class PangleInitializer implements PAGSdk.PAGInitCallback {
    private static PangleInitializer instance;
    private final ArrayList<Listener> initListeners;
    private boolean isInitialized;
    private boolean isInitializing;
    private final PangleFactory pangleFactory;
    private final PangleSdkWrapper pangleSdkWrapper;

    public interface Listener {
        void onInitializeError(AdError adError);

        void onInitializeSuccess();
    }

    public static PangleInitializer getInstance() {
        if (instance == null) {
            instance = new PangleInitializer();
        }
        return instance;
    }

    private PangleInitializer() {
        this.isInitializing = false;
        this.isInitialized = false;
        this.initListeners = new ArrayList<>();
        this.pangleSdkWrapper = new PangleSdkWrapper();
        this.pangleFactory = new PangleFactory();
    }

    public PangleInitializer(PangleSdkWrapper pangleSdkWrapper, PangleFactory pangleFactory) {
        this.isInitializing = false;
        this.isInitialized = false;
        this.initListeners = new ArrayList<>();
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    public void initialize(Context context, String str, Listener listener) {
        if (TextUtils.isEmpty(str)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to initialize Pangle SDK. Missing or invalid App ID.");
            Log.w(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            listener.onInitializeError(adErrorCreateAdapterError);
        } else if (this.isInitializing) {
            this.initListeners.add(listener);
        } else {
            if (this.isInitialized) {
                listener.onInitializeSuccess();
                return;
            }
            this.isInitializing = true;
            this.initListeners.add(listener);
            this.pangleSdkWrapper.init(context, this.pangleFactory.createPAGConfigBuilder().appId(str).setAdxId(PangleConstants.ADX_ID).setGDPRConsent(PangleMediationAdapter.getGDPRConsent()).setUserData(String.format("[{\"name\":\"mediation\",\"value\":\"google\"},{\"name\":\"adapter_version\",\"value\":\"%s\"}]", BuildConfig.ADAPTER_VERSION)).build(), this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
    public void success() {
        this.isInitializing = false;
        this.isInitialized = true;
        Iterator<Listener> it = this.initListeners.iterator();
        while (it.hasNext()) {
            it.next().onInitializeSuccess();
        }
        this.initListeners.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
    public void fail(int i, String str) {
        this.isInitializing = false;
        this.isInitialized = false;
        AdError adErrorCreateSdkError = PangleConstants.createSdkError(i, str);
        Iterator<Listener> it = this.initListeners.iterator();
        while (it.hasNext()) {
            it.next().onInitializeError(adErrorCreateSdkError);
        }
        this.initListeners.clear();
    }
}
