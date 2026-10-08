package com.hive.authv4;

import com.google.zxing.pdf417.PDF417Common;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.protocol.authv4.SignIn;
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
@DebugMetadata(c = "com.hive.authv4.AuthV4Network$signIn$1", f = "AuthV4Network.kt", i = {0, 0, 0}, l = {PDF417Common.MAX_CODEWORDS_IN_BARCODE}, m = "invokeSuspend", n = {"rq", "errorResult", "playerInfo"}, s = {"L$0", "L$1", "L$2"})
public final class AuthV4Network$signIn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<ResultAPI, SignIn, AuthV4.PlayerInfo, String, Unit> $callback;
    final /* synthetic */ String $recaptchaToken;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AuthV4Network$signIn$1(String str, Function4<? super ResultAPI, ? super SignIn, ? super AuthV4.PlayerInfo, ? super String, Unit> function4, Continuation<? super AuthV4Network$signIn$1> continuation) {
        super(2, continuation);
        this.$recaptchaToken = str;
        this.$callback = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Network$signIn$1(this.$recaptchaToken, this.$callback, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(2:61|14)|(1:16)(8:17|22|64|23|(1:25)|26|30|(4:32|63|33|(2:35|(4:37|(1:39)|40|(1:42)(3:43|44|(0)(0)))(2:49|50))(2:51|52)))|21|22|64|23|(0)|26|30|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f3, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f4, code lost:
    
        com.hive.logger.LoggerImpl.INSTANCE.w("[AuthV4Network] agreement Exception: " + r2);
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cf A[Catch: Exception -> 0x00f3, TryCatch #3 {Exception -> 0x00f3, blocks: (B:23:0x0076, B:25:0x00cf, B:26:0x00d1), top: B:64:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0184 A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:6:0x001a, B:44:0x0176, B:46:0x0184, B:47:0x0194), top: B:60:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0194 A[Catch: Exception -> 0x001f, TRY_LEAVE, TryCatch #0 {Exception -> 0x001f, blocks: (B:6:0x001a, B:44:0x0176, B:46:0x0184, B:47:0x0194), top: B:60:0x001a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Network$signIn$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthV4Network$signIn$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
