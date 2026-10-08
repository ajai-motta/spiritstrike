package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgsy extends zzgta {
    zzgsy(ListenableFuture listenableFuture, Class cls, zzgtq zzgtqVar) {
        super(listenableFuture, cls, zzgtqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    final /* synthetic */ void zze(Object obj) {
        zzk((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    final /* bridge */ /* synthetic */ Object zzf(Object obj, Throwable th) throws Exception {
        zzgtq zzgtqVar = (zzgtq) obj;
        ListenableFuture listenableFutureZza = zzgtqVar.zza(th);
        zzgmd.zzl(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgtqVar);
        return listenableFutureZza;
    }
}
