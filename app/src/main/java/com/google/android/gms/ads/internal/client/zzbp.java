package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbam;
import com.google.android.gms.internal.ads.zzban;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbp extends zzbam implements zzbq {
    public zzbp() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    protected final boolean zzdi(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzm zzmVar = (zzm) zzban.zzb(parcel, zzm.CREATOR);
            zzban.zzh(parcel);
            zze(zzmVar);
            parcel2.writeNoException();
        } else if (i == 2) {
            String strZzf = zzf();
            parcel2.writeNoException();
            parcel2.writeString(strZzf);
        } else if (i == 3) {
            boolean zZzg = zzg();
            parcel2.writeNoException();
            int i3 = zzban.zza;
            parcel2.writeInt(zZzg ? 1 : 0);
        } else if (i == 4) {
            String strZzh = zzh();
            parcel2.writeNoException();
            parcel2.writeString(strZzh);
        } else {
            if (i != 5) {
                return false;
            }
            zzm zzmVar2 = (zzm) zzban.zzb(parcel, zzm.CREATOR);
            int i4 = parcel.readInt();
            zzban.zzh(parcel);
            zzi(zzmVar2, i4);
            parcel2.writeNoException();
        }
        return true;
    }
}
