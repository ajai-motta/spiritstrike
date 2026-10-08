package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.c3;
import com.applovin.impl.o7;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.applovin.impl.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.c f486a;
    private final o b;
    private final String c;
    private InterfaceC0151a d;
    private c3 e;
    private String f;

    /* JADX INFO: renamed from: com.applovin.impl.mediation.a$a, reason: collision with other inner class name */
    public interface InterfaceC0151a {
        void b(c3 c3Var);
    }

    a(k kVar) {
        this.b = kVar.O();
        this.f486a = kVar.e();
        this.c = o7.a(k.o(), "AdActivityObserver", kVar);
    }

    public void a(c3 c3Var, InterfaceC0151a interfaceC0151a) {
        if (o.a()) {
            this.b.a("AdActivityObserver", "Starting for ad " + c3Var.getAdUnitId() + "...");
        }
        a();
        this.d = interfaceC0151a;
        this.e = c3Var;
        this.f486a.a(this);
    }

    @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity.getClass().getName().equals(this.c) && this.e.r0()) {
            if (o.a()) {
                this.b.a("AdActivityObserver", "App relaunched via launcher without an ad hidden callback, manually invoking ad hidden");
            }
            if (this.d != null) {
                if (o.a()) {
                    this.b.a("AdActivityObserver", "Invoking callback...");
                }
                this.d.b(this.e);
            }
            a();
            return;
        }
        if (this.f == null) {
            this.f = activity.getClass().getName();
            if (o.a()) {
                this.b.a("AdActivityObserver", "Started tracking ad Activity: " + this.f);
            }
        }
    }

    @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (activity.getClass().getName().equals(this.f)) {
            if (o.a()) {
                this.b.a("AdActivityObserver", "Ad Activity destroyed: " + this.f);
            }
            if (this.d != null) {
                if (o.a()) {
                    this.b.a("AdActivityObserver", "Invoking callback...");
                }
                this.d.b(this.e);
            }
            a();
        }
    }

    public void a() {
        if (o.a()) {
            this.b.a("AdActivityObserver", "Cancelling...");
        }
        this.f486a.b(this);
        this.d = null;
        this.e = null;
        this.f = null;
    }
}
