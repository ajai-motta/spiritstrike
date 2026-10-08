package com.google.android.gms.internal.fido;

import com.google.android.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@21.0.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhc {
    static final Charset zza = Charset.forName(C.ASCII_NAME);
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName(C.ISO88591_NAME);
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzhb zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i = zzhb.zza;
        zzgz zzgzVar = new zzgz(bArr, 0, 0, false, null);
        try {
            zzgzVar.zza(0);
            zzf = zzgzVar;
        } catch (zzhd e) {
            throw new IllegalArgumentException(e);
        }
    }
}
