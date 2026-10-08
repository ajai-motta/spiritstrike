package com.fyber.inneractive.sdk.dv.interstitial;

import android.app.Activity;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.b0;
import com.fyber.inneractive.sdk.flow.p0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends p0 implements a {
    public boolean w = false;

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

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void a(com.fyber.inneractive.sdk.external.g gVar) {
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
        b0.a(com.fyber.inneractive.sdk.cache.session.enums.a.CLICK, com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO);
        a(y(), false, Float.NaN, Float.NaN);
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void h() {
        InneractiveUnitController.EventsListener eventsListener;
        if (this.w || (eventsListener = this.c) == null) {
            return;
        }
        this.w = true;
        ((InneractiveFullscreenAdEventsListener) eventsListener).onAdDismissed(this.f1036a);
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public final void l() {
    }

    @Override // com.fyber.inneractive.sdk.dv.interstitial.a
    public final void onReward() {
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
        b0.a(com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION, com.fyber.inneractive.sdk.cache.session.enums.c.INTERSTITIAL_VIDEO);
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
        IAlog.f("%sYou must pass activity in order to show interstitial", IAlog.a(this));
        throw new InneractiveUnitController.AdDisplayError("No activity context");
    }
}
