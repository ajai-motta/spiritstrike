package com.adxcorp.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class ADXAsyncTaskUtil {
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());

    public void doInBackground() {
    }

    public void doInUiThread() {
    }

    public void execute() {
        this.executor.execute(new Runnable() { // from class: com.adxcorp.util.ADXAsyncTaskUtil.1
            @Override // java.lang.Runnable
            public void run() {
                ADXAsyncTaskUtil.this.doInBackground();
                ADXAsyncTaskUtil.this.handler.post(new Runnable() { // from class: com.adxcorp.util.ADXAsyncTaskUtil.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ADXAsyncTaskUtil.this.doInUiThread();
                    }
                });
            }
        });
    }
}
