package com.google.android.recaptcha.internal;

import com.facebook.login.LoginLogger;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmu {
    public static final zzmx zza = zzmx.zza("cause", Throwable.class);

    static {
        zzmx.zza("ratelimit_count", Integer.class);
        zzmx.zza("sampling_count", Integer.class);
        zzmx.zza("ratelimit_period", zzmr.class);
        zzmx.zza(LoginLogger.EVENT_PARAM_METHOD_RESULT_SKIPPED, Integer.class);
        new zzms("group_by", Object.class, true);
        zzmx.zza("forced", Boolean.class);
        new zzmt("tags", zzor.class, false);
        zzmx.zza("stack_size", zzmy.class);
    }
}
