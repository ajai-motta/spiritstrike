package com.applovin.impl.mediation;

import com.applovin.impl.c3;
import com.applovin.impl.mediation.a;
import com.applovin.impl.mediation.c;
import com.applovin.impl.sdk.k;
import com.applovin.impl.t2;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: loaded from: classes2.dex */
public class b implements a.InterfaceC0151a, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f497a;
    private final a b;
    private final c c;

    public b(k kVar) {
        this.f497a = kVar;
        this.b = new a(kVar);
        this.c = new c(kVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void c(c3 c3Var) {
        h hVarA;
        if (c3Var == null || (hVarA = c3Var.A()) == null || !c3Var.w().compareAndSet(false, true)) {
            return;
        }
        t2.e(hVarA.c(), c3Var);
    }

    public void a() {
        this.c.a();
        this.b.a();
    }

    @Override // com.applovin.impl.mediation.a.InterfaceC0151a
    public void b(final c3 c3Var) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(c3Var);
            }
        }, c3Var.f0());
    }

    public void e(c3 c3Var) {
        long jG0 = c3Var.g0();
        if (jG0 >= 0) {
            this.c.a(c3Var, jG0);
        }
        if (c3Var.q0() || c3Var.r0()) {
            this.b.a(c3Var, this);
        }
    }

    @Override // com.applovin.impl.mediation.c.a
    public void a(c3 c3Var) {
        c(c3Var);
    }
}
