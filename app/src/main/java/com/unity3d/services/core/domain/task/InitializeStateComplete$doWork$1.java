package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateComplete;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: InitializeStateComplete.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateComplete", f = "InitializeStateComplete.kt", i = {}, l = {18}, m = "doWork-gIAlu-s", n = {}, s = {})
final class InitializeStateComplete$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateComplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateComplete$doWork$1(InitializeStateComplete initializeStateComplete, Continuation<? super InitializeStateComplete$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateComplete;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM7124doWorkgIAlus = this.this$0.m7124doWorkgIAlus((InitializeStateComplete.Params) null, (Continuation<? super Result<Unit>>) this);
        return objM7124doWorkgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM7124doWorkgIAlus : Result.m7414boximpl(objM7124doWorkgIAlus);
    }
}
