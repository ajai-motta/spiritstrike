package io.ktor.client.plugins.sse;

import io.ktor.client.statement.HttpStatement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: io.ktor.client.plugins.sse.BuildersKt$serverSentEventsSession-i8z2VEo$$inlined$processSession-rp2poPw$1, reason: invalid class name */
/* JADX INFO: compiled from: builders.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "io/ktor/client/plugins/sse/BuildersKt$processSession$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt$processSession$2", f = "builders.kt", i = {0, 1, 1}, l = {1121, 1124, 1136, 1136}, m = "invokeSuspend", n = {"this_$iv", "this_$iv", "response$iv"}, s = {"L$0", "L$0", "L$2"})
public final class BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred $sessionDeferred;
    final /* synthetic */ HttpStatement $statement;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1(HttpStatement httpStatement, CompletableDeferred completableDeferred, Continuation continuation) {
        super(2, continuation);
        this.$statement = httpStatement;
        this.$sessionDeferred = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1(this.$statement, this.$sessionDeferred, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:(1:(1:(1:(1:(2:8|9)(3:10|11|68))(4:13|14|60|61))(4:16|67|17|(5:42|43|(1:45)|60|61)(2:46|47)))(2:21|22))(4:26|27|28|(1:30)(1:31))|63|33|65|34|37|(1:39)(2:40|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099 A[Catch: all -> 0x003f, TRY_ENTER, TRY_LEAVE, TryCatch #5 {all -> 0x003f, blocks: (B:17:0x003b, B:42:0x0099, B:46:0x00b2, B:47:0x00b9), top: B:67:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2 A[Catch: all -> 0x003f, TRY_ENTER, TryCatch #5 {all -> 0x003f, blocks: (B:17:0x003b, B:42:0x0099, B:46:0x00b2, B:47:0x00b9), top: B:67:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ca  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.BuildersKt$serverSentEventsSessioni8z2VEo$$inlined$processSessionrp2poPw$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
