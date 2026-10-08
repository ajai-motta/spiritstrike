package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzfkk {
    private static final ListenableFuture zza = zzgui.zza(null);
    private final zzgus zzb;
    private final ScheduledExecutorService zzc;
    private final zzfkl zzd;

    public zzfkk(zzgus zzgusVar, ScheduledExecutorService scheduledExecutorService, zzfkl zzfklVar) {
        this.zzb = zzgusVar;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfklVar;
    }

    public final zzfkj zza(Object obj, ListenableFuture listenableFuture) {
        return new zzfkj(this, obj, null, listenableFuture, Collections.singletonList(listenableFuture), listenableFuture, null);
    }

    public final zzfkb zzb(Object obj, ListenableFuture... listenableFutureArr) {
        return new zzfkb(this, obj, Arrays.asList(listenableFutureArr), null);
    }

    protected abstract String zzc(Object obj);

    final /* synthetic */ zzgus zze() {
        return this.zzb;
    }

    final /* synthetic */ ScheduledExecutorService zzf() {
        return this.zzc;
    }

    final /* synthetic */ zzfkl zzg() {
        return this.zzd;
    }
}
