package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdrq implements zzifh {
    private final zzifq zza;

    private zzdrq(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdrq zza(zzifq zzifqVar) {
        return new zzdrq(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbdz.zza.EnumC0303zza enumC0303zza = ((zzcyf) this.zza).zza().zzp.zza == 3 ? zzbdz.zza.EnumC0303zza.REWARDED_INTERSTITIAL : zzbdz.zza.EnumC0303zza.REWARD_BASED_VIDEO_AD;
        zzifp.zzb(enumC0303zza);
        return enumC0303zza;
    }
}
