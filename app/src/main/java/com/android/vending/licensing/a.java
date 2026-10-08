package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.android.vending.licensing.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0137a extends Binder implements a {
        public AbstractBinderC0137a() {
            attachInterface(this, "com.android.vending.licensing.ILicenseResultListener");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("com.android.vending.licensing.ILicenseResultListener");
            }
            if (i == 1598968902) {
                parcel2.writeString("com.android.vending.licensing.ILicenseResultListener");
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            a(parcel.readInt(), parcel.readString(), parcel.readString());
            return true;
        }
    }

    void a(int i, String str, String str2);
}
