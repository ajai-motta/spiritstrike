package com.inca.security.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.inca.security.Native.AppGuardPreAssistantNative;

/* JADX INFO: compiled from: ja */
/* JADX INFO: loaded from: classes.dex */
public class AppGuardService extends Service {
    private static final /* synthetic */ int SERVICE_ROOTING_MAGISK = 1;
    private /* synthetic */ Handler handler = new Handler() { // from class: com.inca.security.Service.AppGuardService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int iIiiiIIiIIi;
            try {
                if (message.what == 1) {
                    iIiiiIIiIIi = AppGuardPreAssistantNative.IiiiIIiIIi(1);
                    message.replyTo.send(Message.obtain(null, message.what, iIiiiIIiIIi, 0));
                    return;
                }
                message.replyTo.send(Message.obtain(null, message.what, iIiiiIIiIIi, 0));
                return;
            } catch (Exception unused) {
                return;
            }
            iIiiiIIiIIi = 0;
        }
    };

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new Messenger(this.handler).getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
