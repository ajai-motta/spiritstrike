package io.ktor.network.sockets;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Sockets.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\f\u001a\u00020\u000b*\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\"\u0015\u0010\u0012\u001a\u00020\t*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0018\u001a\u00020\u0015*\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lio/ktor/network/sockets/ASocket;", "", "awaitClosed", "(Lio/ktor/network/sockets/ASocket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/network/sockets/AReadable;", "Lio/ktor/utils/io/ByteReadChannel;", "openReadChannel", "(Lio/ktor/network/sockets/AReadable;)Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/network/sockets/AWritable;", "", "autoFlush", "Lio/ktor/utils/io/ByteWriteChannel;", "openWriteChannel", "(Lio/ktor/network/sockets/AWritable;Z)Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/network/sockets/Socket;", "Lio/ktor/network/sockets/Connection;", "connection", "(Lio/ktor/network/sockets/Socket;)Lio/ktor/network/sockets/Connection;", "isClosed", "(Lio/ktor/network/sockets/ASocket;)Z", "Lio/ktor/network/sockets/ServerSocket;", "", "getPort", "(Lio/ktor/network/sockets/ServerSocket;)I", "port", "ktor-network"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SocketsKt {

    /* JADX INFO: renamed from: io.ktor.network.sockets.SocketsKt$awaitClosed$1, reason: invalid class name */
    /* JADX INFO: compiled from: Sockets.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.SocketsKt", f = "Sockets.kt", i = {0}, l = {49}, m = "awaitClosed", n = {"$this$awaitClosed"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SocketsKt.awaitClosed(null, this);
        }
    }

    public static final boolean isClosed(ASocket aSocket) {
        Intrinsics.checkNotNullParameter(aSocket, "<this>");
        return aSocket.getSocketContext().isCompleted();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitClosed(io.ktor.network.sockets.ASocket r4, kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.network.sockets.SocketsKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.network.sockets.SocketsKt$awaitClosed$1 r0 = (io.ktor.network.sockets.SocketsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.network.sockets.SocketsKt$awaitClosed$1 r0 = new io.ktor.network.sockets.SocketsKt$awaitClosed$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.network.sockets.ASocket r4 = (io.ktor.network.sockets.ASocket) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L48
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.Job r5 = r4.getSocketContext()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.join(r0)
            if (r5 != r1) goto L48
            return r1
        L48:
            kotlinx.coroutines.Job r5 = r4.getSocketContext()
            boolean r5 = r5.isCancelled()
            if (r5 != 0) goto L55
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L55:
            kotlinx.coroutines.Job r4 = r4.getSocketContext()
            java.util.concurrent.CancellationException r4 = r4.getCancellationException()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.SocketsKt.awaitClosed(io.ktor.network.sockets.ASocket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final ByteReadChannel openReadChannel(AReadable aReadable) {
        Intrinsics.checkNotNullParameter(aReadable, "<this>");
        ByteChannel byteChannel = new ByteChannel(false);
        aReadable.attachForReading(byteChannel);
        return byteChannel;
    }

    public static /* synthetic */ ByteWriteChannel openWriteChannel$default(AWritable aWritable, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return openWriteChannel(aWritable, z);
    }

    public static final ByteWriteChannel openWriteChannel(AWritable aWritable, boolean z) {
        Intrinsics.checkNotNullParameter(aWritable, "<this>");
        ByteChannel byteChannel = new ByteChannel(z);
        aWritable.attachForWriting(byteChannel);
        return byteChannel;
    }

    public static final int getPort(ServerSocket serverSocket) {
        Intrinsics.checkNotNullParameter(serverSocket, "<this>");
        return SocketAddressKt.port(serverSocket.getLocalAddress());
    }

    public static final Connection connection(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        return new Connection(socket, openReadChannel(socket), openWriteChannel$default(socket, false, 1, null));
    }
}
