package com.google.android.gms.internal.gtm;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzvc {
    private static String zza = "com.google.android.gms.internal.gtm.zzvg";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.gms.internal.gtm.zzvg", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzwg.zza();
    }

    public static long zzb() {
        return zzva.zza.zzc();
    }

    public static zzum zzd(String str) {
        return zzva.zza.zze(str);
    }

    public static zzuo zzf() {
        return zzi().zza();
    }

    public static zzvb zzg() {
        return zzva.zza.zzh();
    }

    public static zzvq zzi() {
        return zzva.zza.zzj();
    }

    public static zzwc zzk() {
        return zzi().zzc();
    }

    public static String zzl() {
        return zzva.zza.zzm();
    }

    public static boolean zzn(String str, Level level, boolean z) {
        zzi().zzd(str, level, z);
        return false;
    }

    protected long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    protected abstract zzum zze(String str);

    protected abstract zzvb zzh();

    protected zzvq zzj() {
        return zzvq.zze();
    }

    protected abstract String zzm();
}
