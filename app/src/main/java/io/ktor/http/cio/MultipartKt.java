package io.ktor.http.cio;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import io.ktor.http.ContentType;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.http.cio.internals.UnsupportedMediaTypeExceptionCIO;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.StringsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.io.bytestring.ByteString;
import kotlinx.io.bytestring.ByteStringKt;

/* JADX INFO: compiled from: Multipart.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\u001a2\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\b\u0010\t\u001a\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@¢\u0006\u0004\b\u000b\u0010\f\u001a8\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u0012\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0000H\u0082@¢\u0006\u0004\b\u0012\u0010\u0013\u001a1\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u001d\u001a;\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016*\u00020\u00142\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u001f\u001a\u0017\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b!\u0010\"\u001a\u0017\u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b$\u0010%\u001a\u001f\u0010(\u001a\u00020'2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010)\"\u0014\u0010*\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+\"\u0014\u0010-\u001a\u00020,8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010.\"\u0014\u0010/\u001a\u00020\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010+¨\u00060"}, d2 = {"Lkotlinx/io/bytestring/ByteString;", "boundary", "Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/utils/io/ByteWriteChannel;", "output", "", "limit", "parsePreambleImpl", "(Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/HttpHeadersMap;", "parsePartHeadersImpl", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boundaryPrefixed", "headers", "parsePartBodyImpl", "(Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/utils/io/ByteWriteChannel;Lio/ktor/http/cio/HttpHeadersMap;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prefix", "skipIfFoundReadCount", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlinx/io/bytestring/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineScope;", "maxPartSize", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lio/ktor/http/cio/MultipartEvent;", "parseMultipart", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/cio/HttpHeadersMap;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "", "contentType", "contentLength", "(Lkotlinx/coroutines/CoroutineScope;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/CharSequence;Ljava/lang/Long;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "totalLength", "(Lkotlinx/coroutines/CoroutineScope;Lkotlinx/io/bytestring/ByteString;Lio/ktor/utils/io/ByteReadChannel;Ljava/lang/Long;J)Lkotlinx/coroutines/channels/ReceiveChannel;", "", "findBoundary", "(Ljava/lang/CharSequence;)I", "", "parseBoundaryInternal", "(Ljava/lang/CharSequence;)[B", "actual", "", "throwLimitExceeded", "(JJ)Ljava/lang/Void;", "CrLf", "Lkotlinx/io/bytestring/ByteString;", "", "PrefixChar", "B", "PrefixString", "ktor-http-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MultipartKt {
    private static final ByteString CrLf = new ByteString(StringsKt.toByteArray$default(ServerSentEventKt.END_OF_LINE, null, 1, null), 0, 0, 6, null);
    private static final byte PrefixChar = 45;
    private static final ByteString PrefixString = ByteStringKt.ByteString(PrefixChar, PrefixChar);

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$parsePartBodyImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0, 1, 1, 1, 2, 3}, l = {132, 133, 133, 136}, m = "parsePartBodyImpl", n = {"output", "boundaryPrefixed", "input", "output", "output", "byteCount"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "J$0"})
    static final class C33071 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C33071(Continuation<? super C33071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.parsePartBodyImpl(null, null, null, null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0}, l = {113}, m = "parsePartHeadersImpl", n = {"builder"}, s = {"L$0"})
    static final class C33081 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33081(Continuation<? super C33081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.parsePartHeadersImpl(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt", f = "Multipart.kt", i = {0}, l = {143}, m = "skipIfFoundReadCount", n = {"prefix"}, s = {"L$0"})
    static final class C33091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C33091(Continuation<? super C33091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MultipartKt.skipIfFoundReadCount(null, null, this);
        }
    }

    static /* synthetic */ Object parsePreambleImpl$default(ByteString byteString, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            j = Long.MAX_VALUE;
        }
        return parsePreambleImpl(byteString, byteReadChannel, byteWriteChannel, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object parsePreambleImpl(ByteString byteString, ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, long j, Continuation<? super Long> continuation) {
        return ByteReadChannelOperationsKt.readUntil(byteReadChannel, byteString, byteWriteChannel, j, true, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object parsePartHeadersImpl(io.ktor.utils.io.ByteReadChannel r8, kotlin.coroutines.Continuation<? super io.ktor.http.cio.HttpHeadersMap> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.http.cio.MultipartKt.C33081
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1 r0 = (io.ktor.http.cio.MultipartKt.C33081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1 r0 = new io.ktor.http.cio.MultipartKt$parsePartHeadersImpl$1
            r0.<init>(r9)
        L19:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r8 = r4.L$0
            io.ktor.http.cio.internals.CharArrayBuilder r8 = (io.ktor.http.cio.internals.CharArrayBuilder) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L2f
            goto L55
        L2f:
            r9 = move-exception
            goto L66
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.http.cio.internals.CharArrayBuilder r9 = new io.ktor.http.cio.internals.CharArrayBuilder
            r1 = 0
            r9.<init>(r1, r2, r1)
            r4.L$0 = r9     // Catch: java.lang.Throwable -> L62
            r4.label = r2     // Catch: java.lang.Throwable -> L62
            r3 = 0
            r5 = 4
            r6 = 0
            r1 = r8
            r2 = r9
            java.lang.Object r8 = io.ktor.http.cio.HttpParserKt.parseHeaders$default(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L62
            if (r8 != r0) goto L52
            return r0
        L52:
            r7 = r9
            r9 = r8
            r8 = r7
        L55:
            io.ktor.http.cio.HttpHeadersMap r9 = (io.ktor.http.cio.HttpHeadersMap) r9     // Catch: java.lang.Throwable -> L2f
            if (r9 == 0) goto L5a
            return r9
        L5a:
            java.io.EOFException r9 = new java.io.EOFException     // Catch: java.lang.Throwable -> L2f
            java.lang.String r0 = "Failed to parse multipart headers: unexpected end of stream"
            r9.<init>(r0)     // Catch: java.lang.Throwable -> L2f
            throw r9     // Catch: java.lang.Throwable -> L2f
        L62:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L66:
            r8.release()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.parsePartHeadersImpl(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00df A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object parsePartBodyImpl(kotlinx.io.bytestring.ByteString r15, io.ktor.utils.io.ByteReadChannel r16, io.ktor.utils.io.ByteWriteChannel r17, io.ktor.http.cio.HttpHeadersMap r18, long r19, kotlin.coroutines.Continuation<? super java.lang.Long> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.parsePartBodyImpl(kotlinx.io.bytestring.ByteString, io.ktor.utils.io.ByteReadChannel, io.ktor.utils.io.ByteWriteChannel, io.ktor.http.cio.HttpHeadersMap, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object skipIfFoundReadCount(io.ktor.utils.io.ByteReadChannel r4, kotlinx.io.bytestring.ByteString r5, kotlin.coroutines.Continuation<? super java.lang.Long> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.http.cio.MultipartKt.C33091
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1 r0 = (io.ktor.http.cio.MultipartKt.C33091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1 r0 = new io.ktor.http.cio.MultipartKt$skipIfFoundReadCount$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.L$0
            r5 = r4
            kotlinx.io.bytestring.ByteString r5 = (kotlinx.io.bytestring.ByteString) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = io.ktor.utils.io.ByteReadChannelOperationsKt.skipIfFound(r4, r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r4 = r6.booleanValue()
            if (r4 == 0) goto L53
            int r4 = r5.getSize()
            long r4 = (long) r4
            goto L55
        L53:
            r4 = 0
        L55:
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.skipIfFoundReadCount(io.ktor.utils.io.ByteReadChannel, kotlinx.io.bytestring.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ ReceiveChannel parseMultipart$default(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, HttpHeadersMap httpHeadersMap, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = Long.MAX_VALUE;
        }
        return parseMultipart(coroutineScope, byteReadChannel, httpHeadersMap, j);
    }

    public static final ReceiveChannel<MultipartEvent> parseMultipart(CoroutineScope coroutineScope, ByteReadChannel input, HttpHeadersMap headers, long j) throws UnsupportedMediaTypeExceptionCIO {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(headers, "headers");
        CharSequence charSequence = headers.get("Content-Type");
        if (charSequence == null) {
            throw new UnsupportedMediaTypeExceptionCIO("Failed to parse multipart: no Content-Type header");
        }
        CharSequence charSequence2 = headers.get(HttpHeaders.CONTENT_LENGTH);
        return parseMultipart(coroutineScope, input, charSequence, charSequence2 != null ? Long.valueOf(CharsKt.parseDecLong(charSequence2)) : null, j);
    }

    public static /* synthetic */ ReceiveChannel parseMultipart$default(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, CharSequence charSequence, Long l, long j, int i, Object obj) {
        if ((i & 8) != 0) {
            j = Long.MAX_VALUE;
        }
        return parseMultipart(coroutineScope, byteReadChannel, charSequence, l, j);
    }

    public static final ReceiveChannel<MultipartEvent> parseMultipart(CoroutineScope coroutineScope, ByteReadChannel input, CharSequence contentType, Long l, long j) throws UnsupportedMediaTypeExceptionCIO {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        if (!ContentType.MultiPart.INSTANCE.contains(contentType)) {
            throw new UnsupportedMediaTypeExceptionCIO("Failed to parse multipart: Content-Type should be multipart/* but it is " + ((Object) contentType));
        }
        return parseMultipart(coroutineScope, new ByteString(parseBoundaryInternal(contentType), 0, 0, 6, null), input, l, j);
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.MultipartKt$parseMultipart$1, reason: invalid class name */
    /* JADX INFO: compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lio/ktor/http/cio/MultipartEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.MultipartKt$parseMultipart$1", f = "Multipart.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 12}, l = {208, 211, 214, 215, 218, 225, 229, 236, 248, 249, 256, 256, 259, 261}, m = "invokeSuspend", n = {"$this$produce", "countedInput", "firstBoundary", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", TtmlNode.TAG_BODY, "headers", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", TtmlNode.TAG_BODY, "headers", "readBeforeParse", "$this$produce", "countedInput", "firstBoundary", TtmlNode.TAG_BODY, "headers", "headersMap", "readBeforeParse", "$this$produce", "countedInput", "readBeforeParse", "$this$produce", "countedInput", "readBeforeParse", "$this$produce"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "J$0", "L$0", "L$1", "J$0", "L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ProducerScope<? super MultipartEvent>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ByteString $boundaryPrefixed;
        final /* synthetic */ ByteReadChannel $input;
        final /* synthetic */ long $maxPartSize;
        final /* synthetic */ Long $totalLength;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ByteReadChannel byteReadChannel, ByteString byteString, long j, Long l, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$input = byteReadChannel;
            this.$boundaryPrefixed = byteString;
            this.$maxPartSize = j;
            this.$totalLength = l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$input, this.$boundaryPrefixed, this.$maxPartSize, this.$totalLength, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ProducerScope<? super MultipartEvent> producerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x0367 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:105:0x0370  */
        /* JADX WARN: Removed duplicated region for block: B:110:0x038c  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01b6  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x01e0  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0216 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x021f  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0221  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0274 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0275  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x0285 A[Catch: all -> 0x0079, TRY_LEAVE, TryCatch #0 {all -> 0x0079, blocks: (B:12:0x006e, B:65:0x027f, B:67:0x0285, B:74:0x02c0, B:75:0x02ca), top: B:115:0x006e }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x02c0 A[Catch: all -> 0x0079, TRY_ENTER, TryCatch #0 {all -> 0x0079, blocks: (B:12:0x006e, B:65:0x027f, B:67:0x0285, B:74:0x02c0, B:75:0x02ca), top: B:115:0x006e }] */
        /* JADX WARN: Removed duplicated region for block: B:80:0x02d3 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0301 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0302  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x031e A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0323  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x021f -> B:39:0x01b0). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x02b1 -> B:13:0x0071). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r28) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 966
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private static final ReceiveChannel<MultipartEvent> parseMultipart(CoroutineScope coroutineScope, ByteString byteString, ByteReadChannel byteReadChannel, Long l, long j) {
        return ProduceKt.produce$default(coroutineScope, null, 0, new AnonymousClass1(byteReadChannel, byteString, j, l, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int findBoundary(java.lang.CharSequence r12) {
        /*
            int r0 = r12.length()
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
        L8:
            if (r2 >= r0) goto L5f
            char r5 = r12.charAt(r2)
            r6 = 59
            r7 = 1
            if (r3 == 0) goto L58
            r8 = 44
            r9 = 2
            if (r3 == r7) goto L37
            r10 = 34
            r11 = 3
            if (r3 == r9) goto L2e
            r6 = 4
            if (r3 == r11) goto L25
            if (r3 == r6) goto L23
            goto L5c
        L23:
            r3 = r11
            goto L5c
        L25:
            if (r5 == r10) goto L5a
            r7 = 92
            if (r5 == r7) goto L2c
            goto L5c
        L2c:
            r3 = r6
            goto L5c
        L2e:
            if (r5 == r10) goto L23
            if (r5 == r8) goto L35
            if (r5 == r6) goto L5a
            goto L5c
        L35:
            r3 = r1
            goto L5c
        L37:
            r10 = 61
            if (r5 != r10) goto L3d
            r3 = r9
            goto L5c
        L3d:
            if (r5 != r6) goto L41
            r4 = r1
            goto L5c
        L41:
            if (r5 != r8) goto L44
            goto L35
        L44:
            r6 = 32
            if (r5 == r6) goto L5c
            if (r4 != 0) goto L55
            java.lang.String r5 = "boundary="
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = kotlin.text.StringsKt.startsWith(r12, r5, r2, r7)
            if (r5 == 0) goto L55
            return r2
        L55:
            int r4 = r4 + 1
            goto L5c
        L58:
            if (r5 != r6) goto L5c
        L5a:
            r4 = r1
            r3 = r7
        L5c:
            int r2 = r2 + 1
            goto L8
        L5f:
            r12 = -1
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.MultipartKt.findBoundary(java.lang.CharSequence):int");
    }

    public static final byte[] parseBoundaryInternal(CharSequence contentType) throws IOException {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        int iFindBoundary = findBoundary(contentType);
        if (iFindBoundary == -1) {
            throw new IOException("Failed to parse multipart: Content-Type's boundary parameter is missing");
        }
        byte[] bArr = new byte[74];
        Ref.IntRef intRef = new Ref.IntRef();
        parseBoundaryInternal$put(intRef, bArr, Ascii.CR);
        parseBoundaryInternal$put(intRef, bArr, (byte) 10);
        parseBoundaryInternal$put(intRef, bArr, PrefixChar);
        parseBoundaryInternal$put(intRef, bArr, PrefixChar);
        int length = contentType.length();
        char c = 0;
        for (int i = iFindBoundary + 9; i < length; i++) {
            char cCharAt = contentType.charAt(i);
            int i2 = cCharAt & CharCompanionObject.MAX_VALUE;
            if ((65535 & cCharAt) > 127) {
                StringBuilder sb = new StringBuilder("Failed to parse multipart: wrong boundary byte 0x");
                String string = Integer.toString(i2, kotlin.text.CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                sb.append(string);
                sb.append(" - should be 7bit character");
                throw new IOException(sb.toString());
            }
            if (c != 0) {
                if (c == 1) {
                    if (cCharAt == ' ' || cCharAt == ',' || cCharAt == ';') {
                        break;
                    }
                    parseBoundaryInternal$put(intRef, bArr, (byte) i2);
                } else if (c == 2) {
                    if (cCharAt == '\"') {
                        break;
                    }
                    if (cCharAt != '\\') {
                        parseBoundaryInternal$put(intRef, bArr, (byte) i2);
                    } else {
                        c = 3;
                    }
                } else if (c == 3) {
                    parseBoundaryInternal$put(intRef, bArr, (byte) i2);
                    c = 2;
                }
            } else if (cCharAt == ' ') {
                continue;
            } else if (cCharAt == '\"') {
                c = 2;
            } else {
                if (cCharAt == ',' || cCharAt == ';') {
                    break;
                }
                parseBoundaryInternal$put(intRef, bArr, (byte) i2);
                c = 1;
            }
        }
        if (intRef.element == 4) {
            throw new IOException("Empty multipart boundary is not allowed");
        }
        return ArraysKt.copyOfRange(bArr, 0, intRef.element);
    }

    private static final void parseBoundaryInternal$put(Ref.IntRef intRef, byte[] bArr, byte b) throws IOException {
        if (intRef.element >= bArr.length) {
            throw new IOException("Failed to parse multipart: boundary shouldn't be longer than 70 characters");
        }
        int i = intRef.element;
        intRef.element = i + 1;
        bArr[i] = b;
    }

    private static final Void throwLimitExceeded(long j, long j2) throws IOException {
        throw new IOException("Multipart content length exceeds limit " + j + " > " + j2 + "; limit is defined using 'formFieldLimit' argument");
    }
}
