package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzck implements Callable {
    final /* synthetic */ zzcm zza;

    zzck(zzcm zzcmVar) {
        this.zza = zzcmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() throws Exception {
        return this.zza.zzc();
    }
}
