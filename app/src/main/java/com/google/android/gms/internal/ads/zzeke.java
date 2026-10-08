package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzeke implements zzguf {
    final /* synthetic */ zzffu zza;
    final /* synthetic */ zzekf zzb;

    zzeke(zzekf zzekfVar, zzffu zzffuVar) {
        this.zza = zzffuVar;
        Objects.requireNonNull(zzekfVar);
        this.zzb = zzekfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzekf zzekfVar = this.zzb;
        synchronized (zzekfVar) {
            zzekg zzekgVarZzc = zzekfVar.zzc();
            zzffu zzffuVar = this.zza;
            zzekgVarZzc.zzc(th, zzffuVar);
            zzffu zzffuVarZza = zzekfVar.zzc().zza();
            if (zzffuVar.zzav) {
                while (zzffuVarZza != null) {
                    zzekfVar.zzb(zzffuVarZza);
                    zzffuVarZza = zzekfVar.zzc().zza();
                }
            } else if (zzffuVarZza != null) {
                zzekfVar.zzb(zzffuVarZza);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzekf zzekfVar = this.zzb;
        zzekw zzekwVar = (zzekw) obj;
        synchronized (zzekfVar) {
            zzekfVar.zzc().zzb(zzekwVar, this.zza);
            zzffu zzffuVarZza = zzekfVar.zzc().zza();
            if (zzffuVarZza != null) {
                zzekfVar.zzb(zzffuVarZza);
            }
        }
    }
}
