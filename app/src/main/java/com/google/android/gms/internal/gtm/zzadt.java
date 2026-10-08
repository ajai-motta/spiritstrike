package com.google.android.gms.internal.gtm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzadt {
    public static final /* synthetic */ int zza = 0;
    private static final zzadt zzb = new zzadt();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzady zzc = new zzadd();

    private zzadt() {
    }

    public static zzadt zza() {
        return zzb;
    }

    public final zzadx zzb(Class cls) {
        zzaco.zzc(cls, "messageType");
        zzadx zzadxVarZza = (zzadx) this.zzd.get(cls);
        if (zzadxVarZza == null) {
            zzadxVarZza = this.zzc.zza(cls);
            zzaco.zzc(cls, "messageType");
            zzadx zzadxVar = (zzadx) this.zzd.putIfAbsent(cls, zzadxVarZza);
            if (zzadxVar != null) {
                return zzadxVar;
            }
        }
        return zzadxVarZza;
    }
}
