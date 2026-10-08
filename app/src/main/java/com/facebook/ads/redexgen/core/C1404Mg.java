package com.facebook.ads.redexgen.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1404Mg {
    public static byte[] A05;
    public static String[] A06 = {"nQDli3B322dNyuNUEmcA1lNjVYYmcThQ", "JG8wfEU3nZ2EADYXO0uZDMHFqmVSkpWr", "8K0NmfCVVugnhGVgpCD", "5JHmUKWu4ei3dzUY0lNr", "xKwnuhTKVDH3YhaAiUGpqwLltg47C3CG", "Jcwv8MY0", "vBOLiuiZ", "hny3hth3cGmNH4IG9ndqfAmzri4VXjHL"};
    public C2375kN A00;
    public final int A01;
    public final String A02;
    public final ArrayList<C1403Mf> A03;
    public final TreeSet<C2373kL> A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 47);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{115, -57, -62, 115, -100, -70, -68, -63, -66, -67, -100, -56, -57, -51, -66, -57, -51, -57, -30, -22, -19, -26, -27, -95, -11, -16, -95, -13, -26, -17, -30, -18, -26, -95};
    }

    static {
        A01();
    }

    public C1404Mg(int i, String str) {
        this(i, str, C2375kN.A03);
    }

    public C1404Mg(int i, String str, C2375kN c2375kN) {
        this.A01 = i;
        this.A02 = str;
        this.A00 = c2375kN;
        this.A04 = new TreeSet<>();
        this.A03 = new ArrayList<>();
    }

    public final long A02(long j, long j2) {
        boolean z = true;
        AbstractC09493y.A07(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        AbstractC09493y.A07(z);
        C2373kL c2373kLA04 = A04(j, j2);
        if (c2373kLA04.A03()) {
            return -Math.min(c2373kLA04.A04() ? Long.MAX_VALUE : c2373kLA04.A01, j2);
        }
        long j3 = j + j2;
        if (j3 < 0) {
            j3 = Long.MAX_VALUE;
        }
        long currentEndPosition = c2373kLA04.A02 + c2373kLA04.A01;
        if (currentEndPosition < j3) {
            TreeSet<C2373kL> treeSet = this.A04;
            String[] strArr = A06;
            if (strArr[5].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[2] = "31viDRwdD8ErVcI5dXS";
            strArr2[3] = "q1k4diPGE3D0s4ujqDJA";
            for (C2373kL c2373kL : treeSet.tailSet(c2373kLA04, false)) {
                if (c2373kL.A02 > currentEndPosition) {
                    break;
                }
                long j4 = c2373kL.A02;
                long queryEndPosition = c2373kL.A01;
                currentEndPosition = Math.max(currentEndPosition, j4 + queryEndPosition);
                if (currentEndPosition >= j3) {
                    break;
                }
            }
        }
        return Math.min(currentEndPosition - j, j2);
    }

    public final C2375kN A03() {
        return this.A00;
    }

    public final C2373kL A04(long j, long j2) {
        C2373kL c2373kLA03 = C2373kL.A03(this.A02, j);
        C2373kL c2373kLFloor = this.A04.floor(c2373kLA03);
        if (c2373kLFloor != null && c2373kLFloor.A02 + c2373kLFloor.A01 > j) {
            return c2373kLFloor;
        }
        C2373kL lookupSpan = this.A04.ceiling(c2373kLA03);
        if (lookupSpan != null) {
            long jMin = lookupSpan.A02 - j;
            if (j2 != -1) {
                jMin = Math.min(jMin, j2);
            }
            j2 = jMin;
        }
        return C2373kL.A04(this.A02, j, j2);
    }

    public final C2373kL A05(C2373kL c2373kL, long j, boolean z) {
        AbstractC09493y.A08(this.A04.remove(c2373kL));
        File file = (File) AbstractC09493y.A01(c2373kL.A03);
        if (z) {
            File file2 = file.getParentFile();
            File fileA05 = C2373kL.A05((File) AbstractC09493y.A01(file2), this.A01, c2373kL.A02, j);
            if (file.renameTo(fileA05)) {
                file = fileA05;
            } else {
                AbstractC09574g.A07(A00(4, 13, 42), A00(17, 17, 82) + file + A00(0, 4, 36) + fileA05);
            }
        }
        C2373kL newCacheSpan = c2373kL.A09(file, j);
        this.A04.add(newCacheSpan);
        return newCacheSpan;
    }

    public final TreeSet<C2373kL> A06() {
        return this.A04;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07(long r5) {
        /*
            r4 = this;
            r3 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r4.A03
            int r0 = r0.size()
            if (r3 >= r0) goto L20
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r4.A03
            java.lang.Object r0 = r0.get(r3)
            com.facebook.ads.redexgen.X.Mf r0 = (com.facebook.ads.redexgen.core.C1403Mf) r0
            long r1 = r0.A01
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 != 0) goto L1d
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r4.A03
            r0.remove(r3)
            return
        L1d:
            int r3 = r3 + 1
            goto L1
        L20:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1404Mg.A07(long):void");
    }

    public final void A08(C2373kL c2373kL) {
        this.A04.add(c2373kL);
    }

    public final boolean A09() {
        return this.A04.isEmpty();
    }

    public final boolean A0A() {
        return this.A03.isEmpty();
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B(long r3, long r5) {
        /*
            r2 = this;
            r1 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r2.A03
            int r0 = r0.size()
            if (r1 >= r0) goto L1c
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r2.A03
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.Mf r0 = (com.facebook.ads.redexgen.core.C1403Mf) r0
            boolean r0 = r0.A00(r3, r5)
            if (r0 == 0) goto L19
            r0 = 1
            return r0
        L19:
            int r1 = r1 + 1
            goto L1
        L1c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1404Mg.A0B(long, long):boolean");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0C(long r3, long r5) {
        /*
            r2 = this;
            r1 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r2.A03
            int r0 = r0.size()
            if (r1 >= r0) goto L1c
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r2.A03
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.Mf r0 = (com.facebook.ads.redexgen.core.C1403Mf) r0
            boolean r0 = r0.A01(r3, r5)
            if (r0 == 0) goto L19
            r0 = 0
            return r0
        L19:
            int r1 = r1 + 1
            goto L1
        L1c:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r1 = r2.A03
            com.facebook.ads.redexgen.X.Mf r0 = new com.facebook.ads.redexgen.X.Mf
            r0.<init>(r3, r5)
            r1.add(r0)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1404Mg.A0C(long, long):boolean");
    }

    public final boolean A0D(MZ mz) {
        if (this.A04.remove(mz)) {
            if (mz.A03 != null) {
                mz.A03.delete();
                return true;
            }
            return true;
        }
        String[] strArr = A06;
        if (strArr[2].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[2] = "U4uu0ltzeeg5QMm1KwS";
        strArr2[3] = "VtFGErd1YdVsfyUNL3Po";
        return false;
    }

    public final boolean A0E(C1409Ml c1409Ml) {
        C2375kN c2375kN = this.A00;
        C2375kN oldMetadata = this.A00;
        this.A00 = oldMetadata.A05(c1409Ml);
        C2375kN oldMetadata2 = this.A00;
        return !oldMetadata2.equals(c2375kN);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1404Mg c1404Mg = (C1404Mg) obj;
        if (this.A01 == c1404Mg.A01 && this.A02.equals(c1404Mg.A02) && this.A04.equals(c1404Mg.A04) && this.A00.equals(c1404Mg.A00)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A01;
        int i = result * 31;
        int result2 = this.A02.hashCode();
        return ((i + result2) * 31) + this.A00.hashCode();
    }
}
