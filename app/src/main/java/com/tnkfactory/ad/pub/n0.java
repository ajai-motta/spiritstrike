package com.tnkfactory.ad.pub;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes6.dex */
public final class n0 extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBinder f3164a;

    public n0(IBinder iBinder) {
        this.f3164a = iBinder;
    }

    public final String a() {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.f3164a.transact(1, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readString();
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f3164a;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1598968902) {
            parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return true;
        }
        if (i == 1) {
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            String strA = a();
            parcel2.writeNoException();
            parcel2.writeString(strA);
            return true;
        }
        if (i == 2) {
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            boolean zA = a(parcel.readInt() != 0);
            parcel2.writeNoException();
            parcel2.writeInt(zA ? 1 : 0);
            return true;
        }
        if (i == 3) {
            parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            String string = parcel.readString();
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                parcelObtain.writeString(string);
                this.f3164a.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string2 = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                parcel2.writeNoException();
                parcel2.writeString(string2);
                return true;
            } finally {
            }
        }
        if (i != 4) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        String string3 = parcel.readString();
        int i3 = parcel.readInt() != 0 ? 1 : 0;
        Parcel parcelObtain3 = Parcel.obtain();
        Parcel parcelObtain4 = Parcel.obtain();
        try {
            parcelObtain3.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcelObtain3.writeString(string3);
            parcelObtain3.writeInt(i3);
            this.f3164a.transact(4, parcelObtain3, parcelObtain4, 0);
            parcelObtain4.readException();
            parcelObtain4.recycle();
            parcelObtain3.recycle();
            parcel2.writeNoException();
            return true;
        } finally {
        }
    }

    public final boolean a(boolean z) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            parcelObtain.writeInt(z ? 1 : 0);
            this.f3164a.transact(2, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            return parcelObtain2.readInt() != 0;
        } finally {
            parcelObtain2.recycle();
            parcelObtain.recycle();
        }
    }
}
