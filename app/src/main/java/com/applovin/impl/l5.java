package com.applovin.impl;

import android.app.Activity;
import android.text.TextUtils;
import com.applovin.impl.e6;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class l5 extends j5 {
    private final List g;
    private final Activity h;

    public l5(List list, Activity activity, com.applovin.impl.sdk.k kVar) {
        super("TaskAutoInitAdapters", kVar, true);
        this.g = list;
        this.h = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(k3 k3Var) {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Auto-initing adapter: " + k3Var);
        }
        this.f428a.S().a(k3Var, this.h);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.g.size() > 0) {
            if (com.applovin.impl.sdk.o.a()) {
                com.applovin.impl.sdk.o oVar = this.c;
                String str = this.b;
                StringBuilder sb = new StringBuilder("Auto-initing ");
                sb.append(this.g.size());
                sb.append(" adapters");
                sb.append(this.f428a.t0().c() ? " in test mode" : "");
                sb.append("...");
                oVar.a(str, sb.toString());
            }
            if (TextUtils.isEmpty(this.f428a.V())) {
                this.f428a.Q0();
            } else if (!this.f428a.H0()) {
                com.applovin.impl.sdk.o.h("AppLovinSdk", "Auto-initing adapters for non-MAX mediation provider: " + this.f428a.V());
            }
            if (this.h == null) {
                com.applovin.impl.sdk.o.h("AppLovinSdk", "\n**********\nAttempting to init 3rd-party SDKs without an Activity instance.\n**********\n");
            }
            for (final k3 k3Var : this.g) {
                if (k3Var.s()) {
                    this.f428a.r0().a(new Runnable() { // from class: com.applovin.impl.l5$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.a(k3Var);
                        }
                    }, e6.b.MEDIATION);
                } else {
                    this.f428a.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        this.f428a.O().a(this.b, "Skipping eager auto-init for adapter " + k3Var);
                    }
                }
            }
        }
    }
}
