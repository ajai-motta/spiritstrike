package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzexw implements zzeya {
    private final zzgus zza;
    private final Context zzb;

    zzexw(zzgus zzgusVar, Context context) {
        this.zza = zzgusVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzexv
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 37;
    }

    final /* synthetic */ zzexu zzc() {
        return new zzexu(com.google.android.gms.ads.internal.util.zzac.zzb(this.zzb, (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgH)));
    }
}
