package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzeka extends zzbtb {
    final /* synthetic */ zzekb zza;
    private final zzehn zzb;

    /* synthetic */ zzeka(zzekb zzekbVar, zzehn zzehnVar, byte[] bArr) {
        Objects.requireNonNull(zzekbVar);
        this.zza = zzekbVar;
        this.zzb = zzehnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zze(zzbry zzbryVar) throws RemoteException {
        this.zza.zzc(zzbryVar);
        ((zzeiz) this.zzb.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzf(String str) throws RemoteException {
        ((zzeiz) this.zzb.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzeiz) this.zzb.zzc).zzx(zzeVar);
    }
}
