package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.do, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class Cdo {
    public String A02;
    public String A03;
    public String A04;
    public final NY A06;
    public final C1435Nm A07;
    public final C2165gi A08;
    public C1423Na A01 = C1423Na.A01(null);
    public int A00 = 1000;
    public boolean A05 = false;

    public Cdo(C2165gi c2165gi, NY ny, C1435Nm c1435Nm) {
        this.A08 = c2165gi;
        this.A06 = ny;
        this.A07 = c1435Nm;
    }

    public final Cdo A09(int i) {
        this.A00 = i;
        return this;
    }

    public final Cdo A0A(C1423Na c1423Na) {
        this.A01 = c1423Na;
        return this;
    }

    public final Cdo A0B(String str) {
        this.A04 = str;
        return this;
    }

    public final Cdo A0C(String str) {
        this.A02 = str;
        return this;
    }

    public final Cdo A0D(String str) {
        this.A03 = str;
        return this;
    }

    public final Cdo A0E(boolean z) {
        this.A05 = z;
        return this;
    }

    public final C1988dq A0F() {
        return new C1988dq(this, null);
    }
}
