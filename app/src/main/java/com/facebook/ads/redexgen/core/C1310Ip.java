package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ip, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1310Ip {
    public static String[] A02 = {"FbN3icTzKhcmmOzEdUfRhsUcZXOxDMx7", "gRO2jrgUj", "b8s", "WfQv3ylCa", "vfaK2gbRuWFTNhe4O3MK62WfTyU3BnZK", "pVe6dBWT2JPKzaWtvTS73YU0fEYT7kcM", "E55gBTZIZGS8er9hAJqyKM4XsX", "9GOGOeqncrOiIcn9"};
    public int A00;
    public final C09724v A01 = new C09724v(8);

    /* JADX WARN: Incorrect condition in loop: B:8:0x001f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private long A00(com.facebook.ads.redexgen.core.InterfaceC2516ms r6) throws java.io.IOException {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.4v r0 = r5.A01
            byte[] r0 = r0.A0l()
            r1 = 0
            r2 = 1
            r6.AGt(r0, r1, r2)
            com.facebook.ads.redexgen.X.4v r0 = r5.A01
            byte[] r0 = r0.A0l()
            r0 = r0[r1]
            r4 = r0 & 255(0xff, float:3.57E-43)
            if (r4 != 0) goto L1a
            r0 = -9223372036854775808
            return r0
        L1a:
            r1 = 128(0x80, float:1.8E-43)
            r3 = 0
        L1d:
            r0 = r4 & r1
            if (r0 != 0) goto L26
            int r1 = r1 >> 1
            int r3 = r3 + 1
            goto L1d
        L26:
            int r0 = ~r1
            r4 = r4 & r0
            com.facebook.ads.redexgen.X.4v r0 = r5.A01
            byte[] r0 = r0.A0l()
            r6.AGt(r0, r2, r3)
            r2 = 0
        L32:
            if (r2 >= r3) goto L46
            int r4 = r4 << 8
            com.facebook.ads.redexgen.X.4v r0 = r5.A01
            byte[] r1 = r0.A0l()
            int r0 = r2 + 1
            r0 = r1[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            int r4 = r4 + r0
            int r2 = r2 + 1
            goto L32
        L46:
            int r1 = r5.A00
            int r0 = r3 + 1
            int r1 = r1 + r0
            r5.A00 = r1
            long r0 = (long) r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C1310Ip.A00(com.facebook.ads.redexgen.X.ms):long");
    }

    public final boolean A01(InterfaceC2516ms interfaceC2516ms) throws IOException {
        long jA8O = interfaceC2516ms.A8O();
        long j = 1024;
        if (jA8O != -1 && jA8O <= 1024) {
            j = jA8O;
        }
        int i = (int) j;
        boolean z = false;
        interfaceC2516ms.AGt(this.A01.A0l(), 0, 4);
        long jA0Q = this.A01.A0Q();
        this.A00 = 4;
        while (jA0Q != 440786851) {
            int i2 = this.A00 + 1;
            this.A00 = i2;
            if (i2 == i) {
                return false;
            }
            interfaceC2516ms.AGt(this.A01.A0l(), 0, 1);
            long j2 = jA0Q << 8;
            if (A02[5].charAt(9) == 'Z') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[7] = "keWgERcis7TdroPm";
            strArr[2] = "OXY";
            jA0Q = (j2 & (-256)) | ((long) (this.A01.A0l()[0] & 255));
        }
        long jA00 = A00(interfaceC2516ms);
        int i3 = this.A00;
        String[] strArr2 = A02;
        if (strArr2[7].length() == strArr2[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr3 = A02;
        strArr3[0] = "8USntBNRnGq1k7YndUZ918x7mjNkxlAo";
        strArr3[4] = "NlU12704XsvvTftMDquGsme1zZ9M6Gib";
        long j3 = i3;
        if (jA00 == Long.MIN_VALUE) {
            return false;
        }
        if (jA8O != -1 && j3 + jA00 >= jA8O) {
            return false;
        }
        while (this.A00 < j3 + jA00) {
            if (A00(interfaceC2516ms) == Long.MIN_VALUE) {
                return z;
            }
            long jA002 = A00(interfaceC2516ms);
            String[] strArr4 = A02;
            if (strArr4[0].charAt(12) != strArr4[4].charAt(12)) {
                String[] strArr5 = A02;
                strArr5[0] = "WOjoKoWSnEX2mR88EDllzX7MR8FXWjEu";
                strArr5[4] = "zFQ8S5RVgPrJFIVyTDDE2qr0iqJgcsXB";
                if (jA002 < 0) {
                    return false;
                }
            } else {
                A02[6] = "uJmDg5c2xISP09FpPwUdNktwoy";
                if (jA002 < 0) {
                    return false;
                }
            }
            if (jA002 > 2147483647L) {
                return false;
            }
            if (jA002 != 0) {
                int i4 = (int) jA002;
                interfaceC2516ms.A47(i4);
                this.A00 += i4;
            }
            z = false;
        }
        return ((long) this.A00) == j3 + jA00;
    }
}
