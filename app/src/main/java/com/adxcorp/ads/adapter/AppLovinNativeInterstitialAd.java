package com.adxcorp.ads.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.library.standard.R;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdViewBinder;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinNativeInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "AdMobNativeInterstitialAd";
    private Activity mActivity;
    private String mAdUnitId;
    private ICustomEventListener mCustomEventListener;
    private AppLovinInterstitialDialog mDialog;
    private MaxAd mNativeAd;
    private MaxNativeAdLoader mNativeAdLoader;
    private MaxNativeAdView mNativeAdView;

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void loadAd(Context context, Map<String, String> map, ICustomEventListener iCustomEventListener) {
        String str = TAG;
        ADXLogUtil.d(str, ":::loadAd:::" + map);
        this.mCustomEventListener = iCustomEventListener;
        if (context == null) {
            Log.d(str, "Context cannot be null.");
            ICustomEventListener iCustomEventListener2 = this.mCustomEventListener;
            if (iCustomEventListener2 != null) {
                iCustomEventListener2.onAdError();
                return;
            }
            return;
        }
        if (!(context instanceof Activity)) {
            Log.d(str, "An Activity Context is required.");
            ICustomEventListener iCustomEventListener3 = this.mCustomEventListener;
            if (iCustomEventListener3 != null) {
                iCustomEventListener3.onAdError();
                return;
            }
            return;
        }
        this.mActivity = (Activity) context;
        String str2 = map.get(MaxRewardedVideo.ADUNIT_ID_EXTRA_KEY);
        this.mAdUnitId = str2;
        if (TextUtils.isEmpty(str2)) {
            this.mAdUnitId = map.get(AppLovinUtils.ServerParameterKeys.ZONE_ID);
        }
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            Log.d(str, "The AdUnitId cannot be null.");
            ICustomEventListener iCustomEventListener4 = this.mCustomEventListener;
            if (iCustomEventListener4 != null) {
                iCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        if (AppLovinUtils.isChildUser()) {
            Log.d(str, AppLovinUtils.ERROR_MSG_CHILD_USER);
            ICustomEventListener iCustomEventListener5 = this.mCustomEventListener;
            if (iCustomEventListener5 != null) {
                iCustomEventListener5.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(this.mAdUnitId, this.mActivity);
        this.mNativeAdLoader = maxNativeAdLoader;
        maxNativeAdLoader.setExtraParameter("disable_auto_retries", "true");
        this.mNativeAdLoader.setNativeAdListener(new MaxNativeAdListener() { // from class: com.adxcorp.ads.adapter.AppLovinNativeInterstitialAd.1
            @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
            public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                if (AppLovinNativeInterstitialAd.this.mNativeAd != null) {
                    AppLovinNativeInterstitialAd.this.mNativeAdLoader.destroy(AppLovinNativeInterstitialAd.this.mNativeAd);
                }
                AppLovinNativeInterstitialAd.this.mNativeAd = maxAd;
                AppLovinNativeInterstitialAd.this.mNativeAdView = maxNativeAdView;
                AppLovinNativeInterstitialAd appLovinNativeInterstitialAd = AppLovinNativeInterstitialAd.this;
                AppLovinNativeInterstitialAd appLovinNativeInterstitialAd2 = AppLovinNativeInterstitialAd.this;
                appLovinNativeInterstitialAd.mDialog = appLovinNativeInterstitialAd2.new AppLovinInterstitialDialog(appLovinNativeInterstitialAd2.mActivity);
                if (AppLovinNativeInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinNativeInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }

            @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
            public void onNativeAdLoadFailed(String str, MaxError maxError) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, "Failure, " + maxError.getCode() + "(" + maxError.getMessage() + ")");
                if (AppLovinNativeInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinNativeInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }

            @Override // com.applovin.mediation.nativeAds.MaxNativeAdListener
            public void onNativeAdClicked(MaxAd maxAd) {
                if (AppLovinNativeInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinNativeInterstitialAd.this.mCustomEventListener.onAdClicked();
                }
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
            }
        });
        this.mNativeAdLoader.setRevenueListener(new MaxAdRevenueListener() { // from class: com.adxcorp.ads.adapter.AppLovinNativeInterstitialAd.2
            @Override // com.applovin.mediation.MaxAdRevenueListener
            public void onAdRevenuePaid(MaxAd maxAd) {
                double revenue = maxAd.getRevenue();
                double d = 1000.0d * revenue;
                if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                    ADXLogUtil.d(AppLovinNativeInterstitialAd.TAG, "AppLovin onAdRevenuePaid - " + maxAd);
                    ADXLogUtil.d(AppLovinNativeInterstitialAd.TAG, "AppLovin onAdRevenuePaid - Revenue : " + revenue + ", RevenuePrecision : " + maxAd.getRevenuePrecision() + ", ecpm : " + d);
                }
                if (AppLovinNativeInterstitialAd.this.mCustomEventListener != null) {
                    AppLovinNativeInterstitialAd.this.mCustomEventListener.onPaidEvent(d);
                }
            }
        });
        this.mNativeAdLoader.loadAd(createNativeAdView());
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        ADXLogUtil.d(TAG, ":::show:::");
        try {
            this.mDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.adxcorp.ads.adapter.AppLovinNativeInterstitialAd.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, "Impression");
                    if (AppLovinNativeInterstitialAd.this.mCustomEventListener != null) {
                        AppLovinNativeInterstitialAd.this.mCustomEventListener.onAdImpression();
                    }
                }
            });
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.adxcorp.ads.adapter.AppLovinNativeInterstitialAd.4
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                    if (AppLovinNativeInterstitialAd.this.mCustomEventListener != null) {
                        AppLovinNativeInterstitialAd.this.mCustomEventListener.onAdClosed();
                    }
                }
            });
            this.mDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
            ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_APPLOVIN, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
            ICustomEventListener iCustomEventListener = this.mCustomEventListener;
            if (iCustomEventListener != null) {
                iCustomEventListener.onAdFailedToShow();
            }
        }
    }

    @Override // com.adxcorp.ads.common.CustomEvent
    public void destroy() {
        super.destroy();
        ADXLogUtil.d(TAG, ":::destroy:::");
        this.mCustomEventListener = null;
        MaxNativeAdLoader maxNativeAdLoader = this.mNativeAdLoader;
        if (maxNativeAdLoader != null) {
            MaxAd maxAd = this.mNativeAd;
            if (maxAd != null) {
                maxNativeAdLoader.destroy(maxAd);
                this.mNativeAd = null;
            }
            this.mNativeAdLoader.destroy();
            this.mNativeAdLoader = null;
        }
    }

    private MaxNativeAdView createNativeAdView() {
        return new MaxNativeAdView(new MaxNativeAdViewBinder.Builder(R.layout.applovin_native_template).setTitleTextViewId(R.id.ad_headline).setBodyTextViewId(R.id.ad_body).setIconImageViewId(R.id.ad_icon).setMediaContentViewGroupId(R.id.ad_media).setOptionsContentViewGroupId(R.id.ad_options).setCallToActionButtonId(R.id.ad_cta).build(), this.mActivity);
    }

    private class AppLovinInterstitialDialog extends Dialog {
        public AppLovinInterstitialDialog(Context context) {
            super(context, android.R.style.Theme.Translucent.NoTitleBar);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(R.layout.applovin_native_interstitial_view);
            AppLovinNativeInterstitialAd.this.mNativeAdView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.ad_container);
            relativeLayout.removeAllViews();
            relativeLayout.addView(AppLovinNativeInterstitialAd.this.mNativeAdView);
            findViewById(R.id.btn_close_ad).setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.adapter.AppLovinNativeInterstitialAd.AppLovinInterstitialDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AppLovinInterstitialDialog.this.dismiss();
                }
            });
        }
    }
}
