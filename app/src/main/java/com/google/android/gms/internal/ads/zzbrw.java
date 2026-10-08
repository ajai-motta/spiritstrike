package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbrw extends zzbal implements zzbry {
    zzbrw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final float zzA() throws RemoteException {
        Parcel parcelZzde = zzde(24, zza());
        float f = parcelZzde.readFloat();
        parcelZzde.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final float zzB() throws RemoteException {
        Parcel parcelZzde = zzde(25, zza());
        float f = parcelZzde.readFloat();
        parcelZzde.recycle();
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void zzC() throws RemoteException {
        zzdf(26, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final String zze() throws RemoteException {
        Parcel parcelZzde = zzde(2, zza());
        String string = parcelZzde.readString();
        parcelZzde.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final List zzf() throws RemoteException {
        Parcel parcelZzde = zzde(3, zza());
        ArrayList arrayListZzf = zzban.zzf(parcelZzde);
        parcelZzde.recycle();
        return arrayListZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final String zzg() throws RemoteException {
        Parcel parcelZzde = zzde(4, zza());
        String string = parcelZzde.readString();
        parcelZzde.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final zzbii zzh() throws RemoteException {
        Parcel parcelZzde = zzde(5, zza());
        zzbii zzbiiVarZzh = zzbih.zzh(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzbiiVarZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final String zzi() throws RemoteException {
        Parcel parcelZzde = zzde(6, zza());
        String string = parcelZzde.readString();
        parcelZzde.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final String zzj() throws RemoteException {
        Parcel parcelZzde = zzde(7, zza());
        String string = parcelZzde.readString();
        parcelZzde.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final double zzk() throws RemoteException {
        Parcel parcelZzde = zzde(8, zza());
        double d = parcelZzde.readDouble();
        parcelZzde.recycle();
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final String zzl() throws RemoteException {
        Parcel parcelZzde = zzde(9, zza());
        String string = parcelZzde.readString();
        parcelZzde.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final String zzm() throws RemoteException {
        Parcel parcelZzde = zzde(10, zza());
        String string = parcelZzde.readString();
        parcelZzde.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final com.google.android.gms.ads.internal.client.zzed zzn() throws RemoteException {
        Parcel parcelZzde = zzde(11, zza());
        com.google.android.gms.ads.internal.client.zzed zzedVarZzb = com.google.android.gms.ads.internal.client.zzec.zzb(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzedVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final zzbib zzo() throws RemoteException {
        Parcel parcelZzde = zzde(12, zza());
        zzbib zzbibVarZzj = zzbia.zzj(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzbibVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final IObjectWrapper zzp() throws RemoteException {
        Parcel parcelZzde = zzde(13, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final IObjectWrapper zzq() throws RemoteException {
        Parcel parcelZzde = zzde(14, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final IObjectWrapper zzr() throws RemoteException {
        Parcel parcelZzde = zzde(15, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final Bundle zzs() throws RemoteException {
        Parcel parcelZzde = zzde(16, zza());
        Bundle bundle = (Bundle) zzban.zzb(parcelZzde, Bundle.CREATOR);
        parcelZzde.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final boolean zzt() throws RemoteException {
        Parcel parcelZzde = zzde(17, zza());
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final boolean zzu() throws RemoteException {
        Parcel parcelZzde = zzde(18, zza());
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void zzv() throws RemoteException {
        zzdf(19, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void zzx(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzban.zze(parcelZza, iObjectWrapper2);
        zzban.zze(parcelZza, iObjectWrapper3);
        zzdf(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, iObjectWrapper);
        zzdf(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbry
    public final float zzz() throws RemoteException {
        Parcel parcelZzde = zzde(23, zza());
        float f = parcelZzde.readFloat();
        parcelZzde.recycle();
        return f;
    }
}
