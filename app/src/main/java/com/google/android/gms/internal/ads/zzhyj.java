package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhyj {
    private static final zzhyj zza = new zzhyj();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzhys zzb = new zzhxq();

    private zzhyj() {
    }

    public static zzhyj zza() {
        return zza;
    }

    public final zzhyr zzb(Class cls) {
        zzhxb.zza(cls, "messageType");
        ConcurrentMap concurrentMap = this.zzc;
        zzhyr zzhyrVarZza = (zzhyr) concurrentMap.get(cls);
        if (zzhyrVarZza == null) {
            zzhyrVarZza = this.zzb.zza(cls);
            zzhxb.zza(cls, "messageType");
            zzhyr zzhyrVar = (zzhyr) concurrentMap.putIfAbsent(cls, zzhyrVarZza);
            if (zzhyrVar != null) {
                return zzhyrVar;
            }
        }
        return zzhyrVarZza;
    }
}
