package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzflc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfky implements zzdga, zzcze, zzdge {
    private final zzflm zza;
    private final zzflc zzb;

    zzfky(Context context, zzflm zzflmVar) {
        this.zza = zzflmVar;
        this.zzb = zzflc.CC.zzn(context, 13);
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zza() {
        if (((Boolean) zzbgn.zzd.zze()).booleanValue()) {
            zzflm zzflmVar = this.zza;
            zzflc zzflcVar = this.zzb;
            zzflcVar.zzd(true);
            zzflmVar.zza(zzflcVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdge
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final void zzg() {
    }

    @Override // com.google.android.gms.internal.ads.zzdga
    public final void zzh() {
        if (((Boolean) zzbgn.zzd.zze()).booleanValue()) {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcze
    public final void zzj(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (((Boolean) zzbgn.zzd.zze()).booleanValue()) {
            zzflm zzflmVar = this.zza;
            zzflc zzflcVar = this.zzb;
            zzflcVar.zzk(zzeVar.zza().toString());
            zzflcVar.zzd(false);
            zzflmVar.zza(zzflcVar);
        }
    }
}
