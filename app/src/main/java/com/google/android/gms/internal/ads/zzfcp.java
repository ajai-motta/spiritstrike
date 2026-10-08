package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfcp implements zzfiv {
    private final zzfdm zza;

    public zzfcp(zzfdm zzfdmVar) {
        this.zza = zzfdmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final ListenableFuture zza(zzfiw zzfiwVar) {
        zzfcs zzfcsVar = (zzfcs) zzfiwVar;
        return ((zzfco) this.zza).zzb(zzfcsVar.zzb, zzfcsVar.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final void zzb(zzfil zzfilVar) {
        zzfilVar.zza = ((zzfco) this.zza).zza();
    }
}
