package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzebe implements zzguf {
    final /* synthetic */ zzebk zza;

    zzebe(zzebk zzebkVar) {
        Objects.requireNonNull(zzebkVar);
        this.zza = zzebkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfgf zzfgfVar = (zzfgf) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcA)).booleanValue()) {
            this.zza.zzf().zzdU(zzfgfVar);
        }
    }
}
