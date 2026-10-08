package com.fyber.inneractive.sdk.renderers;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.flow.w0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;
import com.fyber.inneractive.sdk.util.l0;
import com.fyber.inneractive.sdk.util.m0;
import com.fyber.inneractive.sdk.util.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends e implements w, m0 {
    public ViewGroup l;
    public com.fyber.inneractive.sdk.flow.nativead.trackers.a n;
    public ImageView o;
    public boolean m = false;
    public final y p = new y(this);

    static {
        IAlog.a(a0.class);
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final boolean E() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.util.m0
    public final void a(float f, Rect rect) {
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.k;
        if (bVar != null) {
            ((com.fyber.inneractive.sdk.ui.controller.a) bVar).a(f);
        }
    }

    @Override // com.fyber.inneractive.sdk.renderers.w
    public final void b(ViewGroup viewGroup) {
        if (this.f1036a == null) {
            IAlog.f("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            return;
        }
        this.l = viewGroup;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        ImageView imageView = new ImageView(this.l.getContext());
        this.o = imageView;
        imageView.setImageURI(((w0) this.b).m);
        this.o.getViewTreeObserver().addOnWindowFocusChangeListener(this);
        this.l.setLayoutParams(layoutParams);
        this.l.addView(this.o, layoutParams);
        com.fyber.inneractive.sdk.ui.controller.a aVar = new com.fyber.inneractive.sdk.ui.controller.a();
        this.k = aVar;
        aVar.f1634a = this.p;
        n0 n0Var = l0.f1658a;
        ViewGroup viewGroup2 = this.l;
        n0Var.getClass();
        n0Var.a(viewGroup2.getContext(), viewGroup2, this);
    }

    @Override // com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        com.fyber.inneractive.sdk.flow.nativead.trackers.a aVar = this.n;
        if (aVar != null) {
            aVar.a();
            this.n = null;
        }
        ImageView imageView = this.o;
        if (imageView != null) {
            imageView.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            this.o = null;
        }
        l0.f1658a.a(this.l);
        com.fyber.inneractive.sdk.util.v.a(this.l);
        this.l = null;
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.k;
        if (bVar != null) {
            ((com.fyber.inneractive.sdk.ui.controller.a) bVar).f1634a = null;
        }
        super.destroy();
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public final void onWindowFocusChanged(boolean z) {
        l0.f1658a.a(com.fyber.inneractive.sdk.util.o.a(z()).getApplicationContext());
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final View z() {
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar != null) {
            w0 w0Var = (w0) xVar;
            if (w0Var.n != null) {
                return w0Var.n;
            }
        }
        return this.l;
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.k
    public final void a(String str, boolean z, com.fyber.inneractive.sdk.util.g gVar, com.fyber.inneractive.sdk.click.o oVar) {
        if (!this.m) {
            com.fyber.inneractive.sdk.util.r.b.post(new z(this));
            com.fyber.inneractive.sdk.ui.controller.b bVar = this.k;
            if (bVar instanceof com.fyber.inneractive.sdk.ui.controller.a) {
                ((com.fyber.inneractive.sdk.ui.controller.a) bVar).b.set(true);
            }
        }
        com.fyber.inneractive.sdk.util.r.b.post(new com.fyber.inneractive.sdk.flow.y(this, com.fyber.inneractive.sdk.util.o.a(z()), str, new g1(), gVar, z, oVar));
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.trackers.c
    public final void b() {
        com.fyber.inneractive.sdk.flow.nativead.trackers.a aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
    }
}
