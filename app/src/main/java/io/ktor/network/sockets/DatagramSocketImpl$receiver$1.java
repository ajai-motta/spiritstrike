package io.ktor.network.sockets;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/* JADX INFO: compiled from: DatagramSocketImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lio/ktor/network/sockets/Datagram;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.network.sockets.DatagramSocketImpl$receiver$1", f = "DatagramSocketImpl.kt", i = {0, 1}, l = {52, 52}, m = "invokeSuspend", n = {"$this$produce", "$this$produce"}, s = {"L$0", "L$0"})
final class DatagramSocketImpl$receiver$1 extends SuspendLambda implements Function2<ProducerScope<? super Datagram>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DatagramSocketImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatagramSocketImpl$receiver$1(DatagramSocketImpl datagramSocketImpl, Continuation<? super DatagramSocketImpl$receiver$1> continuation) {
        super(2, continuation);
        this.this$0 = datagramSocketImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DatagramSocketImpl$receiver$1 datagramSocketImpl$receiver$1 = new DatagramSocketImpl$receiver$1(this.this$0, continuation);
        datagramSocketImpl$receiver$1.L$0 = obj;
        return datagramSocketImpl$receiver$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super Datagram> producerScope, Continuation<? super Unit> continuation) {
        return ((DatagramSocketImpl$receiver$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x005c -> B:15:0x0032). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r1 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L5e
            r9 = r1
            goto L32
        L17:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1f:
            java.lang.Object r1 = r8.L$1
            kotlinx.coroutines.channels.SendChannel r1 = (kotlinx.coroutines.channels.SendChannel) r1
            java.lang.Object r4 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r4 = (kotlinx.coroutines.channels.ProducerScope) r4
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            goto L4b
        L2b:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.L$0
            kotlinx.coroutines.channels.ProducerScope r9 = (kotlinx.coroutines.channels.ProducerScope) r9
        L32:
            kotlinx.coroutines.channels.SendChannel r1 = r9.getChannel()     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            io.ktor.network.sockets.DatagramSocketImpl r4 = r8.this$0     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            r8.L$0 = r9     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            r8.L$1 = r1     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            r8.label = r3     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            java.lang.Object r4 = io.ktor.network.sockets.DatagramSocketImpl.access$receiveImpl(r4, r5)     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            if (r4 != r0) goto L48
            return r0
        L48:
            r7 = r4
            r4 = r9
            r9 = r7
        L4b:
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            r8.L$0 = r4     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            r6 = 0
            r8.L$1 = r6     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            r8.label = r2     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            java.lang.Object r9 = r1.send(r9, r5)     // Catch: java.lang.Throwable -> L5e java.lang.Throwable -> L5e
            if (r9 != r0) goto L5c
            return r0
        L5c:
            r9 = r4
            goto L32
        L5e:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSocketImpl$receiver$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
