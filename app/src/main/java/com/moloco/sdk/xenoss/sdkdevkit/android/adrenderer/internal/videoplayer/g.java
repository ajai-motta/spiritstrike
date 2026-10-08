package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import android.view.View;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.P;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class g {
    public static final Flow<Boolean> b(P p, View view) {
        Flow<Boolean> flowA;
        return (view == null || (flowA = p.a(view)) == null) ? FlowKt.flowOf(Boolean.FALSE) : flowA;
    }
}
