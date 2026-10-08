package com.hive.authv4.agegate;

import android.app.Activity;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.agegate.AgeGateCheck;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.agegate.AgeGateCheck$show$1$dismiss$1", f = "AgeGateCheck.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AgeGateCheck$show$1$dismiss$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $dateOfBirth;
    final /* synthetic */ AuthV4.AuthV4AgeGateListener $listener;
    final /* synthetic */ ResultAPI $result;
    int label;
    final /* synthetic */ AgeGateCheck.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgeGateCheck$show$1$dismiss$1(AuthV4.AuthV4AgeGateListener authV4AgeGateListener, ResultAPI resultAPI, Ref.ObjectRef<String> objectRef, AgeGateCheck.AnonymousClass1 anonymousClass1, Continuation<? super AgeGateCheck$show$1$dismiss$1> continuation) {
        super(2, continuation);
        this.$listener = authV4AgeGateListener;
        this.$result = resultAPI;
        this.$dateOfBirth = objectRef;
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AgeGateCheck$show$1$dismiss$1(this.$listener, this.$result, this.$dateOfBirth, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$listener.onAuthV4AgeGate(this.$result, this.$dateOfBirth.element);
        Activity launchActivity = this.this$0.getLaunchActivity();
        if (launchActivity != null) {
            launchActivity.finish();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AgeGateCheck$show$1$dismiss$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
