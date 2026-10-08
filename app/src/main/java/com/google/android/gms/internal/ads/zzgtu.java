package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgtu extends zzgtv {
    final /* synthetic */ zzgtw zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgtu(zzgtw zzgtwVar, Callable callable, Executor executor) {
        super(zzgtwVar, executor);
        Objects.requireNonNull(zzgtwVar);
        this.zza = zzgtwVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzgtv
    final void zzb(Object obj) {
        this.zza.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    final String zzc() {
        return this.zzc.toString();
    }
}
