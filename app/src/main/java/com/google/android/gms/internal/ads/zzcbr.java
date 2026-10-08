package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcbr extends ScheduledThreadPoolExecutor {
    zzcbr(int i, ThreadFactory threadFactory) {
        super(3, threadFactory);
    }
}
