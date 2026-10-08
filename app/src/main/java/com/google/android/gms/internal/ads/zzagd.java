package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagd implements zzao {
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzagd(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    public static zzagd zzb(zzeg zzegVar) {
        int iZzB = zzegVar.zzB();
        String strZzi = zzas.zzi(zzegVar.zzK(zzegVar.zzB(), StandardCharsets.US_ASCII));
        String strZzK = zzegVar.zzK(zzegVar.zzB(), StandardCharsets.UTF_8);
        int iZzB2 = zzegVar.zzB();
        int iZzB3 = zzegVar.zzB();
        int iZzB4 = zzegVar.zzB();
        int iZzB5 = zzegVar.zzB();
        int iZzB6 = zzegVar.zzB();
        byte[] bArr = new byte[iZzB6];
        zzegVar.zzm(bArr, 0, iZzB6);
        return new zzagd(iZzB, strZzi, strZzK, iZzB2, iZzB3, iZzB4, iZzB5, bArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagd zzagdVar = (zzagd) obj;
            if (this.zza == zzagdVar.zza && this.zzb.equals(zzagdVar.zzb) && this.zzc.equals(zzagdVar.zzc) && this.zzd == zzagdVar.zzd && this.zze == zzagdVar.zze && this.zzf == zzagdVar.zzf && this.zzg == zzagdVar.zzg && Arrays.equals(this.zzh, zzagdVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.zza + 527) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String str = this.zzb;
        int length = String.valueOf(str).length();
        String str2 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 32 + str2.length());
        sb.append("Picture: mimeType=");
        sb.append(str);
        sb.append(", description=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final void zza(zzam zzamVar) {
        zzamVar.zzf(this.zzh, this.zza);
    }
}
