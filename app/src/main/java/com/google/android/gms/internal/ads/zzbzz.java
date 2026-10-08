package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbzz implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzbzz(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzbzz zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzbzz(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbzy zzb() {
        return new zzbzy((Clock) this.zza.zzb(), (zzbzw) this.zzb.zzb());
    }
}
