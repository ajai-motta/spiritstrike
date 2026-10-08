package com.facebook.ads.redexgen.core;

import android.util.SparseArray;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2437lP implements LE {
    public static byte[] A02;
    public static String[] A03 = {"H5L2tIFZt", "7T8ctTOgfri2uFWYkrl4fLjFw3zYZmyw", "rpSuNqLmPSNrp8BaktpsZc4frut4njZi", "OS1ujTmztQNXT6hqD6nsoX0kfRSYmmsY", "PkY6KfFeVbpCvwlFdEj", "TmaVkoyYGnCbszGh0vcMc", "p0AihzwiszaEN", "o1l4pHohEGjnpBhSGl6NtukXiQnI0CCo"};
    public final int A00;
    public final List<C2725qI> A01;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    private List<C2725qI> A03(LD ld) {
        String strA02;
        int i;
        if (A05(32)) {
            return this.A01;
        }
        C09724v c09724v = new C09724v(ld.A03);
        List<C2725qI> arrayList = this.A01;
        while (c09724v.A07() > 0) {
            int iA0I = c09724v.A0I();
            int iA09 = c09724v.A09() + c09724v.A0I();
            if (iA0I == 134) {
                arrayList = new ArrayList<>();
                int iA0I2 = c09724v.A0I() & 31;
                for (int i2 = 0; i2 < iA0I2; i2++) {
                    String strA0W = c09724v.A0W(3);
                    int iA0I3 = c09724v.A0I();
                    boolean z = (iA0I3 & 128) != 0;
                    if (z) {
                        strA02 = A02(19, 19, 47);
                        i = iA0I3 & 63;
                    } else {
                        strA02 = A02(0, 19, 57);
                        i = 1;
                    }
                    byte bA0I = (byte) c09724v.A0I();
                    c09724v.A0g(1);
                    List<byte[]> listA04 = null;
                    if (z) {
                        boolean z2 = (bA0I & SignedBytes.MAX_POWER_OF_TWO) != 0;
                        if (A03[5].length() != 21) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A03;
                        strArr[6] = "Fx9tcNCtSciYr";
                        strArr[4] = "fWuzF8xs7o61BMX22RC";
                        listA04 = AnonymousClass46.A04(z2);
                    }
                    arrayList.add(new C09162p().A11(strA02).A10(strA0W).A0Z(i).A12(listA04).A14());
                }
            }
            c09724v.A0f(iA09);
        }
        return arrayList;
    }

    public static void A04() {
        A02 = new byte[]{-30, -15, -15, -19, -22, -28, -30, -11, -22, -16, -17, -80, -28, -26, -30, -82, -73, -79, -71, -40, -25, -25, -29, -32, -38, -40, -21, -32, -26, -27, -90, -38, -36, -40, -92, -82, -89, -81, Ascii.FF, Ascii.ESC, Ascii.ESC, Ascii.ETB, Ascii.DC4, Ascii.SO, Ascii.FF, Ascii.US, Ascii.DC4, Ascii.SUB, Ascii.EM, -38, 33, Ascii.EM, Ascii.SI, -39, Ascii.SI, 33, Ascii.CR, -39, Ascii.FF, Ascii.DC4, Ascii.US, -61, -46, -46, -50, -53, -59, -61, -42, -53, -47, -48, -111, -38, -113, -43, -59, -42, -57, -107, -105};
    }

    static {
        A04();
    }

    public C2437lP() {
        this(0);
    }

    @MetaExoPlayerCustomization("Replaces ImmutableList.of with MetaExoPlayerCustomizedCollections")
    public C2437lP(int i) {
        this(i, MetaExoPlayerCustomizedCollections.A03(new C2725qI[0]));
    }

    public C2437lP(int i, List<C2725qI> list) {
        this.A00 = i;
        this.A01 = list;
    }

    private L9 A00(LD ld) {
        return new L9(A03(ld));
    }

    private LJ A01(LD ld) {
        return new LJ(A03(ld));
    }

    private boolean A05(int i) {
        return (this.A00 & i) != 0;
    }

    @Override // com.facebook.ads.redexgen.core.LE
    public final SparseArray<LH> A5Q() {
        return new SparseArray<>();
    }

    @Override // com.facebook.ads.redexgen.core.LE
    public final LH A5V(int i, LD ld) {
        switch (i) {
            case 2:
            case 128:
                return new C2426lE(new C2434lM(A01(ld)));
            case 3:
            case 4:
                return new C2426lE(new C2428lG(ld.A01));
            case 15:
                if (A05(2)) {
                    return null;
                }
                return new C2426lE(new C2438lQ(false, ld.A01));
            case 16:
                return new C2426lE(new C2433lL(A01(ld)));
            case 17:
                if (A05(2)) {
                    return null;
                }
                return new C2426lE(new C2429lH(ld.A01));
            case 21:
                return new C2426lE(new C2430lI());
            case 27:
                if (A05(4)) {
                    return null;
                }
                return new C2426lE(new C2432lK(A00(ld), A05(1), A05(8)));
            case 36:
                return new C2426lE(new C2431lJ(A00(ld)));
            case 89:
                return new C2426lE(new C2435lN(ld.A02));
            case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
            case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                return new C2426lE(new C2444lW(ld.A01));
            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                if (!A05(64)) {
                    return null;
                }
                break;
            case TsExtractor.TS_STREAM_TYPE_SPLICE_INFO /* 134 */:
                if (A05(16)) {
                    return null;
                }
                return new C2421l9(new C2427lF(A02(61, 20, 26)));
            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                break;
            case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                return new C2426lE(new C2441lT(ld.A01));
            case 257:
                return new C2421l9(new C2427lF(A02(38, 23, 99)));
            default:
                return null;
        }
        return new C2426lE(new C2436lO(ld.A01));
    }
}
