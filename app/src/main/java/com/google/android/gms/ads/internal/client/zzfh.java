package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfh extends zzbp {
    final /* synthetic */ zzfi zza;

    /* synthetic */ zzfh(zzfi zzfiVar, byte[] bArr) {
        Objects.requireNonNull(zzfiVar);
        this.zza = zzfiVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zze(zzm zzmVar) throws RemoteException {
        zzi(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final String zzf() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final boolean zzg() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final String zzh() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbq
    public final void zzi(zzm zzmVar, int i) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.zzf("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzfg(this));
    }
}
