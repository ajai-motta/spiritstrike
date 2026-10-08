package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class K6 extends AbstractRunnableC1652Wc {
    public final /* synthetic */ C1328Ji A00;
    public final /* synthetic */ boolean A01;

    public K6(C1328Ji c1328Ji, boolean z) {
        this.A00 = c1328Ji;
        this.A01 = z;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        AbstractC1700Yb abstractC1700YbA0B = this.A00.A0b.A0B();
        if (abstractC1700YbA0B == null) {
            return;
        }
        abstractC1700YbA0B.setPageDetailsVisible((this.A01 || abstractC1700YbA0B.A0E()) ? false : true);
        abstractC1700YbA0B.setToolbarActionMode(this.A00.getCloseButtonStyle());
    }
}
