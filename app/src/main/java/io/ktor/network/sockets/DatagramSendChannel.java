package io.ktor.network.sockets;

import androidx.compose.runtime.ComposerKt;
import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.facebook.appevents.integrity.IntegrityManager;
import io.ktor.network.util.PoolsKt;
import io.ktor.utils.io.core.ByteReadPacketKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* JADX INFO: compiled from: DatagramSendChannel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ4\u0010 \u001a\u00020\u00102#\u0010\u001f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\u001cH\u0017¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u000b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b/\u0010#\u001a\u0004\b-\u0010.R&\u00103\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lio/ktor/network/sockets/DatagramSendChannel;", "Lkotlinx/coroutines/channels/SendChannel;", "Lio/ktor/network/sockets/Datagram;", "Ljava/nio/channels/DatagramChannel;", "channel", "Lio/ktor/network/sockets/DatagramSocketImpl;", "socket", "<init>", "(Ljava/nio/channels/DatagramChannel;Lio/ktor/network/sockets/DatagramSocketImpl;)V", "", "cause", "", "close", "(Ljava/lang/Throwable;)Z", "element", "Lkotlinx/coroutines/channels/ChannelResult;", "", "trySend-JP2dKIU", "(Lio/ktor/network/sockets/Datagram;)Ljava/lang/Object;", "trySend", "send", "(Lio/ktor/network/sockets/Datagram;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/nio/ByteBuffer;", "buffer", "Lio/ktor/network/sockets/SocketAddress;", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "sendSuspend", "(Ljava/nio/ByteBuffer;Lio/ktor/network/sockets/SocketAddress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "closeAndCheckHandler", "()V", "Ljava/nio/channels/DatagramChannel;", "getChannel", "()Ljava/nio/channels/DatagramChannel;", "Lio/ktor/network/sockets/DatagramSocketImpl;", "getSocket", "()Lio/ktor/network/sockets/DatagramSocketImpl;", "Lkotlinx/coroutines/sync/Mutex;", "lock", "Lkotlinx/coroutines/sync/Mutex;", "isClosedForSend", "()Z", "isClosedForSend$annotations", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "ktor-network"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DatagramSendChannel implements SendChannel<Datagram> {
    private final DatagramChannel channel;
    private volatile /* synthetic */ int closed;
    private volatile /* synthetic */ Object closedCause;
    private final Mutex lock;
    private volatile /* synthetic */ Object onCloseHandler;
    private final DatagramSocketImpl socket;
    private static final /* synthetic */ AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(DatagramSendChannel.class, Object.class, "onCloseHandler");
    private static final /* synthetic */ AtomicIntegerFieldUpdater closed$FU = AtomicIntegerFieldUpdater.newUpdater(DatagramSendChannel.class, "closed");

    /* JADX INFO: renamed from: io.ktor.network.sockets.DatagramSendChannel$send$1, reason: invalid class name */
    /* JADX INFO: compiled from: DatagramSendChannel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.DatagramSendChannel", f = "DatagramSendChannel.kt", i = {0, 0, 1}, l = {ComposerKt.providerKey, 95}, m = "send", n = {"element", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
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
            return DatagramSendChannel.this.send2((Datagram) null, (Continuation<? super Unit>) this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DatagramSendChannel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.DatagramSendChannel", f = "DatagramSendChannel.kt", i = {0, 0}, l = {136}, m = "sendSuspend", n = {"buffer", IntegrityManager.INTEGRITY_TYPE_ADDRESS}, s = {"L$0", "L$1"})
    static final class C33161 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33161(Continuation<? super C33161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DatagramSendChannel.this.sendSuspend(null, null, this);
        }
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    public DatagramSendChannel(DatagramChannel channel, DatagramSocketImpl socket) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(socket, "socket");
        this.channel = channel;
        this.socket = socket;
        this.onCloseHandler = null;
        this.closed = 0;
        this.closedCause = null;
        this.lock = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(Datagram datagram) {
        return SendChannel.DefaultImpls.offer(this, datagram);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public /* bridge */ /* synthetic */ Object send(Datagram datagram, Continuation continuation) {
        return send2(datagram, (Continuation<? super Unit>) continuation);
    }

    public final DatagramChannel getChannel() {
        return this.channel;
    }

    public final DatagramSocketImpl getSocket() {
        return this.socket;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this.closed;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        if (!closed$FU.compareAndSet(this, 0, 1)) {
            return false;
        }
        this.closedCause = cause;
        if (!this.socket.isClosed()) {
            this.socket.close();
        }
        closeAndCheckHandler();
        return true;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* JADX INFO: renamed from: trySend-JP2dKIU, reason: avoid collision after fix types in other method and not valid java name and merged with bridge method [inline-methods] */
    public Object mo7333trySendJP2dKIU(Datagram element) {
        boolean z;
        Intrinsics.checkNotNullParameter(element, "element");
        if (!Mutex.DefaultImpls.tryLock$default(this.lock, null, 1, null)) {
            return ChannelResult.INSTANCE.m8965failurePtdJZtk();
        }
        try {
            long remaining = ByteReadPacketKt.getRemaining(element.getPacket());
            UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
            Buffer bufferField = element.getPacket().getBufferField();
            if (!(!bufferField.exhausted())) {
                throw new IllegalArgumentException("Buffer is empty".toString());
            }
            Segment head = bufferField.getHead();
            Intrinsics.checkNotNull(head);
            byte[] bArrDataAsByteArray = head.dataAsByteArray(true);
            int pos = head.getPos();
            ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(bArrDataAsByteArray, pos, head.getLimit() - pos).slice().asReadOnlyBuffer();
            Intrinsics.checkNotNull(byteBufferAsReadOnlyBuffer);
            if (byteBufferAsReadOnlyBuffer.remaining() < remaining) {
                z = true;
            } else {
                z = false;
                if (this.channel.send(byteBufferAsReadOnlyBuffer, JavaSocketAddressUtilsKt.toJavaAddress(element.getAddress())) == 0) {
                    byteBufferAsReadOnlyBuffer.position(byteBufferAsReadOnlyBuffer.limit());
                } else {
                    byteBufferAsReadOnlyBuffer.position(0);
                }
            }
            int iPosition = byteBufferAsReadOnlyBuffer.position();
            if (iPosition != 0) {
                if (iPosition < 0) {
                    throw new IllegalStateException("Returned negative read bytes count");
                }
                if (iPosition > head.getSize()) {
                    throw new IllegalStateException("Returned too many bytes");
                }
                bufferField.skip(iPosition);
            }
            if (z) {
                ObjectPool<ByteBuffer> defaultDatagramByteBufferPool = PoolsKt.getDefaultDatagramByteBufferPool();
                ByteBuffer byteBufferBorrow = defaultDatagramByteBufferPool.borrow();
                try {
                    ByteBuffer byteBuffer = byteBufferBorrow;
                    DatagramSendChannelKt.writeMessageTo(element.getPacket().peek(), byteBuffer);
                    if (this.channel.send(byteBuffer, JavaSocketAddressUtilsKt.toJavaAddress(element.getAddress())) == 0) {
                        ByteReadPacketKt.discard$default(element.getPacket(), 0L, 1, null);
                    }
                    Unit unit = Unit.INSTANCE;
                    defaultDatagramByteBufferPool.recycle(byteBufferBorrow);
                } catch (Throwable th) {
                    defaultDatagramByteBufferPool.recycle(byteBufferBorrow);
                    throw th;
                }
            }
            Mutex.DefaultImpls.unlock$default(this.lock, null, 1, null);
            return ChannelResult.INSTANCE.m8966successJP2dKIU(Unit.INSTANCE);
        } catch (Throwable th2) {
            Mutex.DefaultImpls.unlock$default(this.lock, null, 1, null);
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: send, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object send2(io.ktor.network.sockets.Datagram r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof io.ktor.network.sockets.DatagramSendChannel.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.network.sockets.DatagramSendChannel$send$1 r0 = (io.ktor.network.sockets.DatagramSendChannel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.network.sockets.DatagramSendChannel$send$1 r0 = new io.ktor.network.sockets.DatagramSendChannel$send$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L32
            goto L77
        L32:
            r9 = move-exception
            goto L83
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.L$0
            io.ktor.network.sockets.Datagram r2 = (io.ktor.network.sockets.Datagram) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r8
            r8 = r2
            goto L5c
        L4a:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.sync.Mutex r9 = r7.lock
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r2 = r9.lock(r5, r0)
            if (r2 != r1) goto L5c
            return r1
        L5c:
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Throwable -> L7f
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2     // Catch: java.lang.Throwable -> L7f
            io.ktor.network.sockets.DatagramSendChannel$send$2$1 r4 = new io.ktor.network.sockets.DatagramSendChannel$send$2$1     // Catch: java.lang.Throwable -> L7f
            r4.<init>(r8, r7, r5)     // Catch: java.lang.Throwable -> L7f
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L7f
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L7f
            r0.L$1 = r5     // Catch: java.lang.Throwable -> L7f
            r0.label = r3     // Catch: java.lang.Throwable -> L7f
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)     // Catch: java.lang.Throwable -> L7f
            if (r8 != r1) goto L76
            return r1
        L76:
            r8 = r9
        L77:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L32
            r8.unlock(r5)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L7f:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L83:
            r8.unlock(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSendChannel.send2(io.ktor.network.sockets.Datagram, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005d -> B:18:0x0060). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendSuspend(java.nio.ByteBuffer r7, io.ktor.network.sockets.SocketAddress r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.ktor.network.sockets.DatagramSendChannel.C33161
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1 r0 = (io.ktor.network.sockets.DatagramSendChannel.C33161) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1 r0 = new io.ktor.network.sockets.DatagramSendChannel$sendSuspend$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$1
            io.ktor.network.sockets.SocketAddress r7 = (io.ktor.network.sockets.SocketAddress) r7
            java.lang.Object r8 = r0.L$0
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L60
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.ResultKt.throwOnFailure(r9)
        L40:
            io.ktor.network.sockets.DatagramSocketImpl r9 = r6.socket
            io.ktor.network.selector.SelectInterest r2 = io.ktor.network.selector.SelectInterest.WRITE
            r9.interestOp(r2, r3)
            io.ktor.network.sockets.DatagramSocketImpl r9 = r6.socket
            io.ktor.network.selector.SelectorManager r9 = r9.getSelector()
            io.ktor.network.sockets.DatagramSocketImpl r2 = r6.socket
            io.ktor.network.selector.Selectable r2 = (io.ktor.network.selector.Selectable) r2
            io.ktor.network.selector.SelectInterest r4 = io.ktor.network.selector.SelectInterest.WRITE
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r9.select(r2, r4, r0)
            if (r9 != r1) goto L60
            return r1
        L60:
            java.nio.channels.DatagramChannel r9 = r6.channel
            java.net.SocketAddress r2 = io.ktor.network.sockets.JavaSocketAddressUtilsKt.toJavaAddress(r8)
            int r9 = r9.send(r7, r2)
            if (r9 == 0) goto L40
            io.ktor.network.sockets.DatagramSocketImpl r7 = r6.socket
            io.ktor.network.selector.SelectInterest r8 = io.ktor.network.selector.SelectInterest.WRITE
            r9 = 0
            r7.interestOp(r8, r9)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.DatagramSendChannel.sendSuspend(java.nio.ByteBuffer, io.ktor.network.sockets.SocketAddress, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<Datagram, SendChannel<Datagram>> getOnSend() {
        throw new NotImplementedError("An operation is not implemented: [DatagramSendChannel] doesn't support [onSend] select clause");
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = onCloseHandler$FU;
        if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, null, handler)) {
            return;
        }
        if (this.onCloseHandler == DatagramSendChannelKt.CLOSED) {
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, DatagramSendChannelKt.CLOSED, DatagramSendChannelKt.CLOSED_INVOKED)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            handler.invoke(this.closedCause);
            return;
        }
        DatagramSendChannelKt.failInvokeOnClose((Function1) this.onCloseHandler);
    }

    private final void closeAndCheckHandler() {
        do {
            Function1 function1 = (Function1) this.onCloseHandler;
            if (function1 == DatagramSendChannelKt.CLOSED_INVOKED) {
                return;
            }
            if (function1 != null) {
                if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(onCloseHandler$FU, this, function1, DatagramSendChannelKt.CLOSED_INVOKED)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                function1.invoke(this.closedCause);
                return;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(onCloseHandler$FU, this, null, DatagramSendChannelKt.CLOSED));
    }
}
