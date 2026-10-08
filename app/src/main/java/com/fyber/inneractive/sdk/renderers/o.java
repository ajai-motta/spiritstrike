package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.fyber.inneractive.sdk.player.controller.a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f1604a;

    public o(p pVar) {
        this.f1604a = pVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void d() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void f() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void g() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void i() {
        this.f1604a.a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void j() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void k() {
        this.f1604a.K();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void onCompleted() {
        com.fyber.inneractive.sdk.player.ui.m mVar;
        p pVar = this.f1604a;
        VideoContentListener videoContentListener = pVar.n;
        if (videoContentListener == null || (mVar = pVar.m) == null || !((com.fyber.inneractive.sdk.player.ui.e) mVar).e) {
            return;
        }
        videoContentListener.onCompleted();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void onPlayerError() {
        com.fyber.inneractive.sdk.player.ui.m mVar;
        p pVar = this.f1604a;
        VideoContentListener videoContentListener = pVar.n;
        if (videoContentListener == null || (mVar = pVar.m) == null || !((com.fyber.inneractive.sdk.player.ui.e) mVar).e) {
            return;
        }
        videoContentListener.onPlayerError();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void onProgress(int i, int i2) {
        com.fyber.inneractive.sdk.player.ui.m mVar;
        p pVar = this.f1604a;
        VideoContentListener videoContentListener = pVar.n;
        if (videoContentListener == null || (mVar = pVar.m) == null || !((com.fyber.inneractive.sdk.player.ui.e) mVar).e) {
            return;
        }
        videoContentListener.onProgress(i, i2);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final com.fyber.inneractive.sdk.ignite.m p() {
        return com.fyber.inneractive.sdk.ignite.m.NONE;
    }

    @Override // com.fyber.inneractive.sdk.ui.controller.c
    public final void u() {
        this.f1604a.K();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(String str, String str2) {
        p pVar = this.f1604a;
        pVar.getClass();
        IAlog.a("%s ad view video ad renderer callback: onSuspiciousNoUserWebActionDetected", IAlog.a(pVar));
        ViewGroup viewGroup = this.f1604a.p;
        if (viewGroup == null || viewGroup.getContext() == null) {
            return;
        }
        p pVar2 = this.f1604a;
        if (!pVar2.u) {
            com.fyber.inneractive.sdk.network.b0.a(pVar2.p.getContext(), str, str2, this.f1604a.b);
            p pVar3 = this.f1604a;
            pVar3.u = true;
            pVar3.getClass();
            IAlog.a("%s reporting auto redirect", IAlog.a(pVar3));
            return;
        }
        pVar2.getClass();
        IAlog.a("%s redirect already reported for this ad", IAlog.a(pVar2));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(View view, String str) {
        if (view != null) {
            Context contextC = this.f1604a.c(view);
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(contextC, str);
            this.f1604a.a(contextC, false, Float.NaN, Float.NaN);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final com.fyber.inneractive.sdk.util.d0 a(g1 g1Var, com.fyber.inneractive.sdk.util.g gVar) {
        Context context;
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        p pVar = this.f1604a;
        if (pVar.m.getContext() == null) {
            context = com.fyber.inneractive.sdk.util.o.f1662a;
        } else {
            context = this.f1604a.m.getContext();
        }
        com.fyber.inneractive.sdk.flow.x xVar = this.f1604a.b;
        return pVar.a(context, (xVar == null || (eVar = ((t0) xVar).b) == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).O) == null) ? null : bVar.b, g1Var, gVar, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    @Override // com.fyber.inneractive.sdk.player.controller.g0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.util.d0 a(java.lang.String r10, com.fyber.inneractive.sdk.util.g1 r11, boolean r12) {
        /*
            r9 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            r1 = 0
            if (r0 == 0) goto L1d
            com.fyber.inneractive.sdk.renderers.p r0 = r9.f1604a
            com.fyber.inneractive.sdk.flow.x r0 = r0.b
            if (r0 == 0) goto L1d
            com.fyber.inneractive.sdk.flow.t0 r0 = (com.fyber.inneractive.sdk.flow.t0) r0
            com.fyber.inneractive.sdk.response.e r10 = r0.b
            if (r10 == 0) goto L1c
            com.fyber.inneractive.sdk.response.g r10 = (com.fyber.inneractive.sdk.response.g) r10
            com.fyber.inneractive.sdk.model.vast.b r10 = r10.O
            if (r10 == 0) goto L1c
            java.lang.String r10 = r10.b
            goto L1d
        L1c:
            r10 = r1
        L1d:
            com.fyber.inneractive.sdk.renderers.p r0 = r9.f1604a
            com.fyber.inneractive.sdk.ui.controller.b r2 = r0.k
            com.fyber.inneractive.sdk.player.controller.b r2 = (com.fyber.inneractive.sdk.player.controller.b) r2
            if (r2 != 0) goto L2b
            com.fyber.inneractive.sdk.renderers.d0 r0 = r0.q
            if (r0 == 0) goto L2b
            com.fyber.inneractive.sdk.player.controller.z r2 = r0.f1597a
        L2b:
            if (r2 == 0) goto L34
            com.fyber.inneractive.sdk.player.controller.z r2 = (com.fyber.inneractive.sdk.player.controller.z) r2
            com.fyber.inneractive.sdk.flow.endcard.k r0 = r2.j()
            goto L35
        L34:
            r0 = r1
        L35:
            if (r0 == 0) goto L3d
            com.fyber.inneractive.sdk.flow.endcard.m r0 = r0.b
            com.fyber.inneractive.sdk.flow.endcard.b r1 = r0.a()
        L3d:
            boolean r0 = r1 instanceof com.fyber.inneractive.sdk.flow.endcard.c
            if (r0 == 0) goto L4f
            com.fyber.inneractive.sdk.flow.endcard.c r1 = (com.fyber.inneractive.sdk.flow.endcard.c) r1
            com.fyber.inneractive.sdk.model.vast.c r0 = r1.g
            java.lang.String r0 = r0.g
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L4f
            r4 = r0
            goto L50
        L4f:
            r4 = r10
        L50:
            com.fyber.inneractive.sdk.renderers.p r2 = r9.f1604a
            android.view.ViewGroup r10 = r2.p
            android.content.Context r3 = r2.c(r10)
            if (r12 == 0) goto L5d
            com.fyber.inneractive.sdk.util.g r10 = com.fyber.inneractive.sdk.util.g.DEFAULT_ENDCARD
            goto L5f
        L5d:
            com.fyber.inneractive.sdk.util.g r10 = com.fyber.inneractive.sdk.util.g.VAST_ENDCARD
        L5f:
            r6 = r10
            r7 = 0
            r8 = 0
            r5 = r11
            com.fyber.inneractive.sdk.util.d0 r10 = r2.a(r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.o.a(java.lang.String, com.fyber.inneractive.sdk.util.g1, boolean):com.fyber.inneractive.sdk.util.d0");
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(View view) {
        p pVar = this.f1604a;
        if (pVar.c != null) {
            pVar.a(pVar.c(view), false, Float.NaN, Float.NaN);
        }
    }
}
