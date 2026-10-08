package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzajm implements zzajs {
    private final zzadn zza;
    private final zzadm zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzajm(zzadn zzadnVar, zzadm zzadmVar) {
        this.zza = zzadnVar;
        this.zzb = zzadmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final long zza(zzadb zzadbVar) {
        long j = this.zzd;
        if (j < 0) {
            return -1L;
        }
        this.zzd = -1L;
        return -(j + 2);
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final void zzb(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzep.zzm(jArr, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final zzaed zzc() {
        zzgmd.zzh(this.zzc != -1);
        return new zzadl(this.zza, this.zzc);
    }

    public final void zzd(long j) {
        this.zzc = j;
    }
}
