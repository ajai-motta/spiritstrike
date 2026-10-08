package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzapj implements Executor {
    final /* synthetic */ Handler zza;

    zzapj(zzapl zzaplVar, Handler handler) {
        this.zza = handler;
        Objects.requireNonNull(zzaplVar);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
