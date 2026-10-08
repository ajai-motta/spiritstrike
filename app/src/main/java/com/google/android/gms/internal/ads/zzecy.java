package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzecy {
    private final zzcjn zza;
    private final Context zzb;
    private final Executor zzc;

    zzecy(zzcjn zzcjnVar, Context context, Executor executor) {
        this.zza = zzcjnVar;
        this.zzb = context;
        this.zzc = executor;
    }

    public final void zza() {
        this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzecx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzb();
            }
        });
    }

    final /* synthetic */ void zzb() {
        zzeda zzedaVarZzh = this.zza.zzh();
        zzedaVarZzh.zzb(this.zzb);
        zzedaVarZzh.zza().zza().zza();
    }
}
