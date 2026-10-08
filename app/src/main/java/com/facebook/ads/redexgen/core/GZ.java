package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class GZ extends AbstractRunnableC1652Wc {
    public final /* synthetic */ C09744x A00;

    public GZ(C09744x c09744x) {
        this.A00 = c09744x;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        if (this.A00.A00 != null && this.A00.A00.A1N()) {
            ((AbstractC1252Gj) this.A00).A02 = true;
            this.A00.A09.setToolbarActionMode(8);
        }
    }
}
