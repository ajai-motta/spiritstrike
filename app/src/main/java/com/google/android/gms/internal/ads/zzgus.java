package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzgus extends ExecutorService {

    /* JADX INFO: renamed from: com.google.android.gms.internal.ads.zzgus$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
    public final /* synthetic */ class CC {
    }

    ListenableFuture zza(Runnable runnable);

    ListenableFuture zzb(Runnable runnable, Object obj);

    ListenableFuture zzc(Callable callable);
}
