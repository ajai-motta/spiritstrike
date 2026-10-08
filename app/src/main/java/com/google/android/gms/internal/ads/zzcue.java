package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcue {
    private final zzfgf zza;
    private final zzffu zzb;
    private final String zzc;

    public zzcue(zzfgf zzfgfVar, zzffu zzffuVar, String str) {
        this.zza = zzfgfVar;
        this.zzb = zzffuVar;
        this.zzc = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzfgf zza() {
        return this.zza;
    }

    public final zzffu zzb() {
        return this.zzb;
    }

    public final zzffx zzc() {
        return this.zza.zzb.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }
}
