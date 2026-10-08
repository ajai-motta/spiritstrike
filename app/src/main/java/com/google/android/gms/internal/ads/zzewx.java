package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzewx implements zzeya {
    private final String zza;
    private final int zzb;

    zzewx(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return zzgui.zza(new zzewy(this.zza, this.zzb));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 31;
    }
}
