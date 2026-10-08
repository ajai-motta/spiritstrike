package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2387kZ implements InterfaceC1395Lx {
    public final InterfaceC1392Lu A00;

    public C2387kZ(InterfaceC1392Lu interfaceC1392Lu) {
        this.A00 = interfaceC1392Lu;
    }

    public final InterfaceC1392Lu A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1395Lx
    public final C8J ACL() {
        return new C8J(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1395Lx
    public final C2391kd ACM() {
        return new C2391kd(this);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1395Lx
    public final C2391kd ACN(String str) {
        return new C2391kd(this, str);
    }
}
