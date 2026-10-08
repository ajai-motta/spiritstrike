package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbnb extends zzbal implements zzbnd {
    zzbnb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final zzbna zze(IObjectWrapper iObjectWrapper, zzbrj zzbrjVar, int i, zzbmx zzbmxVar) throws RemoteException {
        zzbna zzbmyVar;
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzban.zze(parcelZza, zzbrjVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        zzban.zze(parcelZza, zzbmxVar);
        Parcel parcelZzde = zzde(1, parcelZza);
        IBinder strongBinder = parcelZzde.readStrongBinder();
        if (strongBinder == null) {
            zzbmyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
            zzbmyVar = iInterfaceQueryLocalInterface instanceof zzbna ? (zzbna) iInterfaceQueryLocalInterface : new zzbmy(strongBinder);
        }
        parcelZzde.recycle();
        return zzbmyVar;
    }
}
