package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.El, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1203El {
    public static byte[] A03;
    public final int A00;
    public final C2688pg A01;
    public final int[] A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 82);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-11, 4, 3, -12, Ascii.NAK, Ascii.SYN, Ascii.EM, Ascii.RS, Ascii.EM, 36, Ascii.EM, Ascii.US, Ascii.RS, 3, 43, 46, 50, 55, -34, 50, 48, Ascii.US, 33, 41, 49, -34, Ascii.US, 48, 35, -34, 44, 45, 50, -34, Ascii.US, 42, 42, 45, 53, 35, 34};
    }

    public C1203El(C2688pg c2688pg, int... iArr) {
        this(c2688pg, iArr, 0);
    }

    public C1203El(C2688pg c2688pg, int[] iArr, int i) {
        if (iArr.length == 0) {
            AbstractC09574g.A08(A00(0, 13, 94), A00(13, 28, 108), new IllegalArgumentException());
        }
        this.A01 = c2688pg;
        this.A02 = iArr;
        this.A00 = i;
    }
}
