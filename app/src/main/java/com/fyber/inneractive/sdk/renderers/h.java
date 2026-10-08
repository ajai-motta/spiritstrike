package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.q0;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g0;
import com.fyber.inneractive.sdk.util.g1;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements com.fyber.inneractive.sdk.web.b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f1599a;

    public h(l lVar) {
        this.f1599a = lVar;
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final com.fyber.inneractive.sdk.util.d0 a(String str, g1 g1Var) {
        s0 s0Var;
        l lVar = this.f1599a;
        lVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a(lVar));
        ViewGroup viewGroup = this.f1599a.p;
        Context context = (viewGroup == null || viewGroup.getContext() == null) ? com.fyber.inneractive.sdk.util.o.f1662a : this.f1599a.p.getContext();
        if (context != null) {
            l lVar2 = this.f1599a;
            if (lVar2.f) {
                com.fyber.inneractive.sdk.flow.x xVar = lVar2.b;
                com.fyber.inneractive.sdk.response.e eVar = xVar != null ? ((q0) xVar).b : null;
                if (eVar != null) {
                    com.fyber.inneractive.sdk.flow.b0.a(eVar);
                }
                com.fyber.inneractive.sdk.flow.x xVar2 = this.f1599a.b;
                if (xVar2 != null && (s0Var = ((q0) xVar2).d) != null) {
                    r0 r0Var = (r0) s0Var;
                    if (r0Var.c != null) {
                        com.fyber.inneractive.sdk.flow.b0.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, r0Var.c.b == UnitDisplayType.MRECT ? com.fyber.inneractive.sdk.cache.session.enums.c.RECTANGLE_DISPLAY : com.fyber.inneractive.sdk.cache.session.enums.c.BANNER_DISPLAY);
                    }
                }
                return this.f1599a.a(context, str, g1Var, com.fyber.inneractive.sdk.util.g.DISPLAY, false, null);
            }
        }
        return new com.fyber.inneractive.sdk.util.d0(g0.FAILED, new Exception("No context or no native click detected"));
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void a(boolean z, Orientation orientation) {
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void b() {
        this.f1599a.c(true);
        l lVar = this.f1599a;
        lVar.getClass();
        IAlog.a("%sweb view callback: onResize", IAlog.a(lVar));
        l lVar2 = this.f1599a;
        InneractiveUnitController.EventsListener eventsListener = lVar2.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdResized(lVar2.f1036a);
        }
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void b(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void c() {
        l lVar = this.f1599a;
        lVar.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a(lVar));
        l lVar2 = this.f1599a;
        InneractiveUnitController.EventsListener eventsListener = lVar2.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdExpanded(lVar2.f1036a);
        }
        l lVar3 = this.f1599a;
        lVar3.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a(lVar3));
        this.f1599a.c(true);
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void d() {
        l lVar = this.f1599a;
        lVar.a(lVar.y(), false, Float.NaN, Float.NaN);
        this.f1599a.H();
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void onClose() {
        l lVar = this.f1599a;
        lVar.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a(lVar));
        l lVar2 = this.f1599a;
        InneractiveUnitController.EventsListener eventsListener = lVar2.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdCollapsed(lVar2.f1036a);
        }
        this.f1599a.O();
        l lVar3 = this.f1599a;
        lVar3.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a(lVar3));
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a() {
        this.f1599a.a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a(String str, String str2) {
        l lVar = this.f1599a;
        lVar.getClass();
        IAlog.a("%sweb view callback: onSuspiciousNoUserWebActionDetected", IAlog.a(lVar));
        ViewGroup viewGroup = this.f1599a.p;
        if (viewGroup == null || viewGroup.getContext() == null) {
            return;
        }
        l lVar2 = this.f1599a;
        if (!lVar2.v) {
            com.fyber.inneractive.sdk.network.b0.a(lVar2.p.getContext(), str, str2, this.f1599a.b);
            l lVar3 = this.f1599a;
            lVar3.v = true;
            lVar3.getClass();
            IAlog.a("%sreporting auto redirect", IAlog.a(lVar3));
            return;
        }
        lVar2.getClass();
        IAlog.a("%sredirect already reported for this ad", IAlog.a(lVar2));
    }

    @Override // com.fyber.inneractive.sdk.web.j1
    public final void a(boolean z) {
        s0 s0Var;
        l0 l0Var;
        com.fyber.inneractive.sdk.cache.session.enums.c cVar;
        l lVar = this.f1599a;
        lVar.getClass();
        IAlog.a("%sweb view callback: onVisibilityChanged: %s", IAlog.a(lVar), Boolean.valueOf(z));
        if (z) {
            l lVar2 = this.f1599a;
            if (!lVar2.o) {
                IAlog.a("%sonShownForTheFirstTime called", IAlog.a(lVar2));
                com.fyber.inneractive.sdk.flow.x xVar = lVar2.b;
                com.fyber.inneractive.sdk.response.e eVar = xVar != null ? ((q0) xVar).b : null;
                if (eVar != null) {
                    IAmraidWebViewController iAmraidWebViewController = lVar2.m;
                    if (iAmraidWebViewController != null) {
                        iAmraidWebViewController.l();
                    }
                    lVar2.b(eVar);
                    lVar2.G();
                }
                long jM = lVar2.M();
                lVar2.k = jM;
                if (jM != 0) {
                    lVar2.a(true, jM);
                }
                com.fyber.inneractive.sdk.flow.x xVar2 = lVar2.b;
                if (xVar2 != null && (s0Var = ((q0) xVar2).d) != null && (l0Var = ((r0) s0Var).c) != null) {
                    com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION;
                    if (l0Var.b == UnitDisplayType.MRECT) {
                        cVar = com.fyber.inneractive.sdk.cache.session.enums.c.RECTANGLE_DISPLAY;
                    } else {
                        cVar = com.fyber.inneractive.sdk.cache.session.enums.c.BANNER_DISPLAY;
                    }
                    com.fyber.inneractive.sdk.flow.b0.a(aVar, cVar);
                }
                this.f1599a.o = true;
                return;
            }
            d dVar = lVar2.y;
            if (dVar != null && !dVar.h && !dVar.g && dVar.f != 0) {
                dVar.f = 0L;
                dVar.g = true;
                dVar.a();
            }
            this.f1599a.O();
            return;
        }
        d dVar2 = this.f1599a.y;
        if (dVar2 != null && dVar2.g) {
            dVar2.g = false;
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar2.j);
        }
        this.f1599a.c(false);
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final boolean a(String str) {
        Context contextA = com.fyber.inneractive.sdk.util.o.a(this.f1599a.z());
        boolean zStartRichMediaIntent = InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(contextA, str);
        if (zStartRichMediaIntent) {
            l lVar = this.f1599a;
            if (lVar.c != null) {
                lVar.a(contextA, false, Float.NaN, Float.NaN);
            }
        }
        return zStartRichMediaIntent;
    }

    @Override // com.fyber.inneractive.sdk.web.b0
    public final void a(IAmraidWebViewController.MraidVideoFailedToDisplayError mraidVideoFailedToDisplayError) {
        l lVar = this.f1599a;
        InneractiveUnitController.EventsListener eventsListener = lVar.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdEnteredErrorState(lVar.f1036a, mraidVideoFailedToDisplayError);
        }
    }
}
