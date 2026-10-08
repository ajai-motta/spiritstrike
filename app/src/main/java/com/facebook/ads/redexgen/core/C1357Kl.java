package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1357Kl extends AbstractRunnableC1652Wc {
    public final /* synthetic */ AbstractC1850bb A00;

    public C1357Kl(AbstractC1850bb abstractC1850bb) {
        this.A00 = abstractC1850bb;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        this.A00.setPressed(false);
        this.A00.postOnAnimationDelayed(this.A00.A09, this.A00.A08);
    }
}
