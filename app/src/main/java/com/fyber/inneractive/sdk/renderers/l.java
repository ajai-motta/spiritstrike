package com.fyber.inneractive.sdk.renderers;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.l0;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.flow.q0;
import com.fyber.inneractive.sdk.mraid.f0;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.h1;
import com.iab.omid.library.fyber.adsession.AdSession;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends com.fyber.inneractive.sdk.flow.b0 implements com.fyber.inneractive.sdk.interfaces.d, com.fyber.inneractive.sdk.util.a0 {
    public InneractiveAdViewUnitController l;
    public IAmraidWebViewController m;
    public h n;
    public ViewGroup p;
    public j q;
    public i s;
    public d y;
    public long k = 0;
    public boolean o = false;
    public long r = 0;
    public int t = 0;
    public long u = 0;
    public boolean v = false;
    public boolean w = true;
    public boolean x = false;

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final int A() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return (iAmraidWebViewController.b == null || !iAmraidWebViewController.p()) ? com.fyber.inneractive.sdk.util.o.c(this.m.e0) : com.fyber.inneractive.sdk.util.o.c(this.m.b.getHeight());
        }
        return -1;
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final int B() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return (iAmraidWebViewController.b == null || !iAmraidWebViewController.p()) ? com.fyber.inneractive.sdk.util.o.c(this.m.d0) : com.fyber.inneractive.sdk.util.o.c(this.m.b.getWidth());
        }
        return -1;
    }

    public final void K() {
        if (this.s != null) {
            IAlog.a("%scancelling refreen runnable", IAlog.a(this));
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.s);
            this.s = null;
        }
    }

    public final void L() {
        d dVar = this.y;
        if (dVar != null) {
            dVar.g = false;
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar.j);
        }
        if (this.m != null) {
            K();
            com.fyber.inneractive.sdk.flow.x xVar = this.b;
            if (xVar != null) {
                ((q0) xVar).destroy();
            }
            this.m = null;
            this.b = null;
            ViewGroup viewGroup = this.p;
            if (viewGroup != null) {
                viewGroup.removeView(this.q);
            }
            j jVar = this.q;
            if (jVar != null) {
                jVar.removeAllViews();
                this.q = null;
            }
        }
        this.v = false;
    }

    public final int M() {
        l0 l0Var;
        int iIntValue;
        int i = this.t;
        if (i == -1) {
            IAlog.a("%sreturning disable value for banner refresh", IAlog.a(this));
            return 0;
        }
        if (i <= 0) {
            s0 s0Var = this.f1036a.getAdContent().d;
            if (s0Var != null && (l0Var = ((r0) s0Var).c) != null) {
                Integer num = l0Var.f962a;
                IAlog.a("%sreturning refreshConfig = %d", IAlog.a(this), num);
                if (num != null) {
                    iIntValue = num.intValue();
                }
            }
            IAlog.a("%sgetRefreshInterval: returning 0. Refresh is disabled", IAlog.a(this));
            return 0;
        }
        IAlog.a("%sreturning overriden refresh interval = %d", IAlog.a(this), Integer.valueOf(this.t));
        iIntValue = this.t;
        return iIntValue * 1000;
    }

    public final void N() {
        InneractiveAdViewUnitController inneractiveAdViewUnitController;
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || iAmraidWebViewController.b == null) {
            return;
        }
        IAlog.a("%srefreshing ad", IAlog.a(this));
        if ((!this.m.p() || this.m.N == f0.RESIZED) && (inneractiveAdViewUnitController = this.l) != null) {
            this.r = 0L;
            inneractiveAdViewUnitController.refreshAd();
        }
    }

    public final void O() {
        com.fyber.inneractive.sdk.web.m mVar;
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || (mVar = iAmraidWebViewController.b) == null || !mVar.getIsVisible() || this.r == 0 || this.m.p() || this.m.N == f0.RESIZED) {
            return;
        }
        if (!this.w) {
            if (this.k < System.currentTimeMillis() - this.r) {
                this.u = 1L;
            } else {
                this.u = this.k - (System.currentTimeMillis() - this.r);
            }
        }
        IAlog.a("%sresuming refresh runnable mRefreshTimeStamp %d", IAlog.a(this), Long.valueOf(this.u));
        a(false, this.u);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean a(com.fyber.inneractive.sdk.flow.x xVar) {
        return xVar instanceof q0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final boolean b(View view) {
        return view != null && view.equals(this.p);
    }

    public final void c(boolean z) {
        if (this.s != null) {
            this.w = z;
            K();
            this.u = this.k - (System.currentTimeMillis() - this.r);
            IAlog.a("%sPause refresh time : time remaning:%d ,refreshInterval: %d", IAlog.a(this), Long.valueOf(this.u), Long.valueOf(this.k));
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final boolean canRefreshAd() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return (iAmraidWebViewController.p() || this.m.N == f0.RESIZED) ? false : true;
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final void d(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.a(view, com.fyber.inneractive.sdk.measurement.tracker.d.ProgressOverlay);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        K();
        L();
        this.n = null;
        com.fyber.inneractive.sdk.util.z.f1680a.f1645a.remove(this);
        i iVar = this.s;
        if (iVar != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(iVar);
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int e() {
        return this.m.d0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void m() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final int o() {
        return this.m.e0;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void r() {
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void t() {
        d dVar = this.y;
        if (dVar != null) {
            dVar.g = false;
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar.j);
        }
        j jVar = this.q;
        if (jVar != null) {
            jVar.removeAllViews();
            this.q = null;
        }
        ViewGroup viewGroup = this.p;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.p = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final View z() {
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController != null) {
            return iAmraidWebViewController.b;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    @Override // com.fyber.inneractive.sdk.interfaces.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.ViewGroup r14) {
        /*
            Method dump skipped, instruction units count: 648
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.l.a(android.view.ViewGroup):void");
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void q() {
        com.fyber.inneractive.sdk.web.m mVar;
        IAlog.a("%sgot onAdRefreshFailed", IAlog.a(this));
        IAmraidWebViewController iAmraidWebViewController = this.m;
        if (iAmraidWebViewController == null || (mVar = iAmraidWebViewController.b) == null) {
            return;
        }
        if (!mVar.getIsVisible() || com.fyber.inneractive.sdk.util.z.f1680a.b || this.m.p() || this.m.N == f0.RESIZED) {
            IAlog.a("%sview is not visible or screen is locked or webView is Expanded or web is Resised. Waiting for visibility change", IAlog.a(this));
            this.u = 1L;
            return;
        }
        IAlog.a("%sview is visible and screen is unlocked: refreshing ad and webView is not expanded", IAlog.a(this));
        long jM = M();
        this.k = jM;
        if (jM != 0) {
            a(false, 10000L);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final void e(View view) {
        com.fyber.inneractive.sdk.measurement.tracker.e eVar;
        IAmraidWebViewController iAmraidWebViewController = this.m;
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

    public final void a(boolean z, long j) {
        IAmraidWebViewController iAmraidWebViewController;
        com.fyber.inneractive.sdk.web.m mVar;
        if (!TextUtils.isEmpty(this.f1036a.getMediationNameString()) || j == 0 || (this.f1036a.getSelectedUnitController() instanceof InneractiveFullscreenUnitController) || this.t == -1 || (iAmraidWebViewController = this.m) == null || (mVar = iAmraidWebViewController.b) == null) {
            return;
        }
        if (!mVar.getIsVisible()) {
            IAlog.a("%sstartRefreshTimer called but ad is not visible", IAlog.a(this));
            return;
        }
        this.r = System.currentTimeMillis();
        this.k = z ? this.k : j;
        IAlog.a("%sstartRefreshTimer in %d msec, mRefreshInterval = %d", IAlog.a(this), Long.valueOf(j), Long.valueOf(this.k));
        if (j > 1) {
            i iVar = this.s;
            if (iVar != null) {
                com.fyber.inneractive.sdk.util.r.b.removeCallbacks(iVar);
            }
            K();
            i iVar2 = new i(this);
            this.s = iVar2;
            com.fyber.inneractive.sdk.util.r.b.postDelayed(iVar2, j);
            return;
        }
        N();
    }

    public static h1 a(int i, int i2, s0 s0Var) {
        int iA;
        int iA2;
        l0 l0Var;
        IAlog.a("View layout params: response width and height: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i > 0 && i2 > 0) {
            iA = com.fyber.inneractive.sdk.util.o.a(i);
            iA2 = com.fyber.inneractive.sdk.util.o.a(i2);
        } else {
            UnitDisplayType unitDisplayType = UnitDisplayType.BANNER;
            if (s0Var != null && (l0Var = ((r0) s0Var).c) != null) {
                unitDisplayType = l0Var.b;
            }
            if (unitDisplayType.equals(UnitDisplayType.MRECT)) {
                iA = com.fyber.inneractive.sdk.util.o.a(k.RECTANGLE_WIDTH.value);
                iA2 = com.fyber.inneractive.sdk.util.o.a(k.RECTANGLE_HEIGHT.value);
            } else if (com.fyber.inneractive.sdk.util.k.m()) {
                iA = com.fyber.inneractive.sdk.util.o.a(k.BANNER_TABLET_WIDTH.value);
                iA2 = com.fyber.inneractive.sdk.util.o.a(k.BANNER_TABLET_HEIGHT.value);
            } else {
                iA = com.fyber.inneractive.sdk.util.o.a(k.BANNER_WIDTH.value);
                iA2 = com.fyber.inneractive.sdk.util.o.a(k.BANNER_HEIGHT.value);
            }
        }
        IAlog.e("View layout params: final scaled width and height: %d, %d", Integer.valueOf(iA), Integer.valueOf(iA2));
        return new h1(iA, iA2);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.d
    public final void a(int i) {
        this.t = i;
    }
}
