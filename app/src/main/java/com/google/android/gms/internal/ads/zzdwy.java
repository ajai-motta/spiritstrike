package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdwy implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzdwy(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzdwy zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdwy(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdwx((zzdxa) this.zza.zzb(), ((zzdww) this.zzb).zzb());
    }
}
