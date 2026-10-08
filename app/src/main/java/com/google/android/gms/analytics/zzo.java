package com.google.android.gms.analytics;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzo implements ThreadFactory {
    private static final AtomicInteger zza = new AtomicInteger();

    private zzo() {
        throw null;
    }

    /* synthetic */ zzo(zzq zzqVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new zzp(runnable, "measurement-" + zza.incrementAndGet());
    }
}
