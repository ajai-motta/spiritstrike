package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class zzen {
    private static volatile Logger zza = new zzct();

    public static Logger zza() {
        return zza;
    }

    public static void zzb(String str, Object obj) {
        String str2;
        zzeo zzeoVarZza = zzeo.zza();
        if (zzeoVarZza != null) {
            zzeoVarZza.zzJ(str, obj);
        } else if (zzf(3)) {
            if (obj != null) {
                str2 = str + ":" + ((String) obj);
            } else {
                str2 = str;
            }
            Log.e((String) zzeh.zzb.zzb(), str2);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.error(str);
        }
    }

    public static void zzc(Logger logger) {
        zza = logger;
    }

    public static void zzd(String str) {
        zzeo zzeoVarZza = zzeo.zza();
        if (zzeoVarZza != null) {
            zzeoVarZza.zzN(str);
        } else if (zzf(0)) {
            Log.v((String) zzeh.zzb.zzb(), str);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    public static void zze(String str) {
        zzeo zzeoVarZza = zzeo.zza();
        if (zzeoVarZza != null) {
            zzeoVarZza.zzQ(str);
        } else if (zzf(2)) {
            Log.w((String) zzeh.zzb.zzb(), str);
        }
        Logger logger = zza;
        if (logger != null) {
            logger.warn(str);
        }
    }

    public static boolean zzf(int i) {
        return zza != null && zza.getLogLevel() <= i;
    }
}
