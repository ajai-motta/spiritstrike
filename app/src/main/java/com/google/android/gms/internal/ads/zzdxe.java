package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdxe extends zzbyu {
    final /* synthetic */ zzdxg zza;

    zzdxe(zzdxg zzdxgVar) {
        Objects.requireNonNull(zzdxgVar);
        this.zza = zzdxgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zze() throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzk(zzdxgVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zzf(int i) throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzl(zzdxgVar.zzd(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzl(zzdxgVar.zzd(), zzeVar.zza);
    }
}
