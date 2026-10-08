package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgxp extends zzgxb {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzgxo zze;
    private final zzgxn zzf;

    /* synthetic */ zzgxp(int i, int i2, int i3, int i4, zzgxo zzgxoVar, zzgxn zzgxnVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzgxoVar;
        this.zzf = zzgxnVar;
    }

    public static zzgxm zzb() {
        return new zzgxm(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgxp)) {
            return false;
        }
        zzgxp zzgxpVar = (zzgxp) obj;
        return zzgxpVar.zza == this.zza && zzgxpVar.zzb == this.zzb && zzgxpVar.zzc == this.zzc && zzgxpVar.zzd == this.zzd && zzgxpVar.zze == this.zze && zzgxpVar.zzf == this.zzf;
    }

    public final int hashCode() {
        return Objects.hash(zzgxp.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        zzgxn zzgxnVar = this.zzf;
        String strValueOf = String.valueOf(this.zze);
        String strValueOf2 = String.valueOf(zzgxnVar);
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(strValueOf2).length();
        int i = this.zzc;
        int length3 = String.valueOf(i).length();
        int i2 = this.zzd;
        int length4 = String.valueOf(i2).length();
        int i3 = this.zza;
        int length5 = String.valueOf(i3).length();
        int i4 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 2 + length3 + 14 + length4 + 16 + length5 + 19 + String.valueOf(i4).length() + 15);
        sb.append("AesCtrHmacAead Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", hashType: ");
        sb.append(strValueOf2);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte IV, and ");
        sb.append(i2);
        sb.append("-byte tags, and ");
        sb.append(i3);
        sb.append("-byte AES key, and ");
        sb.append(i4);
        sb.append("-byte HMAC key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgwj
    public final boolean zza() {
        return this.zze != zzgxo.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() {
        return this.zzd;
    }

    public final int zzf() {
        return this.zzc;
    }

    public final zzgxo zzg() {
        return this.zze;
    }

    public final zzgxn zzh() {
        return this.zzf;
    }
}
