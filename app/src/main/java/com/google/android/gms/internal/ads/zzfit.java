package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfit implements zzguf {
    final /* synthetic */ zzfiw zza;
    final /* synthetic */ zzfiy zzb;

    zzfit(zzfiy zzfiyVar, zzfiw zzfiwVar) {
        this.zza = zzfiwVar;
        Objects.requireNonNull(zzfiyVar);
        this.zzb = zzfiyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzfiy zzfiyVar = this.zzb;
        synchronized (zzfiyVar) {
            zzfiyVar.zzf(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfiy zzfiyVar = this.zzb;
        synchronized (zzfiyVar) {
            zzfiyVar.zzf(null);
            zzfiyVar.zze().addFirst(this.zza);
            if (zzfiyVar.zzg() == 1) {
                zzfiyVar.zzd();
            }
        }
    }
}
