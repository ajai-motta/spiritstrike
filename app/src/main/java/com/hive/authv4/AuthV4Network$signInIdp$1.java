package com.hive.authv4;

import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.protocol.authv4.SignInIdp;
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
@DebugMetadata(c = "com.hive.authv4.AuthV4Network$signInIdp$1", f = "AuthV4Network.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {2393, 1092}, m = "invokeSuspend", n = {"$this$launch", "signInIdp", "verifier", ClientData.KEY_CHALLENGE, "rq", "errorResult", "playerInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
public final class AuthV4Network$signInIdp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<ResultAPI, SignInIdp, AuthV4.PlayerInfo, String, Unit> $callback;
    final /* synthetic */ String $player;
    final /* synthetic */ AuthV4ProviderAdapter $provider;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AuthV4Network$signInIdp$1(AuthV4ProviderAdapter authV4ProviderAdapter, String str, Function4<? super ResultAPI, ? super SignInIdp, ? super AuthV4.PlayerInfo, ? super String, Unit> function4, Continuation<? super AuthV4Network$signInIdp$1> continuation) {
        super(2, continuation);
        this.$provider = authV4ProviderAdapter;
        this.$player = str;
        this.$callback = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AuthV4Network$signInIdp$1 authV4Network$signInIdp$1 = new AuthV4Network$signInIdp$1(this.$provider, this.$player, this.$callback, continuation);
        authV4Network$signInIdp$1.L$0 = obj;
        return authV4Network$signInIdp$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0180, code lost:
    
        if (r6 != r4) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0358 A[Catch: Exception -> 0x0388, TryCatch #6 {Exception -> 0x0388, blocks: (B:120:0x034a, B:122:0x0358, B:123:0x036a), top: B:155:0x034a }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x036a A[Catch: Exception -> 0x0388, TRY_LEAVE, TryCatch #6 {Exception -> 0x0388, blocks: (B:120:0x034a, B:122:0x0358, B:123:0x036a), top: B:155:0x034a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0135 A[Catch: Exception -> 0x01b3, TryCatch #7 {Exception -> 0x01b3, blocks: (B:29:0x00a1, B:31:0x0135, B:32:0x0137, B:34:0x014b, B:36:0x0153, B:38:0x017d), top: B:157:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014b A[Catch: Exception -> 0x01b3, TryCatch #7 {Exception -> 0x01b3, blocks: (B:29:0x00a1, B:31:0x0135, B:32:0x0137, B:34:0x014b, B:36:0x0153, B:38:0x017d), top: B:157:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x017d A[Catch: Exception -> 0x01b3, TRY_LEAVE, TryCatch #7 {Exception -> 0x01b3, blocks: (B:29:0x00a1, B:31:0x0135, B:32:0x0137, B:34:0x014b, B:36:0x0153, B:38:0x017d), top: B:157:0x00a1 }] */
    /* JADX WARN: Type inference failed for: r10v24, types: [T, com.hive.AuthV4$PlayerInfo, com.hive.AuthV4$ProfileInfo] */
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
    public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1025
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.AuthV4Network$signInIdp$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AuthV4Network$signInIdp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
