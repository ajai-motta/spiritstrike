package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzekr extends zzekk {
    private final zzcjn zza;
    private final zzcxw zzb;
    private final zzdeo zzc;
    private final zzekv zzd;

    @Nullable
    private final zzfgg zze;
    private final zzehp zzf;

    public zzekr(zzcjn zzcjnVar, zzcxw zzcxwVar, zzdeo zzdeoVar, @Nullable zzfgg zzfggVar, zzekv zzekvVar, zzehp zzehpVar) {
        this.zza = zzcjnVar;
        this.zzb = zzcxwVar;
        this.zzc = zzdeoVar;
        this.zze = zzfggVar;
        this.zzd = zzekvVar;
        this.zzf = zzehpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    protected final ListenableFuture zzc(zzfgn zzfgnVar, Bundle bundle, zzffu zzffuVar, zzfgf zzfgfVar) {
        zzfgg zzfggVar;
        zzcxw zzcxwVar = this.zzb;
        zzcxwVar.zzb(zzfgnVar);
        zzcxwVar.zzc(bundle);
        zzcxwVar.zzd(new zzcxp(zzfgfVar, zzffuVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzed)).booleanValue() && (zzfggVar = this.zze) != null) {
            zzcxwVar.zzf(zzfggVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzee)).booleanValue()) {
            zzcxwVar.zzg(this.zzf);
        }
        zzdrm zzdrmVarZzp = this.zza.zzp();
        zzdrmVarZzp.zzd(zzcxwVar.zze());
        zzdrmVarZzp.zze(this.zzc);
        zzcus zzcusVarZza = zzdrmVarZzp.zza().zza();
        return zzcusVarZza.zzc(zzcusVarZza.zzb());
    }
}
