package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdmg implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzdmg(zzdmb zzdmbVar, zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzdmg zzc(zzdmb zzdmbVar, zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdmg(zzdmbVar, zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcac zzb() {
        return new zzcac(((zzcjv) this.zza).zza(), ((zzcyf) this.zzb).zza().zzg);
    }
}
