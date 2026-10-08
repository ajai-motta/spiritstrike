package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdpw implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzdpw(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzdpw zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdpw(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdpv((zzdll) this.zza.zzb(), ((zzdmi) this.zzb).zza());
    }
}
