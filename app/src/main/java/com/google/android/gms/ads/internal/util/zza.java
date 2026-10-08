package com.google.android.gms.ads.internal.util;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zza implements Runnable {
    final /* synthetic */ zzb zza;

    zza(zzb zzbVar) {
        Objects.requireNonNull(zzbVar);
        this.zza = zzbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb zzbVar = this.zza;
        zzbVar.zzc(Thread.currentThread());
        zzbVar.zza();
    }
}
