package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzexs implements zzeya {
    private final boolean zza;

    zzexs(zzfdq zzfdqVar) {
        this.zza = zzfdqVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return zzgui.zza(new zzexr(this.zza, null));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 36;
    }
}
