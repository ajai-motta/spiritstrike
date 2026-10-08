package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhrl {
    private static final Charset zza = Charset.forName("UTF-8");

    public static byte[] zza(String str, int i) {
        byte[] bytes = str.getBytes(zza);
        int length = bytes.length;
        zzhrk zzhrkVar = new zzhrk(2, new byte[(length * 3) / 4]);
        if (!zzhrkVar.zza(bytes, 0, length, true)) {
            throw new IllegalArgumentException("bad base-64");
        }
        int i2 = zzhrkVar.zzb;
        byte[] bArr = zzhrkVar.zza;
        if (i2 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }
}
