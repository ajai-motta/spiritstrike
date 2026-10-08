package com.fyber.inneractive.sdk.config;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t1;
import com.fyber.inneractive.sdk.util.v1;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f929a;

    public c(e eVar) {
        this.f929a = eVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.f929a.e.hasMessages(123) || this.f929a.f937a.get()) {
            return;
        }
        this.f929a.e.sendEmptyMessageDelayed(123, 3000L);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.fyber.inneractive.sdk.cache.session.g gVar;
        this.f929a.e.removeMessages(123);
        e eVar = this.f929a;
        if (eVar.f937a.compareAndSet(true, false)) {
            if (eVar.b) {
                IAlog.a("onActivityResumed: restartSession", new Object[0]);
                eVar.b = false;
                x0 x0Var = eVar.d;
                if (x0Var != null) {
                    com.fyber.inneractive.sdk.cache.session.e eVar2 = x0Var.f987a;
                    if (eVar2 != null) {
                        com.fyber.inneractive.sdk.cache.session.i iVar = eVar2.f907a;
                        for (com.fyber.inneractive.sdk.cache.session.enums.c cVar : com.fyber.inneractive.sdk.cache.session.enums.c.values()) {
                            if (cVar != com.fyber.inneractive.sdk.cache.session.enums.c.NONE && (gVar = (com.fyber.inneractive.sdk.cache.session.g) iVar.f911a.get(cVar)) != null && gVar.f910a != 0) {
                                eVar2.a(cVar, gVar);
                            }
                        }
                        com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar2, com.fyber.inneractive.sdk.cache.session.enums.a.NEW_SESSION, com.fyber.inneractive.sdk.cache.session.enums.c.NONE));
                    }
                    eVar.d.c.put("SESSION_STAMP", Long.toString(SystemClock.elapsedRealtime()));
                    eVar.d.b.clear();
                }
            }
            v1 v1Var = eVar.c;
            if (v1Var != null) {
                v1Var.d = false;
                v1Var.f = 0L;
                t1 t1Var = v1Var.c;
                if (t1Var != null) {
                    t1Var.removeMessages(1932593528);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
