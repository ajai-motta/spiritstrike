package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class LI {
    public static String[] A00 = {"zHvJnNiJi0M", "FniiyLS950t5mTu4QlbfX1TrXuc", "I7PZw93cjLP5IpZ6BbWCD", "9iobBdNwIxtUK2g", "LhRCEY8vP1M7TerIjGAXS82kM3fiu", "vMv2t0fFsfhvwPnbOb52fPF3dg3aW", "XvTrrYiBPPp7CW1", "g12euaG6mbsrKt48m9yyXN0g2MG"};

    public static int A00(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static long A01(C09724v c09724v, int i, int i2) {
        c09724v.A0f(i);
        if (c09724v.A07() < 5) {
            return C.TIME_UNSET;
        }
        int pid = c09724v.A0C();
        int tsPacketHeader = 8388608 & pid;
        if (tsPacketHeader != 0) {
            return C.TIME_UNSET;
        }
        int tsPacketHeader2 = 2096896 & pid;
        if ((tsPacketHeader2 >> 8) != i2) {
            return C.TIME_UNSET;
        }
        int tsPacketHeader3 = pid & 32;
        int tsPacketHeader4 = tsPacketHeader3 != 0 ? 1 : 0;
        if (tsPacketHeader4 == 0) {
            return C.TIME_UNSET;
        }
        int tsPacketHeader5 = c09724v.A0I();
        if (tsPacketHeader5 >= 7) {
            int tsPacketHeader6 = c09724v.A07();
            if (tsPacketHeader6 >= 7) {
                int tsPacketHeader7 = c09724v.A0I();
                if ((tsPacketHeader7 & 16) == 16) {
                    byte[] bArr = new byte[6];
                    int tsPacketHeader8 = bArr.length;
                    c09724v.A0k(bArr, 0, tsPacketHeader8);
                    long jA02 = A02(bArr);
                    String[] strArr = A00;
                    String str = strArr[4];
                    String str2 = strArr[5];
                    int pid2 = str.length();
                    int tsPacketHeader9 = str2.length();
                    if (pid2 != tsPacketHeader9) {
                        throw new RuntimeException();
                    }
                    A00[2] = "oAb2qjZGj";
                    return jA02;
                }
            }
        }
        return C.TIME_UNSET;
    }

    public static long A02(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A03(byte[] r6, int r7, int r8, int r9) {
        /*
            r4 = 0
            r3 = -4
        L2:
            r0 = 4
            if (r3 > r0) goto L41
            int r5 = r3 * 188
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.LI.A00
            r0 = 3
            r1 = r2[r0]
            r0 = 6
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L1f
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1f:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.LI.A00
            java.lang.String r1 = "Qn38sx03S77VT5y"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "gfX0N6dqp84BCDo"
            r0 = 6
            r2[r0] = r1
            int r5 = r5 + r9
            if (r5 < r7) goto L36
            if (r5 >= r8) goto L36
            r1 = r6[r5]
            r0 = 71
            if (r1 == r0) goto L3a
        L36:
            r4 = 0
        L37:
            int r3 = r3 + 1
            goto L2
        L3a:
            int r4 = r4 + 1
            r0 = 5
            if (r4 != r0) goto L37
            r0 = 1
            return r0
        L41:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.LI.A03(byte[], int, int, int):boolean");
    }
}
