package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzzs implements zzzt {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzdg zzb;

    zzzs(Executor executor, zzdg zzdgVar) {
        this.zza = executor;
        this.zzb = zzdgVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.execute(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzzt
    public final void zza() {
        this.zzb.zza(this.zza);
    }
}
