package com.google.android.recaptcha.internal;

import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvj {
    static {
        zzrt zzrtVarZzi = zzrv.zzi();
        zzrtVarZzi.zzf(-315576000000L);
        zzrtVarZzi.zze(-999999999);
        zzrt zzrtVarZzi2 = zzrv.zzi();
        zzrtVarZzi2.zzf(315576000000L);
        zzrtVarZzi2.zze(999999999);
        zzrt zzrtVarZzi3 = zzrv.zzi();
        zzrtVarZzi3.zzf(0L);
        zzrtVarZzi3.zze(0);
    }

    public static zzrv zza(long j) {
        int i = (int) (j % C.NANOS_PER_SECOND);
        long jZza = j / C.NANOS_PER_SECOND;
        if (i <= -1000000000 || i >= 1000000000) {
            jZza = zzps.zza(jZza, i / 1000000000);
            i %= 1000000000;
        }
        if (jZza > 0 && i < 0) {
            i += 1000000000;
            jZza--;
        }
        if (jZza < 0 && i > 0) {
            i -= 1000000000;
            jZza++;
        }
        zzrt zzrtVarZzi = zzrv.zzi();
        zzrtVarZzi.zzf(jZza);
        zzrtVarZzi.zze(i);
        zzrv zzrvVar = (zzrv) zzrtVarZzi.zzk();
        long jZzg = zzrvVar.zzg();
        int iZzf = zzrvVar.zzf();
        if (jZzg < -315576000000L || jZzg > 315576000000L || iZzf < -999999999 || iZzf >= 1000000000 || ((jZzg < 0 || iZzf < 0) && (jZzg > 0 || iZzf > 0))) {
            throw new IllegalArgumentException(zzmg.zza("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", Long.valueOf(jZzg), Integer.valueOf(iZzf)));
        }
        return zzrvVar;
    }
}
