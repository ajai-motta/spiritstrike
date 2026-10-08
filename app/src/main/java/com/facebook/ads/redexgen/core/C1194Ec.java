package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ec, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1194Ec implements Comparable<C1194Ec> {
    public final boolean A00;
    public final boolean A01;

    public C1194Ec(C2725qI c2725qI, int i) {
        this.A00 = (c2725qI.A0H & 1) != 0;
        this.A01 = C10829h.A0S(i, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C1194Ec c1194Ec) {
        return AbstractC2577ns.A01().A09(this.A01, c1194Ec.A01).A09(this.A00, c1194Ec.A00).A05();
    }
}
