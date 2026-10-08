package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfxk implements zzgtq {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzfxn zzb;

    zzfxk(zzfxn zzfxnVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzfxnVar);
        this.zzb = zzfxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        return this.zzb.zzg().zzb(this.zza);
    }
}
