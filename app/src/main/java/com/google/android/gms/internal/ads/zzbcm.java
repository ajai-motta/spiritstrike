package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbcm extends zzbam implements zzbcn {
    public zzbcm() {
        super("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public static zzbcn zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
        return iInterfaceQueryLocalInterface instanceof zzbcn ? (zzbcn) iInterfaceQueryLocalInterface : new zzbcl(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    protected final boolean zzdi(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbcu zzbcsVar;
        switch (i) {
            case 2:
                com.google.android.gms.ads.internal.client.zzbx zzbxVarZze = zze();
                parcel2.writeNoException();
                zzban.zze(parcel2, zzbxVarZze);
                return true;
            case 3:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenAdPresentationCallback");
                    if (iInterfaceQueryLocalInterface instanceof zzbcr) {
                    }
                }
                zzban.zzh(parcel);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 == null) {
                    zzbcsVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
                    zzbcsVar = iInterfaceQueryLocalInterface2 instanceof zzbcu ? (zzbcu) iInterfaceQueryLocalInterface2 : new zzbcs(strongBinder2);
                }
                zzban.zzh(parcel);
                zzf(iObjectWrapperAsInterface, zzbcsVar);
                parcel2.writeNoException();
                return true;
            case 5:
                com.google.android.gms.ads.internal.client.zzea zzeaVarZzg = zzg();
                parcel2.writeNoException();
                zzban.zze(parcel2, zzeaVarZzg);
                return true;
            case 6:
                boolean zZza = zzban.zza(parcel);
                zzban.zzh(parcel);
                zzh(zZza);
                parcel2.writeNoException();
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzdt zzdtVarZzb = com.google.android.gms.ads.internal.client.zzds.zzb(parcel.readStrongBinder());
                zzban.zzh(parcel);
                zzi(zzdtVarZzb);
                parcel2.writeNoException();
                return true;
            case 8:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 9:
                long jZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeLong(jZzk);
                return true;
            case 10:
                long j = parcel.readLong();
                zzban.zzh(parcel);
                zzl(j);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
