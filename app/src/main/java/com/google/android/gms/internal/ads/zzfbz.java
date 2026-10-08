package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfbz implements zzepi {
    final /* synthetic */ zzfcc zza;

    zzfbz(zzfcc zzfccVar) {
        Objects.requireNonNull(zzfccVar);
        this.zza = zzfccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        zzfcc zzfccVar = this.zza;
        synchronized (zzfccVar) {
            zzfccVar.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcra zzcraVar = (zzcra) obj;
        zzfcc zzfccVar = this.zza;
        synchronized (zzfccVar) {
            zzcra zzcraVar2 = zzfccVar.zza;
            if (zzcraVar2 != null) {
                zzcraVar2.zzd();
            }
            zzfccVar.zza = zzcraVar;
            zzcraVar.zza(zzfccVar);
            zzfccVar.zzN().zzs(new zzcrb(zzcraVar, zzfccVar, zzfccVar.zzN(), zzfccVar.zzO()));
            zzcraVar.zzj();
        }
    }
}
