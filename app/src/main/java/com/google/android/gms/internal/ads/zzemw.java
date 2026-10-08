package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzemw implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzcca zza;
    final /* synthetic */ zzfgf zzb;
    final /* synthetic */ zzffu zzc;
    final /* synthetic */ zzend zzd;
    final /* synthetic */ zzemy zze;

    zzemw(zzemy zzemyVar, zzcca zzccaVar, zzfgf zzfgfVar, zzffu zzffuVar, zzend zzendVar) {
        this.zza = zzccaVar;
        this.zzb = zzfgfVar;
        this.zzc = zzffuVar;
        this.zzd = zzendVar;
        Objects.requireNonNull(zzemyVar);
        this.zze = zzemyVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
        zzend zzendVar = this.zzd;
        this.zza.zzc(this.zze.zzd().zza(this.zzb, this.zzc, view, zzendVar));
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
    }
}
