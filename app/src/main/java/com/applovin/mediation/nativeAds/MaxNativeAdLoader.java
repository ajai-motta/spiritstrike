package com.applovin.mediation.nativeAds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.k;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MaxNativeAdLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxNativeAdLoaderImpl f759a;

    public MaxNativeAdLoader(String str) {
        this(str, k.o());
    }

    public void a(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        this.f759a.logApiCall("a()");
        this.f759a.registerClickableViews(list, viewGroup, maxAd);
    }

    public void b(MaxAd maxAd) {
        this.f759a.logApiCall("b()");
        this.f759a.handleNativeAdViewRendered(maxAd);
    }

    public void destroy() {
        this.f759a.logApiCall("destroy()");
        this.f759a.destroy();
    }

    public String getAdUnitId() {
        return this.f759a.getAdUnitId();
    }

    public String getPlacement() {
        this.f759a.logApiCall("getPlacement()");
        return this.f759a.getPlacement();
    }

    public void loadAd() {
        loadAd(null);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        this.f759a.logApiCall("render(adView=" + maxNativeAdView + ", ad=" + maxAd + ")");
        return this.f759a.render(maxNativeAdView, maxAd);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f759a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f759a.setAdReviewListener(maxAdReviewListener);
    }

    public void setCustomData(String str) {
        this.f759a.logApiCall("setCustomData(value=" + str + ")");
        this.f759a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f759a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f759a.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f759a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f759a.setLocalExtraParameter(str, obj);
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        this.f759a.logApiCall("setNativeAdListener(listener=" + maxNativeAdListener + ")");
        this.f759a.setNativeAdListener(maxNativeAdListener);
    }

    public void setPlacement(String str) {
        this.f759a.logApiCall("setPlacement(placement=" + str + ")");
        this.f759a.setPlacement(str);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f759a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f759a.setRevenueListener(maxAdRevenueListener);
    }

    @Deprecated
    public MaxNativeAdLoader(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        this.f759a.logApiCall("loadAd(adView=" + maxNativeAdView + ")");
        this.f759a.loadAd(maxNativeAdView);
    }

    @Deprecated
    public MaxNativeAdLoader(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxNativeAdLoader", "MaxNativeAdLoader(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Empty ad unit ID specified");
            }
            if (appLovinSdk == null) {
                throw new IllegalArgumentException("No sdk specified");
            }
            if (context != null) {
                this.f759a = new MaxNativeAdLoaderImpl(str, appLovinSdk.a());
                return;
            }
            throw new IllegalArgumentException("No context specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    public void destroy(MaxAd maxAd) {
        this.f759a.logApiCall("destroy(nativeAd=" + maxAd + ")");
        this.f759a.destroy(maxAd);
    }
}
