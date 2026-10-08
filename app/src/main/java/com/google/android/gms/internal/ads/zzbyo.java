package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzbyo extends IInterface {
    void zzb(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzc(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbyv zzbyvVar) throws RemoteException;

    void zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, zzbyv zzbyvVar) throws RemoteException;

    void zze(zzbyr zzbyrVar) throws RemoteException;

    void zzf(com.google.android.gms.ads.internal.client.zzdq zzdqVar) throws RemoteException;

    Bundle zzg() throws RemoteException;

    void zzh(zzbzc zzbzcVar) throws RemoteException;

    boolean zzi() throws RemoteException;

    String zzj() throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    zzbyl zzl() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzea zzm() throws RemoteException;

    String zzn() throws RemoteException;

    void zzo(com.google.android.gms.ads.internal.client.zzdt zzdtVar) throws RemoteException;

    void zzp(boolean z) throws RemoteException;

    long zzq() throws RemoteException;

    void zzr(long j) throws RemoteException;

    void zzs(zzbyw zzbywVar) throws RemoteException;
}
