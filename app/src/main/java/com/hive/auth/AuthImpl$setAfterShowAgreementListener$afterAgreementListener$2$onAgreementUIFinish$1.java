package com.hive.auth;

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
@DebugMetadata(c = "com.hive.auth.AuthImpl$setAfterShowAgreementListener$afterAgreementListener$2$onAgreementUIFinish$1", f = "AuthImpl.kt", i = {}, l = {437}, m = "invokeSuspend", n = {}, s = {})
public final class AuthImpl$setAfterShowAgreementListener$afterAgreementListener$2$onAgreementUIFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isAgreementSuccess;
    final /* synthetic */ int $resultCode;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthImpl$setAfterShowAgreementListener$afterAgreementListener$2$onAgreementUIFinish$1(int i, boolean z, Continuation<? super AuthImpl$setAfterShowAgreementListener$afterAgreementListener$2$onAgreementUIFinish$1> continuation) {
        super(2, continuation);
        this.$resultCode = i;
        this.$isAgreementSuccess = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthImpl$setAfterShowAgreementListener$afterAgreementListener$2$onAgreementUIFinish$1(this.$resultCode, this.$isAgreementSuccess, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LoggerImpl.INSTANCE.i(AuthDataInterface.getTAG(), "initializeSDKV1, AfterAgreementListener onAgreementUIFinish, resultCode : " + this.$resultCode + ", isAgreementSuccess : " + this.$isAgreementSuccess);
                AuthImpl authImpl = AuthImpl.INSTANCE;
                boolean z = this.$isAgreementSuccess;
                this.label = 1;
                obj = authImpl.requestDidAndSendAgreement(z, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue != 0 && iIntValue != 1) {
                return Unit.INSTANCE;
            }
            AuthImpl authImpl2 = AuthImpl.INSTANCE;
            authImpl2.checkMaintenancePopupAndFinishInitialize();
            if (iIntValue == 0) {
                authImpl2.requestPromotionDownloadInfo();
            }
            return Unit.INSTANCE;
        } catch (Exception unused) {
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthImpl$setAfterShowAgreementListener$afterAgreementListener$2$onAgreementUIFinish$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
