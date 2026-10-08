package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzepd implements zzepi {
    final /* synthetic */ zzepe zza;

    zzepd(zzepe zzepeVar) {
        Objects.requireNonNull(zzepeVar);
        this.zza = zzepeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcto zzctoVar = (zzcto) obj;
        zzepe zzepeVar = this.zza;
        synchronized (zzepeVar) {
            zzepeVar.zze(zzctoVar.zzn());
            zzctoVar.zzj();
        }
    }
}
