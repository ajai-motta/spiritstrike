package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbwv extends zzbal implements zzbwx {
    zzbwv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zze(zzbxj zzbxjVar, zzbxb zzbxbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbxjVar);
        zzban.zze(parcelZza, zzbxbVar);
        zzdf(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzf(zzbxj zzbxjVar, zzbxb zzbxbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbxjVar);
        zzban.zze(parcelZza, zzbxbVar);
        zzdf(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzg(zzbxj zzbxjVar, zzbxb zzbxbVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbxjVar);
        zzban.zze(parcelZza, zzbxbVar);
        zzdf(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzh(String str, zzbxb zzbxbVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzban.zze(parcelZza, zzbxbVar);
        zzdf(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzi(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdf(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzj(zzbwt zzbwtVar, zzbxc zzbxcVar) throws RemoteException {
        throw null;
    }
}
