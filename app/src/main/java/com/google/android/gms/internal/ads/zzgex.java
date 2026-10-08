package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgex extends zzfrs {
    private final zzfzn zzb;

    zzgex(Context context, Executor executor, zzfzn zzfznVar) {
        super(context, executor, new TaskCompletionSource().getTask(), false);
        this.zzb = zzfznVar;
    }

    private static Task zzh() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(true);
        return taskCompletionSource.getTask();
    }

    @Override // com.google.android.gms.internal.ads.zzfrs
    public final Task zzb(int i, long j) {
        this.zzb.zzb(i, j, null, null);
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzfrs
    public final Task zzc(int i, long j, Exception exc) {
        this.zzb.zzb(i, j, exc, null);
        return zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzfrs
    public final Task zze(int i, String str) {
        this.zzb.zzb(i, -1L, null, str);
        return zzh();
    }
}
