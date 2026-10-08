package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzcas extends IInterface {
    void zze(IObjectWrapper iObjectWrapper, zzcaw zzcawVar, zzcap zzcapVar) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzg(List list, IObjectWrapper iObjectWrapper, zzbvx zzbvxVar) throws RemoteException;

    void zzh(List list, IObjectWrapper iObjectWrapper, zzbvx zzbvxVar) throws RemoteException;

    void zzi(zzbwa zzbwaVar) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(List list, IObjectWrapper iObjectWrapper, zzbvx zzbvxVar) throws RemoteException;

    void zzl(List list, IObjectWrapper iObjectWrapper, zzbvx zzbvxVar) throws RemoteException;

    IObjectWrapper zzm(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException;
}
