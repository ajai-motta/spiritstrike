package com.hive.authv4;

import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.analytics.logger.RemoteLoggerV2;
import com.hive.base.Android;
import com.hive.logger.LoggerImpl;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Impl$setup$1$1$5", f = "AuthV4Impl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AuthV4Impl$setup$1$1$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthV4.AuthV4SetupListener $setupListener;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthV4Impl$setup$1$1$5(AuthV4.AuthV4SetupListener authV4SetupListener, Continuation<? super AuthV4Impl$setup$1$1$5> continuation) {
        super(2, continuation);
        this.$setupListener = authV4SetupListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Impl$setup$1$1$5(this.$setupListener, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String advertisingId = Android.INSTANCE.getAdvertisingId();
        StringBuilder sb = new StringBuilder("\n=== Advertising ID in setup ===\n");
        if (advertisingId != null) {
            sb.append(advertisingId);
        } else {
            sb.append("It could not obtained Advertising Id from com.hive.base.Android.getAdvertisingId()");
        }
        sb.append("\n=== Advertising ID ===\n\n");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL(sb.toString());
        RemoteLoggerV2.INSTANCE.remoteLoggingValidation(HiveActivity.INSTANCE.getRecentActivity());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("[API_CALL] ===  %s ===\nlistener = %s", Arrays.copyOf(new Object[]{"AuthV4.setup()", this.$setupListener}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        loggerImpl.i(AuthV4.getTAG(), str);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthV4Impl$setup$1$1$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
