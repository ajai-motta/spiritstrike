package com.facebook.ads.redexgen.core;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.ads.androidx.media3.common.ColorInfo;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class B3 {
    public static byte[] A0B;
    public static String[] A0C = {"I9JaO4heFf5nDgSUvVeAxAeOAdbY1nhs", "PVSEhsxK0zpzpXeziFZITHKDYbLYMlXw", "qlK6yxEC", "9zKWhcki2UyQZLYGzaAyWcMw08QqvpbN", "JlMwKIWIzkUyHhMRK", "e8OveLjqyhc2hkEtyY01o7K", "DY1oAH7PrQgT6IVPSHYZAZf9F8l8uJ13", "bCAM9BCoFLqZyqtmC8leb"};
    public final MediaCodecInfo.CodecCapabilities A00;
    public final String A01;
    public final String A02;
    public final String A03;
    public final boolean A04;
    public final boolean A05;
    public final boolean A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 26);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0B = new byte[]{73, Ascii.GS, 6, 73, Ascii.GS, 17, 65, 77, 54, 46, 48, 2, 2, 4, Ascii.FS, Ascii.DC4, Ascii.NAK, 60, Ascii.DLE, 9, 50, Ascii.EM, Ascii.DLE, Ascii.US, Ascii.US, Ascii.DC4, Ascii.GS, 48, Ascii.NAK, Ascii.ESC, 4, 2, 5, Ascii.FS, Ascii.DC4, Ascii.US, 5, 75, 81, Ascii.SO, 60, 60, 58, 34, 42, 43, Ascii.FS, 58, 63, 63, 32, Base64.padSymbol, 59, 111, Ascii.DC4, 19, 58, 49, 48, 41, 48, 127, Ascii.VT, Ascii.GS, 114, 7, 105, 111, 106, 98, 75, SignedBytes.MAX_POWER_OF_TWO, 65, 88, 65, Ascii.SO, 122, 108, 3, 118, Ascii.CAN, Ascii.RS, Ascii.CAN, 86, 127, 116, 117, 108, 117, 58, 78, 88, 55, 66, 44, 43, 44, 52, Ascii.FS, Ascii.GS, Ascii.DLE, Ascii.CAN, 58, Ascii.SYN, Ascii.GS, Ascii.FS, Ascii.SUB, 48, Ascii.ETB, Ascii.US, Ascii.SYN, Ascii.FS, 55, 42, 39, 33, 114, 99, 98, 126, 95, 99, 69, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 95, 66, 68, Ascii.DLE, 107, Ascii.VT, 0, Ascii.SYN, Ascii.VT, Ascii.CR, 0, 105, Ascii.FS, 17, 119, 32, 34, 55, 65, 42, Ascii.ETB, Ascii.SYN, 1, 0, Ascii.FS, 65, 46, 57, 44, 65, 43, 10, Ascii.FF, 0, Ascii.VT, 10, Ascii.GS, Ascii.US, Ascii.GS, 8, 126, Ascii.NAK, 40, 41, 62, 63, 35, 126, 17, 6, 19, 126, Ascii.DC4, 53, 51, 63, 52, 53, 34, 126, 35, 53, 51, 37, 34, 53, 84, 86, 67, 53, 86, 90, 73, 77, 94, 87, 87, 53, 77, 82, 95, 94, 84, 53, 83, 76, 53, 88, 84, 95, 90, 44, 46, 47, 41, 95, 94, 88, 84, 95, 94, 73, Ascii.VT, 9, Ascii.FS, 106, 9, Ascii.DLE, Ascii.SI, 106, Ascii.DC2, Ascii.CR, 0, 1, Ascii.VT, 106, 0, 1, 7, Ascii.VT, 0, 1, Ascii.SYN, 106, Ascii.FF, 1, Ascii.DC2, 7, Ascii.DLE, Ascii.SO, 110, Ascii.ETB, 113, 112, 115, Ascii.SI, 102, Ascii.ESC, 96, 90, 95, 90, 75, 79, 82, 77, 94, Ascii.SYN, 75, 87, 90, 66, 89, 90, 88, 80, Ascii.GS, 9, Ascii.CAN, Ascii.NAK, 19, 83, 79, Ascii.ESC, Ascii.FF, Ascii.FF, 74, 94, 79, 66, 68, 4, 74, 72, Ascii.CAN, 110, 122, 107, 102, 96, 32, 110, 98, 125, 34, 120, 109, 44, 56, 41, 36, 34, 98, 40, 44, 46, 126, 7, 19, 2, Ascii.SI, 9, 73, 0, 10, 7, 5, 127, 107, 122, 119, 113, 49, 121, 41, 47, 47, 51, 127, 114, 127, 105, 42, 62, 47, 34, 36, 100, 44, 124, 122, 122, 102, 38, 39, 42, 60, Ascii.CAN, Ascii.FF, Ascii.GS, Ascii.DLE, Ascii.SYN, 86, Ascii.RS, 10, Ascii.DC4, 78, 90, 75, 70, SignedBytes.MAX_POWER_OF_TWO, 0, 66, 95, Ascii.ESC, 78, 2, 67, 78, 91, 66, 85, 65, 80, 93, 91, Ascii.ESC, 89, 68, 81, 83, 79, 91, 74, 71, 65, 1, 65, 94, 91, 93, 84, SignedBytes.MAX_POWER_OF_TWO, 81, 92, 90, Ascii.SUB, 71, 84, 66, 111, 123, 106, 103, 97, 33, 120, 97, 124, 108, 103, 125, 126, 115, 110, 121, 125, 112, 5, Ascii.SO, 7, 8, 8, 3, 10, 37, 9, 19, 8, Ascii.DC2, 72, 7, 37, 7, Ascii.SYN, Ascii.NAK, 66, 73, SignedBytes.MAX_POWER_OF_TWO, 79, 79, 68, 77, 98, 78, 84, 79, 85, Ascii.SI, 66, SignedBytes.MAX_POWER_OF_TWO, 81, 82, 55, 60, 53, 58, 58, 49, 56, Ascii.ETB, 59, 33, 58, 32, 122, 39, 33, 36, 36, 59, 38, 32, 120, 116, 53, 57, 50, 51, 53, 120, 59, 63, 59, 51, 118, 107, 103, 108, 109, 107, 38, 120, 122, 103, 110, 97, 100, 109, 68, 109, 126, 109, 100, 36, 40, 126, 114, 97, 127, 122, 125, 36, 42, 63, 124, 40, 87, 69, 70, 86, 77, 74, 69, 77, 95, 87, 82, 88, 87, 77, 86, 49, 35, 47, 50, 46, 39, Ascii.DLE, 35, 54, 39, 108, 35, 1, 35, 50, 49, 109, 127, 115, 110, 114, 123, 76, 127, 106, 123, 48, 125, 127, 110, 109, 2, Ascii.DLE, Ascii.FS, 1, Ascii.GS, Ascii.DC4, 35, Ascii.DLE, 5, Ascii.DC4, 95, 2, 4, 1, 1, Ascii.RS, 3, 5, 93, 81, 1, Ascii.ETB, 17, 7, 0, Ascii.ETB, 95, 2, Ascii.RS, 19, Ascii.VT, Ascii.DLE, 19, 17, Ascii.EM, 102, 124, 111, 112, 84, 123, 113, 71, 116, 97, 112, 59, 118, 116, 101, 102, SignedBytes.MAX_POWER_OF_TWO, 90, 73, 86, 114, 93, 87, 97, 82, 71, 86, Ascii.GS, 80, 92, 69, 86, 65, Ascii.US, 19, 108, 118, 101, 122, 94, 113, 123, 77, 126, 107, 122, 49, 109, 112, 107, 126, 107, 122, 123, 51, 63, Ascii.CAN, 2, 17, Ascii.SO, 42, 5, Ascii.SI, 57, 10, Ascii.US, Ascii.SO, 69, Ascii.CAN, Ascii.RS, Ascii.ESC, Ascii.ESC, 4, Ascii.EM, Ascii.US, 71, 75, 100, 126, 109, 114, 86, 121, 115, 69, 118, 99, 114, 57, 97, 84, 118, 103, 100, 4, 5, Ascii.RS, Ascii.RS, Ascii.NAK, Ascii.FS, Ascii.NAK, Ascii.DC4, 93, 0, Ascii.FS, 17, 9, Ascii.DC2, 17, 19, Ascii.ESC, 48, 47, 34, 35, 41, 105, 39, 48, 37, 114, 109, 96, 97, 107, 43, 96, 107, 104, 102, 125, 41, 114, 109, 119, 109, 107, 106, Ascii.NAK, 10, 7, 6, Ascii.FF, 76, Ascii.VT, 6, Ascii.NAK, 0, 82, 77, SignedBytes.MAX_POWER_OF_TWO, 65, 75, Ascii.VT, 92, 9, 82, 74, SignedBytes.MAX_POWER_OF_TWO, 10, 75, 74, Ascii.SYN, 10, 82, 84, Ascii.GS, 92};
    }

    static {
        A04();
    }

    public B3(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.A03 = (String) AbstractC09493y.A01(str);
        this.A02 = str2;
        this.A01 = str3;
        this.A00 = codecCapabilities;
        this.A05 = z;
        this.A07 = z2;
        this.A09 = z3;
        this.A04 = z4;
        this.A08 = z5;
        this.A06 = z6;
        this.A0A = C3J.A0F(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A00(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.B3.A00(java.lang.String, java.lang.String, int):int");
    }

    public static Point A01(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int heightAlignment = videoCapabilities.getWidthAlignment();
        int widthAlignment = videoCapabilities.getHeightAlignment();
        return new Point(C5C.A05(i, heightAlignment) * heightAlignment, C5C.A05(i2, widthAlignment) * widthAlignment);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.core.B3 A02(java.lang.String r14, java.lang.String r15, java.lang.String r16, android.media.MediaCodecInfo.CodecCapabilities r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22) {
        /*
            com.facebook.ads.redexgen.X.B3 r4 = new com.facebook.ads.redexgen.X.B3
            r8 = r17
            r5 = r14
            if (r21 != 0) goto L20
            if (r8 == 0) goto L20
            boolean r3 = A09(r8)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.B3.A0C
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 8
            if (r1 == r0) goto L22
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L20:
            r12 = 0
            goto L32
        L22:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.B3.A0C
            java.lang.String r1 = "xqlBNWNY"
            r0 = 2
            r2[r0] = r1
            if (r3 == 0) goto L20
            boolean r0 = A0J(r5)
            if (r0 != 0) goto L20
            r12 = 1
        L32:
            if (r8 == 0) goto L55
            boolean r0 = A0D(r8)
            if (r0 == 0) goto L55
            r13 = 1
        L3b:
            if (r22 != 0) goto L45
            if (r8 == 0) goto L53
            boolean r0 = A0B(r8)
            if (r0 == 0) goto L53
        L45:
            r14 = 1
        L46:
            r11 = r20
            r10 = r19
            r9 = r18
            r7 = r16
            r6 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r4
        L53:
            r14 = 0
            goto L46
        L55:
            r13 = 0
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.B3.A02(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):com.facebook.ads.redexgen.X.B3");
    }

    private void A05(String str) {
        StringBuilder sbAppend = new StringBuilder().append(A03(39, 16, 85)).append(str);
        String strA03 = A03(261, 3, 33);
        AbstractC09574g.A04(A03(97, 14, 99), sbAppend.append(strA03).append(this.A03).append(A03(4, 2, 43)).append(this.A02).append(strA03).append(C5C.A04).append(A03(260, 1, 72)).toString());
    }

    private void A06(String str) {
        StringBuilder sbAppend = new StringBuilder().append(A03(119, 11, 42)).append(str);
        String strA03 = A03(261, 3, 33);
        AbstractC09574g.A04(A03(97, 14, 99), sbAppend.append(strA03).append(this.A03).append(A03(4, 2, 43)).append(this.A02).append(strA03).append(C5C.A04).append(A03(260, 1, 72)).toString());
    }

    public static boolean A07() {
        return C5C.A03.equals(A03(532, 7, 62)) || C5C.A03.equals(A03(427, 6, 6)) || C5C.A06.startsWith(A03(55, 14, 69)) || C5C.A06.startsWith(A03(69, 14, 52)) || C5C.A06.startsWith(A03(83, 14, 0));
    }

    public static boolean A09(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C5C.A02 >= 19 && A0A(codecCapabilities);
    }

    public static boolean A0A(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(264, 17, 33));
    }

    public static boolean A0B(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C5C.A02 >= 21 && A0C(codecCapabilities);
    }

    public static boolean A0C(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(598, 15, 104));
    }

    public static boolean A0D(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return C5C.A02 >= 21 && A0E(codecCapabilities);
    }

    public static boolean A0E(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(A03(TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 17, 106));
    }

    public static boolean A0F(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point alignedSize = A01(videoCapabilities, i, i2);
        int i3 = alignedSize.x;
        int i4 = alignedSize.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        return videoCapabilities.areSizeAndRateSupported(i3, i4, Math.floor(d));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009b  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "D46258033: [FBLite][Video] Solve tasks T154141530 T154151746 gating the call for SDK >=21")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A0G(com.facebook.ads.redexgen.core.C2725qI r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.B3.A0G(com.facebook.ads.redexgen.X.qI, boolean):boolean");
    }

    public static boolean A0H(String str) {
        return A03(396, 10, 52).equals(str);
    }

    public static boolean A0I(String str) {
        return C5C.A06.startsWith(A03(253, 7, 89)) && A03(191, 36, 1).equals(str);
    }

    public static boolean A0J(String str) {
        if (C5C.A02 <= 22) {
            if ((A03(TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 10, 94).equals(C5C.A06) || A03(111, 8, 72).equals(C5C.A06)) && (A03(140, 22, 117).equals(str) || A03(162, 29, 74).equals(str))) {
                return true;
            }
        }
        return false;
    }

    public static boolean A0K(String str) {
        if (A03(227, 26, 94).equals(str) && A03(527, 5, 83).equals(C5C.A03)) {
            return false;
        }
        return true;
    }

    public static boolean A0L(String str, int i) {
        if (A03(751, 10, 121).equals(str) && 2 == i) {
            if (A03(539, 8, 36).equals(C5C.A03) || A03(521, 6, 9).equals(C5C.A03)) {
                return true;
            }
        }
        return false;
    }

    public static MediaCodecInfo.CodecProfileLevel[] A0M(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int level;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int iIntValue = 0;
        if (codecCapabilities != null && (videoCapabilities = codecCapabilities.getVideoCapabilities()) != null) {
            Integer num = (Integer) videoCapabilities.getBitrateRange().getUpper();
            if (A0C[0].charAt(21) != 'A') {
                throw new RuntimeException();
            }
            A0C[0] = "QcEMGW7v0Yxqh7XLcQ4xIAQDDerowqhX";
            iIntValue = num.intValue();
        }
        if (iIntValue >= 180000000) {
            level = 1024;
        } else if (iIntValue >= 120000000) {
            level = 512;
        } else if (iIntValue >= 60000000) {
            level = 256;
        } else if (iIntValue >= 30000000) {
            level = 128;
        } else if (iIntValue >= 18000000) {
            level = 64;
        } else {
            if (A0C[0].charAt(21) != 'A') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[7] = "cnj1P9QIvdvvlmM3jq4NJ";
            strArr[5] = "0LKKsHUxH9Ew65kXLPhVQ5r";
            if (iIntValue >= 12000000) {
                level = 32;
            } else if (iIntValue >= 7200000) {
                level = 16;
            } else if (iIntValue >= 3600000) {
                level = 8;
            } else if (iIntValue >= 1800000) {
                level = 4;
            } else if (iIntValue >= 800000) {
                level = 2;
            } else {
                level = 1;
            }
        }
        MediaCodecInfo.CodecProfileLevel profileLevel = new MediaCodecInfo.CodecProfileLevel();
        profileLevel.profile = 1;
        profileLevel.level = level;
        return new MediaCodecInfo.CodecProfileLevel[]{profileLevel};
    }

    public final Point A0N(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (this.A00 == null || (videoCapabilities = this.A00.getVideoCapabilities()) == null) {
            return null;
        }
        return A01(videoCapabilities, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.core.C6L A0O(com.facebook.ads.redexgen.core.C2725qI r13, com.facebook.ads.redexgen.core.C2725qI r14) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.B3.A0O(com.facebook.ads.redexgen.X.qI, com.facebook.ads.redexgen.X.qI):com.facebook.ads.redexgen.X.6L");
    }

    public final boolean A0P(int i) {
        if (this.A00 == null) {
            A06(A03(451, 17, 59));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.A00.getAudioCapabilities();
        if (audioCapabilities == null) {
            A06(A03(433, 18, 124));
            return false;
        }
        if (A00(this.A03, this.A02, audioCapabilities.getMaxInputChannelCount()) < i) {
            A06(A03(468, 22, 78) + i);
            return false;
        }
        return true;
    }

    public final boolean A0Q(int i) {
        if (this.A00 == null) {
            A06(A03(563, 15, 4));
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.A00.getAudioCapabilities();
        if (audioCapabilities == null) {
            A06(A03(547, 16, 88));
            return false;
        }
        if (!audioCapabilities.isSampleRateSupported(i)) {
            A06(A03(578, 20, 107) + i);
            return false;
        }
        return true;
    }

    public final boolean A0R(int i, int i2, double d) {
        if (this.A00 == null) {
            if (A0C[4].length() != 17) {
                throw new RuntimeException();
            }
            A0C[1] = "VtsIfpRARdWM2RcSD8UT7BsOJP98i2Mb";
            A06(A03(613, 16, 15));
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = this.A00.getVideoCapabilities();
        if (videoCapabilities == null) {
            A06(A03(690, 17, 13));
            return false;
        }
        int i3 = C5C.A02;
        String strA03 = A03(9, 1, 116);
        String strA032 = A03(780, 1, 62);
        if (i3 >= 29) {
            int iA00 = B1.A00(videoCapabilities, i, i2, d);
            if (iA00 == 2) {
                return true;
            }
            if (iA00 == 1) {
                A06(A03(629, 19, 41) + i + strA032 + i2 + strA03 + d);
                return false;
            }
        }
        if (!A0F(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !A0K(this.A03) || !A0F(videoCapabilities, i2, i, d)) {
                A06(A03(669, 21, 113) + i + strA032 + i2 + strA03 + d);
                return false;
            }
            A05(A03(648, 21, 5) + i + strA032 + i2 + strA03 + d);
        }
        return true;
    }

    @MetaExoPlayerCustomization(type = {"DEPRECATED_LOGIC"}, value = "D51676338: Control Renderer Support behavior")
    public final boolean A0S(C2725qI c2725qI) {
        String strA07;
        if (c2725qI.A0R == null || this.A02 == null || (strA07 = C3J.A07(c2725qI.A0R)) == null) {
            return true;
        }
        String codecMimeType = this.A02;
        if (!codecMimeType.equals(strA07)) {
            StringBuilder sb = new StringBuilder();
            String codecMimeType2 = A03(490, 11, 76);
            StringBuilder sbAppend = sb.append(codecMimeType2);
            String codecMimeType3 = c2725qI.A0R;
            StringBuilder sbAppend2 = sbAppend.append(codecMimeType3);
            String codecMimeType4 = A03(4, 2, 43);
            A06(sbAppend2.append(codecMimeType4).append(strA07).toString());
            return false;
        }
        return A0G(c2725qI, true);
    }

    public final boolean A0T(C2725qI c2725qI) {
        if (this.A0A) {
            boolean z = this.A04;
            if (A0C[1].charAt(21) == 'k') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[7] = "p6ujkjtFWGTlktsjRzxuv";
            strArr[5] = "iao6hIdGkkUEjHJmkTON0Ul";
            return z;
        }
        Pair<Integer, Integer> profileLevel = C1117Ba.A0B(c2725qI);
        return profileLevel != null && ((Integer) profileLevel.first).intValue() == 42;
    }

    @Deprecated
    public final boolean A0U(C2725qI c2725qI, C2725qI c2725qI2, boolean z) {
        if (!z && c2725qI.A0N != null) {
            ColorInfo colorInfo = c2725qI2.A0N;
            String[] strArr = A0C;
            if (strArr[7].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A0C[2] = "CiueF8sE";
            if (colorInfo == null) {
                c2725qI2 = c2725qI2.A07().A0t(c2725qI.A0N).A14();
            }
        }
        int i = A0O(c2725qI, c2725qI2).A01;
        return i == 2 || i == 3;
    }

    public final MediaCodecInfo.CodecProfileLevel[] A0V() {
        if (this.A00 == null || this.A00.profileLevels == null) {
            return new MediaCodecInfo.CodecProfileLevel[0];
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.A00;
        if (A0C[2].length() != 8) {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[7] = "wYBsKMorArWFj72U1vIrO";
        strArr[5] = "2GYgXVRgmEsc3DaR9LQ86J2";
        return codecCapabilities.profileLevels;
    }

    public final String toString() {
        return this.A03;
    }
}
