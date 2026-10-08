package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbhd {
    public static final zzbge zza = zzbge.zzb("gads:dynamite_load:fail:sample_rate", 10000);
    public static final zzbge zzb = zzbge.zza("gads:report_dynamite_crash_in_background_thread", false);
    public static final zzbge zzc = new zzbge("gads:public_beta:traffic_multiplier", "1.0", 4);
    public static final zzbge zzd = new zzbge("gads:sdk_crash_report_class_prefix", "com.google.", 4);
    public static final zzbge zze;
    public static final zzbge zzf;

    static {
        zzbge.zza("gads:sdk_crash_report_enabled", false);
        zze = zzbge.zza("gads:sdk_crash_report_full_stacktrace", false);
        zzf = zzbge.zzc("gads:trapped_exception_sample_rate", 0.01d);
    }
}
