package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Za, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1725Za {
    public int A00;
    public YM A01;
    public InterfaceC1730Zf A02;
    public String A03;
    public String A04;
    public String A05;
    public String A06;
    public final C2165gi A0B;
    public boolean A09 = true;
    public boolean A0A = true;
    public boolean A08 = true;
    public boolean A07 = true;
    public final boolean A0C = true;

    public C1725Za(C2165gi c2165gi, InterfaceC1730Zf interfaceC1730Zf) {
        this.A0B = c2165gi;
        this.A02 = interfaceC1730Zf;
    }

    public final C1725Za A0C(int i) {
        this.A00 = i;
        return this;
    }

    public final C1725Za A0D(YM ym) {
        this.A01 = ym;
        return this;
    }

    public final C1725Za A0E(String str) {
        this.A03 = str;
        return this;
    }

    public final C1725Za A0F(String str) {
        this.A04 = str;
        return this;
    }

    public final C1725Za A0G(String str) {
        this.A05 = str;
        return this;
    }

    public final C1725Za A0H(String str) {
        this.A06 = str;
        return this;
    }

    public final C1725Za A0I(boolean z) {
        this.A08 = z;
        return this;
    }

    public final C1725Za A0J(boolean z) {
        this.A09 = z;
        return this;
    }

    public final C1725Za A0K(boolean z) {
        this.A0A = z;
        return this;
    }

    public final C1726Zb A0L() {
        return new C1726Zb(this, null);
    }
}
