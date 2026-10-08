package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveAdRequest f1126a;
    public com.fyber.inneractive.sdk.response.e b;
    public final com.fyber.inneractive.sdk.config.global.r c;
    public final com.fyber.inneractive.sdk.config.s0 d;
    public boolean e = false;
    public boolean f = false;

    public x(com.fyber.inneractive.sdk.config.s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.d = s0Var;
        this.c = rVar;
    }

    public com.fyber.inneractive.sdk.web.v0 a() {
        return null;
    }

    public void a(String str) {
    }

    public boolean a(boolean z, com.fyber.inneractive.sdk.util.g gVar) {
        return false;
    }

    public com.fyber.inneractive.sdk.response.e b() {
        return this.b;
    }

    public boolean c() {
        com.fyber.inneractive.sdk.config.s0 s0Var = this.d;
        if (s0Var == null) {
            IAlog.f("%s : isFullscreenAd() called with unit config null", IAlog.a(this));
            return false;
        }
        com.fyber.inneractive.sdk.config.p0 p0Var = ((com.fyber.inneractive.sdk.config.r0) s0Var).e;
        return false;
    }

    public boolean d() {
        return false;
    }

    public abstract void destroy();

    public abstract boolean e();

    public void f() {
    }

    public abstract boolean isVideoAd();
}
