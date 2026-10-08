package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzbxb extends IInterface {
    @Deprecated
    void zze(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zzf(com.google.android.gms.ads.internal.util.zzba zzbaVar) throws RemoteException;

    void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbxj zzbxjVar) throws RemoteException;
}
