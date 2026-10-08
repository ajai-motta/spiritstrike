package com.bytedance.sdk.component.utils;

import com.google.common.base.Ascii;
import io.ktor.util.date.GMTDateParser;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class jtx {
    private static final char[] qdl = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};

    public static String qdl(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    return qdl(messageDigest.digest());
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String qdl(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        return qdl(bArr, 0, bArr.length);
    }

    public static String qdl(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 * 2;
        char[] cArr = new char[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b = bArr[i5 + i];
            int i6 = i4 + 1;
            char[] cArr2 = qdl;
            cArr[i4] = cArr2[(b & 255) >> 4];
            i4 += 2;
            cArr[i6] = cArr2[b & Ascii.SI];
        }
        return new String(cArr, 0, i3);
    }
}
