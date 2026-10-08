package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfke implements zzguf {
    final /* synthetic */ zzfjz zza;
    final /* synthetic */ zzfkj zzb;

    zzfke(zzfkj zzfkjVar, zzfjz zzfjzVar) {
        this.zza = zzfjzVar;
        Objects.requireNonNull(zzfkjVar);
        this.zzb = zzfkjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        this.zzb.zza.zzg().zzc(this.zza, th);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        this.zzb.zza.zzg().zzd(this.zza);
    }
}
