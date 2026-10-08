package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzpc {
    private static final char[] zza = "0123456789abcdef".toCharArray();
    public static final /* synthetic */ int zzb = 0;

    zzpc() {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzpc) {
            zzpc zzpcVar = (zzpc) obj;
            if (zzb() == zzpcVar.zzb() && zzc(zzpcVar)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (zzb() >= 32) {
            return zza();
        }
        byte[] bArrZze = zze();
        int i = bArrZze[0] & 255;
        for (int i2 = 1; i2 < bArrZze.length; i2++) {
            i |= (bArrZze[i2] & 255) << (i2 * 8);
        }
        return i;
    }

    public final String toString() {
        byte[] bArrZze = zze();
        int length = bArrZze.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b : bArrZze) {
            char[] cArr = zza;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & Ascii.SI]);
        }
        return sb.toString();
    }

    public abstract int zza();

    public abstract int zzb();

    abstract boolean zzc(zzpc zzpcVar);

    public abstract byte[] zzd();

    byte[] zze() {
        throw null;
    }
}
