package com.google.ads.mediation.adpie;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.adxcorp.util.ADXLogUtil;
import com.gomfactory.adpie.sdk.AdPieError;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.AdView;
import com.google.ads.mediation.AdErrorUtil;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class AdPieBannerLoader implements MediationBannerAd, AdView.AdListener {
    private static final String APP_ID = "app_id";
    private static final String DOMAIN = "com.google.ads.mediation.adpie";
    private static final String SLOT_ID = "slot_id";
    private String TAG = "AdPieBannerLoader";
    private MediationBannerAdCallback bannerAdCallback;
    private AdView mAdView;
    private String mAppId;
    private String mSlotId;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback;
    private final MediationBannerAdConfiguration mediationBannerAdConfiguration;

    public AdPieBannerLoader(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.mediationBannerAdConfiguration = mediationBannerAdConfiguration;
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    public void loadAd() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        try {
            Log.d(this.TAG, "severParameters : " + this.mediationBannerAdConfiguration.getServerParameters());
            JSONObject jSONObject = new JSONObject(this.mediationBannerAdConfiguration.getServerParameters().getString(MediationConfiguration.CUSTOM_EVENT_SERVER_PARAMETER_FIELD));
            this.mAppId = jSONObject.getString("app_id");
            this.mSlotId = jSONObject.getString(SLOT_ID);
            Log.d(this.TAG, "AppId : " + this.mAppId + ", SlotId : " + this.mSlotId);
            if (TextUtils.isEmpty(this.mAppId) || TextUtils.isEmpty(this.mSlotId)) {
                this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(101, "Parameters are invalid.", DOMAIN));
                return;
            }
            final Context context = this.mediationBannerAdConfiguration.getContext();
            if (!AdPieSDK.getInstance().isInitialized()) {
                AdPieSDK.getInstance().initialize(context, this.mAppId, new AdPieSDK.OnInitializedListener() { // from class: com.google.ads.mediation.adpie.AdPieBannerLoader.1
                    @Override // com.gomfactory.adpie.sdk.AdPieSDK.OnInitializedListener
                    public void onCompleted(boolean z) {
                        if (!z) {
                            AdPieBannerLoader.this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(104, "Failed to initialize SDK.", AdPieBannerLoader.DOMAIN));
                        } else {
                            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.google.ads.mediation.adpie.AdPieBannerLoader.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdPieBannerLoader.this.mAdView = new AdView(context);
                                    AdPieBannerLoader.this.mAdView.setSlotId(AdPieBannerLoader.this.mSlotId);
                                    AdPieBannerLoader.this.mAdView.setAdListener(AdPieBannerLoader.this);
                                    AdPieBannerLoader.this.mAdView.load();
                                }
                            });
                        }
                    }
                });
                return;
            }
            AdView adView = new AdView(context);
            this.mAdView = adView;
            adView.setSlotId(this.mSlotId);
            this.mAdView.setAdListener(this);
            this.mAdView.load();
        } catch (Exception e) {
            e.printStackTrace();
            this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(101, "Parameters are invalid.", DOMAIN));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    public View getView() {
        return this.mAdView;
    }

    @Override // com.gomfactory.adpie.sdk.AdView.AdListener
    public void onAdLoaded() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
        MediationBannerAdCallback mediationBannerAdCallbackOnSuccess = this.mediationAdLoadCallback.onSuccess(this);
        this.bannerAdCallback = mediationBannerAdCallbackOnSuccess;
        mediationBannerAdCallbackOnSuccess.reportAdImpression();
    }

    @Override // com.gomfactory.adpie.sdk.AdView.AdListener
    public void onAdFailedToLoad(int i) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, "Failure, " + i + AdPieError.getMessage(i));
        this.mediationAdLoadCallback.onFailure(AdErrorUtil.createSDKError(i, AdPieError.getMessage(i), DOMAIN));
    }

    @Override // com.gomfactory.adpie.sdk.AdView.AdListener
    public void onAdClicked() {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_ADPIE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
        this.bannerAdCallback.reportAdClicked();
        this.bannerAdCallback.onAdLeftApplication();
    }
}
