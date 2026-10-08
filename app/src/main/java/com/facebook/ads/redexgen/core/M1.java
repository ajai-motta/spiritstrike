package com.facebook.ads.redexgen.core;

import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class M1 extends AbstractC1513Qq<C1233Fq> {
    public int A00;
    public int A01;
    public int A02;
    public InterfaceC1706Yh A03;
    public C2110fp A04;
    public String A05;
    public List<C2003e5> A06;
    public final SparseBooleanArray A07 = new SparseBooleanArray();
    public final AbstractC2330jd A08;
    public final C1571Sx A09;
    public final C2165gi A0A;
    public final VA A0B;
    public final UK A0C;
    public final Y2 A0D;
    public final C6X A0E;
    public final DZ A0F;

    public M1(C2165gi c2165gi, List<C2003e5> list, AbstractC2330jd abstractC2330jd, VA va, UK uk, InterfaceC1706Yh interfaceC1706Yh, String str, C6X c6x, DZ dz) {
        this.A0A = c2165gi;
        this.A0B = va;
        this.A0C = uk;
        this.A09 = uk.A14();
        this.A04 = uk.A1G();
        this.A0D = uk.A1E();
        this.A03 = interfaceC1706Yh;
        this.A08 = abstractC2330jd;
        this.A06 = list;
        this.A05 = str;
        this.A0E = c6x;
        this.A0F = dz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC1513Qq
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C1233Fq A0F(ViewGroup viewGroup, int i) {
        return new C1233Fq(AbstractC1845bW.A00(new C1881c6(this.A0A, this.A0B, this.A03, this.A08, null, this.A04, this.A0D).A0R(this.A0F).A0N(this.A0C).A0U(), this.A0C, this.A05, this.A0E), this.A07, this.A04, this.A06.size(), this.A0A, this.A08.A2A());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.AbstractC1513Qq
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void A0K(C1233Fq c1233Fq, int i) {
        C2003e5 c2003e5 = this.A06.get(i);
        c1233Fq.A0q(this.A04);
        c1233Fq.A0p(c2003e5, this.A0B, this.A09, this.A0D, this.A05, this.A00, this.A02, this.A01);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1513Qq
    public final int A0B() {
        return this.A06.size();
    }

    public final void A0O(int i, int i2, int i3) {
        boolean needsUpdate = i != this.A00;
        this.A00 = i;
        this.A02 = i2;
        this.A01 = i3;
        if (needsUpdate) {
            A0G();
        }
    }

    public final void A0P(C2110fp c2110fp) {
        this.A04 = c2110fp;
    }
}
