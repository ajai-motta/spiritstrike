package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zztn {
    zztn() {
    }

    public static final boolean zza(Object obj) {
        return !((zztm) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zztm zztmVarZzb = (zztm) obj;
        zztm zztmVar = (zztm) obj2;
        if (!zztmVar.isEmpty()) {
            if (!zztmVarZzb.zze()) {
                zztmVarZzb = zztmVarZzb.zzb();
            }
            zztmVarZzb.zzd(zztmVar);
        }
        return zztmVarZzb;
    }
}
