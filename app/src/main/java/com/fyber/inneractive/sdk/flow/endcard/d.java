package com.fyber.inneractive.sdk.flow.endcard;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.x0;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {
    public d(int i, x0 x0Var) {
        super(i, x0Var);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final void a(ViewGroup viewGroup, com.fyber.inneractive.sdk.player.ui.b bVar) {
        f fVar = (f) f();
        fVar.a(bVar, null);
        ViewGroup viewGroup2 = fVar.c;
        com.fyber.inneractive.sdk.util.v.a(viewGroup2);
        viewGroup.addView(viewGroup2);
        a(this.e, this.c);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final n c() {
        return new f(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.player.ui.c d() {
        Boolean boolC;
        com.fyber.inneractive.sdk.config.global.features.u uVar = this.c.g;
        View viewB = f().b();
        com.fyber.inneractive.sdk.player.ui.c cVarD = super.d();
        cVarD.e = viewB;
        cVarD.b = (uVar == null || (boolC = uVar.c("cta_text_all_caps")) == null || !boolC.booleanValue()) ? false : true;
        boolean zB = b.b(uVar);
        Integer numValueOf = Integer.valueOf(b.a(uVar));
        if (zB) {
            cVarD.d = numValueOf;
        }
        return cVarD;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.util.g g() {
        return com.fyber.inneractive.sdk.util.g.DEFAULT_ENDCARD;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final l h() {
        return l.Default;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final com.fyber.inneractive.sdk.model.vast.i i() {
        return com.fyber.inneractive.sdk.model.vast.i.Default_End_Card;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean l() {
        return true;
    }

    public final void a(int i, x0 x0Var) {
        com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.VAST_DEFAULT_COMPANION_DISPLAYED;
        InneractiveAdRequest inneractiveAdRequest = x0Var.c;
        com.fyber.inneractive.sdk.response.g gVar = x0Var.d;
        JSONArray jSONArray = x0Var.f;
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(gVar);
        wVar.c = uVar;
        wVar.f1220a = inneractiveAdRequest;
        wVar.d = jSONArray;
        wVar.a((String) null);
    }
}
