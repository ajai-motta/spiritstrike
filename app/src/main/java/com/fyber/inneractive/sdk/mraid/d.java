package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.fyber.inneractive.sdk.factories.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAMraidKit f1180a;

    public d(IAMraidKit iAMraidKit) {
        this.f1180a = iAMraidKit;
    }

    @Override // com.fyber.inneractive.sdk.factories.a
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        return this.f1180a.isMRaidSpotContent(inneractiveAdSpot);
    }

    @Override // com.fyber.inneractive.sdk.factories.a
    public final com.fyber.inneractive.sdk.interfaces.d a() {
        return new com.fyber.inneractive.sdk.renderers.l();
    }
}
