package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mC, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2486mC implements InterfaceC1317Ix {
    public static byte[] A03;
    public final int A00;
    public final int A01;
    public final C09724v A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 108);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{65, 77, Ascii.RS, Ascii.EM, Ascii.RS, Ascii.ETB, 77, Ascii.RS, Ascii.FF, 0, Ascii.GS, 1, 8, 77, Ascii.RS, 4, Ascii.ETB, 8, 87, 77, 70, 115, 104, 106, 87, 102, 117, 116, 98, 117, 116, 9, Base64.padSymbol, 44, 33, 39, 104, 59, 41, 37, 56, 36, 45, 104, 59, 33, 50, 45, 104, 37, 33, 59, 37, 41, 60, 43, 32, 102, 104, 59, 60, 59, 44, 104, 59, 41, 37, 56, 36, 45, 104, 59, 33, 50, 45, 114, 104, Ascii.EM, Ascii.CR, Ascii.FS, 17, Ascii.ETB, 87, 10, Ascii.EM, Ascii.SI};
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2486mC(com.facebook.ads.redexgen.core.C2487mD r7, com.facebook.ads.redexgen.core.C2725qI r8) {
        /*
            r6 = this;
            r6.<init>()
            com.facebook.ads.redexgen.X.4v r0 = r7.A00
            r6.A02 = r0
            com.facebook.ads.redexgen.X.4v r1 = r6.A02
            r0 = 12
            r1.A0f(r0)
            com.facebook.ads.redexgen.X.4v r0 = r6.A02
            int r5 = r0.A0L()
            r2 = 77
            r1 = 9
            r0 = 20
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.String r0 = r8.A0W
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6d
            int r1 = r8.A0C
            int r0 = r8.A06
            int r4 = com.facebook.ads.redexgen.core.C5C.A06(r1, r0)
            if (r5 == 0) goto L34
            int r0 = r5 % r4
            if (r0 == 0) goto L6d
        L34:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 31
            r1 = 46
            r0 = 36
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r3 = r0.append(r4)
            r2 = 0
            r1 = 20
            r0 = 1
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r3 = r0.toString()
            r2 = 20
            r1 = 11
            r0 = 107(0x6b, float:1.5E-43)
            java.lang.String r0 = A00(r2, r1, r0)
            com.facebook.ads.redexgen.core.AbstractC09574g.A07(r0, r3)
            r5 = r4
        L6d:
            if (r5 != 0) goto L70
            r5 = -1
        L70:
            r6.A00 = r5
            com.facebook.ads.redexgen.X.4v r0 = r6.A02
            int r0 = r0.A0L()
            r6.A01 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2486mC.<init>(com.facebook.ads.redexgen.X.mD, com.facebook.ads.redexgen.X.qI):void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1317Ix
    public final int A8A() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1317Ix
    public final int A8v() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1317Ix
    public final int AHS() {
        return this.A00 == -1 ? this.A02.A0L() : this.A00;
    }
}
