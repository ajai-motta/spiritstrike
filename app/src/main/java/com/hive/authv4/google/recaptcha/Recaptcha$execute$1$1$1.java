package com.hive.authv4.google.recaptcha;

import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaClient;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Recaptcha.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.google.recaptcha.Recaptcha$execute$1$1$1", f = "Recaptcha.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
final class Recaptcha$execute$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends String>>, Object> {
    final /* synthetic */ RecaptchaClient $client;
    final /* synthetic */ Function2<Integer, String, Unit> $listener;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Recaptcha$execute$1$1$1(RecaptchaClient recaptchaClient, Function2<? super Integer, ? super String, Unit> function2, Continuation<? super Recaptcha$execute$1$1$1> continuation) {
        super(2, continuation);
        this.$client = recaptchaClient;
        this.$listener = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Recaptcha$execute$1$1$1(this.$client, this.$listener, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends String>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<String>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<String>> continuation) {
        return ((Recaptcha$execute$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objMo5052executegIAlus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            objMo5052executegIAlus = this.$client.mo5052executegIAlus(RecaptchaAction.INSTANCE.custom("SIGNIN"), this);
            if (objMo5052executegIAlus == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objMo5052executegIAlus = ((Result) obj).getValue();
        }
        Function2<Integer, String, Unit> function2 = this.$listener;
        if (Result.m7422isSuccessimpl(objMo5052executegIAlus)) {
            String str = (String) objMo5052executegIAlus;
            if (str.length() > 0) {
                LoggerImpl.INSTANCE.d("[Recaptcha] execute success.");
                function2.invoke(Boxing.boxInt(0), str);
            } else {
                LoggerImpl.INSTANCE.w("[Recaptcha] execute token is empty.");
                function2.invoke(Boxing.boxInt(-1), null);
            }
        }
        Function2<Integer, String, Unit> function22 = this.$listener;
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objMo5052executegIAlus);
        if (thM7418exceptionOrNullimpl != null) {
            function22.invoke(Boxing.boxInt(Recaptcha.INSTANCE.handleFailure("execute", thM7418exceptionOrNullimpl)), null);
        }
        return Result.m7414boximpl(objMo5052executegIAlus);
    }
}
