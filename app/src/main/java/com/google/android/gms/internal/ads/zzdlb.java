package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdlb implements zzguf {
    final /* synthetic */ String zza = "Google";
    final /* synthetic */ zzdll zzb;

    zzdlb(zzdll zzdllVar, String str, boolean z) {
        Objects.requireNonNull(zzdllVar);
        this.zzb = zzdllVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfX)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdll zzdllVar = this.zzb;
        zzdllVar.zzZ().zzo((zzcgy) obj);
        String str = this.zza;
        zzcca zzccaVarZzY = zzdllVar.zzZ().zzY();
        zzehf zzehfVarZzL = zzdllVar.zzL(str, true);
        if (zzehfVarZzL != null && zzccaVarZzY != null) {
            zzccaVarZzY.zzc(zzehfVarZzL);
        } else if (zzccaVarZzY != null) {
            zzccaVarZzY.cancel(false);
        }
    }
}
