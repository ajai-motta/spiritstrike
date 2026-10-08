package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeei {
    private final zzbxd zza;

    zzeei(zzbxd zzbxdVar) {
        this.zza = zzbxdVar;
    }

    public final void zza() {
        ListenableFuture listenableFutureZza = this.zza.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziq)).booleanValue()) {
            zzcby.zzb(listenableFutureZza, "persistFlags");
        } else {
            zzcby.zza(listenableFutureZza, "persistFlags");
        }
    }
}
