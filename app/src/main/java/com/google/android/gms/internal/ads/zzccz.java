package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzccz implements Runnable {
    final /* synthetic */ zzcdf zza;

    zzccz(zzcdf zzcdfVar) {
        Objects.requireNonNull(zzcdfVar);
        this.zza = zzcdfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzI("surfaceCreated", new String[0]);
    }
}
