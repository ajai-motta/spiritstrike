package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzbti extends IInterface {
    void zze(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbtl zzbtlVar) throws RemoteException;

    zzbtx zzf() throws RemoteException;

    zzbtx zzg() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzed zzh() throws RemoteException;

    void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbsw zzbswVar, zzbrp zzbrpVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException;

    void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbsz zzbszVar, zzbrp zzbrpVar) throws RemoteException;

    boolean zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbtf zzbtfVar, zzbrp zzbrpVar) throws RemoteException;

    boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar, zzbrp zzbrpVar) throws RemoteException;

    void zzo(String str) throws RemoteException;

    void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbtf zzbtfVar, zzbrp zzbrpVar) throws RemoteException;

    void zzq(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbsw zzbswVar, zzbrp zzbrpVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException;

    void zzr(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar, zzbrp zzbrpVar, zzbhx zzbhxVar) throws RemoteException;

    void zzs(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbst zzbstVar, zzbrp zzbrpVar) throws RemoteException;

    boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException;
}
