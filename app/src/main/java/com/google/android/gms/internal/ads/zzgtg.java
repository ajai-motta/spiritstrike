package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgtg extends zzgth {
    zzgtg(ListenableFuture listenableFuture, zzglu zzgluVar) {
        super(listenableFuture, zzgluVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgth
    final void zze(Object obj) {
        zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgth
    final /* synthetic */ Object zzf(Object obj, Object obj2) throws Exception {
        return ((zzglu) obj).apply(obj2);
    }
}
