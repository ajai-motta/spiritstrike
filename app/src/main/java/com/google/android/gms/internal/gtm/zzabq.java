package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzabq {
    static final zzabq zza = new zzabq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private static volatile zzabq zzd;
    private final Map zze;

    zzabq() {
        this.zze = new HashMap();
    }

    public static zzabq zza() {
        zzabq zzabqVar = zzd;
        if (zzabqVar != null) {
            return zzabqVar;
        }
        synchronized (zzabq.class) {
            zzabq zzabqVar2 = zzd;
            if (zzabqVar2 != null) {
                return zzabqVar2;
            }
            int i = zzadt.zza;
            zzabq zzabqVarZzb = zzaby.zzb(zzabq.class);
            zzd = zzabqVarZzb;
            return zzabqVarZzb;
        }
    }

    public zzace zzb(zzadl zzadlVar, int i) {
        return (zzace) this.zze.get(new zzabp(zzadlVar, i));
    }

    zzabq(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
