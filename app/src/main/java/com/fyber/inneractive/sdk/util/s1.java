package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class s1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f1672a = new AtomicBoolean(true);
    public volatile String b = null;
    public Context c = null;
    public final AtomicBoolean d = new AtomicBoolean(false);
    public final p1 e = new p1(this);

    public final String a() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        if (this.e != null && this.f1672a.get()) {
            Handler handler = r.b;
            handler.removeCallbacks(this.e);
            handler.postDelayed(this.e, 50L);
        }
        return System.getProperty("http.agent");
    }

    public final void b() {
        if (this.c == null || !TextUtils.isEmpty(this.b)) {
            return;
        }
        this.b = this.c.getSharedPreferences("fyber.ua", 0).getString("ua", null);
        if (!TextUtils.isEmpty(this.b)) {
            IAlog.a("UserAgentProvider | populated user agent from shared prefs", new Object[0]);
            this.d.compareAndSet(false, true);
        }
        r.f1668a.execute(new r1(this));
    }

    public final void c() {
        String defaultUserAgent;
        Context context = this.c;
        if (context != null) {
            try {
                defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            } catch (Throwable unused) {
                this.f1672a.set(false);
                defaultUserAgent = null;
            }
            if (TextUtils.isEmpty(defaultUserAgent)) {
                return;
            }
            this.b = defaultUserAgent;
            if (!TextUtils.isEmpty(this.b)) {
                IAlog.a("UserAgentProvider | populated user agent form updateUserAgentIfPossible", new Object[0]);
                this.d.compareAndSet(false, true);
            }
            r.f1668a.execute(new q1(this, defaultUserAgent));
        }
    }
}
