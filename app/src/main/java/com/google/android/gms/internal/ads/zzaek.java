package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaek implements zzadd {
    private final long zzb;
    private final zzadd zzc;

    public zzaek(long j, zzadd zzaddVar) {
        this.zzb = j;
        this.zzc = zzaddVar;
    }

    final /* synthetic */ long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final zzaem zzu(int i, int i2) {
        return this.zzc.zzu(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzv() {
        this.zzc.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzw(zzaed zzaedVar) {
        this.zzc.zzw(new zzaej(this, zzaedVar, zzaedVar));
    }
}
