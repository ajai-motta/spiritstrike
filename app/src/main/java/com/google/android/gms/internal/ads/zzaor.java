package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaor implements zzaed {
    private final zzaoo zza;
    private final int zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;

    public zzaor(zzaoo zzaooVar, int i, long j, long j2) {
        this.zza = zzaooVar;
        this.zzb = i;
        this.zzc = j;
        long j3 = (j2 - j) / ((long) zzaooVar.zzd);
        this.zzd = j3;
        this.zze = zzd(j3);
    }

    private final long zzd(long j) {
        return zzep.zzt(j * ((long) this.zzb), 1000000L, this.zza.zzc, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        long j2 = this.zzb;
        zzaoo zzaooVar = this.zza;
        long j3 = (((long) zzaooVar.zzc) * j) / (j2 * 1000000);
        String str = zzep.zza;
        long j4 = this.zzd - 1;
        long jMax = Math.max(0L, Math.min(j3, j4));
        long j5 = zzaooVar.zzd;
        long jZzd = zzd(jMax);
        long j6 = this.zzc;
        zzaee zzaeeVar = new zzaee(jZzd, (jMax * j5) + j6);
        if (jZzd >= j || jMax == j4) {
            return new zzaeb(zzaeeVar, zzaeeVar);
        }
        long j7 = jMax + 1;
        return new zzaeb(zzaeeVar, new zzaee(zzd(j7), j6 + (j5 * j7)));
    }
}
