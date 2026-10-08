package com.hive.authv4;

import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.AuthV4Network;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.provision.AgreementDetermineBasePlayer;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/hive/ResultAPI;", "Lcom/hive/protocol/provision/AgreementDetermineBasePlayer;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Impl$onSignInFinish$1$agreementDetermineBasePlayerFlow$1", f = "AuthV4Impl.kt", i = {}, l = {5499}, m = "invokeSuspend", n = {}, s = {})
public final class AuthV4Impl$onSignInFinish$1$agreementDetermineBasePlayerFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends ResultAPI, ? extends AgreementDetermineBasePlayer>>, Object> {
    final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthV4Impl$onSignInFinish$1$agreementDetermineBasePlayerFlow$1(AuthV4.PlayerInfo playerInfo, Continuation<? super AuthV4Impl$onSignInFinish$1$agreementDetermineBasePlayerFlow$1> continuation) {
        super(2, continuation);
        this.$playerInfo = playerInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Impl$onSignInFinish$1$agreementDetermineBasePlayerFlow$1(this.$playerInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends ResultAPI, ? extends AgreementDetermineBasePlayer>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Pair<ResultAPI, AgreementDetermineBasePlayer>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!ConfigurationImpl.INSTANCE.isAgreementDetermineBaseAccount()) {
                LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[onSignInFinish. Skip, /provision/agreement-determine-base-player 통신]");
                return null;
            }
            LoggerImpl.INSTANCE.i(AuthV4.getTAG(), "[onSignInFinish. /provision/agreement-determine-base-player 통신]");
            AuthV4Network.Provision provision = AuthV4Network.Provision.INSTANCE;
            AuthV4.PlayerInfo playerInfo = this.$playerInfo;
            this.label = 1;
            obj = provision.agreementDetermineBasePlayer$hive_service_release(playerInfo, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return (Pair) obj;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Pair<ResultAPI, AgreementDetermineBasePlayer>> continuation) {
        return ((AuthV4Impl$onSignInFinish$1$agreementDetermineBasePlayerFlow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
