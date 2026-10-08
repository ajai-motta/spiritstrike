package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.h7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2190h7 extends WP {
    public final /* synthetic */ C2189h6 A00;

    public C2190h7(C2189h6 c2189h6) {
        this.A00 = c2189h6;
    }

    @Override // com.facebook.ads.redexgen.core.WP
    public final void A01() {
        if (this.A00.A01.A01.A00() != null) {
            this.A00.A01.A01.A00().onAdsLoaded();
        }
    }
}
