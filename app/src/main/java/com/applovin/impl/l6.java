package com.applovin.impl;

import com.applovin.impl.e6;
import com.applovin.impl.p7;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
class l6 extends j5 {
    private final t7 g;
    private final AppLovinAdLoadListener h;

    l6(t7 t7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskRenderVastAd", kVar);
        this.h = appLovinAdLoadListener;
        this.g = t7Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Rendering VAST ad...");
        }
        int size = this.g.a().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String strA = "";
        y7 y7VarA = null;
        c8 c8VarA = null;
        s7 s7VarA = null;
        r7 r7VarA = null;
        String strA2 = "";
        for (q8 q8Var : this.g.a()) {
            q8 q8VarB = q8Var.b(b8.b(q8Var) ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.f : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.e);
            if (q8VarB != null) {
                q8 q8VarB2 = q8VarB.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.h);
                if (q8VarB2 != null) {
                    y7VarA = y7.a(q8VarB2, y7VarA, this.f428a);
                }
                strA = b8.a(q8VarB, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.i, strA);
                strA2 = b8.a(q8VarB, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.j, strA2);
                b8.a(q8VarB.a("Impression"), hashSet, this.g, this.f428a);
                q8 q8VarC = q8VarB.c("ViewableImpression");
                if (q8VarC != null) {
                    b8.a(q8VarC.a("Viewable"), hashSet, this.g, this.f428a);
                }
                q8 q8VarB3 = q8VarB.b("AdVerifications");
                if (q8VarB3 != null) {
                    r7VarA = r7.a(q8VarB3, r7VarA, this.g, this.f428a);
                }
                b8.a(q8VarB.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.c), hashSet2, this.g, this.f428a);
                q8 q8VarC2 = q8VarB.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.o);
                if (q8VarC2 != null) {
                    for (q8 q8Var2 : q8VarC2.b()) {
                        q8 q8VarC3 = q8Var2.c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.q);
                        if (q8VarC3 != null) {
                            c8VarA = c8.a(q8VarC3, c8VarA, this.g, this.f428a);
                        } else {
                            q8 q8VarB4 = q8Var2.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.L);
                            if (q8VarB4 != null) {
                                q8 q8VarB5 = q8VarB4.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.M);
                                if (q8VarB5 != null) {
                                    s7VarA = s7.a(q8VarB5, s7VarA, this.g, this.f428a);
                                }
                            } else if (com.applovin.impl.sdk.o.a()) {
                                this.c.b(this.b, "Received and will skip rendering for an unidentified creative: " + q8Var2);
                            }
                        }
                    }
                }
            } else if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Did not find wrapper or inline response for node: " + q8Var);
            }
        }
        p7 p7VarA = new p7.b().a(this.f428a).a(this.g.b()).b(this.g.e()).a(this.g.c()).b(strA).a(strA2).a(y7VarA).a(c8VarA).a(s7VarA).a(r7VarA).b(hashSet).a(r7VarA).a(hashSet2).a();
        u7 u7VarC = b8.c(p7VarA);
        if (u7VarC != null) {
            b8.a(this.g, this.h, u7VarC, -6, this.f428a);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finished rendering VAST ad: " + p7VarA);
        }
        p7VarA.getAdEventTracker().e();
        this.f428a.r0().a((j5) new o5(p7VarA, this.f428a, this.h), e6.b.CACHING);
    }
}
