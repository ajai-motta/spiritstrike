package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends w {
    public com.fyber.inneractive.sdk.player.t i;
    public boolean j;

    public t0(com.fyber.inneractive.sdk.config.s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.response.g gVar, InneractiveAdRequest inneractiveAdRequest) {
        super(s0Var, rVar);
        this.j = false;
        this.b = gVar;
        this.f1126a = inneractiveAdRequest;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean c() {
        com.fyber.inneractive.sdk.config.t0 t0Var;
        com.fyber.inneractive.sdk.config.s0 s0Var = this.d;
        if (s0Var == null || (t0Var = ((com.fyber.inneractive.sdk.config.r0) s0Var).f) == null) {
            IAlog.f("%s : isFullscreenAd() called with unit config: %s or mUnitConfig.getVideo is null", IAlog.a(this), this.d);
            return false;
        }
        UnitDisplayType unitDisplayType = t0Var.j;
        return UnitDisplayType.INTERSTITIAL.equals(unitDisplayType) || UnitDisplayType.REWARDED.equals(unitDisplayType) || UnitDisplayType.VERTICAL.equals(unitDisplayType);
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void destroy() {
        com.fyber.inneractive.sdk.player.n nVar;
        if (this.g != null && c()) {
            com.fyber.inneractive.sdk.web.v0 v0Var = this.g;
            v0Var.y = true;
            v0Var.D = false;
            v0Var.b.h.remove(v0Var);
            v0Var.i = null;
            IAlog.a("destroy internalStoreWebpageController", new Object[0]);
            this.g = null;
        }
        com.fyber.inneractive.sdk.player.t tVar = this.i;
        if (tVar != null) {
            com.fyber.inneractive.sdk.player.b bVar = tVar.f1519a;
            if (bVar != null && (nVar = bVar.b) != null) {
                nVar.i = true;
                IAlog.a("IAMediaPlayerFlowManager: destroy", new Object[0]);
                nVar.a();
                com.fyber.inneractive.sdk.flow.endcard.b bVarA = nVar.t.b.a();
                if (bVarA != null) {
                    bVarA.destroy();
                }
                if (nVar.f1498a != null) {
                    IAlog.a("%s : destroy() : playerController being destroyed", InneractiveMediationDefs.GENDER_FEMALE);
                    nVar.f1498a.a();
                    nVar.f1498a = null;
                }
                nVar.l = null;
                com.fyber.inneractive.sdk.flow.endcard.k kVar = nVar.t;
                if (kVar != null) {
                    com.fyber.inneractive.sdk.flow.endcard.m mVar = kVar.b;
                    Iterator it = mVar.f1058a.iterator();
                    while (it.hasNext()) {
                        ((com.fyber.inneractive.sdk.flow.endcard.b) it.next()).destroy();
                    }
                    mVar.f1058a.clear();
                    mVar.b.clear();
                    mVar.c = -1;
                }
                com.fyber.inneractive.sdk.player.ui.remote.g gVar = nVar.u;
                if (gVar != null) {
                    gVar.f1534a.a();
                }
                com.fyber.inneractive.sdk.flow.storepromo.b bVar2 = nVar.v;
                if (bVar2 != null) {
                    bVar2.f1093a.a();
                    bVar2.a();
                    bVar2.e = null;
                    bVar2.h.clear();
                }
            }
            this.i = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean e() {
        return this.i != null;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public boolean isVideoAd() {
        return true;
    }
}
