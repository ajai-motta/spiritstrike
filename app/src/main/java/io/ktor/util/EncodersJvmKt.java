package io.ktor.util;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: EncodersJvm.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0082\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a,\u0010\u0013\u001a\u00020\u0000*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0017\u0010\u001c\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001b¨\u0006\u001e"}, d2 = {"", "flag", "", "has", "(II)Z", "Lio/ktor/utils/io/ByteReadChannel;", "source", "gzip", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "inflate", "(Lio/ktor/utils/io/ByteReadChannel;ZLkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ByteReadChannel;", "Ljava/util/zip/Inflater;", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "Ljava/nio/ByteBuffer;", "buffer", "Ljava/util/zip/Checksum;", "checksum", "inflateTo", "(Ljava/util/zip/Inflater;Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;Ljava/util/zip/Checksum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "GZIP_HEADER_SIZE", "I", "Lio/ktor/util/Encoder;", "Deflate", "Lio/ktor/util/Encoder;", "getDeflate", "()Lio/ktor/util/Encoder;", "GZip", "getGZip", "ktor-utils"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class EncodersJvmKt {
    private static final int GZIP_HEADER_SIZE = 10;
    private static final Encoder Deflate = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$Deflate$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(ByteReadChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, false, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteWriteChannel encode(ByteWriteChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, false, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(ByteReadChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return EncodersJvmKt.inflate(source, false, coroutineContext);
        }
    };
    private static final Encoder GZip = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$GZip$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(ByteReadChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteWriteChannel encode(ByteWriteChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineContext, 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(ByteReadChannel source, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
            return EncodersJvmKt.inflate$default(source, false, coroutineContext, 2, null);
        }
    };

    /* JADX INFO: renamed from: io.ktor.util.EncodersJvmKt$inflateTo$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EncodersJvm.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", i = {0}, l = {171}, m = "inflateTo", n = {"inflated"}, s = {"I$0"})
    static final class C33221 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C33221(Continuation<? super C33221> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EncodersJvmKt.inflateTo(null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean has(int i, int i2) {
        return (i & i2) != 0;
    }

    public static final Encoder getDeflate() {
        return Deflate;
    }

    public static final Encoder getGZip() {
        return GZip;
    }

    static /* synthetic */ ByteReadChannel inflate$default(ByteReadChannel byteReadChannel, boolean z, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return inflate(byteReadChannel, z, coroutineContext);
    }

    /* JADX INFO: renamed from: io.ktor.util.EncodersJvmKt$inflate$1, reason: invalid class name */
    /* JADX INFO: compiled from: EncodersJvm.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.EncodersJvmKt$inflate$1", f = "EncodersJvm.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {82, 99, 100, 110, 117, 123, TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend", n = {"$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ ByteReadChannel $source;
        byte B$0;
        byte B$1;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        short S$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, ByteReadChannel byteReadChannel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$gzip = z;
            this.$source = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$gzip, this.$source, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x01ac A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01b9  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01c1  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0235  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0261 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:7:0x0034, B:92:0x032f, B:86:0x0302, B:88:0x0308, B:93:0x0346, B:95:0x034a, B:97:0x0352, B:99:0x0370, B:102:0x0375, B:103:0x0399, B:104:0x039a, B:105:0x03a5, B:106:0x03a6, B:107:0x03c9, B:108:0x03ca, B:113:0x03e5, B:114:0x03ec, B:72:0x0299, B:74:0x029f, B:76:0x02a5, B:82:0x02ef, B:64:0x0259, B:66:0x0261, B:69:0x027f, B:71:0x0287, B:83:0x02f4, B:85:0x02fc, B:115:0x03ed, B:15:0x0083), top: B:126:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0287 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:7:0x0034, B:92:0x032f, B:86:0x0302, B:88:0x0308, B:93:0x0346, B:95:0x034a, B:97:0x0352, B:99:0x0370, B:102:0x0375, B:103:0x0399, B:104:0x039a, B:105:0x03a5, B:106:0x03a6, B:107:0x03c9, B:108:0x03ca, B:113:0x03e5, B:114:0x03ec, B:72:0x0299, B:74:0x029f, B:76:0x02a5, B:82:0x02ef, B:64:0x0259, B:66:0x0261, B:69:0x027f, B:71:0x0287, B:83:0x02f4, B:85:0x02fc, B:115:0x03ed, B:15:0x0083), top: B:126:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x029f A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:7:0x0034, B:92:0x032f, B:86:0x0302, B:88:0x0308, B:93:0x0346, B:95:0x034a, B:97:0x0352, B:99:0x0370, B:102:0x0375, B:103:0x0399, B:104:0x039a, B:105:0x03a5, B:106:0x03a6, B:107:0x03c9, B:108:0x03ca, B:113:0x03e5, B:114:0x03ec, B:72:0x0299, B:74:0x029f, B:76:0x02a5, B:82:0x02ef, B:64:0x0259, B:66:0x0261, B:69:0x027f, B:71:0x0287, B:83:0x02f4, B:85:0x02fc, B:115:0x03ed, B:15:0x0083), top: B:126:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:83:0x02f4 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:7:0x0034, B:92:0x032f, B:86:0x0302, B:88:0x0308, B:93:0x0346, B:95:0x034a, B:97:0x0352, B:99:0x0370, B:102:0x0375, B:103:0x0399, B:104:0x039a, B:105:0x03a5, B:106:0x03a6, B:107:0x03c9, B:108:0x03ca, B:113:0x03e5, B:114:0x03ec, B:72:0x0299, B:74:0x029f, B:76:0x02a5, B:82:0x02ef, B:64:0x0259, B:66:0x0261, B:69:0x027f, B:71:0x0287, B:83:0x02f4, B:85:0x02fc, B:115:0x03ed, B:15:0x0083), top: B:126:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0308 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:7:0x0034, B:92:0x032f, B:86:0x0302, B:88:0x0308, B:93:0x0346, B:95:0x034a, B:97:0x0352, B:99:0x0370, B:102:0x0375, B:103:0x0399, B:104:0x039a, B:105:0x03a5, B:106:0x03a6, B:107:0x03c9, B:108:0x03ca, B:113:0x03e5, B:114:0x03ec, B:72:0x0299, B:74:0x029f, B:76:0x02a5, B:82:0x02ef, B:64:0x0259, B:66:0x0261, B:69:0x027f, B:71:0x0287, B:83:0x02f4, B:85:0x02fc, B:115:0x03ed, B:15:0x0083), top: B:126:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0346 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:7:0x0034, B:92:0x032f, B:86:0x0302, B:88:0x0308, B:93:0x0346, B:95:0x034a, B:97:0x0352, B:99:0x0370, B:102:0x0375, B:103:0x0399, B:104:0x039a, B:105:0x03a5, B:106:0x03a6, B:107:0x03c9, B:108:0x03ca, B:113:0x03e5, B:114:0x03ec, B:72:0x0299, B:74:0x029f, B:76:0x02a5, B:82:0x02ef, B:64:0x0259, B:66:0x0261, B:69:0x027f, B:71:0x0287, B:83:0x02f4, B:85:0x02fc, B:115:0x03ed, B:15:0x0083), top: B:126:0x000b }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0285 -> B:64:0x0259). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0287 -> B:72:0x0299). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x02cb -> B:80:0x02d3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:91:0x032e -> B:92:0x032f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1050
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.EncodersJvmKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel inflate(ByteReadChannel byteReadChannel, boolean z, CoroutineContext coroutineContext) {
        return ByteWriteChannelOperationsKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2) new AnonymousClass1(z, byteReadChannel, null), 2, (Object) null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object inflateTo(java.util.zip.Inflater r5, io.ktor.utils.io.ByteWriteChannel r6, java.nio.ByteBuffer r7, java.util.zip.Checksum r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.util.EncodersJvmKt.C33221
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.util.EncodersJvmKt$inflateTo$1 r0 = (io.ktor.util.EncodersJvmKt.C33221) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.util.EncodersJvmKt$inflateTo$1 r0 = new io.ktor.util.EncodersJvmKt$inflateTo$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r5 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L63
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r9)
            r7.clear()
            byte[] r9 = r7.array()
            int r2 = r7.position()
            int r4 = r7.remaining()
            int r5 = r5.inflate(r9, r2, r4)
            int r9 = r7.position()
            int r9 = r9 + r5
            r7.position(r9)
            r7.flip()
            io.ktor.util.DeflaterKt.updateKeepPosition(r8, r7)
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = io.ktor.utils.io.ByteWriteChannelOperations_jvmKt.writeFully(r6, r7, r0)
            if (r6 != r1) goto L63
            return r1
        L63:
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.EncodersJvmKt.inflateTo(java.util.zip.Inflater, io.ktor.utils.io.ByteWriteChannel, java.nio.ByteBuffer, java.util.zip.Checksum, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
