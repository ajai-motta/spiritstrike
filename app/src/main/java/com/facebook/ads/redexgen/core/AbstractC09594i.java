package com.facebook.ads.redexgen.core;

import android.media.MediaFormat;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4i, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC09594i {
    public static byte[] A00;
    public static String[] A01 = {"xemy17oJESjX", "rPO8UlQzVoplqsv241x2vKH9ITvvG5RO", "lwnNPX4PInl", "3ZJzEwR8uVRMBQC0tqntIJ86zVyjP6", "EDwbiEJ5SEYx8yR18WYzWyNJdlpGFaeE", "Kr1YCqNPaz9XeY6", "vkRdwAWmOCKEbB6zjyqD0a8RWRR8tEwK", "9fnayNKVpPH2aeCe0iQJlqHqzIFqpYut"};

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {74, 86, 83, 86, 89, Ascii.DC4, 89, 72, 85, 78, 76, Ascii.VT, Ascii.ETB, Ascii.DC4, Ascii.ETB, Ascii.SUB, -43, Ascii.ESC, Ascii.FS, 9, Ascii.SYN, Ascii.FF, 9, Ascii.SUB, Ascii.FF, -22, -10, -13, -10, -7, -76, -5, -7, -24, -11, -6, -19, -20, -7, -29, -13, -28, -83, 85, 81, 95, Ascii.SUB, 96, 97, 78, 97, 86, 80, Ascii.SUB, 86, 91, 83, 92};
        if (A01[1].charAt(12) != 'q') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[6] = "2QjkwbE64yFQhHjtiWmGMRmbrZEFKpMO";
        strArr[0] = "Fg5M50njpCut";
        A00 = bArr;
    }

    static {
        A01();
    }

    public static void A02(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo != null) {
            A04(mediaFormat, A00(25, 14, 23), colorInfo.A03);
            A04(mediaFormat, A00(11, 14, 56), colorInfo.A02);
            A04(mediaFormat, A00(0, 11, 119), colorInfo.A01);
            A05(mediaFormat, A00(43, 15, 125), colorInfo.A04);
        }
    }

    public static void A03(MediaFormat mediaFormat, String str, float f) {
        if (f != -1.0f) {
            mediaFormat.setFloat(str, f);
        }
    }

    public static void A04(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public static void A05(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A06(android.media.MediaFormat r5, java.util.List<byte[]> r6) {
        /*
            r4 = 0
        L1:
            int r0 = r6.size()
            if (r4 >= r0) goto L31
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r2 = 39
            r1 = 4
            r0 = 16
            java.lang.String r0 = A00(r2, r1, r0)
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r1 = r0.toString()
            java.lang.Object r0 = r6.get(r4)
            byte[] r0 = (byte[]) r0
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)
            r5.setByteBuffer(r1, r0)
            int r4 = r4 + 1
            goto L1
        L31:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC09594i.A06(android.media.MediaFormat, java.util.List):void");
    }
}
