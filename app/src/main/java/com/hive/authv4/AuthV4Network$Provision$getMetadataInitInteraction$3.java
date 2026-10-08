package com.hive.authv4;

import com.hive.ResultAPI;
import com.hive.authv4.AuthV4Network;
import com.hive.protocol.provision.MetadataInitInteraction;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Network$Provision$getMetadataInitInteraction$3", f = "AuthV4Network.kt", i = {}, l = {2172}, m = "invokeSuspend", n = {}, s = {})
public final class AuthV4Network$Provision$getMetadataInitInteraction$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<ResultAPI, MetadataInitInteraction, Unit> $callback;
    final /* synthetic */ boolean $forceReload;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AuthV4Network$Provision$getMetadataInitInteraction$3(boolean z, Function2<? super ResultAPI, ? super MetadataInitInteraction, Unit> function2, Continuation<? super AuthV4Network$Provision$getMetadataInitInteraction$3> continuation) {
        super(2, continuation);
        this.$forceReload = z;
        this.$callback = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Network$Provision$getMetadataInitInteraction$3(this.$forceReload, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AuthV4Network.Provision provision = AuthV4Network.Provision.INSTANCE;
            boolean z = this.$forceReload;
            this.label = 1;
            obj = provision.getMetadataInitInteraction$hive_service_release(z, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Triple triple = (Triple) obj;
        this.$callback.invoke((ResultAPI) triple.getFirst(), (MetadataInitInteraction) triple.getSecond());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthV4Network$Provision$getMetadataInitInteraction$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
