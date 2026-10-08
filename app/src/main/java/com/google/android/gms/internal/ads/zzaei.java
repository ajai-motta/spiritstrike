package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaei extends zzado {
    private final long zza;

    public zzaei(zzadb zzadbVar, long j) {
        super(zzadbVar);
        zzgmd.zza(zzadbVar.zzn() >= j);
        this.zza = j;
    }

    @Override // com.google.android.gms.internal.ads.zzado, com.google.android.gms.internal.ads.zzadb
    public final long zzm() {
        return super.zzm() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzado, com.google.android.gms.internal.ads.zzadb
    public final long zzn() {
        return super.zzn() - this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzado, com.google.android.gms.internal.ads.zzadb
    public final long zzo() {
        return super.zzo() - this.zza;
    }
}
