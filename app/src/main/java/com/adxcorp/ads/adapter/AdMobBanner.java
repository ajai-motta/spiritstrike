package com.adxcorp.ads.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.compose.animation.core.AnimationConstants;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.AdConstants;
import com.adxcorp.ads.common.BCustomEventListener;
import com.adxcorp.ads.common.BannerCustomEvent;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdMobBanner extends BannerCustomEvent {
    private static final String TAG = "AdMobBanner";
    private String mAdUnitId;
    private AdView mAdView;
    private AdConstants.BANNER_AD_SIZE mBannerAdSize;
    private Context mContext;
    private BCustomEventListener mCustomEventListener;
    private boolean mIsLoaded;

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public View getAdView() {
        return this.mAdView;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void loadAd(Context context, Map<String, String> map, BCustomEventListener bCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = bCustomEventListener;
        this.mContext = context;
        String str2 = map.get(MaxRewardedVideo.ADUNIT_ID_EXTRA_KEY);
        this.mAdUnitId = str2;
        if (TextUtils.isEmpty(str2)) {
            Log.d(str, "The AdUnitId cannot be null.");
            BCustomEventListener bCustomEventListener2 = this.mCustomEventListener;
            if (bCustomEventListener2 != null) {
                bCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        if (this.mContext == null) {
            Log.d(str, "Context cannot be null.");
            BCustomEventListener bCustomEventListener3 = this.mCustomEventListener;
            if (bCustomEventListener3 != null) {
                bCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD);
        if (this.mAdView == null) {
            AdView adView = new AdView(this.mContext);
            this.mAdView = adView;
            adView.setAdUnitId(this.mAdUnitId);
        }
        applyBannerAdSize();
        if (this.mAdView.getAdSize() == null) {
            this.mAdView.setAdSize(AdSize.BANNER);
        }
        ADXLogUtil.d(TAG, "AdSize : " + this.mAdView.getAdSize());
        this.mAdView.setAdListener(new AdListener() { // from class: com.adxcorp.ads.adapter.AdMobBanner.1
            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdImpression() {
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                if (AdMobBanner.this.mIsLoaded) {
                    return;
                }
                AdMobBanner.this.mIsLoaded = true;
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_BANNER, "Failure, " + loadAdError.getCode() + "(" + loadAdError.getMessage() + ")");
                if (AdMobBanner.this.mCustomEventListener != null) {
                    AdMobBanner.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                if (AdMobBanner.this.mIsLoaded) {
                    return;
                }
                AdMobBanner.this.mIsLoaded = true;
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AdMobBanner.this.mCustomEventListener != null) {
                    AdMobBanner.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClicked() {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_BANNER, ADXLogUtil.EVENT_CLICK);
                if (AdMobBanner.this.mCustomEventListener != null) {
                    AdMobBanner.this.mCustomEventListener.onAdClicked();
                }
            }
        });
        this.mAdView.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.adxcorp.ads.adapter.AdMobBanner.2
            @Override // com.google.android.gms.ads.OnPaidEventListener
            public void onPaidEvent(AdValue adValue) {
                double valueMicros = adValue.getValueMicros() / 1000000.0d;
                double d = 1000.0d * valueMicros;
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(AdMobBanner.TAG, "AdMob onPaidEvent - CurrencyCode : " + adValue.getCurrencyCode() + ", Revenue : " + valueMicros + ", PrecisionType : " + adValue.getPrecisionType() + ", ecpm : " + d);
                }
                if (AdMobBanner.this.mCustomEventListener != null) {
                    AdMobBanner.this.mCustomEventListener.onPaidEvent(d);
                }
            }
        });
        Bundle bundle = new Bundle();
        if (ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(this.mContext)] == ADXGDPR.ADXConsentState.ADXConsentStateDenied) {
            bundle.putString("npa", "1");
        }
        AdRequest adRequestBuild = new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
        this.mIsLoaded = false;
        this.mAdView.loadAd(adRequestBuild);
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.removeAllViews();
            this.mAdView.destroy();
            this.mAdView = null;
        }
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void setBannerAdSize(AdConstants.BANNER_AD_SIZE banner_ad_size) {
        this.mBannerAdSize = banner_ad_size;
    }

    @Override // com.adxcorp.ads.common.BannerCustomEvent
    public void impression() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_BANNER, "Impression");
        BCustomEventListener bCustomEventListener = this.mCustomEventListener;
        if (bCustomEventListener != null) {
            bCustomEventListener.onAdImpression();
        }
    }

    private void applyBannerAdSize() {
        AdView adView = this.mAdView;
        if (adView == null || adView.getAdSize() != null) {
            return;
        }
        int i = AnonymousClass3.$SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[this.mBannerAdSize.ordinal()];
        if (i == 1) {
            this.mAdView.setAdSize(new AdSize(320, 50));
            return;
        }
        if (i == 2) {
            this.mAdView.setAdSize(new AdSize(320, 100));
        } else if (i == 3) {
            this.mAdView.setAdSize(new AdSize(AnimationConstants.DefaultDurationMillis, 250));
        } else {
            if (i != 4) {
                return;
            }
            this.mAdView.setAdSize(new AdSize(728, 90));
        }
    }

    /* JADX INFO: renamed from: com.adxcorp.ads.adapter.AdMobBanner$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE;

        static {
            int[] iArr = new int[AdConstants.BANNER_AD_SIZE.values().length];
            $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE = iArr;
            try {
                iArr[AdConstants.BANNER_AD_SIZE.AD_SIZE_320x50.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[AdConstants.BANNER_AD_SIZE.AD_SIZE_320x100.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[AdConstants.BANNER_AD_SIZE.AD_SIZE_300x250.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$adxcorp$ads$common$AdConstants$BANNER_AD_SIZE[AdConstants.BANNER_AD_SIZE.AD_SIZE_728x90.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }
}
