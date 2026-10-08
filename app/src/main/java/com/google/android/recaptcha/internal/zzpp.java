package com.google.android.recaptcha.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzpp {
    private static final zzpp zza = new zzpm("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final zzpp zzb = new zzpm("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    static {
        new zzpo("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new zzpo("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        int i = zzpl.zza;
        zzpk zzpkVar = new zzpk("base16()", "0123456789ABCDEF".toCharArray());
        new zzpo(zzpkVar, null);
        char[] cArr = new char[512];
        zzmd.zza(zzpkVar.zzf.length == 16);
        for (int i2 = 0; i2 < 256; i2++) {
            cArr[i2] = zzpkVar.zza(i2 >>> 4);
            cArr[i2 | 256] = zzpkVar.zza(i2 & 15);
        }
    }

    zzpp() {
    }

    public static zzpp zzg() {
        return zza;
    }

    public static zzpp zzh() {
        return zzb;
    }

    abstract int zza(byte[] bArr, CharSequence charSequence) throws zzpn;

    abstract void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    abstract int zzc(int i);

    abstract int zzd(int i);

    CharSequence zze(CharSequence charSequence) {
        throw null;
    }

    public final String zzi(byte[] bArr, int i, int i2) {
        zzmd.zzd(0, i2, bArr.length);
        StringBuilder sb = new StringBuilder(zzd(i2));
        try {
            zzb(sb, bArr, 0, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final byte[] zzj(CharSequence charSequence) {
        try {
            CharSequence charSequenceZze = zze(charSequence);
            int iZzc = zzc(charSequenceZze.length());
            byte[] bArr = new byte[iZzc];
            int iZza = zza(bArr, charSequenceZze);
            if (iZza == iZzc) {
                return bArr;
            }
            byte[] bArr2 = new byte[iZza];
            System.arraycopy(bArr, 0, bArr2, 0, iZza);
            return bArr2;
        } catch (zzpn e) {
            throw new IllegalArgumentException(e);
        }
    }
}
