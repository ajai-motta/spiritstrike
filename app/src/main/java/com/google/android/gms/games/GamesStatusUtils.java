package com.google.android.gms.games;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class GamesStatusUtils {
    private GamesStatusUtils() {
    }

    public static void zza(TaskCompletionSource taskCompletionSource, SecurityException securityException) {
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(new ApiException(GamesClientStatusCodes.zza(4)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void zzb(com.google.android.gms.tasks.TaskCompletionSource r4, int r5) {
        /*
            Method dump skipped, instruction units count: 658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.GamesStatusUtils.zzb(com.google.android.gms.tasks.TaskCompletionSource, int):void");
    }
}
