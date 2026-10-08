package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzacy {
    zzacy() {
    }

    public static final List zza(Object obj, long j) {
        zzacn zzacnVar = (zzacn) zzaet.zzf(obj, j);
        if (zzacnVar.zzc()) {
            return zzacnVar;
        }
        int size = zzacnVar.size();
        zzacn zzacnVarZzd = zzacnVar.zzd(size == 0 ? 10 : size + size);
        zzaet.zzs(obj, j, zzacnVarZzd);
        return zzacnVarZzd;
    }
}
