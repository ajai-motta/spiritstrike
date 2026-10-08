package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: loaded from: classes6.dex */
public interface u {
    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y> a(Context context, com.moloco.sdk.internal.ortb.model.c cVar, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar);

    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> a(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, String str, r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar);

    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> a(Context context, CoroutineScope coroutineScope, com.moloco.sdk.internal.ortb.model.c cVar, r rVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, MutableStateFlow<Boolean> mutableStateFlow, boolean z);
}
