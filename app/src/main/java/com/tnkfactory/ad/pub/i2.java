package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdListener;
import com.tnkfactory.ad.InterstitialAdItem;

/* JADX INFO: loaded from: classes6.dex */
public final class i2 implements k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j2 f3141a;

    public i2(j2 j2Var) {
        this.f3141a = j2Var;
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void a(int i) {
        this.f3141a.a();
        j2 j2Var = this.f3141a;
        InterstitialAdItem interstitialAdItem = j2Var.f;
        AdListener adListener = j2Var.b;
        if (adListener != null) {
            adListener.onClose(interstitialAdItem, i);
        }
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void b() {
        j2 j2Var = this.f3141a;
        InterstitialAdItem interstitialAdItem = j2Var.f;
        AdListener adListener = j2Var.b;
        if (adListener != null) {
            adListener.onShow(interstitialAdItem);
        }
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void b(int i) {
        j2 j2Var = this.f3141a;
        InterstitialAdItem interstitialAdItem = j2Var.f;
        AdListener adListener = j2Var.b;
        if (adListener != null) {
            adListener.onVideoCompletion(interstitialAdItem, i);
        }
    }

    @Override // com.tnkfactory.ad.pub.k2
    public final void a() {
        j2 j2Var = this.f3141a;
        InterstitialAdItem interstitialAdItem = j2Var.f;
        AdListener adListener = j2Var.b;
        if (adListener != null) {
            adListener.onClick(interstitialAdItem);
        }
    }
}
