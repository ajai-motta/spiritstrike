package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfdc implements zzfdm {
    private zzcxv zza;

    @Override // com.google.android.gms.internal.ads.zzfdm
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcxv zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfdn zzfdnVar, zzfdl zzfdlVar, Object obj) {
        return zzb(zzfdnVar, zzfdlVar, null);
    }

    public final synchronized ListenableFuture zzb(zzfdn zzfdnVar, zzfdl zzfdlVar, zzcxv zzcxvVar) {
        zzcus zzcusVarZza;
        if (zzcxvVar != null) {
            this.zza = zzcxvVar;
        } else {
            this.zza = (zzcxv) zzfdlVar.zza(zzfdnVar.zzb).zzh();
        }
        zzcusVarZza = this.zza.zza();
        return zzcusVarZza.zzc(zzcusVarZza.zzb());
    }
}
