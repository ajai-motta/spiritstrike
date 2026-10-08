package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2202hJ extends AbstractRunnableC1652Wc {
    public final /* synthetic */ C2201hI A00;
    public final /* synthetic */ AnonymousClass62 A01;

    public C2202hJ(C2201hI c2201hI, AnonymousClass62 anonymousClass62) {
        this.A00 = c2201hI;
        this.A01 = anonymousClass62;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractRunnableC1652Wc
    public final void A07() {
        this.A01.setAdViewabilityChecker(this.A00.A02.A1G());
        this.A00.A02.A1o(true, true);
    }
}
