package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbjk extends zzbal implements zzbjm {
    zzbjk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zze(zzbjc zzbjcVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zze(parcelZza, zzbjcVar);
        parcelZza.writeString(str);
        zzdf(1, parcelZza);
    }
}
