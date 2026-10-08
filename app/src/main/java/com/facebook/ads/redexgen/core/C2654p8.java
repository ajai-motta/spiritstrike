package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.p8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2654p8 implements C5Y {
    public final InterfaceC09965t A00;

    public C2654p8() {
        this(null);
    }

    public C2654p8(InterfaceC09965t interfaceC09965t) {
        this.A00 = interfaceC09965t;
    }

    @Override // com.facebook.ads.redexgen.core.C5Y
    public final InterfaceC2661pF A5I() {
        C08861j c08861j = new C08861j();
        if (this.A00 != null) {
            c08861j.A43(this.A00);
        }
        return c08861j;
    }
}
