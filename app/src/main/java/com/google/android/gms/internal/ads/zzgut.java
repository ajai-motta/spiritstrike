package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzgut extends ScheduledExecutorService, zzgus {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzgut$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
    }

    zzgur zzd(Runnable runnable, long j, TimeUnit timeUnit);

    zzgur zze(Callable callable, long j, TimeUnit timeUnit);

    zzgur zzf(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    zzgur zzg(Runnable runnable, long j, long j2, TimeUnit timeUnit);
}
