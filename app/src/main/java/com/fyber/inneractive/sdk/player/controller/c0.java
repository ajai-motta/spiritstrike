package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends s {
    public final AtomicBoolean F;

    public c0(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.s sVar, r0 r0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(fVar, sVar, r0Var, rVar, false, null);
        this.F = new AtomicBoolean(false);
        this.A = 0.5f;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final boolean B() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void C() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.s
    public final void H() {
        com.fyber.inneractive.sdk.player.ui.s sVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        q qVar = fVar != null ? fVar.f1498a : null;
        if (this.B < this.A || qVar == null || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed || qVar.j == null || (sVar = this.d) == null || !sVar.hasWindowFocus()) {
            return;
        }
        c(0);
        i(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.s
    public final void K() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.b
    public final void a(com.fyber.inneractive.sdk.flow.endcard.b bVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.s, com.fyber.inneractive.sdk.player.controller.z
    public final void b(g1 g1Var) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final boolean e() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void g(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void h() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final com.fyber.inneractive.sdk.web.b0 k() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final com.fyber.inneractive.sdk.flow.storepromo.b n() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void s() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.s
    public final void F() {
        com.fyber.inneractive.sdk.measurement.f fVar;
        q qVar;
        IAlog.a("%s handle buffering timeout: video paused on last shown frame", IAlog.a(this));
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1259a;
        if (fVar2 != null && (qVar = fVar2.f1498a) != null) {
            qVar.k();
            this.f1259a.f1498a.i();
        }
        com.fyber.inneractive.sdk.player.f fVar3 = this.f1259a;
        if (fVar3 == null || (fVar = fVar3.e) == null || fVar.c == null) {
            return;
        }
        IAlog.a("%s pause", "OMVideo");
        try {
            fVar.c.pause();
        } catch (Throwable th) {
            fVar.a(th);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.s, com.fyber.inneractive.sdk.ui.controller.b
    public final void a(float f) {
        boolean z = f >= 0.01f && this.F.compareAndSet(false, true);
        e(z);
        super.a(f);
        if (z) {
            IAlog.a("%sVisibility requirement met. visibleViewArea: %.1f%%", IAlog.a(this), Float.valueOf(f * 100.0f));
            ((com.fyber.inneractive.sdk.renderers.o) ((a0) this.g)).f1604a.K();
        }
    }
}
