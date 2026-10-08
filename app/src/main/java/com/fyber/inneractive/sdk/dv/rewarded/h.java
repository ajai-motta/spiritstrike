package com.fyber.inneractive.sdk.dv.rewarded;

import android.app.Activity;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveFullScreenAdRewardedListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.b0;
import com.fyber.inneractive.sdk.flow.i0;
import com.fyber.inneractive.sdk.flow.p0;
import com.fyber.inneractive.sdk.flow.s0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends p0 implements com.fyber.inneractive.sdk.dv.interstitial.a {
    public com.fyber.inneractive.sdk.external.g w;
    public boolean x = false;

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final boolean K() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final int M() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final int N() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final long O() {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final boolean P() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final long a(long j) {
        return 0L;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a() {
    }

    @Override // com.fyber.inneractive.sdk.flow.p0
    public final /* bridge */ /* synthetic */ boolean b(x xVar) {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void c() {
        i iVar;
        x xVar = this.b;
        if (xVar != null && (iVar = (i) ((com.fyber.inneractive.sdk.a) xVar).b) != null) {
            b0.a(iVar);
        }
        b0.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO);
        a(y(), false, Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void h() {
        InneractiveUnitController.EventsListener eventsListener;
        if (this.x || (eventsListener = this.c) == null) {
            return;
        }
        this.x = true;
        ((InneractiveFullscreenAdEventsListener) eventsListener).onAdDismissed(this.f1036a);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void l() {
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void onReward() {
        com.fyber.inneractive.sdk.external.g gVar = this.w;
        if (gVar != null) {
            i0 i0Var = (i0) v.a(((s0) gVar.f1024a).mAdSpot);
            InneractiveFullScreenAdRewardedListener inneractiveFullScreenAdRewardedListener = gVar.f1024a.b;
            if (inneractiveFullScreenAdRewardedListener != null && i0Var != null) {
                inneractiveFullScreenAdRewardedListener.onAdRewarded(i0Var);
            }
            J();
        }
        b0.a(com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION, com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final boolean v() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void w() {
        x xVar = this.b;
        if (xVar != null) {
            b((i) ((com.fyber.inneractive.sdk.a) xVar).b);
        }
        b0.a(com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION, com.fyber.inneractive.sdk.cache.session.enums.c.REWARDED_VIDEO);
        G();
    }

    @Override // com.fyber.inneractive.sdk.flow.p0, com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        super.a(eVar, activity);
        if (activity != null) {
            x xVar = this.b;
            if (xVar != null) {
                com.fyber.inneractive.sdk.a aVar = (com.fyber.inneractive.sdk.a) xVar;
                if (aVar.i != null) {
                    aVar.a(this, activity);
                    return;
                }
            }
            IAlog.f("%sad content is null aborting", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Ad content is null");
        }
        IAlog.f("%sYou must pass activity in order to show rewarded", IAlog.a(this));
        throw new InneractiveUnitController.AdDisplayError("No activity context");
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
        this.w = gVar;
    }
}
