package com.applovin.adview;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.applovin.impl.n2;
import com.applovin.impl.w1;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class AppLovinFullscreenAdViewObserver implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lifecycle f276a;
    private n2 b;
    private final AtomicBoolean c = new AtomicBoolean(true);
    private w1 d;

    public AppLovinFullscreenAdViewObserver(Lifecycle lifecycle, n2 n2Var) {
        this.f276a = lifecycle;
        this.b = n2Var;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f276a.removeObserver(this);
        n2 n2Var = this.b;
        if (n2Var != null) {
            n2Var.a();
            this.b = null;
        }
        w1 w1Var = this.d;
        if (w1Var != null) {
            w1Var.a("lifecycle_on_destroy");
            this.d.r();
            this.d = null;
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        w1 w1Var = this.d;
        if (w1Var != null) {
            w1Var.s();
            this.d.v();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        w1 w1Var;
        if (this.c.getAndSet(false) || (w1Var = this.d) == null) {
            return;
        }
        w1Var.t();
        this.d.b(0L);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        w1 w1Var = this.d;
        if (w1Var != null) {
            w1Var.u();
        }
    }

    public void setPresenter(w1 w1Var) {
        this.d = w1Var;
    }
}
