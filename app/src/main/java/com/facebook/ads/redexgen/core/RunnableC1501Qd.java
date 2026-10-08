package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class RunnableC1501Qd implements Runnable {
    public static Comparator<C1500Qc> A04;
    public static byte[] A05;
    public static String[] A06 = {"ZWObiMwNkhaZGfEgqHenCxQvRQCezgXM", "iKaB5ntiNbaiz6tgW", "JplxjEE1IYbCInXXNCkbxZV0", "UEoPOy6vCmPnpiXEMXmcZKvRtDoHf0nN", "JvUlYJe7lgtJoJN1gtwvhyIs", "RcG3r4ysor4dcgCWVGn8CFYsdgQ7jZkt", "cxmAjzJ", "EyohaYHYoMvb6y9gFGiucolIeU60NsdM"};
    public static final ThreadLocal<RunnableC1501Qd> A07;
    public long A00;
    public long A01;
    public ArrayList<C7M> A02 = new ArrayList<>();
    public ArrayList<C1500Qc> A03 = new ArrayList<>();

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{105, 109, Ascii.ESC, 117, 94, 72, 79, 94, 95, Ascii.ESC, 107, 73, 94, 93, 94, 79, 88, 83, 100, 96, Ascii.SYN, 102, 68, 83, 80, 83, 66, 85, 94};
    }

    static {
        A03();
        A07 = new ThreadLocal<>();
        A04 = new C1499Qb();
    }

    private RK A00(C7M c7m, int i, long j) {
        if (A08(c7m, i)) {
            return null;
        }
        RA ra = c7m.A0r;
        try {
            c7m.A1M();
            RK rkA0I = ra.A0I(i, false, j);
            if (rkA0I != null) {
                if (rkA0I.A0e() && !rkA0I.A0f()) {
                    ra.A0T(rkA0I.A0H);
                } else {
                    ra.A0Z(rkA0I, false);
                }
            }
            return rkA0I;
        } finally {
            c7m.A1o(false);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:16:0x0054 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02() {
        /*
            r10 = this;
            java.util.ArrayList<com.facebook.ads.redexgen.X.7M> r0 = r10.A02
            int r9 = r0.size()
            r4 = 0
            r3 = 0
        L8:
            r2 = 0
            if (r3 >= r9) goto L26
            java.util.ArrayList<com.facebook.ads.redexgen.X.7M> r0 = r10.A02
            java.lang.Object r1 = r0.get(r3)
            com.facebook.ads.redexgen.X.7M r1 = (com.facebook.ads.redexgen.core.C7M) r1
            int r0 = r1.getWindowVisibility()
            if (r0 != 0) goto L23
            com.facebook.ads.redexgen.X.hs r0 = r1.A02
            r0.A04(r1, r2)
            com.facebook.ads.redexgen.X.hs r0 = r1.A02
            int r0 = r0.A00
            int r4 = r4 + r0
        L23:
            int r3 = r3 + 1
            goto L8
        L26:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Qc> r0 = r10.A03
            r0.ensureCapacity(r4)
            r8 = 0
            r7 = 0
        L2d:
            if (r7 >= r9) goto L8f
            java.util.ArrayList<com.facebook.ads.redexgen.X.7M> r0 = r10.A02
            java.lang.Object r6 = r0.get(r7)
            com.facebook.ads.redexgen.X.7M r6 = (com.facebook.ads.redexgen.core.C7M) r6
            int r0 = r6.getWindowVisibility()
            if (r0 == 0) goto L40
        L3d:
            int r7 = r7 + 1
            goto L2d
        L40:
            com.facebook.ads.redexgen.X.hs r5 = r6.A02
            int r0 = r5.A01
            int r4 = java.lang.Math.abs(r0)
            int r0 = r5.A02
            int r0 = java.lang.Math.abs(r0)
            int r4 = r4 + r0
            r3 = 0
        L50:
            int r0 = r5.A00
            int r0 = r0 * 2
            if (r3 >= r0) goto L3d
            java.util.ArrayList<com.facebook.ads.redexgen.X.Qc> r0 = r10.A03
            int r0 = r0.size()
            if (r8 < r0) goto L86
            com.facebook.ads.redexgen.X.Qc r0 = new com.facebook.ads.redexgen.X.Qc
            r0.<init>()
            java.util.ArrayList<com.facebook.ads.redexgen.X.Qc> r1 = r10.A03
            r1.add(r0)
        L68:
            int[] r2 = r5.A03
            int r1 = r3 + 1
            r2 = r2[r1]
            if (r2 > r4) goto L84
            r1 = 1
        L71:
            r0.A04 = r1
            r0.A02 = r4
            r0.A00 = r2
            r0.A03 = r6
            int[] r1 = r5.A03
            r1 = r1[r3]
            r0.A01 = r1
            int r8 = r8 + 1
            int r3 = r3 + 2
            goto L50
        L84:
            r1 = 0
            goto L71
        L86:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Qc> r0 = r10.A03
            java.lang.Object r0 = r0.get(r8)
            com.facebook.ads.redexgen.X.Qc r0 = (com.facebook.ads.redexgen.core.C1500Qc) r0
            goto L68
        L8f:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Qc> r1 = r10.A03
            java.util.Comparator<com.facebook.ads.redexgen.X.Qc> r0 = com.facebook.ads.redexgen.core.RunnableC1501Qd.A04
            java.util.Collections.sort(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.RunnableC1501Qd.A02():void");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04(long r6) {
        /*
            r5 = this;
            r4 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Qc> r0 = r5.A03
            int r0 = r0.size()
            if (r4 >= r0) goto L31
            java.util.ArrayList<com.facebook.ads.redexgen.X.Qc> r0 = r5.A03
            java.lang.Object r3 = r0.get(r4)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.RunnableC1501Qd.A06
            r0 = 7
            r1 = r1[r0]
            r0 = 15
            char r1 = r1.charAt(r0)
            r0 = 103(0x67, float:1.44E-43)
            if (r1 == r0) goto L24
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L24:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.RunnableC1501Qd.A06
            java.lang.String r1 = "gpZ2KV2"
            r0 = 6
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Qc r3 = (com.facebook.ads.redexgen.core.C1500Qc) r3
            com.facebook.ads.redexgen.X.7M r0 = r3.A03
            if (r0 != 0) goto L32
        L31:
            return
        L32:
            r5.A06(r3, r6)
            r3.A00()
            int r4 = r4 + 1
            goto L1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.RunnableC1501Qd.A04(long):void");
    }

    private final void A05(long j) {
        A02();
        A04(j);
    }

    private void A06(C1500Qc c1500Qc, long j) {
        RK rkA00 = A00(c1500Qc.A03, c1500Qc.A01, c1500Qc.A04 ? Long.MAX_VALUE : j);
        if (rkA00 != null && rkA00.A09 != null && rkA00.A0e() && !rkA00.A0f()) {
            C7M c7m = rkA00.A09.get();
            if (A06[3].charAt(4) != 'O') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[0] = "y01bdO2VJYUoPT1JEr7HCeGbjhjinZRt";
            strArr[5] = "ogbTL45N3M3fzw26YptkCantwmvhDLLM";
            A07(c7m, j);
        }
    }

    private void A07(C7M c7m, long j) {
        if (c7m == null) {
            return;
        }
        if (c7m.A0C && c7m.A01.A06() != 0) {
            c7m.A1P();
        }
        C2236hs c2236hs = c7m.A02;
        c2236hs.A04(c7m, true);
        if (c2236hs.A00 != 0) {
            try {
                P4.A01(A01(0, 18, 83));
                c7m.A0s.A05(c7m.A04);
                for (int i = 0; i < c2236hs.A00 * 2; i += 2) {
                    A00(c7m, c2236hs.A03[i], j);
                }
            } finally {
                P4.A00();
            }
        }
    }

    public static boolean A08(C7M c7m, int i) {
        int iA06 = c7m.A01.A06();
        for (int i2 = 0; i2 < iA06; i2++) {
            RK rkA0F = C7M.A0F(c7m.A01.A0A(i2));
            int childCount = rkA0F.A03;
            if (childCount == i && !rkA0F.A0f()) {
                return true;
            }
        }
        return false;
    }

    public final void A09(C7M c7m) {
        this.A02.add(c7m);
    }

    public final void A0A(C7M c7m) {
        this.A02.remove(c7m);
    }

    public final void A0B(C7M c7m, int i, int i2) {
        if (c7m.isAttachedToWindow()) {
            long j = this.A01;
            String[] strArr = A06;
            if (strArr[0].charAt(20) != strArr[5].charAt(20)) {
                throw new RuntimeException();
            }
            A06[6] = "T8Y6UBY";
            if (j == 0) {
                this.A01 = c7m.getNanoTime();
                c7m.post(this);
            }
        }
        c7m.A02.A03(i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            P4.A01(A01(18, 11, 94));
            if (this.A02.isEmpty()) {
                this.A01 = 0L;
                if (A06[6].length() != 7) {
                    throw new RuntimeException();
                }
                A06[7] = "jOxF3Mzmcdx8L8GgZmI4I6pGAsyGGZV3";
                P4.A00();
                return;
            }
            int size = this.A02.size();
            long jMax = 0;
            for (int i = 0; i < size; i++) {
                C7M c7m = this.A02.get(i);
                if (c7m.getWindowVisibility() == 0) {
                    jMax = Math.max(c7m.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                return;
            }
            A05(TimeUnit.MILLISECONDS.toNanos(jMax) + this.A00);
        } finally {
            this.A01 = 0L;
            P4.A00();
        }
    }
}
