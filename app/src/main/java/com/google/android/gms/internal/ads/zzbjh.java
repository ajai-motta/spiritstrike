package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbjh extends zzbal implements zzbjj {
    zzbjh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbjj
    public final void zze(zzbiz zzbizVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbizVar);
        zzdf(1, parcelZza);
    }
}
