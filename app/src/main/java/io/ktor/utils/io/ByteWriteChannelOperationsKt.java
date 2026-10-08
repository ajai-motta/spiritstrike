package io.ktor.utils.io;

import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.io.Buffer;
import kotlinx.io.CoreKt;
import kotlinx.io.RawSource;
import kotlinx.io.Sink;
import kotlinx.io.SinksKt;
import kotlinx.io.Source;

/* JADX INFO: compiled from: ByteWriteChannelOperations.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Ý\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0004*\u0001^\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\fH\u0086@¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0010\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000fH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u001b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001e\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b\u001e\u0010\u001f\u001a0\u0010\"\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00152\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\tH\u0086@¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010%\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020$H\u0086@¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010'\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001dH\u0086@¢\u0006\u0004\b'\u0010\u001f\u001a\u001c\u0010*\u001a\u00020\u0003*\u00020\u00002\u0006\u0010)\u001a\u00020(H\u0086@¢\u0006\u0004\b*\u0010+\u001a\u001c\u0010*\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b*\u0010\u001c\u001a\u001b\u0010.\u001a\u00020\u0003*\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/\u001a\u0014\u00101\u001a\u00020\u0003*\u000200H\u0086@¢\u0006\u0004\b1\u00102\u001a\u0015\u00105\u001a\u000603j\u0002`4*\u000200¢\u0006\u0004\b5\u00106\u001a6\u0010<\u001a\u00020;*\u0002002#\u0010:\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010,¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020\u000307¢\u0006\u0004\b<\u0010=\u001a!\u0010<\u001a\u00020\u0003*\u0002002\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00030>H\u0007¢\u0006\u0004\b<\u0010?\u001a\u0011\u0010@\u001a\u00020\u0003*\u000200¢\u0006\u0004\b@\u0010A\u001aN\u0010M\u001a\u00020L*\u00020B2\b\b\u0002\u0010D\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020E2'\u0010:\u001a#\b\u0001\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030I\u0012\u0006\u0012\u0004\u0018\u00010J0G¢\u0006\u0002\bK¢\u0006\u0004\bM\u0010N\u001aL\u0010M\u001a\u00020L*\u00020B2\b\b\u0002\u0010D\u001a\u00020C2\u0006\u0010P\u001a\u00020O2'\u0010:\u001a#\b\u0001\u0012\u0004\u0012\u00020H\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030I\u0012\u0006\u0012\u0004\u0018\u00010J0G¢\u0006\u0002\bK¢\u0006\u0004\bM\u0010Q\u001a>\u0010T\u001a\u00020\t*\u00020\u00002\b\b\u0002\u0010R\u001a\u00020\t2\u001e\u0010:\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0SH\u0086@¢\u0006\u0004\bT\u0010U\u001a\u0014\u0010V\u001a\u00020\u0003*\u00020\u0000H\u0086@¢\u0006\u0004\bV\u0010W\u001a/\u0010Y\u001a\u00020\u0003\"\u0004\b\u0000\u0010X*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000I\u0012\u0006\u0012\u0004\u0018\u00010J07H\u0000¢\u0006\u0004\bY\u0010Z\"\u0015\u0010[\u001a\u00020E*\u0002008F¢\u0006\u0006\u001a\u0004\b[\u0010\\\"\u0015\u0010]\u001a\u00020E*\u0002008F¢\u0006\u0006\u001a\u0004\b]\u0010\\\"\u0014\u0010_\u001a\u00020^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`¨\u0006a"}, d2 = {"Lio/ktor/utils/io/ByteWriteChannel;", "", "value", "", "writeByte", "(Lio/ktor/utils/io/ByteWriteChannel;BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeShort", "(Lio/ktor/utils/io/ByteWriteChannel;SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeInt", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeFloat", "(Lio/ktor/utils/io/ByteWriteChannel;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeDouble", "(Lio/ktor/utils/io/ByteWriteChannel;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeLong", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "array", "writeByteArray", "(Lio/ktor/utils/io/ByteWriteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Source;", "source", "writeSource", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/Source;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "writeString", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startIndex", "endIndex", "writeFully", "(Lio/ktor/utils/io/ByteWriteChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/RawSource;", "writeBuffer", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/RawSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeStringUtf8", "Lkotlinx/io/Buffer;", "copy", "writePacket", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlinx/io/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cause", "close", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/Throwable;)V", "Lio/ktor/utils/io/ChannelJob;", "join", "(Lio/ktor/utils/io/ChannelJob;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lio/ktor/utils/io/CancellationException;", "getCancellationException", "(Lio/ktor/utils/io/ChannelJob;)Ljava/util/concurrent/CancellationException;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "block", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(Lio/ktor/utils/io/ChannelJob;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlin/Function0;", "(Lio/ktor/utils/io/ChannelJob;Lkotlin/jvm/functions/Function0;)V", "cancel", "(Lio/ktor/utils/io/ChannelJob;)V", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "", "autoFlush", "Lkotlin/Function2;", "Lio/ktor/utils/io/WriterScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Lio/ktor/utils/io/WriterJob;", "writer", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteChannel;", "channel", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteChannel;Lkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/WriterJob;", "desiredSpace", "Lkotlin/Function3;", "write", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFreeSpace", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "fireAndForget", "(Lkotlin/jvm/functions/Function1;)V", "isCompleted", "(Lio/ktor/utils/io/ChannelJob;)Z", "isCancelled", "io/ktor/utils/io/ByteWriteChannelOperationsKt$NO_CALLBACK$1", "NO_CALLBACK", "Lio/ktor/utils/io/ByteWriteChannelOperationsKt$NO_CALLBACK$1;", "ktor-io"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ByteWriteChannelOperationsKt {
    private static final ByteWriteChannelOperationsKt$NO_CALLBACK$1 NO_CALLBACK = new Continuation<Object>() { // from class: io.ktor.utils.io.ByteWriteChannelOperationsKt$NO_CALLBACK$1
        private final CoroutineContext context = EmptyCoroutineContext.INSTANCE;

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.context;
        }
    };

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelOperationsKt$write$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteWriteChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt", f = "ByteWriteChannelOperations.kt", i = {0}, l = {224}, m = "write", n = {"written"}, s = {"I$0"})
    static final class C33571 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C33571(Continuation<? super C33571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteWriteChannelOperationsKt.write(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelOperationsKt$writePacket$2, reason: invalid class name */
    /* JADX INFO: compiled from: ByteWriteChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelOperationsKt", f = "ByteWriteChannelOperations.kt", i = {0, 0}, l = {116}, m = "writePacket", n = {"$this$writePacket", "source"}, s = {"L$0", "L$1"})
    static final class AnonymousClass2 extends ContinuationImpl {
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
            return ByteWriteChannelOperationsKt.writePacket((ByteWriteChannel) null, (Source) null, this);
        }
    }

    public static final Object writeByte(ByteWriteChannel byteWriteChannel, byte b, Continuation<? super Unit> continuation) {
        byteWriteChannel.getWriteBuffer().writeByte(b);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, short s, Continuation<? super Unit> continuation) {
        byteWriteChannel.getWriteBuffer().writeShort(s);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        byteWriteChannel.getWriteBuffer().writeInt(i);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeFloat(ByteWriteChannel byteWriteChannel, float f, Continuation<? super Unit> continuation) {
        SinksKt.writeFloat(byteWriteChannel.getWriteBuffer(), f);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeDouble(ByteWriteChannel byteWriteChannel, double d, Continuation<? super Unit> continuation) {
        SinksKt.writeDouble(byteWriteChannel.getWriteBuffer(), d);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeLong(ByteWriteChannel byteWriteChannel, long j, Continuation<? super Unit> continuation) {
        byteWriteChannel.getWriteBuffer().writeLong(j);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeByteArray(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        Sink.CC.write$default(byteWriteChannel.getWriteBuffer(), bArr, 0, 0, 6, null);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeSource(ByteWriteChannel byteWriteChannel, Source source, Continuation<? super Unit> continuation) throws Throwable {
        Object objWritePacket = writePacket(byteWriteChannel, source, continuation);
        return objWritePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket : Unit.INSTANCE;
    }

    public static final Object writeString(ByteWriteChannel byteWriteChannel, String str, Continuation<? super Unit> continuation) {
        StringsKt.writeText$default(byteWriteChannel.getWriteBuffer(), str, 0, 0, (Charset) null, 14, (Object) null);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static /* synthetic */ Object writeFully$default(ByteWriteChannel byteWriteChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return writeFully(byteWriteChannel, bArr, i, i2, continuation);
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        byteWriteChannel.getWriteBuffer().write(bArr, i, i2);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writeBuffer(ByteWriteChannel byteWriteChannel, RawSource rawSource, Continuation<? super Unit> continuation) throws Throwable {
        Object objWritePacket = writePacket(byteWriteChannel, CoreKt.buffered(rawSource), continuation);
        return objWritePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket : Unit.INSTANCE;
    }

    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, String str, Continuation<? super Unit> continuation) {
        StringsKt.writeText$default(byteWriteChannel.getWriteBuffer(), str, 0, 0, (Charset) null, 14, (Object) null);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    public static final Object writePacket(ByteWriteChannel byteWriteChannel, Buffer buffer, Continuation<? super Unit> continuation) {
        byteWriteChannel.getWriteBuffer().transferFrom(buffer);
        Object objFlushIfNeeded = ByteWriteChannelKt.flushIfNeeded(byteWriteChannel, continuation);
        return objFlushIfNeeded == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlushIfNeeded : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object writePacket(io.ktor.utils.io.ByteWriteChannel r7, kotlinx.io.Source r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteWriteChannelOperationsKt.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.utils.io.ByteWriteChannelOperationsKt$writePacket$2 r0 = (io.ktor.utils.io.ByteWriteChannelOperationsKt.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.utils.io.ByteWriteChannelOperationsKt$writePacket$2 r0 = new io.ktor.utils.io.ByteWriteChannelOperationsKt$writePacket$2
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$1
            kotlinx.io.Source r7 = (kotlinx.io.Source) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteWriteChannel r8 = (io.ktor.utils.io.ByteWriteChannel) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r6 = r8
            r8 = r7
            r7 = r6
            goto L40
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.ResultKt.throwOnFailure(r9)
        L40:
            boolean r9 = r8.exhausted()
            if (r9 != 0) goto L61
            kotlinx.io.Sink r9 = r7.getWriteBuffer()
            r2 = r8
            kotlinx.io.RawSource r2 = (kotlinx.io.RawSource) r2
            long r4 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r8)
            r9.write(r2, r4)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = io.ktor.utils.io.ByteWriteChannelKt.flushIfNeeded(r7, r0)
            if (r9 != r1) goto L40
            return r1
        L61:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteWriteChannelOperationsKt.writePacket(io.ktor.utils.io.ByteWriteChannel, kotlinx.io.Source, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteWriteChannelOperationsKt$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: ByteWriteChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass1(Object obj) {
            super(1, obj, ByteWriteChannel.class, "flushAndClose", "flushAndClose(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((ByteWriteChannel) this.receiver).flushAndClose(continuation);
        }
    }

    public static final void close(ByteWriteChannel byteWriteChannel, Throwable th) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        if (th == null) {
            fireAndForget(new AnonymousClass1(byteWriteChannel));
        } else {
            byteWriteChannel.cancel(th);
        }
    }

    public static final Object join(ChannelJob channelJob, Continuation<? super Unit> continuation) {
        Object objJoin = channelJob.getJob().join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    public static final boolean isCompleted(ChannelJob channelJob) {
        Intrinsics.checkNotNullParameter(channelJob, "<this>");
        return channelJob.getJob().isCompleted();
    }

    public static final boolean isCancelled(ChannelJob channelJob) {
        Intrinsics.checkNotNullParameter(channelJob, "<this>");
        return channelJob.getJob().isCancelled();
    }

    public static final CancellationException getCancellationException(ChannelJob channelJob) {
        Intrinsics.checkNotNullParameter(channelJob, "<this>");
        return channelJob.getJob().getCancellationException();
    }

    public static final DisposableHandle invokeOnCompletion(ChannelJob channelJob, Function1<? super Throwable, Unit> block) {
        Intrinsics.checkNotNullParameter(channelJob, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return channelJob.getJob().invokeOnCompletion(block);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    public static final /* synthetic */ void invokeOnCompletion(ChannelJob channelJob, final Function0 block) {
        Intrinsics.checkNotNullParameter(channelJob, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        channelJob.getJob().invokeOnCompletion(new Function1() { // from class: io.ktor.utils.io.ByteWriteChannelOperationsKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ByteWriteChannelOperationsKt.invokeOnCompletion$lambda$0(block, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeOnCompletion$lambda$0(Function0 function0, Throwable th) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final void cancel(ChannelJob channelJob) {
        Intrinsics.checkNotNullParameter(channelJob, "<this>");
        Job.DefaultImpls.cancel$default(channelJob.getJob(), (CancellationException) null, 1, (Object) null);
    }

    public static /* synthetic */ WriterJob writer$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return writer(coroutineScope, coroutineContext, z, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static final WriterJob writer(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(block, "block");
        return writer(coroutineScope, coroutineContext, new ByteChannel(false, 1, null), block);
    }

    public static /* synthetic */ WriterJob writer$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, ByteChannel byteChannel, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return writer(coroutineScope, coroutineContext, byteChannel, (Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static final WriterJob writer(CoroutineScope coroutineScope, CoroutineContext coroutineContext, final ByteChannel channel, Function2<? super WriterScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(block, "block");
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineContext, null, new ByteWriteChannelOperationsKt$writer$job$1(block, channel, null), 2, null);
        jobLaunch$default.invokeOnCompletion(new Function1() { // from class: io.ktor.utils.io.ByteWriteChannelOperationsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ByteWriteChannelOperationsKt.writer$lambda$2$lambda$1(channel, (Throwable) obj);
            }
        });
        return new WriterJob(channel, jobLaunch$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writer$lambda$2$lambda$1(ByteChannel byteChannel, Throwable th) {
        if (th != null && !byteChannel.isClosedForWrite()) {
            byteChannel.cancel(th);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object write(io.ktor.utils.io.ByteWriteChannel r8, int r9, kotlin.jvm.functions.Function3<? super byte[], ? super java.lang.Integer, ? super java.lang.Integer, java.lang.Integer> r10, kotlin.coroutines.Continuation<? super java.lang.Integer> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteWriteChannelOperationsKt.write(io.ktor.utils.io.ByteWriteChannel, int, kotlin.jvm.functions.Function3, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object write$default(ByteWriteChannel byteWriteChannel, int i, Function3 function3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return write(byteWriteChannel, i, function3, continuation);
    }

    public static final Object awaitFreeSpace(ByteWriteChannel byteWriteChannel, Continuation<? super Unit> continuation) {
        Object objFlush = byteWriteChannel.flush(continuation);
        return objFlush == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objFlush : Unit.INSTANCE;
    }

    public static final <R> void fireAndForget(Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        CancellableKt.startCoroutineCancellable(function1, NO_CALLBACK);
    }
}
