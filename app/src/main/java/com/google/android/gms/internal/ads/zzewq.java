package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzewq implements zzeya {
    private final Bundle zza;

    zzewq(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return zzgui.zza(new zzewr(this.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 30;
    }
}
