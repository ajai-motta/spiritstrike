package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcjh implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzcjh(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzcjh zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzcjh(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcjg((zzcix) this.zza.zzb(), (zzdvi) this.zzb.zzb());
    }
}
