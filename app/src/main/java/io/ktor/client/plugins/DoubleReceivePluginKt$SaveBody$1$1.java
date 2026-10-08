package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: SaveBody.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", "response"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DoubleReceivePluginKt$SaveBody$1$1", f = "SaveBody.kt", i = {0, 0, 0}, l = {45, 52}, m = "invokeSuspend", n = {"$this$intercept", "response", "attributes"}, s = {"L$0", "L$1", "L$2"})
final class DoubleReceivePluginKt$SaveBody$1$1 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    DoubleReceivePluginKt$SaveBody$1$1(Continuation<? super DoubleReceivePluginKt$SaveBody$1$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        DoubleReceivePluginKt$SaveBody$1$1 doubleReceivePluginKt$SaveBody$1$1 = new DoubleReceivePluginKt$SaveBody$1$1(continuation);
        doubleReceivePluginKt$SaveBody$1$1.L$0 = pipelineContext;
        doubleReceivePluginKt$SaveBody$1$1.L$1 = httpResponse;
        return doubleReceivePluginKt$SaveBody$1$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:48|(1:(1:(3:6|37|38)(2:7|8))(2:9|10))(2:12|(4:14|(1:16)|17|18)(4:19|(1:21)|22|(1:24)(1:25)))|26|52|27|31|(1:33)|34|(1:36)|37|38) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bf, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c0, code lost:
    
        r6 = kotlin.Result.INSTANCE;
        r2 = kotlin.Result.m7415constructorimpl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v4, types: [io.ktor.client.statement.HttpResponse] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DoubleReceivePluginKt$SaveBody$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
