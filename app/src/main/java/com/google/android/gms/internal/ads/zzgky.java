package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgky implements ServiceConnection {
    final /* synthetic */ zzgle zza;

    /* synthetic */ zzgky(zzgle zzgleVar, byte[] bArr) {
        Objects.requireNonNull(zzgleVar);
        this.zza = zzgleVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        Object[] objArr = {componentName};
        zzgle zzgleVar = this.zza;
        zzgleVar.zzi().zza("LmdServiceConnectionManager.onServiceConnected(%s)", objArr);
        zzgleVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgkx
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzgji zzgjiVarZzb = zzgjh.zzb(iBinder);
                zzgky zzgkyVar = this.zza;
                zzgle zzgleVar2 = zzgkyVar.zza;
                zzgleVar2.zzn(zzgjiVarZzb);
                zzgleVar2.zzi().zza("linkToDeath", new Object[0]);
                try {
                    IInterface iInterfaceZzm = zzgleVar2.zzm();
                    iInterfaceZzm.getClass();
                    IInterface iInterface = iInterfaceZzm;
                    iInterfaceZzm.asBinder().linkToDeath(zzgleVar2.zzl(), 0);
                } catch (RemoteException e) {
                    zzgkyVar.zza.zzi().zzd(e, "linkToDeath failed", new Object[0]);
                }
                zzgle zzgleVar3 = zzgkyVar.zza;
                zzgleVar3.zzk(false);
                synchronized (zzgleVar3.zzj()) {
                    Iterator it = zzgleVar3.zzj().iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    zzgleVar3.zzj().clear();
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object[] objArr = {componentName};
        zzgle zzgleVar = this.zza;
        zzgleVar.zzi().zza("LmdServiceConnectionManager.onServiceDisconnected(%s)", objArr);
        zzgleVar.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgkw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzgle zzgleVar2 = this.zza.zza;
                zzgleVar2.zzi().zza("unlinkToDeath", new Object[0]);
                IInterface iInterfaceZzm = zzgleVar2.zzm();
                iInterfaceZzm.getClass();
                iInterfaceZzm.asBinder().unlinkToDeath(zzgleVar2.zzl(), 0);
                zzgleVar2.zzn(null);
                zzgleVar2.zzk(false);
            }
        });
    }
}
