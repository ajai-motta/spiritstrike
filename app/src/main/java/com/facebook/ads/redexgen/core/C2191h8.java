package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.h8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2191h8 extends WP {
    public final /* synthetic */ C2188h5 A00;
    public final /* synthetic */ C1637Vm A01;

    public C2191h8(C2188h5 c2188h5, C1637Vm c1637Vm) {
        this.A00 = c2188h5;
        this.A01 = c1637Vm;
    }

    @Override // com.facebook.ads.redexgen.core.WP
    public final void A01() {
        if (this.A00.A01.A00() != null) {
            this.A00.A01.A00().onAdError(XE.A00(this.A01));
        }
    }
}
