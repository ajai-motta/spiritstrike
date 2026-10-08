package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfcz implements zzfdm {
    private final zzfic zza;
    private final Executor zzb;
    private final zzguf zzc = new zzfcw(this);

    public zzfcz(zzfic zzficVar, Executor executor) {
        this.zza = zzficVar;
        this.zzb = executor;
    }

    public final ListenableFuture zza(zzfdn zzfdnVar, zzfdl zzfdlVar, final zzcxv zzcxvVar) {
        zzfic zzficVar = this.zza;
        Executor executor = this.zzb;
        return (zzgua) zzgui.zzg((zzgua) zzgui.zzj(zzgua.zzw(new zzfdi(zzficVar, zzcxvVar, executor).zza()), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzfcx
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzcxvVar, (zzfdg) obj);
            }
        }, executor), Exception.class, new zzfcv(this), executor);
    }

    final /* synthetic */ ListenableFuture zzb(zzcxv zzcxvVar, zzfdg zzfdgVar) {
        zzfic zzficVar = this.zza;
        zzfim zzfimVar = zzfdgVar.zzb;
        zzbxj zzbxjVar = zzfdgVar.zza;
        zzfil zzfilVarZza = zzficVar.zza(zzfimVar);
        if (zzfilVarZza != null && zzbxjVar != null) {
            zzgui.zzr(zzcxvVar.zza().zzf(zzbxjVar), this.zzc, this.zzb);
        }
        return zzgui.zza(new zzfcy(zzfimVar, zzbxjVar, zzfilVarZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfdn zzfdnVar, zzfdl zzfdlVar, Object obj) {
        return zza(zzfdnVar, zzfdlVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
