package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbig extends zzbal implements zzbii {
    zzbig(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final IObjectWrapper zzb() throws RemoteException {
        Parcel parcelZzde = zzde(1, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final Uri zzc() throws RemoteException {
        Parcel parcelZzde = zzde(2, zza());
        Uri uri = (Uri) zzban.zzb(parcelZzde, Uri.CREATOR);
        parcelZzde.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final double zzd() throws RemoteException {
        Parcel parcelZzde = zzde(3, zza());
        double d = parcelZzde.readDouble();
        parcelZzde.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final int zze() throws RemoteException {
        Parcel parcelZzde = zzde(4, zza());
        int i = parcelZzde.readInt();
        parcelZzde.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final int zzf() throws RemoteException {
        Parcel parcelZzde = zzde(5, zza());
        int i = parcelZzde.readInt();
        parcelZzde.recycle();
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbii
    public final Map zzg() throws RemoteException {
        Parcel parcelZzde = zzde(6, zza());
        HashMap mapZzg = zzban.zzg(parcelZzde);
        parcelZzde.recycle();
        return mapZzg;
    }
}
