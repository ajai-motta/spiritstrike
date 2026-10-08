package io.ktor.websocket;

import io.ktor.websocket.Frame;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: PingPong.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.websocket.PingPongKt$pinger$1$rc$1", f = "PingPong.kt", i = {}, l = {77, 81}, m = "invokeSuspend", n = {}, s = {})
final class PingPongKt$pinger$1$rc$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<Frame.Pong> $channel;
    final /* synthetic */ SendChannel<Frame> $outgoing;
    final /* synthetic */ String $pingMessage;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PingPongKt$pinger$1$rc$1(SendChannel<? super Frame> sendChannel, String str, Channel<Frame.Pong> channel, Continuation<? super PingPongKt$pinger$1$rc$1> continuation) {
        super(2, continuation);
        this.$outgoing = sendChannel;
        this.$pingMessage = str;
        this.$channel = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PingPongKt$pinger$1$rc$1(this.$outgoing, this.$pingMessage, this.$channel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PingPongKt$pinger$1$rc$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0050 -> B:16:0x0053). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r10)
            goto L53
        L12:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1a:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L45
        L1e:
            kotlin.ResultKt.throwOnFailure(r10)
            org.slf4j.Logger r10 = io.ktor.websocket.DefaultWebSocketSessionKt.getLOGGER()
            java.lang.String r1 = "WebSocket Pinger: sending ping frame"
            r10.trace(r1)
            kotlinx.coroutines.channels.SendChannel<io.ktor.websocket.Frame> r10 = r9.$outgoing
            io.ktor.websocket.Frame$Ping r1 = new io.ktor.websocket.Frame$Ping
            java.lang.String r4 = r9.$pingMessage
            java.nio.charset.Charset r5 = kotlin.text.Charsets.ISO_8859_1
            byte[] r4 = io.ktor.utils.io.core.StringsKt.toByteArray(r4, r5)
            r1.<init>(r4)
            r4 = r9
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r9.label = r3
            java.lang.Object r10 = r10.send(r1, r4)
            if (r10 != r0) goto L45
            return r0
        L45:
            kotlinx.coroutines.channels.Channel<io.ktor.websocket.Frame$Pong> r10 = r9.$channel
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r9.label = r2
            java.lang.Object r10 = r10.receive(r1)
            if (r10 != r0) goto L53
            return r0
        L53:
            io.ktor.websocket.Frame$Pong r10 = (io.ktor.websocket.Frame.Pong) r10
            byte[] r3 = r10.getData()
            byte[] r1 = r10.getData()
            int r5 = r1.length
            r7 = 4
            r8 = 0
            r4 = 0
            r6 = 0
            java.lang.String r1 = kotlin.text.StringsKt.decodeToString$default(r3, r4, r5, r6, r7, r8)
            java.lang.String r3 = r9.$pingMessage
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L86
            org.slf4j.Logger r0 = io.ktor.websocket.DefaultWebSocketSessionKt.getLOGGER()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "WebSocket Pinger: received valid pong frame "
            r1.<init>(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.trace(r10)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L86:
            org.slf4j.Logger r1 = io.ktor.websocket.DefaultWebSocketSessionKt.getLOGGER()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "WebSocket Pinger: received invalid pong frame "
            r3.<init>(r4)
            r3.append(r10)
            java.lang.String r10 = ", continue waiting"
            r3.append(r10)
            java.lang.String r10 = r3.toString()
            r1.trace(r10)
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.websocket.PingPongKt$pinger$1$rc$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
