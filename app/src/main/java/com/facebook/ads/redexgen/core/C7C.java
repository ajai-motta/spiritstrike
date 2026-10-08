package com.facebook.ads.redexgen.core;

import android.widget.FrameLayout;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7C, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C7C extends C2194hB {
    public InterfaceC2037ee A00;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final void A08(NativeAdLayout nativeAdLayout, C2165gi c2165gi, NativeAd nativeAd, C1629Vd c1629Vd) {
        C1859bk c1859bk = new C1859bk(c2165gi);
        MediaView mediaView = new MediaView(c2165gi);
        AdOptionsView adOptionsView = new AdOptionsView(c2165gi, nativeAd, nativeAdLayout);
        c1629Vd.A09(adOptionsView, 28);
        this.A00 = new F2(c2165gi, nativeAd, c1629Vd, UK.A0L(nativeAd.getInternalNativeAd()).A1C(), c1859bk, mediaView, adOptionsView);
        YB.A0N(nativeAdLayout, c1629Vd.A00());
        nativeAd.registerViewForInteraction(nativeAdLayout, mediaView, c1859bk, this.A00.getViewsForInteraction());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        nativeAdLayout.addView(this.A00.getView(), layoutParams);
    }

    @Override // com.facebook.ads.redexgen.core.C1535Rm, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A00.unregisterView();
    }
}
