package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbdj extends zzcca {
    final /* synthetic */ zzbdp zza;

    zzbdj(zzbdp zzbdpVar) {
        Objects.requireNonNull(zzbdpVar);
        this.zza = zzbdpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcca, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.zza.zzb();
        return super.cancel(z);
    }
}
