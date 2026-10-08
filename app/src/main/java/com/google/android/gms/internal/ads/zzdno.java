package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdno implements zzguf {
    final /* synthetic */ zzdnq zza;

    zzdno(zzdnq zzdnqVar) {
        Objects.requireNonNull(zzdnqVar);
        this.zza = zzdnqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfX)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final void zzb(List list) {
        try {
            zzcgy zzcgyVar = (zzcgy) list.get(0);
            if (zzcgyVar != null) {
                this.zza.zza(zzcgyVar);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfX)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "omid native display exp");
            }
        }
    }
}
