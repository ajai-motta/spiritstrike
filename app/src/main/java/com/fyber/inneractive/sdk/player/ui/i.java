package com.fyber.inneractive.sdk.player.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.util.h1;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends s {
    public final t0 A;
    public final o y;
    public p z;

    /* JADX WARN: Removed duplicated region for block: B:60:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public i(android.content.Context r22, com.fyber.inneractive.sdk.player.ui.a r23, com.fyber.inneractive.sdk.player.n r24, com.fyber.inneractive.sdk.config.global.r r25, java.lang.String r26) {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.ui.i.<init>(android.content.Context, com.fyber.inneractive.sdk.player.ui.a, com.fyber.inneractive.sdk.player.n, com.fyber.inneractive.sdk.config.global.r, java.lang.String):void");
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e, com.fyber.inneractive.sdk.player.ui.m
    public final boolean a() {
        p pVar = this.z;
        return pVar != null && pVar.a();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void b(boolean z) {
        this.y.b(z);
        if (a(this.z)) {
            this.z.b(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void c(boolean z) {
        this.y.c(z);
        if (a(this.z)) {
            this.z.c(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void d(boolean z) {
        this.y.d(z);
        if (a(this.z)) {
            this.z.d(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void e(boolean z) {
        if (a(this.z)) {
            this.z.e(z);
        } else {
            this.y.e(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f(boolean z) {
        this.y.f(z);
        if (a(this.z)) {
            this.z.f(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g(boolean z) {
        if (a(this.z)) {
            this.z.g(z);
        } else {
            this.y.g(z);
        }
    }

    public InneractiveAdRequest getAdRequest() {
        t0 t0Var = this.A;
        if (t0Var != null) {
            return t0Var.f1126a;
        }
        return null;
    }

    public com.fyber.inneractive.sdk.response.e getAdResponse() {
        t0 t0Var = this.A;
        if (t0Var != null) {
            return t0Var.b;
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View getEndCardView() {
        return this.y.getEndCardView();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyView() {
        return a(this.z) ? this.z.getTrackingFriendlyView() : this.y.getTrackingFriendlyView();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return a(this.z) ? this.z.getTrackingFriendlyViewObstructionPurposeOther() : this.y.getTrackingFriendlyViewObstructionPurposeOther();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void h() {
        this.y.h();
        if (a(this.z)) {
            this.z.h();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final boolean i() {
        return a(this.z) ? this.z.L.n : this.y.i();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void j() {
        this.y.j();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void k() {
        this.y.k();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final boolean l() {
        return a(this.z) ? this.z.L.m : this.y.l();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void m() {
        this.y.m();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void n() {
        this.y.n();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void o() {
        this.y.o();
        this.t = this.y.t;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setAppInfoButtonRound(TextView textView) {
        this.y.setAppInfoButtonRound(textView);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public void setListener(n nVar) {
        super.setListener(nVar);
        this.y.setListener(nVar);
        if (a(this.z)) {
            this.z.setListener(nVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setMuteButtonState(boolean z) {
        this.y.setMuteButtonState(z);
        if (a(this.z)) {
            this.z.setMuteButtonState(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setRemainingTime(String str) {
        this.y.setRemainingTime(str);
        if (a(this.z)) {
            this.z.setRemainingTime(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setSkipText(String str) {
        this.y.setSkipText(str);
        if (a(this.z)) {
            this.z.setSkipText(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public void setUnitConfig(s0 s0Var) {
        super.setUnitConfig(s0Var);
        this.y.setUnitConfig(s0Var);
        if (a(this.z)) {
            this.z.setUnitConfig(s0Var);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(com.fyber.inneractive.sdk.flow.endcard.d dVar, b bVar) {
        ViewGroup viewGroup;
        p pVar;
        this.y.a(dVar, bVar);
        if (!a(this.z) || (viewGroup = this.q) == null || viewGroup.getVisibility() != 0 || (pVar = this.z) == null) {
            return;
        }
        pVar.destroy();
        this.z = null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f() {
        o oVar = this.y;
        oVar.p();
        oVar.B = true;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g() {
        this.y.g();
        if (a(this.z)) {
            this.z.g();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, com.fyber.inneractive.sdk.ignite.m mVar) {
        if (!a(this.z)) {
            this.y.a(z, mVar);
        } else {
            this.z.a(z, mVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, String str) {
        this.y.a(z, str);
        if (a(this.z)) {
            this.z.a(z, str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, int i, int i2) {
        this.n = i;
        this.o = i2;
        this.p = z;
        o oVar = this.y;
        oVar.n = i;
        oVar.o = i2;
        oVar.p = z;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(com.fyber.inneractive.sdk.flow.endcard.b bVar, b bVar2) {
        this.y.a(bVar, bVar2);
        p pVar = this.z;
        if (pVar != null) {
            pVar.destroy();
            this.z = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z) {
        if (a(this.z)) {
            this.z.a(z);
        } else {
            this.y.a(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(int i, int i2) {
        this.y.a(i, i2);
        if (a(this.z)) {
            this.z.a(i, i2);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void a(h1 h1Var, int i, int i2) {
        this.y.a(h1Var, i, i2);
    }

    public static boolean a(p pVar) {
        return (pVar == null || pVar.L.h || !pVar.a()) ? false : true;
    }
}
