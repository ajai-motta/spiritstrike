package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class LP {
    public static byte[] A00;
    public static String[] A01 = {"sX38XYxjSWs23SpIJtTv7zqsiULa6NDN", "GVdzvLjErUQlCiFlI6sj0UXKxa4oVMD1", "mIptDDVqgJzdzMBxnTdyNQyM9U5NEVN", "EbHk890dVqPqb4rol71PU8NjsI2mWG9N", "NaaYWHcYaAW6JEQtPhbZM5A", "ny7KRitGLB3lrMhzsw8kbWX2NySq0vmW", "JAavj5eiIDuEB7ikgcXMWWkFbaDdUxIE", "svQ0hoJoeE45w1Y6xC2"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static LN A02(InterfaceC2516ms interfaceC2516ms) throws IOException {
        byte[] bArr;
        C09724v c09724v = new C09724v(16);
        LO loA03 = A03(WavUtil.FMT_FOURCC, interfaceC2516ms, c09724v);
        AbstractC09493y.A08(loA03.A01 >= 16);
        interfaceC2516ms.AGt(c09724v.A0l(), 0, 16);
        c09724v.A0f(0);
        int iA0G = c09724v.A0G();
        int iA0G2 = c09724v.A0G();
        int iA0F = c09724v.A0F();
        int iA0F2 = c09724v.A0F();
        int iA0G3 = c09724v.A0G();
        int iA0G4 = c09724v.A0G();
        int i = ((int) loA03.A01) - 16;
        if (i > 0) {
            bArr = new byte[i];
            interfaceC2516ms.AGt(bArr, 0, i);
        } else {
            bArr = C5C.A07;
        }
        interfaceC2516ms.AK3((int) (interfaceC2516ms.A8i() - interfaceC2516ms.A8n()));
        return new LN(iA0G, iA0G2, iA0F, iA0F2, iA0G3, iA0G4, bArr);
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{59, Ascii.DLE, Ascii.CR, Ascii.SYN, 19, 88, 17, Ascii.VT, 88, Ascii.FF, Ascii.ETB, Ascii.ETB, 88, Ascii.DC4, Ascii.EM, 10, Ascii.US, Ascii.GS, 88, 80, 6, 74, 63, 58, 83, 81, 88, Ascii.FF, Ascii.ETB, 88, Ascii.VT, 19, 17, 8, 67, 88, 17, Ascii.FS, 66, 88, 45, 3, 10, Ascii.VT, Ascii.SYN, Ascii.CR, 10, 3, 68, 17, 10, Ascii.SI, 10, Ascii.VT, 19, 10, 68, 51, 37, 50, 68, 7, Ascii.FF, 17, 10, Ascii.SI, 94, 68, 105, 82, 79, 73, 76, 76, 83, 78, 72, 89, 88, Ascii.FS, 90, 83, 78, 81, Ascii.FS, 72, 69, 76, 89, 6, Ascii.FS, 105, 95, 72, 118, 91, 95, 90, 91, 76, 108, 91, 95, 90, 91, 76};
    }

    static {
        A05();
    }

    public static long A00(InterfaceC2516ms interfaceC2516ms) throws IOException {
        C09724v c09724v = new C09724v(8);
        LO chunkHeader = LO.A00(interfaceC2516ms, c09724v);
        if (chunkHeader.A00 != 1685272116) {
            interfaceC2516ms.AIl();
            return -1L;
        }
        interfaceC2516ms.A47(8);
        c09724v.A0f(0);
        interfaceC2516ms.AGt(c09724v.A0l(), 0, 8);
        long sampleDataSize = c09724v.A0N();
        interfaceC2516ms.AK3(((int) chunkHeader.A01) + 8);
        return sampleDataSize;
    }

    public static Pair<Long, Long> A01(InterfaceC2516ms interfaceC2516ms) throws IOException {
        interfaceC2516ms.AIl();
        LO loA03 = A03(1684108385, interfaceC2516ms, new C09724v(8));
        interfaceC2516ms.AK3(8);
        return Pair.create(Long.valueOf(interfaceC2516ms.A8n()), Long.valueOf(loA03.A01));
    }

    public static LO A03(int i, InterfaceC2516ms interfaceC2516ms, C09724v c09724v) throws IOException {
        LO loA00 = LO.A00(interfaceC2516ms, c09724v);
        while (loA00.A00 != i) {
            AbstractC09574g.A07(A04(91, 15, 125), A04(40, 28, 39) + loA00.A00);
            long j = loA00.A01 + 8;
            if (j <= 2147483647L) {
                interfaceC2516ms.AK3((int) j);
                loA00 = LO.A00(interfaceC2516ms, c09724v);
            } else {
                throw C3K.A00(A04(0, 40, 59) + loA00.A00);
            }
        }
        return loA00;
    }

    public static boolean A06(InterfaceC2516ms interfaceC2516ms) throws IOException {
        C09724v c09724v = new C09724v(8);
        LO loA00 = LO.A00(interfaceC2516ms, c09724v);
        if (loA00.A00 != 1380533830) {
            int i = loA00.A00;
            if (A01[1].charAt(26) == 'h') {
                throw new RuntimeException();
            }
            A01[4] = "7d3HBnqB6pKujyEoyh9Hov6";
            if (i != 1380333108) {
                return false;
            }
        }
        interfaceC2516ms.AGt(c09724v.A0l(), 0, 4);
        c09724v.A0f(0);
        int iA0C = c09724v.A0C();
        if (iA0C != 1463899717) {
            AbstractC09574g.A05(A04(91, 15, 125), A04(68, 23, 127) + iA0C);
            return false;
        }
        return true;
    }
}
