package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaya implements Runnable {
    final /* synthetic */ zzayd zza;

    zzaya(zzayd zzaydVar) {
        Objects.requireNonNull(zzaydVar);
        this.zza = zzaydVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzr();
    }
}
