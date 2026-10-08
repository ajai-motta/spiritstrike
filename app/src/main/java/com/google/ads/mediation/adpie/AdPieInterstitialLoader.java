package com.google.ads.mediation.adpie;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.adxcorp.util.ADXLogUtil;
import com.gomfactory.adpie.sdk.AdPieError;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.InterstitialAd;
import com.google.ads.mediation.AdErrorUtil;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class AdPieInterstitialLoader implements MediationInterstitialAd, InterstitialAd.InterstitialAdListener {
    private static final String APP_ID = "app_id";
    private static final String DOMAIN = "com.google.ads.mediation.adpie";
    private static final String SLOT_ID = "slot_id";
    private String TAG = "AdPieInterstitialLoader";
    private MediationInterstitialAdCallback interstitialAdCallback;
    private String mAppId;
    private InterstitialAd mInterstitialAd;
    private String mSlotId;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback;
    private final MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration;

    public AdPieInterstitialLoader(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.mediationInterstitialAdConfiguration = mediationInterstitialAdConfiguration;
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    public void loadAd() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        try {
            Log.d(this.TAG, "severParameters : " + this.mediationInterstitialAdConfiguration.getServerParameters());
            JSONObject jSONObject = new JSONObject(this.mediationInterstitialAdConfiguration.getServerParameters().getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD));
            this.mAppId = jSONObject.getString("app_id");
            this.mSlotId = jSONObject.getString(SLOT_ID);
            Log.d(this.TAG, "AppId : " + this.mAppId + ", SlotId : " + this.mSlotId);
            if (TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.mSlotId)) {
                this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(101, "Parameters are invalid.", DOMAIN));
                return;
            }
            final Context context = this.mediationInterstitialAdConfiguration.getContext();
            if (!AdPieSDK.getInstance().isInitialized()) {
                AdPieSDK.getInstance().initialize(context, this.mAppId, new AdPieSDK.OnInitializedListener() { // from class: com.google.ads.mediation.adpie.AdPieInterstitialLoader.1
                    @Override // com.gomfactory.adpie.sdk.AdPieSDK.OnInitializedListener
                    public void onCompleted(boolean z) {
                        if (!z) {
                            AdPieInterstitialLoader.this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(104, "Failed to initialize SDK.", AdPieInterstitialLoader.DOMAIN));
                        } else {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.ads.mediation.adpie.AdPieInterstitialLoader.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdPieInterstitialLoader.this.mInterstitialAd = new InterstitialAd(context, AdPieInterstitialLoader.this.mSlotId);
                                    AdPieInterstitialLoader.this.mInterstitialAd.setAdListener(AdPieInterstitialLoader.this);
                                    AdPieInterstitialLoader.this.mInterstitialAd.load();
                                }
                            });
                        }
                    }
                });
                return;
            }
            InterstitialAd interstitialAd = new InterstitialAd(context, this.mSlotId);
            this.mInterstitialAd = interstitialAd;
            interstitialAd.setAdListener(this);
            this.mInterstitialAd.load();
        } catch (Exception e) {
            e.printStackTrace();
            this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(101, "Parameters are invalid.", DOMAIN));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(Context context) {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null && interstitialAd.isLoaded()) {
            this.mInterstitialAd.show();
            return;
        }
        Log.d(this.TAG, "Interstitial ad not ready");
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        this.interstitialAdCallback.onAdFailedToShow(AdErrorUtil.createSDKError(0, "No ad to show.", DOMAIN));
    }

    @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
    public void onAdLoaded() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
        this.interstitialAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
    public void onAdFailedToLoad(int i) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Failure, " + i + AdPieError.getMessage(i));
        this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(i, AdPieError.getMessage(i), DOMAIN));
    }

    @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
    public void onAdShown() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, "Impression");
        this.interstitialAdCallback.reportAdImpression();
        this.interstitialAdCallback.onAdOpened();
    }

    @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
    public void onAdClicked() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
        this.interstitialAdCallback.reportAdClicked();
        this.interstitialAdCallback.onAdLeftApplication();
    }

    @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
    public void onAdDismissed() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
        this.interstitialAdCallback.onAdClosed();
    }

    @Override // com.gomfactory.adpie.sdk.InterstitialAd.InterstitialAdListener
    public void onAdFailedToShow() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
        this.interstitialAdCallback.onAdFailedToShow(AdErrorUtil.createSDKError(103, "Failed To show", DOMAIN));
    }
}
