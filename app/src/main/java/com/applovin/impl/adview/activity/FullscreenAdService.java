package com.applovin.impl.adview.activity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.n2;
import com.applovin.impl.o7;
import com.applovin.impl.sdk.o;
import com.applovin.impl.t2;

/* JADX INFO: loaded from: classes2.dex */
public class FullscreenAdService extends Service {
    public static final String DATA_KEY_RAW_FULL_AD_RESPONSE = "raw_full_ad_response";
    private static final String TAG = "FullscreenAdService";

    private static class b extends Handler {
        private b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                n2 n2Var = AppLovinFullscreenActivity.parentInterstitialWrapper;
                if (n2Var == null) {
                    if (!o7.a(1.0d)) {
                        super.handleMessage(message);
                        return;
                    } else {
                        throw new RuntimeException("parentWrapper is null for " + message.what);
                    }
                }
                com.applovin.impl.sdk.ad.b bVarF = n2Var.f();
                int i = message.what;
                c cVar = c.AD;
                if (i == cVar.b()) {
                    Bundle bundle = new Bundle();
                    bundle.putString(FullscreenAdService.DATA_KEY_RAW_FULL_AD_RESPONSE, bVarF.getRawFullResponse());
                    Message messageObtain = Message.obtain((Handler) null, cVar.b());
                    messageObtain.setData(bundle);
                    try {
                        message.replyTo.send(messageObtain);
                        return;
                    } catch (RemoteException e) {
                        o.c(FullscreenAdService.TAG, "Failed to respond to Fullscreen Activity in another process with ad", e);
                        return;
                    }
                }
                if (message.what == c.AD_DISPLAYED.b()) {
                    t2.a(n2Var.c(), bVarF);
                    return;
                }
                if (message.what == c.AD_CLICKED.b()) {
                    t2.a(n2Var.b(), bVarF);
                    return;
                }
                if (message.what == c.AD_VIDEO_STARTED.b()) {
                    t2.a(n2Var.d(), bVarF);
                    return;
                }
                if (message.what == c.AD_VIDEO_ENDED.b()) {
                    Bundle data = message.getData();
                    t2.a(n2Var.d(), bVarF, data.getDouble("percent_viewed"), data.getBoolean("fully_watched"));
                    return;
                }
                if (message.what == c.AD_HIDDEN.b()) {
                    t2.b(n2Var.c(), bVarF);
                } else {
                    super.handleMessage(message);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public enum c {
        AD(0),
        AD_DISPLAYED(1),
        AD_CLICKED(2),
        AD_VIDEO_STARTED(3),
        AD_VIDEO_ENDED(4),
        AD_HIDDEN(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f301a;

        c(int i) {
            this.f301a = i;
        }

        public int b() {
            return this.f301a;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new Messenger(new b()).getBinder();
    }
}
