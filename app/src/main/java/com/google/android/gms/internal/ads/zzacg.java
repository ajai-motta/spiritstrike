package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzacg implements zzaed {
    private final zzacj zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;

    public zzacg(zzacj zzacjVar, long j, long j2, long j3, long j4, long j5, long j6) {
        this.zza = zzacjVar;
        this.zzb = j;
        this.zzc = j3;
        this.zzd = j4;
        this.zze = j5;
        this.zzf = j6;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzaee zzaeeVar = new zzaee(j, zzaci.zza(this.zza.zza(j), 0L, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzaeb(zzaeeVar, zzaeeVar);
    }

    public final long zzd(long j) {
        return this.zza.zza(j);
    }

    final /* synthetic */ long zze() {
        return this.zzc;
    }

    final /* synthetic */ long zzf() {
        return this.zzd;
    }

    final /* synthetic */ long zzg() {
        return this.zze;
    }

    final /* synthetic */ long zzh() {
        return this.zzf;
    }
}
