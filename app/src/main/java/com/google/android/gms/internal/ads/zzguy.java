package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzguy extends zzguu implements zzgut {
    final ScheduledExecutorService zza;

    zzguy(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzgur schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgvh zzgvhVarZze = zzgvh.zze(runnable, null);
        return new zzguw(zzgvhVarZze, scheduledExecutorService.schedule(zzgvhVarZze, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzgur schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgvh zzgvhVar = new zzgvh(callable);
        return new zzguw(zzgvhVar, this.zza.schedule(zzgvhVar, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzgur scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgux zzguxVar = new zzgux(runnable);
        return new zzguw(zzguxVar, this.zza.scheduleAtFixedRate(zzguxVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgur scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzgux zzguxVar = new zzgux(runnable);
        return new zzguw(zzguxVar, this.zza.scheduleWithFixedDelay(zzguxVar, j, j2, timeUnit));
    }
}
