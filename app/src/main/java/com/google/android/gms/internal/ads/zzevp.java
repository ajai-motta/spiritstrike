package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzevp implements zzeya {
    private final zzgus zza;
    private final zzdyo zzb;

    zzevp(zzgus zzgusVar, zzdyo zzdyoVar) {
        this.zza = zzgusVar;
        this.zzb = zzdyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final ListenableFuture zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzevo
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 23;
    }

    final /* synthetic */ zzevq zzc() {
        zzdyo zzdyoVar = this.zzb;
        return new zzevq(zzdyoVar.zzg(), zzdyoVar.zzd(), com.google.android.gms.ads.internal.zzt.zzo().zzk(), zzdyoVar.zzq(), zzdyoVar.zzm());
    }
}
