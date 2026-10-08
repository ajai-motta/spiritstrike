package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbfn extends zzbal implements zzbfp {
    zzbfn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbfp
    public final void zze(zzbfm zzbfmVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbfmVar);
        zzdf(1, parcelZza);
    }
}
