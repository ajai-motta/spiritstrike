package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgsz extends zzgta {
    zzgsz(ListenableFuture listenableFuture, Class cls, zzglu zzgluVar) {
        super(listenableFuture, cls, zzgluVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    final void zze(Object obj) {
        zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    final /* synthetic */ Object zzf(Object obj, Throwable th) throws Exception {
        return ((zzglu) obj).apply(th);
    }
}
