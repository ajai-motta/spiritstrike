package com.tnkfactory.ad.pub;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class p0 {
    public static m0 a(Context context) throws IOException {
        Context applicationContext = context.getApplicationContext();
        PackageManager packageManager = applicationContext.getPackageManager();
        try {
            packageManager.getPackageInfo("com.android.vending", 0);
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                if (packageInfo.versionCode < 4242000) {
                    throw new IOException("Google Play services out of date. Requires 4242000 but found " + packageInfo.versionCode);
                }
                try {
                    if (!packageManager.getApplicationInfo("com.google.android.gms", 0).enabled) {
                        throw new IOException("Google Play services is not enabled.");
                    }
                    o0 o0Var = new o0();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!applicationContext.bindService(intent, o0Var, 1)) {
                            throw new IOException("Connection failure");
                        }
                        try {
                            n0 n0VarA = a(o0Var.a());
                            return new m0(n0VarA.a(), n0VarA.a(true));
                        } catch (RemoteException e) {
                            throw new IOException("GMS Remote exception: " + e);
                        } catch (InterruptedException e2) {
                            throw new IOException("Interrupted exception: " + e2);
                        }
                    } finally {
                        applicationContext.unbindService(o0Var);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new IOException("Google Play services is missing when getting application info.");
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new IOException("Google Play services is missing.");
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            throw new IOException("Google Play Store is missing.");
        }
    }

    public static n0 a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof n0)) {
            return (n0) iInterfaceQueryLocalInterface;
        }
        return new n0(iBinder);
    }
}
