package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzadg {
    zzadg() {
    }

    public static final boolean zza(Object obj) {
        return !((zzadf) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzadf zzadfVarZzb = (zzadf) obj;
        zzadf zzadfVar = (zzadf) obj2;
        if (!zzadfVar.isEmpty()) {
            if (!zzadfVarZzb.zze()) {
                zzadfVarZzb = zzadfVarZzb.zzb();
            }
            zzadfVarZzb.zzd(zzadfVar);
        }
        return zzadfVarZzb;
    }
}
