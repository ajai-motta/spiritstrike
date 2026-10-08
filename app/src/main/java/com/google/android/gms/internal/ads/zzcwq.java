package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcwq implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzcwq(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzcwq zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzcwq(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdgn((zzddf) this.zza.zzb(), (Executor) this.zzb.zzb());
    }
}
