package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcgz implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbzt zza;
    final /* synthetic */ zzchj zzb;

    zzcgz(zzchj zzchjVar, zzbzt zzbztVar) {
        this.zza = zzbztVar;
        Objects.requireNonNull(zzchjVar);
        this.zzb = zzchjVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzX(view, this.zza, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
