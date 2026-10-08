package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdys implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzdys(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzdys zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdys(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdyz(((zzcjv) this.zza).zza(), ((zzckk) this.zzb).zza());
    }
}
