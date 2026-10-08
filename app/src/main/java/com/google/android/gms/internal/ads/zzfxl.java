package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfxl implements zzgtq {
    final /* synthetic */ Context zza;
    final /* synthetic */ View zzb;
    final /* synthetic */ Activity zzc;
    final /* synthetic */ zzfxn zzd;

    zzfxl(zzfxn zzfxnVar, Context context, String str, View view, Activity activity) {
        this.zza = context;
        this.zzb = view;
        this.zzc = activity;
        Objects.requireNonNull(zzfxnVar);
        this.zzd = zzfxnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        return this.zzd.zzg().zzc(this.zza, null, this.zzb, this.zzc);
    }
}
