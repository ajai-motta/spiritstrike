package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.j1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2301j1 extends AbstractRunnableC1652Wc {
    public final /* synthetic */ AbstractC2300j0 A00;
    public final /* synthetic */ C1637Vm A01;

    public C2301j1(AbstractC2300j0 abstractC2300j0, C1637Vm c1637Vm) {
        this.A00 = abstractC2300j0;
        this.A01 = c1637Vm;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        this.A00.A0B.A0F().A5g(this.A01.A03().getErrorCode(), this.A01.A04());
        if (this.A00.A07 != null) {
            this.A00.A07.A0G(this.A01);
        }
    }
}
