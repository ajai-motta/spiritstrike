package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfdi {
    private final zzfic zza;
    private final zzcxv zzb;
    private final Executor zzc;
    private zzfdg zzd;

    public zzfdi(zzfic zzficVar, zzcxv zzcxvVar, Executor executor) {
        this.zza = zzficVar;
        this.zzb = zzcxvVar;
        this.zzc = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzfim zzb() {
        zzfgn zzfgnVarZzb = this.zzb.zzb();
        return this.zza.zzd(zzfgnVarZzb.zzd, zzfgnVarZzb.zzg, zzfgnVarZzb.zzk);
    }

    public final ListenableFuture zza() {
        ListenableFuture listenableFutureZza;
        zzfdg zzfdgVar = this.zzd;
        if (zzfdgVar != null) {
            return zzgui.zza(zzfdgVar);
        }
        if (((Boolean) zzbhb.zza.zze()).booleanValue()) {
            zzgua zzguaVarZzw = zzgua.zzw(this.zzb.zza().zze(this.zza.zze()));
            zzfdf zzfdfVar = new zzfdf(this);
            Executor executor = this.zzc;
            listenableFutureZza = (zzgua) zzgui.zzg((zzgua) zzgui.zzk(zzguaVarZzw, zzfdfVar, executor), zzecj.class, new zzfde(this), executor);
        } else {
            zzfdg zzfdgVar2 = new zzfdg(null, zzb(), null);
            this.zzd = zzfdgVar2;
            listenableFutureZza = zzgui.zza(zzfdgVar2);
        }
        return zzgui.zzk(listenableFutureZza, zzfdh.zza, this.zzc);
    }

    final /* synthetic */ zzfdg zzc() {
        return this.zzd;
    }

    final /* synthetic */ void zzd(zzfdg zzfdgVar) {
        this.zzd = zzfdgVar;
    }
}
