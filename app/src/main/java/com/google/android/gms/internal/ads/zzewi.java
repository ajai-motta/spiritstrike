package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzewi implements zzeya {
    private final zzgus zza;
    private final zzdwl zzb;

    zzewi(zzgus zzgusVar, zzdwl zzdwlVar) {
        this.zza = zzgusVar;
        this.zzb = zzdwlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzewh
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 62;
    }

    final /* synthetic */ zzewj zzc() {
        return new zzewj(this.zzb.zzb());
    }
}
