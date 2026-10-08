package com.google.android.gms.internal.ads;

import android.media.Spatializer;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzxv implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ zzyi zza;

    zzxv(zzxx zzxxVar, zzyi zzyiVar) {
        this.zza = zzyiVar;
        Objects.requireNonNull(zzxxVar);
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.zzl();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.zzl();
    }
}
