package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzayc implements Runnable {
    final /* synthetic */ zzayd zza;

    zzayc(zzayd zzaydVar) {
        Objects.requireNonNull(zzaydVar);
        this.zza = zzaydVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbeu.zza(this.zza.zza);
    }
}
