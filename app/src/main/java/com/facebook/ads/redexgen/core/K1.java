package com.facebook.ads.redexgen.core;

import android.util.SparseArray;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class K1 {
    public C1341Jv A00;
    public C1343Jx A01;
    public final int A02;
    public final int A03;
    public final SparseArray<C1345Jz> A08 = new SparseArray<>();
    public final SparseArray<C1340Ju> A06 = new SparseArray<>();
    public final SparseArray<C1342Jw> A07 = new SparseArray<>();
    public final SparseArray<C1340Ju> A04 = new SparseArray<>();
    public final SparseArray<C1342Jw> A05 = new SparseArray<>();

    public K1(int i, int i2) {
        this.A03 = i;
        this.A02 = i2;
    }

    public final void A00() {
        this.A08.clear();
        this.A06.clear();
        this.A07.clear();
        this.A04.clear();
        this.A05.clear();
        this.A00 = null;
        this.A01 = null;
    }
}
