package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzesb implements zzeya {
    private final zzfgn zza;

    zzesb(zzfgn zzfgnVar) {
        this.zza = zzfgnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return zzgui.zza(new zzesc(this.zza.zzq));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 58;
    }
}
