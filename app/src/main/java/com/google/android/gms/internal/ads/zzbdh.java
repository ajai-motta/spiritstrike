package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbdh extends zzbal implements IInterface {
    zzbdh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzbdc zze(zzbdf zzbdfVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbdfVar);
        Parcel parcelZzde = zzde(1, parcelZza);
        zzbdc zzbdcVar = (zzbdc) zzban.zzb(parcelZzde, zzbdc.CREATOR);
        parcelZzde.recycle();
        return zzbdcVar;
    }

    public final zzbdc zzf(zzbdf zzbdfVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbdfVar);
        Parcel parcelZzde = zzde(2, parcelZza);
        zzbdc zzbdcVar = (zzbdc) zzban.zzb(parcelZzde, zzbdc.CREATOR);
        parcelZzde.recycle();
        return zzbdcVar;
    }

    public final long zzg(zzbdf zzbdfVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, zzbdfVar);
        Parcel parcelZzde = zzde(3, parcelZza);
        long j = parcelZzde.readLong();
        parcelZzde.recycle();
        return j;
    }
}
