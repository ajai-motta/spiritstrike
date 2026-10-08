package com.google.ads.mediation.applovin;

import android.content.Context;
import android.widget.FrameLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.ads.AdSize;

/* JADX INFO: loaded from: classes8.dex */
class AppLovinAdViewWrapper {
    private final FrameLayout adViewWrapper;
    private final AppLovinAdView appLovinAdView;

    private AppLovinAdViewWrapper(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, FrameLayout frameLayout, Context context) {
        AppLovinAdView appLovinAdView = new AppLovinAdView(appLovinSdk, appLovinAdSize, context);
        this.appLovinAdView = appLovinAdView;
        this.adViewWrapper = frameLayout;
        frameLayout.addView(appLovinAdView);
    }

    public static AppLovinAdViewWrapper newInstance(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, AdSize adSize, Context context) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(adSize.getWidthInPixels(context), adSize.getHeightInPixels(context));
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(layoutParams);
        return new AppLovinAdViewWrapper(appLovinSdk, appLovinAdSize, frameLayout, context);
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.appLovinAdView.setAdDisplayListener(appLovinAdDisplayListener);
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.appLovinAdView.setAdClickListener(appLovinAdClickListener);
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        this.appLovinAdView.setAdViewEventListener(appLovinAdViewEventListener);
    }

    public void renderAd(AppLovinAd appLovinAd) {
        this.appLovinAdView.renderAd(appLovinAd);
    }

    public FrameLayout getAppLovinAdView() {
        return this.adViewWrapper;
    }
}
