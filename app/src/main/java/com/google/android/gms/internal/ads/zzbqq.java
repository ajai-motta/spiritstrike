package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbqq implements zzcce {
    final /* synthetic */ zzbpv zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzcca zzc;
    final /* synthetic */ zzbqt zzd;

    zzbqq(zzbqt zzbqtVar, zzbpv zzbpvVar, Object obj, zzcca zzccaVar) {
        this.zza = zzbpvVar;
        this.zzb = obj;
        this.zzc = zzccaVar;
        Objects.requireNonNull(zzbqtVar);
        this.zzd = zzbqtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzcca zzccaVar = this.zzc;
        this.zzd.zzc(this.zza, (zzbqc) obj, obj2, zzccaVar);
    }
}
