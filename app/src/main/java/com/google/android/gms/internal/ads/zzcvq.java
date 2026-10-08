package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcvq implements zzdej, zzdac {
    private final Clock zza;
    private final zzcvs zzb;
    private final zzfgn zzc;
    private final String zzd;

    zzcvq(Clock clock, zzcvs zzcvsVar, zzfgn zzfgnVar, String str) {
        this.zza = clock;
        this.zzb = zzcvsVar;
        this.zzc = zzfgnVar;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdej
    public final void zza() {
        this.zzb.zzd(this.zzd, this.zza.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzdac
    public final void zzg() {
        Clock clock = this.zza;
        this.zzb.zze(this.zzc.zzg, this.zzd, clock.elapsedRealtime());
    }
}
