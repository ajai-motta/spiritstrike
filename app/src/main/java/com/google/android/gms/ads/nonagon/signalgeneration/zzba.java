package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzifh;
import com.google.android.gms.internal.ads.zzifp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzba implements zzifh {
    private final zzay zza;

    private zzba(zzay zzayVar) {
        this.zza = zzayVar;
    }

    public static zzba zza(zzay zzayVar) {
        return new zzba(zzayVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        String strZzb = this.zza.zzb();
        zzifp.zzb(strZzb);
        return strZzb;
    }
}
