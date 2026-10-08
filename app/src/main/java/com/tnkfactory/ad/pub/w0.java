package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.BannerAdView;

/* JADX INFO: loaded from: classes6.dex */
public final class w0 implements k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f3212a;

    public w0(b1 b1Var) {
        this.f3212a = b1Var;
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void a(int i) {
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void b() {
        b1 b1Var = this.f3212a;
        BannerAdView bannerAdView = b1Var.f;
        AdListener adListener = b1Var.b;
        if (adListener != null) {
            adListener.onShow(bannerAdView);
        }
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void a() {
        b1 b1Var = this.f3212a;
        BannerAdView bannerAdView = b1Var.f;
        AdListener adListener = b1Var.b;
        if (adListener != null) {
            adListener.onClick(bannerAdView);
        }
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void b(int i) {
        b1 b1Var = this.f3212a;
        BannerAdView bannerAdView = b1Var.f;
        AdListener adListener = b1Var.b;
        if (adListener != null) {
            adListener.onVideoCompletion(bannerAdView, i);
        }
    }
}
