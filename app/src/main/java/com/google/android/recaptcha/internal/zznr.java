package com.google.android.recaptcha.internal;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zznr {
    private static String zza = "com.google.android.recaptcha.internal.zznv";
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.recaptcha.internal.zznv", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzov.zza();
    }

    public static long zzb() {
        return zznp.zza.zzc();
    }

    public static zznb zzd(String str) {
        return zznp.zza.zze(str);
    }

    public static zznd zzf() {
        return zzi().zza();
    }

    public static zznq zzg() {
        return zznp.zza.zzh();
    }

    public static zzof zzi() {
        return zznp.zza.zzj();
    }

    public static zzor zzk() {
        return zzi().zzc();
    }

    public static String zzl() {
        return zznp.zza.zzm();
    }

    public static boolean zzn(String str, Level level, boolean z) {
        zzi().zzd(str, level, z);
        return false;
    }

    protected long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    protected abstract zznb zze(String str);

    protected abstract zznq zzh();

    protected zzof zzj() {
        return zzof.zze();
    }

    protected abstract String zzm();
}
