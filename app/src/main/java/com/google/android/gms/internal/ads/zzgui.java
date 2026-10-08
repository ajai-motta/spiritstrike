package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgui extends zzguk {
    public static ListenableFuture zza(Object obj) {
        return obj == null ? zzgum.zza : new zzgum(obj);
    }

    public static ListenableFuture zzb() {
        return zzgum.zza;
    }

    public static ListenableFuture zzd(Callable callable, Executor executor) {
        zzgvh zzgvhVar = new zzgvh(callable);
        executor.execute(zzgvhVar);
        return zzgvhVar;
    }

    public static ListenableFuture zze(Runnable runnable, Executor executor) {
        zzgvh zzgvhVarZze = zzgvh.zze(runnable, null);
        executor.execute(zzgvhVarZze);
        return zzgvhVarZze;
    }

    public static ListenableFuture zzf(zzgtp zzgtpVar, Executor executor) {
        zzgvh zzgvhVar = new zzgvh(zzgtpVar);
        executor.execute(zzgvhVar);
        return zzgvhVar;
    }

    public static ListenableFuture zzg(ListenableFuture listenableFuture, Class cls, zzglu zzgluVar, Executor executor) {
        int i = zzgta.zzd;
        zzgsz zzgszVar = new zzgsz(listenableFuture, cls, zzgluVar);
        listenableFuture.addListener(zzgszVar, zzguz.zzd(executor, zzgszVar));
        return zzgszVar;
    }

    public static ListenableFuture zzh(ListenableFuture listenableFuture, Class cls, zzgtq zzgtqVar, Executor executor) {
        int i = zzgta.zzd;
        zzgsy zzgsyVar = new zzgsy(listenableFuture, cls, zzgtqVar);
        listenableFuture.addListener(zzgsyVar, zzguz.zzd(executor, zzgsyVar));
        return zzgsyVar;
    }

    public static ListenableFuture zzi(ListenableFuture listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : zzgve.zze(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static ListenableFuture zzj(ListenableFuture listenableFuture, zzgtq zzgtqVar, Executor executor) {
        int i = zzgth.zzc;
        zzgtf zzgtfVar = new zzgtf(listenableFuture, zzgtqVar);
        listenableFuture.addListener(zzgtfVar, zzguz.zzd(executor, zzgtfVar));
        return zzgtfVar;
    }

    public static ListenableFuture zzk(ListenableFuture listenableFuture, zzglu zzgluVar, Executor executor) {
        int i = zzgth.zzc;
        zzgtg zzgtgVar = new zzgtg(listenableFuture, zzgluVar);
        listenableFuture.addListener(zzgtgVar, zzguz.zzd(executor, zzgtgVar));
        return zzgtgVar;
    }

    @SafeVarargs
    public static ListenableFuture zzl(ListenableFuture... listenableFutureArr) {
        return new zzgtr(zzgpe.zzr(listenableFutureArr), true);
    }

    public static ListenableFuture zzm(Iterable iterable) {
        return new zzgtr(zzgpe.zzp(iterable), true);
    }

    public static zzguh zzn(Iterable iterable) {
        return new zzguh(false, zzgpe.zzp(iterable), null);
    }

    @SafeVarargs
    public static zzguh zzo(ListenableFuture... listenableFutureArr) {
        return new zzguh(true, zzgpe.zzr(listenableFutureArr), null);
    }

    public static zzguh zzp(Iterable iterable) {
        return new zzguh(true, zzgpe.zzp(iterable), null);
    }

    @SafeVarargs
    public static ListenableFuture zzq(ListenableFuture... listenableFutureArr) {
        return new zzgtr(zzgpe.zzr(listenableFutureArr), false);
    }

    public static Object zzs(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgvj.zza(future);
        }
        throw new IllegalStateException(zzgmu.zzd("Future was expected to be done: %s", future));
    }

    public static Object zzt(Future future) {
        try {
            return zzgvj.zza(future);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof Error) {
                throw new zzgty((Error) e.getCause());
            }
            throw new zzgvi(e.getCause());
        }
    }

    public static ListenableFuture zzc(Throwable th) {
        th.getClass();
        return new zzgul(th);
    }

    public static void zzr(ListenableFuture listenableFuture, zzguf zzgufVar, Executor executor) {
        zzgufVar.getClass();
        listenableFuture.addListener(new zzgug(listenableFuture, zzgufVar), executor);
    }
}
