package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public interface ILicensingService extends IInterface {

    public static abstract class a extends Binder implements ILicensingService {

        /* JADX INFO: renamed from: com.android.vending.licensing.ILicensingService$a$a, reason: collision with other inner class name */
        private static class C0136a implements ILicensingService {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f126a;

            C0136a(IBinder iBinder) {
                this.f126a = iBinder;
            }

            @Override // com.android.vending.licensing.ILicensingService
            public void a(long j, String str, com.android.vending.licensing.a aVar) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.android.vending.licensing.ILicensingService");
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    parcelObtain.writeStrongInterface(aVar);
                    this.f126a.transact(1, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f126a;
            }
        }

        public static ILicensingService a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.licensing.ILicensingService");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ILicensingService)) ? new C0136a(iBinder) : (ILicensingService) iInterfaceQueryLocalInterface;
        }
    }

    void a(long j, String str, com.android.vending.licensing.a aVar);
}
