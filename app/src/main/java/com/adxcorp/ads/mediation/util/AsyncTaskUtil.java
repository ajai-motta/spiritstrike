package com.adxcorp.ads.mediation.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class AsyncTaskUtil {
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());

    public void doInBackground() {
    }

    public void doInUiThread() {
    }

    public void execute() {
        this.executor.execute(new Runnable() { // from class: com.adxcorp.ads.mediation.util.AsyncTaskUtil.1
            @Override // java.lang.Runnable
            public void run() {
                AsyncTaskUtil.this.doInBackground();
                AsyncTaskUtil.this.handler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.util.AsyncTaskUtil.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AsyncTaskUtil.this.doInUiThread();
                    }
                });
            }
        });
    }
}
