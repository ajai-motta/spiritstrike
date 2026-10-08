package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.u;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;
import com.fyber.inneractive.sdk.util.h1;
import com.fyber.inneractive.sdk.util.t1;
import com.fyber.inneractive.sdk.util.v1;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends s {
    public static final g1 I;
    public final com.fyber.inneractive.sdk.flow.g A;
    public boolean B;
    public v1 C;
    public k D;
    public int E;
    public int F;
    public View G;
    public boolean H;
    public final a y;
    public final LayoutInflater z;

    static {
        g1 g1Var = new g1();
        g1Var.c = true;
        I = g1Var;
    }

    public l(Context context, com.fyber.inneractive.sdk.flow.g gVar, a aVar, com.fyber.inneractive.sdk.config.global.r rVar, String str) {
        super(context, rVar, str);
        this.B = false;
        this.H = true;
        this.A = gVar;
        this.z = LayoutInflater.from(context);
        this.y = aVar;
    }

    public abstract void a(int i);

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(com.fyber.inneractive.sdk.flow.endcard.b bVar, b bVar2) {
        Integer num;
        this.G = bVar2.e;
        ViewGroup viewGroup = this.r;
        if (viewGroup != null) {
            bVar.a(viewGroup, bVar2);
            this.r.setVisibility(0);
            com.fyber.inneractive.sdk.model.vast.i iVar = bVar2.f;
            com.fyber.inneractive.sdk.model.vast.i iVar2 = com.fyber.inneractive.sdk.model.vast.i.Static;
            if (iVar2 == iVar) {
                a(getEndCardView(), 4);
            }
            if ((iVar2 == iVar || iVar == com.fyber.inneractive.sdk.model.vast.i.FMP_End_Card) && (num = bVar2.d) != null) {
                b(iVar != iVar2 ? 8 : 4, num.intValue());
            }
        }
    }

    public void b(int i, int i2) {
        if (this.B || this.C != null) {
            return;
        }
        IAlog.a("Start Autoclick timer - %d seconds", Integer.valueOf(i2));
        v1 v1Var = new v1(TimeUnit.SECONDS, i2);
        this.C = v1Var;
        v1Var.e = new j(this, i);
        t1 t1Var = new t1(v1Var);
        v1Var.c = t1Var;
        v1Var.d = false;
        t1Var.sendEmptyMessage(1932593528);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f() {
        p();
        this.B = true;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View getEndCardView() {
        return this.G;
    }

    public String getLocalizedCtaButtonText() {
        com.fyber.inneractive.sdk.config.global.r rVar = this.v;
        com.fyber.inneractive.sdk.config.global.features.d dVar = rVar != null ? (com.fyber.inneractive.sdk.config.global.features.d) rVar.a(com.fyber.inneractive.sdk.config.global.features.d.class) : null;
        if (dVar == null) {
            return null;
        }
        dVar.d(IAConfigManager.O.o);
        com.fyber.inneractive.sdk.model.vast.a aVar = dVar.e;
        if (aVar == null || !aVar.d) {
            return null;
        }
        return aVar.f1158a;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public int getMaxTickFactor() {
        return 1000;
    }

    public int getSingleTickTime() {
        return 1000 / getTickFraction();
    }

    public int getTickFraction() {
        return 5;
    }

    public void h(boolean z) {
        String string = getContext().getString(R.string.ia_video_app_info_text);
        com.fyber.inneractive.sdk.config.global.r rVar = this.v;
        if (rVar != null) {
            Boolean boolC = ((u) rVar.a(u.class)).c("show_ad_identifier_original_design");
            this.H = boolC != null ? boolC.booleanValue() : true;
            string = ((com.fyber.inneractive.sdk.config.global.features.n) this.v.a(com.fyber.inneractive.sdk.config.global.features.n.class)).a("app_info_button_text", "App Info");
            if (string != null && string.length() > 30) {
                string = string.substring(0, 30);
            }
        }
        if (z && this.H) {
            b(false);
            a(true, string);
            c(true);
        } else if (z) {
            b(false);
            a(true, string);
            c(false);
        } else if (!this.H) {
            b(true);
            c(false);
        } else {
            a(false, (String) null);
            b(false);
            c(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void j() {
        if (this.C != null) {
            IAlog.a("Autoclick paused", new Object[0]);
            v1 v1Var = this.C;
            v1Var.d = true;
            t1 t1Var = v1Var.c;
            if (t1Var != null) {
                t1Var.removeMessages(1932593528);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void k() {
        if (this.C != null) {
            IAlog.a("Autoclick resumed", new Object[0]);
            v1 v1Var = this.C;
            v1Var.d = false;
            v1Var.a(SystemClock.uptimeMillis());
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void o() {
        this.t = this.y.a(this.d, this.n, this.o, this.s, this.b, this.l);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e, android.view.View
    public final void onWindowFocusChanged(boolean z) {
    }

    public final void p() {
        if (this.C != null) {
            IAlog.a("Autoclick is removed ", new Object[0]);
            this.C.e = null;
            this.C = null;
        }
    }

    public void setEndCardView(View view) {
        this.G = view;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void a(h1 h1Var, int i, int i2) {
        this.y.a(this.d, this.n, this.o, this.p, h1Var, i, i2, this.b, ((r0) this.c).f.f.intValue());
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void a(int i, int i2) {
        Runnable runnable = this.D;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.D = null;
        }
        this.F = getMaxTickFactor() + i2;
        int maxTickFactor = (getMaxTickFactor() / getTickFractions()) + i2;
        int i3 = this.F;
        if (i3 <= 0 || i3 > i) {
            return;
        }
        int i4 = this.E;
        if (maxTickFactor < i4 && i4 > 0) {
            a(i3);
            return;
        }
        this.E = maxTickFactor;
        a(maxTickFactor);
        k kVar = new k(this);
        this.D = kVar;
        postDelayed(kVar, this.k);
    }
}
