package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzban;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbj extends zzbam implements zzbk {
    public zzbj() {
        super("com.google.android.gms.ads.internal.client.IAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    protected final boolean zzdi(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzb();
                break;
            case 2:
                int i3 = parcel.readInt();
                zzban.zzh(parcel);
                zzc(i3);
                break;
            case 3:
                break;
            case 4:
                zzf();
                break;
            case 5:
                zzg();
                break;
            case 6:
                zzh();
                break;
            case 7:
                zzj();
                break;
            case 8:
                zze zzeVar = (zze) zzban.zzb(parcel, zze.CREATOR);
                zzban.zzh(parcel);
                zzd(zzeVar);
                break;
            case 9:
                zzi();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
