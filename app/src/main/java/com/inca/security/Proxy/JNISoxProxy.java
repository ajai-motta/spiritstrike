package com.inca.security.Proxy;

import android.content.Context;
import android.os.Build;
import com.inca.security.Info.IDeviceInfo;

/* JADX INFO: compiled from: pa */
/* JADX INFO: loaded from: classes.dex */
public class JNISoxProxy {
    private static /* synthetic */ Context applicationContext;
    private static /* synthetic */ Context mBaseContext;
    private static /* synthetic */ IDeviceInfo mDeviceInfo;

    public static String getLocaleString() {
        if (Build.VERSION.SDK_INT >= 24) {
            return mBaseContext.getResources().getConfiguration().getLocales().get(0).getCountry();
        }
        return mBaseContext.getResources().getConfiguration().locale.getCountry();
    }

    public static void setContext(Context context) {
        mBaseContext = context;
        if (context == null || mDeviceInfo != null) {
            return;
        }
        try {
            mDeviceInfo = (IDeviceInfo) Class.forName("com.inca.security.Info.DeviceInfo").getConstructor(Class.forName("android.content.Context")).newInstance(context);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void setApplicationContext(Context context) {
        applicationContext = context;
    }

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static Context getContext() {
        return mBaseContext;
    }

    public static IDeviceInfo getDeviceInfo() {
        return mDeviceInfo;
    }
}
