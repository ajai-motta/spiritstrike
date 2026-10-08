package io.ktor.network.sockets;

import com.facebook.appevents.integrity.IntegrityManager;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.SocketOptions;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ProtocolFamily;
import java.net.StandardProtocolFamily;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConnectUtilsJvm.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0080@¢\u0006\u0004\b\u0007\u0010\b\u001a*\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0080@¢\u0006\u0004\b\f\u0010\r\u001a#\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a%\u0010\u0015\u001a\n \u0011*\u0004\u0018\u00010\u00140\u0014*\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketAddress;", "remoteAddress", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/network/sockets/Socket;", "tcpConnect", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localAddress", "Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;", "Lio/ktor/network/sockets/ServerSocket;", "tcpBind", "(Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketAddress;Lio/ktor/network/sockets/SocketOptions$AcceptorOptions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/channels/spi/SelectorProvider;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Ljava/nio/channels/SocketChannel;", "kotlin.jvm.PlatformType", "openSocketChannelFor", "(Ljava/nio/channels/spi/SelectorProvider;Lio/ktor/network/sockets/SocketAddress;)Ljava/nio/channels/SocketChannel;", "Ljava/nio/channels/ServerSocketChannel;", "openServerSocketChannelFor", "(Ljava/nio/channels/spi/SelectorProvider;Lio/ktor/network/sockets/SocketAddress;)Ljava/nio/channels/ServerSocketChannel;", "ktor-network"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ConnectUtilsJvmKt {

    /* JADX INFO: renamed from: io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectUtilsJvm.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.ConnectUtilsJvmKt", f = "ConnectUtilsJvm.kt", i = {0}, l = {21}, m = "tcpConnect", n = {"result$iv"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectUtilsJvmKt.tcpConnect(null, null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object tcpConnect(io.ktor.network.selector.SelectorManager r6, io.ktor.network.sockets.SocketAddress r7, io.ktor.network.sockets.SocketOptions.TCPClientSocketOptions r8, kotlin.coroutines.Continuation<? super io.ktor.network.sockets.Socket> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.network.sockets.ConnectUtilsJvmKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1 r0 = (io.ktor.network.sockets.ConnectUtilsJvmKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1 r0 = new io.ktor.network.sockets.ConnectUtilsJvmKt$tcpConnect$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.L$1
            io.ktor.network.sockets.SocketImpl r6 = (io.ktor.network.sockets.SocketImpl) r6
            java.lang.Object r7 = r0.L$0
            java.io.Closeable r7 = (java.io.Closeable) r7
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r6 = move-exception
            goto L7f
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.throwOnFailure(r9)
            java.nio.channels.spi.SelectorProvider r9 = r6.getProvider()
            java.nio.channels.SocketChannel r9 = openSocketChannelFor(r9, r7)
            java.io.Closeable r9 = (java.io.Closeable) r9
            r2 = r9
            java.nio.channels.SocketChannel r2 = (java.nio.channels.SocketChannel) r2     // Catch: java.lang.Throwable -> L7d
            boolean r4 = r7 instanceof io.ktor.network.sockets.InetSocketAddress     // Catch: java.lang.Throwable -> L7d
            if (r4 == 0) goto L5c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch: java.lang.Throwable -> L7d
            r4 = r2
            java.nio.channels.SelectableChannel r4 = (java.nio.channels.SelectableChannel) r4     // Catch: java.lang.Throwable -> L7d
            r5 = r8
            io.ktor.network.sockets.SocketOptions r5 = (io.ktor.network.sockets.SocketOptions) r5     // Catch: java.lang.Throwable -> L7d
            io.ktor.network.sockets.JavaSocketOptionsKt.assignOptions(r4, r5)     // Catch: java.lang.Throwable -> L7d
        L5c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch: java.lang.Throwable -> L7d
            r4 = r2
            java.nio.channels.SelectableChannel r4 = (java.nio.channels.SelectableChannel) r4     // Catch: java.lang.Throwable -> L7d
            io.ktor.network.sockets.JavaSocketOptionsKt.nonBlocking(r4)     // Catch: java.lang.Throwable -> L7d
            io.ktor.network.sockets.SocketImpl r4 = new io.ktor.network.sockets.SocketImpl     // Catch: java.lang.Throwable -> L7d
            r4.<init>(r2, r6, r8)     // Catch: java.lang.Throwable -> L7d
            java.net.SocketAddress r6 = io.ktor.network.sockets.JavaSocketAddressUtilsKt.toJavaAddress(r7)     // Catch: java.lang.Throwable -> L7d
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L7d
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L7d
            r0.label = r3     // Catch: java.lang.Throwable -> L7d
            java.lang.Object r6 = r4.connect$ktor_network(r6, r0)     // Catch: java.lang.Throwable -> L7d
            if (r6 != r1) goto L7b
            return r1
        L7b:
            r6 = r4
        L7c:
            return r6
        L7d:
            r6 = move-exception
            r7 = r9
        L7f:
            r7.close()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.ConnectUtilsJvmKt.tcpConnect(io.ktor.network.selector.SelectorManager, io.ktor.network.sockets.SocketAddress, io.ktor.network.sockets.SocketOptions$TCPClientSocketOptions, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final SocketChannel openSocketChannelFor(SelectorProvider selectorProvider, SocketAddress address) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(selectorProvider, "<this>");
        Intrinsics.checkNotNullParameter(address, "address");
        if (address instanceof InetSocketAddress) {
            return selectorProvider.openSocketChannel();
        }
        if (!(address instanceof UnixSocketAddress)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objInvoke = SelectorProvider.class.getMethod("openSocketChannel", ProtocolFamily.class).invoke(selectorProvider, StandardProtocolFamily.valueOf("UNIX"));
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.nio.channels.SocketChannel");
        return (SocketChannel) objInvoke;
    }

    public static final ServerSocketChannel openServerSocketChannelFor(SelectorProvider selectorProvider, SocketAddress socketAddress) throws IllegalAccessException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(selectorProvider, "<this>");
        if (socketAddress == null) {
            return selectorProvider.openServerSocketChannel();
        }
        if (socketAddress instanceof InetSocketAddress) {
            return selectorProvider.openServerSocketChannel();
        }
        if (!(socketAddress instanceof UnixSocketAddress)) {
            throw new NoWhenBranchMatchedException();
        }
        Object objInvoke = SelectorProvider.class.getMethod("openServerSocketChannel", ProtocolFamily.class).invoke(selectorProvider, StandardProtocolFamily.valueOf("UNIX"));
        Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type java.nio.channels.ServerSocketChannel");
        return (ServerSocketChannel) objInvoke;
    }

    public static final Object tcpBind(SelectorManager selectorManager, SocketAddress socketAddress, SocketOptions.AcceptorOptions acceptorOptions, Continuation<? super ServerSocket> continuation) throws IllegalAccessException, IOException, InvocationTargetException {
        ServerSocketChannel serverSocketChannelOpenServerSocketChannelFor = openServerSocketChannelFor(selectorManager.getProvider(), socketAddress);
        try {
            ServerSocketChannel serverSocketChannel = serverSocketChannelOpenServerSocketChannelFor;
            if (socketAddress instanceof InetSocketAddress) {
                Intrinsics.checkNotNull(serverSocketChannel);
                JavaSocketOptionsKt.assignOptions(serverSocketChannel, acceptorOptions);
            }
            Intrinsics.checkNotNull(serverSocketChannel);
            JavaSocketOptionsKt.nonBlocking(serverSocketChannel);
            ServerSocketImpl serverSocketImpl = new ServerSocketImpl(serverSocketChannel, selectorManager);
            if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
                serverSocketImpl.getChannel().bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null, acceptorOptions.getBacklogSize());
            } else {
                serverSocketImpl.getChannel().socket().bind(socketAddress != null ? JavaSocketAddressUtilsKt.toJavaAddress(socketAddress) : null, acceptorOptions.getBacklogSize());
            }
            return serverSocketImpl;
        } catch (Throwable th) {
            serverSocketChannelOpenServerSocketChannelFor.close();
            throw th;
        }
    }
}
