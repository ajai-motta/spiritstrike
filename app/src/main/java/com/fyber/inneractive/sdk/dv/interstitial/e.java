package com.fyber.inneractive.sdk.dv.interstitial;

import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.google.android.gms.ads.AdListener;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends AdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f999a;

    public e(g gVar) {
        this.f999a = gVar;
    }

    public final void onAdFailedToLoad(int i) {
        com.fyber.inneractive.sdk.dv.c cVar = this.f999a.g;
        if (cVar != null) {
            cVar.j();
            InneractiveAdRequest inneractiveAdRequest = this.f999a.f1126a;
            String spotId = inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : null;
            com.fyber.inneractive.sdk.dv.enums.a aVar = com.fyber.inneractive.sdk.dv.enums.a.Load;
            g gVar = this.f999a;
            com.fyber.inneractive.sdk.dv.handler.e.a(spotId, aVar, gVar.f1126a, (i) gVar.b, String.format("errorCode - %d", Integer.valueOf(i)));
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        g gVar = this.f999a;
        if (gVar.g != null) {
            gVar.g();
            this.f999a.g.g();
        }
    }
}
