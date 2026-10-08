package com.hive.authv4;

import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.AuthV4Network;
import com.hive.protocol.provision.Integration;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001*\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lcom/hive/ResultAPI;", "Lcom/hive/protocol/provision/Integration;", "Ljava/util/ArrayList;", "Lcom/hive/AuthV4$AuthV4MaintenanceInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Impl$setup$1$1$integrationFlow$1", f = "AuthV4Impl.kt", i = {}, l = {496}, m = "invokeSuspend", n = {}, s = {})
public final class AuthV4Impl$setup$1$1$integrationFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Triple<? extends ResultAPI, ? extends Integration, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>>>, Object> {
    int label;

    public AuthV4Impl$setup$1$1$integrationFlow$1(Continuation<? super AuthV4Impl$setup$1$1$integrationFlow$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Impl$setup$1$1$integrationFlow$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Triple<? extends ResultAPI, ? extends Integration, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Triple<ResultAPI, Integration, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>>>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        AuthV4Network.Provision provision = AuthV4Network.Provision.INSTANCE;
        this.label = 1;
        Object objIntegration$hive_service_release = provision.integration$hive_service_release(this);
        return objIntegration$hive_service_release == coroutine_suspended ? coroutine_suspended : objIntegration$hive_service_release;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Triple<ResultAPI, Integration, ? extends ArrayList<AuthV4.AuthV4MaintenanceInfo>>> continuation) {
        return ((AuthV4Impl$setup$1$1$integrationFlow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
