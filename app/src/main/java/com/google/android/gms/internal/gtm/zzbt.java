package com.google.android.gms.internal.gtm;

import java.lang.Thread;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbt implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzbu zza;

    zzbt(zzbu zzbuVar) {
        this.zza = zzbuVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzeo zzeoVarZzn = this.zza.zzn();
        if (zzeoVarZzn != null) {
            zzeoVarZzn.zzJ("Job execution failed", th);
        }
    }
}
