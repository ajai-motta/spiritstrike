package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbth extends zzbam implements zzbti {
    public zzbth() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbti zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzbti ? (zzbti) iInterfaceQueryLocalInterface : new zzbtg(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.google.android.gms.internal.ads.zzbtl] */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.google.android.gms.internal.ads.zzbtf] */
    /* JADX WARN: Type inference failed for: r11v5, types: [com.google.android.gms.internal.ads.zzbtc] */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.google.android.gms.internal.ads.zzbtf] */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.google.android.gms.internal.ads.zzbtc] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.google.android.gms.internal.ads.zzbth] */
    /* JADX WARN: Type inference failed for: r5v16, types: [com.google.android.gms.internal.ads.zzbsw] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.google.android.gms.internal.ads.zzbsw] */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.google.android.gms.internal.ads.zzbst] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.google.android.gms.internal.ads.zzbsz] */
    @Override // com.google.android.gms.internal.ads.zzbam
    protected final boolean zzdi(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        IInterface zzbsrVar = null;
        if (i == 1) {
            IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            String string = parcel.readString();
            Bundle bundle = (Bundle) zzban.zzb(parcel, Bundle.CREATOR);
            Bundle bundle2 = (Bundle) zzban.zzb(parcel, Bundle.CREATOR);
            com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzbsrVar = iInterfaceQueryLocalInterface instanceof zzbtl ? (zzbtl) iInterfaceQueryLocalInterface : new zzbtj(strongBinder);
            }
            ?? r11 = zzbsrVar;
            zzban.zzh(parcel);
            zze(iObjectWrapperAsInterface, string, bundle, bundle2, zzrVar, r11);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzbtx zzbtxVarZzf = zzf();
            parcel2.writeNoException();
            zzban.zzd(parcel2, zzbtxVarZzf);
        } else if (i == 3) {
            zzbtx zzbtxVarZzg = zzg();
            parcel2.writeNoException();
            zzban.zzd(parcel2, zzbtxVarZzg);
        } else if (i == 5) {
            com.google.android.gms.ads.internal.client.zzed zzedVarZzh = zzh();
            parcel2.writeNoException();
            zzban.zze(parcel2, zzedVarZzh);
        } else if (i == 10) {
            IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
            zzban.zzh(parcel);
            parcel2.writeNoException();
        } else if (i != 11) {
            switch (i) {
                case 13:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbsrVar = iInterfaceQueryLocalInterface2 instanceof zzbsw ? (zzbsw) iInterfaceQueryLocalInterface2 : new zzbsu(strongBinder2);
                    }
                    ?? r5 = zzbsrVar;
                    zzbrp zzbrpVarZzb = zzbro.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzban.zzh(parcel);
                    zzi(string2, string3, zzmVar, iObjectWrapperAsInterface2, r5, zzbrpVarZzb, zzrVar2);
                    parcel2.writeNoException();
                    break;
                case 14:
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder3 = parcel.readStrongBinder();
                    if (strongBinder3 != null) {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzbsrVar = iInterfaceQueryLocalInterface3 instanceof zzbsz ? (zzbsz) iInterfaceQueryLocalInterface3 : new zzbsx(strongBinder3);
                    }
                    ?? r7 = zzbsrVar;
                    zzbrp zzbrpVarZzb2 = zzbro.zzb(parcel.readStrongBinder());
                    zzban.zzh(parcel);
                    zzj(string4, string5, zzmVar2, iObjectWrapperAsInterface3, r7, zzbrpVarZzb2);
                    parcel2.writeNoException();
                    break;
                case 15:
                    IObjectWrapper iObjectWrapperAsInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzban.zzh(parcel);
                    boolean zZzk = zzk(iObjectWrapperAsInterface4);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzk ? 1 : 0);
                    break;
                case 16:
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar3 = (com.google.android.gms.ads.internal.client.zzm) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder4 = parcel.readStrongBinder();
                    if (strongBinder4 != null) {
                        IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbsrVar = iInterfaceQueryLocalInterface4 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface4 : new zzbtd(strongBinder4);
                    }
                    ?? r112 = zzbsrVar;
                    zzbrp zzbrpVarZzb3 = zzbro.zzb(parcel.readStrongBinder());
                    zzban.zzh(parcel);
                    zzl(string6, string7, zzmVar3, iObjectWrapperAsInterface5, r112, zzbrpVarZzb3);
                    parcel2.writeNoException();
                    break;
                case 17:
                    IObjectWrapper iObjectWrapperAsInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzban.zzh(parcel);
                    boolean zZzm = zzm(iObjectWrapperAsInterface6);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzm ? 1 : 0);
                    break;
                case 18:
                    String string8 = parcel.readString();
                    String string9 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar4 = (com.google.android.gms.ads.internal.client.zzm) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder5 = parcel.readStrongBinder();
                    if (strongBinder5 != null) {
                        IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbsrVar = iInterfaceQueryLocalInterface5 instanceof zzbtc ? (zzbtc) iInterfaceQueryLocalInterface5 : new zzbta(strongBinder5);
                    }
                    ?? r113 = zzbsrVar;
                    zzbrp zzbrpVarZzb4 = zzbro.zzb(parcel.readStrongBinder());
                    zzban.zzh(parcel);
                    zzn(string8, string9, zzmVar4, iObjectWrapperAsInterface7, r113, zzbrpVarZzb4);
                    parcel2.writeNoException();
                    break;
                case 19:
                    String string10 = parcel.readString();
                    zzban.zzh(parcel);
                    zzo(string10);
                    parcel2.writeNoException();
                    break;
                case 20:
                    String string11 = parcel.readString();
                    String string12 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar5 = (com.google.android.gms.ads.internal.client.zzm) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder6 = parcel.readStrongBinder();
                    if (strongBinder6 != null) {
                        IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbsrVar = iInterfaceQueryLocalInterface6 instanceof zzbtf ? (zzbtf) iInterfaceQueryLocalInterface6 : new zzbtd(strongBinder6);
                    }
                    ?? r114 = zzbsrVar;
                    zzbrp zzbrpVarZzb5 = zzbro.zzb(parcel.readStrongBinder());
                    zzban.zzh(parcel);
                    zzp(string11, string12, zzmVar5, iObjectWrapperAsInterface8, r114, zzbrpVarZzb5);
                    parcel2.writeNoException();
                    break;
                case 21:
                    String string13 = parcel.readString();
                    String string14 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar6 = (com.google.android.gms.ads.internal.client.zzm) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder7 = parcel.readStrongBinder();
                    if (strongBinder7 != null) {
                        IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbsrVar = iInterfaceQueryLocalInterface7 instanceof zzbsw ? (zzbsw) iInterfaceQueryLocalInterface7 : new zzbsu(strongBinder7);
                    }
                    ?? r52 = zzbsrVar;
                    zzbrp zzbrpVarZzb6 = zzbro.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzban.zzh(parcel);
                    zzq(string13, string14, zzmVar6, iObjectWrapperAsInterface9, r52, zzbrpVarZzb6, zzrVar3);
                    parcel2.writeNoException();
                    break;
                case 22:
                    String string15 = parcel.readString();
                    String string16 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar7 = (com.google.android.gms.ads.internal.client.zzm) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder8 = parcel.readStrongBinder();
                    if (strongBinder8 != null) {
                        IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbsrVar = iInterfaceQueryLocalInterface8 instanceof zzbtc ? (zzbtc) iInterfaceQueryLocalInterface8 : new zzbta(strongBinder8);
                    }
                    ?? r115 = zzbsrVar;
                    zzbrp zzbrpVarZzb7 = zzbro.zzb(parcel.readStrongBinder());
                    zzbhx zzbhxVar = (zzbhx) zzban.zzb(parcel, zzbhx.CREATOR);
                    zzban.zzh(parcel);
                    zzr(string15, string16, zzmVar7, iObjectWrapperAsInterface10, r115, zzbrpVarZzb7, zzbhxVar);
                    parcel2.writeNoException();
                    break;
                case 23:
                    String string17 = parcel.readString();
                    String string18 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar8 = (com.google.android.gms.ads.internal.client.zzm) zzban.zzb(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder9 = parcel.readStrongBinder();
                    if (strongBinder9 != null) {
                        IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                        zzbsrVar = iInterfaceQueryLocalInterface9 instanceof zzbst ? (zzbst) iInterfaceQueryLocalInterface9 : new zzbsr(strongBinder9);
                    }
                    ?? r72 = zzbsrVar;
                    zzbrp zzbrpVarZzb8 = zzbro.zzb(parcel.readStrongBinder());
                    zzban.zzh(parcel);
                    zzs(string17, string18, zzmVar8, iObjectWrapperAsInterface11, r72, zzbrpVarZzb8);
                    parcel2.writeNoException();
                    break;
                case 24:
                    IObjectWrapper iObjectWrapperAsInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                    zzban.zzh(parcel);
                    boolean zZzt = zzt(iObjectWrapperAsInterface12);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzt ? 1 : 0);
                    break;
                default:
                    return false;
            }
        } else {
            parcel.createStringArray();
            zzban.zzh(parcel);
            parcel2.writeNoException();
        }
        return true;
    }
}
