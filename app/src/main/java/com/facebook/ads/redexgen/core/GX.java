package com.facebook.ads.redexgen.core;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class GX extends AbstractRunnableC1652Wc {
    public final /* synthetic */ InterfaceC1987dp A00;
    public final /* synthetic */ C1988dq A01;

    public GX(C1988dq c1988dq, InterfaceC1987dp interfaceC1987dp) {
        this.A01 = c1988dq;
        this.A00 = interfaceC1987dp;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setInterpolator(new AccelerateInterpolator());
        alphaAnimation.setAnimationListener(new GY(this));
        this.A01.startAnimation(alphaAnimation);
    }
}
