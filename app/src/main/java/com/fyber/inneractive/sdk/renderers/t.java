package com.fyber.inneractive.sdk.renderers;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.i0;
import com.fyber.inneractive.sdk.flow.p0;
import com.fyber.inneractive.sdk.flow.q0;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.a1;
import com.fyber.inneractive.sdk.util.t1;
import com.fyber.inneractive.sdk.util.v1;
import com.iab.omid.library.fyber.adsession.AdSession;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends p0 {
    public v1 E;
    public com.fyber.inneractive.sdk.external.g I;
    public a1 J;
    public s w;
    public IAmraidWebViewController y;
    public boolean x = false;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public UnitDisplayType F = UnitDisplayType.INTERSTITIAL;
    public boolean G = false;
    public boolean H = false;

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final boolean K() {
        return !this.B && this.y.X;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final int M() {
        Integer numA;
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar == null) {
            return -1;
        }
        q0 q0Var = (q0) xVar;
        if (q0Var.c == null || q0Var.c.a(com.fyber.inneractive.sdk.config.global.features.e.class) == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.e) ((q0) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.e.class)).a("close_clickable_area_dp")) == null) {
            return -1;
        }
        return numA.intValue();
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final int N() {
        Integer numA;
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar == null) {
            return -1;
        }
        q0 q0Var = (q0) xVar;
        if (q0Var.c == null || q0Var.c.a(com.fyber.inneractive.sdk.config.global.features.e.class) == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.e) ((q0) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.e.class)).a("close_visible_size_dp")) == null) {
            return -1;
        }
        return numA.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    @Override // com.fyber.inneractive.sdk.flow.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long O() {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.t.O():long");
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final boolean P() {
        return false;
    }

    public final void R() {
        IAmraidWebViewController iAmraidWebViewController;
        if (this.b == null || (iAmraidWebViewController = this.y) == null) {
            IAlog.a("updateWebViewLayoutParams called, but web view is invalid", new Object[0]);
            return;
        }
        com.fyber.inneractive.sdk.web.m mVar = iAmraidWebViewController.b;
        if (mVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            mVar.setLayoutParams(layoutParams);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        s0 s0Var;
        super.a(eVar, activity);
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        l0 l0Var = (xVar == null || (s0Var = ((q0) xVar).d) == null) ? null : ((r0) s0Var).c;
        if (l0Var == null) {
            IAlog.f("%sNo display config for full screen mraid ad renderer! Cannot render", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("No display config for full screen mraid");
        }
        IAmraidWebViewController iAmraidWebViewController = xVar != null ? ((q0) xVar).i : null;
        this.y = iAmraidWebViewController;
        if (iAmraidWebViewController == null || iAmraidWebViewController.b == null) {
            IAlog.f("%sWeb view controller content is not valid. Web view might have crashed", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Web view could not be loaded");
        }
        ((q0) xVar).f();
        this.F = l0Var.b;
        this.z = false;
        this.A = false;
        this.J = new a1(this.f1036a);
        this.k = eVar;
        IAmraidWebViewController iAmraidWebViewController2 = this.y;
        if (iAmraidWebViewController2 == null) {
            IAlog.f("InneractiveFullscreenMraidAdRenderer.renderAd: Spot ad content is not the right content :( %s", this.b);
            return;
        }
        iAmraidWebViewController2.a(eVar.getCloseButton(), com.fyber.inneractive.sdk.measurement.tracker.d.CloseButton);
        com.fyber.inneractive.sdk.response.f fVar = (com.fyber.inneractive.sdk.response.f) ((q0) this.b).b;
        int i = fVar.e;
        int i2 = fVar.f;
        boolean z = (i == 300 && i2 == 250) || (i == 600 && i2 == 500);
        this.B = z;
        if (z) {
            this.y.setAdDefaultSize(com.fyber.inneractive.sdk.util.o.a(i), com.fyber.inneractive.sdk.util.o.a(i2));
        }
        if (this.w == null) {
            this.w = new s(this);
        }
        this.y.setListener(this.w);
        InneractiveAdSpot inneractiveAdSpot = this.f1036a;
        if (inneractiveAdSpot != null && inneractiveAdSpot.getAdContent() != null && activity != null) {
            com.fyber.inneractive.sdk.flow.x adContent = this.f1036a.getAdContent();
            com.fyber.inneractive.sdk.flow.g gVar = new com.fyber.inneractive.sdk.flow.g(activity, false, adContent.f1126a, adContent.b(), adContent.c);
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.ia_identifier_overlay);
            IFyberAdIdentifier.Corner corner = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
            IFyberAdIdentifier iFyberAdIdentifier = gVar.d;
            iFyberAdIdentifier.k = corner;
            iFyberAdIdentifier.a(viewGroup);
            viewGroup.setVisibility(0);
            this.y.a(viewGroup, com.fyber.inneractive.sdk.measurement.tracker.d.IdentifierView);
        }
        R();
        IAmraidWebViewController iAmraidWebViewController3 = this.y;
        ViewGroup layout = this.k.getLayout();
        InneractiveAdRequest inneractiveAdRequest = ((q0) this.b).f1126a;
        iAmraidWebViewController3.a(layout, (ViewGroup.LayoutParams) null);
        this.z = true;
        if (this.F == UnitDisplayType.REWARDED) {
            v1 v1Var = new v1(TimeUnit.SECONDS, IAConfigManager.O.u.b.a("rewarded_mraid_delay", 31, 30));
            this.E = v1Var;
            v1Var.e = new r(this);
            t1 t1Var = new t1(v1Var);
            v1Var.c = t1Var;
            v1Var.d = false;
            t1Var.sendEmptyMessage(1932593528);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final /* bridge */ /* synthetic */ boolean b(com.fyber.inneractive.sdk.flow.x xVar) {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final void d(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.y;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.a(view, com.fyber.inneractive.sdk.measurement.tracker.d.ProgressOverlay);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        InneractiveUnitController.EventsListener eventsListener;
        if (this.z && !this.A && (eventsListener = this.c) != null) {
            this.A = true;
            ((InneractiveFullscreenAdEventsListener) eventsListener).onAdDismissed(this.f1036a);
        }
        this.w = null;
        v1 v1Var = this.E;
        if (v1Var != null) {
            v1Var.e = null;
            this.E = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final void e(View view) {
        com.fyber.inneractive.sdk.measurement.tracker.e eVar;
        IAmraidWebViewController iAmraidWebViewController = this.y;
        if (iAmraidWebViewController == null || (eVar = iAmraidWebViewController.I) == null) {
            return;
        }
        try {
            AdSession adSession = eVar.f1151a;
            if (adSession == null || view == null) {
                return;
            }
            adSession.removeFriendlyObstruction(view);
        } catch (Throwable unused) {
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void l() {
        com.fyber.inneractive.sdk.config.global.r rVar;
        InneractiveUnitController.EventsListener eventsListener;
        if (this.F == UnitDisplayType.REWARDED && this.G) {
            Q();
        }
        if (!this.A && (eventsListener = this.c) != null) {
            this.A = true;
            ((InneractiveFullscreenAdEventsListener) eventsListener).onAdDismissed(this.f1036a);
        }
        a1 a1Var = this.J;
        if (a1Var != null && a1Var.b != 0) {
            long jCurrentTimeMillis = (System.currentTimeMillis() - a1Var.b) - a1Var.d;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long seconds = timeUnit.toSeconds(jCurrentTimeMillis);
            long millis = timeUnit.toMillis(jCurrentTimeMillis - TimeUnit.SECONDS.toMillis(seconds));
            Locale locale = Locale.US;
            String str = seconds + "." + millis;
            a1Var.b = 0L;
            a1Var.c = 0L;
            a1Var.d = 0L;
            InneractiveAdSpot inneractiveAdSpot = a1Var.f1644a;
            com.fyber.inneractive.sdk.flow.x adContent = inneractiveAdSpot != null ? inneractiveAdSpot.getAdContent() : null;
            com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.INTERSTITIAL_VIEW_TIME;
            InneractiveAdRequest inneractiveAdRequest = adContent != null ? adContent.f1126a : null;
            com.fyber.inneractive.sdk.response.e eVarB = adContent != null ? adContent.b() : null;
            JSONArray jSONArrayB = (adContent == null || (rVar = adContent.c) == null) ? null : rVar.b();
            com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVarB);
            wVar.c = uVar;
            wVar.f1220a = inneractiveAdRequest;
            wVar.d = jSONArrayB;
            wVar.a("time", str);
            wVar.a((String) null);
        }
        InneractiveAdSpot inneractiveAdSpot2 = this.f1036a;
        if (inneractiveAdSpot2 == null || !(inneractiveAdSpot2 instanceof i0)) {
            return;
        }
        ((i0) inneractiveAdSpot2).a();
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void n() {
        v1 v1Var;
        super.n();
        if (this.F == UnitDisplayType.REWARDED && (v1Var = this.E) != null) {
            v1Var.d = false;
            v1Var.a(SystemClock.uptimeMillis());
        }
        a1 a1Var = this.J;
        if (a1Var != null) {
            if (a1Var.b == 0) {
                a1Var.b = System.currentTimeMillis();
            }
            if (a1Var.c > 0) {
                a1Var.d += System.currentTimeMillis() - a1Var.c;
                a1Var.c = 0L;
            }
        }
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        if (!aVar.b || aVar.e <= 0) {
            return;
        }
        aVar.f += System.currentTimeMillis() - aVar.e;
        aVar.e = 0L;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void s() {
        v1 v1Var;
        super.s();
        if (this.F == UnitDisplayType.REWARDED && (v1Var = this.E) != null) {
            v1Var.d = true;
            t1 t1Var = v1Var.c;
            if (t1Var != null) {
                t1Var.removeMessages(1932593528);
            }
        }
        a1 a1Var = this.J;
        if (a1Var != null) {
            a1Var.c = System.currentTimeMillis();
        }
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        if (aVar.b) {
            aVar.e = System.currentTimeMillis();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean v() {
        boolean z;
        if (this.k != null) {
            if (this.F == UnitDisplayType.REWARDED) {
                if (this.G) {
                    Q();
                }
                z = this.G;
            } else {
                z = this.p;
            }
            if (!z) {
                return true;
            }
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar == null) {
            return false;
        }
        eVar.dismissAd(true);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final Context y() {
        IAmraidWebViewController iAmraidWebViewController = this.y;
        return c(iAmraidWebViewController != null ? iAmraidWebViewController.b : null);
    }

    public final void Q() {
        IAlog.a("%sprovide reward called", IAlog.a(this));
        if (this.H) {
            IAlog.a("%sreward was already provided", IAlog.a(this));
            return;
        }
        IAlog.a("%sreward sent", IAlog.a(this));
        if (this.I != null) {
            com.fyber.inneractive.sdk.flow.b0.a(com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION, com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_DISPLAY);
            com.fyber.inneractive.sdk.external.g gVar = this.I;
            i0 i0Var = (i0) com.fyber.inneractive.sdk.util.v.a(((com.fyber.inneractive.sdk.flow.s0) gVar.f1024a).mAdSpot);
            InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener = gVar.f1024a.b;
            if (inneractiveFullScreenAdRewardedListener != null && i0Var != null) {
                inneractiveFullScreenAdRewardedListener.onAdRewarded(i0Var);
            }
        }
        IAmraidWebViewController iAmraidWebViewController = this.y;
        if (iAmraidWebViewController == null || !iAmraidWebViewController.D) {
            J();
        }
        this.H = true;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void b(boolean z) {
        if (!K()) {
            if (z) {
                this.u.a((String) null);
            } else {
                com.fyber.inneractive.sdk.util.a aVar = this.u;
                aVar.d = 0L;
                aVar.e = 0L;
                aVar.f = 0L;
                aVar.b = false;
            }
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            eVar.destroy();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
        R();
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final long a(long j) {
        if (this.F == UnitDisplayType.REWARDED) {
            return 0L;
        }
        if (this.t) {
            return j;
        }
        long j2 = 13;
        try {
            j2 = Long.parseLong(IAConfigManager.O.u.b.a("mraid_x_fallback_delay", Long.toString(13L)));
        } catch (Throwable unused) {
        }
        return j2 * 1000;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
        this.I = gVar;
    }
}
