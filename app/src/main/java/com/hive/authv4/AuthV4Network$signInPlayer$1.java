package com.hive.authv4;

import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.protocol.authv4.SignInPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Network$signInPlayer$1", f = "AuthV4Network.kt", i = {0, 0, 0}, l = {1570}, m = "invokeSuspend", n = {"signInPlayer", "rq", "errorResult"}, s = {"L$0", "L$1", "L$2"})
public final class AuthV4Network$signInPlayer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<ResultAPI, SignInPlayer, AuthV4.PlayerInfo, String, Unit> $callback;
    final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AuthV4Network$signInPlayer$1(AuthV4.PlayerInfo playerInfo, Function4<? super ResultAPI, ? super SignInPlayer, ? super AuthV4.PlayerInfo, ? super String, Unit> function4, Continuation<? super AuthV4Network$signInPlayer$1> continuation) {
        super(2, continuation);
        this.$playerInfo = playerInfo;
        this.$callback = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Network$signInPlayer$1(this.$playerInfo, this.$callback, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:77|14|(1:16)(9:17|22|73|23|(1:25)|26|30|(5:75|32|(4:34|35|(4:79|37|(2:44|(1:(2:50|89)(2:51|(2:53|91)(1:90))))|57)|82)|58|(1:60)(3:61|62|(0)(0)))|70)|21|22|73|23|(0)|26|30|(0)|70) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x010e, code lost:
    
        com.hive.logger.LoggerImpl.INSTANCE.w("[AuthV4Network] authSignInPlayer Exception: " + r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e0 A[Catch: Exception -> 0x010d, TryCatch #0 {Exception -> 0x010d, blocks: (B:23:0x0078, B:25:0x00e0, B:26:0x00e2), top: B:73:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0232 A[Catch: Exception -> 0x0021, TryCatch #4 {Exception -> 0x0021, blocks: (B:6:0x0019, B:62:0x0224, B:64:0x0232, B:65:0x0241), top: B:81:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0241 A[Catch: Exception -> 0x0021, TRY_LEAVE, TryCatch #4 {Exception -> 0x0021, blocks: (B:6:0x0019, B:62:0x0224, B:64:0x0232, B:65:0x0241), top: B:81:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 681
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Network$signInPlayer$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthV4Network$signInPlayer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
