package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzapl {
    private final Executor zza;

    public zzapl(Handler handler) {
        this.zza = new zzapj(this, handler);
    }

    public final void zza(zzapu zzapuVar, zzaqa zzaqaVar, Runnable runnable) {
        zzapuVar.zzp();
        zzapuVar.zzc("post-response");
        ((zzapj) this.zza).zza.post(new zzapk(zzapuVar, zzaqaVar, runnable));
    }

    public final void zzb(zzapu zzapuVar, zzaqd zzaqdVar) {
        zzapuVar.zzc("post-error");
        ((zzapj) this.zza).zza.post(new zzapk(zzapuVar, zzaqa.zzb(zzaqdVar), null));
    }
}
