package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdvw implements zzifh {
    private final zzifq zza;

    private zzdvw(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdvw zza(zzifq zzifqVar) {
        return new zzdvw(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdvv((Clock) this.zza.zzb());
    }
}
