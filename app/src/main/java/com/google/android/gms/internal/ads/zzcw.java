package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcw {
    private static Executor zza;

    public static synchronized Executor zza() {
        if (zza == null) {
            zza = zzep.zzf("ExoPlayer:BackgroundExecutor");
        }
        return zza;
    }
}
