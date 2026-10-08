package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdru implements zzbuo {
    final /* synthetic */ zzdsd zza;

    zzdru(zzdsd zzdsdVar) {
        Objects.requireNonNull(zzdsdVar);
        this.zza = zzdsdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zza(int i, int i2, int i3, int i4) {
        this.zza.zzg().zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzb() {
        this.zza.zzg().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzc() {
        this.zza.zzh().zza();
    }
}
