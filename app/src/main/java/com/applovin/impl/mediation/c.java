package com.applovin.impl.mediation;

import com.applovin.impl.c3;
import com.applovin.impl.g0;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.o;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f498a;
    private final o b;
    private final a c;
    private g0 d;

    public interface a {
        void a(c3 c3Var);
    }

    c(k kVar, a aVar) {
        this.f498a = kVar;
        this.b = kVar.O();
        this.c = aVar;
    }

    public void a(final c3 c3Var, long j) {
        if (o.a()) {
            this.b.a("AdHiddenCallbackTimeoutManager", "Scheduling in " + j + "ms...");
        }
        this.d = g0.a(j, this.f498a, new Runnable() { // from class: com.applovin.impl.mediation.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(c3Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(c3 c3Var) {
        if (o.a()) {
            this.b.a("AdHiddenCallbackTimeoutManager", "Timing out...");
        }
        this.c.a(c3Var);
    }

    public void a() {
        if (o.a()) {
            this.b.a("AdHiddenCallbackTimeoutManager", "Cancelling timeout");
        }
        g0 g0Var = this.d;
        if (g0Var != null) {
            g0Var.a();
            this.d = null;
        }
    }
}
