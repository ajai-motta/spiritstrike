package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QL implements InterfaceC1690Xr {
    public int A00;
    public final InterfaceC1690Xr A01;
    public final InterfaceC1690Xr A02;

    public QL(InterfaceC1690Xr interfaceC1690Xr, int i, InterfaceC1690Xr interfaceC1690Xr2) {
        this.A01 = interfaceC1690Xr;
        this.A00 = i;
        this.A02 = interfaceC1690Xr2;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1690Xr
    public final void AH8(String str) {
        if (this.A00 > 0) {
            this.A01.AH8(str);
            this.A01.flush();
            this.A00--;
            return;
        }
        this.A02.AH8(str);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1690Xr
    public final void flush() {
        this.A02.flush();
    }
}
