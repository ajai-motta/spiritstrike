package io.ktor.utils.io;

import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import java.io.EOFException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.io.Buffer;
import kotlinx.io.Segment;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.unsafe.UnsafeBufferOperations;

/* JADX INFO: compiled from: ByteReadChannelOperations.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\b*\u00020\u0000H\u0086@¢\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0014\u0010\r\u001a\u00020\f*\u00020\u0000H\u0086@¢\u0006\u0004\b\r\u0010\u0003\u001a\u0014\u0010\u000f\u001a\u00020\u000e*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u0014\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0011\u0010\u0003\u001a\u001c\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0017\u001a\u00020\u0016*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0017\u0010\u0003\u001a\u001c\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0017\u0010\u0015\u001a\u001c\u0010\u001b\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001b\u0010\u001c\u001a \u0010\u001e\u001a\u0004\u0018\u00010\u001d*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u001e\u0010\u0015\u001a\u001c\u0010\u001f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@¢\u0006\u0004\b\u001f\u0010\u001c\u001a$\u0010\u001f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u000eH\u0086@¢\u0006\u0004\b\u001f\u0010!\u001a\u001c\u0010#\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\"\u001a\u00020\nH\u0086@¢\u0006\u0004\b#\u0010\u0015\u001a\u0014\u0010%\u001a\u00020$*\u00020\u0000H\u0086@¢\u0006\u0004\b%\u0010\u0003\u001a\u001c\u0010%\u001a\u00020$*\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000eH\u0086@¢\u0006\u0004\b%\u0010&\u001a0\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\n2\b\b\u0002\u0010)\u001a\u00020\nH\u0086@¢\u0006\u0004\b*\u0010+\u001a-\u0010*\u001a\u00020\n*\u00020\u00002\u0006\u0010,\u001a\u00020\n2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\n0-¢\u0006\u0004\b*\u0010/\u001aN\u0010:\u001a\u000209*\u0002002\b\b\u0002\u00102\u001a\u0002012\b\b\u0002\u00103\u001a\u00020\u00012'\u0010.\u001a#\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001306\u0012\u0006\u0012\u0004\u0018\u00010704¢\u0006\u0002\b8¢\u0006\u0004\b:\u0010;\u001aJ\u0010:\u001a\u000209*\u0002002\u0006\u00102\u001a\u0002012\u0006\u0010\u001a\u001a\u00020<2'\u0010.\u001a#\b\u0001\u0012\u0004\u0012\u000205\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001306\u0012\u0006\u0012\u0004\u0018\u00010704¢\u0006\u0002\b8¢\u0006\u0004\b:\u0010=\u001a\u001c\u0010?\u001a\u00020$*\u00020\u00002\u0006\u0010>\u001a\u00020\nH\u0086@¢\u0006\u0004\b?\u0010\u0015\u001a\u001c\u0010A\u001a\u00020\u0013*\u00020\u00002\u0006\u0010@\u001a\u00020\u000eH\u0086@¢\u0006\u0004\bA\u0010&\u001a\u001e\u0010B\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\u000eH\u0086@¢\u0006\u0004\bB\u0010&\u001a*\u0010F\u001a\u00020\u0001*\u00020\u00002\n\u0010E\u001a\u00060Cj\u0002`D2\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0086@¢\u0006\u0004\bF\u0010G\u001a4\u0010F\u001a\u00020\u0001*\u00020\u00002\n\u0010E\u001a\u00060Cj\u0002`D2\b\b\u0002\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010I\u001a\u00020HH\u0087@¢\u0006\u0004\bJ\u0010K\u001aF\u0010M\u001a\u00020\n*\u00020\u000020\b\u0004\u0010.\u001a*\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n06\u0012\u0006\u0012\u0004\u0018\u0001070LH\u0086H¢\u0006\u0004\bM\u0010N\u001a0\u0010Q\u001a\u00020\u0013*\u00020\u00002\u0006\u0010E\u001a\u00020\u00042\b\b\u0002\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\nH\u0086@¢\u0006\u0004\bQ\u0010+\u001a\u0013\u0010R\u001a\u00020\u0013*\u00020\u0000H\u0007¢\u0006\u0004\bR\u0010S\u001a\u0013\u0010R\u001a\u00020\u0013*\u00020\u0019H\u0007¢\u0006\u0004\bR\u0010T\u001a\u0013\u0010R\u001a\u00020\u0013*\u00020<H\u0007¢\u0006\u0004\bR\u0010U\u001a8\u0010Z\u001a\u00020\u000e*\u00020\u00002\u0006\u0010W\u001a\u00020V2\u0006\u0010X\u001a\u00020\u00192\b\b\u0002\u0010 \u001a\u00020\u000e2\b\b\u0002\u0010Y\u001a\u00020\u0001H\u0086@¢\u0006\u0004\bZ\u0010[\u001a\u001c\u0010]\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\\\u001a\u00020VH\u0086@¢\u0006\u0004\b]\u0010^\u001a\u001e\u0010_\u001a\u0004\u0018\u00010V*\u00020\u00002\u0006\u0010\"\u001a\u00020\nH\u0086@¢\u0006\u0004\b_\u0010\u0015\"\u001b\u0010c\u001a\u00020\n*\u00020\u00198F¢\u0006\f\u0012\u0004\bb\u0010T\u001a\u0004\b`\u0010a\"\u0014\u0010d\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bd\u0010e\"\u0014\u0010f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bf\u0010e\"\u001b\u0010j\u001a\u00020\n*\u00020\u00008F¢\u0006\f\u0012\u0004\bi\u0010S\u001a\u0004\bg\u0010h¨\u0006k"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "", "exhausted", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "toByteArray", "", "readByte", "", "readShort", "", "readInt", "", "readFloat", "", "readLong", "", "readDouble", "numberOfBytes", "", "awaitUntilReadable", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/io/Buffer;", "readBuffer", "max", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "copyAndClose", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "readUTF8Line", "copyTo", "limit", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "count", "readByteArray", "Lkotlinx/io/Source;", "readRemaining", "(Lio/ktor/utils/io/ByteReadChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buffer", TypedValues.CycleType.S_WAVE_OFFSET, "length", "readAvailable", "(Lio/ktor/utils/io/ByteReadChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "min", "Lkotlin/Function1;", "block", "(Lio/ktor/utils/io/ByteReadChannel;ILkotlin/jvm/functions/Function1;)I", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "autoFlush", "Lkotlin/Function2;", "Lio/ktor/utils/io/ReaderScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "Lio/ktor/utils/io/ReaderJob;", "reader", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;ZLkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/utils/io/ByteChannel;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/ByteChannel;Lkotlin/jvm/functions/Function2;)Lio/ktor/utils/io/ReaderJob;", "packet", "readPacket", "value", "discardExact", "discard", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "readUTF8LineTo", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/LineEndingMode;", "lineEnding", "readUTF8LineTo-RRvyBJ8", "(Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Appendable;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "read", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TtmlNode.START, TtmlNode.END, "readFully", "rethrowCloseCauseIfNeeded", "(Lio/ktor/utils/io/ByteReadChannel;)V", "(Lio/ktor/utils/io/ByteWriteChannel;)V", "(Lio/ktor/utils/io/ByteChannel;)V", "Lkotlinx/io/bytestring/ByteString;", "matchString", "writeChannel", "ignoreMissing", "readUntil", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteWriteChannel;JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "byteString", "skipIfFound", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peek", "getAvailableForWrite", "(Lio/ktor/utils/io/ByteWriteChannel;)I", "getAvailableForWrite$annotations", "availableForWrite", "CR", "B", "LF", "getAvailableForRead", "(Lio/ktor/utils/io/ByteReadChannel;)I", "getAvailableForRead$annotations", "availableForRead", "ktor-io"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ByteReadChannelOperationsKt {
    private static final byte CR = 13;
    private static final byte LF = 10;

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1, reason: invalid class name */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {}, l = {92}, m = "awaitUntilReadable", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.awaitUntilReadable(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyAndClose$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 1, 1, 1, 2}, l = {132, 133, 142, 142}, m = "copyAndClose", n = {"$this$copyAndClose", "channel", "result", "$this$copyAndClose", "channel", "result", "result"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "J$0"})
    static final class C33291 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33291(Continuation<? super C33291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyAndClose(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 1, 1, 1, 2}, l = {171, TsExtractor.TS_STREAM_TYPE_AC4, 179, 179}, m = "copyTo", n = {"$this$copyTo", "channel", "result", "$this$copyTo", "channel", "result", "result"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "J$0"})
    static final class C33301 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33301(Continuation<? super C33301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.copyTo(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$copyTo$2, reason: invalid class name */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, 194, ComposerKt.providerKey, ComposerKt.providerKey}, m = "copyTo", n = {"$this$copyTo", "channel", "limit", "remaining", "$this$copyTo", "channel", "limit", "remaining", "limit", "remaining"}, s = {"L$0", "L$1", "J$0", "J$1", "L$0", "L$1", "J$0", "J$1", "J$0", "J$1"})
    static final class AnonymousClass2 extends ContinuationImpl {
        long J$0;
        long J$1;
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
            return ByteReadChannelOperationsKt.copyTo(null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0}, l = {393}, m = "discard", n = {"$this$discard", "max", "remaining"}, s = {"L$0", "J$0", "J$1"})
    static final class C33311 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33311(Continuation<? super C33311> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.discard(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {385}, m = "discardExact", n = {"value"}, s = {"J$0"})
    static final class C33321 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        C33321(Continuation<? super C33321> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.discardExact(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {34}, m = "exhausted", n = {"$this$exhausted"}, s = {"L$0"})
    static final class C33331 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33331(Continuation<? super C33331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.exhausted(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {618}, m = "peek", n = {"$this$peek", "count"}, s = {"L$0", "I$0"})
    static final class C33341 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33341(Continuation<? super C33341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.peek(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$read$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 1, 1, 1}, l = {499, 504}, m = "read", n = {"$this$read", "block", "result", "buffer$iv", "head$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    static final class C33351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C33351(Continuation<? super C33351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.read(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {259}, m = "readAvailable", n = {"$this$readAvailable", "buffer", TypedValues.CycleType.S_WAVE_OFFSET, "length"}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C33361 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33361(Continuation<? super C33361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readAvailable(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {102}, m = "readBuffer", n = {"$this$readBuffer", "result"}, s = {"L$0", "L$1"})
    static final class C33371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33371(Continuation<? super C33371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readBuffer(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3, reason: invalid class name */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0}, l = {116}, m = "readBuffer", n = {"$this$readBuffer", "result", "remaining"}, s = {"L$0", "L$1", "I$0"})
    static final class AnonymousClass3 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readBuffer(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {45}, m = "readByte", n = {"currentBuffer"}, s = {"L$0"})
    static final class C33381 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33381(Continuation<? super C33381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readByte(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {209}, m = "readByteArray", n = {"$this$readByteArray", "builder$iv", "$this$readByteArray_u24lambda_u242", "count"}, s = {"L$0", "L$1", "L$2", "I$0"})
    static final class C33391 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C33391(Continuation<? super C33391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readByteArray(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {87}, m = "readDouble", n = {"$this$readDouble"}, s = {"L$0"})
    static final class C33401 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33401(Continuation<? super C33401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readDouble(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {70}, m = "readFloat", n = {"$this$readFloat"}, s = {"L$0"})
    static final class C33411 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33411(Continuation<? super C33411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readFloat(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0}, l = {533}, m = "readFully", n = {"$this$readFully", "out", TtmlNode.END, TypedValues.CycleType.S_WAVE_OFFSET}, s = {"L$0", "L$1", "I$0", "I$1"})
    static final class C33421 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33421(Continuation<? super C33421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readFully(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {59}, m = "readInt", n = {"$this$readInt"}, s = {"L$0"})
    static final class C33431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33431(Continuation<? super C33431> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readInt(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {76}, m = "readLong", n = {"$this$readLong"}, s = {"L$0"})
    static final class C33441 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33441(Continuation<? super C33441> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readLong(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readPacket$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0}, l = {368}, m = "readPacket", n = {"$this$readPacket", "result", "packet"}, s = {"L$0", "L$1", "I$0"})
    static final class C33451 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33451(Continuation<? super C33451> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readPacket(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {219}, m = "readRemaining", n = {"$this$readRemaining", "result"}, s = {"L$0", "L$1"})
    static final class C33461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33461(Continuation<? super C33461> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readRemaining(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0}, l = {239}, m = "readRemaining", n = {"$this$readRemaining", "result", "remaining"}, s = {"L$0", "L$1", "J$0"})
    static final class C33472 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33472(Continuation<? super C33472> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readRemaining(null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {53}, m = "readShort", n = {"$this$readShort"}, s = {"L$0"})
    static final class C33481 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33481(Continuation<? super C33481> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readShort(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0}, l = {161}, m = "readUTF8Line", n = {"result"}, s = {"L$0"})
    static final class C33491 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33491(Continuation<? super C33491> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.readUTF8Line(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8LineTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {446, 461, 485}, m = "readUTF8LineTo-RRvyBJ8", n = {"$this$readUTF8LineTo_u2dRRvyBJ8", "out", "max", "lineEnding", "$this$readUTF8LineTo_u2dRRvyBJ8", "out", "lineBuffer", "lineEnding", "$this$readUTF8LineTo_u2dRRvyBJ8", "out", "lineBuffer", "max", "lineEnding"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$3", "I$0", "L$0", "L$1", "L$3", "I$0", "I$1"})
    static final class C33502 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C33502(Continuation<? super C33502> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.m7382readUTF8LineToRRvyBJ8(null, null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {0, 0}, l = {598, CommonGatewayClient.CODE_599}, m = "skipIfFound", n = {"$this$skipIfFound", "byteString"}, s = {"L$0", "L$1"})
    static final class C33521 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33521(Continuation<? super C33521> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.skipIfFound(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt", f = "ByteReadChannelOperations.kt", i = {}, l = {39}, m = "toByteArray", n = {}, s = {})
    static final class C33531 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C33531(Continuation<? super C33531> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteReadChannelOperationsKt.toByteArray(null, this);
        }
    }

    public static /* synthetic */ void getAvailableForRead$annotations(ByteReadChannel byteReadChannel) {
    }

    public static /* synthetic */ void getAvailableForWrite$annotations(ByteWriteChannel byteWriteChannel) {
    }

    public static final int getAvailableForWrite(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return 1048576 - BytePacketBuilderKt.getSize(byteWriteChannel.getWriteBuffer());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object exhausted(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33331
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33331) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$exhausted$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L50
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.io.Source r5 = r4.getReadBuffer()
            boolean r5 = r5.exhausted()
            if (r5 == 0) goto L50
            r0.L$0 = r4
            r0.label = r3
            r5 = 0
            r2 = 0
            java.lang.Object r5 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r4, r5, r0, r3, r2)
            if (r5 != r1) goto L50
            return r1
        L50:
            kotlinx.io.Source r4 = r4.getReadBuffer()
            boolean r4 = r4.exhausted()
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.exhausted(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object toByteArray(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super byte[]> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33531
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33531) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$toByteArray$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L3e
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = readBuffer(r4, r0)
            if (r5 != r1) goto L3e
            return r1
        L3e:
            kotlinx.io.Buffer r5 = (kotlinx.io.Buffer) r5
            r4 = 0
            r0 = 0
            byte[] r4 = io.ktor.utils.io.core.BuffersKt.readBytes$default(r5, r4, r3, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.toByteArray(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readByte(io.ktor.utils.io.ByteReadChannel r6, kotlin.coroutines.Continuation<? super java.lang.Byte> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33381
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33381) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readByte$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r6 = r0.L$0
            kotlinx.io.Source r6 = (kotlinx.io.Source) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L53
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.io.Source r7 = r6.getReadBuffer()
            boolean r2 = r7.exhausted()
            if (r2 == 0) goto L65
            r0.L$0 = r7
            r0.label = r3
            r2 = 0
            r4 = 0
            java.lang.Object r6 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r6, r2, r0, r3, r4)
            if (r6 != r1) goto L50
            return r1
        L50:
            r5 = r7
            r7 = r6
            r6 = r5
        L53:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L5d
            r7 = r6
            goto L65
        L5d:
            java.io.EOFException r6 = new java.io.EOFException
            java.lang.String r7 = "Not enough data available"
            r6.<init>(r7)
            throw r6
        L65:
            byte r6 = r7.readByte()
            java.lang.Byte r6 = kotlin.coroutines.jvm.internal.Boxing.boxByte(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readByte(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readShort(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Short> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33481
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readShort$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 2
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            kotlinx.io.Source r4 = r4.getReadBuffer()
            short r4 = r4.readShort()
            java.lang.Short r4 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readShort(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readInt(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Integer> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33431
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readInt$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 4
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            kotlinx.io.Source r4 = r4.getReadBuffer()
            int r4 = r4.readInt()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readInt(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readFloat(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Float> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33411
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33411) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readFloat$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L45
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 4
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            kotlinx.io.Source r4 = r4.getReadBuffer()
            float r4 = kotlinx.io.SourcesKt.readFloat(r4)
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readFloat(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readLong(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Long> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33441
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readLong$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L46
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 8
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlinx.io.Source r4 = r4.getReadBuffer()
            long r4 = r4.readLong()
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readLong(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readDouble(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation<? super java.lang.Double> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33401
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readDouble$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L46
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            r5 = 8
            java.lang.Object r5 = awaitUntilReadable(r4, r5, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlinx.io.Source r4 = r4.getReadBuffer()
            double r4 = kotlinx.io.SourcesKt.readDouble(r4)
            java.lang.Double r4 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readDouble(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitUntilReadable(io.ktor.utils.io.ByteReadChannel r4, int r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$awaitUntilReadable$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L3e
        L2a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.Object r6 = r4.awaitContent(r5, r0)
            if (r6 != r1) goto L3e
            return r1
        L3e:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r4 = r6.booleanValue()
            if (r4 == 0) goto L49
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L49:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.String r5 = "Not enough data available"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.awaitUntilReadable(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readBuffer(io.ktor.utils.io.ByteReadChannel r5, kotlin.coroutines.Continuation<? super kotlinx.io.Buffer> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33371
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33371) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            kotlinx.io.Buffer r5 = (kotlinx.io.Buffer) r5
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            r5 = r2
            goto L44
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.io.Buffer r6 = new kotlinx.io.Buffer
            r6.<init>()
        L44:
            boolean r2 = r5.isClosedForRead()
            if (r2 != 0) goto L62
            kotlinx.io.Source r2 = r5.getReadBuffer()
            kotlinx.io.RawSource r2 = (kotlinx.io.RawSource) r2
            r6.transferFrom(r2)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            r2 = 0
            r4 = 0
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r5, r2, r0, r3, r4)
            if (r2 != r1) goto L44
            return r1
        L62:
            java.lang.Throwable r5 = r5.getClosedCause()
            if (r5 != 0) goto L69
            return r6
        L69:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readBuffer(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0054 -> B:25:0x006d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0067 -> B:24:0x006a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readBuffer(io.ktor.utils.io.ByteReadChannel r8, int r9, kotlin.coroutines.Continuation<? super kotlinx.io.Buffer> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.AnonymousClass3
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.AnonymousClass3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readBuffer$3
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            kotlinx.io.Buffer r9 = (kotlinx.io.Buffer) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6a
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3c:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.io.Buffer r10 = new kotlinx.io.Buffer
            r10.<init>()
        L44:
            if (r9 <= 0) goto L87
            boolean r2 = r8.isClosedForRead()
            if (r2 != 0) goto L87
            kotlinx.io.Source r2 = r8.getReadBuffer()
            boolean r2 = r2.exhausted()
            if (r2 == 0) goto L6d
            r0.L$0 = r8
            r0.L$1 = r10
            r0.I$0 = r9
            r0.label = r3
            r2 = 0
            r4 = 0
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r8, r2, r0, r3, r4)
            if (r2 != r1) goto L67
            return r1
        L67:
            r2 = r8
            r8 = r9
            r9 = r10
        L6a:
            r10 = r9
            r9 = r8
            r8 = r2
        L6d:
            long r4 = (long) r9
            kotlinx.io.Source r2 = r8.getReadBuffer()
            long r6 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r2)
            long r4 = java.lang.Math.min(r4, r6)
            kotlinx.io.Source r2 = r8.getReadBuffer()
            r6 = r10
            kotlinx.io.RawSink r6 = (kotlinx.io.RawSink) r6
            r2.readTo(r6, r4)
            int r2 = (int) r4
            int r9 = r9 - r2
            goto L44
        L87:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readBuffer(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a A[Catch: all -> 0x00c7, TRY_LEAVE, TryCatch #1 {all -> 0x00c7, blocks: (B:27:0x0074, B:29:0x007a, B:36:0x00ab, B:44:0x00c6), top: B:57:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab A[Catch: all -> 0x00c7, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00c7, blocks: (B:27:0x0074, B:29:0x007a, B:36:0x00ab, B:44:0x00c6), top: B:57:0x0074 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00a8 -> B:20:0x0057). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object copyAndClose(io.ktor.utils.io.ByteReadChannel r15, io.ktor.utils.io.ByteWriteChannel r16, kotlin.coroutines.Continuation<? super java.lang.Long> r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.copyAndClose(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readUTF8Line(io.ktor.utils.io.ByteReadChannel r5, int r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33491
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33491) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readUTF8Line$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4f
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r2 = r7
            java.lang.Appendable r2 = (java.lang.Appendable) r2
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r5 = readUTF8LineTo(r5, r2, r6, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            r4 = r7
            r7 = r5
            r5 = r4
        L4f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L59
            r5 = 0
            goto L5d
        L59:
            java.lang.String r5 = r5.toString()
        L5d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readUTF8Line(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object readUTF8Line$default(ByteReadChannel byteReadChannel, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8Line(byteReadChannel, i, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007d A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #0 {all -> 0x00c4, blocks: (B:27:0x0077, B:29:0x007d), top: B:52:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ac -> B:20:0x0057). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r16, io.ktor.utils.io.ByteWriteChannel r17, kotlin.coroutines.Continuation<? super java.lang.Long> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2, types: [io.ktor.utils.io.ByteWriteChannel] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5, types: [io.ktor.utils.io.ByteWriteChannel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00d7 -> B:20:0x005b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object copyTo(io.ktor.utils.io.ByteReadChannel r18, io.ktor.utils.io.ByteWriteChannel r19, long r20, kotlin.coroutines.Continuation<? super java.lang.Long> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.copyTo(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0071 -> B:12:0x003a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readByteArray(io.ktor.utils.io.ByteReadChannel r6, int r7, kotlin.coroutines.Continuation<? super byte[]> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33391
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33391) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readByteArray$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$2
            kotlinx.io.Sink r7 = (kotlinx.io.Sink) r7
            java.lang.Object r2 = r0.L$1
            kotlinx.io.Buffer r2 = (kotlinx.io.Buffer) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r4 = (io.ktor.utils.io.ByteReadChannel) r4
            kotlin.ResultKt.throwOnFailure(r8)
            r5 = r0
            r0 = r6
            r6 = r4
        L3a:
            r4 = r2
            r2 = r5
            goto L75
        L3d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L45:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.io.Buffer r8 = new kotlinx.io.Buffer
            r8.<init>()
            r2 = r8
            kotlinx.io.Sink r2 = (kotlinx.io.Sink) r2
            r5 = r8
            r8 = r7
            r7 = r2
            r2 = r5
        L54:
            int r4 = io.ktor.utils.io.core.BytePacketBuilderKt.getSize(r7)
            if (r4 >= r8) goto L7e
            int r4 = io.ktor.utils.io.core.BytePacketBuilderKt.getSize(r7)
            int r4 = r8 - r4
            r0.L$0 = r6
            r0.L$1 = r2
            r0.L$2 = r7
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r4 = readPacket(r6, r4, r0)
            if (r4 != r1) goto L71
            return r1
        L71:
            r5 = r0
            r0 = r8
            r8 = r4
            goto L3a
        L75:
            kotlinx.io.Source r8 = (kotlinx.io.Source) r8
            io.ktor.utils.io.core.BytePacketBuilderKt.writePacket(r7, r8)
            r8 = r0
            r0 = r2
            r2 = r4
            goto L54
        L7e:
            kotlinx.io.Source r2 = (kotlinx.io.Source) r2
            byte[] r6 = kotlinx.io.SourcesKt.readByteArray(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readByteArray(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readRemaining(io.ktor.utils.io.ByteReadChannel r5, kotlin.coroutines.Continuation<? super kotlinx.io.Source> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33461
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.L$1
            kotlinx.io.Sink r5 = (kotlinx.io.Sink) r5
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            r5 = r2
            goto L43
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.io.Sink r6 = io.ktor.utils.io.core.BytePacketBuilderKt.BytePacketBuilder()
        L43:
            boolean r2 = r5.isClosedForRead()
            if (r2 != 0) goto L61
            kotlinx.io.Source r2 = r5.getReadBuffer()
            kotlinx.io.RawSource r2 = (kotlinx.io.RawSource) r2
            r6.transferFrom(r2)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            r2 = 0
            r4 = 0
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r5, r2, r0, r3, r4)
            if (r2 != r1) goto L43
            return r1
        L61:
            rethrowCloseCauseIfNeeded(r5)
            kotlinx.io.Buffer r5 = r6.getBufferField()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readRemaining(io.ktor.utils.io.ByteReadChannel r8, long r9, kotlin.coroutines.Continuation<? super kotlinx.io.Source> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33472
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$2 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33472) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$2 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readRemaining$2
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            long r8 = r0.J$0
            java.lang.Object r10 = r0.L$1
            kotlinx.io.Sink r10 = (kotlinx.io.Sink) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r9 = r8
            r8 = r2
            goto L46
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.io.Sink r11 = io.ktor.utils.io.core.BytePacketBuilderKt.BytePacketBuilder()
        L46:
            boolean r2 = r8.isClosedForRead()
            if (r2 != 0) goto L94
            r4 = 0
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r2 <= 0) goto L94
            kotlinx.io.Source r2 = r8.getReadBuffer()
            long r6 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r2)
            int r2 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r2 < 0) goto L77
            kotlinx.io.Source r2 = r8.getReadBuffer()
            long r4 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r2)
            long r4 = r9 - r4
            kotlinx.io.Source r9 = r8.getReadBuffer()
            r10 = r11
            kotlinx.io.RawSink r10 = (kotlinx.io.RawSink) r10
            long r9 = r9.transferTo(r10)
            kotlin.coroutines.jvm.internal.Boxing.boxLong(r9)
            goto L81
        L77:
            kotlinx.io.Source r2 = r8.getReadBuffer()
            r6 = r11
            kotlinx.io.RawSink r6 = (kotlinx.io.RawSink) r6
            r2.readTo(r6, r9)
        L81:
            r0.L$0 = r8
            r0.L$1 = r11
            r0.J$0 = r4
            r0.label = r3
            r9 = 0
            r10 = 0
            java.lang.Object r9 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r8, r9, r0, r3, r10)
            if (r9 != r1) goto L92
            return r1
        L92:
            r9 = r4
            goto L46
        L94:
            kotlinx.io.Buffer r8 = r11.getBufferField()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(io.ktor.utils.io.ByteReadChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readAvailable(io.ktor.utils.io.ByteReadChannel r7, byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super java.lang.Integer> r11) throws java.lang.Throwable {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33361
            if (r0 == 0) goto L14
            r0 = r11
            io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33361) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readAvailable$1
            r0.<init>(r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = -1
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 != r4) goto L3d
            int r7 = r0.I$1
            int r8 = r0.I$0
            java.lang.Object r9 = r0.L$1
            byte[] r9 = (byte[]) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r10 = (io.ktor.utils.io.ByteReadChannel) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r5 = r10
            r10 = r7
            r7 = r5
            r6 = r9
            r9 = r8
            r8 = r6
            goto L70
        L3d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L45:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r7.isClosedForRead()
            if (r11 == 0) goto L53
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            return r7
        L53:
            kotlinx.io.Source r11 = r7.getReadBuffer()
            boolean r11 = r11.exhausted()
            if (r11 == 0) goto L70
            r0.L$0 = r7
            r0.L$1 = r8
            r0.I$0 = r9
            r0.I$1 = r10
            r0.label = r4
            r11 = 0
            r2 = 0
            java.lang.Object r11 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r7, r11, r0, r4, r2)
            if (r11 != r1) goto L70
            return r1
        L70:
            boolean r11 = r7.isClosedForRead()
            if (r11 == 0) goto L7b
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            return r7
        L7b:
            kotlinx.io.Source r7 = r7.getReadBuffer()
            int r7 = io.ktor.utils.io.core.InputKt.readAvailable(r7, r8, r9, r10)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readAvailable(io.ktor.utils.io.ByteReadChannel, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object readAvailable$default(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(byteReadChannel, bArr, i, i2, continuation);
    }

    public static final int readAvailable(ByteReadChannel byteReadChannel, int i, Function1<? super Buffer, Integer> block) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (i <= 0) {
            throw new IllegalArgumentException("min should be positive".toString());
        }
        if (i > 1048576) {
            throw new IllegalArgumentException(("Min(" + i + ") shouldn't be greater than 1048576").toString());
        }
        if (getAvailableForRead(byteReadChannel) < i) {
            return -1;
        }
        return block.invoke(byteReadChannel.getReadBuffer().getBufferField()).intValue();
    }

    public static /* synthetic */ ReaderJob reader$default(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return reader(coroutineScope, coroutineContext, z, (Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object>) function2);
    }

    public static final ReaderJob reader(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(block, "block");
        return reader(coroutineScope, coroutineContext, new ByteChannel(false, 1, null), block);
    }

    public static final ReaderJob reader(CoroutineScope coroutineScope, CoroutineContext coroutineContext, final ByteChannel channel, Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(block, "block");
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineContext, null, new ByteReadChannelOperationsKt$reader$job$1(block, channel, null), 2, null);
        jobLaunch$default.invokeOnCompletion(new Function1() { // from class: io.ktor.utils.io.ByteReadChannelOperationsKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ByteReadChannelOperationsKt.reader$lambda$6$lambda$5(channel, (Throwable) obj);
            }
        });
        return new ReaderJob(CloseHookByteWriteChannelKt.onClose(channel, new C33511(jobLaunch$default, null)), jobLaunch$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reader$lambda$6$lambda$5(ByteChannel byteChannel, Throwable th) {
        if (th != null && !byteChannel.isClosedForRead()) {
            byteChannel.cancel(th);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: io.ktor.utils.io.ByteReadChannelOperationsKt$reader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ByteReadChannelOperations.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteReadChannelOperationsKt$reader$1", f = "ByteReadChannelOperations.kt", i = {}, l = {353}, m = "invokeSuspend", n = {}, s = {})
    static final class C33511 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Job $job;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C33511(Job job, Continuation<? super C33511> continuation) {
            super(1, continuation);
            this.$job = job;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C33511(this.$job, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C33511) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$job.join(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0058 -> B:24:0x006f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006b -> B:23:0x006d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readPacket(io.ktor.utils.io.ByteReadChannel r11, int r12, kotlin.coroutines.Continuation<? super kotlinx.io.Source> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readPacket(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object discardExact(io.ktor.utils.io.ByteReadChannel r4, long r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33321
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33321) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$discardExact$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            long r5 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L42
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L34:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r7 = discard(r4, r5, r0)
            if (r7 != r1) goto L42
            return r1
        L42:
            java.lang.Number r7 = (java.lang.Number) r7
            long r0 = r7.longValue()
            int r4 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r4 < 0) goto L4f
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L4f:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Unable to discard "
            r7.<init>(r0)
            r7.append(r5)
            java.lang.String r5 = " bytes"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.discardExact(io.ktor.utils.io.ByteReadChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x004e -> B:26:0x0067). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0061 -> B:25:0x0064). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object discard(io.ktor.utils.io.ByteReadChannel r10, long r11, kotlin.coroutines.Continuation<? super java.lang.Long> r13) throws java.lang.Throwable {
        /*
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33311
            if (r0 == 0) goto L14
            r0 = r13
            io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33311) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$discard$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            long r10 = r0.J$1
            long r4 = r0.J$0
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r12 = (io.ktor.utils.io.ByteReadChannel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L64
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L3a:
            kotlin.ResultKt.throwOnFailure(r13)
            r4 = r11
        L3e:
            r6 = 0
            int r13 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r13 <= 0) goto L7c
            boolean r13 = r10.isClosedForRead()
            if (r13 != 0) goto L7c
            int r13 = getAvailableForRead(r10)
            if (r13 != 0) goto L67
            r0.L$0 = r10
            r0.J$0 = r4
            r0.J$1 = r11
            r0.label = r3
            r13 = 0
            r2 = 0
            java.lang.Object r13 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r10, r13, r0, r3, r2)
            if (r13 != r1) goto L61
            return r1
        L61:
            r8 = r11
            r12 = r10
            r10 = r8
        L64:
            r8 = r10
            r10 = r12
            r11 = r8
        L67:
            kotlinx.io.Source r13 = r10.getReadBuffer()
            long r6 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r13)
            long r6 = java.lang.Math.min(r11, r6)
            kotlinx.io.Source r13 = r10.getReadBuffer()
            io.ktor.utils.io.core.ByteReadPacketKt.discard(r13, r6)
            long r11 = r11 - r6
            goto L3e
        L7c:
            long r4 = r4 - r11
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.discard(io.ktor.utils.io.ByteReadChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object discard$default(ByteReadChannel byteReadChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Long.MAX_VALUE;
        }
        return discard(byteReadChannel, j, continuation);
    }

    public static /* synthetic */ Object readUTF8LineTo$default(ByteReadChannel byteReadChannel, Appendable appendable, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        return readUTF8LineTo(byteReadChannel, appendable, i, continuation);
    }

    public static final Object readUTF8LineTo(ByteReadChannel byteReadChannel, Appendable appendable, int i, Continuation<? super Boolean> continuation) {
        return m7382readUTF8LineToRRvyBJ8(byteReadChannel, appendable, i, LineEndingMode.INSTANCE.m7396getAnyf0jXZW8(), continuation);
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x01d5: INVOKE (r14 I:java.lang.AutoCloseable), (r1 I:java.lang.Throwable) STATIC call: kotlin.jdk7.AutoCloseableKt.closeFinally(java.lang.AutoCloseable, java.lang.Throwable):void A[MD:(java.lang.AutoCloseable, java.lang.Throwable):void throws java.lang.Exception (m)], block:B:81:0x01d4 */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d1 A[Catch: all -> 0x006d, LOOP:1: B:39:0x00d1->B:63:0x016e, LOOP_START, TryCatch #1 {all -> 0x006d, blocks: (B:14:0x0046, B:37:0x00cb, B:39:0x00d1, B:41:0x00db, B:43:0x00e7, B:45:0x00f1, B:50:0x010c, B:52:0x011e, B:54:0x013e, B:53:0x0135, B:59:0x0153, B:63:0x016e, B:64:0x0173, B:66:0x017e, B:69:0x0194, B:70:0x01af, B:71:0x01b0, B:74:0x01bb, B:76:0x01c5, B:19:0x0068, B:36:0x00c1), top: B:85:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011e A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:14:0x0046, B:37:0x00cb, B:39:0x00d1, B:41:0x00db, B:43:0x00e7, B:45:0x00f1, B:50:0x010c, B:52:0x011e, B:54:0x013e, B:53:0x0135, B:59:0x0153, B:63:0x016e, B:64:0x0173, B:66:0x017e, B:69:0x0194, B:70:0x01af, B:71:0x01b0, B:74:0x01bb, B:76:0x01c5, B:19:0x0068, B:36:0x00c1), top: B:85:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0135 A[Catch: all -> 0x006d, TryCatch #1 {all -> 0x006d, blocks: (B:14:0x0046, B:37:0x00cb, B:39:0x00d1, B:41:0x00db, B:43:0x00e7, B:45:0x00f1, B:50:0x010c, B:52:0x011e, B:54:0x013e, B:53:0x0135, B:59:0x0153, B:63:0x016e, B:64:0x0173, B:66:0x017e, B:69:0x0194, B:70:0x01af, B:71:0x01b0, B:74:0x01bb, B:76:0x01c5, B:19:0x0068, B:36:0x00c1), top: B:85:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c5 A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #1 {all -> 0x006d, blocks: (B:14:0x0046, B:37:0x00cb, B:39:0x00d1, B:41:0x00db, B:43:0x00e7, B:45:0x00f1, B:50:0x010c, B:52:0x011e, B:54:0x013e, B:53:0x0135, B:59:0x0153, B:63:0x016e, B:64:0x0173, B:66:0x017e, B:69:0x0194, B:70:0x01af, B:71:0x01b0, B:74:0x01bb, B:76:0x01c5, B:19:0x0068, B:36:0x00c1), top: B:85:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX INFO: renamed from: readUTF8LineTo-RRvyBJ8, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m7382readUTF8LineToRRvyBJ8(io.ktor.utils.io.ByteReadChannel r19, java.lang.Appendable r20, int r21, int r22, kotlin.coroutines.Continuation<? super java.lang.Boolean> r23) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 473
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.m7382readUTF8LineToRRvyBJ8(io.ktor.utils.io.ByteReadChannel, java.lang.Appendable, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: readUTF8LineTo-RRvyBJ8$default, reason: not valid java name */
    public static /* synthetic */ Object m7383readUTF8LineToRRvyBJ8$default(ByteReadChannel byteReadChannel, Appendable appendable, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = Integer.MAX_VALUE;
        }
        if ((i3 & 4) != 0) {
            i2 = LineEndingMode.INSTANCE.m7396getAnyf0jXZW8();
        }
        return m7382readUTF8LineToRRvyBJ8(byteReadChannel, appendable, i, i2, continuation);
    }

    private static final void readUTF8LineTo_RRvyBJ8$checkLineEndingAllowed(int i, int i2) throws IOException {
        if (LineEndingMode.m7389containslTjpP64(i, i2)) {
            return;
        }
        throw new IOException("Unexpected line ending " + ((Object) LineEndingMode.m7394toStringimpl(i2)) + ", while expected " + ((Object) LineEndingMode.m7394toStringimpl(i)));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object read(io.ktor.utils.io.ByteReadChannel r7, kotlin.jvm.functions.Function4<? super byte[], ? super java.lang.Integer, ? super java.lang.Integer, ? super kotlin.coroutines.Continuation<? super java.lang.Integer>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.read(io.ktor.utils.io.ByteReadChannel, kotlin.jvm.functions.Function4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final Object read$$forInline(ByteReadChannel byteReadChannel, Function4<? super byte[], ? super Integer, ? super Integer, ? super Continuation<? super Integer>, ? extends Object> function4, Continuation<? super Integer> continuation) throws EOFException {
        if (byteReadChannel.isClosedForRead()) {
            return -1;
        }
        if (byteReadChannel.getReadBuffer().exhausted()) {
            InlineMarker.mark(0);
            ByteReadChannel.DefaultImpls.awaitContent$default(byteReadChannel, 0, continuation, 1, null);
            InlineMarker.mark(1);
        }
        if (byteReadChannel.isClosedForRead()) {
            return -1;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        UnsafeBufferOperations unsafeBufferOperations = UnsafeBufferOperations.INSTANCE;
        Buffer bufferField = byteReadChannel.getReadBuffer().getBufferField();
        if (!(!bufferField.exhausted())) {
            throw new IllegalArgumentException("Buffer is empty".toString());
        }
        Segment head = bufferField.getHead();
        Intrinsics.checkNotNull(head);
        Object objDataAsByteArray = head.dataAsByteArray(true);
        Integer numValueOf = Integer.valueOf(head.getPos());
        int iIntValue = Integer.valueOf(head.getLimit()).intValue();
        Integer numValueOf2 = Integer.valueOf(numValueOf.intValue());
        Integer numValueOf3 = Integer.valueOf(iIntValue);
        InlineMarker.mark(3);
        intRef.element = ((Number) function4.invoke((byte[]) objDataAsByteArray, numValueOf2, numValueOf3, null)).intValue();
        int iIntValue2 = Integer.valueOf(intRef.element).intValue();
        if (iIntValue2 != 0) {
            if (iIntValue2 < 0) {
                throw new IllegalStateException("Returned negative read bytes count");
            }
            if (iIntValue2 > head.getSize()) {
                throw new IllegalStateException("Returned too many bytes");
            }
            bufferField.skip(iIntValue2);
        }
        return Integer.valueOf(intRef.element);
    }

    public static final int getAvailableForRead(ByteReadChannel byteReadChannel) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        return (int) byteReadChannel.getReadBuffer().getBufferField().getSizeMut();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005c -> B:29:0x007b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0071 -> B:28:0x0076). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object readFully(io.ktor.utils.io.ByteReadChannel r8, byte[] r9, int r10, int r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33421
            if (r0 == 0) goto L14
            r0 = r12
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$readFully$1
            r0.<init>(r12)
        L19:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "Channel is already closed"
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            byte[] r10 = (byte[]) r10
            java.lang.Object r11 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r11 = (io.ktor.utils.io.ByteReadChannel) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L76
        L38:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L40:
            kotlin.ResultKt.throwOnFailure(r12)
            if (r11 <= r10) goto L52
            boolean r12 = r8.isClosedForRead()
            if (r12 != 0) goto L4c
            goto L52
        L4c:
            java.io.EOFException r8 = new java.io.EOFException
            r8.<init>(r3)
            throw r8
        L52:
            if (r10 >= r11) goto La0
            kotlinx.io.Source r12 = r8.getReadBuffer()
            boolean r12 = r12.exhausted()
            if (r12 == 0) goto L7b
            r0.L$0 = r8
            r0.L$1 = r9
            r0.I$0 = r11
            r0.I$1 = r10
            r0.label = r4
            r12 = 0
            r2 = 0
            java.lang.Object r12 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.awaitContent$default(r8, r12, r0, r4, r2)
            if (r12 != r1) goto L71
            return r1
        L71:
            r7 = r11
            r11 = r8
            r8 = r10
            r10 = r9
            r9 = r7
        L76:
            r7 = r10
            r10 = r8
            r8 = r11
            r11 = r9
            r9 = r7
        L7b:
            boolean r12 = r8.isClosedForRead()
            if (r12 != 0) goto L9a
            int r12 = r11 - r10
            kotlinx.io.Source r2 = r8.getReadBuffer()
            long r5 = io.ktor.utils.io.core.ByteReadPacketKt.getRemaining(r2)
            int r2 = (int) r5
            int r12 = java.lang.Math.min(r12, r2)
            kotlinx.io.Source r2 = r8.getReadBuffer()
            int r12 = r12 + r10
            kotlinx.io.SourcesKt.readTo(r2, r9, r10, r12)
            r10 = r12
            goto L52
        L9a:
            java.io.EOFException r8 = new java.io.EOFException
            r8.<init>(r3)
            throw r8
        La0:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.readFully(io.ktor.utils.io.ByteReadChannel, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object readFully$default(ByteReadChannel byteReadChannel, byte[] bArr, int i, int i2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return readFully(byteReadChannel, bArr, i, i2, continuation);
    }

    public static final void rethrowCloseCauseIfNeeded(ByteReadChannel byteReadChannel) throws Throwable {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Throwable closedCause = byteReadChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static final void rethrowCloseCauseIfNeeded(ByteWriteChannel byteWriteChannel) throws Throwable {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        Throwable closedCause = byteWriteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static final void rethrowCloseCauseIfNeeded(ByteChannel byteChannel) {
        Intrinsics.checkNotNullParameter(byteChannel, "<this>");
        Throwable closedCause = byteChannel.getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    public static /* synthetic */ Object readUntil$default(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Long.MAX_VALUE;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            z = false;
        }
        return readUntil(byteReadChannel, byteString, byteWriteChannel, j2, z, continuation);
    }

    public static final Object readUntil(ByteReadChannel byteReadChannel, ByteString byteString, ByteWriteChannel byteWriteChannel, long j, boolean z, Continuation<? super Long> continuation) {
        return new ByteChannelScanner(byteReadChannel, byteString, byteWriteChannel, j).findNext$ktor_io(z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object skipIfFound(io.ktor.utils.io.ByteReadChannel r5, kotlinx.io.bytestring.ByteString r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33521
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33521) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$skipIfFound$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            java.lang.Object r5 = r0.L$1
            r6 = r5
            kotlinx.io.bytestring.ByteString r6 = (kotlinx.io.bytestring.ByteString) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L56
        L42:
            kotlin.ResultKt.throwOnFailure(r7)
            int r7 = r6.getSize()
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = peek(r5, r7, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r6)
            if (r7 == 0) goto L74
            int r6 = r6.getSize()
            long r6 = (long) r6
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r5 = discard(r5, r6, r0)
            if (r5 != r1) goto L6f
            return r1
        L6f:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r5
        L74:
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.skipIfFound(io.ktor.utils.io.ByteReadChannel, kotlinx.io.bytestring.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object peek(io.ktor.utils.io.ByteReadChannel r5, int r6, kotlin.coroutines.Continuation<? super kotlinx.io.bytestring.ByteString> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteReadChannelOperationsKt.C33341
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1 r0 = (io.ktor.utils.io.ByteReadChannelOperationsKt.C33341) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1 r0 = new io.ktor.utils.io.ByteReadChannelOperationsKt$peek$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 != r4) goto L31
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteReadChannel r5 = (io.ktor.utils.io.ByteReadChannel) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L50
        L31:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r5.isClosedForRead()
            if (r7 == 0) goto L43
            return r3
        L43:
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitContent(r6, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L59
            return r3
        L59:
            kotlinx.io.Source r5 = r5.getReadBuffer()
            kotlinx.io.Source r5 = r5.peek()
            kotlinx.io.bytestring.ByteString r5 = kotlinx.io.ByteStringsKt.readByteString(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteReadChannelOperationsKt.peek(io.ktor.utils.io.ByteReadChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
