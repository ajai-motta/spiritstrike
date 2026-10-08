package com.inca.security.Proxy;

import android.content.Context;
import androidx.multidex.MultiDexApplication;
import com.inca.security.DexProtect.Binder;
import com.inca.security.Native.AppGuardPreAssistantNative;

/* JADX INFO: compiled from: xa */
/* JADX INFO: loaded from: classes.dex */
public class AppGuardProxyApplication extends MultiDexApplication {
    static {
        try {
            if (Binder.getABI() == 0) {
                System.loadLibrary("compatible");
            }
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        try {
            if (Binder.getABI() == 0) {
                iIiIiIiIii.iIiIIiIiiI(context, context.getClassLoader());
            }
        } catch (UnsatisfiedLinkError unused) {
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        JNISoxProxy.setApplicationContext(getApplicationContext());
        AppGuardPreAssistantNative.IiIiiIiIiI(this);
    }
}
