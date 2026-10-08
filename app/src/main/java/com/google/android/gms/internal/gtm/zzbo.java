package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbo implements Callable {
    final /* synthetic */ zzbp zza;

    zzbo(zzbp zzbpVar) {
        this.zza = zzbpVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        this.zza.zza.zzab();
        return null;
    }
}
