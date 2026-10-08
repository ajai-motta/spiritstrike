package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1356Kk implements Comparable<C1356Kk> {
    public final int A00;
    public final C1347Kb A01;

    public C1356Kk(int i, C1347Kb c1347Kb) {
        this.A00 = i;
        this.A01 = c1347Kb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C1356Kk c1356Kk) {
        return Integer.compare(this.A00, c1356Kk.A00);
    }
}
