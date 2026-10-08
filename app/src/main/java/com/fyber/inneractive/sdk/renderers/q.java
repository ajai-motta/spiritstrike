package com.fyber.inneractive.sdk.renderers;

import android.view.View;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.config.x0;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.p0;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.player.controller.g0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends p0 implements g0 {
    public boolean w = false;

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final boolean K() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final int M() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final int N() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final long O() {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final boolean P() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final long a(long j) {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final /* bridge */ /* synthetic */ boolean b(com.fyber.inneractive.sdk.flow.x xVar) {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void d() {
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        if (!this.w) {
            l();
        }
        this.b = null;
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void f() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void i() {
        a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void j() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void k() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void l() {
        this.w = true;
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar != null) {
        }
        IAlog.a("%sunit controller is null!", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void n() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void onCompleted() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void onPlayerError() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void onProgress(int i, int i2) {
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void s() {
    }

    @Override // com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.ui.controller.c
    public final void u() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean v() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void g() {
        IAlog.a("%snShownCloseButton", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final com.fyber.inneractive.sdk.util.d0 a(String str, g1 g1Var, boolean z) {
        return new com.fyber.inneractive.sdk.util.d0(com.fyber.inneractive.sdk.util.g0.FAILED, new Exception("No Companion clicked"));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final com.fyber.inneractive.sdk.util.d0 a(g1 g1Var, com.fyber.inneractive.sdk.util.g gVar) {
        s0 s0Var;
        l0 l0Var;
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar != null && (s0Var = ((t0) xVar).d) != null && (l0Var = ((r0) s0Var).c) != null) {
            UnitDisplayType unitDisplayType = l0Var.b;
            x0 x0Var = IAConfigManager.O.x;
            com.fyber.inneractive.sdk.cache.session.enums.c cVar = unitDisplayType == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO;
            com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.CLICK;
            com.fyber.inneractive.sdk.cache.session.e eVar = x0Var.f987a;
            if (eVar != null) {
                com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
            }
        }
        throw null;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(String str, String str2) {
        IAlog.a(IAlog.a(this) + "full screen video ad renderer callback: onSuspiciousNoUserWebActionDetected", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(View view, String str) {
        if (view == null || view.getContext() == null) {
            return;
        }
        InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
        a(c(view), false, Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(View view) {
        a(c(view), false, Float.NaN, Float.NaN);
    }
}
