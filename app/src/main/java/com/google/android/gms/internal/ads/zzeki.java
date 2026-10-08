package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeki extends zzekk {
    private final zzcjn zza;
    private final zzdju zzb;
    private final zzcxw zzc;
    private final zzdeo zzd;
    private final zzekv zze;
    private final zzehp zzf;

    public zzeki(zzcjn zzcjnVar, zzdju zzdjuVar, zzcxw zzcxwVar, zzdeo zzdeoVar, zzekv zzekvVar, zzehp zzehpVar) {
        this.zza = zzcjnVar;
        this.zzb = zzdjuVar;
        this.zzc = zzcxwVar;
        this.zzd = zzdeoVar;
        this.zze = zzekvVar;
        this.zzf = zzehpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    protected final ListenableFuture zzc(zzfgn zzfgnVar, Bundle bundle, zzffu zzffuVar, zzfgf zzfgfVar) {
        zzcxw zzcxwVar = this.zzc;
        zzcxwVar.zzb(zzfgnVar);
        zzcxwVar.zzc(bundle);
        zzcxwVar.zzd(new zzcxp(zzfgfVar, zzffuVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzee)).booleanValue()) {
            zzcxwVar.zzg(this.zzf);
        }
        zzdjy zzdjyVarZzo = this.zza.zzo();
        zzdjyVarZzo.zzf(zzcxwVar.zze());
        zzdjyVarZzo.zzg(this.zzd);
        zzdjyVarZzo.zze(this.zzb);
        zzdjyVarZzo.zzd(new zzcrd(null));
        zzcus zzcusVarZza = zzdjyVarZzo.zza().zza();
        return zzcusVarZza.zzc(zzcusVarZza.zzb());
    }
}
