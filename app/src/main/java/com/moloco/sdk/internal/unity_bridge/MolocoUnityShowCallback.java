package com.moloco.sdk.internal.unity_bridge;

import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/moloco/sdk/internal/unity_bridge/MolocoUnityShowCallback;", "", "onAdShowSuccess", "", HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, "", "onAdShowFailed", "error", "onAdHidden", "onAdClicked", "onAdRewarded", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MolocoUnityShowCallback {
    void onAdClicked(String adUnitId);

    void onAdHidden(String adUnitId);

    void onAdRewarded(String adUnitId);

    void onAdShowFailed(String adUnitId, String error);

    void onAdShowSuccess(String adUnitId);
}
