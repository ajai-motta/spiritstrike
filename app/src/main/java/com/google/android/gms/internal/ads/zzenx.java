package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzenx implements zzepi {
    final /* synthetic */ zzeny zza;

    zzenx(zzeny zzenyVar) {
        Objects.requireNonNull(zzenyVar);
        this.zza = zzenyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        zzeny zzenyVar = this.zza;
        synchronized (zzenyVar) {
            zzenyVar.zzN(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeny zzenyVar = this.zza;
        zzcrg zzcrgVar = (zzcrg) obj;
        synchronized (zzenyVar) {
            if (zzenyVar.zzM() != null) {
                if (zzcrgVar.zzo() != null && zzenyVar.zzM().zzo() != null) {
                    zzcrgVar.zzo().zzb(zzenyVar.zzM().zzo().zza());
                }
                zzenyVar.zzM().zzd();
            }
            zzenyVar.zzN(zzcrgVar);
            zzenyVar.zzM().zzj();
        }
    }
}
