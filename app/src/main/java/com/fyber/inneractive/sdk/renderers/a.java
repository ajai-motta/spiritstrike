package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.flow.u0;

/* JADX INFO: loaded from: classes3.dex */
public class a extends d0 {
    public a(com.fyber.inneractive.sdk.player.t tVar) {
        super(tVar);
    }

    @Override // com.fyber.inneractive.sdk.renderers.d0
    public final void a(com.fyber.inneractive.sdk.player.e eVar) {
    }

    @Override // com.fyber.inneractive.sdk.renderers.d0
    public final void b() {
        this.c.getClass();
    }

    @Override // com.fyber.inneractive.sdk.renderers.d0
    public com.fyber.inneractive.sdk.player.ui.m a(Context context, com.fyber.inneractive.sdk.config.global.r rVar) {
        com.fyber.inneractive.sdk.player.ui.s sVar = this.b;
        return sVar == null ? new com.fyber.inneractive.sdk.player.ui.i(context, new com.fyber.inneractive.sdk.player.ui.h(), this.c, rVar, a()) : sVar;
    }

    @Override // com.fyber.inneractive.sdk.renderers.d0
    public com.fyber.inneractive.sdk.player.controller.b a(InneractiveAdSpot inneractiveAdSpot, t0 t0Var) {
        if (this.f1597a == null) {
            Object selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
            this.f1597a = new com.fyber.inneractive.sdk.player.controller.s(this.c, (com.fyber.inneractive.sdk.player.ui.o) this.b, com.fyber.inneractive.sdk.config.a.a(inneractiveAdSpot.getAdContent().b().o), t0Var.c, selectedUnitController instanceof u0 ? ((u0) selectedUnitController).isOverlayOutside() : false, a());
        }
        return this.f1597a;
    }
}
