package com.fyber.inneractive.sdk.video;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.factories.g;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.interfaces.f;
import com.fyber.inneractive.sdk.renderers.q;
import com.fyber.inneractive.sdk.renderers.v;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements g {
    @Override // com.fyber.inneractive.sdk.factories.g
    public final boolean a(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof t0);
    }

    @Override // com.fyber.inneractive.sdk.factories.g
    public final f b(InneractiveAdSpot inneractiveAdSpot) {
        InneractiveAdRequest inneractiveAdRequest = inneractiveAdSpot.getAdContent().f1126a;
        return (inneractiveAdSpot.getAdContent().c() && (inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen())) ? new v() : new q();
    }
}
