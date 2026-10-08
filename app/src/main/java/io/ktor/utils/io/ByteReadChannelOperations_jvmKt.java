package io.ktor.utils.io;

import androidx.compose.runtime.ComposerKt;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.BytePacketBuilderExtensions_jvmKt;
import io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* JADX INFO: compiled from: ByteReadChannelOperations.jvm.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a&\u0010\u0010\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0014\u0010\b\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001c\u0010\u0016\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0016\u0010\b\u001a%\u0010\u0007\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0017¢\u0006\u0004\b\u0007\u0010\u0019\u001a4\u0010\u001c\u001a\u00020\u0013*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00062\u0014\b\b\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00130\u0017H\u0086H¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ljava/nio/ByteBuffer;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "ByteReadChannel", "(Ljava/nio/ByteBuffer;)Lio/ktor/utils/io/ByteReadChannel;", "buffer", "", "readAvailable", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/bytestring/ByteString;", "ByteString", "(Ljava/nio/ByteBuffer;)Lkotlinx/io/bytestring/ByteString;", "Ljava/nio/channels/WritableByteChannel;", "channel", "", "limit", "copyTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/nio/channels/WritableByteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", TtmlNode.RUBY_DELIMITER, "", "skipDelimiter", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFully", "Lkotlin/Function1;", "block", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function1;)I", "min", "consumer", "read", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ByteReadChannelOperations_jvmKt {

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$copyTo$1, reason: invalid class name */
    /* JADX INFO: compiled from: ByteReadChannelOperations.jvm.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {211, 215}, m = "copyTo", n = {"$this$copyTo", "copied", "copy", "$this$read$iv", "limit", "min$iv", "$this$copyTo", "copied", "copy", "$this$read$iv", "limit"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$read$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.jvm.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", i = {0, 0, 0, 1, 1}, l = {198, ComposerKt.compositionLocalMapKey}, m = "read", n = {"$this$read", "consumer", "min", "$this$read", "consumer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1"})
    static final class C33541 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33541(Continuation<? super C33541> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.read(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readAvailable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.jvm.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", i = {0, 0}, l = {40}, m = "readAvailable", n = {"$this$readAvailable", "buffer"}, s = {"L$0", "L$1"})
    static final class C33551 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33551(Continuation<? super C33551> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.readAvailable(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.jvm.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", i = {0, 0}, l = {TsExtractor.TS_STREAM_TYPE_HDMV_DTS}, m = "readFully", n = {"$this$readFully", "buffer"}, s = {"L$0", "L$1"})
    static final class C33561 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33561(Continuation<? super C33561> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.readFully(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2, reason: invalid class name */
    /* JADX INFO: compiled from: ByteReadChannelOperations.jvm.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperations_jvmKt", f = "ByteReadChannelOperations.jvm.kt", i = {0, 0, 0}, l = {114}, m = "skipDelimiter", n = {"$this$skipDelimiter", TtmlNode.RUBY_DELIMITER, "i"}, s = {"L$0", "L$1", "I$0"})
    static final class AnonymousClass2 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperations_jvmKt.skipDelimiter((ByteReadChannel) null, (ByteString) null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readAvailable(io.ktor.utils.io.ByteReadChannel r6, java.nio.ByteBuffer r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C33551
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readAvailable$1 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C33551) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readAvailable$1 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readAvailable$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = -1
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 != r4) goto L36
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r7 = (io.ktor.utils.io.ByteReadChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r7
            r7 = r6
            r6 = r5
            goto L65
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r6.isClosedForRead()
            if (r8 == 0) goto L4c
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            return r6
        L4c:
            kotlinx.io.Source r8 = r6.getReadBuffer()
            boolean r8 = r8.exhausted()
            if (r8 == 0) goto L65
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            r8 = 0
            r2 = 0
            java.lang.Object r8 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r6, r8, r0, r4, r2)
            if (r8 != r1) goto L65
            return r1
        L65:
            boolean r8 = r6.isClosedForRead()
            if (r8 == 0) goto L70
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            return r6
        L70:
            kotlinx.io.Source r6 = r6.getReadBuffer()
            int r6 = kotlinx.io.SourcesJvmKt.readAtMostTo(r6, r7)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.readAvailable(io.ktor.utils.io.ByteReadChannel, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final ByteString ByteString(ByteBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        byte[] bArr = new byte[buffer.remaining()];
        buffer.mark();
        buffer.get(bArr);
        buffer.reset();
        return new ByteString(bArr, 0, 0, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00f3 -> B:45:0x00fa). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r9, final java.nio.channels.WritableByteChannel r10, final long r11, kotlin.coroutines.Continuation<? super java.lang.Long> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.copyTo(io.ktor.utils.io.ByteReadChannel, java.nio.channels.WritableByteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object copyTo$default(ByteReadChannel byteReadChannel, WritableByteChannel writableByteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = Long.MAX_VALUE;
        }
        return copyTo(byteReadChannel, writableByteChannel, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit copyTo$lambda$3(long j, Ref.LongRef longRef, WritableByteChannel writableByteChannel, ByteBuffer bb) throws IOException {
        Intrinsics.checkNotNullParameter(bb, "bb");
        long j2 = j - longRef.element;
        if (j2 < bb.remaining()) {
            int iLimit = bb.limit();
            bb.limit(bb.position() + ((int) j2));
            while (bb.hasRemaining()) {
                writableByteChannel.write(bb);
            }
            bb.limit(iLimit);
            longRef.element += j2;
        } else {
            long jWrite = 0;
            while (bb.hasRemaining()) {
                jWrite += (long) writableByteChannel.write(bb);
            }
            longRef.element += jWrite;
        }
        return Unit.INSTANCE;
    }

    public static final Object skipDelimiter(ByteReadChannel byteReadChannel, ByteBuffer byteBuffer, Continuation<? super Unit> continuation) throws Throwable {
        Object objSkipDelimiter = skipDelimiter(byteReadChannel, ByteString(byteBuffer), continuation);
        return objSkipDelimiter == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSkipDelimiter : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:20:0x0062). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object skipDelimiter(io.ktor.utils.io.ByteReadChannel r7, kotlinx.io.bytestring.ByteString r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$skipDelimiter$2
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlinx.io.bytestring.ByteString r2 = (kotlinx.io.bytestring.ByteString) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r9)
            goto L62
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            kotlin.ResultKt.throwOnFailure(r9)
            int r9 = r8.getSize()
            r2 = 0
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
        L4a:
            if (r2 >= r7) goto L7c
            r0.L$0 = r8
            r0.L$1 = r9
            r0.I$0 = r2
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r4 = io.ktor.utils.io.ByteReadChannelOperationsKt.readByte(r8, r0)
            if (r4 != r1) goto L5d
            return r1
        L5d:
            r6 = r4
            r4 = r8
            r8 = r2
            r2 = r9
            r9 = r6
        L62:
            java.lang.Number r9 = (java.lang.Number) r9
            byte r9 = r9.byteValue()
            byte r5 = r2.get(r8)
            if (r9 != r5) goto L74
            int r8 = r8 + 1
            r9 = r2
            r2 = r8
            r8 = r4
            goto L4a
        L74:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Delimiter is not found"
            r7.<init>(r8)
            throw r7
        L7c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.skipDelimiter(io.ktor.utils.io.ByteReadChannel, kotlinx.io.bytestring.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0052 -> B:20:0x0055). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readFully(io.ktor.utils.io.ByteReadChannel r5, java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C33561
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C33561) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$readFully$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$1
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r6 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L55
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
        L40:
            boolean r7 = r6.hasRemaining()
            if (r7 == 0) goto L82
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            r7 = 0
            r2 = 0
            java.lang.Object r7 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r5, r7, r0, r3, r2)
            if (r7 != r1) goto L55
            return r1
        L55:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L65
            kotlinx.io.Source r7 = r5.getReadBuffer()
            kotlinx.io.SourcesJvmKt.readAtMostTo(r7, r6)
            goto L40
        L65:
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Not enough bytes available: expected "
            r7.<init>(r0)
            int r6 = r6.remaining()
            r7.append(r6)
            java.lang.String r6 = " more bytes"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            r5.<init>(r6)
            throw r5
        L82:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.readFully(io.ktor.utils.io.ByteReadChannel, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final int readAvailable(ByteReadChannel byteReadChannel, Function1<? super ByteBuffer, Integer> block) throws EOFException {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (byteReadChannel.isClosedForRead() || byteReadChannel.getReadBuffer().exhausted()) {
            return -1;
        }
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer bufferField = byteReadChannel.getReadBuffer().getBufferField();
        if (!(!bufferField.exhausted())) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head = bufferField.getHead();
        Intrinsics.checkNotNull(head);
        byte[] bArrDataAsByteArray = head.dataAsByteArray(true);
        int pos = head.getPos();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArrDataAsByteArray, pos, head.getLimit() - pos);
        Intrinsics.checkNotNull(byteBufferWrap);
        int iIntValue = block.invoke(byteBufferWrap).intValue();
        if (iIntValue != 0) {
            if (iIntValue < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (iIntValue > head.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            bufferField.skip(iIntValue);
        }
        return iIntValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object read(io.ktor.utils.io.ByteReadChannel r5, int r6, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C33541
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$read$1 r0 = (io.ktor.utils.io.ByteReadChannelOperations_jvmKt.C33541) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperations_jvmKt$read$1 r0 = new io.ktor.utils.io.ByteReadChannelOperations_jvmKt$read$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$1
            r7 = r5
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto La7
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r7 = r5
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L63
        L4d:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r6 < 0) goto Lb9
            if (r6 <= 0) goto L98
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.awaitContent(r6, r0)
            if (r8 != r1) goto L63
            return r1
        L63:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L73
            kotlinx.io.Source r5 = r5.getReadBuffer()
            io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt.read(r5, r7)
            goto Lb6
        L73:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Not enough bytes available: required "
            r8.<init>(r0)
            r8.append(r6)
            java.lang.String r6 = " but "
            r8.append(r6)
            int r5 = io.ktor.utils.io.ByteReadChannelOperationsKt.getAvailableForRead(r5)
            r8.append(r5)
            java.lang.String r5 = " available"
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r7.<init>(r5)
            throw r7
        L98:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.label = r3
            r6 = 0
            r8 = 0
            java.lang.Object r8 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r5, r6, r0, r4, r8)
            if (r8 != r1) goto La7
            return r1
        La7:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r6 = r8.booleanValue()
            if (r6 == 0) goto Lb6
            kotlinx.io.Source r5 = r5.getReadBuffer()
            io.ktor.utils.io.core.ByteReadPacketExtensions_jvmKt.read(r5, r7)
        Lb6:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        Lb9:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "min should be positive or zero"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperations_jvmKt.read(io.ktor.utils.io.ByteReadChannel, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) throws EOFException {
        if (i < 0) {
            throw new IllegalArgumentException("min should be positive or zero".toString());
        }
        if (i > 0) {
            InlineMarker.mark(0);
            Object objAwaitContent = byteReadChannel.awaitContent(i, continuation);
            InlineMarker.mark(1);
            if (!((Boolean) objAwaitContent).booleanValue()) {
                throw new EOFException("Not enough bytes available: required " + i + " but " + ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel) + " available");
            }
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
        } else {
            InlineMarker.mark(0);
            Object objAwaitContent$default = ByteReadChannel.DefaultImpls.awaitContent$default(byteReadChannel, 0, continuation, 1, null);
            InlineMarker.mark(1);
            if (((Boolean) objAwaitContent$default).booleanValue()) {
                ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
            }
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object read$default(ByteReadChannel byteReadChannel, int i, Function1 function1, Continuation continuation, int i2, Object obj) throws EOFException {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if (i < 0) {
            throw new IllegalArgumentException("min should be positive or zero".toString());
        }
        if (i > 0) {
            InlineMarker.mark(0);
            Object objAwaitContent = byteReadChannel.awaitContent(i, continuation);
            InlineMarker.mark(1);
            if (!((Boolean) objAwaitContent).booleanValue()) {
                throw new EOFException("Not enough bytes available: required " + i + " but " + ByteReadChannelOperationsKt.getAvailableForRead(byteReadChannel) + " available");
            }
            ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
        } else {
            InlineMarker.mark(0);
            Object objAwaitContent$default = ByteReadChannel.DefaultImpls.awaitContent$default(byteReadChannel, 0, continuation, 1, null);
            InlineMarker.mark(1);
            if (((Boolean) objAwaitContent$default).booleanValue()) {
                ByteReadPacketExtensions_jvmKt.read(byteReadChannel.getReadBuffer(), function1);
            }
        }
        return Unit.INSTANCE;
    }

    public static final ByteReadChannel ByteReadChannel(ByteBuffer content) {
        Intrinsics.checkNotNullParameter(content, "content");
        Buffer buffer = new Buffer();
        BytePacketBuilderExtensions_jvmKt.writeFully(buffer, content);
        return ByteChannelCtorKt.ByteReadChannel(buffer);
    }
}
