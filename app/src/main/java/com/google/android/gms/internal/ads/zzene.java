package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzene implements zzdjl {
    final /* synthetic */ zzffu zza;

    zzene(zzenh zzenhVar, zzffu zzffuVar) {
        this.zza = zzffuVar;
        Objects.requireNonNull(zzenhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final void zza(boolean z, Context context, zzczb zzczbVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final zzffu zzb() {
        return this.zza;
    }
}
