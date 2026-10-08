package com.adxcorp.ads.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.BCustomEventListener;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FyberBanner extends BannerCustomEvent {
    private static final String TAG = "FyberBanner";
    private ViewGroup mAdLayout;
    private String mAdUnitId;
    private String mAppId;
    private AdConstants.BANNER_AD_SIZE mBannerAdSize;
    private InneractiveAdSpot mBannerSpot;
    private Context mContext;
    private BCustomEventListener mCustomEventListener;
    private double mEcpm;
    private boolean mIsLoaded;

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public View getAdView() {
        return this.mAdLayout;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void loadAd(Context context, Map<String, String> map, BCustomEventListener bCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = bCustomEventListener;
        if (context == null) {
            Log.d(str, "Activity cannot be null.");
            BCustomEventListener bCustomEventListener2 = this.mCustomEventListener;
            if (bCustomEventListener2 != null) {
                bCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        this.mContext = context;
        this.mAppId = map.get("app_id");
        this.mAdUnitId = map.get("spot_id");
        try {
            this.mEcpm = Double.parseDouble(map.get("ecpm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.mAppId)) {
            Log.d(TAG, "The AppId cannot be null.");
            BCustomEventListener bCustomEventListener3 = this.mCustomEventListener;
            if (bCustomEventListener3 != null) {
                bCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(TAG, "The AdUnitId cannot be null.");
            BCustomEventListener bCustomEventListener4 = this.mCustomEventListener;
            if (bCustomEventListener4 != null) {
                bCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        if (!InneractiveAdManager.wasInitialized()) {
            initGdpr(context);
            InneractiveAdManager.initialize(context, this.mAppId, null);
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        InneractiveAdSpot inneractiveAdSpot = this.mBannerSpot;
        if (inneractiveAdSpot != null) {
            inneractiveAdSpot.destroy();
            this.mBannerSpot = null;
        }
        InneractiveAdSpot inneractiveAdSpotCreateSpot = InneractiveAdSpotManager.get().createSpot();
        this.mBannerSpot = inneractiveAdSpotCreateSpot;
        inneractiveAdSpotCreateSpot.setMediationName(InneractiveMediationName.OTHER);
        this.mBannerSpot.setMediationVersion(ADXGDPR.ADX_SDK_VERSION);
        this.mBannerSpot.addUnitController(new InneractiveAdViewUnitController());
        InneractiveAdRequest inneractiveAdRequest = new InneractiveAdRequest(this.mAdUnitId);
        this.mBannerSpot.setRequestListener(new InneractiveAdSpot.RequestListener() { // from class: com.adxcorp.ads.adapter.FyberBanner.1
            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot inneractiveAdSpot2) {
                if (FyberBanner.this.mIsLoaded) {
                    return;
                }
                FyberBanner.this.mIsLoaded = true;
                if (inneractiveAdSpot2 != FyberBanner.this.mBannerSpot) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_FAILURE);
                    ADXLogUtil.d(FyberBanner.TAG, "Wrong Banner Spot received - " + inneractiveAdSpot2 + ", Actual - " + FyberBanner.this.mBannerSpot);
                    if (FyberBanner.this.mCustomEventListener != null) {
                        FyberBanner.this.mCustomEventListener.onAdError();
                        return;
                    }
                    return;
                }
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                FyberBanner.this.mAdLayout = new FrameLayout(FyberBanner.this.mContext);
                InneractiveAdViewUnitController inneractiveAdViewUnitController = (InneractiveAdViewUnitController) FyberBanner.this.mBannerSpot.getSelectedUnitController();
                inneractiveAdViewUnitController.setEventsListener(new InneractiveAdViewEventsListener() { // from class: com.adxcorp.ads.adapter.FyberBanner.1.1
                    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
                    public void onAdCollapsed(InneractiveAdSpot inneractiveAdSpot3) {
                    }

                    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot3, InneractiveUnitController.AdDisplayError adDisplayError) {
                    }

                    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
                    public void onAdExpanded(InneractiveAdSpot inneractiveAdSpot3) {
                    }

                    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot3) {
                    }

                    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener
                    public void onAdResized(InneractiveAdSpot inneractiveAdSpot3) {
                    }

                    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot3) {
                    }

                    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot3) {
                    }

                    @Override // com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener, com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener
                    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot3) {
                        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                        if (FyberBanner.this.mCustomEventListener != null) {
                            FyberBanner.this.mCustomEventListener.onAdClicked();
                        }
                    }
                });
                inneractiveAdViewUnitController.bindView(FyberBanner.this.mAdLayout);
                if (FyberBanner.this.mCustomEventListener != null) {
                    FyberBanner.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot.RequestListener
            public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot2, InneractiveErrorCode inneractiveErrorCode) {
                if (FyberBanner.this.mIsLoaded) {
                    return;
                }
                FyberBanner.this.mIsLoaded = true;
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_BANNER, "Failure, " + inneractiveErrorCode);
                if (FyberBanner.this.mCustomEventListener != null) {
                    FyberBanner.this.mCustomEventListener.onAdError();
                }
            }
        });
        this.mIsLoaded = false;
        this.mBannerSpot.requestAd(inneractiveAdRequest);
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        InneractiveAdSpot inneractiveAdSpot = this.mBannerSpot;
        if (inneractiveAdSpot != null) {
            inneractiveAdSpot.destroy();
            this.mBannerSpot = null;
        }
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void setBannerAdSize(AdConstants.BANNER_AD_SIZE banner_ad_size) {
        this.mBannerAdSize = banner_ad_size;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void impression() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_FYBER, ADXLogUtil.INVENTORY_BANNER, "Impression");
        BCustomEventListener bCustomEventListener = this.mCustomEventListener;
        if (bCustomEventListener != null) {
            bCustomEventListener.onAdImpression();
            this.mCustomEventListener.onPaidEvent(this.mEcpm);
        }
    }

    private void initGdpr(Context context) {
        if (ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(context)] == ADXGDPR.ADXConsentState.ADXConsentStateDenied) {
            InneractiveAdManager.setGdprConsent(false);
        } else {
            InneractiveAdManager.setGdprConsent(true);
        }
    }
}
