package com.inca.security.Proxy;

import android.os.Handler;
import android.os.Message;
import com.inca.security.Native.AppGuardAssistantNative;

/* JADX INFO: loaded from: classes.dex */
public class AppGuardProxyHandler implements Handler.Callback {
    private static AppGuardProxyHandler mInstance;

    public static synchronized AppGuardProxyHandler getInstance() {
        if (mInstance == null) {
            mInstance = new AppGuardProxyHandler();
        }
        return mInstance;
    }

    private AppGuardProxyHandler() {
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return AppGuardAssistantNative.iiIiIIiIIi(message);
    }
}
