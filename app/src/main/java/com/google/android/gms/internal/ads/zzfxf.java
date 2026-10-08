package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfxf {
    public static ListenableFuture zza(Task task, CancellationTokenSource cancellationTokenSource) {
        final zzfxd zzfxdVar = new zzfxd(task, null);
        task.addOnCompleteListener(zzguz.zza(), new OnCompleteListener() { // from class: com.google.android.gms.internal.ads.zzfxe
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final /* synthetic */ void onComplete(Task task2) {
                zzfxd zzfxdVar2 = zzfxdVar;
                if (task2.isCanceled()) {
                    zzfxdVar2.cancel(false);
                    return;
                }
                if (task2.isSuccessful()) {
                    zzfxdVar2.zza(task2.getResult());
                    return;
                }
                Exception exception = task2.getException();
                if (exception == null) {
                    throw new IllegalStateException();
                }
                zzfxdVar2.zzb(exception);
            }
        });
        return zzfxdVar;
    }
}
