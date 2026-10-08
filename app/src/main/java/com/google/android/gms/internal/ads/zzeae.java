package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeae implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzeae(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        this.zza = zzifqVar3;
        this.zzb = zzifqVar4;
    }

    public static zzeae zzc(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        return new zzeae(zzifqVar, zzifqVar2, zzifqVar3, zzifqVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzead zzb() {
        return new zzead(zzfjt.zzc(), zzfjn.zzc(), ((zzear) this.zza).zzb(), zzifg.zzc(this.zzb));
    }
}
