package com.moloco.sdk.publisher;

import com.adxcorp.util.ADXLogUtil;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"createAdInfo", "Lcom/moloco/sdk/publisher/MolocoAd;", HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, "", AnalyticsProviderAdjust.EventKeys.revenue, "", "creativeId", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)Lcom/moloco/sdk/publisher/MolocoAd;", "moloco-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MolocoAdKt {
    public static final MolocoAd createAdInfo(String adUnitId, Float f, String str) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        return new MolocoAd(ADXLogUtil.PLATFORM_MOLOCO, adUnitId, f, str);
    }

    public static /* synthetic */ MolocoAd createAdInfo$default(String str, Float f, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return createAdInfo(str, f, str2);
    }
}
