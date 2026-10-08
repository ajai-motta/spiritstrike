package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import com.applovin.impl.o7;
import com.applovin.impl.y4;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class SessionTracker {
    public static final String ACTION_APPLICATION_PAUSED = "com.applovin.application_paused";
    public static final String ACTION_APPLICATION_RESUMED = "com.applovin.application_resumed";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final k f610a;
    private final String b = UUID.randomUUID().toString();
    private final AtomicBoolean c = new AtomicBoolean();
    private final AtomicBoolean d = new AtomicBoolean();
    private final AtomicInteger e = new AtomicInteger();
    private final AtomicLong f = new AtomicLong();
    private final AtomicLong g = new AtomicLong();
    private Date h;
    private Date i;

    class a extends com.applovin.impl.b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            super.onActivityResumed(activity);
            SessionTracker.this.b();
        }
    }

    class b implements ComponentCallbacks2 {
        b() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            SessionTracker.this.e.set(i);
            if (i == 20) {
                SessionTracker.this.a();
            }
        }
    }

    class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.USER_PRESENT".equals(action)) {
                if (o7.g()) {
                    SessionTracker.this.b();
                }
            } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                SessionTracker.this.a();
            }
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f614a;

        static {
            int[] iArr = new int[e.values().length];
            f614a = iArr;
            try {
                iArr[e.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f614a[e.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f614a[e.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum e {
        STARTED("started"),
        PAUSED("paused"),
        RESUMED("resumed");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f615a;

        e(String str) {
            this.f615a = str;
        }

        public String b() {
            return this.f615a;
        }
    }

    SessionTracker(k kVar) {
        this.f610a = kVar;
        Application application = (Application) k.o();
        application.registerActivityLifecycleCallbacks(new a());
        application.registerComponentCallbacks(new b());
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        application.registerReceiver(new c(), intentFilter);
    }

    private void d() {
        this.f610a.O();
        if (o.a()) {
            this.f610a.O().a("SessionTracker", "Application Resumed");
        }
        this.g.set(System.currentTimeMillis());
        boolean zBooleanValue = ((Boolean) this.f610a.a(y4.z3)).booleanValue();
        long jLongValue = ((Long) this.f610a.a(y4.A3)).longValue();
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_RESUMED), null);
        if (this.c.getAndSet(false)) {
            return;
        }
        long millis = TimeUnit.MINUTES.toMillis(jLongValue);
        if (this.i == null || System.currentTimeMillis() - this.i.getTime() >= millis) {
            this.f610a.F().trackEvent("resumed");
            if (zBooleanValue) {
                this.i = new Date();
            }
        }
        if (zBooleanValue) {
            return;
        }
        this.i = new Date();
    }

    public long getAppEnteredBackgroundTimeMillis() {
        return this.f.get();
    }

    public long getAppEnteredForegroundTimeMillis() {
        return this.g.get();
    }

    public e getCurrentApplicationState() {
        return this.d.get() ? e.PAUSED : this.f.get() != 0 ? e.RESUMED : e.STARTED;
    }

    public long getCurrentApplicationStateDurationMillis() {
        long jN;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = d.f614a[getCurrentApplicationState().ordinal()];
        if (i == 1) {
            jN = k.n();
        } else if (i == 2) {
            jN = this.f.get();
        } else {
            if (i != 3) {
                return -1L;
            }
            jN = this.g.get();
        }
        return jCurrentTimeMillis - jN;
    }

    public int getLastTrimMemoryLevel() {
        return this.e.get();
    }

    public String getSessionId() {
        return this.b;
    }

    public boolean isApplicationPaused() {
        return this.d.get();
    }

    public void pauseForClick() {
        this.c.set(true);
    }

    public void resumeForClick() {
        this.c.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.d.compareAndSet(false, true)) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.d.compareAndSet(true, false)) {
            d();
        }
    }

    private void c() {
        this.f610a.O();
        if (o.a()) {
            this.f610a.O().a("SessionTracker", "Application Paused");
        }
        this.f.set(System.currentTimeMillis());
        AppLovinBroadcastManager.sendBroadcastSync(new Intent(ACTION_APPLICATION_PAUSED), null);
        if (this.c.get()) {
            return;
        }
        boolean zBooleanValue = ((Boolean) this.f610a.a(y4.z3)).booleanValue();
        long millis = TimeUnit.MINUTES.toMillis(((Long) this.f610a.a(y4.B3)).longValue());
        if (this.h == null || System.currentTimeMillis() - this.h.getTime() >= millis) {
            this.f610a.F().trackEvent("paused");
            if (zBooleanValue) {
                this.h = new Date();
            }
        }
        if (zBooleanValue) {
            return;
        }
        this.h = new Date();
    }
}
