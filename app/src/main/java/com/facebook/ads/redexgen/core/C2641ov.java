package com.facebook.ads.redexgen.core;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ov, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2641ov implements EP {
    public static byte[] A01;
    public final /* synthetic */ C2640ou A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{118, 67, 67, 82, 90, 71, 67, 82, 83, Ascii.ETB, 67, 88, Ascii.ETB, 84, 69, 82, 86, 67, 82, Ascii.ETB, 83, 82, 84, 88, 83, 82, 69, Ascii.ETB, 81, 88, 69, Ascii.ETB, 66, 89, 68, 66, 71, 71, 88, 69, 67, 82, 83, Ascii.ETB, 81, 88, 69, 90, 86, 67, Ascii.FS, Ascii.CR, Ascii.CR, 17, Ascii.DC4, Ascii.RS, Ascii.FS, 9, Ascii.DC4, Ascii.DC2, 19, 82, Ascii.RS, Ascii.CAN, Ascii.FS, 80, 75, 77, 69, 121, 104, 104, 116, 113, 123, 121, 108, 113, 119, 118, 55, 123, 125, 121, 53, 47, 40, 32, 107, 122, 122, 102, 99, 105, 107, 126, 99, 101, 100, 37, 110, 124, 104, 121, 127, 104, 121, 69, 84, 84, 72, 77, 71, 69, 80, 77, 75, 74, Ascii.VT, 84, 67, 87, 5, Ascii.DC4, Ascii.DC4, 8, Ascii.CR, 7, 5, Ascii.DLE, Ascii.CR, Ascii.VT, 10, 75, Ascii.DLE, Ascii.DLE, 9, 8, 79, Ascii.FS, 9, 8, 0, 17, 17, Ascii.CR, 8, 2, 0, Ascii.NAK, 8, Ascii.SO, Ascii.SI, 78, Ascii.EM, 76, Ascii.FF, 17, 85, 76, 2, 4, 0, 76, 87, 81, 89, 53, 36, 36, 56, Base64.padSymbol, 55, 53, 32, Base64.padSymbol, 59, 58, 123, 44, 121, 57, 36, 96, 121, 34, 32, 32, 50, 35, 35, 63, 58, 48, 50, 39, 58, 60, Base64.padSymbol, 124, 43, 126, 34, 38, 58, 48, 56, 39, 58, 62, 54, 126, 39, 43, 96, 52, Ascii.FF, Ascii.GS, Ascii.GS, 1, 4, Ascii.SO, Ascii.FF, Ascii.EM, 4, 2, 3, 66, Ascii.NAK, SignedBytes.MAX_POWER_OF_TWO, Ascii.RS, Ascii.CAN, Ascii.SI, Ascii.US, 4, Ascii.GS, 68, 85, 72, 68, Ascii.US, 70, 68, 68, 83, 66, 95, 83, 8, 95, 10, 84, 84, 70};
    }

    public C2641ov(C2640ou c2640ou) {
        this.A00 = c2640ou;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0009  */
    @Override // com.facebook.ads.redexgen.core.EP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.InterfaceC2464lq A5K(com.facebook.ads.redexgen.core.C2725qI r6) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2641ov.A5K(com.facebook.ads.redexgen.X.qI):com.facebook.ads.redexgen.X.lq");
    }

    @Override // com.facebook.ads.redexgen.core.EP
    public final boolean AKN(C2725qI c2725qI) {
        String str = c2725qI.A0W;
        String mimeType = A00(236, 8, 34);
        if (!mimeType.equals(str)) {
            String mimeType2 = A00(244, 10, 53);
            if (!mimeType2.equals(str)) {
                String mimeType3 = A00(122, 20, 118);
                if (!mimeType3.equals(str)) {
                    String mimeType4 = A00(167, 21, 70);
                    if (!mimeType4.equals(str)) {
                        String mimeType5 = A00(216, 20, 127);
                        if (!mimeType5.equals(str)) {
                            String mimeType6 = A00(TsExtractor.TS_PACKET_SIZE, 28, 65);
                            if (!mimeType6.equals(str)) {
                                String mimeType7 = A00(50, 19, 111);
                                if (!mimeType7.equals(str)) {
                                    String mimeType8 = A00(142, 25, 115);
                                    if (!mimeType8.equals(str)) {
                                        String mimeType9 = A00(69, 19, 10);
                                        if (!mimeType9.equals(str)) {
                                            String mimeType10 = A00(88, 19, 24);
                                            if (!mimeType10.equals(str)) {
                                                String mimeType11 = A00(107, 15, 54);
                                                if (!mimeType11.equals(str)) {
                                                    return false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
