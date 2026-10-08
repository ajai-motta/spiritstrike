package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdsz implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzdsz(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzdsz zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdsz(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdsy(((zzcnd) this.zza).zzb(), (zzdsv) this.zzb.zzb());
    }
}
