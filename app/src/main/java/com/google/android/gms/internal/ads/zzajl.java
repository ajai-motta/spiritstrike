package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzajl implements zzajs {
    private final zzajr zza;
    private final long zzb;
    private final long zzc;
    private final zzajw zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzajl(zzajw zzajwVar, long j, long j2, long j3, long j4, boolean z) {
        zzgmd.zza(j >= 0 && j2 > j);
        this.zzd = zzajwVar;
        this.zzb = j;
        this.zzc = j2;
        if (j3 == j2 - j || z) {
            this.zzf = j4;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzajr();
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final void zzb(long j) {
        long j2 = this.zzf - 1;
        String str = zzep.zza;
        this.zzh = Math.max(0L, Math.min(j, j2));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final /* bridge */ /* synthetic */ zzaed zzc() {
        byte[] bArr = null;
        if (this.zzf != 0) {
            return new zzajk(this, bArr);
        }
        return null;
    }

    final /* synthetic */ long zzd() {
        return this.zzb;
    }

    final /* synthetic */ long zze() {
        return this.zzc;
    }

    final /* synthetic */ zzajw zzf() {
        return this.zzd;
    }

    final /* synthetic */ long zzg() {
        return this.zzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    @Override // com.google.android.gms.internal.ads.zzajs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zza(com.google.android.gms.internal.ads.zzadb r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajl.zza(com.google.android.gms.internal.ads.zzadb):long");
    }
}
