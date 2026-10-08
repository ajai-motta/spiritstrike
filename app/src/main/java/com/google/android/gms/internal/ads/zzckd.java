package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzckd implements zzifh {
    private final zzifq zza;

    private zzckd(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
    }

    public static zzckd zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzckd(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbU)).booleanValue() ? Collections.singleton(new zzdgn((zzdxv) this.zza.zzb(), zzfjn.zzc())) : Collections.emptySet();
        zzifp.zzb(setSingleton);
        return setSingleton;
    }
}
