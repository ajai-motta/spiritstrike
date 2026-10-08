package com.hive.authv4;

import com.hive.Configuration;
import com.hive.Const;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Impl$setup$1$1$4", f = "AuthV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AuthV4Impl$setup$1$1$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public AuthV4Impl$setup$1$1$4(Continuation<? super AuthV4Impl$setup$1$1$4> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Impl$setup$1$1$4(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        LoggerImpl.INSTANCE.i(Const.TAG, "\n\n=== Hive Core Version ===\nHive Core = 26.2.0\nHive Protocol = 26.2.0\n\n=== SDK Version ===\n\nHive SDK = " + Configuration.getHiveSDKVersion() + "\n");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthV4Impl$setup$1$1$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
