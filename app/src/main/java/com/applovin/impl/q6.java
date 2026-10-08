package com.applovin.impl;

import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;

/* JADX INFO: loaded from: classes2.dex */
class q6 extends j5 {
    private final t7 g;
    private final AppLovinAdLoadListener h;

    q6(t7 t7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskResolveVastWrapper", kVar);
        this.h = appLovinAdLoadListener;
        this.g = t7Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strA = b8.a(this.g);
        if (!StringUtils.isValidString(strA)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Resolving VAST failed. Could not find resolution URL");
            }
            a(-1);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Resolving VAST ad with depth " + this.g.d() + " at " + strA);
        }
        try {
            this.f428a.r0().a(new a(com.applovin.impl.sdk.network.a.a(this.f428a).b(strA).c("GET").a(q8.f).a(((Integer) this.f428a.a(y4.V4)).intValue()).c(((Integer) this.f428a.a(y4.W4)).intValue()).a(false).a(), this.f428a));
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to resolve VAST wrapper", th);
            }
            a(-1);
        }
    }

    class a extends m6 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar) {
            super(aVar, kVar);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, q8 q8Var, int i) {
            this.f428a.r0().a(i6.a(q8Var, q6.this.g, q6.this.h, q6.this.f428a));
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, q8 q8Var) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to resolve VAST wrapper. Server returned " + i);
            }
            q6.this.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Failed to resolve VAST wrapper due to error code " + i);
        }
        if (i == -1009) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.h;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
                return;
            }
            return;
        }
        b8.a(this.g, this.h, i == -1001 ? u7.TIMED_OUT : u7.GENERAL_WRAPPER_ERROR, i, this.f428a);
    }
}
