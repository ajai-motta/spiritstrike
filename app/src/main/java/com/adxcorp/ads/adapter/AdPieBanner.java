package com.adxcorp.ads.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.BCustomEventListener;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.mediation.MAdView;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdPieBanner extends BannerCustomEvent {
    private static final String TAG = "AdPieBanner";
    private MAdView mAdView;
    private AdConstants.BANNER_AD_SIZE mBannerAdSize;
    private Context mContext;
    private BCustomEventListener mCustomEventListener;

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public View getAdView() {
        MAdView mAdView = this.mAdView;
        if (mAdView != null) {
            return mAdView.getAdContentView();
        }
        return null;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void loadAd(Context context, Map<String, String> map, BCustomEventListener bCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = bCustomEventListener;
        this.mContext = context;
        if (context == null) {
            Log.d(str, "Context cannot be null.");
            BCustomEventListener bCustomEventListener2 = this.mCustomEventListener;
            if (bCustomEventListener2 != null) {
                bCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        if (this.mAdView == null) {
            this.mAdView = new MAdView(this.mContext);
        }
        this.mAdView.setAdListener(new MAdView.AdListener() { // from class: com.adxcorp.ads.adapter.AdPieBanner.1
            @Override // com.adxcorp.ads.mediation.MAdView.AdListener
            public void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings, NewsFeed newsFeed) {
            }

            @Override // com.adxcorp.ads.mediation.MAdView.AdListener
            public void onAdLoaded() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdPieBanner.this.mCustomEventListener != null) {
                    AdPieBanner.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.MAdView.AdListener
            public void onAdFailedToLoad(int i) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_BANNER, "Failure, " + i);
                if (AdPieBanner.this.mCustomEventListener != null) {
                    AdPieBanner.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.adxcorp.ads.mediation.MAdView.AdListener
            public void onAdClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                if (AdPieBanner.this.mCustomEventListener != null) {
                    AdPieBanner.this.mCustomEventListener.onAdClicked();
                }
            }
        });
        this.mAdView.parsingBidResponse(this.mMediationData);
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void setBannerAdSize(AdConstants.BANNER_AD_SIZE banner_ad_size) {
        this.mBannerAdSize = banner_ad_size;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void impression() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADPIE_OR_INHOUSE, ADXLogUtil.INVENTORY_BANNER, "Impression");
        BCustomEventListener bCustomEventListener = this.mCustomEventListener;
        if (bCustomEventListener != null) {
            bCustomEventListener.onAdImpression();
            this.mCustomEventListener.onPaidEvent(this.mMediationData.getEcpm());
        }
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        MAdView mAdView = this.mAdView;
        if (mAdView != null) {
            mAdView.destroy();
            this.mAdView = null;
        }
    }
}
