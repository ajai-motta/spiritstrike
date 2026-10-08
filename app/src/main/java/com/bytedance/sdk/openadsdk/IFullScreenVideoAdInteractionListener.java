package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public interface IFullScreenVideoAdInteractionListener extends IInterface {

    public static class Default implements IFullScreenVideoAdInteractionListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
        public void onAdClose() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
        public void onAdShow() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
        public void onDestroy() throws RemoteException {
        }
    }

    void onAdClose() throws RemoteException;

    void onAdShow() throws RemoteException;

    void onAdVideoBarClick() throws RemoteException;

    void onDestroy() throws RemoteException;

    public static abstract class Stub extends Binder implements IFullScreenVideoAdInteractionListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
        }

        public static IFullScreenVideoAdInteractionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IFullScreenVideoAdInteractionListener)) {
                return (IFullScreenVideoAdInteractionListener) iInterfaceQueryLocalInterface;
            }
            return new qdl(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
                onDestroy();
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
                onAdShow();
                parcel2.writeNoException();
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
                onAdVideoBarClick();
                parcel2.writeNoException();
                return true;
            }
            if (i != 4) {
                if (i == 1598968902) {
                    parcel2.writeString("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
            onAdClose();
            parcel2.writeNoException();
            return true;
        }

        private static class qdl implements IFullScreenVideoAdInteractionListener {
            public static IFullScreenVideoAdInteractionListener qdl;
            private IBinder ud;

            qdl(IBinder iBinder) {
                this.ud = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.ud;
            }

            @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
            public void onDestroy() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
                    if (!this.ud.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDestroy();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
            public void onAdShow() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
                    if (!this.ud.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAdShow();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
            public void onAdVideoBarClick() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
                    if (!this.ud.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAdVideoBarClick();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener
            public void onAdClose() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IFullScreenVideoAdInteractionListener");
                    if (!this.ud.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAdClose();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IFullScreenVideoAdInteractionListener iFullScreenVideoAdInteractionListener) {
            if (qdl.qdl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iFullScreenVideoAdInteractionListener == null) {
                return false;
            }
            qdl.qdl = iFullScreenVideoAdInteractionListener;
            return true;
        }

        public static IFullScreenVideoAdInteractionListener getDefaultImpl() {
            return qdl.qdl;
        }
    }
}
