package com.facebook.ads.redexgen.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class O6 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{10, 76, 80, 73, 72, 121, 126, 100, 117, 98, 99, 100, 121, 100, 121, 113, 124, 101, 114, 96, 118, 101, 115, 114, 115, 72, 97, 126, 115, 114, 120};
    }

    /* JADX WARN: Incorrect condition in loop: B:11:0x00da */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A02(com.facebook.ads.redexgen.core.C2165gi r11, com.facebook.ads.redexgen.core.C1571Sx r12, com.facebook.ads.redexgen.core.C10407l r13) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.O6.A02(com.facebook.ads.redexgen.X.gi, com.facebook.ads.redexgen.X.Sx, com.facebook.ads.redexgen.X.7l):void");
    }

    public static void A03(C2165gi c2165gi, C1571Sx c1571Sx, C10407l c10407l) {
        int i = 0;
        for (NR nr : c10407l.A2G()) {
            C1569Sv c1569Sv = new C1569Sv(nr.A0H().A08(), O1.A00(nr.A0H()), O1.A01(nr.A0H()), c10407l.A1D(), A00(5, 12, 118));
            if (i == 0) {
                c1571Sx.A0c(c1569Sv);
            } else {
                c1571Sx.A0d(c1569Sv);
            }
            O0.A00(c10407l, c1571Sx, A00(17, 14, 113));
            Iterator<String> it = nr.A0K().A02().iterator();
            while (it.hasNext()) {
                c1571Sx.A0d(new C1569Sv(it.next(), -1, -1, c10407l.A1D(), A00(5, 12, 118)));
            }
            if (!TextUtils.isEmpty(nr.A0H().A09())) {
                new C1567St(nr.A0H().A09(), c10407l.A1D(), A00(5, 12, 118), nr.A0H().A06()).A04 = false;
            }
            i++;
        }
    }
}
