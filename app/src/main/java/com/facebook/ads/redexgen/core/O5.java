package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdError;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class O5 {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Ascii.VT, 77, 81, 72, 73, 93, 90, SignedBytes.MAX_POWER_OF_TWO, 81, 70, 71, SignedBytes.MAX_POWER_OF_TWO, 93, SignedBytes.MAX_POWER_OF_TWO, 93, 85, 88};
    }

    public static void A02(C2165gi c2165gi, AbstractC2330jd abstractC2330jd, boolean z, O3 o3) {
        if (!C1615Up.A2E(c2165gi)) {
            C1571Sx c1571Sx = new C1571Sx(c2165gi);
            C1437No c1437NoA07 = abstractC2330jd.A29().A0H().A07();
            c1571Sx.A0e(new VI(abstractC2330jd.A2E(), c2165gi.A0A()));
            if (c1437NoA07 == null) {
                o3.AFF(AdError.CACHE_ERROR);
                return;
            }
            if (c1437NoA07.A0Y()) {
                o3.AFG();
                return;
            }
            C1567St c1567St = new C1567St(c1437NoA07.A0L(), abstractC2330jd.A1D(), abstractC2330jd.A10());
            c1567St.A04 = true;
            c1567St.A03 = A00(0, 5, 86);
            switch (O2.A00[c1437NoA07.A0G().ordinal()]) {
                case 1:
                case 2:
                    c1571Sx.A0Y(c1567St);
                    break;
            }
            c1571Sx.A0c(new C1569Sv(abstractC2330jd.A2C().A01(), -1, -1, abstractC2330jd.A1D(), abstractC2330jd.A10()));
            c1571Sx.A0c(new C1569Sv(c1437NoA07.A0K(), -1, -1, abstractC2330jd.A1D(), abstractC2330jd.A10()));
            O0.A00(abstractC2330jd, c1571Sx, A00(5, 12, 71));
            c1571Sx.A0X(new C2308jA(c2165gi, o3, c1571Sx, c1437NoA07, z), new C1564Sq(abstractC2330jd.A1D(), abstractC2330jd.A10()));
            return;
        }
        o3.AFG();
    }
}
