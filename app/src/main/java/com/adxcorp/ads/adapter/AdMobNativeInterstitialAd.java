package com.adxcorp.ads.adapter;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.adxcorp.ads.common.ADXGdprManager;
import com.adxcorp.ads.common.ICustomEventListener;
import com.adxcorp.ads.common.IntersCustomEvent;
import com.adxcorp.ads.mediation.MediationSDK;
import com.adxcorp.gdpr.ADXGDPR;
import com.adxcorp.util.ADXLogUtil;
import com.google.ads.mediation.applovin.MaxRewardedVideo;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdMobNativeInterstitialAd extends IntersCustomEvent {
    private static final String TAG = "AdMobNativeInterstitialAd";
    private Activity mActivity;
    private String mAdUnitId;
    private ICustomEventListener mCustomEventListener;
    private AdMobInterstitialDialog mDialog;
    private NativeAd mNativeAd;

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
            Log.d(str, "The AdUnitId cannot be null.");
            ICustomEventListener iCustomEventListener4 = this.mCustomEventListener;
            if (iCustomEventListener4 != null) {
                iCustomEventListener4.onAdError();
                return;
            }
            return;
        }
        requestAd();
    }

    private void requestAd() {
        ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_LOAD);
        Bundle bundle = new Bundle();
        if (ADXGDPR.ADXConsentState.values()[ADXGdprManager.getResultGDPR(this.mActivity)] == ADXGDPR.ADXConsentState.ADXConsentStateDenied) {
            bundle.putString("npa", "1");
        }
        AdLoader.Builder builder = new AdLoader.Builder(this.mActivity, this.mAdUnitId);
        NativeAdOptions.Builder builder2 = new NativeAdOptions.Builder();
        builder2.setRequestMultipleImages(false);
        AdLoader adLoaderBuild = builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() { // from class: com.adxcorp.ads.adapter.AdMobNativeInterstitialAd.2
            @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
            public void onNativeAdLoaded(NativeAd nativeAd) {
                if (!AdMobNativeInterstitialAd.this.isValidNativeAd(nativeAd)) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, "Failure, The Google native ad ad is missing one or more required assets, failing request.");
                    if (AdMobNativeInterstitialAd.this.mCustomEventListener != null) {
                        AdMobNativeInterstitialAd.this.mCustomEventListener.onAdError();
                        return;
                    }
                    return;
                }
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_LOAD_SUCCESS);
                AdMobNativeInterstitialAd.this.mNativeAd = nativeAd;
                AdMobNativeInterstitialAd.this.mNativeAd.setOnPaidEventListener(new OnPaidEventListener() { // from class: com.adxcorp.ads.adapter.AdMobNativeInterstitialAd.2.1
                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public void onPaidEvent(AdValue adValue) {
                        double valueMicros = adValue.getValueMicros() / 1000000.0d;
                        double d = 1000.0d * valueMicros;
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.d(AdMobNativeInterstitialAd.TAG, "AdMob onPaidEvent - CurrencyCode : " + adValue.getCurrencyCode() + ", Revenue : " + valueMicros + ", PrecisionType : " + adValue.getPrecisionType() + ", ecpm : " + d);
                        }
                        if (AdMobNativeInterstitialAd.this.mCustomEventListener != null) {
                            AdMobNativeInterstitialAd.this.mCustomEventListener.onPaidEvent(d);
                        }
                    }
                });
                AdMobNativeInterstitialAd adMobNativeInterstitialAd = AdMobNativeInterstitialAd.this;
                AdMobNativeInterstitialAd adMobNativeInterstitialAd2 = AdMobNativeInterstitialAd.this;
                adMobNativeInterstitialAd.mDialog = adMobNativeInterstitialAd2.new AdMobInterstitialDialog(adMobNativeInterstitialAd2.mActivity);
                if (AdMobNativeInterstitialAd.this.mCustomEventListener != null) {
                    AdMobNativeInterstitialAd.this.mCustomEventListener.onAdLoaded();
                }
            }
        }).withAdListener(new AdListener() { // from class: com.adxcorp.ads.adapter.AdMobNativeInterstitialAd.1
            @Override // com.google.android.gms.ads.AdListener
            public void onAdImpression() {
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdClicked() {
                super.onAdClicked();
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_CLICK);
                if (AdMobNativeInterstitialAd.this.mCustomEventListener != null) {
                    AdMobNativeInterstitialAd.this.mCustomEventListener.onAdClicked();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, "Failure, " + loadAdError.getCode() + "(" + loadAdError.getMessage() + ")");
                if (AdMobNativeInterstitialAd.this.mCustomEventListener != null) {
                    AdMobNativeInterstitialAd.this.mCustomEventListener.onAdError();
                }
            }
        }).withNativeAdOptions(builder2.build()).build();
        AdRequest.Builder builder3 = new AdRequest.Builder();
        MobileAds.setRequestConfiguration(new RequestConfiguration.Builder().build());
        adLoaderBuild.loadAd(builder3.build());
    }

    @Override // com.adxcorp.ads.common.IntersCustomEvent
    public void show() {
        ADXLogUtil.d(TAG, ":::show:::");
        try {
            this.mDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.adxcorp.ads.adapter.AdMobNativeInterstitialAd.3
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, "Impression");
                    if (AdMobNativeInterstitialAd.this.mCustomEventListener != null) {
                        AdMobNativeInterstitialAd.this.mCustomEventListener.onAdImpression();
                    }
                }
            });
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.adxcorp.ads.adapter.AdMobNativeInterstitialAd.4
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_CLOSED);
                    if (AdMobNativeInterstitialAd.this.mCustomEventListener != null) {
                        AdMobNativeInterstitialAd.this.mCustomEventListener.onAdClosed();
                    }
                }
            });
            this.mDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
            ADXLogUtil.logAdapterEvent(ADXLogUtil.PLATFORM_ADMOB, ADXLogUtil.INVENTORY_NATIVE_INTERSTITIAL, ADXLogUtil.EVENT_FAILED_TO_SHOW);
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
        NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.destroy();
            this.mNativeAd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValidNativeAd(NativeAd nativeAd) {
        return (nativeAd.getHeadline() == null || nativeAd.getBody() == null || nativeAd.getImages() == null || nativeAd.getImages().size() <= 0 || nativeAd.getImages().get(0) == null || nativeAd.getCallToAction() == null) ? false : true;
    }

    private class AdMobInterstitialDialog extends Dialog {
        public AdMobInterstitialDialog(Context context) {
            super(context, R.style.Theme.Translucent.NoTitleBar);
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(com.adxcorp.library.standard.R.layout.admob_native_interstitial_view);
            NativeAdView nativeAdView = (NativeAdView) findViewById(com.adxcorp.library.standard.R.id.ad_native_adview);
            TextView textView = (TextView) findViewById(com.adxcorp.library.standard.R.id.ad_headline);
            textView.setText(AdMobNativeInterstitialAd.this.mNativeAd.getHeadline());
            nativeAdView.setHeadlineView(textView);
            TextView textView2 = (TextView) findViewById(com.adxcorp.library.standard.R.id.ad_body);
            textView2.setText(AdMobNativeInterstitialAd.this.mNativeAd.getBody());
            nativeAdView.setBodyView(textView2);
            ImageView imageView = (ImageView) findViewById(com.adxcorp.library.standard.R.id.ad_icon);
            imageView.setImageDrawable(AdMobNativeInterstitialAd.this.mNativeAd.getIcon().getDrawable());
            nativeAdView.setIconView(imageView);
            Button button = (Button) findViewById(com.adxcorp.library.standard.R.id.ad_cta);
            button.setText(AdMobNativeInterstitialAd.this.mNativeAd.getCallToAction());
            nativeAdView.setCallToActionView(button);
            nativeAdView.setMediaView((MediaView) findViewById(com.adxcorp.library.standard.R.id.ad_media));
            nativeAdView.setNativeAd(AdMobNativeInterstitialAd.this.mNativeAd);
            findViewById(com.adxcorp.library.standard.R.id.btn_close_ad).setOnClickListener(new View.OnClickListener() { // from class: com.adxcorp.ads.adapter.AdMobNativeInterstitialAd.AdMobInterstitialDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdMobInterstitialDialog.this.dismiss();
                }
            });
        }
    }
}
