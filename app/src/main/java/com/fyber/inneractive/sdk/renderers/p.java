package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveAdViewVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.VideoContentListener;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.l0;
import com.fyber.inneractive.sdk.util.m0;
import com.fyber.inneractive.sdk.util.n0;

/* JADX INFO: loaded from: classes3.dex */
public class p extends e implements com.fyber.inneractive.sdk.interfaces.d, InneractiveNativeVideoContentController.Renderer, m0 {
    public FrameLayout l;
    public com.fyber.inneractive.sdk.player.ui.m m;
    public VideoContentListener n;
    public ViewGroup p;
    public d0 q;
    public n t;
    public final m o = new m(this);
    public float r = 0.0f;
    public final Rect s = new Rect();
    public boolean u = false;
    public final o v = new o(this);

    public void K() {
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar != null) {
            t0 t0Var = (t0) xVar;
            if (t0Var.j) {
                return;
            }
            t0Var.j = true;
            G();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void a(int i) {
    }

    public void b(ViewGroup viewGroup) {
        a(viewGroup);
    }

    @Override // com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        this.n = null;
        t();
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void m() {
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.k;
        if (bVar != null) {
            ((com.fyber.inneractive.sdk.player.controller.s) bVar).b(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int o() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController.Renderer
    public final void pauseVideo() {
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.k;
        if (bVar != null) {
            ((com.fyber.inneractive.sdk.player.controller.s) bVar).z();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveNativeVideoContentController.Renderer
    public final void playVideo() {
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.k;
        if (bVar != null) {
            ((com.fyber.inneractive.sdk.player.controller.s) bVar).c(0);
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void q() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void r() {
        com.fyber.inneractive.sdk.player.controller.q qVar;
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.k;
        if (bVar != null) {
            com.fyber.inneractive.sdk.player.controller.s sVar = (com.fyber.inneractive.sdk.player.controller.s) bVar;
            sVar.getClass();
            IAlog.a("%sfullscreenExited called", IAlog.a(sVar));
            sVar.E = false;
            sVar.j(sVar.D);
            com.fyber.inneractive.sdk.player.f fVar = sVar.f1259a;
            if (fVar == null || (qVar = fVar.f1498a) == null) {
                return;
            }
            sVar.a(qVar.e);
            sVar.a(sVar.f1259a.f1498a.b());
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void t() {
        ViewGroup viewGroup;
        n nVar = this.t;
        if (nVar != null && (viewGroup = this.p) != null) {
            viewGroup.removeCallbacks(nVar);
            this.t = null;
        }
        l0.f1658a.a(this.p);
        IAlog.a("%sunbind called. root is %s", IAlog.a(this), this.p);
        if (this.k != null) {
            IAlog.a("%sdestroying video ui controller", IAlog.a(this));
            com.fyber.inneractive.sdk.player.controller.s sVar = (com.fyber.inneractive.sdk.player.controller.s) this.k;
            sVar.getClass();
            sVar.g = null;
            ((com.fyber.inneractive.sdk.player.controller.s) this.k).destroy();
            this.k = null;
        }
        if (this.m != null) {
            this.p.setLayoutTransition(null);
            this.p.removeView(this.l);
            this.m.destroy();
            this.m = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final Context y() {
        return c(this.p);
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public View z() {
        return this.l;
    }

    public boolean a(com.fyber.inneractive.sdk.flow.x xVar) {
        return xVar instanceof t0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean b(View view) {
        return view != null && view.equals(this.p);
    }

    public void a(ViewGroup viewGroup) {
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
        this.u = false;
        this.l = new FrameLayout(viewGroup.getContext());
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        com.fyber.inneractive.sdk.player.t tVar = xVar != null ? ((t0) xVar).i : null;
        Context context = viewGroup.getContext();
        d0 d0VarA = a(tVar);
        this.q = d0VarA;
        if (d0VarA != null) {
            this.m = d0VarA.a(context, ((t0) this.b).c);
            this.k = (com.fyber.inneractive.sdk.player.controller.s) this.q.a(this.f1036a, (t0) this.b);
            this.p.addView(this.l, new ViewGroup.LayoutParams(-1, -2));
            this.p.setLayoutTransition(null);
            this.l.addView((View) this.m, new FrameLayout.LayoutParams(-2, -2, 17));
            com.fyber.inneractive.sdk.player.controller.s sVar = (com.fyber.inneractive.sdk.player.controller.s) this.k;
            o oVar = this.v;
            sVar.getClass();
            sVar.g = oVar;
            com.fyber.inneractive.sdk.player.controller.s sVar2 = (com.fyber.inneractive.sdk.player.controller.s) this.k;
            this.q.b();
            sVar2.b(false);
            this.q.a(this.o);
            n0 n0Var = l0.f1658a;
            ViewGroup viewGroup2 = this.p;
            n0Var.getClass();
            n0Var.a(viewGroup2.getContext(), viewGroup2, this);
        }
    }

    public boolean a(InneractiveUnitController inneractiveUnitController) {
        return inneractiveUnitController instanceof InneractiveAdViewUnitController;
    }

    public VideoContentListener a(InneractiveContentController inneractiveContentController) {
        if (!(inneractiveContentController instanceof InneractiveAdViewVideoContentController)) {
            IAlog.f("%sContent controller expected to be InneractiveFullscreenVideoContentController and is %s", IAlog.a(this), inneractiveContentController.getClass().getSimpleName());
            return null;
        }
        return (VideoContentListener) ((InneractiveAdViewVideoContentController) inneractiveContentController).getEventsListener();
    }

    @Override // com.fyber.inneractive.sdk.util.m0
    public final void a(float f, Rect rect) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        if (this.r == f && this.s.equals(rect)) {
            return;
        }
        this.r = f;
        this.s.set(rect);
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.k;
        if (bVar != null) {
            ((com.fyber.inneractive.sdk.player.controller.s) bVar).D = false;
            ((com.fyber.inneractive.sdk.player.ui.e) this.m).e();
            ((com.fyber.inneractive.sdk.player.controller.s) this.k).a(f);
        }
        if (f > 0.0f) {
            n nVar = this.t;
            if (nVar != null && (viewGroup2 = this.p) != null) {
                viewGroup2.removeCallbacks(nVar);
                this.t = null;
            }
            n nVar2 = new n(this);
            this.t = nVar2;
            this.p.postDelayed(nVar2, 100L);
            return;
        }
        n nVar3 = this.t;
        if (nVar3 == null || (viewGroup = this.p) == null) {
            return;
        }
        viewGroup.removeCallbacks(nVar3);
        this.t = null;
    }

    public d0 a(com.fyber.inneractive.sdk.player.t tVar) {
        if (tVar == null || tVar.f == null) {
            return null;
        }
        return new a(tVar);
    }
}
