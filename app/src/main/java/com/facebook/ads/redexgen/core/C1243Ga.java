package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ga, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1243Ga extends AbstractRunnableC1652Wc {
    public final /* synthetic */ C09744x A00;

    public C1243Ga(C09744x c09744x) {
        this.A00 = c09744x;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        if (this.A00.A00 != null) {
            this.A00.A00.A1F();
        }
        this.A00.A09.setToolbarActionMode(this.A00.getCloseButtonStyle());
        this.A00.A09.A0A();
        this.A00.A06.set(true);
    }
}
