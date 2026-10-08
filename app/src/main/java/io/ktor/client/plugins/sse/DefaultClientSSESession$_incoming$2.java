package io.ktor.client.plugins.sse;

import io.ktor.sse.ServerSentEvent;
import io.ktor.util.logging.LoggerJvmKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.slf4j.Logger;

/* JADX INFO: compiled from: DefaultClientSSESession.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lio/ktor/sse/ServerSentEvent;", "cause", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$2", f = "DefaultClientSSESession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DefaultClientSSESession$_incoming$2 extends SuspendLambda implements Function3<FlowCollector<? super ServerSentEvent>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultClientSSESession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultClientSSESession$_incoming$2(DefaultClientSSESession defaultClientSSESession, Continuation<? super DefaultClientSSESession$_incoming$2> continuation) {
        super(3, continuation);
        this.this$0 = defaultClientSSESession;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super ServerSentEvent> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        DefaultClientSSESession$_incoming$2 defaultClientSSESession$_incoming$2 = new DefaultClientSSESession$_incoming$2(this.this$0, continuation);
        defaultClientSSESession$_incoming$2.L$0 = th;
        return defaultClientSSESession$_incoming$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Throwable th = (Throwable) this.L$0;
        if (!(th instanceof CancellationException)) {
            Logger logger = SSEKt.getLOGGER();
            if (LoggerJvmKt.isTraceEnabled(logger)) {
                logger.trace("Error during SSE session processing: " + th);
            }
            this.this$0.close();
            throw th;
        }
        return Unit.INSTANCE;
    }
}
