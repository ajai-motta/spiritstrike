package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbro extends zzbam implements zzbrp {
    public zzbro() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbrp zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return iInterfaceQueryLocalInterface instanceof zzbrp ? (zzbrp) iInterfaceQueryLocalInterface : new zzbrn(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    protected final boolean zzdi(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int i3 = parcel.readInt();
                zzban.zzh(parcel);
                zzg(i3);
                break;
            case 4:
                zzh();
                break;
            case 5:
                zzi();
                break;
            case 6:
                zzj();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (iInterfaceQueryLocalInterface instanceof zzbrt) {
                    }
                }
                zzban.zzh(parcel);
                break;
            case 8:
                zzk();
                break;
            case 9:
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzban.zzh(parcel);
                zzl(string, string2);
                break;
            case 10:
                zzbjb.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzban.zzh(parcel);
                break;
            case 11:
                zzn();
                break;
            case 12:
                parcel.readString();
                zzban.zzh(parcel);
                break;
            case 13:
                zzo();
                break;
            case 14:
                zzbyh zzbyhVar = (zzbyh) zzban.zzb(parcel, zzbyh.CREATOR);
                zzban.zzh(parcel);
                zzp(zzbyhVar);
                break;
            case 15:
                zzq();
                break;
            case 16:
                zzbyl zzbylVarZzb = zzbyk.zzb(parcel.readStrongBinder());
                zzban.zzh(parcel);
                zzr(zzbylVarZzb);
                break;
            case 17:
                int i4 = parcel.readInt();
                zzban.zzh(parcel);
                zzs(i4);
                break;
            case 18:
                zzt();
                break;
            case 19:
                zzban.zzh(parcel);
                break;
            case 20:
                zzu();
                break;
            case 21:
                String string3 = parcel.readString();
                zzban.zzh(parcel);
                zzv(string3);
                break;
            case 22:
                int i5 = parcel.readInt();
                String string4 = parcel.readString();
                zzban.zzh(parcel);
                zzw(i5, string4);
                break;
            case 23:
                com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzban.zzh(parcel);
                zzx(zzeVar);
                break;
            case 24:
                com.google.android.gms.ads.internal.client.zze zzeVar2 = (com.google.android.gms.ads.internal.client.zze) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzban.zzh(parcel);
                zzy(zzeVar2);
                break;
            case 25:
                zzz();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
