package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbnr implements zzgtq {
    final /* synthetic */ zzbnj zza;

    zzbnr(zzbnv zzbnvVar, zzbnj zzbnjVar) {
        this.zza = zzbnjVar;
        Objects.requireNonNull(zzbnvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzcca zzccaVar = new zzcca();
        ((zzbnp) obj).zze(this.zza, new zzbnq(this, zzccaVar));
        return zzccaVar;
    }
}
