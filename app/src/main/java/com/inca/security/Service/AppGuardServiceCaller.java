package com.inca.security.Service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.inca.security.Proxy.JNISoxProxy;

/* JADX INFO: compiled from: ga */
/* JADX INFO: loaded from: classes.dex */
public class AppGuardServiceCaller {
    private static /* synthetic */ boolean isConnected;
    private static /* synthetic */ Messenger mServiceMessenger;
    private static /* synthetic */ int pipe;
    private static /* synthetic */ Messenger proxyManagerMeseenger;
    private static /* synthetic */ ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.inca.security.Service.AppGuardServiceCaller.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Messenger unused = AppGuardServiceCaller.proxyManagerMeseenger = null;
            boolean unused2 = AppGuardServiceCaller.isConnected = false;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (AppGuardServiceCaller.proxyManagerMeseenger == null) {
                Messenger unused = AppGuardServiceCaller.proxyManagerMeseenger = new Messenger(new Handler((Handler.Callback) new 1(this)));
            }
            Messenger unused2 = AppGuardServiceCaller.mServiceMessenger = new Messenger(iBinder);
            Message messageObtain = Message.obtain(null, 1, 0, 0);
            messageObtain.replyTo = AppGuardServiceCaller.proxyManagerMeseenger;
            try {
                AppGuardServiceCaller.mServiceMessenger.send(messageObtain);
            } catch (Exception unused3) {
            }
            boolean unused4 = AppGuardServiceCaller.isConnected = true;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            Messenger unused = AppGuardServiceCaller.proxyManagerMeseenger = null;
            boolean unused2 = AppGuardServiceCaller.isConnected = false;
        }
    };

    public static void callService(int i, int i2) {
        pipe = i2;
        if (!isConnected) {
            JNISoxProxy.getApplicationContext().bindService(new Intent(JNISoxProxy.getApplicationContext(), (Class<?>) AppGuardService.class), serviceConnection, 1);
        } else {
            Message messageObtain = Message.obtain(null, 1, 0, 0);
            messageObtain.replyTo = proxyManagerMeseenger;
            try {
                mServiceMessenger.send(messageObtain);
            } catch (Exception unused) {
            }
        }
    }
}
