package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes2.dex */
public class i8 {
    private static final Set f = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f418a;
    private final com.applovin.impl.sdk.k b;
    private Runnable c;
    private final Object d = new Object();
    private final Timer e;

    class a extends TimerTask {

        /* JADX INFO: renamed from: com.applovin.impl.i8$a$a, reason: collision with other inner class name */
        class C0149a implements AppLovinBroadcastManager.Receiver {
            C0149a() {
            }

            @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
            public void onReceive(Intent intent, Map map) {
                AppLovinBroadcastManager.unregisterReceiver(this);
                i8.this.c();
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (!i8.this.b.n0().isApplicationPaused() || i8.this.f418a) {
                i8.this.c();
            } else {
                AppLovinBroadcastManager.registerReceiver(new C0149a(), new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
            }
        }
    }

    private i8(long j, boolean z, com.applovin.impl.sdk.k kVar, Runnable runnable) {
        Timer timer = new Timer();
        this.e = timer;
        if (j < 0) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Invalid timer length: " + j);
        }
        if (kVar == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Sdk is null");
        }
        if (runnable == null) {
            throw new IllegalArgumentException("Cannot create wall clock timer. Runnable is null.");
        }
        this.f418a = z;
        this.b = kVar;
        this.c = runnable;
        f.add(this);
        timer.schedule(b(), j);
    }

    public static i8 a(long j, boolean z, com.applovin.impl.sdk.k kVar, Runnable runnable) {
        return new i8(j, z, kVar, runnable);
    }

    private TimerTask b() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Runnable runnable = this.c;
        if (runnable != null) {
            runnable.run();
            a();
        }
    }

    public void a() {
        synchronized (this.d) {
            this.e.cancel();
            this.c = null;
            f.remove(this);
        }
    }
}
