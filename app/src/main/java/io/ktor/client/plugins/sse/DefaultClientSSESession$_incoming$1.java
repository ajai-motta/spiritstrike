package io.ktor.client.plugins.sse;

import io.ktor.sse.ServerSentEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: DefaultClientSSESession.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lio/ktor/sse/ServerSentEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$1", f = "DefaultClientSSESession.kt", i = {0, 1, 2}, l = {48, 53, 57}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow"}, s = {"L$0", "L$0", "L$0"})
final class DefaultClientSSESession$_incoming$1 extends SuspendLambda implements Function2<FlowCollector<? super ServerSentEvent>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultClientSSESession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultClientSSESession$_incoming$1(DefaultClientSSESession defaultClientSSESession, Continuation<? super DefaultClientSSESession$_incoming$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultClientSSESession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultClientSSESession$_incoming$1 defaultClientSSESession$_incoming$1 = new DefaultClientSSESession$_incoming$1(this.this$0, continuation);
        defaultClientSSESession$_incoming$1.L$0 = obj;
        return defaultClientSSESession$_incoming$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super ServerSentEvent> flowCollector, Continuation<? super Unit> continuation) {
        return ((DefaultClientSSESession$_incoming$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00be  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x008f -> B:15:0x0045). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00b4 -> B:13:0x0039). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00b7 -> B:13:0x0039). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L32
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r1
            goto L39
        L1a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L22:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8f
        L2a:
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L68
        L32:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
        L39:
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r8.this$0
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()
            boolean r1 = kotlinx.coroutines.JobKt.isActive(r1)
            if (r1 == 0) goto Lbe
        L45:
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r8.this$0
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()
            boolean r1 = kotlinx.coroutines.JobKt.isActive(r1)
            if (r1 == 0) goto L9f
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r8.this$0
            io.ktor.utils.io.ByteReadChannel r5 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getInput$p(r1)
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.L$0 = r9
            r8.label = r4
            java.lang.Object r1 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$tryParseEvent(r1, r5, r6)
            if (r1 != r0) goto L65
            return r0
        L65:
            r7 = r1
            r1 = r9
            r9 = r7
        L68:
            io.ktor.sse.ServerSentEvent r9 = (io.ktor.sse.ServerSentEvent) r9
            if (r9 != 0) goto L6e
            r9 = r1
            goto L9f
        L6e:
            io.ktor.client.plugins.sse.DefaultClientSSESession r5 = r8.this$0
            boolean r5 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$isCommentsEvent(r5, r9)
            if (r5 == 0) goto L7e
            io.ktor.client.plugins.sse.DefaultClientSSESession r5 = r8.this$0
            boolean r5 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getShowCommentEvents$p(r5)
            if (r5 == 0) goto L8f
        L7e:
            io.ktor.client.plugins.sse.DefaultClientSSESession r5 = r8.this$0
            boolean r5 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$isRetryEvent(r5, r9)
            if (r5 == 0) goto L91
            io.ktor.client.plugins.sse.DefaultClientSSESession r5 = r8.this$0
            boolean r5 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getShowRetryEvents$p(r5)
            if (r5 == 0) goto L8f
            goto L91
        L8f:
            r9 = r1
            goto L45
        L91:
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r8.L$0 = r1
            r8.label = r3
            java.lang.Object r9 = r1.emit(r9, r5)
            if (r9 != r0) goto L8f
            return r0
        L9f:
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r8.this$0
            boolean r1 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$getNeedToReconnect$p(r1)
            if (r1 == 0) goto Lb7
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r8.this$0
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r8.L$0 = r9
            r8.label = r2
            java.lang.Object r1 = io.ktor.client.plugins.sse.DefaultClientSSESession.access$doReconnection(r1, r5)
            if (r1 != r0) goto L39
            return r0
        Lb7:
            io.ktor.client.plugins.sse.DefaultClientSSESession r1 = r8.this$0
            io.ktor.client.plugins.sse.DefaultClientSSESession.access$close(r1)
            goto L39
        Lbe:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.sse.DefaultClientSSESession$_incoming$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
