package com.unity3d.ads.core.domain.exposure;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CommonAdViewerExposedFunctions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.exposure.CommonAdViewerExposedFunctionsKt$request$1", f = "CommonAdViewerExposedFunctions.kt", i = {0, 0}, l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "invoke", n = {"id", "url"}, s = {"L$0", "L$1"})
final class CommonAdViewerExposedFunctionsKt$request$1$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonAdViewerExposedFunctionsKt.C31621 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonAdViewerExposedFunctionsKt$request$1$invoke$1(CommonAdViewerExposedFunctionsKt.C31621 c31621, Continuation<? super CommonAdViewerExposedFunctionsKt$request$1$invoke$1> continuation) {
        super(continuation);
        this.this$0 = c31621;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke2((Object[]) null, (Continuation<Object>) this);
    }
}
