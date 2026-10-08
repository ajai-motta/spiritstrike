package com.google.ads.mediation.fyber;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FyberFactory.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/google/ads/mediation/fyber/FyberFactory;", "", "<init>", "()V", "createRewardedAdSpot", "Lcom/fyber/inneractive/sdk/external/InneractiveAdSpot;", "createInneractiveFullscreenUnitController", "Lcom/fyber/inneractive/sdk/external/InneractiveFullscreenUnitController;", "adx-library-fyber_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FyberFactory {
    public static final FyberFactory INSTANCE = new FyberFactory();

    private FyberFactory() {
    }

    @JvmStatic
    public static final InneractiveAdSpot createRewardedAdSpot() {
        InneractiveAdSpot inneractiveAdSpotCreateSpot = InneractiveAdSpotManager.get().createSpot();
        Intrinsics.checkNotNullExpressionValue(inneractiveAdSpotCreateSpot, "createSpot(...)");
        return inneractiveAdSpotCreateSpot;
    }

    @JvmStatic
    public static final InneractiveFullscreenUnitController createInneractiveFullscreenUnitController() {
        return new InneractiveFullscreenUnitController();
    }
}
