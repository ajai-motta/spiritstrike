package com.hive.userengagement;

import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.hive.userengagement.UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithWebView$1", f = "UserEngagement.kt", i = {}, l = {1209}, m = "invokeSuspend", n = {}, s = {})
public final class UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithWebView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Integer, Integer, Unit> $callback;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithWebView$1(Function2<? super Integer, ? super Integer, Unit> function2, Continuation<? super UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithWebView$1> continuation) {
        super(2, continuation);
        this.$callback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithWebView$1(this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = UserEngagement.requestFirstLaunchDirectlinkData$getCssScreenSizeWithInvisibleWebView(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Pair pair = (Pair) obj;
        this.$callback.invoke((Integer) pair.getFirst(), (Integer) pair.getSecond());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UserEngagement$requestFirstLaunchDirectlinkData$getCssScreenSizeWithWebView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
