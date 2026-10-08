package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdwi implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzdwi(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzdwi zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdwi(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdwh((zzdvv) this.zza.zzb(), (zzcjn) this.zzb.zzb());
    }
}
