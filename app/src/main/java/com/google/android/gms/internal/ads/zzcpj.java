package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcpj implements zzguf {
    final /* synthetic */ zzcpq zza;

    zzcpj(zzcpq zzcpqVar) {
        Objects.requireNonNull(zzcpqVar);
        this.zza = zzcpqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpq zzcpqVar = this.zza;
        zzcpqVar.zzu().zzb(zzcpqVar.zzt().zzb(zzcpqVar.zzr(), zzcpqVar.zzs(), false, "", (String) obj, zzcpqVar.zzs().zzc, null), true == com.google.android.gms.ads.internal.zzt.zzh().zzs(zzcpqVar.zzq()) ? 2 : 1);
    }
}
