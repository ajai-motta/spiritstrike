package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbal;
import com.google.android.gms.internal.ads.zzban;
import com.google.android.gms.internal.ads.zzbri;
import com.google.android.gms.internal.ads.zzbrj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcw extends zzbal implements zzcy {
    zzcw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final zzbrj getAdapterCreator() throws RemoteException {
        Parcel parcelZzde = zzde(2, zza());
        zzbrj zzbrjVarZzf = zzbri.zzf(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzbrjVarZzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcy
    public final zzfc getLiteSdkVersion() throws RemoteException {
        Parcel parcelZzde = zzde(1, zza());
        zzfc zzfcVar = (zzfc) zzban.zzb(parcelZzde, zzfc.CREATOR);
        parcelZzde.recycle();
        return zzfcVar;
    }
}
