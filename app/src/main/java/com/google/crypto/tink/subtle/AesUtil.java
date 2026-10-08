package com.google.crypto.tink.subtle;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
class AesUtil {
    public static final int BLOCK_SIZE = 16;

    AesUtil() {
    }

    static byte[] dbl(final byte[] value) {
        if (value.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            byte b = (byte) ((value[i] << 1) & 254);
            bArr[i] = b;
            if (i < 15) {
                bArr[i] = (byte) (((byte) ((value[i + 1] >> 7) & 1)) | b);
            }
        }
        bArr[15] = (byte) (((byte) ((value[0] >> 7) & TsExtractor.TS_STREAM_TYPE_E_AC3)) ^ bArr[15]);
        return bArr;
    }

    static byte[] cmacPad(final byte[] x) {
        if (x.length >= 16) {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        byte[] bArrCopyOf = Arrays.copyOf(x, 16);
        bArrCopyOf[x.length] = -128;
        return bArrCopyOf;
    }
}
