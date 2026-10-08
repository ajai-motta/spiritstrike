package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public interface InterfaceC3018b {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.b$a */
    public interface a {
        void a();

        void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar);

        void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar);
    }

    void a(long j, a aVar);

    StateFlow<Boolean> isLoaded();
}
