package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzadl implements zzaed {
    private final zzadn zza;
    private final long zzb;

    public zzadl(zzadn zzadnVar, long j) {
        this.zza = zzadnVar;
        this.zzb = j;
    }

    private final zzaee zzd(long j, long j2) {
        return new zzaee((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzadn zzadnVar = this.zza;
        zzadm zzadmVar = zzadnVar.zzk;
        zzadmVar.getClass();
        long jZzb = zzadnVar.zzb(j);
        long[] jArr = zzadmVar.zza;
        int iZzm = zzep.zzm(jArr, jZzb, true, false);
        long j2 = iZzm == -1 ? 0L : jArr[iZzm];
        long[] jArr2 = zzadmVar.zzb;
        zzaee zzaeeVarZzd = zzd(j2, iZzm != -1 ? jArr2[iZzm] : 0L);
        if (zzaeeVarZzd.zzb == j || iZzm == jArr.length - 1) {
            return new zzaeb(zzaeeVarZzd, zzaeeVarZzd);
        }
        int i = iZzm + 1;
        return new zzaeb(zzaeeVarZzd, zzd(jArr[i], jArr2[i]));
    }
}
