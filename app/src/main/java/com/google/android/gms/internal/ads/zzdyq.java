package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdyq implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzdyq(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzdyq zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdyq(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdyj((zzdxt) this.zza.zzb(), (zzdsv) this.zzb.zzb());
    }
}
