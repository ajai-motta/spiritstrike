package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdww implements zzifh {
    private final zzifq zza;

    private zzdww(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdww zzc(zzifq zzifqVar) {
        return new zzdww(zzifqVar);
    }

    public static zzdwv zzd(zzbmx zzbmxVar) {
        return new zzdwv(zzbmxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdwv zzb() {
        return new zzdwv((zzbmx) this.zza.zzb());
    }
}
