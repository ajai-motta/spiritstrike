package com.adxcorp.gdpr;

import android.content.Context;
import com.adxcorp.util.ADXAsyncTaskUtil;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: loaded from: classes2.dex */
public class AdvertisingInfoTask {
    private AdvertisingInfoListener advertisingInfoListener;
    private AdvertisingIdClient.Info info;

    public interface AdvertisingInfoListener {
        void onInfoReceived(AdvertisingIdClient.Info info);
    }

    public AdvertisingInfoTask(AdvertisingInfoListener advertisingInfoListener) {
        this.advertisingInfoListener = advertisingInfoListener;
    }

    public void execute(final Context context) {
        new ADXAsyncTaskUtil() { // from class: com.adxcorp.gdpr.AdvertisingInfoTask.1
            @Override // com.adxcorp.util.ADXAsyncTaskUtil
            public void doInBackground() {
                try {
                    AdvertisingInfoTask.this.info = AdvertisingIdClient.getAdvertisingIdInfo(context);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.adxcorp.util.ADXAsyncTaskUtil
            public void doInUiThread() {
                if (AdvertisingInfoTask.this.advertisingInfoListener != null) {
                    AdvertisingInfoTask.this.advertisingInfoListener.onInfoReceived(AdvertisingInfoTask.this.info);
                }
            }
        }.execute();
    }
}
