package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcpk implements zzguf {
    final /* synthetic */ String zza;
    final /* synthetic */ zzcpq zzb;

    zzcpk(zzcpq zzcpqVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzcpqVar);
        this.zzb = zzcpqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzcpq zzcpqVar = this.zzb;
        zzcpqVar.zzu().zza(zzcpqVar.zzt().zzb(zzcpqVar.zzr(), zzcpqVar.zzs(), false, this.zza, null, zzcpqVar.zzp(), zzcpqVar.zzw()), null);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = this.zza;
        String str2 = (String) obj;
        zzcpq zzcpqVar = this.zzb;
        zzcpqVar.zzu().zza(zzcpqVar.zzt().zzb(zzcpqVar.zzr(), zzcpqVar.zzs(), false, str, str2, zzcpqVar.zzp(), zzcpqVar.zzw()), zzcpqVar.zzv());
    }
}
