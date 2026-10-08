package com.fyber.inneractive.sdk.player.controller;

import android.app.Application;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.Skip;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.config.t0;
import com.fyber.inneractive.sdk.config.w0;
import com.fyber.inneractive.sdk.config.x0;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.fyber.adsession.media.InteractionType;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z implements b, p, o, com.fyber.inneractive.sdk.player.ui.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.player.f f1259a;
    public final s0 b;
    public final com.fyber.inneractive.sdk.config.global.r c;
    public final com.fyber.inneractive.sdk.player.ui.s d;
    public x e;
    public g0 g;
    public Runnable j;
    public boolean k;
    public u m;
    public final boolean n;
    public com.fyber.inneractive.sdk.player.ui.g u;
    public final String v;
    public int f = 0;
    public boolean h = false;
    public float i = -0.1f;
    public boolean l = false;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public com.fyber.inneractive.sdk.ignite.m t = com.fyber.inneractive.sdk.ignite.m.NONE;
    public boolean w = false;
    public boolean y = false;
    public final Skip x = null;

    public z(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.s sVar, s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, String str) {
        q qVar;
        this.f1259a = fVar;
        this.b = s0Var;
        this.c = rVar;
        this.d = sVar;
        this.n = z;
        this.v = str;
        sVar.setListener(this);
        if (fVar == null || (qVar = fVar.f1498a) == null) {
            return;
        }
        if (!qVar.b.contains(this)) {
            qVar.b.add(this);
        }
        q qVar2 = fVar.f1498a;
        if (qVar2.c.contains(this)) {
            return;
        }
        qVar2.c.add(this);
    }

    public static int l() {
        int i;
        try {
            i = Integer.parseInt(IAConfigManager.O.u.b.a("max_rv_tsec", Integer.toString(30)));
        } catch (Throwable unused) {
            i = 30;
        }
        if (i < 1) {
            return 30;
        }
        return i;
    }

    public abstract boolean A();

    public boolean B() {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        t0 t0Var;
        s0 s0Var = this.b;
        boolean z = (s0Var == null || (t0Var = ((r0) s0Var).f) == null || t0Var.j != UnitDisplayType.REWARDED) ? false : true;
        if (!InneractiveAdManager.isCurrentUserAChild() || !z || this.d == null || (fVar = this.f1259a) == null || (qVar = fVar.f1498a) == null) {
            return false;
        }
        int iB = qVar.b() / 1000;
        return (this.f1259a.f1498a.c() / 1000) - iB <= 0 || iB < l();
    }

    public void C() {
        Boolean boolC;
        com.fyber.inneractive.sdk.config.global.r rVar = this.c;
        com.fyber.inneractive.sdk.config.global.features.u uVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.u) rVar.a(com.fyber.inneractive.sdk.config.global.features.u.class) : null;
        boolean zBooleanValue = (uVar == null || (boolC = uVar.c("show_cta")) == null) ? true : boolC.booleanValue();
        g0 g0Var = this.g;
        if (g0Var != null) {
            this.t = g0Var.p();
        }
        com.fyber.inneractive.sdk.ignite.m mVar = this.t;
        this.d.a(mVar == com.fyber.inneractive.sdk.ignite.m.NONE ? zBooleanValue : true, mVar);
    }

    public final void D() {
        com.fyber.inneractive.sdk.flow.endcard.b bVarA;
        g0 g0Var;
        com.fyber.inneractive.sdk.flow.storepromo.controller.c cVar;
        boolean z;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar2;
        com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar3;
        View view;
        View view2;
        com.fyber.inneractive.sdk.flow.endcard.b bVar;
        com.fyber.inneractive.sdk.model.vast.o oVar;
        this.d.h();
        com.fyber.inneractive.sdk.flow.endcard.k kVarJ = j();
        if (kVarJ != null) {
            bVarA = kVarJ.a();
            com.fyber.inneractive.sdk.flow.endcard.h hVar = kVarJ.e;
            com.fyber.inneractive.sdk.flow.endcard.m mVar = kVarJ.b;
            hVar.getClass();
            if (mVar.f1058a.size() >= 1) {
                com.fyber.inneractive.sdk.flow.endcard.b bVarA2 = mVar.a();
                com.fyber.inneractive.sdk.model.vast.i iVar = com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card;
                Iterator it = mVar.f1058a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        bVar = null;
                        break;
                    } else {
                        bVar = (com.fyber.inneractive.sdk.flow.endcard.b) it.next();
                        if (bVar.i() == iVar) {
                            break;
                        }
                    }
                }
                if (bVarA2 != null && bVarA2.i() != com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card && bVarA2.i() != com.fyber.inneractive.sdk.model.vast.i.Default_End_Card && bVarA2.l() && (oVar = bVarA2.c.e.f) != null && oVar.d && bVar != null && bVar.l()) {
                    hVar.a(bVarA2, bVar.l());
                    hVar.a(bVar, true, bVarA2.k());
                } else if (bVarA2 == bVar || bVarA2 == null || bVarA2.g() == com.fyber.inneractive.sdk.util.g.DEFAULT_ENDCARD) {
                    hVar.a(bVarA2, false, false);
                } else {
                    hVar.a(bVarA2, false);
                }
            }
        } else {
            bVarA = null;
        }
        if (bVarA == null) {
            if (e() || (g0Var = this.g) == null) {
                return;
            }
            g0Var.j();
            return;
        }
        a(bVarA);
        if (n() != null) {
            com.fyber.inneractive.sdk.flow.storepromo.b bVarN = n();
            com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
            com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar2 = bVarN.d;
            if (bVar2 == null || (cVar = bVar2.c) == null || !(z = cVar.e)) {
                bVarN.f1093a.a();
                bVarN.a();
                bVarN.a((bVarN.d == null ? com.fyber.inneractive.sdk.flow.storepromo.events.a.CONTROLLER_NOT_INITIALIZED : com.fyber.inneractive.sdk.flow.storepromo.events.a.TEMPLATE_NOT_LOADED).name(), (String) null, (String) null);
                return;
            }
            bVar2.i = kVarJ;
            if (cVar == null || !z || (cVar2 = bVar2.d) == null || bVar2.g) {
                return;
            }
            if (cVar2.b == null || (view2 = cVar2.f1116a) == null || view2.getParent() == null || cVar2.b.getVisibility() != 0) {
                com.fyber.inneractive.sdk.flow.storepromo.ui.c cVar4 = bVar2.d;
                if (cVar4.b == null || cVar4.f1116a == null) {
                    IAlog.f("StorePromoView: show: missing container or content", new Object[0]);
                    return;
                }
                cVar4.a();
                com.fyber.inneractive.sdk.util.v.a(cVar4.b);
                sVar.addView(cVar4.b);
                cVar4.f1116a.setAnimation(cVar4.c);
                cVar4.b.setVisibility(0);
                com.fyber.inneractive.sdk.flow.storepromo.b bVar3 = cVar4.f;
                if (bVar3 != null) {
                    com.fyber.inneractive.sdk.flow.storepromo.controller.b bVar4 = bVar3.d;
                    com.fyber.inneractive.sdk.flow.storepromo.observer.b bVar5 = new com.fyber.inneractive.sdk.flow.storepromo.observer.b((bVar4 == null || (cVar3 = bVar4.d) == null || cVar3.b == null || (view = cVar3.f1116a) == null || view.getParent() == null || cVar3.b.getVisibility() != 0) ? false : true, bVar3.i);
                    Iterator it2 = bVar3.h.iterator();
                    while (it2.hasNext()) {
                        ((com.fyber.inneractive.sdk.flow.storepromo.observer.a) it2.next()).a(bVar5);
                    }
                    JSONObject jSONObject = new JSONObject();
                    Integer numValueOf = Integer.valueOf(bVar3.g);
                    try {
                        jSONObject.put("screenshots", numValueOf);
                    } catch (Exception unused) {
                        IAlog.f("Got exception adding param to json object: %s, %s", "screenshots", numValueOf);
                    }
                    com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.VAST_EVENT_SP_IMPRESSION;
                    InneractiveAdRequest inneractiveAdRequest = bVar3.c;
                    com.fyber.inneractive.sdk.response.e eVar = bVar3.b;
                    String str = bVar3.f;
                    com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(uVar, inneractiveAdRequest, eVar);
                    try {
                        jSONObject.put("templateURL", str);
                    } catch (Exception unused2) {
                        IAlog.f("Got exception adding param to json object: %s, %s", "templateURL", str);
                    }
                    wVar.f.put(jSONObject);
                    wVar.a((String) null);
                }
            }
        }
    }

    public void E() {
        boolean z;
        q qVar;
        q qVar2;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null && (((qVar2 = fVar.f1498a) != null && qVar2.e == com.fyber.inneractive.sdk.player.enums.b.Completed) || this.q)) {
            fVar.a();
        }
        boolean zA = IAConfigManager.O.u.b.a("endcard").a();
        com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
        com.fyber.inneractive.sdk.player.f fVar2 = this.f1259a;
        sVar.e((fVar2 == null || (qVar = fVar2.f1498a) == null || qVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed) && !(((z = this.q) && !zA) || this.r || (z && zA)));
    }

    public void a() {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.mediaplayer.o oVar) {
    }

    public abstract void b(g1 g1Var);

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public boolean b() {
        com.fyber.inneractive.sdk.player.ui.s sVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null) {
            return false;
        }
        if (!this.h && fVar.f1498a != null && ((sVar = this.d) == null || !sVar.i())) {
            int iC = this.f1259a.f1498a.c();
            com.fyber.inneractive.sdk.player.f fVar2 = this.f1259a;
            if (!com.fyber.inneractive.sdk.player.f.a(iC, com.fyber.inneractive.sdk.player.f.a(fVar2), ((com.fyber.inneractive.sdk.player.n) fVar2).s) || this.h || this.f != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void c(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void d() {
        if (this.o && !this.l) {
            this.l = true;
        }
    }

    @Override // com.fyber.inneractive.sdk.ui.controller.b
    public void destroy() {
        q qVar;
        Application application;
        u uVar = this.m;
        if (uVar != null && (application = com.fyber.inneractive.sdk.util.o.f1662a) != null) {
            application.unregisterActivityLifecycleCallbacks(uVar);
        }
        IAlog.a("%sdestroy called", IAlog.a(this));
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null && (qVar = fVar.f1498a) != null) {
            qVar.b.remove(this);
            this.f1259a.f1498a.c.remove(this);
        }
        g();
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        this.g = null;
    }

    public boolean e() {
        String str;
        com.fyber.inneractive.sdk.flow.endcard.k kVarJ = j();
        if (kVarJ == null) {
            return false;
        }
        com.fyber.inneractive.sdk.response.g gVar = kVarJ.f1049a.d;
        return (gVar != null && (str = gVar.E) != null && TextUtils.equals(str, "1")) ^ true;
    }

    public final void f(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null && (qVar = fVar.f1498a) != null) {
            qVar.b(z);
        }
        this.d.setMuteButtonState(true);
    }

    public void g() {
        if (this.u != null) {
            IAlog.a("%sdestroyTextureView", IAlog.a(this));
        }
    }

    public void h(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null) {
            if (!fVar.g) {
                E();
                return;
            }
            if (z && (qVar = fVar.f1498a) != null) {
                qVar.a(0, true);
                return;
            }
            q qVar2 = fVar.f1498a;
            if (qVar2 != null) {
                com.fyber.inneractive.sdk.player.enums.b bVar = qVar2.e;
                if (bVar == com.fyber.inneractive.sdk.player.enums.b.Completed || bVar == com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                    qVar2.a(1, true);
                } else {
                    qVar2.j();
                }
            }
        }
    }

    public abstract int i();

    public final void i(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null && (qVar = fVar.f1498a) != null) {
            qVar.d(z);
        }
        this.d.setMuteButtonState(false);
    }

    public final com.fyber.inneractive.sdk.flow.endcard.k j() {
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null) {
            return ((com.fyber.inneractive.sdk.player.n) fVar).t;
        }
        return null;
    }

    public com.fyber.inneractive.sdk.web.b0 k() {
        return new w(this);
    }

    public final float m() {
        try {
            return ((AudioManager) this.d.getContext().getSystemService("audio")).getStreamVolume(3);
        } catch (Throwable unused) {
            return 1.0f;
        }
    }

    public com.fyber.inneractive.sdk.flow.storepromo.b n() {
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null) {
            return ((com.fyber.inneractive.sdk.player.n) fVar).v;
        }
        return null;
    }

    public abstract int o();

    public final boolean p() {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || (qVar = fVar.f1498a) == null) {
            return false;
        }
        return qVar.g() || ((double) m()) == 0.0d;
    }

    public final void q() {
        this.d.a(true);
        this.d.e(false);
        Runnable runnable = this.j;
        if (runnable == null) {
            if (runnable == null) {
                this.j = new t(this);
            }
            int i = i();
            IAlog.a("%s Starting buffering timeout with %d", IAlog.a(this), Integer.valueOf(i));
            this.d.postDelayed(this.j, i);
        }
    }

    public abstract void r();

    public void s() {
        if (B()) {
            g(false);
        } else {
            d(false);
        }
    }

    public abstract void t();

    public void u() {
        Runnable runnable = this.j;
        if (runnable != null) {
            this.d.removeCallbacks(runnable);
            this.j = null;
        }
        this.d.a(false);
        E();
    }

    public abstract void v();

    public void w() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void x() {
        /*
            r5 = this;
            com.fyber.inneractive.sdk.player.ui.s r0 = r5.d
            r1 = 0
            r0.a(r1)
            com.fyber.inneractive.sdk.player.ui.s r0 = r5.d
            r0.e(r1)
            java.lang.Runnable r0 = r5.j
            if (r0 == 0) goto L17
            com.fyber.inneractive.sdk.player.ui.s r2 = r5.d
            r2.removeCallbacks(r0)
            r0 = 0
            r5.j = r0
        L17:
            com.fyber.inneractive.sdk.player.f r0 = r5.f1259a
            r2 = 1
            if (r0 == 0) goto L74
            boolean r0 = r5.A()
            if (r0 == 0) goto L74
            boolean r0 = r5.h
            if (r0 != 0) goto L74
            com.fyber.inneractive.sdk.player.f r0 = r5.f1259a
            com.fyber.inneractive.sdk.player.controller.q r0 = r0.f1498a
            int r0 = r0.c()
            com.fyber.inneractive.sdk.player.f r3 = r5.f1259a
            r4 = r3
            com.fyber.inneractive.sdk.player.n r4 = (com.fyber.inneractive.sdk.player.n) r4
            com.fyber.inneractive.sdk.config.s0 r4 = r4.s
            int r3 = com.fyber.inneractive.sdk.player.f.a(r3)
            boolean r0 = com.fyber.inneractive.sdk.player.f.a(r0, r3, r4)
            if (r0 == 0) goto L74
            int r0 = r5.f
            if (r0 > 0) goto L4c
            com.fyber.inneractive.sdk.player.ui.s r0 = r5.d
            r0.g(r2)
            r5.h()
            goto L74
        L4c:
            com.fyber.inneractive.sdk.player.f r0 = r5.f1259a
            if (r0 == 0) goto L64
            com.fyber.inneractive.sdk.player.controller.q r0 = r0.f1498a
            if (r0 == 0) goto L64
            int r0 = r0.c()
            int r0 = r0 / 1000
            int r3 = r5.f
            if (r3 < r0) goto L64
            com.fyber.inneractive.sdk.player.ui.s r0 = r5.d
            r0.g(r1)
            goto L74
        L64:
            boolean r0 = r5.p
            if (r0 != 0) goto L74
            com.fyber.inneractive.sdk.player.ui.s r0 = r5.d
            r0.g(r2)
            int r0 = r5.f
            r5.b(r0)
            r5.p = r2
        L74:
            com.fyber.inneractive.sdk.player.controller.g0 r0 = r5.g
            if (r0 == 0) goto L81
            boolean r3 = r5.k
            if (r3 != 0) goto L81
            r5.k = r2
            r0.k()
        L81:
            r5.q = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.z.x():void");
    }

    public final void y() {
        com.fyber.inneractive.sdk.player.ui.g gVar;
        com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
        if (sVar != null) {
            sVar.o();
        }
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null && fVar.f1498a != null && (gVar = this.u) != null) {
            gVar.invalidate();
            this.u.requestLayout();
        }
        com.fyber.inneractive.sdk.player.ui.s sVar2 = this.d;
        if (sVar2 != null) {
            sVar2.invalidate();
            this.d.requestLayout();
        }
    }

    public void z() {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || (qVar = fVar.f1498a) == null) {
            return;
        }
        if (qVar.e == com.fyber.inneractive.sdk.player.enums.b.Paused) {
            IAlog.a("%spauseVideo called in bad state! %s", IAlog.a(this), qVar.e);
            return;
        }
        IAlog.a("%spauseVideo %s", IAlog.a(this), this.d);
        TextureView textureView = qVar.j;
        if (textureView == null || textureView.getParent() == null || textureView.getParent() != this.d.getTextureHost()) {
            return;
        }
        qVar.i();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    @Override // com.fyber.inneractive.sdk.player.controller.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.fyber.inneractive.sdk.flow.endcard.b r6) {
        /*
            Method dump skipped, instruction units count: 211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.z.a(com.fyber.inneractive.sdk.flow.endcard.b):void");
    }

    @Override // com.fyber.inneractive.sdk.player.ui.n
    public void c() {
        IAlog.a("%sonVideoViewDetachedFromWindow", IAlog.a(this));
        g();
    }

    public final void e(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || (qVar = fVar.f1498a) == null) {
            return;
        }
        com.fyber.inneractive.sdk.player.enums.b bVar = qVar.e;
        if (z && bVar != com.fyber.inneractive.sdk.player.enums.b.Completed && !this.d.b()) {
            h(false);
            return;
        }
        if (!z && bVar == com.fyber.inneractive.sdk.player.enums.b.Paused && this.d.b()) {
            int iB = qVar.b();
            int iC = qVar.c();
            if (iB <= 0 || iB > iC) {
                return;
            }
            qVar.a(iB - 1, false);
            qVar.a(iB, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(boolean r5) {
        /*
            r4 = this;
            com.fyber.inneractive.sdk.player.controller.f0 r0 = new com.fyber.inneractive.sdk.player.controller.f0
            com.fyber.inneractive.sdk.player.ui.s r1 = r4.d
            android.content.Context r1 = r1.getContext()
            com.fyber.inneractive.sdk.config.global.r r2 = r4.c
            if (r2 == 0) goto L33
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.c> r3 = com.fyber.inneractive.sdk.config.global.features.c.class
            com.fyber.inneractive.sdk.config.global.features.h r2 = r2.a(r3)
            com.fyber.inneractive.sdk.config.global.features.c r2 = (com.fyber.inneractive.sdk.config.global.features.c) r2
            r2.getClass()
            java.util.ArrayList r3 = new java.util.ArrayList
            java.util.HashMap r2 = r2.c
            java.util.Collection r2 = r2.values()
            r3.<init>(r2)
            int r2 = r3.size()
            if (r2 <= 0) goto L33
            com.fyber.inneractive.sdk.config.global.r r2 = r4.c
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.c> r3 = com.fyber.inneractive.sdk.config.global.features.c.class
            com.fyber.inneractive.sdk.config.global.features.h r2 = r2.a(r3)
            com.fyber.inneractive.sdk.config.global.features.c r2 = (com.fyber.inneractive.sdk.config.global.features.c) r2
            goto L34
        L33:
            r2 = 0
        L34:
            com.fyber.inneractive.sdk.player.controller.v r3 = new com.fyber.inneractive.sdk.player.controller.v
            r3.<init>(r4, r5)
            r0.<init>(r1, r2, r3)
            android.app.Dialog r5 = r0.b
            r5.show()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.z.g(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(boolean r6) {
        /*
            Method dump skipped, instruction units count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.z.d(boolean):void");
    }

    public void f() {
        q qVar;
        q qVar2;
        com.fyber.inneractive.sdk.measurement.f fVar;
        if (this.u == null) {
            com.fyber.inneractive.sdk.player.ui.g gVar = new com.fyber.inneractive.sdk.player.ui.g(this.d);
            this.u = gVar;
            gVar.setId(R.id.ia_inn_texture_view);
            com.fyber.inneractive.sdk.player.f fVar2 = this.f1259a;
            if (fVar2 != null && (fVar = fVar2.e) != null) {
                com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
                View[] trackingFriendlyView = sVar.getTrackingFriendlyView();
                AdSession adSession = fVar.f1147a;
                if (adSession != null) {
                    try {
                        adSession.registerAdView(sVar);
                    } catch (Throwable th) {
                        fVar.a(th);
                    }
                }
                if (fVar.f1147a != null && trackingFriendlyView != null) {
                    for (View view : trackingFriendlyView) {
                        if (view != null) {
                            try {
                                fVar.f1147a.addFriendlyObstruction(view, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
                            } catch (Throwable th2) {
                                fVar.a(th2);
                            }
                        }
                    }
                }
                View[] trackingFriendlyViewObstructionPurposeOther = this.d.getTrackingFriendlyViewObstructionPurposeOther();
                if (fVar.f1147a != null) {
                    for (View view2 : trackingFriendlyViewObstructionPurposeOther) {
                        if (view2 != null) {
                            try {
                                fVar.f1147a.addFriendlyObstruction(view2, FriendlyObstructionPurpose.OTHER, null);
                            } catch (Throwable th3) {
                                fVar.a(th3);
                            }
                        }
                    }
                }
            }
        }
        IAlog.a("%sconnectToTextureView called %s", IAlog.a(this), this.d.getTextureHost());
        if (this.u != null && this.d.getTextureHost().equals(this.u.getParent())) {
            IAlog.a("%sconnectToTextureView called but already connected", IAlog.a(this));
            return;
        }
        com.fyber.inneractive.sdk.player.f fVar3 = this.f1259a;
        if (fVar3 != null && (qVar2 = fVar3.f1498a) != null) {
            qVar2.a(this.u);
        }
        com.fyber.inneractive.sdk.player.ui.g gVar2 = this.u;
        if (gVar2 != null && gVar2.getParent() == null) {
            IAlog.a("%supdateView adding texture to parent", IAlog.a(this));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.d.getTextureHost().addView(this.u, layoutParams);
        }
        this.l = false;
        x xVar = new x(this);
        this.e = xVar;
        com.fyber.inneractive.sdk.player.f fVar4 = this.f1259a;
        if (fVar4 == null || (qVar = fVar4.f1498a) == null) {
            return;
        }
        qVar.d = xVar;
    }

    public void h() {
        if (A()) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.d dVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class) : null;
            if (dVar != null) {
                dVar.d(IAConfigManager.O.o);
                com.fyber.inneractive.sdk.model.vast.a aVar = dVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.b;
                }
            }
            if (TextUtils.isEmpty(this.v) && str != null) {
                this.d.setSkipText(str);
            } else {
                com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
                sVar.setSkipText(sVar.getContext().getString(R.string.ia_video_skip_text));
            }
            this.d.g();
            this.f = 0;
            g0 g0Var = this.g;
            if (g0Var != null) {
                g0Var.d();
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.b
    public void b(boolean z) {
        IAlog.a("%sinitUI", IAlog.a(this));
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || fVar.f1498a == null) {
            return;
        }
        this.d.setUnitConfig(this.b);
        this.d.a(this.n, this.f1259a.f1498a.f(), this.f1259a.f1498a.e());
        if (A()) {
            this.f = o();
        } else {
            this.d.g(false);
        }
        if (!z) {
            a(this.f1259a.f1498a.b());
            a(this.f1259a.f1498a.e, false);
        }
        this.d.setMuteButtonState(p());
    }

    public final void b(int i) {
        if (this.d != null) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.c;
            String str = null;
            com.fyber.inneractive.sdk.config.global.features.d dVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class) : null;
            if (dVar != null) {
                dVar.d(IAConfigManager.O.o);
                com.fyber.inneractive.sdk.model.vast.a aVar = dVar.e;
                if (aVar != null && aVar.d) {
                    str = aVar.c;
                }
            }
            if (TextUtils.isEmpty(this.v) && str != null) {
                this.d.setSkipText(str.replaceFirst("\\[TIME\\]", Integer.toString(i)));
            } else {
                this.d.setSkipText(String.valueOf(i));
            }
        }
    }

    public final void b(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null) {
            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
            if (nVar.v != null) {
                com.fyber.inneractive.sdk.flow.storepromo.b bVar = nVar.v;
                bVar.getClass();
                synchronized (com.fyber.inneractive.sdk.flow.storepromo.b.k) {
                    bVar.h.remove(aVar);
                }
                return;
            }
        }
        IAlog.f("Unable to remove store promo observer, promo manager is unavailable", new Object[0]);
    }

    public final com.fyber.inneractive.sdk.player.ui.c a(com.fyber.inneractive.sdk.player.ui.c cVar) {
        String string;
        cVar.h = this.f1259a != null && com.fyber.inneractive.sdk.player.f.a(this.c, this.t);
        com.fyber.inneractive.sdk.config.global.r rVar = this.c;
        com.fyber.inneractive.sdk.config.global.features.n nVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.n) rVar.a(com.fyber.inneractive.sdk.config.global.features.n.class) : null;
        if (nVar != null) {
            string = nVar.a("app_info_button_text", "App Info");
            if (string != null && string.length() > 30) {
                string = string.substring(0, 30);
            }
        } else {
            string = this.d.getContext().getString(R.string.ia_video_app_info_text);
        }
        cVar.i = string;
        cVar.g = this.t;
        return cVar;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.p
    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar) {
        IAlog.a("%sonPlayerStateChanged with %s", IAlog.a(this), bVar);
        a(bVar, true);
    }

    public final void a(com.fyber.inneractive.sdk.player.enums.b bVar, boolean z) {
        g0 g0Var;
        com.fyber.inneractive.sdk.player.ui.s sVar;
        switch (y.f1258a[bVar.ordinal()]) {
            case 1:
                boolean z2 = this.w;
                if (z2) {
                    IAlog.a("IAVideoUIControllerBase playerStateUpdated=%s mBuffering=%s", bVar, String.valueOf(z2));
                    q();
                }
                break;
            case 2:
                if (this.o) {
                    E();
                    w();
                }
                break;
            case 3:
                if (this.o) {
                    this.w = true;
                    q();
                }
                break;
            case 4:
                if (this.w) {
                    this.w = false;
                }
                if (this.o) {
                    x();
                }
                break;
            case 5:
                u();
                break;
            case 6:
                if (this.o || (!e() && !this.s)) {
                    this.s = true;
                    if (!this.d.b()) {
                        this.d.a(false);
                        Runnable runnable = this.j;
                        if (runnable != null) {
                            this.d.removeCallbacks(runnable);
                            this.j = null;
                        }
                        E();
                        D();
                        this.k = false;
                        this.h = true;
                    }
                    if (z && (g0Var = this.g) != null) {
                        g0Var.onCompleted();
                        break;
                    }
                }
                break;
            case 7:
                if (this.o || ((sVar = this.d) != null && sVar.isShown())) {
                    s();
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c5  */
    @Override // com.fyber.inneractive.sdk.player.controller.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r9) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.controller.z.a(int):void");
    }

    public final void a(String str) {
        x0 x0Var = IAConfigManager.O.x;
        s0 s0Var = this.b;
        if (s0Var != null) {
            r0 r0Var = (r0) s0Var;
            if (r0Var.f != null) {
                x0Var.a(r0Var.f.j, "LAST_VAST_CLICKED_TYPE", str);
            }
        }
    }

    public void a(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        x xVar;
        com.fyber.inneractive.sdk.player.ui.s sVar;
        Application application;
        if (this.o == z || (fVar = this.f1259a) == null || fVar.f1498a == null) {
            return;
        }
        IAlog.a("%sonVisibilityChanged: %s my video view is%s", IAlog.a(this), Boolean.valueOf(z), this.d);
        if (z) {
            this.o = true;
            com.fyber.inneractive.sdk.player.enums.b bVar = this.f1259a.f1498a.e;
            if (bVar != com.fyber.inneractive.sdk.player.enums.b.Completed && !this.d.b()) {
                if (bVar != com.fyber.inneractive.sdk.player.enums.b.Error) {
                    if (bVar == com.fyber.inneractive.sdk.player.enums.b.Idle) {
                        this.f1259a.getClass();
                    } else {
                        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Start_in_progress || bVar == com.fyber.inneractive.sdk.player.enums.b.Playing) {
                            x();
                        }
                        com.fyber.inneractive.sdk.player.f fVar2 = this.f1259a;
                        if (!fVar2.j) {
                            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar2;
                            nVar.a(nVar.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_CREATIVE_VIEW);
                            fVar2.j = true;
                        }
                        f();
                        if (this.m != null || (application = com.fyber.inneractive.sdk.util.o.f1662a) == null) {
                            return;
                        }
                        u uVar = new u(this);
                        this.m = uVar;
                        application.registerActivityLifecycleCallbacks(uVar);
                        return;
                    }
                }
                s();
                return;
            }
            if (!this.s) {
                this.s = true;
                if (!this.y) {
                    if (!this.d.b()) {
                        this.d.a(false);
                        Runnable runnable = this.j;
                        if (runnable != null) {
                            this.d.removeCallbacks(runnable);
                            this.j = null;
                        }
                        E();
                        D();
                        this.k = false;
                        this.h = true;
                    }
                    g0 g0Var = this.g;
                    if (g0Var != null) {
                        g0Var.onCompleted();
                    }
                }
            }
            com.fyber.inneractive.sdk.player.ui.s sVar2 = this.d;
            if (sVar2 != null) {
                sVar2.k();
                return;
            }
            return;
        }
        this.o = false;
        com.fyber.inneractive.sdk.player.f fVar3 = this.f1259a;
        if (fVar3 != null && (qVar = fVar3.f1498a) != null && (xVar = qVar.d) != null && xVar.equals(this.e)) {
            IAlog.a("%sonVisibilityChanged pausing video", IAlog.a(this));
            z();
            if (this.f1259a.f1498a.e == com.fyber.inneractive.sdk.player.enums.b.Completed || ((sVar = this.d) != null && sVar.b())) {
                this.d.j();
            }
        }
        com.fyber.inneractive.sdk.player.ui.s sVar3 = this.d;
        if (sVar3 == null || !sVar3.h) {
            g();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(int i, g1 g1Var) {
        IAlog.a("onClicked called with %d", Integer.valueOf(i));
        switch (i) {
            case 1:
                if (p()) {
                    i(true);
                    com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
                    if (fVar != null) {
                        com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
                        nVar.a(nVar.p, VideoClickOrigin.MUTE, com.fyber.inneractive.sdk.model.vast.x.EVENT_UNMUTE);
                    }
                } else {
                    f(true);
                    com.fyber.inneractive.sdk.player.f fVar2 = this.f1259a;
                    if (fVar2 != null) {
                        com.fyber.inneractive.sdk.player.n nVar2 = (com.fyber.inneractive.sdk.player.n) fVar2;
                        nVar2.a(nVar2.p, VideoClickOrigin.MUTE, com.fyber.inneractive.sdk.model.vast.x.EVENT_MUTE);
                    }
                }
                this.d.setMuteButtonState(p());
                break;
            case 2:
                v();
                break;
            case 3:
                a(w0.CTA_BUTTON.a());
                a(false, VideoClickOrigin.CTA, g1Var);
                break;
            case 4:
                a(w0.COMPANION.a());
                com.fyber.inneractive.sdk.player.f fVar3 = this.f1259a;
                String str = null;
                if (fVar3 != null) {
                    com.fyber.inneractive.sdk.player.n nVar3 = (com.fyber.inneractive.sdk.player.n) fVar3;
                    com.fyber.inneractive.sdk.flow.endcard.b bVarA = nVar3.t.b.a();
                    if (bVarA instanceof com.fyber.inneractive.sdk.flow.endcard.c) {
                        com.fyber.inneractive.sdk.flow.endcard.c cVar = (com.fyber.inneractive.sdk.flow.endcard.c) bVarA;
                        String str2 = cVar.g.g;
                        if (TextUtils.isEmpty(str2)) {
                            com.fyber.inneractive.sdk.model.vast.b bVar = nVar3.p;
                            if (bVar != null) {
                                str = bVar.b;
                            }
                        } else {
                            str = str2;
                        }
                        fVar3.a(cVar, VideoClickOrigin.COMPANION, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                    }
                }
                com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
                if (sVar != null) {
                    sVar.f();
                }
                g0 g0Var = this.g;
                if (g0Var != null) {
                    g0Var.a(str, g1Var, false);
                }
                break;
            case 5:
                t();
                break;
            case 6:
                if (B()) {
                    g(true);
                } else {
                    d(true);
                }
                break;
            case 7:
                b(g1Var);
                break;
            case 8:
                a(w0.COMPANION.a());
                a(true, VideoClickOrigin.COMPANION, g1Var);
                break;
            case 9:
                com.fyber.inneractive.sdk.player.f fVar4 = this.f1259a;
                if (fVar4 != null && !this.d.h) {
                    fVar4.g = true;
                    h(false);
                    break;
                }
                break;
            case 10:
                a(w0.APP_INFO.a());
                a(false, VideoClickOrigin.APP_INFO, g1Var);
                break;
            case 11:
                a(w0.STORE_PROMO.a());
                a(false, VideoClickOrigin.STORE_PROMO, g1Var);
                break;
        }
    }

    public final boolean a(boolean z, VideoClickOrigin videoClickOrigin, g1 g1Var) {
        com.fyber.inneractive.sdk.util.g gVar;
        com.fyber.inneractive.sdk.player.ui.s sVar = this.d;
        if (sVar != null) {
            sVar.f();
        }
        g0 g0Var = this.g;
        boolean z2 = false;
        if (g0Var != null) {
            if (z) {
                com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
                if (fVar != null) {
                    com.fyber.inneractive.sdk.model.vast.b bVar = ((com.fyber.inneractive.sdk.player.n) fVar).p;
                    g0Var.a(bVar != null ? bVar.b : null, g1Var, true);
                    com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) this.f1259a;
                    nVar.a(nVar.p, videoClickOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                }
            } else {
                int i = y.b[videoClickOrigin.ordinal()];
                if (i == 1) {
                    gVar = com.fyber.inneractive.sdk.util.g.STORE_PROMO_CTA;
                } else if (i == 2) {
                    gVar = com.fyber.inneractive.sdk.util.g.VIDEO_CLICK;
                } else if (i != 3) {
                    gVar = com.fyber.inneractive.sdk.util.g.VIDEO_CTA;
                } else {
                    gVar = com.fyber.inneractive.sdk.util.g.VIDEO_APP_INFO;
                }
                com.fyber.inneractive.sdk.util.d0 d0VarA = this.g.a(g1Var, gVar);
                com.fyber.inneractive.sdk.player.f fVar2 = this.f1259a;
                if (fVar2 != null) {
                    com.fyber.inneractive.sdk.player.n nVar2 = (com.fyber.inneractive.sdk.player.n) fVar2;
                    nVar2.a(nVar2.p, videoClickOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_CLICK);
                    com.fyber.inneractive.sdk.measurement.f fVar3 = this.f1259a.e;
                    if (fVar3 != null && fVar3.c != null) {
                        IAlog.a("%s click", "OMVideo");
                        try {
                            fVar3.c.adUserInteraction(InteractionType.CLICK);
                        } catch (Throwable th) {
                            fVar3.a(th);
                        }
                    }
                }
                if (d0VarA.f1648a != com.fyber.inneractive.sdk.util.g0.FAILED) {
                    z2 = true;
                }
            }
        }
        if (videoClickOrigin == VideoClickOrigin.VIDEO) {
            a(w0.VIDEO.a());
        }
        return z2;
    }

    public final boolean a(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null) {
            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
            if (nVar.v != null) {
                com.fyber.inneractive.sdk.flow.storepromo.b bVar = nVar.v;
                bVar.getClass();
                synchronized (com.fyber.inneractive.sdk.flow.storepromo.b.k) {
                    bVar.h.add(aVar);
                }
                return true;
            }
        }
        IAlog.f("Unable to add store promo observer, promo manager is unavailable", new Object[0]);
        return false;
    }
}
