package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzgrz {
    private static final zzgrz zza = new zzgrw("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzgrz zzb = new zzgrw("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final zzgrz zzc;

    static {
        new zzgry("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new zzgry("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        zzc = new zzgrv("base16()", "0123456789ABCDEF");
    }

    zzgrz() {
    }

    public static zzgrz zzl() {
        return zza;
    }

    public static zzgrz zzm() {
        return zzb;
    }

    public static zzgrz zzn() {
        return zzc;
    }

    abstract void zza(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    abstract int zzb(byte[] bArr, CharSequence charSequence) throws zzgrx;

    abstract int zzd(int i);

    abstract int zzf(int i);

    CharSequence zzg(CharSequence charSequence) {
        throw null;
    }

    public abstract zzgrz zzh();

    public abstract zzgrz zzi();

    public final String zzj(byte[] bArr, int i, int i2) {
        zzgmd.zzo(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zzd(i2));
        try {
            zza(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] zzk(CharSequence charSequence) {
        try {
            CharSequence charSequenceZzg = zzg(charSequence);
            int iZzf = zzf(charSequenceZzg.length());
            byte[] bArr = new byte[iZzf];
            int iZzb = zzb(bArr, charSequenceZzg);
            if (iZzb == iZzf) {
                return bArr;
            }
            byte[] bArr2 = new byte[iZzb];
            System.arraycopy(bArr, 0, bArr2, 0, iZzb);
            return bArr2;
        } catch (zzgrx e) {
            throw new IllegalArgumentException(e);
        }
    }
}
