package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfpm implements Runnable {
    final /* synthetic */ float zza;
    final /* synthetic */ zzfpn zzb;

    zzfpm(zzfpn zzfpnVar, float f) {
        this.zza = f;
        Objects.requireNonNull(zzfpnVar);
        this.zzb = zzfpnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzg().zzf(this.zza);
    }
}
