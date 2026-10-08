package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgjg extends zzbal implements zzgji {
    zzgjg(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    @Override // com.google.android.gms.internal.ads.zzgji
    public final void zze(String str, Bundle bundle, zzgjk zzgjkVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzban.zzc(parcelZza, bundle);
        zzban.zze(parcelZza, zzgjkVar);
        zzdg(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzgji
    public final void zzf(Bundle bundle, zzgjk zzgjkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, bundle);
        zzban.zze(parcelZza, zzgjkVar);
        zzdg(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzgji
    public final void zzg(Bundle bundle, zzgjk zzgjkVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzban.zzc(parcelZza, bundle);
        zzban.zze(parcelZza, zzgjkVar);
        zzdg(3, parcelZza);
    }
}
