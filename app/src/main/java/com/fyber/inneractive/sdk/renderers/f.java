package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.flow.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends d0 {
    public f(com.fyber.inneractive.sdk.player.t tVar) {
        super(tVar);
    }

    @Override // com.fyber.inneractive.sdk.renderers.d0
    public final com.fyber.inneractive.sdk.player.ui.m a(Context context, com.fyber.inneractive.sdk.config.global.r rVar) {
        if (this.b == null) {
            this.b = new com.fyber.inneractive.sdk.player.ui.i(context, new com.fyber.inneractive.sdk.player.ui.f(), this.c, rVar, a());
        }
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.renderers.d0
    public final void b() {
        this.c.getClass();
    }

    @Override // com.fyber.inneractive.sdk.renderers.d0
    public final com.fyber.inneractive.sdk.player.controller.b a(InneractiveAdSpot inneractiveAdSpot, t0 t0Var) {
        if (this.f1597a == null) {
            Object selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
            this.f1597a = new com.fyber.inneractive.sdk.player.controller.g(this.c, this.b, inneractiveAdSpot.getAdContent().d, t0Var.c, selectedUnitController instanceof u0 ? ((u0) selectedUnitController).isOverlayOutside() : false, IAConfigManager.O.k || t0Var.f, a());
        }
        return this.f1597a;
    }

    @Override // com.fyber.inneractive.sdk.renderers.d0
    public final void a(com.fyber.inneractive.sdk.player.e eVar) {
        this.c.getClass();
        eVar.a();
    }
}
