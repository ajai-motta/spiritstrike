package com.hive.authv4;

import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.protocol.authv4.CustomAuthSignInIdp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.hive.authv4.AuthV4Network$customAuthSignInIdp$1", f = "AuthV4Network.kt", i = {0, 0, 0, 0}, l = {1235}, m = "invokeSuspend", n = {"rq", "errorResult", "playerInfo", "firstIdpId"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class AuthV4Network$customAuthSignInIdp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $authKey;
    final /* synthetic */ Function5<ResultAPI, CustomAuthSignInIdp, AuthV4.PlayerInfo, String, String, Unit> $callback;
    final /* synthetic */ String $player;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AuthV4Network$customAuthSignInIdp$1(String str, String str2, Function5<? super ResultAPI, ? super CustomAuthSignInIdp, ? super AuthV4.PlayerInfo, ? super String, ? super String, Unit> function5, Continuation<? super AuthV4Network$customAuthSignInIdp$1> continuation) {
        super(2, continuation);
        this.$authKey = str;
        this.$player = str2;
        this.$callback = function5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthV4Network$customAuthSignInIdp$1(this.$authKey, this.$player, this.$callback, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:119|14|(1:16)(8:17|22|116|23|(1:25)|26|30|(4:32|118|33|(2:35|(4:37|(1:39)|40|(2:99|100)(2:44|(2:97|98)(7:121|48|(1:50)(1:51)|52|(4:54|55|(4:111|57|(2:62|(1:(2:68|(1:130)(2:72|131))(2:73|(1:134)(2:79|135))))|82)|123)|83|(1:85)(5:86|113|87|(0)(0)|90))))(2:101|102))(2:103|104))(1:108))|21|22|116|23|(0)|26|30|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x010b, code lost:
    
        com.hive.logger.LoggerImpl.INSTANCE.w("[AuthV4Network] customAuthSignIn Exception: " + r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e6 A[Catch: Exception -> 0x010a, TryCatch #3 {Exception -> 0x010a, blocks: (B:23:0x0086, B:25:0x00e6, B:26:0x00e8), top: B:116:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028a A[Catch: Exception -> 0x02be, TryCatch #1 {Exception -> 0x02be, blocks: (B:87:0x027c, B:89:0x028a, B:91:0x02a0), top: B:113:0x027c }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02a0 A[Catch: Exception -> 0x02be, TRY_LEAVE, TryCatch #1 {Exception -> 0x02be, blocks: (B:87:0x027c, B:89:0x028a, B:91:0x02a0), top: B:113:0x027c }] */
    /* JADX WARN: Type inference failed for: r9v8, types: [T, com.hive.AuthV4$PlayerInfo, com.hive.AuthV4$ProfileInfo] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 818
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Network$customAuthSignInIdp$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthV4Network$customAuthSignInIdp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
