package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Deque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfhm {
    private final Deque zza = new LinkedBlockingDeque();
    private final Callable zzb;
    private final zzgus zzc;

    public zzfhm(Callable callable, zzgus zzgusVar) {
        this.zzb = callable;
        this.zzc = zzgusVar;
    }

    public final synchronized void zza(int i) {
        Deque deque = this.zza;
        int size = i - deque.size();
        for (int i2 = 0; i2 < size; i2++) {
            deque.add(this.zzc.zzc(this.zzb));
        }
    }

    public final synchronized ListenableFuture zzb() {
        zza(1);
        return (ListenableFuture) this.zza.poll();
    }

    public final synchronized void zzc(ListenableFuture listenableFuture) {
        this.zza.addFirst(listenableFuture);
    }
}
