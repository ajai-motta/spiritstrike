package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdvn;
import com.google.android.gms.internal.ads.zzifh;
import com.google.android.gms.internal.ads.zzifq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzy implements zzifh {
    private final zzifq zza;

    private zzy(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzy zza(zzifq zzifqVar) {
        return new zzy(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzv((zzdvn) this.zza.zzb());
    }
}
