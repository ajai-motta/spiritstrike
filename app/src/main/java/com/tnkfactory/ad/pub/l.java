package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdItem;
import com.tnkfactory.ad.BannerAdView;
import com.tnkfactory.ad.FeedAdView;
import com.tnkfactory.ad.InterstitialAdItem;
import com.tnkfactory.ad.NativeAdItem;
import com.tnkfactory.ad.RewardVideoAdItem;

/* JADX INFO: loaded from: classes6.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdItem f3150a;

    public l(AdItem adItem) {
        this.f3150a = adItem;
    }

    public static l a(AdItem adItem) {
        return adItem instanceof RewardVideoAdItem ? new k(adItem) : adItem instanceof InterstitialAdItem ? new i(adItem) : adItem instanceof NativeAdItem ? new j(adItem) : adItem instanceof BannerAdView ? new f(adItem) : adItem instanceof FeedAdView ? new h(adItem) : new g(adItem);
    }

    public abstract c1 a(String str);
}
