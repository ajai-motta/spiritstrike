package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfxh implements zzifh {
    private final zzifq zza;

    private zzfxh(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzfxh zza(zzifq zzifqVar) {
        return new zzfxh(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgus zzgusVarZzb = zzguz.zzb((ExecutorService) this.zza.zzb());
        zzifp.zzb(zzgusVarZzb);
        return zzgusVarZzb;
    }
}
