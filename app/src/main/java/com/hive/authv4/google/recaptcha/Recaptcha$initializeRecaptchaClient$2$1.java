package com.hive.authv4.google.recaptcha;

import android.app.Application;
import com.google.android.recaptcha.RecaptchaClient;
import com.hive.HiveActivity;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Recaptcha.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.google.recaptcha.Recaptcha$initializeRecaptchaClient$2$1", f = "Recaptcha.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
final class Recaptcha$initializeRecaptchaClient$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<RecaptchaClient> $cont;
    final /* synthetic */ String $siteKey;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    Recaptcha$initializeRecaptchaClient$2$1(String str, CancellableContinuation<? super RecaptchaClient> cancellableContinuation, Continuation<? super Recaptcha$initializeRecaptchaClient$2$1> continuation) {
        super(2, continuation);
        this.$siteKey = str;
        this.$cont = cancellableContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Recaptcha$initializeRecaptchaClient$2$1(this.$siteKey, this.$cont, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Recaptcha$initializeRecaptchaClient$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM5049getClientBWLJW6A$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            com.google.android.recaptcha.Recaptcha recaptcha = com.google.android.recaptcha.Recaptcha.INSTANCE;
            Application application = HiveActivity.INSTANCE.getRecentActivity().getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
            this.label = 1;
            objM5049getClientBWLJW6A$default = com.google.android.recaptcha.Recaptcha.m5049getClientBWLJW6A$default(recaptcha, application, this.$siteKey, 0L, this, 4, null);
            if (objM5049getClientBWLJW6A$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            objM5049getClientBWLJW6A$default = ((Result) obj).getValue();
        }
        CancellableContinuation<RecaptchaClient> cancellableContinuation = this.$cont;
        if (Result.m7422isSuccessimpl(objM5049getClientBWLJW6A$default)) {
            RecaptchaClient recaptchaClient = (RecaptchaClient) objM5049getClientBWLJW6A$default;
            LoggerImpl.INSTANCE.d("[Recaptcha] init success.");
            Recaptcha recaptcha2 = Recaptcha.INSTANCE;
            Recaptcha.recaptchaClient = recaptchaClient;
            if (cancellableContinuation.isActive()) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m7415constructorimpl(recaptchaClient));
            }
        }
        CancellableContinuation<RecaptchaClient> cancellableContinuation2 = this.$cont;
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM5049getClientBWLJW6A$default);
        if (thM7418exceptionOrNullimpl != null) {
            Recaptcha.INSTANCE.handleFailure("init", thM7418exceptionOrNullimpl);
            if (cancellableContinuation2.isActive()) {
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m7415constructorimpl(null));
            }
        }
        return Unit.INSTANCE;
    }
}
