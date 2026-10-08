package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzezz implements zzeya {
    final zzgus zza;
    final List zzb;

    public zzezz(zzbee zzbeeVar, zzgus zzgusVar, List list) {
        this.zza = zzgusVar;
        this.zzb = list;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzezy
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzfaa(this.zza.zzb);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 48;
    }
}
