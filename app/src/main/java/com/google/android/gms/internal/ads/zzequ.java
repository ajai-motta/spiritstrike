package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzequ {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzeqt zzb;

    public final void zza(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzb() {
        return this.zza.get();
    }

    final void zzc(zzeqt zzeqtVar) {
        this.zzb = zzeqtVar;
    }

    final zzeqt zzd() {
        return this.zzb;
    }
}
