package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzaec implements zzaed {
    private final long zza;
    private final zzaeb zzb;

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        return this.zzb;
    }

    public zzaec(long j, long j2) {
        this.zza = j;
        zzaee zzaeeVar = j2 == 0 ? zzaee.zza : new zzaee(0L, j2);
        this.zzb = new zzaeb(zzaeeVar, zzaeeVar);
    }
}
