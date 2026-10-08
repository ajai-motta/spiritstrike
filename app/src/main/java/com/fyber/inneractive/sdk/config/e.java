package com.fyber.inneractive.sdk.config;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.fyber.inneractive.sdk.util.t1;
import com.fyber.inneractive.sdk.util.v1;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements r {
    public v1 c;
    public final x0 d;
    public final d f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f937a = new AtomicBoolean(false);
    public boolean b = false;
    public final Handler e = new Handler(Looper.getMainLooper(), new b(this));

    public e(x0 x0Var) {
        c cVar = new c(this);
        this.f = new d(this);
        this.d = x0Var;
        Application application = com.fyber.inneractive.sdk.util.o.f1662a;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(cVar);
        }
    }

    public final void a() {
        s sVar = IAConfigManager.O.u;
        if (!sVar.d) {
            sVar.c.add(this);
        }
        v1 v1Var = new v1(TimeUnit.MINUTES, r0.u.b.a("session_duration", 30, 1));
        this.c = v1Var;
        v1Var.e = this.f;
    }

    @Override // com.fyber.inneractive.sdk.config.r
    public final void onGlobalConfigChanged(s sVar, o oVar) {
        v1 v1Var = this.c;
        if (v1Var != null) {
            v1Var.d = false;
            v1Var.f = 0L;
            t1 t1Var = v1Var.c;
            if (t1Var != null) {
                t1Var.removeMessages(1932593528);
            }
            v1 v1Var2 = new v1(TimeUnit.MINUTES, oVar.a("session_duration", 30, 1), this.c.f);
            this.c = v1Var2;
            v1Var2.e = this.f;
        }
        sVar.c.remove(this);
    }
}
