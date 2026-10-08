package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbpz implements zzcce {
    final /* synthetic */ zzbqa zza;

    zzbpz(zzbqa zzbqaVar) {
        Objects.requireNonNull(zzbqaVar);
        this.zza = zzbqaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        final zzbow zzbowVar = (zzbow) obj;
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbpy
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzbow zzbowVar2 = zzbowVar;
                zzbowVar2.zzn("/result", zzblw.zzo);
                zzbowVar2.zzj();
            }
        });
    }
}
