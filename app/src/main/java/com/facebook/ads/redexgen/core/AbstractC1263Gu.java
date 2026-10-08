package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.common.primitives.SignedBytes;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gu, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1263Gu {
    public static byte[] A00;
    public static String[] A01 = {"xbfghvjfzJvhku5N8OELiq204nVuVPFf", "QHdNkhaNqF6P8ZoHbM5E7ac9pSEOFT0I", "gTrjGkh7SJSYjcOCOWWCub6Uckq9Yltj", "B1r", "bt5fTN19iCcMkB3LBJCDNqZ6iO4ZjItL", "3vLSrbB7SQdOWYeFWsx", "mXdQOoT87saNovPMynKxKkWZ", "FMZbalTyTizDclIiFtsmYNu0onhdvCq9"};
    public static final int[] A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.C1262Gt A04(com.facebook.ads.redexgen.core.C09714u r12) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1263Gu.A04(com.facebook.ads.redexgen.X.4u):com.facebook.ads.redexgen.X.Gt");
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A01[7].charAt(26) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[2] = "ZZS15YLfqnGzRKQmbGGBAS62S7daT6Pr";
            strArr[0] = "wbQ3s0ZhLtikxP7PtpYOpvXFjSSpaatC";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A00 = new byte[]{-121, -101, -118, -113, -107, 85, -121, -119, 90};
    }

    static {
        A06();
        A02 = new int[]{2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};
    }

    public static int A00(C09714u c09714u, int i) {
        int i2 = 0;
        while (true) {
            int value = c09714u.A04(i);
            int i3 = i2 + value;
            if (!c09714u.A0H()) {
                return i3;
            }
            i2 = (i3 + 1) << i;
        }
    }

    public static int A01(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return A04(new C09714u(bArr)).A03;
    }

    public static int A02(byte[] bArr, int i) {
        if (bArr.length < 7) {
            return -1;
        }
        int headerSize = bArr[2];
        int i2 = (headerSize & 255) << 8;
        int headerSize2 = bArr[3];
        int i3 = i2 | (headerSize2 & 255);
        int frameSize = 2 + 2;
        if (i3 == 65535) {
            int headerSize3 = bArr[4];
            int i4 = (headerSize3 & 255) << 16;
            int headerSize4 = bArr[5];
            int i5 = i4 | ((headerSize4 & 255) << 8);
            int headerSize5 = bArr[6];
            i3 = i5 | (headerSize5 & 255);
            frameSize += 3;
        }
        if (i == 44097) {
            frameSize += 2;
        }
        int i6 = i3 + frameSize;
        String[] strArr = A01;
        String str = strArr[1];
        String str2 = strArr[4];
        int iCharAt = str.charAt(27);
        int headerSize6 = str2.charAt(27);
        if (iCharAt == headerSize6) {
            throw new RuntimeException();
        }
        A01[7] = "5dLepgbvmcODZNjBgadRz1gh8sb0vEN9";
        return i6;
    }

    public static C2725qI A03(C09724v c09724v, String str, String str2, DrmInitData drmInitData) {
        c09724v.A0g(1);
        return new C09162p().A0y(str).A11(A05(0, 9, 31)).A0b(2).A0m(((c09724v.A0I() & 32) >> 5) == 1 ? OpusUtil.SAMPLE_RATE : 44100).A0u(drmInitData).A10(str2).A14();
    }

    public static void A07(int i, C09724v c09724v) {
        c09724v.A0d(7);
        byte[] bArrA0l = c09724v.A0l();
        bArrA0l[0] = -84;
        bArrA0l[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrA0l[2] = -1;
        bArrA0l[3] = -1;
        bArrA0l[4] = (byte) ((i >> 16) & 255);
        bArrA0l[5] = (byte) ((i >> 8) & 255);
        bArrA0l[6] = (byte) (i & 255);
    }
}
