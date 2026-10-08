package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzepa implements zzepi {
    final /* synthetic */ zzepb zza;

    zzepa(zzepb zzepbVar) {
        Objects.requireNonNull(zzepbVar);
        this.zza = zzepbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        zzepb zzepbVar = this.zza;
        synchronized (zzepbVar) {
            zzepbVar.zzM(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzepb zzepbVar = this.zza;
        zzdhw zzdhwVar = (zzdhw) obj;
        synchronized (zzepbVar) {
            zzepbVar.zzM(zzdhwVar);
            zzepbVar.zzL().zzj();
        }
    }
}
