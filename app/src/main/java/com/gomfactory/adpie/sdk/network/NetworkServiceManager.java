package com.gomfactory.adpie.sdk.network;

import android.os.Handler;
import android.os.Message;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.network.apiclient.NetworkServiceRetrofit;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkServiceManager {
    public static final int MAX_CONNECTIONS = 5;
    public static final String TAG = "NetworkServiceManager";
    private static NetworkServiceManager ourInstance = new NetworkServiceManager();
    private ArrayList<NetworkService> active = new ArrayList<>();
    private ArrayList<NetworkService> queue = new ArrayList<>();
    private boolean useRetrofit = false;

    private NetworkServiceManager() {
        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
            AdPieLog.d(TAG, "NetworkServiceManager instance is created.");
        }
    }

    public static NetworkServiceManager getInstance() {
        return ourInstance;
    }

    public void get(String str, Handler handler) {
        try {
            if (this.useRetrofit) {
                new NetworkServiceRetrofit().get(str, handler);
            } else {
                push(new NetworkService(str, null, handler, "GET"));
            }
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
            if (handler != null) {
                handler.sendMessage(Message.obtain(handler, -1));
            }
        }
    }

    public void post(String str, String str2, Handler handler) {
        try {
            if (this.useRetrofit) {
                new NetworkServiceRetrofit().post(str, str2, handler);
            } else {
                push(new NetworkService(str, str2, handler, "POST"));
            }
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
            if (handler != null) {
                handler.sendMessage(Message.obtain(handler, -1));
            }
        }
    }

    private void push(NetworkService networkService) {
        this.queue.add(networkService);
        if (this.active.size() < 5) {
            startNext();
        }
    }

    private void startNext() {
        try {
            synchronized (this.queue) {
                if (!this.queue.isEmpty()) {
                    NetworkService networkService = this.queue.get(0);
                    this.queue.remove(0);
                    this.active.add(networkService);
                    networkService.process();
                }
            }
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
        }
    }

    public void didComplete(NetworkService networkService) {
        this.active.remove(networkService);
        startNext();
    }

    public void setUseRetrofit(boolean z) {
        if (z) {
            try {
                Class.forName("retrofit2.Retrofit");
                Class.forName("okhttp3.OkHttpClient");
            } catch (ClassNotFoundException unused) {
                this.useRetrofit = false;
                return;
            }
        }
        this.useRetrofit = z;
    }
}
