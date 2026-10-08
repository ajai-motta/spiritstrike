package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.t0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.fyber.inneractive.sdk.player.controller.z f1597a;
    public com.fyber.inneractive.sdk.player.ui.s b;
    public final com.fyber.inneractive.sdk.player.n c;

    public d0(com.fyber.inneractive.sdk.player.t tVar) {
        this.c = (com.fyber.inneractive.sdk.player.n) tVar.f;
    }

    public abstract com.fyber.inneractive.sdk.player.controller.b a(InneractiveAdSpot inneractiveAdSpot, t0 t0Var);

    public abstract com.fyber.inneractive.sdk.player.ui.m a(Context context, com.fyber.inneractive.sdk.config.global.r rVar);

    public String a() {
        t0 t0Var;
        com.fyber.inneractive.sdk.player.n nVar = this.c;
        com.fyber.inneractive.sdk.response.e eVar = (nVar == null || (t0Var = nVar.b) == null) ? null : t0Var.b;
        if (eVar != null) {
            return eVar.F;
        }
        return null;
    }

    public abstract void a(com.fyber.inneractive.sdk.player.e eVar);

    public abstract void b();
}
