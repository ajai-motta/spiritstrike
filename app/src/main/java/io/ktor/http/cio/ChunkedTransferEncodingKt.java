package io.ktor.http.cio;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import io.ktor.http.ContentDisposition;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.ReaderJob;
import io.ktor.utils.io.ReaderScope;
import io.ktor.utils.io.WriterJob;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.DefaultPool;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\u001a\u001f\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\t\u001a \u0010\u0005\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0005\u0010\r\u001a!\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u0013\u0010\u0016\u001a\u00020\f*\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a,\u0010\u001d\u001a\u00020\u001a*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0082@¢\u0006\u0004\b\u001d\u0010\u001e\"\u0014\u0010\u001f\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 \"\u001e\u0010%\u001a\f\u0012\b\u0012\u00060#j\u0002`$0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&\"\u0014\u0010(\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010,\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+*\n\u0010-\"\u00020\u00032\u00020\u0003*\n\u0010.\"\u00020\u00112\u00020\u0011¨\u0006/"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/WriterJob;", "Lio/ktor/http/cio/DecoderJob;", "decodeChunked", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/utils/io/WriterJob;", "", "contentLength", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;J)Lio/ktor/utils/io/WriterJob;", "Lio/ktor/utils/io/ByteWriteChannel;", "out", "", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "output", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lio/ktor/utils/io/ReaderJob;", "Lio/ktor/http/cio/EncoderJob;", "encodeChunked", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/utils/io/ReaderJob;", "(Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rethrowCloseCause", "(Lio/ktor/utils/io/ByteReadChannel;)V", "", "memory", "", "startIndex", "endIndex", "writeChunk", "(Lio/ktor/utils/io/ByteWriteChannel;[BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "MAX_CHUNK_SIZE_LENGTH", "I", "CHUNK_BUFFER_POOL_SIZE", "Lio/ktor/utils/io/pool/ObjectPool;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "ChunkSizeBufferPool", "Lio/ktor/utils/io/pool/ObjectPool;", "", "CrLfShort", ExifInterface.LATITUDE_SOUTH, "CrLf", "[B", "LastChunkBytes", "DecoderJob", "EncoderJob", "ktor-http-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ChunkedTransferEncodingKt {
    private static final int CHUNK_BUFFER_POOL_SIZE = 2048;
    private static final short CrLfShort = 3338;
    private static final int MAX_CHUNK_SIZE_LENGTH = 128;
    private static final ObjectPool<StringBuilder> ChunkSizeBufferPool = new DefaultPool<StringBuilder>() { // from class: io.ktor.http.cio.ChunkedTransferEncodingKt$ChunkSizeBufferPool$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.io.pool.DefaultPool
        public StringBuilder produceInstance() {
            return new StringBuilder(128);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.ktor.utils.io.pool.DefaultPool
        public StringBuilder clearInstance(StringBuilder instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            StringsKt.clear(instance);
            return instance;
        }
    };
    private static final byte[] CrLf = io.ktor.utils.io.core.StringsKt.toByteArray$default(ServerSentEventKt.END_OF_LINE, null, 1, null);
    private static final byte[] LastChunkBytes = io.ktor.utils.io.core.StringsKt.toByteArray$default("0\r\n\r\n", null, 1, null);

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$2, reason: invalid class name */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {72, 81, 82, 87, 101, 101}, m = "decodeChunked", n = {"input", "out", "chunkSizeBuffer", "totalBytesCopied", "input", "out", "chunkSizeBuffer", "totalBytesCopied", "chunkSize", "input", "out", "chunkSizeBuffer", "totalBytesCopied", "chunkSize", "input", "out", "chunkSizeBuffer", "totalBytesCopied", "chunkSize"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "J$1"})
    static final class AnonymousClass2 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.decodeChunked((ByteReadChannel) null, (ByteWriteChannel) null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2}, l = {175, TsExtractor.TS_STREAM_TYPE_E_AC3, 140, 146, 146}, m = "encodeChunked", n = {"output", "input", "$this$read$iv", "output", "input", "result$iv", "buffer$iv$iv", "head$iv$iv", "output", "input"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"})
    static final class C33032 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C33032(Continuation<? super C33032> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.encodeChunked(null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$writeChunk$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt", f = "ChunkedTransferEncoding.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 3, 3, 4}, l = {164, 165, 167, 168, 169}, m = "writeChunk", n = {"$this$writeChunk", "memory", "startIndex", "endIndex", ContentDisposition.Parameters.Size, "$this$writeChunk", "memory", "startIndex", "endIndex", ContentDisposition.Parameters.Size, "$this$writeChunk", ContentDisposition.Parameters.Size, "$this$writeChunk", ContentDisposition.Parameters.Size, ContentDisposition.Parameters.Size}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "I$0", "L$0", "I$0", "I$0"})
    static final class C33041 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C33041(Continuation<? super C33041> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ChunkedTransferEncodingKt.writeChunk(null, null, 0, 0, this);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Specify content length if known or pass -1L", replaceWith = @ReplaceWith(expression = "decodeChunked(input, -1L)", imports = {}))
    public static final WriterJob decodeChunked(CoroutineScope coroutineScope, ByteReadChannel input) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        return decodeChunked(coroutineScope, input, -1L);
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$1, reason: invalid class name */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$decodeChunked$1", f = "ChunkedTransferEncoding.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteReadChannel $input;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteReadChannel byteReadChannel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                WriterScope writerScope = (WriterScope) this.L$0;
                this.label = 1;
                if (ChunkedTransferEncodingKt.decodeChunked(this.$input, writerScope.getChannel(), this) == coroutine_suspended) {
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

    public static final WriterJob decodeChunked(CoroutineScope coroutineScope, ByteReadChannel input, long j) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        return ByteWriteChannelOperationsKt.writer$default(coroutineScope, coroutineScope.getCoroutineContext(), false, (Function2) new AnonymousClass1(input, null), 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8 A[Catch: all -> 0x009b, TryCatch #2 {all -> 0x009b, blocks: (B:15:0x0051, B:34:0x00d0, B:36:0x00d8, B:38:0x00e1, B:40:0x00e7, B:46:0x00fd, B:50:0x0116, B:43:0x00f2, B:73:0x01a2, B:74:0x01a9, B:19:0x006e, B:22:0x0083, B:25:0x0097), top: B:93:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0129 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0155 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0165 A[Catch: all -> 0x01c2, TryCatch #0 {all -> 0x01c2, blocks: (B:59:0x015d, B:61:0x0165, B:30:0x00b0, B:67:0x017b, B:68:0x0182, B:69:0x0183, B:70:0x019e), top: B:90:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0183 A[Catch: all -> 0x01c2, TryCatch #0 {all -> 0x01c2, blocks: (B:59:0x015d, B:61:0x0165, B:30:0x00b0, B:67:0x017b, B:68:0x0182, B:69:0x0183, B:70:0x019e), top: B:90:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0156 -> B:17:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object decodeChunked(io.ktor.utils.io.ByteReadChannel r18, io.ktor.utils.io.ByteWriteChannel r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 500
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.decodeChunked(io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ChunkedTransferEncoding.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/ReaderScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.ChunkedTransferEncodingKt$encodeChunked$1", f = "ChunkedTransferEncoding.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    static final class C33021 extends SuspendLambda implements Function2<ReaderScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteWriteChannel $output;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C33021(ByteWriteChannel byteWriteChannel, Continuation<? super C33021> continuation) {
            super(2, continuation);
            this.$output = byteWriteChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C33021 c33021 = new C33021(this.$output, continuation);
            c33021.L$0 = obj;
            return c33021;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ReaderScope readerScope, Continuation<? super Unit> continuation) {
            return ((C33021) create(readerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ReaderScope readerScope = (ReaderScope) this.L$0;
                this.label = 1;
                if (ChunkedTransferEncodingKt.encodeChunked(this.$output, readerScope.getChannel(), this) == coroutine_suspended) {
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

    public static final ReaderJob encodeChunked(ByteWriteChannel output, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return ByteReadChannelOperationsKt.reader((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2<? super ReaderScope, ? super Continuation<? super Unit>, ? extends Object>) new C33021(output, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1 A[Catch: all -> 0x01b2, TryCatch #0 {all -> 0x01b2, blocks: (B:35:0x009b, B:37:0x00a1, B:39:0x00a7, B:41:0x00b1, B:78:0x017c), top: B:97:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00d7 A[Catch: all -> 0x0177, TryCatch #2 {all -> 0x0177, blocks: (B:47:0x00d1, B:49:0x00d7, B:51:0x00ed, B:53:0x0106, B:54:0x010f, B:73:0x0167, B:74:0x0172), top: B:100:0x00d1 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ae A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0106 -> B:99:0x0132). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0124 -> B:58:0x012c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0173 -> B:97:0x009b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object encodeChunked(io.ktor.utils.io.ByteWriteChannel r21, io.ktor.utils.io.ByteReadChannel r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.encodeChunked(io.ktor.utils.io.ByteWriteChannel, io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final void rethrowCloseCause(ByteReadChannel byteReadChannel) throws Throwable {
        Throwable closedCause = byteReadChannel instanceof ByteChannel ? ((ByteChannel) byteReadChannel).getClosedCause() : null;
        if (closedCause != null) {
            throw closedCause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object writeChunk(io.ktor.utils.io.ByteWriteChannel r16, byte[] r17, int r18, int r19, kotlin.coroutines.Continuation<? super java.lang.Integer> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.ChunkedTransferEncodingKt.writeChunk(io.ktor.utils.io.ByteWriteChannel, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
