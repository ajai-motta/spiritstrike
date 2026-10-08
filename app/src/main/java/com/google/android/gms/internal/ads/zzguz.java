package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzguz {
    public static Executor zza() {
        return zzgtx.INSTANCE;
    }

    public static zzgus zzb(ExecutorService executorService) {
        if (executorService instanceof zzgus) {
            return (zzgus) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new zzguy((ScheduledExecutorService) executorService) : new zzguu(executorService);
    }

    public static zzgut zzc(ScheduledExecutorService scheduledExecutorService) {
        return new zzguy(scheduledExecutorService);
    }

    static Executor zzd(final Executor executor, final zzgtb zzgtbVar) {
        executor.getClass();
        return executor == zzgtx.INSTANCE ? executor : new Executor() { // from class: com.google.android.gms.internal.ads.zzguv
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                zzguz.zzf(executor, zzgtbVar, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void zzf(Executor executor, zzgtb zzgtbVar, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (RejectedExecutionException e) {
            zzgtbVar.zzb(e);
        }
    }
}
