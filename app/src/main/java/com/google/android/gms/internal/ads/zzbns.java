package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbns implements Runnable {
    final /* synthetic */ zzbnv zza;

    zzbns(zzbnv zzbnvVar) {
        Objects.requireNonNull(zzbnvVar);
        this.zza = zzbnvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb();
    }
}
