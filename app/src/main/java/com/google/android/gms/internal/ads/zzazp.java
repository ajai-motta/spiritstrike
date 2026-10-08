package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzazp implements Runnable {
    final /* synthetic */ zzazq zza;

    zzazp(zzazq zzazqVar) {
        Objects.requireNonNull(zzazqVar);
        this.zza = zzazqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb();
    }
}
