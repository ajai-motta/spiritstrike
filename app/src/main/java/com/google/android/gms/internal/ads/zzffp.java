package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzffp implements zzepi {
    final /* synthetic */ zzffr zza;

    zzffp(zzffr zzffrVar) {
        Objects.requireNonNull(zzffrVar);
        this.zza = zzffrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        zzffr zzffrVar = this.zza;
        synchronized (zzffrVar) {
            zzffrVar.zzx(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzffr zzffrVar = this.zza;
        zzdri zzdriVar = (zzdri) obj;
        synchronized (zzffrVar) {
            zzffrVar.zzx(zzdriVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzec)).booleanValue()) {
                zzdriVar.zzh().zza = zzffrVar.zzv();
            }
            zzffrVar.zzw().zzj();
        }
    }
}
