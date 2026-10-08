package com.facebook.ads.redexgen.core;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class HK {
    public static byte[] A02;
    public static final Pattern A03;
    public int A00 = -1;
    public int A01 = -1;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{SignedBytes.MAX_POWER_OF_TWO, 62, 69, 46, 51, 39, 127, 51, 120, 95, 51, 88, 67, 101, 38, 99, 62, 54, 69, 46, 51, 39, 127, 51, 120, 95, 51, 88, 67, 101, 38, 99, 55, 62, 54, 69, 46, 51, 39, 127, 51, 120, 95, 51, 88, 67, 101, 38, 99, 55, 40, 36, 38, 101, 42, 59, 59, 39, 46, 101, 34, Ascii.US, 62, 37, 46, 56, 86, 107, 74, 81, 108, 114, 111, 125};
    }

    static {
        A01();
        A03 = Pattern.compile(A00(0, 50, 25));
    }

    private boolean A02(String str) {
        Matcher matcher = A03.matcher(str);
        if (matcher.find()) {
            try {
                int i = Integer.parseInt((String) C5C.A0f(matcher.group(1)), 16);
                int i2 = Integer.parseInt((String) C5C.A0f(matcher.group(2)), 16);
                if (i > 0 || i2 > 0) {
                    this.A00 = i;
                    this.A01 = i2;
                    return true;
                }
                return false;
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return false;
    }

    public final boolean A03() {
        return (this.A00 == -1 || this.A01 == -1) ? false : true;
    }

    public final boolean A04(int i) {
        int encoderPadding = i >> 12;
        int encoderDelay = i & 4095;
        if (encoderPadding > 0 || encoderDelay > 0) {
            this.A00 = encoderPadding;
            this.A01 = encoderDelay;
            return true;
        }
        return false;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A05(com.facebook.ads.androidx.media3.common.Metadata r9) {
        /*
            r8 = this;
            r3 = 0
        L1:
            int r0 = r9.A02()
            if (r3 >= r0) goto L59
            com.facebook.ads.androidx.media3.common.Metadata$Entry r5 = r9.A03(r3)
            boolean r7 = r5 instanceof com.facebook.ads.androidx.media3.extractor.metadata.id3.CommentFrame
            r2 = 66
            r1 = 8
            r0 = 56
            java.lang.String r6 = A00(r2, r1, r0)
            r4 = 1
            if (r7 == 0) goto L2d
            com.facebook.ads.androidx.media3.extractor.metadata.id3.CommentFrame r5 = (com.facebook.ads.androidx.media3.extractor.metadata.id3.CommentFrame) r5
            java.lang.String r0 = r5.A00
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L56
            java.lang.String r0 = r5.A02
            boolean r0 = r8.A02(r0)
            if (r0 == 0) goto L56
            return r4
        L2d:
            boolean r0 = r5 instanceof com.facebook.ads.androidx.media3.extractor.metadata.id3.InternalFrame
            if (r0 == 0) goto L56
            com.facebook.ads.androidx.media3.extractor.metadata.id3.InternalFrame r5 = (com.facebook.ads.androidx.media3.extractor.metadata.id3.InternalFrame) r5
            r2 = 50
            r1 = 16
            r0 = 76
            java.lang.String r1 = A00(r2, r1, r0)
            java.lang.String r0 = r5.A01
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L56
            java.lang.String r0 = r5.A00
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L56
            java.lang.String r0 = r5.A02
            boolean r0 = r8.A02(r0)
            if (r0 == 0) goto L56
            return r4
        L56:
            int r3 = r3 + 1
            goto L1
        L59:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.HK.A05(com.facebook.ads.androidx.media3.common.Metadata):boolean");
    }
}
