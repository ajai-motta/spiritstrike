package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzbcn extends IInterface {
    com.google.android.gms.ads.internal.client.zzbx zze() throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper, zzbcu zzbcuVar) throws RemoteException;

    com.google.android.gms.ads.internal.client.zzea zzg() throws RemoteException;

    void zzh(boolean z) throws RemoteException;

    void zzi(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException;

    String zzj() throws RemoteException;

    long zzk() throws RemoteException;

    void zzl(long j) throws RemoteException;
}
