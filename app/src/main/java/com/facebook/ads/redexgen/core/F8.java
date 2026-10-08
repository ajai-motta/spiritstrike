package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class F8 implements InterfaceC2135gE {
    public final /* synthetic */ C2033ea A00;

    public F8(C2033ea c2033ea) {
        this.A00 = c2033ea;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2135gE
    public final void AHA() {
        if (this.A00.A02 != null) {
            this.A00.A02.A4j(this.A00.A03.A94());
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2135gE
    public final void AHC(C2137gG c2137gG) {
        if (this.A00.A02 == null) {
            return;
        }
        if (c2137gG == null || !c2137gG.A00()) {
            this.A00.A01.A0F().ABv();
            this.A00.A02.A4j(this.A00.A03.A94());
        } else {
            this.A00.A01.A0F().ABw();
            this.A00.A02.A4j(this.A00.A03.A95());
        }
    }
}
