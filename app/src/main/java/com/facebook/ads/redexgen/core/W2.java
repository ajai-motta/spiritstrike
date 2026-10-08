package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class W2 implements InterfaceC1821b8 {
    public final /* synthetic */ C1649Vz A00;

    public W2(C1649Vz c1649Vz) {
        this.A00 = c1649Vz;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1821b8
    public final void AE7(C1820b7 c1820b7) {
        this.A00.A0G.set(c1820b7.A00() != null);
        if (this.A00.A0H.get() && this.A00.A05 != null) {
            this.A00.A05.AFB(c1820b7.A00() != null);
        }
    }
}
