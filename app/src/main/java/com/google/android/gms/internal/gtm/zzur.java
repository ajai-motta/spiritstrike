package com.google.android.gms.internal.gtm;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzur {
    private static final zzuu zza = new zzup();
    private static final zzut zzb = new zzuq();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();

    /* synthetic */ zzur(zzuu zzuuVar, zzuv zzuvVar) {
    }

    public final zzuw zza() {
        return new zzus(this, null);
    }

    final void zzd(zzui zzuiVar) {
        zzwe.zza(zzuiVar, "key");
        if (!zzuiVar.zzb()) {
            zzuu zzuuVar = zza;
            zzwe.zza(zzuiVar, "key");
            this.zzd.remove(zzuiVar);
            this.zzc.put(zzuiVar, zzuuVar);
            return;
        }
        zzut zzutVar = zzb;
        zzwe.zza(zzuiVar, "key");
        if (!zzuiVar.zzb()) {
            throw new IllegalArgumentException("key must be repeating");
        }
        this.zzc.remove(zzuiVar);
        this.zzd.put(zzuiVar, zzutVar);
    }
}
