package io.ktor.websocket;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: RawWebSocketCommon.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.RawWebSocketCommon$writerJob$1", f = "RawWebSocketCommon.kt", i = {1, 2}, l = {62, 64, 65, 84, 84, 84, 84}, m = "invokeSuspend", n = {"message", "message"}, s = {"L$0", "L$0"})
final class RawWebSocketCommon$writerJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RawWebSocketCommon this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RawWebSocketCommon$writerJob$1(RawWebSocketCommon rawWebSocketCommon, Continuation<? super RawWebSocketCommon$writerJob$1> continuation) {
        super(2, continuation);
        this.this$0 = rawWebSocketCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RawWebSocketCommon$writerJob$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RawWebSocketCommon$writerJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054 A[Catch: all -> 0x0033, ChannelWriteException -> 0x0036, TryCatch #3 {ChannelWriteException -> 0x0036, all -> 0x0033, blocks: (B:9:0x0025, B:32:0x0088, B:20:0x003c, B:23:0x0050, B:25:0x0054, B:29:0x0073, B:38:0x00bb, B:40:0x00bf, B:41:0x00ca, B:42:0x00e0, B:34:0x008c, B:12:0x002b, B:13:0x002f), top: B:67:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c A[Catch: all -> 0x0033, ChannelWriteException -> 0x0036, TRY_LEAVE, TryCatch #3 {ChannelWriteException -> 0x0036, all -> 0x0033, blocks: (B:9:0x0025, B:32:0x0088, B:20:0x003c, B:23:0x0050, B:25:0x0054, B:29:0x0073, B:38:0x00bb, B:40:0x00bf, B:41:0x00ca, B:42:0x00e0, B:34:0x008c, B:12:0x002b, B:13:0x002f), top: B:67:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bb A[Catch: all -> 0x0033, ChannelWriteException -> 0x0036, TRY_ENTER, TryCatch #3 {ChannelWriteException -> 0x0036, all -> 0x0033, blocks: (B:9:0x0025, B:32:0x0088, B:20:0x003c, B:23:0x0050, B:25:0x0054, B:29:0x0073, B:38:0x00bb, B:40:0x00bf, B:41:0x00ca, B:42:0x00e0, B:34:0x008c, B:12:0x002b, B:13:0x002f), top: B:67:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0158  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0085 -> B:32:0x0088). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00bf -> B:20:0x003c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0145 -> B:51:0x0145). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.RawWebSocketCommon$writerJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
