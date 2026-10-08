package com.fyber.inneractive.sdk.dv.rewarded;

import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends RewardedAdLoadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1005a;

    public e(g gVar) {
        this.f1005a = gVar;
    }

    public final void onRewardedAdFailedToLoad(int i) {
        com.fyber.inneractive.sdk.dv.c cVar = this.f1005a.g;
        if (cVar != null) {
            cVar.j();
            InneractiveAdRequest inneractiveAdRequest = this.f1005a.f1126a;
            String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
            com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
            g gVar = this.f1005a;
            com.fyber.inneractive.sdk.dv.handler.e.a(spotId, aVar, gVar.f1126a, (i) gVar.b, String.format("errorCode - %d", Integer.valueOf(i)));
        }
    }

    public final void onRewardedAdLoaded() {
        g gVar = this.f1005a;
        if (gVar.g != null) {
            gVar.g();
            this.f1005a.g.g();
        }
    }
}
