package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzheu {
    private static final zzheu zzb = new zzheu();
    private final Map zza = new HashMap();

    public static zzheu zza() {
        return zzb;
    }

    public final synchronized void zzb(zzhet zzhetVar, Class cls) throws GeneralSecurityException {
        Map map = this.zza;
        zzhet zzhetVar2 = (zzhet) map.get(cls);
        if (zzhetVar2 != null && !zzhetVar2.equals(zzhetVar)) {
            throw new GeneralSecurityException("Different key creator for parameters class already inserted");
        }
        map.put(cls, zzhetVar);
    }
}
