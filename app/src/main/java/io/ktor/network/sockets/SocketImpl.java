package io.ktor.network.sockets;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import io.ktor.network.selector.SelectInterest;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.SocketOptions;
import java.io.IOException;
import java.net.InetAddress;
import java.nio.channels.SocketChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SocketImpl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004B#\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0080@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001d¨\u0006!"}, d2 = {"Lio/ktor/network/sockets/SocketImpl;", "Ljava/nio/channels/SocketChannel;", ExifInterface.LATITUDE_SOUTH, "Lio/ktor/network/sockets/NIOSocketImpl;", "Lio/ktor/network/sockets/Socket;", "channel", "Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "<init>", "(Ljava/nio/channels/SocketChannel;Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)V", "Ljava/net/SocketAddress;", TypedValues.AttributesType.S_TARGET, "connect$ktor_network", "(Ljava/net/SocketAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect", "", "state", "", "wantConnect", "(Z)V", "inetSelfConnect", "()Z", "Ljava/nio/channels/SocketChannel;", "getChannel", "()Ljava/nio/channels/SocketChannel;", "Lio/ktor/network/sockets/SocketAddress;", "getLocalAddress", "()Lio/ktor/network/sockets/SocketAddress;", "localAddress", "getRemoteAddress", "remoteAddress", "ktor-network"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocketImpl<S extends SocketChannel> extends NIOSocketImpl<S> implements Socket {
    private final S channel;

    public /* synthetic */ SocketImpl(SocketChannel socketChannel, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(socketChannel, selectorManager, (i & 4) != 0 ? null : tCPClientSocketOptions);
    }

    @Override // io.ktor.network.sockets.NIOSocketImpl, io.ktor.network.selector.Selectable
    public S getChannel() {
        return this.channel;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SocketImpl(S channel, SelectorManager selector, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        super(channel, selector, null, tCPClientSocketOptions);
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.channel = channel;
        if (!(!getChannel().isBlocking())) {
            throw new IllegalArgumentException("Channel need to be configured as non-blocking.".toString());
        }
    }

    @Override // io.ktor.network.sockets.ABoundSocket
    public SocketAddress getLocalAddress() throws IOException {
        java.net.SocketAddress localSocketAddress;
        SocketAddress socketAddress;
        if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
            localSocketAddress = getChannel().getLocalAddress();
        } else {
            localSocketAddress = getChannel().socket().getLocalSocketAddress();
        }
        if (localSocketAddress == null || (socketAddress = JavaSocketAddressUtilsKt.toSocketAddress(localSocketAddress)) == null) {
            throw new IllegalStateException("Channel is not yet bound");
        }
        return socketAddress;
    }

    @Override // io.ktor.network.sockets.AConnectedSocket
    public SocketAddress getRemoteAddress() throws IOException {
        java.net.SocketAddress remoteSocketAddress;
        SocketAddress socketAddress;
        if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
            remoteSocketAddress = getChannel().getRemoteAddress();
        } else {
            remoteSocketAddress = getChannel().socket().getRemoteSocketAddress();
        }
        if (remoteSocketAddress == null || (socketAddress = JavaSocketAddressUtilsKt.toSocketAddress(remoteSocketAddress)) == null) {
            throw new IllegalStateException("Channel is not yet connected");
        }
        return socketAddress;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object connect$ktor_network(java.net.SocketAddress r6, kotlin.coroutines.Continuation<? super io.ktor.network.sockets.Socket> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.network.sockets.SocketImpl$connect$1
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.network.sockets.SocketImpl$connect$1 r0 = (io.ktor.network.sockets.SocketImpl$connect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.network.sockets.SocketImpl$connect$1 r0 = new io.ktor.network.sockets.SocketImpl$connect$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            goto L32
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L59
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            java.nio.channels.SocketChannel r7 = r5.getChannel()
            boolean r6 = r7.connect(r6)
            if (r6 == 0) goto L44
            return r5
        L44:
            r5.wantConnect(r4)
            io.ktor.network.selector.SelectorManager r6 = r5.getSelector()
            r7 = r5
            io.ktor.network.selector.Selectable r7 = (io.ktor.network.selector.Selectable) r7
            io.ktor.network.selector.SelectInterest r2 = io.ktor.network.selector.SelectInterest.CONNECT
            r0.label = r4
            java.lang.Object r6 = r6.select(r7, r2, r0)
            if (r6 != r1) goto L59
            return r1
        L59:
            java.nio.channels.SocketChannel r6 = r5.getChannel()
            boolean r6 = r6.finishConnect()
            if (r6 == 0) goto L88
            boolean r6 = r5.inetSelfConnect()
            if (r6 == 0) goto L83
            boolean r6 = io.ktor.network.sockets.JavaSocketOptionsKt.getJava7NetworkApisAvailable()
            if (r6 == 0) goto L77
            java.nio.channels.SocketChannel r6 = r5.getChannel()
            r6.close()
            goto L59
        L77:
            java.nio.channels.SocketChannel r6 = r5.getChannel()
            java.net.Socket r6 = r6.socket()
            r6.close()
            goto L59
        L83:
            r6 = 0
            r5.wantConnect(r6)
            return r5
        L88:
            r5.wantConnect(r4)
            io.ktor.network.selector.SelectorManager r6 = r5.getSelector()
            r7 = r5
            io.ktor.network.selector.Selectable r7 = (io.ktor.network.selector.Selectable) r7
            io.ktor.network.selector.SelectInterest r2 = io.ktor.network.selector.SelectInterest.CONNECT
            r0.label = r3
            java.lang.Object r6 = r6.select(r7, r2, r0)
            if (r6 != r1) goto L59
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.SocketImpl.connect$ktor_network(java.net.SocketAddress, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ void wantConnect$default(SocketImpl socketImpl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        socketImpl.wantConnect(z);
    }

    private final void wantConnect(boolean state) {
        interestOp(SelectInterest.CONNECT, state);
    }

    private final boolean inetSelfConnect() throws IOException {
        java.net.SocketAddress localSocketAddress;
        java.net.SocketAddress remoteSocketAddress;
        String hostAddress;
        InetAddress address;
        InetAddress address2;
        String hostAddress2;
        InetAddress address3;
        if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
            localSocketAddress = getChannel().getLocalAddress();
        } else {
            localSocketAddress = getChannel().socket().getLocalSocketAddress();
        }
        if (JavaSocketOptionsKt.getJava7NetworkApisAvailable()) {
            remoteSocketAddress = getChannel().getRemoteAddress();
        } else {
            remoteSocketAddress = getChannel().socket().getRemoteSocketAddress();
        }
        if (localSocketAddress == null || remoteSocketAddress == null) {
            throw new IllegalStateException("localAddress and remoteAddress should not be null.");
        }
        java.net.InetSocketAddress inetSocketAddress = localSocketAddress instanceof java.net.InetSocketAddress ? (java.net.InetSocketAddress) localSocketAddress : null;
        java.net.InetSocketAddress inetSocketAddress2 = remoteSocketAddress instanceof java.net.InetSocketAddress ? (java.net.InetSocketAddress) remoteSocketAddress : null;
        if (inetSocketAddress == null && inetSocketAddress2 == null) {
            return false;
        }
        String str = "";
        if (inetSocketAddress == null || (address3 = inetSocketAddress.getAddress()) == null || (hostAddress = address3.getHostAddress()) == null) {
            hostAddress = "";
        }
        if (inetSocketAddress2 != null && (address2 = inetSocketAddress2.getAddress()) != null && (hostAddress2 = address2.getHostAddress()) != null) {
            str = hostAddress2;
        }
        boolean zIsAnyLocalAddress = (inetSocketAddress2 == null || (address = inetSocketAddress2.getAddress()) == null) ? false : address.isAnyLocalAddress();
        if (Intrinsics.areEqual(inetSocketAddress != null ? Integer.valueOf(inetSocketAddress.getPort()) : null, inetSocketAddress2 != null ? Integer.valueOf(inetSocketAddress2.getPort()) : null)) {
            return zIsAnyLocalAddress || Intrinsics.areEqual(hostAddress, str);
        }
        return false;
    }
}
