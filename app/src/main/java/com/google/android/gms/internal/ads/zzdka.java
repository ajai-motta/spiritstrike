package com.google.android.gms.internal.ads;

import com.adxcorp.ads.mediation.util.ReportUtil;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdka implements zzifh {
    private final zzifq zza;

    private zzdka(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdka zza(zzifq zzifqVar) {
        return new zzdka(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((zzdjx) this.zza).zza().zzd() != null ? Collections.singleton(ReportUtil.INVENTORY_TYPE_BANNER) : Collections.emptySet();
        zzifp.zzb(setSingleton);
        return setSingleton;
    }
}
