package com.unity3d.ads.core.domain.exposure;

import com.google.android.exoplayer2.RendererCapabilities;
import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$loadScarAd$1", f = "CommonAdViewerExposedFunctions.kt", i = {}, l = {RendererCapabilities.MODE_SUPPORT_MASK}, m = "invoke", n = {}, s = {})
final class CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt.C31531 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1(CommonAdViewerExposedFunctionsKt.C31531 c31531, Continuation<? super CommonAdViewerExposedFunctionsKt$loadScarAd$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = c31531;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke2((Object[]) null, (Continuation<? super Unit>) this);
    }
}
