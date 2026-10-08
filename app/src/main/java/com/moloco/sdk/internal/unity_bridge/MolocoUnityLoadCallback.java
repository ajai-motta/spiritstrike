package com.moloco.sdk.internal.unity_bridge;

import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/moloco/sdk/internal/unity_bridge/MolocoUnityLoadCallback;", "", "onAdLoadSuccess", "", HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, "", "onAdLoadFailed", "error", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MolocoUnityLoadCallback {
    void onAdLoadFailed(String adUnitId, String error);

    void onAdLoadSuccess(String adUnitId);
}
