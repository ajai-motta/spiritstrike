package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhxu {
    zzhxu() {
    }

    public static final boolean zza(Object obj) {
        return !((zzhxt) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzhxt zzhxtVarZzc = (zzhxt) obj;
        zzhxt zzhxtVar = (zzhxt) obj2;
        if (!zzhxtVar.isEmpty()) {
            if (!zzhxtVarZzc.zze()) {
                zzhxtVarZzc = zzhxtVarZzc.zzc();
            }
            zzhxtVarZzc.zzb(zzhxtVar);
        }
        return zzhxtVarZzc;
    }
}
