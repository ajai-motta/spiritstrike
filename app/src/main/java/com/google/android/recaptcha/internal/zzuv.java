package com.google.android.recaptcha.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzuv {
    private static volatile int zza = 100;

    zzuv() {
    }

    abstract Object zza(Object obj);

    abstract Object zzb();

    abstract Object zzc(Object obj);

    abstract void zzd(Object obj, int i, int i2);

    abstract void zze(Object obj, int i, long j);

    abstract void zzf(Object obj, int i, Object obj2);

    abstract void zzg(Object obj, int i, zzqm zzqmVar);

    abstract void zzh(Object obj, int i, long j);

    abstract void zzi(Object obj);

    abstract void zzj(Object obj, Object obj2);

    final boolean zzk(Object obj, zzuf zzufVar, int i) throws IOException {
        int iZzd = zzufVar.zzd();
        int i2 = iZzd >>> 3;
        int i3 = iZzd & 7;
        if (i3 == 0) {
            zzh(obj, i2, zzufVar.zzl());
            return true;
        }
        if (i3 == 1) {
            zze(obj, i2, zzufVar.zzk());
            return true;
        }
        if (i3 == 2) {
            zzg(obj, i2, zzufVar.zzp());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                if (i != 0) {
                    return false;
                }
                throw new zzsx("Protocol message end-group tag did not match expected tag.");
            }
            if (i3 != 5) {
                throw new zzsw("Protocol message tag had invalid wire type.");
            }
            zzd(obj, i2, zzufVar.zzf());
            return true;
        }
        Object objZzb = zzb();
        int i4 = i2 << 3;
        int i5 = i + 1;
        if (i5 >= zza) {
            throw new zzsx("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzufVar.zzc() != Integer.MAX_VALUE && zzk(objZzb, zzufVar, i5)) {
        }
        if ((i4 | 4) != zzufVar.zzd()) {
            throw new zzsx("Protocol message end-group tag did not match expected tag.");
        }
        zzf(obj, i2, zzc(objZzb));
        return true;
    }
}
