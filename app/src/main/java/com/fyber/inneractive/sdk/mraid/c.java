package com.fyber.inneractive.sdk.mraid;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.fyber.inneractive.sdk.factories.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAMraidKit f1178a;

    public c(IAMraidKit iAMraidKit) {
        this.f1178a = iAMraidKit;
    }

    @Override // com.fyber.inneractive.sdk.factories.g
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        return this.f1178a.isMRaidSpotContent(inneractiveAdSpot);
    }

    @Override // com.fyber.inneractive.sdk.factories.g
    public final com.fyber.inneractive.sdk.interfaces.f b(InneractiveAdSpot inneractiveAdSpot) {
        return new com.fyber.inneractive.sdk.renderers.t();
    }
}
