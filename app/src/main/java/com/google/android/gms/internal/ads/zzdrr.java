package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdrr implements zzifh {
    private final zzifq zza;

    private zzdrr(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdrr zza(zzifq zzifqVar) {
        return new zzdrr(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((zzcyf) this.zza).zza().zzp.zza == 3 ? "rewarded_interstitial" : "rewarded";
    }
}
