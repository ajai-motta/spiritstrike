package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzapf implements Runnable {
    final /* synthetic */ zzapu zza;
    final /* synthetic */ zzapg zzb;

    zzapf(zzapg zzapgVar, zzapu zzapuVar) {
        this.zza = zzapuVar;
        Objects.requireNonNull(zzapgVar);
        this.zzb = zzapgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.zzb().put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
