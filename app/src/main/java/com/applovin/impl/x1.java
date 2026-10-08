package com.applovin.impl;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.e6;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class x1 extends w1 {
    private final y1 M;
    private g0 N;
    private long O;
    private final AtomicBoolean P;

    public x1(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.k kVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, kVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.M = new y1(this.f701a, this.d, this.b);
        this.P = new AtomicBoolean();
    }

    private long C() {
        com.applovin.impl.sdk.ad.b bVar = this.f701a;
        if (!(bVar instanceof com.applovin.impl.sdk.ad.a)) {
            return 0L;
        }
        float fH1 = ((com.applovin.impl.sdk.ad.a) bVar).h1();
        if (fH1 <= 0.0f) {
            fH1 = this.f701a.r();
        }
        return (long) (o7.c(fH1) * (((double) this.f701a.y()) / 100.0d));
    }

    private int D() {
        g0 g0Var;
        int iMin = 100;
        if (h()) {
            if (((Boolean) this.b.a(y4.m1)).booleanValue() && !this.f701a.hasShown()) {
                return 0;
            }
            if (!E() && (g0Var = this.N) != null) {
                iMin = (int) Math.min(100.0d, ((this.O - g0Var.b()) / this.O) * 100.0d);
            }
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a("AppLovinFullscreenActivity", "Ad engaged at " + iMin + "%");
            }
        }
        return iMin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a("AppLovinFullscreenActivity", "Marking ad as fully watched");
        }
        this.P.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G() {
        this.q = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.k;
        if (gVar != null) {
            arrayList.add(new h4(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.j;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.j;
            arrayList.add(new h4(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        this.f701a.getAdEventTracker().b(b(), arrayList);
    }

    @Override // com.applovin.impl.w1
    protected void A() {
        this.M.a(this.l);
        this.q = SystemClock.elapsedRealtime();
        this.P.set(true);
    }

    protected boolean E() {
        if (!(this.J && this.f701a.a1()) && h()) {
            return this.P.get();
        }
        return true;
    }

    protected void I() {
        long jP;
        long millis = 0;
        if (this.f701a.O() >= 0 || this.f701a.P() >= 0) {
            if (this.f701a.O() >= 0) {
                jP = this.f701a.O();
            } else {
                if (this.f701a.W0()) {
                    int iH1 = (int) ((com.applovin.impl.sdk.ad.a) this.f701a).h1();
                    if (iH1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iH1);
                    } else {
                        int iR = (int) this.f701a.r();
                        if (iR > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iR);
                        }
                    }
                }
                jP = (long) (millis * (((double) this.f701a.P()) / 100.0d));
            }
            c(jP);
        }
    }

    @Override // com.applovin.impl.w1
    public void a(ViewGroup viewGroup) {
        this.M.a(this.k, this.j, b(), viewGroup);
        if (((Boolean) this.b.a(y4.Y5)).booleanValue() || !a(false)) {
            com.applovin.impl.adview.k kVar = this.j;
            if (kVar != null) {
                kVar.b();
            }
            b().renderAd(this.f701a);
            a("javascript:al_onPoststitialShow();", this.f701a.x());
            if (h()) {
                long jC = C();
                this.O = jC;
                if (jC > 0) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.O + "ms...");
                    }
                    this.N = g0.a(this.O, this.b, new Runnable() { // from class: com.applovin.impl.x1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.F();
                        }
                    });
                }
            }
            if (this.k != null) {
                if (this.f701a.r() >= 0) {
                    a(this.k, this.f701a.r(), new Runnable() { // from class: com.applovin.impl.x1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.G();
                        }
                    });
                } else {
                    this.k.setVisibility(0);
                }
            }
            I();
            this.b.r0().a(new s6(this.b, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.x1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.H();
                }
            }), e6.b.OTHER, TimeUnit.SECONDS.toMillis(1L));
            p();
            super.c(o7.e(this.b));
        }
    }

    @Override // com.applovin.impl.w1
    public void b(long j) {
    }

    @Override // com.applovin.impl.w1
    public void e() {
        super.e();
        A();
    }

    @Override // com.applovin.impl.w1
    public void f() {
        super.f();
        A();
    }

    @Override // com.applovin.impl.w1
    protected void m() {
        super.a(D(), false, E(), -2L);
    }

    @Override // com.applovin.impl.w1
    public void v() {
    }

    @Override // com.applovin.impl.w1
    public void w() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.w1
    protected void x() {
        super.x();
        this.P.set(true);
    }

    @Override // com.applovin.impl.w1
    public void a(String str) {
        if (!((Boolean) this.b.a(y4.Q6)).booleanValue()) {
            com.applovin.impl.sdk.ad.b bVar = this.f701a;
            if (bVar != null) {
                bVar.a(str);
            }
            m();
        }
        g0 g0Var = this.N;
        if (g0Var != null) {
            g0Var.a();
            this.N = null;
        }
        super.a(str);
    }
}
