package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdog implements zzguf {
    final /* synthetic */ zzduq zza;
    final /* synthetic */ zzdoj zzb;

    zzdog(zzdoj zzdojVar, zzduq zzduqVar) {
        this.zza = zzduqVar;
        Objects.requireNonNull(zzdojVar);
        this.zzb = zzdojVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        this.zzb.zzd().zze().putLong(this.zza.zza(), com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
    }
}
