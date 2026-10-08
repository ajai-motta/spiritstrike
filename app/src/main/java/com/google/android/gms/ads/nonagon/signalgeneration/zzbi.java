package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzeay;
import com.google.android.gms.internal.ads.zzfjn;
import com.google.android.gms.internal.ads.zzifh;
import com.google.android.gms.internal.ads.zzifq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbi implements zzifh {
    private final zzifq zza;

    private zzbi(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar2;
    }

    public static zzbi zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzbi(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzbh zzb() {
        return new zzbh(zzfjn.zzc(), ((zzeay) this.zza).zzb());
    }
}
