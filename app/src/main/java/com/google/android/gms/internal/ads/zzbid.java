package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbid extends zzbal implements zzbif {
    zzbid(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final float zze() throws RemoteException {
        Parcel parcelZzde = zzde(2, zza());
        float f = parcelZzde.readFloat();
        parcelZzde.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final IObjectWrapper zzg() throws RemoteException {
        Parcel parcelZzde = zzde(4, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final float zzh() throws RemoteException {
        Parcel parcelZzde = zzde(5, zza());
        float f = parcelZzde.readFloat();
        parcelZzde.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final float zzi() throws RemoteException {
        Parcel parcelZzde = zzde(6, zza());
        float f = parcelZzde.readFloat();
        parcelZzde.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final com.google.android.gms.ads.internal.client.zzed zzj() throws RemoteException {
        Parcel parcelZzde = zzde(7, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzedVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final boolean zzk() throws RemoteException {
        Parcel parcelZzde = zzde(8, zza());
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final boolean zzl() throws RemoteException {
        Parcel parcelZzde = zzde(10, zza());
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbif
    public final void zzm(zzbjq zzbjqVar) throws RemoteException {
        throw null;
    }
}
