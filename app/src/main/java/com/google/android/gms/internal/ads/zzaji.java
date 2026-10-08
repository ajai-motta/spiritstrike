package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaji {
    public final zzajf zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final long zzh;

    public zzaji(zzajf zzajfVar, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j, int i2) {
        int length = iArr.length;
        int length2 = jArr2.length;
        zzgmd.zza(length == length2);
        zzgmd.zza(jArr.length == length2);
        int length3 = iArr2.length;
        zzgmd.zza(length3 == length2);
        this.zza = zzajfVar;
        this.zzc = jArr;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = jArr2;
        this.zzg = iArr2;
        this.zzh = j;
        this.zzb = i2;
        if (length3 > 0) {
            int i3 = length3 - 1;
            iArr2[i3] = iArr2[i3] | 536870912;
        }
    }

    public final int zza(long j) {
        for (int iZzm = zzep.zzm(this.zzf, j, true, false); iZzm >= 0; iZzm--) {
            if ((this.zzg[iZzm] & 1) != 0) {
                return iZzm;
            }
        }
        return -1;
    }

    public final int zzb(long j) {
        long[] jArr = this.zzf;
        for (int iZzo = zzep.zzo(jArr, j, true, false); iZzo < jArr.length; iZzo++) {
            if ((this.zzg[iZzo] & 1) != 0) {
                return iZzo;
            }
        }
        return -1;
    }
}
