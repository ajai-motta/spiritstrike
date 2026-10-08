package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbhi {
    public static final zzbge zza;

    static {
        zzbge.zzb("gads:ad_loader:timeout_ms", 60000L);
        zza = zzbge.zzb("gads:rendering:timeout_ms", 60000L);
        zzbge.zzb("gads:resolve_future:default_timeout_ms", WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS);
    }
}
