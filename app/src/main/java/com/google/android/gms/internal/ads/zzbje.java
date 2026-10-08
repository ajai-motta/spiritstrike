package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbje extends zzbal implements zzbjg {
    zzbje(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbjg
    public final void zze(zzbix zzbixVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbixVar);
        zzdf(1, parcelZza);
    }
}
