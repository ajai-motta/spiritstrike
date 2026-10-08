package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzayi implements Runnable {
    final /* synthetic */ zzayk zza;

    zzayi(zzayk zzaykVar) {
        Objects.requireNonNull(zzaykVar);
        this.zza = zzaykVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzd();
    }
}
