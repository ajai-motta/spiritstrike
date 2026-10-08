package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcvf implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzcvf(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzcvf zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzcvf(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcve((Clock) this.zza.zzb(), (zzcbd) this.zzb.zzb());
    }
}
