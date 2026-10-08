package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdnv implements zzifh {
    private final zzifq zza;

    private zzdnv(zzdnu zzdnuVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdnv zza(zzdnu zzdnuVar, zzifq zzifqVar) {
        return new zzdnv(zzdnuVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdns zzdnsVar = (zzdns) this.zza.zzb();
        zzifp.zzb(zzdnsVar);
        return zzdnsVar;
    }
}
