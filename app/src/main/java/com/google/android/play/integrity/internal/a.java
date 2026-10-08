package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
public class a implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IBinder f1790a;
    private final String b;

    protected a(IBinder iBinder, String str) {
        this.f1790a = iBinder;
        this.b = str;
    }

    protected final Parcel a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.b);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f1790a;
    }

    protected final void b(int i, Parcel parcel) throws RemoteException {
        try {
            this.f1790a.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
