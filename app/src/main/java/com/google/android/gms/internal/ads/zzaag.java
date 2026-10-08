package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaag implements zzabv {
    final /* synthetic */ zzsv zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzaak zzd;

    zzaag(zzaak zzaakVar, zzsv zzsvVar, int i, long j) {
        this.zza = zzsvVar;
        this.zzb = i;
        this.zzc = j;
        Objects.requireNonNull(zzaakVar);
        this.zzd = zzaakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zza(long j) {
        this.zzd.zzay(this.zza, this.zzb, this.zzc, j);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzb() {
        this.zzd.zzav(this.zza, this.zzb, this.zzc);
    }
}
