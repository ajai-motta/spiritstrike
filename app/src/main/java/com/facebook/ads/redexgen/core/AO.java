package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AO implements C5Y {
    public InterfaceC09965t A02;
    public InterfaceC2396kj<String> A03;
    public String A04;
    public boolean A05;
    public boolean A06;
    public final C09915o A07 = new C09915o();
    public int A00 = 8000;
    public int A01 = 8000;

    public final AO A00(InterfaceC09965t interfaceC09965t) {
        this.A02 = interfaceC09965t;
        return this;
    }

    public final AO A01(String str) {
        this.A04 = str;
        return this;
    }

    @Override // com.facebook.ads.redexgen.core.C5Y
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final C08871k A5I() {
        C08871k c08871k = new C08871k(this.A04, this.A00, this.A01, this.A05, this.A07, this.A03, this.A06);
        if (this.A02 != null) {
            c08871k.A43(this.A02);
        }
        return c08871k;
    }
}
