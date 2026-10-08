package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzevw implements zzeya {
    private final zzfft zza;

    zzevw(zzfft zzfftVar) {
        this.zza = zzfftVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return zzgui.zza(new zzevx(this.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 25;
    }
}
