package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzeiv implements zzdjl {
    final /* synthetic */ zzcca zza;
    final /* synthetic */ zzffu zzb;
    final /* synthetic */ zzeix zzc;

    zzeiv(zzeix zzeixVar, zzcca zzccaVar, zzffu zzffuVar) {
        this.zza = zzccaVar;
        this.zzb = zzffuVar;
        Objects.requireNonNull(zzeixVar);
        this.zzc = zzeixVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final void zza(boolean z, Context context, zzczb zzczbVar) {
        try {
            com.google.android.gms.ads.internal.zzt.zzb();
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, (AdOverlayInfoParcel) this.zza.get(), true, this.zzc.zzd());
        } catch (Exception unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final zzffu zzb() {
        return this.zzb;
    }
}
