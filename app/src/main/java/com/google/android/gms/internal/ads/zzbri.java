package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbri extends zzbam implements zzbrj {
    public zzbri() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzbrj zzf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        return iInterfaceQueryLocalInterface instanceof zzbrj ? (zzbrj) iInterfaceQueryLocalInterface : new zzbrh(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    protected final boolean zzdi(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String string = parcel.readString();
            zzban.zzh(parcel);
            zzbrm zzbrmVarZzb = zzb(string);
            parcel2.writeNoException();
            zzban.zze(parcel2, zzbrmVarZzb);
        } else if (i == 2) {
            String string2 = parcel.readString();
            zzban.zzh(parcel);
            boolean zZzc = zzc(string2);
            parcel2.writeNoException();
            parcel2.writeInt(zZzc ? 1 : 0);
        } else if (i == 3) {
            String string3 = parcel.readString();
            zzban.zzh(parcel);
            zzbti zzbtiVarZze = zze(string3);
            parcel2.writeNoException();
            zzban.zze(parcel2, zzbtiVarZze);
        } else {
            if (i != 4) {
                return false;
            }
            String string4 = parcel.readString();
            zzban.zzh(parcel);
            boolean zZzd = zzd(string4);
            parcel2.writeNoException();
            parcel2.writeInt(zZzd ? 1 : 0);
        }
        return true;
    }
}
