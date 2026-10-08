package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: InitializeStateLoadWeb.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$LoadWebResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2", f = "InitializeStateLoadWeb.kt", i = {0, 0, 1}, l = {46, 64, 71}, m = "invokeSuspend", n = {"$this$withContext", "request", "request"}, s = {"L$0", "L$3", "L$2"})
final class InitializeStateLoadWeb$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>>, Object> {
    final /* synthetic */ InitializeStateLoadWeb.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2(InitializeStateLoadWeb.Params params, InitializeStateLoadWeb initializeStateLoadWeb, Continuation<? super InitializeStateLoadWeb$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateLoadWeb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateLoadWeb$doWork$2 initializeStateLoadWeb$doWork$2 = new InitializeStateLoadWeb$doWork$2(this.$params, this.this$0, continuation);
        initializeStateLoadWeb$doWork$2.L$0 = obj;
        return initializeStateLoadWeb$doWork$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return ((InitializeStateLoadWeb$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016e A[Catch: all -> 0x01f8, CancellationException -> 0x0225, TryCatch #6 {CancellationException -> 0x0225, all -> 0x01f8, blocks: (B:8:0x001a, B:51:0x0191, B:55:0x01b4, B:57:0x01be, B:60:0x01c9, B:61:0x01db, B:63:0x01de, B:64:0x01ea, B:46:0x0168, B:48:0x016e, B:52:0x0194, B:53:0x01a6, B:45:0x015e, B:38:0x012c, B:54:0x01a7, B:37:0x0122, B:23:0x0071, B:13:0x0039, B:43:0x0155, B:40:0x0132), top: B:80:0x000e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0194 A[Catch: all -> 0x01f8, CancellationException -> 0x0225, TryCatch #6 {CancellationException -> 0x0225, all -> 0x01f8, blocks: (B:8:0x001a, B:51:0x0191, B:55:0x01b4, B:57:0x01be, B:60:0x01c9, B:61:0x01db, B:63:0x01de, B:64:0x01ea, B:46:0x0168, B:48:0x016e, B:52:0x0194, B:53:0x01a6, B:45:0x015e, B:38:0x012c, B:54:0x01a7, B:37:0x0122, B:23:0x0071, B:13:0x0039, B:43:0x0155, B:40:0x0132), top: B:80:0x000e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01be A[Catch: all -> 0x01f8, CancellationException -> 0x0225, TryCatch #6 {CancellationException -> 0x0225, all -> 0x01f8, blocks: (B:8:0x001a, B:51:0x0191, B:55:0x01b4, B:57:0x01be, B:60:0x01c9, B:61:0x01db, B:63:0x01de, B:64:0x01ea, B:46:0x0168, B:48:0x016e, B:52:0x0194, B:53:0x01a6, B:45:0x015e, B:38:0x012c, B:54:0x01a7, B:37:0x0122, B:23:0x0071, B:13:0x0039, B:43:0x0155, B:40:0x0132), top: B:80:0x000e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01de A[Catch: all -> 0x01f8, CancellationException -> 0x0225, TryCatch #6 {CancellationException -> 0x0225, all -> 0x01f8, blocks: (B:8:0x001a, B:51:0x0191, B:55:0x01b4, B:57:0x01be, B:60:0x01c9, B:61:0x01db, B:63:0x01de, B:64:0x01ea, B:46:0x0168, B:48:0x016e, B:52:0x0194, B:53:0x01a6, B:45:0x015e, B:38:0x012c, B:54:0x01a7, B:37:0x0122, B:23:0x0071, B:13:0x0039, B:43:0x0155, B:40:0x0132), top: B:80:0x000e, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0210  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.unity3d.services.core.network.model.HttpRequest] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.unity3d.services.core.domain.task.InitializeStateLoadWeb] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r37) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
