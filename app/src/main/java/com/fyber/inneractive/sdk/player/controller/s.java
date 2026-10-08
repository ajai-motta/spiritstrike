package com.fyber.inneractive.sdk.player.controller;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.TapAction;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.player.enums.VideoClickOrigin;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;

/* JADX INFO: loaded from: classes3.dex */
public class s extends z {
    public float A;
    public float B;
    public boolean C;
    public boolean D;
    public boolean E;
    public r z;

    public s(com.fyber.inneractive.sdk.player.f fVar, com.fyber.inneractive.sdk.player.ui.s sVar, r0 r0Var, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, String str) {
        super(fVar, sVar, r0Var, rVar, z, str);
        this.B = 0.0f;
        this.C = false;
        this.D = false;
        this.E = false;
        this.A = ((r0) this.b).g.b.intValue() / 100.0f;
        J();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public boolean A() {
        return false;
    }

    public final void G() {
        if (this.g == null || this.E) {
            return;
        }
        I();
        super.g();
        com.fyber.inneractive.sdk.renderers.o oVar = (com.fyber.inneractive.sdk.renderers.o) ((a0) this.g);
        com.fyber.inneractive.sdk.renderers.p pVar = oVar.f1604a;
        InneractiveUnitController.EventsListener eventsListener = pVar.c;
        if (eventsListener != null) {
            ((InneractiveAdViewEventsListener) eventsListener).onAdExpanded(pVar.f1036a);
        }
        ViewGroup viewGroup = oVar.f1604a.p;
        if (viewGroup != null && viewGroup.getContext() != null) {
            com.fyber.inneractive.sdk.renderers.p pVar2 = oVar.f1604a;
            com.fyber.inneractive.sdk.display.a bVar = pVar2.b instanceof com.fyber.inneractive.sdk.dv.a ? new com.fyber.inneractive.sdk.display.b() : new com.fyber.inneractive.sdk.display.c();
            if (bVar instanceof com.fyber.inneractive.sdk.display.c) {
                Context context = pVar2.p.getContext();
                InneractiveAdSpot inneractiveAdSpot = oVar.f1604a.f1036a;
                Intent intent = new Intent(context, (Class<?>) InneractiveFullscreenAdActivity.class);
                intent.putExtra("spotId", inneractiveAdSpot.getLocalUniqueId());
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                try {
                    IAlog.a("%sIAInterstitialUtil: Opening interstitial for spot id: %s", IAlog.a(context), inneractiveAdSpot.getLocalUniqueId());
                    context.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    IAlog.c("%sIAInterstitialUtil: InneractiveFullscreenAdActivity.class not found. Did you declare InneractiveFullscreenAdActivity in your manifest?", IAlog.a(context));
                }
            }
        }
        IAlog.a("%sopening fullscreen", IAlog.a(this));
        this.E = true;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null) {
            com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) fVar;
            nVar.a(nVar.p, VideoClickOrigin.InvalidOrigin, com.fyber.inneractive.sdk.model.vast.x.EVENT_FULLSCREEN, com.fyber.inneractive.sdk.model.vast.x.EVENT_EXPAND);
        }
    }

    public void H() {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        com.fyber.inneractive.sdk.player.ui.s sVar;
        if (this.B < this.A || (fVar = this.f1259a) == null || (qVar = fVar.f1498a) == null || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed || (sVar = this.d) == null || sVar.b() || this.f1259a.f1498a.j == null) {
            return;
        }
        if (((r0) this.b).f.f981a.booleanValue() || this.C) {
            c(IAConfigManager.O.i.f960a);
        }
    }

    public final void I() {
        if (this.z != null) {
            IAlog.a("%sCancelling play runnable", IAlog.a(this));
            this.d.removeCallbacks(this.z);
            this.z = null;
        }
    }

    public final void J() {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || (qVar = fVar.f1498a) == null || qVar.n) {
            return;
        }
        if (((r0) this.b).f.d.booleanValue()) {
            this.f1259a.f1498a.b(false);
        } else {
            if (p()) {
                return;
            }
            this.f1259a.f1498a.d(false);
        }
    }

    public void K() {
        if (((r0) this.b).f.i != TapAction.FULLSCREEN) {
            this.d.n();
        }
        C();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.ui.n
    public final void a(boolean z) {
        if (z) {
            a(this.B);
        }
        super.a(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.b
    public boolean b() {
        return !(this instanceof c0);
    }

    public final void c(int i) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || (qVar = fVar.f1498a) == null || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Playing || this.z != null) {
            return;
        }
        IAlog.a("%splayVideo %s", IAlog.a(this), this.d);
        if (i == 0) {
            h(false);
            return;
        }
        r rVar = new r(this);
        this.z = rVar;
        this.d.postDelayed(rVar, i);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.ui.controller.b
    public final void destroy() {
        I();
        this.g = null;
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void f() {
        super.f();
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null && fVar.f1498a != null) {
            IAlog.a("%sconnectToTextureView playing state = %s", IAlog.a(this), this.f1259a.f1498a.e);
            if (this.f1259a.f1498a.h()) {
                this.d.e(true ^ this.f1259a.g);
                J();
            }
        }
        a(this.B);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void g() {
        I();
        super.g();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void h(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || fVar.f1498a == null) {
            return;
        }
        J();
        super.h(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int i() {
        return IAConfigManager.O.u.b.a("VideoAdBufferingTimeout", 5, 1) * 1000;
    }

    public final void j(boolean z) {
        com.fyber.inneractive.sdk.player.f fVar;
        q qVar;
        this.D = z;
        if (!z || (fVar = this.f1259a) == null || (qVar = fVar.f1498a) == null || qVar.j != null || !this.d.e || qVar.e == com.fyber.inneractive.sdk.player.enums.b.Completed) {
            return;
        }
        f();
        a(this.B);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final int o() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void t() {
        G();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void u() {
        super.u();
        I();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void v() {
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || fVar.f1498a == null) {
            return;
        }
        f();
        h(false);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void w() {
        H();
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void x() {
        super.x();
        K();
        this.C = true;
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void z() {
        I();
        super.z();
    }

    public void F() {
        IAlog.a("%s handle buffering timeout: Skipping to end card", IAlog.a(this));
        if (B()) {
            g(false);
        } else {
            d(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z, com.fyber.inneractive.sdk.player.controller.b
    public final void b(boolean z) {
        q qVar;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar != null && (qVar = fVar.f1498a) != null && qVar.e != com.fyber.inneractive.sdk.player.enums.b.Completed) {
            K();
        }
        super.b(z);
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public final void r() {
        IAlog.a("%s onBufferingTimeout reached", IAlog.a(this));
        if (this.d.e) {
            this.r = true;
            F();
        }
    }

    @Override // com.fyber.inneractive.sdk.ui.controller.b
    public void a(float f) {
        q qVar;
        this.B = f;
        if (IAlog.f1642a >= 3) {
            IAlog.c("%sonVisibilityChanged called with: %s vfpl = %s vfpa = %s", IAlog.a(this), Float.valueOf(f), Float.valueOf(this.A), Float.valueOf(1.0f - this.A));
        }
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || (qVar = fVar.f1498a) == null) {
            return;
        }
        if (qVar.e != com.fyber.inneractive.sdk.player.enums.b.Playing) {
            H();
            return;
        }
        if (f <= this.A) {
            IAlog.e("%sonVisibilityChanged pausing player", IAlog.a(this));
            if (this.f1259a.f1498a.j != null) {
                this.C = false;
                I();
                super.z();
                f(false);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.controller.z
    public void b(g1 g1Var) {
        q qVar;
        TapAction tapAction = ((r0) this.b).f.i;
        com.fyber.inneractive.sdk.player.f fVar = this.f1259a;
        if (fVar == null || fVar.f1498a == null || this.B >= this.A) {
            if (tapAction == TapAction.CTR) {
                a(false, VideoClickOrigin.CTA, g1Var);
                return;
            }
            if (tapAction == TapAction.FULLSCREEN) {
                G();
                return;
            }
            if (tapAction != TapAction.DO_NOTHING) {
                IAlog.a("%sonVideoClicked called, but we recieved an unknown tap action %s", IAlog.a(this), tapAction);
                return;
            }
            if (fVar == null || (qVar = fVar.f1498a) == null) {
                return;
            }
            com.fyber.inneractive.sdk.player.enums.b bVar = qVar.e;
            if (bVar != com.fyber.inneractive.sdk.player.enums.b.Completed && bVar != com.fyber.inneractive.sdk.player.enums.b.Prepared) {
                qVar.j();
            } else {
                qVar.a(1, true);
            }
        }
    }
}
