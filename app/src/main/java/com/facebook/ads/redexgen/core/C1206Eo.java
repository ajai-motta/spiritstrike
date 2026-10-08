package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1206Eo {
    public final int A00;
    public final C2555nW A01;
    public final int[] A02;
    public final int[] A03;
    public final C2555nW[] A04;
    public final String[] A05;
    public final int[][][] A06;

    public C1206Eo(String[] strArr, int[] iArr, C2555nW[] c2555nWArr, int[] iArr2, int[][][] iArr3, C2555nW c2555nW) {
        this.A05 = strArr;
        this.A03 = iArr;
        this.A04 = c2555nWArr;
        this.A06 = iArr3;
        this.A02 = iArr2;
        this.A01 = c2555nW;
        this.A00 = iArr.length;
    }

    private final int A00(int i, int i2, int i3) {
        return this.A06[i][i2][i3];
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A01(int r8, int r9, int[] r10) {
        /*
            r7 = this;
            r6 = 0
            r2 = 16
            r5 = 0
            r4 = 0
            r3 = 0
        L6:
            int r0 = r10.length
            if (r3 >= r0) goto L3b
            r1 = r10[r3]
            com.facebook.ads.redexgen.X.nW[] r0 = r7.A04
            r0 = r0[r8]
            com.facebook.ads.redexgen.X.pg r0 = r0.A05(r9)
            com.facebook.ads.redexgen.X.qI r0 = r0.A08(r1)
            java.lang.String r0 = r0.A0W
            int r1 = r6 + 1
            if (r6 != 0) goto L32
            r4 = r0
        L1e:
            int[][][] r0 = r7.A06
            r0 = r0[r8]
            r0 = r0[r9]
            r0 = r0[r3]
            int r0 = com.facebook.ads.redexgen.core.AbstractC10377i.A01(r0)
            int r2 = java.lang.Math.min(r2, r0)
            int r3 = r3 + 1
            r6 = r1
            goto L6
        L32:
            boolean r0 = com.facebook.ads.redexgen.core.C5C.A1E(r4, r0)
            r0 = r0 ^ 1
            r0 = r0 | r5
            r5 = r0
            goto L1e
        L3b:
            if (r5 == 0) goto L45
            int[] r0 = r7.A02
            r0 = r0[r8]
            int r2 = java.lang.Math.min(r2, r0)
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1206Eo.A01(int, int, int[]):int");
    }

    public final int A02() {
        return this.A00;
    }

    public final int A03(int i) {
        return this.A03[i];
    }

    public final int A04(int i, int i2, int i3) {
        return AbstractC10377i.A03(A00(i, i2, i3));
    }

    public final int A05(int i, int i2, boolean z) {
        int i3 = this.A04[i].A05(i2).A01;
        int[] iArr = new int[i3];
        int i4 = 0;
        for (int trackIndexCount = 0; trackIndexCount < i3; trackIndexCount++) {
            int iA04 = A04(i, i2, trackIndexCount);
            if (iA04 == 4 || (z && iA04 == 3)) {
                int trackCount = i4 + 1;
                iArr[i4] = trackIndexCount;
                i4 = trackCount;
            }
        }
        int trackCount2 = A01(i, i2, Arrays.copyOf(iArr, i4));
        return trackCount2;
    }

    public final C2555nW A06() {
        return this.A01;
    }

    public final C2555nW A07(int i) {
        return this.A04[i];
    }
}
