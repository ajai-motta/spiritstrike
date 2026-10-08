package io.ktor.network.sockets;

import io.ktor.network.selector.Selectable;
import io.ktor.network.selector.SelectorManager;
import io.ktor.network.sockets.SocketOptions;
import io.ktor.network.util.Timeout;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.ReaderScope;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: CIOWriter.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a?\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteChannel;", "channel", "Ljava/nio/channels/WritableByteChannel;", "nioChannel", "Lio/ktor/network/selector/Selectable;", "selectable", "Lio/ktor/network/selector/SelectorManager;", "selector", "Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;", "socketOptions", "Lio/ktor/utils/io/ReaderJob;", "attachForWritingDirectImpl", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteChannel;Ljava/nio/channels/WritableByteChannel;Lio/ktor/network/selector/Selectable;Lio/ktor/network/selector/SelectorManager;Lio/ktor/network/sockets/SocketOptions$TCPClientSocketOptions;)Lio/ktor/utils/io/ReaderJob;", "ktor-network"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CIOWriterKt {
    public static /* synthetic */ ReaderJob attachForWritingDirectImpl$default(CoroutineScope coroutineScope, ByteChannel byteChannel, WritableByteChannel writableByteChannel, Selectable selectable, SelectorManager selectorManager, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, int i, Object obj) {
        if ((i & 16) != 0) {
            tCPClientSocketOptions = null;
        }
        return attachForWritingDirectImpl(coroutineScope, byteChannel, writableByteChannel, selectable, selectorManager, tCPClientSocketOptions);
    }

    /* JADX INFO: renamed from: io.ktor.network.sockets.CIOWriterKt$attachForWritingDirectImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: CIOWriter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.network.sockets.CIOWriterKt$attachForWritingDirectImpl$1", f = "CIOWriter.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3}, l = {33, 75, 79, 50}, m = "invokeSuspend", n = {"timeout", "timeout", "rc", "$this$read_u24default$iv", "consumer$iv", "min$iv", "timeout", "rc", "$this$read_u24default$iv", "consumer$iv", "timeout"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ReaderScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteChannel $channel;
        final /* synthetic */ WritableByteChannel $nioChannel;
        final /* synthetic */ Selectable $selectable;
        final /* synthetic */ SelectorManager $selector;
        final /* synthetic */ SocketOptions.TCPClientSocketOptions $socketOptions;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Selectable selectable, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions, ByteChannel byteChannel, SelectorManager selectorManager, WritableByteChannel writableByteChannel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$selectable = selectable;
            this.$socketOptions = tCPClientSocketOptions;
            this.$channel = byteChannel;
            this.$selector = selectorManager;
            this.$nioChannel = writableByteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$selectable, this.$socketOptions, this.$channel, this.$selector, this.$nioChannel, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ReaderScope readerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00b7 A[Catch: all -> 0x018f, TryCatch #2 {all -> 0x018f, blocks: (B:10:0x001c, B:32:0x00af, B:34:0x00b7, B:36:0x00c1, B:39:0x00d9, B:43:0x0103, B:45:0x010b, B:46:0x0114, B:48:0x0118, B:51:0x0139, B:52:0x0160, B:54:0x0163, B:15:0x0039, B:17:0x0046, B:20:0x0062, B:24:0x007f, B:26:0x0083, B:29:0x008f), top: B:79:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:45:0x010b A[Catch: all -> 0x018f, TryCatch #2 {all -> 0x018f, blocks: (B:10:0x001c, B:32:0x00af, B:34:0x00b7, B:36:0x00c1, B:39:0x00d9, B:43:0x0103, B:45:0x010b, B:46:0x0114, B:48:0x0118, B:51:0x0139, B:52:0x0160, B:54:0x0163, B:15:0x0039, B:17:0x0046, B:20:0x0062, B:24:0x007f, B:26:0x0083, B:29:0x008f), top: B:79:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0118 A[Catch: all -> 0x018f, TryCatch #2 {all -> 0x018f, blocks: (B:10:0x001c, B:32:0x00af, B:34:0x00b7, B:36:0x00c1, B:39:0x00d9, B:43:0x0103, B:45:0x010b, B:46:0x0114, B:48:0x0118, B:51:0x0139, B:52:0x0160, B:54:0x0163, B:15:0x0039, B:17:0x0046, B:20:0x0062, B:24:0x007f, B:26:0x0083, B:29:0x008f), top: B:79:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0139 A[Catch: all -> 0x018f, TryCatch #2 {all -> 0x018f, blocks: (B:10:0x001c, B:32:0x00af, B:34:0x00b7, B:36:0x00c1, B:39:0x00d9, B:43:0x0103, B:45:0x010b, B:46:0x0114, B:48:0x0118, B:51:0x0139, B:52:0x0160, B:54:0x0163, B:15:0x0039, B:17:0x0046, B:20:0x0062, B:24:0x007f, B:26:0x0083, B:29:0x008f), top: B:79:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0163 A[Catch: all -> 0x018f, TRY_LEAVE, TryCatch #2 {all -> 0x018f, blocks: (B:10:0x001c, B:32:0x00af, B:34:0x00b7, B:36:0x00c1, B:39:0x00d9, B:43:0x0103, B:45:0x010b, B:46:0x0114, B:48:0x0118, B:51:0x0139, B:52:0x0160, B:54:0x0163, B:15:0x0039, B:17:0x0046, B:20:0x0062, B:24:0x007f, B:26:0x0083, B:29:0x008f), top: B:79:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0116 -> B:32:0x00af). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0136 -> B:32:0x00af). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 439
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.network.sockets.CIOWriterKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(Timeout timeout, Ref.IntRef intRef, WritableByteChannel writableByteChannel, ByteBuffer byteBuffer) {
            while (byteBuffer.hasRemaining()) {
                if (timeout == null) {
                    do {
                        intRef.element = writableByteChannel.write(byteBuffer);
                        if (byteBuffer.hasRemaining()) {
                        }
                    } while (intRef.element > 0);
                } else {
                    timeout.start();
                    do {
                        try {
                            intRef.element = writableByteChannel.write(byteBuffer);
                            if (!byteBuffer.hasRemaining()) {
                                break;
                            }
                        } finally {
                            timeout.stop();
                        }
                    } while (intRef.element > 0);
                    Unit unit = Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final ReaderJob attachForWritingDirectImpl(CoroutineScope coroutineScope, ByteChannel channel, WritableByteChannel nioChannel, Selectable selectable, SelectorManager selector, SocketOptions.TCPClientSocketOptions tCPClientSocketOptions) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(nioChannel, "nioChannel");
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return ByteReadChannelOperationsKt.reader(coroutineScope, Dispatchers.getIO().plus(new CoroutineName("cio-to-nio-writer")), channel, new AnonymousClass1(selectable, tCPClientSocketOptions, channel, selector, nioChannel, null));
    }
}
