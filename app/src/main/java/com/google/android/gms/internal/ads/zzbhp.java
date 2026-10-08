package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbhp extends zzbal implements IInterface {
    zzbhp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbwl zzbwlVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbwlVar);
        zzdf(1, parcelZza);
    }
}
