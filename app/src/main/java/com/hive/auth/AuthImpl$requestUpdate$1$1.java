package com.hive.auth;

import com.hive.ResultAPI;
import com.hive.auth.AuthDataInterface;
import com.hive.protocol.logincenter.Update;
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
@DebugMetadata(c = "com.hive.auth.AuthImpl$requestUpdate$1$1", f = "AuthImpl.kt", i = {}, l = {2545, 2572}, m = "invokeSuspend", n = {}, s = {})
public final class AuthImpl$requestUpdate$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $did;
    final /* synthetic */ String $fApiName;
    final /* synthetic */ Update $it;
    final /* synthetic */ AuthDataInterface.AuthLoginListener $listener;
    final /* synthetic */ String $uid;
    final /* synthetic */ String $verifier;
    int label;

    /* JADX INFO: renamed from: com.hive.auth.AuthImpl$requestUpdate$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.auth.AuthImpl$requestUpdate$1$1$2", f = "AuthImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $fApiName;
        final /* synthetic */ Update $it;
        final /* synthetic */ AuthDataInterface.AuthLoginListener $listener;
        final /* synthetic */ String $logMsg;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Update update, String str, String str2, AuthDataInterface.AuthLoginListener authLoginListener, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$it = update;
            this.$logMsg = str;
            this.$fApiName = str2;
            this.$listener = authLoginListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$it, this.$logMsg, this.$fApiName, this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AuthImpl.INSTANCE.onLoginFinish(this.$it.getResponse().getErrno() == 2300 ? new ResultAPI(0, ResultAPI.Code.RefundUser, this.$logMsg) : new ResultAPI(0, ResultAPI.Code.Success, this.$logMsg), AuthDataInterface.LoginType.ACCOUNT, AuthImpl.currentAccount, null, this.$fApiName, this.$listener);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthImpl$requestUpdate$1$1(Update update, String str, String str2, String str3, String str4, AuthDataInterface.AuthLoginListener authLoginListener, Continuation<? super AuthImpl$requestUpdate$1$1> continuation) {
        super(2, continuation);
        this.$it = update;
        this.$verifier = str;
        this.$uid = str2;
        this.$did = str3;
        this.$fApiName = str4;
        this.$listener = authLoginListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthImpl$requestUpdate$1$1(this.$it, this.$verifier, this.$uid, this.$did, this.$fApiName, this.$listener, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x013c, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r2, r10, r22) == r1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0152, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r3, r7, r22) == r1) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.auth.AuthImpl$requestUpdate$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthImpl$requestUpdate$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
