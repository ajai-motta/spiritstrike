package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcje extends Thread {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzcjf zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcje(zzcjf zzcjfVar, Runnable runnable, String str, Runnable runnable2) {
        super(runnable, str);
        this.zza = runnable2;
        Objects.requireNonNull(zzcjfVar);
        this.zzb = zzcjfVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.zzb.zza());
        this.zza.run();
    }
}
