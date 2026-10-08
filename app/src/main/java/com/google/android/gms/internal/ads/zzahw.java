package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzahw {
    public final zzadw zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzahw(zzadw zzadwVar, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = new zzadw(zzadwVar);
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzahw zza(zzadw zzadwVar, zzeg zzegVar) {
        long[] jArr;
        int i;
        int i2;
        int iZzB = zzegVar.zzB();
        int iZzH = (iZzB & 1) != 0 ? zzegVar.zzH() : -1;
        long jZzz = (iZzB & 2) != 0 ? zzegVar.zzz() : -1L;
        if ((iZzB & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr2[i3] = zzegVar.zzs();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((iZzB & 8) != 0) {
            zzegVar.zzk(4);
        }
        if (zzegVar.zzd() >= 24) {
            zzegVar.zzk(21);
            int iZzx = zzegVar.zzx();
            i2 = iZzx & 4095;
            i = iZzx >> 12;
        } else {
            i = -1;
            i2 = -1;
        }
        return new zzahw(zzadwVar, iZzH, jZzz, jArr, i, i2);
    }

    public final long zzb() {
        long j = this.zzb;
        if (j == -1 || j == 0) {
            return C.TIME_UNSET;
        }
        return zzep.zzr((j * ((long) r4.zzg)) - 1, this.zza.zzd);
    }
}
