package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.MediaView;
import com.fyber.inneractive.sdk.external.NativeAdContent;
import com.fyber.inneractive.sdk.external.NativeAdUnitController;
import com.fyber.inneractive.sdk.external.NativeAdVideoContentController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.flow.w0;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;
import com.fyber.inneractive.sdk.util.l0;
import com.fyber.inneractive.sdk.util.n0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 extends p implements w {
    public com.fyber.inneractive.sdk.flow.nativead.trackers.a w;
    public WeakReference x;

    static {
        IAlog.a(c0.class);
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final boolean E() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final boolean F() {
        return true;
    }

    @Override // com.fyber.inneractive.sdk.renderers.p
    public final void K() {
        com.fyber.inneractive.sdk.flow.x xVar;
        com.fyber.inneractive.sdk.player.n nVar;
        InneractiveAdSpot inneractiveAdSpot = this.f1036a;
        if (inneractiveAdSpot == null || inneractiveAdSpot.getAdContent() == null || (xVar = this.b) == null || ((t0) xVar).j) {
            return;
        }
        IAlog.a("%sTracking impression", IAlog.a(this));
        com.fyber.inneractive.sdk.flow.nativead.trackers.a aVar = new com.fyber.inneractive.sdk.flow.nativead.trackers.a((w0) this.f1036a.getAdContent());
        this.w = aVar;
        aVar.a(this);
        d0 d0Var = this.q;
        if (d0Var != null && (nVar = d0Var.c) != null) {
            if (nVar.w.compareAndSet(false, true)) {
                nVar.a(nVar.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_IMPRESSION, com.fyber.inneractive.sdk.model.vast.x.EVENT_START);
            } else {
                IAlog.a("%sreportPlayStartEvents called, but start events was already reported", IAlog.a(nVar));
            }
        }
        super.K();
    }

    @Override // com.fyber.inneractive.sdk.renderers.p
    public final d0 a(com.fyber.inneractive.sdk.player.t tVar) {
        if (tVar != null) {
            return new x(tVar);
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.trackers.c
    public final void b() {
        com.fyber.inneractive.sdk.flow.nativead.trackers.a aVar = this.w;
        if (aVar != null) {
            aVar.a();
            this.w = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.renderers.p, com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        com.fyber.inneractive.sdk.flow.nativead.trackers.a aVar = this.w;
        if (aVar != null) {
            aVar.a();
            this.w = null;
        }
        WeakReference weakReference = this.x;
        com.fyber.inneractive.sdk.player.ui.t tVar = weakReference != null ? (com.fyber.inneractive.sdk.player.ui.t) weakReference.get() : null;
        if (tVar != null) {
            tVar.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
        }
        l0.f1658a.a(this.p);
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void initialize(InneractiveAdSpot inneractiveAdSpot) {
        super.initialize(inneractiveAdSpot);
        if (inneractiveAdSpot.getAdContent() instanceof w0) {
            this.b = ((w0) inneractiveAdSpot.getAdContent()).s;
        }
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        l0.f1658a.a(c(this.p).getApplicationContext());
        WeakReference weakReference = this.x;
        com.fyber.inneractive.sdk.player.ui.t tVar = weakReference != null ? (com.fyber.inneractive.sdk.player.ui.t) weakReference.get() : null;
        if (tVar != null) {
            com.fyber.inneractive.sdk.util.r.b.postDelayed(new com.fyber.inneractive.sdk.player.ui.d(tVar, z), 500L);
        }
    }

    @Override // com.fyber.inneractive.sdk.renderers.p, com.fyber.inneractive.sdk.flow.b0
    public final View z() {
        InneractiveAdSpot inneractiveAdSpot = this.f1036a;
        MediaView mediaView = (inneractiveAdSpot == null || !(inneractiveAdSpot.getAdContent() instanceof w0)) ? null : ((w0) this.f1036a.getAdContent()).n;
        return mediaView != null ? mediaView : this.p;
    }

    @Override // com.fyber.inneractive.sdk.renderers.p, com.fyber.inneractive.sdk.interfaces.d
    public final boolean a(com.fyber.inneractive.sdk.flow.x xVar) {
        return xVar instanceof NativeAdContent;
    }

    @Override // com.fyber.inneractive.sdk.renderers.p
    public final boolean a(InneractiveUnitController inneractiveUnitController) {
        return inneractiveUnitController instanceof NativeAdUnitController;
    }

    @Override // com.fyber.inneractive.sdk.renderers.p
    public final VideoContentListener a(InneractiveContentController inneractiveContentController) {
        if (!(inneractiveContentController instanceof NativeAdVideoContentController)) {
            IAlog.f("%s: Content controller expected to be NativeAdVideoContentController but it: %s", IAlog.a(this), inneractiveContentController);
            return null;
        }
        return (VideoContentListener) ((NativeAdVideoContentController) inneractiveContentController).getEventsListener();
    }

    @Override // com.fyber.inneractive.sdk.renderers.p, com.fyber.inneractive.sdk.interfaces.d
    public final void a(ViewGroup viewGroup) {
        com.fyber.inneractive.sdk.player.ui.t tVar;
        com.fyber.inneractive.sdk.player.n nVar;
        InneractiveAdSpot inneractiveAdSpot = this.f1036a;
        if (inneractiveAdSpot == null) {
            IAlog.f("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            return;
        }
        this.p = viewGroup;
        InneractiveUnitController selectedUnitController = inneractiveAdSpot.getSelectedUnitController();
        if (!a(selectedUnitController)) {
            IAlog.f("%sWrong type of unit controller found. Expecting InneractiveAdViewUnitController", IAlog.a(this));
        } else {
            this.n = a(selectedUnitController.getSelectedContentController());
        }
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        Float fValueOf = null;
        com.fyber.inneractive.sdk.player.t tVar2 = xVar != null ? ((t0) xVar).i : null;
        Context context = viewGroup.getContext();
        d0 d0VarA = a(tVar2);
        this.q = d0VarA;
        if (d0VarA == null) {
            IAlog.f("%s : can't render - video renderer is missing", IAlog.a(this));
            return;
        }
        com.fyber.inneractive.sdk.player.ui.m mVarA = d0VarA.a(context, ((t0) this.b).c);
        this.m = mVarA;
        if (mVarA instanceof com.fyber.inneractive.sdk.player.ui.t) {
            tVar = (com.fyber.inneractive.sdk.player.ui.t) mVarA;
            tVar.getViewTreeObserver().addOnWindowFocusChangeListener(this);
        } else {
            tVar = null;
        }
        this.x = new WeakReference(tVar);
        this.k = (com.fyber.inneractive.sdk.player.controller.s) this.q.a(this.f1036a, (t0) this.b);
        viewGroup.addView((View) this.m, new ViewGroup.LayoutParams(-1, -1));
        com.fyber.inneractive.sdk.player.controller.s sVar = (com.fyber.inneractive.sdk.player.controller.s) this.k;
        o oVar = this.v;
        sVar.getClass();
        sVar.g = oVar;
        com.fyber.inneractive.sdk.player.controller.s sVar2 = (com.fyber.inneractive.sdk.player.controller.s) this.k;
        this.q.b();
        sVar2.b(false);
        this.q.a(this.o);
        InneractiveAdSpot inneractiveAdSpot2 = this.f1036a;
        if (inneractiveAdSpot2 != null && (inneractiveAdSpot2.getAdContent() instanceof w0)) {
            w0 w0Var = (w0) this.f1036a.getAdContent();
            d0 d0Var = this.q;
            com.fyber.inneractive.sdk.player.controller.q qVar = (d0Var == null || (nVar = d0Var.c) == null) ? null : nVar.f1498a;
            if (qVar != null && qVar.e() > 0 && qVar.f() > 0) {
                fValueOf = Float.valueOf(qVar.f() / qVar.e());
            }
            w0Var.p = fValueOf;
        }
        n0 n0Var = l0.f1658a;
        ViewGroup viewGroup2 = this.p;
        n0Var.getClass();
        n0Var.a(viewGroup2.getContext(), viewGroup2, this);
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.k
    public final void a(String str, boolean z, com.fyber.inneractive.sdk.util.g gVar, com.fyber.inneractive.sdk.click.o oVar) {
        com.fyber.inneractive.sdk.flow.x xVar;
        InneractiveAdSpot inneractiveAdSpot = this.f1036a;
        if (inneractiveAdSpot != null && inneractiveAdSpot.getAdContent() != null && (xVar = this.b) != null && !((t0) xVar).j) {
            com.fyber.inneractive.sdk.ui.controller.b bVar = this.k;
            if (bVar instanceof com.fyber.inneractive.sdk.player.controller.c0) {
                ((com.fyber.inneractive.sdk.player.controller.c0) bVar).F.set(true);
            }
            com.fyber.inneractive.sdk.util.r.b.post(new b0(this));
        }
        com.fyber.inneractive.sdk.util.r.b.post(new com.fyber.inneractive.sdk.flow.y(this, c(this.p), str, new g1(), gVar, z, oVar));
    }
}
