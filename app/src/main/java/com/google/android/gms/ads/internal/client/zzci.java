package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbal;
import com.google.android.gms.internal.ads.zzban;
import com.google.android.gms.internal.ads.zzbcm;
import com.google.android.gms.internal.ads.zzbcn;
import com.google.android.gms.internal.ads.zzbrj;
import com.google.android.gms.internal.ads.zzbyn;
import com.google.android.gms.internal.ads.zzbyo;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzci extends zzbal implements zzck {
    zzci(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdPreloader");
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zze(List list, zzce zzceVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzban.zze(parcelZza, zzceVar);
        zzdf(1, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzf(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(2, parcelZza);
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbyo zzg(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(3, parcelZza);
        zzbyo zzbyoVarZzt = zzbyn.zzt(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzbyoVarZzt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzh(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(4, parcelZza);
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbcn zzi(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(5, parcelZza);
        zzbcn zzbcnVarZzb = zzbcm.zzb(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzbcnVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzj(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(6, parcelZza);
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbx zzk(String str) throws RemoteException {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(7, parcelZza);
        IBinder strongBinder = parcelZzde.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzde.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zzl(zzbrj zzbrjVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbrjVar);
        zzdf(8, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzm(String str, zzft zzftVar, zzch zzchVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzban.zzc(parcelZza, zzftVar);
        zzban.zze(parcelZza, zzchVar);
        Parcel parcelZzde = zzde(9, parcelZza);
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzn(int i, String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(10, parcelZza);
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbx zzo(String str) throws RemoteException {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(11, parcelZza);
        IBinder strongBinder = parcelZzde.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzde.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbcn zzp(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(12, parcelZza);
        zzbcn zzbcnVarZzb = zzbcm.zzb(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzbcnVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzbyo zzq(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(13, parcelZza);
        zzbyo zzbyoVarZzt = zzbyn.zzt(parcelZzde.readStrongBinder());
        parcelZzde.recycle();
        return zzbyoVarZzt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final zzft zzr(int i, String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(14, parcelZza);
        zzft zzftVar = (zzft) zzban.zzb(parcelZzde, zzft.CREATOR);
        parcelZzde.recycle();
        return zzftVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final Bundle zzs(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        Parcel parcelZzde = zzde(15, parcelZza);
        Bundle bundle = (Bundle) zzban.zzb(parcelZzde, Bundle.CREATOR);
        parcelZzde.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final int zzt(int i, String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(16, parcelZza);
        int i2 = parcelZzde.readInt();
        parcelZzde.recycle();
        return i2;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final boolean zzu(int i, String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        parcelZza.writeString(str);
        Parcel parcelZzde = zzde(17, parcelZza);
        boolean zZza = zzban.zza(parcelZzde);
        parcelZzde.recycle();
        return zZza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzck
    public final void zzv(int i) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i);
        zzdf(18, parcelZza);
    }
}
