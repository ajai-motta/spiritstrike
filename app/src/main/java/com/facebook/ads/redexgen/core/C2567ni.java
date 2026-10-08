package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ni, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2567ni implements InterfaceC1217Ez {
    public long A00;
    public long A01;
    public C2567ni A02;
    public C1216Ey A03;

    public C2567ni(long j, int i) {
        A02(j, i);
    }

    public final int A00(long j) {
        return ((int) (j - this.A01)) + this.A03.A00;
    }

    public final C2567ni A01() {
        this.A03 = null;
        C2567ni c2567ni = this.A02;
        this.A02 = null;
        return c2567ni;
    }

    public final void A02(long j, int i) {
        AbstractC09493y.A08(this.A03 == null);
        this.A01 = j;
        this.A00 = ((long) i) + j;
    }

    public final void A03(C1216Ey c1216Ey, C2567ni c2567ni) {
        this.A03 = c1216Ey;
        this.A02 = c2567ni;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1217Ez
    public final C1216Ey A6u() {
        return (C1216Ey) AbstractC09493y.A01(this.A03);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1217Ez
    public final C2567ni ACc() {
        if (this.A02 == null || this.A02.A03 == null) {
            return null;
        }
        return this.A02;
    }
}
