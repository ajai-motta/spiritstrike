package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbxa extends zzbam implements zzbxb {
    public zzbxa() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    protected final boolean zzdi(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzban.zzb(parcel, ParcelFileDescriptor.CREATOR);
            zzban.zzh(parcel);
            zze(parcelFileDescriptor);
        } else if (i == 2) {
            com.google.android.gms.ads.internal.util.zzba zzbaVar = (com.google.android.gms.ads.internal.util.zzba) zzban.zzb(parcel, com.google.android.gms.ads.internal.util.zzba.CREATOR);
            zzban.zzh(parcel);
            zzf(zzbaVar);
        } else {
            if (i != 3) {
                return false;
            }
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) zzban.zzb(parcel, ParcelFileDescriptor.CREATOR);
            zzbxj zzbxjVar = (zzbxj) zzban.zzb(parcel, zzbxj.CREATOR);
            zzban.zzh(parcel);
            zzg(parcelFileDescriptor2, zzbxjVar);
        }
        parcel2.writeNoException();
        return true;
    }
}
