package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzerd implements zzeya {
    private final zzgus zza;
    private final zzfgn zzb;
    private final zzcbn zzc;

    public zzerd(zzgus zzgusVar, zzfgn zzfgnVar, zzcbn zzcbnVar) {
        this.zza = zzgusVar;
        this.zzb = zzfgnVar;
        this.zzc = zzcbnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzerc
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 9;
    }

    final /* synthetic */ zzere zzc() {
        return new zzere(this.zzb.zzk, this.zzc.zzl());
    }
}
