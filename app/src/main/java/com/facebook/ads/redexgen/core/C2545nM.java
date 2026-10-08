package com.facebook.ads.redexgen.core;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2545nM extends AbstractC1199Eh<C2545nM> implements Comparable<C2545nM> {
    public static String[] A0I = {"kuPF6Ds61I7lkNvdz9bcVPsTInik8V3M", "Qk0zKRkYsaxRz9XBLHG1rmY7ne3qL", "U5xl3sY91uvZaW", "4oEkNGaUX02G9U6MTdWApFSB5pjWlUNx", "CFtCC3eFdvC", "EnNVjubCw6rdwWEp5vRTdV2Ipxq1ST06", "834ujo2VifTXBI2K", "5tr2zEJniV6LNy5ijK5ku"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final C10839i A0A;
    public final String A0B;
    public final boolean A0C;
    public final boolean A0D;
    public final boolean A0E;
    public final boolean A0F;
    public final boolean A0G;
    public final boolean A0H;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C2545nM(int i, C2688pg c2688pg, int i2, C10839i c10839i, int i3, boolean z, InterfaceC2396kj<C2725qI> interfaceC2396kj) {
        super(i, c2688pg, i2);
        this.A0A = c10839i;
        this.A0B = C10829h.A0K(super.A02.A0V);
        this.A0F = C10829h.A0S(i3, false);
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        while (true) {
            if (i6 >= c10839i.A0I.size()) {
                break;
            }
            int iA02 = C10829h.A02(super.A02, c10839i.A0I.get(i6), false);
            if (iA02 > 0) {
                i5 = i6;
                i4 = iA02;
                break;
            }
            i6++;
        }
        this.A04 = i5;
        this.A05 = i4;
        this.A07 = C10829h.A00(super.A02.A0E, ((C2684pc) c10839i).A0B);
        this.A0C = super.A02.A0E == 0 || (super.A02.A0E & 1) != 0;
        this.A0D = (super.A02.A0H & 1) != 0;
        this.A01 = super.A02.A06;
        this.A08 = super.A02.A0G;
        this.A00 = super.A02.A05;
        this.A0E = (super.A02.A05 == -1 || super.A02.A05 <= ((C2684pc) c10839i).A01) && (super.A02.A06 == -1 || super.A02.A06 <= ((C2684pc) c10839i).A02) && interfaceC2396kj.A4C(super.A02);
        String[] strArrA1L = C5C.A1L();
        int i7 = Integer.MAX_VALUE;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 >= strArrA1L.length) {
                break;
            }
            int iA022 = C10829h.A02(super.A02, strArrA1L[i9], false);
            if (iA022 > 0) {
                i7 = i9;
                i8 = iA022;
                break;
            }
            i9++;
        }
        this.A02 = i7;
        this.A03 = i8;
        int i10 = Integer.MAX_VALUE;
        int i11 = 0;
        while (true) {
            if (i11 < c10839i.A0J.size()) {
                if (super.A02.A0W != null && super.A02.A0W.equals(c10839i.A0J.get(i11))) {
                    i10 = i11;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        this.A06 = i10;
        this.A0H = AbstractC10377i.A02(i3) == 128;
        this.A0G = AbstractC10377i.A04(i3) == 64;
        this.A09 = A00(i3, z);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static int A02(List<C2545nM> list, List<C2545nM> list2) {
        return ((C2545nM) Collections.max(list)).compareTo((C2545nM) Collections.max(list2));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static BP<C2545nM> A03(int i, C2688pg c2688pg, C10839i c10839i, int[] iArr, boolean z, InterfaceC2396kj<C2725qI> interfaceC2396kj) {
        C2K c2kA01 = BP.A01();
        for (int i2 = 0; i2 < c2688pg.A01; i2++) {
            c2kA01.A04(new C2545nM(i, c2688pg, i2, c10839i, iArr[i2], z, interfaceC2396kj));
        }
        return c2kA01.A05();
    }

    private int A00(int i, boolean z) {
        if (!C10829h.A0S(i, this.A0A.A0B)) {
            return 0;
        }
        if (!this.A0E && !this.A0A.A09) {
            return 0;
        }
        if (C10829h.A0S(i, false) && this.A0E && super.A02.A05 != -1 && !this.A0A.A0N && !this.A0A.A0O && (this.A0A.A04 || !z)) {
            return 2;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.qK != com.google.common.collect.Ordering<java.lang.Integer> */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C2545nM c2545nM) {
        AbstractC2727qK abstractC2727qKA06;
        AbstractC2727qK abstractC2727qKA062 = (this.A0E && this.A0F) ? C10829h.A09 : C10829h.A09.A06();
        AbstractC2577ns abstractC2577nsA08 = AbstractC2577ns.A01().A09(this.A0F, c2545nM.A0F).A08(Integer.valueOf(this.A04), Integer.valueOf(c2545nM.A04), AbstractC2727qK.A03().A06()).A06(this.A05, c2545nM.A05).A06(this.A07, c2545nM.A07).A09(this.A0D, c2545nM.A0D).A09(this.A0C, c2545nM.A0C).A08(Integer.valueOf(this.A02), Integer.valueOf(c2545nM.A02), AbstractC2727qK.A03().A06()).A06(this.A03, c2545nM.A03).A09(this.A0E, c2545nM.A0E).A08(Integer.valueOf(this.A06), Integer.valueOf(c2545nM.A06), AbstractC2727qK.A03().A06());
        Integer numValueOf = Integer.valueOf(this.A00);
        Integer numValueOf2 = Integer.valueOf(c2545nM.A00);
        if (this.A0A.A0O) {
            abstractC2727qKA06 = C10829h.A09.A06();
        } else {
            abstractC2727qKA06 = C10829h.A0A;
        }
        AbstractC2577ns abstractC2577nsA082 = abstractC2577nsA08.A08(numValueOf, numValueOf2, abstractC2727qKA06).A09(this.A0H, c2545nM.A0H).A09(this.A0G, c2545nM.A0G).A08(Integer.valueOf(this.A01), Integer.valueOf(c2545nM.A01), abstractC2727qKA062).A08(Integer.valueOf(this.A08), Integer.valueOf(c2545nM.A08), abstractC2727qKA062);
        Integer numValueOf3 = Integer.valueOf(this.A00);
        Integer numValueOf4 = Integer.valueOf(c2545nM.A00);
        if (!C5C.A1E(this.A0B, c2545nM.A0B)) {
            abstractC2727qKA062 = C10829h.A0A;
        }
        return abstractC2577nsA082.A08(numValueOf3, numValueOf4, abstractC2727qKA062).A05();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    @Override // com.facebook.ads.redexgen.core.AbstractC1199Eh
    /* JADX INFO: renamed from: A04, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A09(com.facebook.ads.redexgen.core.C2545nM r6) {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.9i r0 = r5.A0A
            boolean r0 = r0.A00
            r3 = -1
            if (r0 != 0) goto L36
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            int r0 = r0.A06
            if (r0 == r3) goto L7a
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            int r4 = r0.A06
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2545nM.A0I
            r0 = 5
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 5
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L7c
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2545nM.A0I
            java.lang.String r1 = "4j0Ebeo7wJOJZxGoc5hIgJQJaA3nIP6d"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "7JU6hRyIHJ6Xx4Pnq3EsCWmSiYve8JpD"
            r0 = 0
            r2[r0] = r1
            com.facebook.ads.redexgen.X.qI r0 = r6.A02
            int r0 = r0.A06
            if (r4 != r0) goto L7a
        L36:
            com.facebook.ads.redexgen.X.9i r0 = r5.A0A
            boolean r0 = r0.A02
            if (r0 != 0) goto L50
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            java.lang.String r0 = r0.A0W
            if (r0 == 0) goto L7a
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            java.lang.String r1 = r0.A0W
            com.facebook.ads.redexgen.X.qI r0 = r6.A02
            java.lang.String r0 = r0.A0W
            boolean r0 = android.text.TextUtils.equals(r1, r0)
            if (r0 == 0) goto L7a
        L50:
            com.facebook.ads.redexgen.X.9i r0 = r5.A0A
            boolean r0 = r0.A03
            if (r0 != 0) goto L66
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            int r0 = r0.A0G
            if (r0 == r3) goto L7a
            com.facebook.ads.redexgen.X.qI r0 = r5.A02
            int r1 = r0.A0G
            com.facebook.ads.redexgen.X.qI r0 = r6.A02
            int r0 = r0.A0G
            if (r1 != r0) goto L7a
        L66:
            com.facebook.ads.redexgen.X.9i r0 = r5.A0A
            boolean r0 = r0.A01
            if (r0 != 0) goto L78
            boolean r1 = r5.A0H
            boolean r0 = r6.A0H
            if (r1 != r0) goto L7a
            boolean r1 = r5.A0G
            boolean r0 = r6.A0G
            if (r1 != r0) goto L7a
        L78:
            r0 = 1
        L79:
            return r0
        L7a:
            r0 = 0
            goto L79
        L7c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2545nM.A09(com.facebook.ads.redexgen.X.nM):boolean");
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC1199Eh
    public final int A08() {
        return this.A09;
    }
}
