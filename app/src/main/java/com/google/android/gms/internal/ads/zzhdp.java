package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhdp {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzhdp(Map map, Map map2, byte[] bArr) {
        this.zza = map;
        this.zzb = map2;
    }

    public static zzhdo zza() {
        return new zzhdo(null);
    }

    public final Enum zzb(Object obj) throws GeneralSecurityException {
        Enum r0 = (Enum) this.zzb.get(obj);
        if (r0 != null) {
            return r0;
        }
        String strValueOf = String.valueOf(obj);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(strValueOf)));
    }

    public final Object zzc(Enum r3) throws GeneralSecurityException {
        Object obj = this.zza.get(r3);
        if (obj != null) {
            return obj;
        }
        String strValueOf = String.valueOf(r3);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(strValueOf)));
    }
}
