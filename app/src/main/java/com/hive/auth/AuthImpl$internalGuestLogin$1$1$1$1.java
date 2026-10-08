package com.hive.auth;

import com.hive.ResultAPI;
import com.hive.auth.AuthDataInterface;
import com.hive.protocol.logincenter.OauthToken;
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
@DebugMetadata(c = "com.hive.auth.AuthImpl$internalGuestLogin$1$1$1$1", f = "AuthImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AuthImpl$internalGuestLogin$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ OauthToken.OauthTokenResponse $exchangeResponse;
    final /* synthetic */ String $fApiName;
    final /* synthetic */ AuthDataInterface.AuthLoginListener $listener;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthImpl$internalGuestLogin$1$1$1$1(OauthToken.OauthTokenResponse oauthTokenResponse, String str, AuthDataInterface.AuthLoginListener authLoginListener, Continuation<? super AuthImpl$internalGuestLogin$1$1$1$1> continuation) {
        super(2, continuation);
        this.$exchangeResponse = oauthTokenResponse;
        this.$fApiName = str;
        this.$listener = authLoginListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthImpl$internalGuestLogin$1$1$1$1(this.$exchangeResponse, this.$fApiName, this.$listener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        AuthImpl.INSTANCE.onLoginFinish(new ResultAPI(-8, ResultAPI.Code.AuthServerResponseNotSuccessful, this.$exchangeResponse.getError() + '(' + this.$exchangeResponse.getErrno() + ')'), AuthDataInterface.LoginType.GUEST, null, null, this.$fApiName, this.$listener);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthImpl$internalGuestLogin$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
