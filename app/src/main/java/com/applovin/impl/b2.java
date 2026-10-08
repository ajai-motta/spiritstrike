package com.applovin.impl;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: classes2.dex */
public class b2 extends v1 {
    public b2(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.k kVar) {
        super(bVar, activity, kVar);
    }

    @Override // com.applovin.impl.v1
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }

    @Override // com.applovin.impl.v1
    public /* bridge */ /* synthetic */ void a(View view) {
        super.a(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.widget.ImageView r17, com.applovin.impl.adview.g r18, final com.applovin.impl.adview.l r19, com.applovin.impl.a r20, android.widget.ProgressBar r21, com.applovin.impl.i0 r22, android.view.View r23, android.view.View r24, com.applovin.adview.AppLovinAdView r25, com.applovin.impl.adview.k r26, android.widget.ImageView r27, android.view.ViewGroup r28) {
        /*
            Method dump skipped, instruction units count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.b2.a(android.widget.ImageView, com.applovin.impl.adview.g, com.applovin.impl.adview.l, com.applovin.impl.a, android.widget.ProgressBar, com.applovin.impl.i0, android.view.View, android.view.View, com.applovin.adview.AppLovinAdView, com.applovin.impl.adview.k, android.widget.ImageView, android.view.ViewGroup):void");
    }

    public void a(com.applovin.impl.adview.g gVar, com.applovin.impl.adview.k kVar, View view, ProgressBar progressBar) {
        if (view != null) {
            view.setVisibility(0);
        }
        s.a(this.d, view);
        if (gVar != null) {
            a(this.c.n(), (this.c.u0() ? 3 : 5) | 48, gVar);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 20, ((Boolean) this.f694a.a(y4.v2)).booleanValue() ? 80 : 48);
            layoutParams.setMargins(0, 0, 0, ((Integer) this.f694a.a(y4.w2)).intValue());
            this.d.addView(progressBar, layoutParams);
        }
        if (kVar != null) {
            this.d.addView(kVar, this.e);
        }
    }
}
