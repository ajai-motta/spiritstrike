package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzbim extends IInterface {
    void zzb(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzc(String str) throws RemoteException;

    void zzd(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzdG(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzdH(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzdI(zzbif zzbifVar) throws RemoteException;

    void zze() throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, int i) throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper) throws RemoteException;
}
