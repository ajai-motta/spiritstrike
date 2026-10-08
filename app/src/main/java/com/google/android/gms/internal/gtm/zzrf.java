package com.google.android.gms.internal.gtm;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrf {
    private final Map zza = new HashMap();
    private zzap zzb;

    private zzrf() {
    }

    public final zzre zza() {
        return new zzre(this.zza, this.zzb, null);
    }

    public final zzrf zzb(String str, zzap zzapVar) {
        this.zza.put(str, zzapVar);
        return this;
    }

    public final zzrf zzc(zzap zzapVar) {
        this.zzb = zzapVar;
        return this;
    }

    /* synthetic */ zzrf(zzrl zzrlVar) {
    }
}
