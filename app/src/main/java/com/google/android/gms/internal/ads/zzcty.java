package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcty implements zzguf {
    final /* synthetic */ zzguf zza;
    final /* synthetic */ zzcud zzb;

    zzcty(zzcud zzcudVar, zzguf zzgufVar) {
        this.zza = zzgufVar;
        Objects.requireNonNull(zzcudVar);
        this.zzb = zzcudVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        this.zzb.zzf();
        this.zza.zza(th);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzf();
        this.zza.zzb((zzcto) obj);
    }
}
