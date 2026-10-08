package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public interface c extends k, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k {
    int Q();

    Flow<d> a();

    StateFlow<Boolean> isPlaying();

    void r();
}
