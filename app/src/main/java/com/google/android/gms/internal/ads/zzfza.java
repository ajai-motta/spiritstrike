package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfza implements zzifh {
    private final zzifq zza;

    private zzfza(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzfza zza(zzifq zzifqVar) {
        return new zzfza(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfzi((ExecutorService) this.zza.zzb());
    }
}
