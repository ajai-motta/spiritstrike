package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdzf extends AdListener {
    final /* synthetic */ zzdzl zza;

    zzdzf(zzdzl zzdzlVar) {
        Objects.requireNonNull(zzdzlVar);
        this.zza = zzdzlVar;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zza.zzg(zzdzl.zzm(loadAdError));
    }
}
