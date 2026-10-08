package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2604oK implements InterfaceC10738v {
    public static byte[] A01;
    public static String[] A02 = {"", "W3zKx7uimPBnuqB79eRuk71Lq6Q9Tdtq", "pdw5IcOEDsyx", "PznYxCtiabQ1XXQUVp9BfEAYIGk6ZsUE", "E1k4hPJKfb0MvebzJOZYusmHHBWvORO7", "bmueFxdYYt0nqn8p", "GRfRtgnBgmJZB0Qq", "VS7ML1wDeymmTLeKFRcttz7uEm3bVRGQ"};
    public final /* synthetic */ AnonymousClass12 A00;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[5].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A02[4] = "fuFs1gweK6T0kCx4bj1F2DHsk5QuVwMS";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 8);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{47, Ascii.ESC, 10, 7, 1, 78, Ascii.GS, 7, 0, 5, 78, Ascii.VT, Ascii.FS, Ascii.FS, 1, Ascii.FS, 32, 8, 9, 4, Ascii.FF, 46, 2, 9, 8, Ascii.SO, 44, Ascii.CAN, 9, 4, 2, 63, 8, 3, 9, 8, Ascii.US, 8, Ascii.US, 55, 54, Ascii.VT, 52, Base64.padSymbol, Base64.padSymbol, 40, Ascii.CAN, Ascii.EM, 32, Ascii.SYN, Ascii.FS, Ascii.DC2, 2, 7};
    }

    static {
        A01();
    }

    public C2604oK(AnonymousClass12 anonymousClass12) {
        this.A00 = anonymousClass12;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10738v
    public final void AD6(Exception exc) {
        AbstractC09574g.A08(A00(16, 23, 101), A00(0, 16, 102), exc);
        this.A00.A0F.A0D(exc);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10738v
    public final void AD7(C10708r c10708r) {
        this.A00.A0F.A0B(c10708r);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10738v
    public final void AD8(C10708r c10708r) {
        this.A00.A0F.A0C(c10708r);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10738v
    public final void AF2() {
        AnonymousClass12.A05(this.A00);
        if (0 != 0) {
            AnonymousClass12.A05(this.A00);
            throw new NullPointerException(A00(46, 8, 127));
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10738v
    public final void AF3() {
        AnonymousClass12.A05(this.A00);
        if (0 != 0) {
            AnonymousClass12.A05(this.A00);
            throw new NullPointerException(A00(39, 7, 80));
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10738v
    public final void AFN(long j) {
        this.A00.A0F.A03(j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10738v
    public final void AFO() {
        this.A00.A26();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10738v
    public final void AFy(boolean z) {
        this.A00.A0F.A0I(z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10738v
    public final void AGJ(int i, long j, long j2) {
        this.A00.A0F.A01(i, j, j2);
    }
}
