package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2589o5 implements InterfaceC1120Bd {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 45);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{40, Ascii.GS, Ascii.GS, Ascii.FF, 4, Ascii.EM, Ascii.GS, Ascii.FF, Ascii.CR, 73, Ascii.GS, 6, 73, 10, Ascii.ESC, Ascii.FF, 8, Ascii.GS, Ascii.FF, 73, Ascii.CR, Ascii.FF, 10, 6, Ascii.CR, Ascii.FF, Ascii.ESC, 73, Ascii.SI, 6, Ascii.ESC, 73, Ascii.FS, 7, Ascii.SUB, Ascii.FS, Ascii.EM, Ascii.EM, 6, Ascii.ESC, Ascii.GS, Ascii.FF, Ascii.CR, 73, 36, 32, 36, 44, 73, Ascii.GS, Ascii.DLE, Ascii.EM, Ascii.FF, 83, 73, Ascii.EM, 8, 8, Ascii.DC4, 17, Ascii.ESC, Ascii.EM, Ascii.FF, 17, Ascii.ETB, Ascii.SYN, 87, 17, Ascii.FS, 75, 19, 2, 2, Ascii.RS, Ascii.ESC, 17, 19, 6, Ascii.ESC, Ascii.GS, Ascii.FS, 93, 10, 95, Ascii.ETB, Ascii.US, 1, Ascii.NAK, 5, Ascii.DC4, Ascii.DC4, 8, Ascii.CR, 7, 5, Ascii.DLE, Ascii.CR, Ascii.VT, 10, 75, Ascii.FS, 73, Ascii.CR, 7, Ascii.GS, 58, 43, 43, 55, 50, 56, 58, 47, 50, 52, 53, 116, 35, 118, 40, 56, 47, 62, 104, 110};
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC1120Bd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.InterfaceC1291Hw A5J(com.facebook.ads.redexgen.core.C2725qI r6) {
        /*
            r5 = this;
            java.lang.String r3 = r6.A0W
            if (r3 == 0) goto Lf
            int r0 = r3.hashCode()
            switch(r0) {
                case -1348231605: goto L65;
                case -1248341703: goto L53;
                case 1154383568: goto L41;
                case 1652648887: goto L2f;
                default: goto Lb;
            }
        Lb:
            r0 = -1
        Lc:
            switch(r0) {
                case 0: goto L89;
                case 1: goto L83;
                case 2: goto L7d;
                case 3: goto L77;
                default: goto Lf;
            }
        Lf:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r2 = 0
            r1 = 55
            r0 = 68
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r1 = r0.toString()
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r0.<init>(r1)
            throw r0
        L2f:
            r2 = 105(0x69, float:1.47E-43)
            r1 = 20
            r0 = 118(0x76, float:1.65E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lb
            r0 = 2
            goto Lc
        L41:
            r2 = 70
            r1 = 18
            r0 = 95
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lb
            r0 = 1
            goto Lc
        L53:
            r2 = 55
            r1 = 15
            r0 = 85
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lb
            r0 = 0
            goto Lc
        L65:
            r2 = 88
            r1 = 17
            r0 = 73
            java.lang.String r0 = A00(r2, r1, r0)
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto Lb
            r0 = 3
            goto Lc
        L77:
            com.facebook.ads.redexgen.X.9c r0 = new com.facebook.ads.redexgen.X.9c
            r0.<init>()
            return r0
        L7d:
            com.facebook.ads.redexgen.X.94 r0 = new com.facebook.ads.redexgen.X.94
            r0.<init>()
            return r0
        L83:
            com.facebook.ads.redexgen.X.9d r0 = new com.facebook.ads.redexgen.X.9d
            r0.<init>()
            return r0
        L89:
            com.facebook.ads.redexgen.X.9U r0 = new com.facebook.ads.redexgen.X.9U
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2589o5.A5J(com.facebook.ads.redexgen.X.qI):com.facebook.ads.redexgen.X.Hw");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1120Bd
    public final boolean AKN(C2725qI c2725qI) {
        String str = c2725qI.A0W;
        String mimeType = A00(55, 15, 85);
        if (!mimeType.equals(str)) {
            String mimeType2 = A00(70, 18, 95);
            if (!mimeType2.equals(str)) {
                String mimeType3 = A00(105, 20, 118);
                if (!mimeType3.equals(str)) {
                    String mimeType4 = A00(88, 17, 73);
                    if (!mimeType4.equals(str)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
