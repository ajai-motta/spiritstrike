package com.facebook.ads.redexgen.core;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.o8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2592o8 implements BY {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{Ascii.CR, Ascii.ESC, Ascii.GS, Ascii.VT, Ascii.FF, Ascii.ESC, 83, Ascii.SO, Ascii.DC2, Ascii.US, 7, Ascii.FS, Ascii.US, Ascii.GS, Ascii.NAK, 10, Ascii.NAK, Ascii.CAN, Ascii.EM, 19, 83, Ascii.GS, 10, Ascii.US};
    }

    public C2592o8() {
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final int A7P() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final MediaCodecInfo A7Q(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final boolean AAR(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final boolean AAS(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return A00(0, 15, 117).equals(str) && A00(15, 9, 119).equals(str2);
    }

    @Override // com.facebook.ads.redexgen.core.BY
    public final boolean AJ4() {
        return false;
    }
}
