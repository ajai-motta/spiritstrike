package com.hive.authv4;

import android.util.Log;
import com.hive.AuthV4;
import com.hive.Const;
import com.hive.ResultAPI;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Impl$setup$1$1$1", f = "AuthV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AuthV4Impl$setup$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthV4.AuthV4SetupListener $setupListener;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthV4Impl$setup$1$1$1(AuthV4.AuthV4SetupListener authV4SetupListener, Continuation<? super AuthV4Impl$setup$1$1$1> continuation) {
        super(2, continuation);
        this.$setupListener = authV4SetupListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Impl$setup$1$1$1(this.$setupListener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Log.e(Const.TAG, "Auth is already initialized. Please use Auth class.");
        AuthV4.AuthV4SetupListener authV4SetupListener = this.$setupListener;
        if (authV4SetupListener == null) {
            return null;
        }
        authV4SetupListener.onAuthV4Setup(new ResultAPI(-2, ResultAPI.Code.AuthV4OnRunningV1, "Auth is already initialized. Please use Auth class."), false, null, null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthV4Impl$setup$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
