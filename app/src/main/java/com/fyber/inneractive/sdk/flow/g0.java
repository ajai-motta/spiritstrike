package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;

/* JADX INFO: loaded from: classes3.dex */
public interface g0 {
    void onAdRefreshFailed(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode);

    void onAdRefreshed(InneractiveAdSpot inneractiveAdSpot);
}
