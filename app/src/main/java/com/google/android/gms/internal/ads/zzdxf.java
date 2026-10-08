package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdxf extends zzbyq {
    final /* synthetic */ zzdxg zza;

    zzdxf(zzdxg zzdxgVar) {
        Objects.requireNonNull(zzdxgVar);
        this.zza = zzdxgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zze() throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzm(zzdxgVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzf() throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzo(zzdxgVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzg(zzbyl zzbylVar) throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzp(zzdxgVar.zzd(), zzbylVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzh(int i) throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzn(zzdxgVar.zzd(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzn(zzdxgVar.zzd(), zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzj() throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzq(zzdxgVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzbyr
    public final void zzk() throws RemoteException {
        zzdxg zzdxgVar = this.zza;
        zzdxgVar.zze().zzr(zzdxgVar.zzd());
    }
}
