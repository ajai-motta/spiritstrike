package io.ktor.network.sockets;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import io.ktor.network.selector.SelectableBase;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelUtilsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.WriterJob;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: SocketBase.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0014\u0010\u0010J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u0013J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0016H ¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\nJ%\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\b0\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R#\u0010/\u001a\u00020,*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R%\u00102\u001a\u0004\u0018\u00010\u0016*\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010+0*8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lio/ktor/network/sockets/SocketBase;", "Lio/ktor/network/sockets/ReadWriteSocket;", "Lio/ktor/network/selector/SelectableBase;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "parent", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "", "dispose", "()V", "close", "Lio/ktor/utils/io/ByteChannel;", "channel", "Lio/ktor/utils/io/WriterJob;", "attachForReading", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ReaderJob;", "attachForWriting", "(Lio/ktor/utils/io/ByteChannel;)Lio/ktor/utils/io/ReaderJob;", "attachForReadingImpl", "attachForWritingImpl", "", "actualClose$ktor_network", "()Ljava/lang/Throwable;", "actualClose", "checkChannels", "e1", "e2", "combine", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/Function1;", "channelCompletionHandler", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/CompletableJob;", "socketContext", "Lkotlinx/coroutines/CompletableJob;", "getSocketContext", "()Lkotlinx/coroutines/CompletableJob;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlinx/atomicfu/AtomicRef;", "Lio/ktor/utils/io/ChannelJob;", "", "getCompletedOrNotStarted", "(Lkotlinx/atomicfu/AtomicRef;)Z", "completedOrNotStarted", "getException", "(Lkotlinx/atomicfu/AtomicRef;)Ljava/lang/Throwable;", "exception", "ktor-network"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SocketBase extends SelectableBase implements ReadWriteSocket, CoroutineScope {
    private volatile /* synthetic */ int actualCloseFlag;
    private final Function1<Throwable, Unit> channelCompletionHandler;
    private volatile /* synthetic */ int closeFlag;
    volatile /* synthetic */ Object readerJob;
    private final CompletableJob socketContext;
    volatile /* synthetic */ Object writerJob;
    private static final /* synthetic */ AtomicIntegerFieldUpdater closeFlag$FU = AtomicIntegerFieldUpdater.newUpdater(SocketBase.class, "closeFlag");
    private static final /* synthetic */ AtomicIntegerFieldUpdater actualCloseFlag$FU = AtomicIntegerFieldUpdater.newUpdater(SocketBase.class, "actualCloseFlag");
    static final /* synthetic */ AtomicReferenceFieldUpdater readerJob$FU = AtomicReferenceFieldUpdater.newUpdater(SocketBase.class, Object.class, "readerJob");
    static final /* synthetic */ AtomicReferenceFieldUpdater writerJob$FU = AtomicReferenceFieldUpdater.newUpdater(SocketBase.class, Object.class, "writerJob");

    public abstract Throwable actualClose$ktor_network();

    public abstract WriterJob attachForReadingImpl(ByteChannel channel);

    public abstract ReaderJob attachForWritingImpl(ByteChannel channel);

    public SocketBase(CoroutineContext parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.closeFlag = 0;
        this.actualCloseFlag = 0;
        this.readerJob = null;
        this.writerJob = null;
        this.channelCompletionHandler = new Function1() { // from class: io.ktor.network.sockets.SocketBase$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SocketBase.channelCompletionHandler$lambda$0(this.f$0, (Throwable) obj);
            }
        };
        this.socketContext = JobKt.Job((Job) parent.get(Job.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit channelCompletionHandler$lambda$0(SocketBase socketBase, Throwable th) {
        socketBase.checkChannels();
        return Unit.INSTANCE;
    }

    @Override // io.ktor.network.sockets.ASocket
    public CompletableJob getSocketContext() {
        return this.socketContext;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return getSocketContext();
    }

    @Override // kotlinx.coroutines.DisposableHandle
    public void dispose() {
        close();
    }

    @Override // io.ktor.network.selector.SelectableBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (closeFlag$FU.compareAndSet(this, 0, 1)) {
            BuildersKt__Builders_commonKt.launch$default(this, new CoroutineName("socket-close"), null, new AnonymousClass1(null), 2, null);
        }
    }

    /* JADX INFO: renamed from: io.ktor.network.sockets.SocketBase$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: SocketBase.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.SocketBase$close$1", f = "SocketBase.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SocketBase.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ReaderJob readerJob = (ReaderJob) SocketBase.this.readerJob;
                if (readerJob != null) {
                    this.label = 1;
                    if (readerJob.flushAndClose(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            WriterJob writerJob = (WriterJob) SocketBase.this.writerJob;
            if (writerJob != null) {
                ByteWriteChannelOperationsKt.cancel(writerJob);
            }
            SocketBase.this.checkChannels();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void checkChannels() {
        /*
            r4 = this;
            int r0 = r4.closeFlag
            if (r0 == 0) goto L7b
            java.lang.Object r0 = r4.readerJob
            io.ktor.utils.io.ChannelJob r0 = (io.ktor.utils.io.ChannelJob) r0
            if (r0 == 0) goto L10
            boolean r0 = io.ktor.utils.io.ByteWriteChannelOperationsKt.isCompleted(r0)
            if (r0 == 0) goto L7b
        L10:
            java.lang.Object r0 = r4.writerJob
            io.ktor.utils.io.ChannelJob r0 = (io.ktor.utils.io.ChannelJob) r0
            if (r0 == 0) goto L1c
            boolean r0 = io.ktor.utils.io.ByteWriteChannelOperationsKt.isCompleted(r0)
            if (r0 == 0) goto L7b
        L1c:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = io.ktor.network.sockets.SocketBase.actualCloseFlag$FU
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r4, r1, r2)
            if (r0 != 0) goto L27
            return
        L27:
            java.lang.Object r0 = r4.readerJob
            io.ktor.utils.io.ChannelJob r0 = (io.ktor.utils.io.ChannelJob) r0
            r1 = 0
            if (r0 == 0) goto L43
            boolean r2 = io.ktor.utils.io.ByteWriteChannelOperationsKt.isCancelled(r0)
            if (r2 == 0) goto L35
            goto L36
        L35:
            r0 = r1
        L36:
            if (r0 == 0) goto L43
            java.util.concurrent.CancellationException r0 = io.ktor.utils.io.ByteWriteChannelOperationsKt.getCancellationException(r0)
            if (r0 == 0) goto L43
            java.lang.Throwable r0 = r0.getCause()
            goto L44
        L43:
            r0 = r1
        L44:
            java.lang.Object r2 = r4.writerJob
            io.ktor.utils.io.ChannelJob r2 = (io.ktor.utils.io.ChannelJob) r2
            if (r2 == 0) goto L5e
            boolean r3 = io.ktor.utils.io.ByteWriteChannelOperationsKt.isCancelled(r2)
            if (r3 == 0) goto L51
            goto L52
        L51:
            r2 = r1
        L52:
            if (r2 == 0) goto L5e
            java.util.concurrent.CancellationException r2 = io.ktor.utils.io.ByteWriteChannelOperationsKt.getCancellationException(r2)
            if (r2 == 0) goto L5e
            java.lang.Throwable r1 = r2.getCause()
        L5e:
            java.lang.Throwable r2 = r4.actualClose$ktor_network()
            java.lang.Throwable r0 = r4.combine(r0, r1)
            java.lang.Throwable r0 = r4.combine(r0, r2)
            if (r0 != 0) goto L74
            kotlinx.coroutines.CompletableJob r0 = r4.getSocketContext()
            r0.complete()
            goto L7b
        L74:
            kotlinx.coroutines.CompletableJob r1 = r4.getSocketContext()
            r1.completeExceptionally(r0)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.SocketBase.checkChannels():void");
    }

    private final Throwable combine(Throwable e1, Throwable e2) {
        if (e1 == null) {
            return e2;
        }
        if (e2 == null || e1 == e2) {
            return e1;
        }
        ExceptionsKt.addSuppressed(e1, e2);
        return e1;
    }

    @Override // io.ktor.network.sockets.AReadable
    public final WriterJob attachForReading(ByteChannel channel) throws IOException {
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (this.closeFlag == 0) {
            WriterJob writerJobAttachForReadingImpl = attachForReadingImpl(channel);
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(writerJob$FU, this, null, writerJobAttachForReadingImpl)) {
                IllegalStateException illegalStateException = new IllegalStateException("reading channel has already been set");
                ByteWriteChannelOperationsKt.cancel(writerJobAttachForReadingImpl);
                throw illegalStateException;
            }
            if (this.closeFlag != 0) {
                IOException iOException = new IOException("Socket closed");
                ByteWriteChannelOperationsKt.cancel(writerJobAttachForReadingImpl);
                ByteWriteChannelOperationsKt.close(channel, iOException);
                throw iOException;
            }
            ByteChannelUtilsKt.attachJob(channel, writerJobAttachForReadingImpl);
            ByteWriteChannelOperationsKt.invokeOnCompletion(writerJobAttachForReadingImpl, this.channelCompletionHandler);
            return writerJobAttachForReadingImpl;
        }
        IOException iOException2 = new IOException("Socket closed");
        ByteWriteChannelOperationsKt.close(channel, iOException2);
        throw iOException2;
    }

    @Override // io.ktor.network.sockets.AWritable
    public final ReaderJob attachForWriting(ByteChannel channel) throws IOException {
        Intrinsics.checkNotNullParameter(channel, "channel");
        if (this.closeFlag == 0) {
            ReaderJob readerJobAttachForWritingImpl = attachForWritingImpl(channel);
            if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(readerJob$FU, this, null, readerJobAttachForWritingImpl)) {
                IllegalStateException illegalStateException = new IllegalStateException("writing channel has already been set");
                ByteWriteChannelOperationsKt.cancel(readerJobAttachForWritingImpl);
                throw illegalStateException;
            }
            if (this.closeFlag != 0) {
                IOException iOException = new IOException("Socket closed");
                ByteWriteChannelOperationsKt.cancel(readerJobAttachForWritingImpl);
                ByteWriteChannelOperationsKt.close(channel, iOException);
                throw iOException;
            }
            ByteChannelUtilsKt.attachJob(channel, readerJobAttachForWritingImpl);
            ByteWriteChannelOperationsKt.invokeOnCompletion(readerJobAttachForWritingImpl, this.channelCompletionHandler);
            return readerJobAttachForWritingImpl;
        }
        IOException iOException2 = new IOException("Socket closed");
        ByteWriteChannelOperationsKt.close(channel, iOException2);
        throw iOException2;
    }
}
