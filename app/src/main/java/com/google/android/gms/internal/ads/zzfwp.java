package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfwp implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzfwp(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar3;
    }

    public static zzfwp zzc(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        return new zzfwp(zzifqVar, zzifqVar2, zzifqVar3, zzifqVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfwo zzb() {
        return new zzfwo((DataStore) this.zza.zzb(), zzcjx.zzc(), (zzdss) this.zzb.zzb(), new zzfvq());
    }
}
