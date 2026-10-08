package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzems implements com.google.android.gms.ads.internal.zzg {
    final AtomicBoolean zza = new AtomicBoolean(false);
    private final zzcym zzb;
    private final zzczg zzc;
    private final zzdgx zzd;
    private final zzdgp zze;
    private final zzcqb zzf;

    zzems(zzcym zzcymVar, zzczg zzczgVar, zzdgx zzdgxVar, zzdgp zzdgpVar, zzcqb zzcqbVar) {
        this.zzb = zzcymVar;
        this.zzc = zzczgVar;
        this.zzd = zzdgxVar;
        this.zze = zzdgpVar;
        this.zzf = zzcqbVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zza(View view) {
        if (this.zza.compareAndSet(false, true)) {
            this.zzf.zzdw();
            this.zze.zza(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        if (this.zza.get()) {
            this.zzb.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        if (this.zza.get()) {
            this.zzc.zza();
            this.zzd.zza();
        }
    }
}
