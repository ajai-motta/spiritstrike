package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfdd implements zzfdm {
    private final zzfdm zza;
    private zzcxv zzb;

    public zzfdd(zzfdm zzfdmVar) {
        this.zza = zzfdmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcxv zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfdn zzfdnVar, zzfdl zzfdlVar, Object obj) {
        return zzb(zzfdnVar, zzfdlVar, null);
    }

    public final synchronized ListenableFuture zzb(zzfdn zzfdnVar, zzfdl zzfdlVar, zzcxv zzcxvVar) {
        zzbxj zzbxjVar;
        this.zzb = zzcxvVar;
        if (zzcxvVar == null || (zzbxjVar = zzfdnVar.zza) == null) {
            return ((zzfdc) this.zza).zzb(zzfdnVar, zzfdlVar, zzcxvVar);
        }
        zzcus zzcusVarZza = zzcxvVar.zza();
        return zzcusVarZza.zzc(zzcusVarZza.zza(zzgui.zza(zzbxjVar)));
    }
}
