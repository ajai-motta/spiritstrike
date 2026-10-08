package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgyg extends zzgxb {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzgyf zzd;

    /* synthetic */ zzgyg(int i, int i2, int i3, zzgyf zzgyfVar, byte[] bArr) {
        this.zza = i;
        this.zzd = zzgyfVar;
    }

    public static zzgye zzb() {
        return new zzgye(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgyg)) {
            return false;
        }
        zzgyg zzgygVar = (zzgyg) obj;
        if (zzgygVar.zza == this.zza) {
            int i = zzgygVar.zzb;
            int i2 = zzgygVar.zzc;
            if (zzgygVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzgyg.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(12).length();
        int length3 = String.valueOf(16).length();
        int i = this.zza;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 10 + length3 + 15 + String.valueOf(i).length() + 10);
        sb.append("AesGcm Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", 12-byte IV, 16-byte tag, and ");
        sb.append(i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zzd != zzgyf.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgyf zzd() {
        return this.zzd;
    }
}
