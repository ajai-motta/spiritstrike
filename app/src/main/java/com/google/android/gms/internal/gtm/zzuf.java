package com.google.android.gms.internal.gtm;

import com.facebook.login.LoginLogger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzuf {
    public static final zzui zza = zzui.zza("cause", Throwable.class);

    static {
        zzui.zza("ratelimit_count", Integer.class);
        zzui.zza("sampling_count", Integer.class);
        zzui.zza("ratelimit_period", zzuc.class);
        zzui.zza(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, Integer.class);
        new zzud("group_by", Object.class, true);
        zzui.zza("forced", Boolean.class);
        new zzue("tags", zzwc.class, false);
        zzui.zza("stack_size", zzuj.class);
    }
}
