package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzaem {
    private static volatile int zza = 100;

    zzaem() {
    }

    abstract Object zza(Object obj);

    abstract Object zzb();

    abstract Object zzc(Object obj);

    abstract void zzd(Object obj, int i, int i2);

    abstract void zze(Object obj, int i, long j);

    abstract void zzf(Object obj, int i, Object obj2);

    abstract void zzg(Object obj, int i, zzyx zzyxVar);

    abstract void zzh(Object obj, int i, long j);

    abstract void zzi(Object obj);

    abstract void zzj(Object obj, Object obj2);

    final boolean zzk(Object obj, zzadw zzadwVar, int i) throws IOException {
        int iZzd = zzadwVar.zzd();
        int i2 = iZzd >>> 3;
        int i3 = iZzd & 7;
        if (i3 == 0) {
            zzh(obj, i2, zzadwVar.zzl());
            return true;
        }
        if (i3 == 1) {
            zze(obj, i2, zzadwVar.zzk());
            return true;
        }
        if (i3 == 2) {
            zzg(obj, i2, zzadwVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw new zzacp("Protocol message tag had invalid wire type.");
            }
            zzd(obj, i2, zzadwVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            throw new zzacq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzadwVar.zzc() != Integer.MAX_VALUE && zzk(objZzb, zzadwVar, i5)) {
        }
        if ((i4 | 4) != zzadwVar.zzd()) {
            throw new zzacq("Protocol message end-group tag did not match expected tag.");
        }
        zzf(obj, i2, zzc(objZzb));
        return true;
    }
}
