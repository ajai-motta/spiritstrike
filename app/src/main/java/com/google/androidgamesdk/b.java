package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
final class b extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f1814a;

    private b() {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Log.i("ChoreographerCallback", "Starting looper thread");
        Looper.prepare();
        this.f1814a = new Handler();
        Looper.loop();
        Log.i("ChoreographerCallback", "Terminating looper thread");
    }
}
