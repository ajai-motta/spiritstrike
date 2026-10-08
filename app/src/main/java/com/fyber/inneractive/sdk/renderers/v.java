package com.fyber.inneractive.sdk.renderers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.config.x0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.i0;
import com.fyber.inneractive.sdk.flow.m0;
import com.fyber.inneractive.sdk.flow.p0;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.player.controller.g0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends p0 implements g0, com.fyber.inneractive.sdk.flow.storepromo.observer.a {
    public com.fyber.inneractive.sdk.external.g D;
    public d0 F;
    public com.fyber.inneractive.sdk.interfaces.e w;
    public com.fyber.inneractive.sdk.player.ui.m x;
    public com.fyber.inneractive.sdk.player.controller.b y;
    public WeakReference z;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public UnitDisplayType E = UnitDisplayType.INTERSTITIAL;
    public boolean G = false;
    public final u H = new u(this);
    public final RelativeLayout.LayoutParams I = new RelativeLayout.LayoutParams(-1, -1);
    public boolean J = false;
    public boolean K = false;

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final boolean D() {
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        return mVar != null && mVar.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final void I() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final boolean K() {
        return this.J;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final int M() {
        Integer numA;
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar == null) {
            return -1;
        }
        t0 t0Var = (t0) xVar;
        if (t0Var.c == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.r) t0Var.c.a(com.fyber.inneractive.sdk.config.global.features.r.class)).a("close_clickable_area_dp")) == null) {
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
        t0 t0Var = (t0) xVar;
        if (t0Var.c == null || (numA = ((com.fyber.inneractive.sdk.config.global.features.r) t0Var.c.a(com.fyber.inneractive.sdk.config.global.features.r.class)).a("close_visible_size_dp")) == null) {
            return -1;
        }
        return numA.intValue();
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final long O() {
        int iA;
        d0 d0Var;
        if (InneractiveAdManager.isCurrentUserAChild()) {
            if (C()) {
                Integer numA = ((com.fyber.inneractive.sdk.config.global.features.c) ((t0) this.b).c.a(com.fyber.inneractive.sdk.config.global.features.c.class)).a("end_card_skip_time_sec");
                int iIntValue = numA != null ? numA.intValue() : 0;
                if (iIntValue < 0 || iIntValue > 5) {
                    iIntValue = 0;
                }
                if (iIntValue > 0) {
                    IAlog.a("%s: overriding endcard dismiss time with child mode with %d", IAlog.a(this), Integer.valueOf(iIntValue));
                    return iIntValue;
                }
            }
            IAlog.a("%s: overriding endcard dismiss time with child mode with %d", IAlog.a(this), 0);
            return 0L;
        }
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.config.l lVarA = iAConfigManager.u.b.a("endcard");
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.y;
        if (bVar == null && (d0Var = this.F) != null) {
            bVar = d0Var.f1597a;
        }
        com.fyber.inneractive.sdk.flow.endcard.k kVarJ = bVar != null ? ((com.fyber.inneractive.sdk.player.controller.z) bVar).j() : null;
        if (kVarJ != null) {
            com.fyber.inneractive.sdk.flow.endcard.b bVarA = kVarJ.b.a();
            iA = bVarA != null ? bVarA.f : kVarJ.f;
        } else {
            iA = iAConfigManager.u.b.a("vast_endcard_x_delay", 5, 0);
        }
        long j = iA;
        if (lVarA.f961a.containsKey("endcard_cr") || lVarA.f961a.containsKey("endcard_ci")) {
            String str = this.E != UnitDisplayType.REWARDED ? "endcard_ci" : "endcard_cr";
            long j2 = lVarA.f961a.containsKey(str) ? Long.parseLong((String) lVarA.f961a.get(str)) : j;
            if (j2 >= 0 && j2 <= 5) {
                IAlog.a("%s : overriding endcard dismiss time for type: %s with: %d sec.", IAlog.a(this), this.E, Long.valueOf(j2));
                this.t = true;
                j = j2;
            }
        }
        return j * 1000;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final boolean P() {
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        return mVar != null && mVar.b();
    }

    public final void Q() {
        if (this.B || this.c == null) {
            return;
        }
        this.B = true;
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null && (eVar.wasDismissedByUser() || IAConfigManager.O.u.b.a("endcard").a())) {
            com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_CLOSE;
            com.fyber.inneractive.sdk.flow.x xVar2 = this.b;
            if (xVar2 != null) {
                t0 t0Var = (t0) xVar2;
                if (t0Var.i != null) {
                    String[] strArr = {xVar.a()};
                    com.fyber.inneractive.sdk.player.t tVar = t0Var.i;
                    if (tVar != null) {
                        tVar.a("EVENT_TRACKING", strArr);
                    }
                }
            }
            com.fyber.inneractive.sdk.model.vast.x xVar3 = com.fyber.inneractive.sdk.model.vast.x.EVENT_CLOSE_LINEAR;
            com.fyber.inneractive.sdk.flow.x xVar4 = this.b;
            if (xVar4 != null) {
                t0 t0Var2 = (t0) xVar4;
                if (t0Var2.i != null) {
                    String[] strArr2 = {xVar3.a()};
                    com.fyber.inneractive.sdk.player.t tVar2 = t0Var2.i;
                    if (tVar2 != null) {
                        tVar2.a("EVENT_TRACKING", strArr2);
                    }
                }
            }
        }
        ((InneractiveFullscreenAdEventsListener) this.c).onAdDismissed(this.f1036a);
    }

    public final void R() {
        s0 s0Var;
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar == null || (s0Var = ((t0) xVar).d) == null) {
            return;
        }
        r0 r0Var = (r0) s0Var;
        if (r0Var.c != null) {
            UnitDisplayType unitDisplayType = r0Var.c.b;
            x0 x0Var = IAConfigManager.O.x;
            com.fyber.inneractive.sdk.cache.session.enums.c cVar = unitDisplayType == UnitDisplayType.REWARDED ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO;
            com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.CLICK;
            com.fyber.inneractive.sdk.cache.session.e eVar = x0Var.f987a;
            if (eVar != null) {
                com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final boolean b(com.fyber.inneractive.sdk.flow.x xVar) {
        boolean zBooleanValue;
        Boolean boolC;
        com.fyber.inneractive.sdk.config.global.r rVar;
        d0 d0Var;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.config.o oVar = iAConfigManager.u.b;
        oVar.getClass();
        String str = iAConfigManager.d;
        if ((oVar.b.containsKey(str) ? (com.fyber.inneractive.sdk.config.m) oVar.b.get(str) : new com.fyber.inneractive.sdk.config.m()).f963a.containsKey("endcard")) {
            return false;
        }
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.y;
        if (bVar == null && (d0Var = this.F) != null) {
            bVar = d0Var.f1597a;
        }
        com.fyber.inneractive.sdk.config.global.features.u uVar = null;
        com.fyber.inneractive.sdk.flow.endcard.k kVarJ = bVar != null ? ((com.fyber.inneractive.sdk.player.controller.z) bVar).j() : null;
        com.fyber.inneractive.sdk.flow.endcard.b bVarA = kVarJ != null ? kVarJ.b.a() : null;
        if (bVarA == null || bVarA.i() != com.fyber.inneractive.sdk.model.vast.i.Static) {
            return false;
        }
        com.fyber.inneractive.sdk.flow.x xVar2 = this.b;
        if (xVar2 != null && (rVar = ((t0) xVar2).c) != null) {
            uVar = (com.fyber.inneractive.sdk.config.global.features.u) rVar.a(com.fyber.inneractive.sdk.config.global.features.u.class);
        }
        UnitDisplayType unitDisplayType = this.E;
        uVar.getClass();
        int i = com.fyber.inneractive.sdk.config.global.features.s.f947a[unitDisplayType.ordinal()];
        if (i == 1) {
            Boolean boolC2 = uVar.c("countdown_rv");
            if (boolC2 == null) {
                return false;
            }
            zBooleanValue = boolC2.booleanValue();
        } else {
            if (i != 2 || (boolC = uVar.c("countdown_iv")) == null) {
                return false;
            }
            zBooleanValue = boolC.booleanValue();
        }
        return zBooleanValue;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void d() {
        if (!this.C) {
            this.u.a(true);
        }
        this.C = true;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.flow.b0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void destroy() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.destroy();
        }
        if (this.A) {
            Q();
        }
        com.fyber.inneractive.sdk.player.controller.b bVar = this.y;
        if (bVar != null) {
            ((com.fyber.inneractive.sdk.player.controller.z) bVar).b(this);
            this.y.destroy();
            this.y = null;
        }
        com.fyber.inneractive.sdk.player.ui.m mVar = this.x;
        if (mVar != null) {
            mVar.destroy();
            this.x = null;
        }
        this.w = null;
        this.z = null;
        super.destroy();
    }

    public final void e(boolean z) {
        if (P() && this.J) {
            return;
        }
        if (z) {
            com.fyber.inneractive.sdk.player.controller.b bVar = this.y;
            com.fyber.inneractive.sdk.flow.endcard.k kVarJ = bVar != null ? ((com.fyber.inneractive.sdk.player.controller.z) bVar).j() : null;
            com.fyber.inneractive.sdk.flow.endcard.o oVar = kVarJ != null ? (com.fyber.inneractive.sdk.flow.endcard.o) kVarJ.b.a(com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card) : null;
            this.u.a(oVar != null ? oVar.g().toString() : null);
            return;
        }
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        aVar.d = 0L;
        aVar.e = 0L;
        aVar.f = 0L;
        aVar.b = false;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void f() {
        R();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void g() {
        this.J = true;
        m0 m0Var = this.v;
        if (m0Var != null) {
            m0Var.cancel();
            this.v = null;
        }
        if (!this.s) {
            this.s = true;
            com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
            if (eVar != null) {
                c(eVar.isCloseButtonDisplay());
            }
        }
        com.fyber.inneractive.sdk.interfaces.e eVar2 = this.w;
        if (eVar2 == null || !eVar2.isCloseButtonDisplay()) {
            return;
        }
        d(true ^ this.t);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void i() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.dismissAd(false);
        }
        a(new WebViewRendererProcessHasGoneError());
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void j() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.dismissAd(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void k() {
        x0 x0Var = IAConfigManager.O.x;
        com.fyber.inneractive.sdk.cache.session.enums.c cVar = this.E == UnitDisplayType.INTERSTITIAL ? com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO;
        com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION;
        com.fyber.inneractive.sdk.cache.session.e eVar = x0Var.f987a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
        }
        G();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void l() {
        Q();
        InneractiveAdSpot inneractiveAdSpot = this.f1036a;
        if (inneractiveAdSpot == null || !(inneractiveAdSpot instanceof i0)) {
            return;
        }
        ((i0) inneractiveAdSpot).a();
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void n() {
        super.n();
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        if (!aVar.b || aVar.e <= 0) {
            return;
        }
        aVar.f += System.currentTimeMillis() - aVar.e;
        aVar.e = 0L;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void onCompleted() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) com.fyber.inneractive.sdk.util.v.a(this.z);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onCompleted();
        }
        x0 x0Var = IAConfigManager.O.x;
        UnitDisplayType unitDisplayType = this.E;
        UnitDisplayType unitDisplayType2 = UnitDisplayType.REWARDED;
        com.fyber.inneractive.sdk.cache.session.enums.c cVar = unitDisplayType == unitDisplayType2 ? com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO;
        com.fyber.inneractive.sdk.cache.session.enums.a aVar = com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION;
        com.fyber.inneractive.sdk.cache.session.e eVar = x0Var.f987a;
        if (eVar != null) {
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.cache.session.d(eVar, aVar, cVar));
        }
        if (this.E == unitDisplayType2) {
            com.fyber.inneractive.sdk.external.g gVar = this.D;
            if (gVar != null) {
                i0 i0Var = (i0) com.fyber.inneractive.sdk.util.v.a(((com.fyber.inneractive.sdk.flow.s0) gVar.f1024a).mAdSpot);
                InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener = gVar.f1024a.b;
                if (inneractiveFullScreenAdRewardedListener != null && i0Var != null) {
                    inneractiveFullScreenAdRewardedListener.onAdRewarded(i0Var);
                }
            }
            J();
        }
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar == null || ((t0) xVar).i == null) {
            return;
        }
        L();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void onPlayerError() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) com.fyber.inneractive.sdk.util.v.a(this.z);
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.dismissAd(false);
        }
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onPlayerError();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void onProgress(int i, int i2) {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) com.fyber.inneractive.sdk.util.v.a(this.z);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onProgress(i, i2);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void s() {
        super.s();
        com.fyber.inneractive.sdk.util.a aVar = this.u;
        if (aVar.b) {
            aVar.e = System.currentTimeMillis();
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean v() {
        com.fyber.inneractive.sdk.player.t tVar;
        com.fyber.inneractive.sdk.player.controller.b bVar;
        com.fyber.inneractive.sdk.interfaces.e eVar;
        com.fyber.inneractive.sdk.player.ui.m mVar;
        com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar2;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar;
        View view;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar2;
        View view2;
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar == null || (tVar = ((t0) xVar).i) == null || (bVar = this.y) == null || (eVar = this.w) == null || (mVar = this.x) == null) {
            return false;
        }
        com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) tVar.f;
        com.fyber.inneractive.sdk.flow.storepromo.b bVar3 = nVar.v;
        if (bVar3 != null && (bVar2 = bVar3.d) != null && (cVar = bVar2.d) != null && cVar.b != null && (view = cVar.f1116a) != null && view.getParent() != null && cVar.b.getVisibility() == 0) {
            com.fyber.inneractive.sdk.flow.storepromo.b bVar4 = nVar.v;
            com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar5 = bVar4.d;
            if (bVar5 == null || (cVar2 = bVar5.d) == null || cVar2.b == null || (view2 = cVar2.f1116a) == null || view2.getParent() == null || cVar2.b.getVisibility() != 0) {
                IAlog.f("StorePromoManager: hidePromo: unable hide promo: controller null or not ready", new Object[0]);
            } else {
                bVar4.d.a();
            }
        } else if (mVar.b()) {
            if (this.p) {
                eVar.dismissAd(true);
            }
        } else if (bVar.b()) {
            com.fyber.inneractive.sdk.player.controller.z zVar = (com.fyber.inneractive.sdk.player.controller.z) bVar;
            if (zVar.B()) {
                zVar.g(true);
            } else {
                zVar.d(true);
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.flow.b0
    public final void x() {
        View view = this.j;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        com.fyber.inneractive.sdk.config.t0 t0Var;
        super.a(eVar, activity);
        this.w = eVar;
        this.A = false;
        this.B = false;
        this.K = false;
        InneractiveUnitController selectedUnitController = this.f1036a.getSelectedUnitController();
        if (selectedUnitController != null) {
            if (selectedUnitController instanceof InneractiveFullscreenUnitController) {
                InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
                if (selectedContentController != null) {
                    if (selectedContentController instanceof InneractiveFullscreenVideoContentController) {
                        this.z = new WeakReference((InneractiveFullscreenVideoContentController) selectedContentController);
                    } else {
                        IAlog.f("%sContent controller expected to be InneractiveFullscreenVideoContentController and is %s", IAlog.a(this), selectedContentController.getClass().getSimpleName());
                    }
                }
            } else {
                IAlog.f("%sWrong type of unit controller found. Expecting InneractiveFullscreenUnitController", IAlog.a(this));
            }
        }
        s0 s0Var = this.f1036a.getAdContent().d;
        if (s0Var != null && (t0Var = ((r0) s0Var).f) != null) {
            this.E = t0Var.j;
        }
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        if (xVar != null) {
            ((t0) xVar).f();
        }
        com.fyber.inneractive.sdk.flow.x xVar2 = this.b;
        com.fyber.inneractive.sdk.player.t tVar = xVar2 != null ? ((t0) xVar2).i : null;
        Context context = this.w.getLayout().getContext();
        if (tVar != null) {
            com.fyber.inneractive.sdk.player.a aVar = tVar.f;
            if (aVar == null || ((com.fyber.inneractive.sdk.player.n) aVar).f1498a == null) {
                IAlog.f("%sFull screen video ad renderer is not valid.", IAlog.a(this));
                throw new InneractiveUnitController.AdDisplayError("Full screen video could not be loaded");
            }
            f fVar = aVar != null ? new f(tVar) : null;
            this.F = fVar;
            this.x = fVar.a(context, ((t0) this.b).c);
            com.fyber.inneractive.sdk.player.controller.b bVarA = this.F.a(this.f1036a, (t0) this.b);
            this.y = bVarA;
            this.F.b();
            bVarA.b(false);
            com.fyber.inneractive.sdk.player.controller.z zVar = (com.fyber.inneractive.sdk.player.controller.z) this.y;
            zVar.getClass();
            zVar.g = this;
            ((com.fyber.inneractive.sdk.player.controller.z) this.y).a(this);
            ((com.fyber.inneractive.sdk.player.ui.e) this.x).e();
            this.I.addRule(13);
            this.w.getLayout().addView((View) this.x, this.I);
            this.j = ((View) this.x).findViewById(R.id.ia_click_overlay);
            this.F.a(this.H);
            this.A = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        if ((!((r2 == null || (r2 = r2.E) == null || !android.text.TextUtils.equals(r2, "1")) ? false : true)) == false) goto L51;
     */
    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(boolean r6) {
        /*
            r5 = this;
            r5.e(r6)
            com.fyber.inneractive.sdk.player.controller.b r6 = r5.y
            r0 = 0
            if (r6 == 0) goto Lf
            com.fyber.inneractive.sdk.player.controller.z r6 = (com.fyber.inneractive.sdk.player.controller.z) r6
            com.fyber.inneractive.sdk.flow.endcard.k r6 = r6.j()
            goto L10
        Lf:
            r6 = r0
        L10:
            com.fyber.inneractive.sdk.player.ui.m r1 = r5.x
            if (r1 == 0) goto L22
            com.fyber.inneractive.sdk.player.ui.s r1 = (com.fyber.inneractive.sdk.player.ui.s) r1
            android.view.ViewGroup r1 = r1.q
            if (r1 == 0) goto L22
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L22
            goto La0
        L22:
            boolean r1 = r5.G
            if (r1 != 0) goto La0
            r1 = 0
            if (r6 == 0) goto L43
            com.fyber.inneractive.sdk.flow.x0 r2 = r6.f1049a
            com.fyber.inneractive.sdk.response.g r2 = r2.d
            r3 = 1
            if (r2 == 0) goto L3e
            java.lang.String r2 = r2.E
            if (r2 == 0) goto L3e
            java.lang.String r4 = "1"
            boolean r2 = android.text.TextUtils.equals(r2, r4)
            if (r2 == 0) goto L3e
            r2 = r3
            goto L3f
        L3e:
            r2 = r1
        L3f:
            r2 = r2 ^ r3
            if (r2 != 0) goto L43
            goto La0
        L43:
            if (r6 == 0) goto L4a
            com.fyber.inneractive.sdk.flow.endcard.b r6 = r6.a()
            goto L4b
        L4a:
            r6 = r0
        L4b:
            if (r6 == 0) goto L98
            com.fyber.inneractive.sdk.flow.x0 r2 = r6.c
            com.fyber.inneractive.sdk.model.vast.b r2 = r2.e
            com.fyber.inneractive.sdk.model.vast.o r2 = r2.f
            if (r2 == 0) goto L98
            boolean r2 = r2.d
            if (r2 == 0) goto L98
            r5.J = r1
            r5.p = r1
            com.fyber.inneractive.sdk.interfaces.e r2 = r5.k
            if (r2 == 0) goto L64
            r2.disableCloseButton()
        L64:
            com.fyber.inneractive.sdk.util.a r2 = r5.u
            r3 = 0
            r2.d = r3
            r2.e = r3
            r2.f = r3
            r2.b = r1
            java.lang.Runnable r1 = r5.l
            if (r1 == 0) goto L7b
            android.os.Handler r2 = com.fyber.inneractive.sdk.util.r.b
            r2.removeCallbacks(r1)
            r5.l = r0
        L7b:
            java.lang.Runnable r1 = r5.n
            if (r1 == 0) goto L86
            android.os.Handler r2 = com.fyber.inneractive.sdk.util.r.b
            r2.removeCallbacks(r1)
            r5.n = r0
        L86:
            r5.L()
            com.fyber.inneractive.sdk.renderers.d0 r0 = r5.F
            com.fyber.inneractive.sdk.player.controller.z r0 = r0.f1597a
            r0.a(r6)
            com.fyber.inneractive.sdk.interfaces.e r6 = r5.w
            if (r6 == 0) goto La7
            r6.secondEndCardWasDisplayed()
            goto La7
        L98:
            com.fyber.inneractive.sdk.interfaces.e r6 = r5.w
            if (r6 == 0) goto La7
            r6.destroy()
            goto La7
        La0:
            com.fyber.inneractive.sdk.interfaces.e r6 = r5.w
            if (r6 == 0) goto La7
            r6.destroy()
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.v.b(boolean):void");
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
        this.D = gVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final com.fyber.inneractive.sdk.util.d0 a(g1 g1Var, com.fyber.inneractive.sdk.util.g gVar) {
        Context context;
        com.fyber.inneractive.sdk.response.e eVar;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        R();
        if (this.x.getContext() == null) {
            context = com.fyber.inneractive.sdk.util.o.f1662a;
        } else {
            context = this.x.getContext();
        }
        Context context2 = context;
        com.fyber.inneractive.sdk.flow.x xVar = this.b;
        return a(context2, (xVar == null || (eVar = ((t0) xVar).b) == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).O) == null) ? null : bVar.b, g1Var, gVar, false, null);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(boolean z, Orientation orientation) {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar != null) {
            eVar.setActivityOrientation(z, orientation);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final boolean b(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.controller.b bVar = this.y;
        if (bVar == null) {
            IAlog.f("Unable to register store promo observer - ui controller unavailable", new Object[0]);
            return false;
        }
        return ((com.fyber.inneractive.sdk.player.controller.z) bVar).a(aVar);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(String str, String str2) {
        IAlog.a(IAlog.a(this) + "full screen video ad renderer callback: onSuspiciousNoUserWebActionDetected", new Object[0]);
        com.fyber.inneractive.sdk.interfaces.e eVar = this.w;
        if (eVar == null || eVar.getLayout() == null || this.w.getLayout().getContext() == null) {
            return;
        }
        if (!this.K) {
            com.fyber.inneractive.sdk.network.b0.a(this.w.getLayout().getContext(), str, str2, this.b);
            this.K = true;
            IAlog.a(IAlog.a(this) + "reporting auto redirect", new Object[0]);
            return;
        }
        IAlog.a(IAlog.a(this) + "redirect already reported for this ad", new Object[0]);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final com.fyber.inneractive.sdk.util.d0 a(String str, g1 g1Var, boolean z) {
        d0 d0Var;
        if (this.E == UnitDisplayType.INTERSTITIAL) {
            this.G = true;
        }
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.y;
        if (bVar == null && (d0Var = this.F) != null) {
            bVar = d0Var.f1597a;
        }
        com.fyber.inneractive.sdk.flow.endcard.k kVarJ = bVar != null ? ((com.fyber.inneractive.sdk.player.controller.z) bVar).j() : null;
        com.fyber.inneractive.sdk.flow.endcard.b bVarA = kVarJ != null ? kVarJ.b.a() : null;
        if (bVarA != null) {
            R();
            com.fyber.inneractive.sdk.util.d0 d0VarA = a(bVarA.c.f1127a, str, g1Var, bVarA.g(), false, null);
            if (d0VarA.f1648a != com.fyber.inneractive.sdk.util.g0.FAILED) {
                t0 t0Var = bVarA.c.b;
                String[] strArr = {com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK.toString()};
                com.fyber.inneractive.sdk.player.t tVar = t0Var.i;
                if (tVar != null) {
                    tVar.a("EVENT_TRACKING", strArr);
                }
            }
            return d0VarA;
        }
        return new com.fyber.inneractive.sdk.util.d0(com.fyber.inneractive.sdk.util.g0.FAILED, new Exception("No Companion clicked"));
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(boolean z) {
        com.fyber.inneractive.sdk.player.t tVar;
        com.fyber.inneractive.sdk.interfaces.e eVar;
        if (z) {
            com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_SKIP;
            com.fyber.inneractive.sdk.flow.x xVar2 = this.b;
            if (xVar2 != null) {
                t0 t0Var = (t0) xVar2;
                if (t0Var.i != null) {
                    String[] strArr = {xVar.a()};
                    com.fyber.inneractive.sdk.player.t tVar2 = t0Var.i;
                    if (tVar2 != null) {
                        tVar2.a("EVENT_TRACKING", strArr);
                    }
                }
            }
        }
        com.fyber.inneractive.sdk.flow.x xVar3 = this.b;
        if (xVar3 == null || (tVar = ((t0) xVar3).i) == null) {
            return;
        }
        tVar.a("TRACKING_COMPLETED", new String[0]);
        L();
        String[] strArr2 = new String[0];
        com.fyber.inneractive.sdk.player.t tVar3 = ((t0) this.b).i;
        if (tVar3 != null) {
            tVar3.a("TRACKING_COMPLETED", strArr2);
        }
        if (IAConfigManager.O.u.b.a("endcard").a() && z && (eVar = this.w) != null) {
            eVar.destroy();
        }
        e(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(View view, String str) {
        if (view != null) {
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(c(view), str);
            a(c(view), false, Float.NaN, Float.NaN);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.g0
    public final void a(View view) {
        a(c(view), false, Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final long a(long j) {
        if (this.t) {
            return j;
        }
        long j2 = 12;
        try {
            j2 = Long.parseLong(IAConfigManager.O.u.b.a("vast_endcard_x_fallback_delay", Long.toString(12L)));
        } catch (Throwable unused) {
        }
        return j2 * 1000;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.controller.b bVar = this.y;
        if (bVar == null) {
            IAlog.f("Unable to unregister store promo observer - ui controller unavailable", new Object[0]);
        } else {
            ((com.fyber.inneractive.sdk.player.controller.z) bVar).b(aVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.storepromo.observer.a
    public final void a(com.fyber.inneractive.sdk.flow.storepromo.observer.b bVar) {
        if (this.E == UnitDisplayType.INTERSTITIAL) {
            IAlog.a("InneractiveFullscreenVideoAdRenderer: update: StorePromo isClicked: %s", Boolean.valueOf(bVar.b));
            this.G = bVar.b;
        }
    }
}
