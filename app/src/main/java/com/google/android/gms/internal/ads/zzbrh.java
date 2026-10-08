package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbrh extends zzbal implements zzbrj {
    zzbrh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final zzbrm zzb(String str) throws RemoteException {
        zzbrm zzbrkVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(1, parcelZza);
        IBinder strongBinder = parcelZzde.readStrongBinder();
        if (strongBinder == null) {
            zzbrkVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzbrkVar = iInterfaceQueryLocalInterface instanceof zzbrm ? (zzbrm) iInterfaceQueryLocalInterface : new zzbrk(strongBinder);
        }
        parcelZzde.recycle();
        return zzbrkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final boolean zzc(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(2, parcelZza);
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final boolean zzd(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(4, parcelZza);
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbrj
    public final zzbti zze(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(3, parcelZza);
        zzbti zzbtiVarZzb = zzbth.zzb(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzbtiVarZzb;
    }
}
