package com.moloco.sdk.publisher;

import androidx.core.view.InputDeviceCompat;
import com.moloco.sdk.internal.InterfaceC2985a;
import com.moloco.sdk.internal.publisher.v;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/moloco/sdk/internal/a;", "<anonymous>", "()Lcom/moloco/sdk/internal/a;"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$adCreator$2$1", f = "Moloco.kt", i = {}, l = {InputDeviceCompat.SOURCE_DPAD}, m = "invokeSuspend", n = {}, s = {})
public final class Moloco$adCreator$2$1 extends SuspendLambda implements Function1<Continuation<? super InterfaceC2985a>, Object> {
    int label;

    public Moloco$adCreator$2$1(Continuation<? super Moloco$adCreator$2$1> continuation) {
        super(1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Moloco$adCreator$2$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            v initializationHandler = Moloco.INSTANCE.getInitializationHandler();
            this.label = 1;
            obj = initializationHandler.a(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super InterfaceC2985a> continuation) {
        return ((Moloco$adCreator$2$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
