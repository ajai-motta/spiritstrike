package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdrt implements com.google.android.gms.ads.internal.zzn {
    final /* synthetic */ zzdse zza;

    zzdrt(zzdse zzdseVar) {
        Objects.requireNonNull(zzdseVar);
        this.zza = zzdseVar;
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdp() {
        this.zza.zzb().zza();
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdq() {
        this.zza.zzb().zzb();
    }
}
