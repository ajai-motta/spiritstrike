package io.ktor.http.cio;

import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.HttpMethod;
import io.ktor.http.cio.internals.AsciiCharTree;
import io.ktor.http.cio.internals.CharArrayBuilder;
import io.ktor.http.cio.internals.CharsKt;
import io.ktor.http.cio.internals.MutableRange;
import io.ktor.http.cio.internals.TokenizerKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.LineEndingMode;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.files.FileSystemKt;

/* JADX INFO: compiled from: HttpParser.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@¢\u0006\u0004\b\b\u0010\u0004\u001a,\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\b\u0010\r\u001a\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001f\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002¢\u0006\u0004\b \u0010!\u001a\u001f\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\"\u0010#\u001a/\u0010)\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b)\u0010*\u001a\u001f\u0010+\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b+\u0010,\u001a\u001f\u0010-\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b-\u0010.\u001a\u001f\u0010/\u001a\u00020(2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b/\u00100\u001a\u0017\u00101\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b1\u00102\u001a\u0017\u00104\u001a\u00020(2\u0006\u00103\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105\"\u0014\u00106\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00107\"\u0014\u00108\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00107\"\u0014\u00109\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00107\"\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020&0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<\" \u0010>\u001a\u00020=8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\b>\u00107\u0012\u0004\bA\u0010B\u001a\u0004\b?\u0010@\"\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020D0C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lio/ktor/utils/io/ByteReadChannel;", "input", "Lio/ktor/http/cio/Request;", "parseRequest", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/http/cio/Response;", "parseResponse", "Lio/ktor/http/cio/HttpHeadersMap;", "parseHeaders", "Lio/ktor/http/cio/internals/CharArrayBuilder;", "builder", "Lio/ktor/http/cio/internals/MutableRange;", "range", "(Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "host", "", "validateHostHeader", "(Ljava/lang/CharSequence;)V", "text", "Lio/ktor/http/HttpMethod;", "parseHttpMethod", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Lio/ktor/http/HttpMethod;", "parseHttpMethodFull", "parseUri", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Ljava/lang/CharSequence;", "parseVersion", "", "parseStatusCode", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)I", "code", "", "statusOutOfRange", "(I)Z", "parseHeaderName", "(Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;)I", FirebaseAnalytics.Param.INDEX, TtmlNode.START, "", "ch", "", "parseHeaderNameFailed", "(Lio/ktor/http/cio/internals/CharArrayBuilder;IIC)Ljava/lang/Void;", "parseHeaderValue", "(Lio/ktor/http/cio/internals/CharArrayBuilder;Lio/ktor/http/cio/internals/MutableRange;)V", "noColonFound", "(Ljava/lang/CharSequence;Lio/ktor/http/cio/internals/MutableRange;)Ljava/lang/Void;", "characterIsNotAllowed", "(Ljava/lang/CharSequence;C)Ljava/lang/Void;", "isDelimiter", "(C)Z", "result", "unsupportedHttpVersion", "(Ljava/lang/CharSequence;)Ljava/lang/Void;", "HTTP_LINE_LIMIT", "I", "HTTP_STATUS_CODE_MIN_RANGE", "HTTP_STATUS_CODE_MAX_RANGE", "", "hostForbiddenSymbols", "Ljava/util/Set;", "Lio/ktor/utils/io/LineEndingMode;", "httpLineEndings", "getHttpLineEndings", "()I", "getHttpLineEndings$annotations", "()V", "Lio/ktor/http/cio/internals/AsciiCharTree;", "", "versions", "Lio/ktor/http/cio/internals/AsciiCharTree;", "ktor-http-cio"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HttpParserKt {
    private static final int HTTP_LINE_LIMIT = 8192;
    private static final int HTTP_STATUS_CODE_MAX_RANGE = 999;
    private static final int HTTP_STATUS_CODE_MIN_RANGE = 100;
    private static final Set<Character> hostForbiddenSymbols = SetsKt.setOf((Object[]) new Character[]{Character.valueOf(FileSystemKt.UnixPathSeparator), '?', '#', '@'});
    private static final int httpLineEndings = LineEndingMode.m7393plus1TerO4(LineEndingMode.INSTANCE.m7398getCRLFf0jXZW8(), LineEndingMode.INSTANCE.m7399getLFf0jXZW8());
    private static final AsciiCharTree<String> versions = AsciiCharTree.INSTANCE.build(CollectionsKt.listOf((Object[]) new String[]{"HTTP/1.0", "HTTP/1.1"}));

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseHeaders$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpParser.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0}, l = {106}, m = "parseHeaders", n = {"builder"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseHeaders(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseHeaders$2, reason: invalid class name */
    /* JADX INFO: compiled from: HttpParser.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0, 0, 0}, l = {122}, m = "parseHeaders", n = {"input", "builder", "range", "headers"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseHeaders(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseRequest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpParser.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {45, 60}, m = "parseRequest", n = {"input", "builder", "range", "builder", FirebaseAnalytics.Param.METHOD, ShareConstants.MEDIA_URI, "version"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
    static final class C33051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C33051(Continuation<? super C33051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseRequest(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.http.cio.HttpParserKt$parseResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpParser.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.http.cio.HttpParserKt", f = "HttpParser.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {81, 90}, m = "parseResponse", n = {"input", "builder", "range", "builder", "version", "statusText", "statusCode"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
    static final class C33061 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C33061(Continuation<? super C33061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpParserKt.parseResponse(null, this);
        }
    }

    public static /* synthetic */ void getHttpLineEndings$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseHttpMethod$lambda$1(char c, int i) {
        return c == ' ';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseVersion$lambda$3(char c, int i) {
        return c == ' ';
    }

    private static final boolean statusOutOfRange(int i) {
        return i < 100 || i > 999;
    }

    public static final int getHttpLineEndings() {
        return httpLineEndings;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0099 A[Catch: all -> 0x0042, TryCatch #1 {all -> 0x0042, blocks: (B:13:0x003a, B:44:0x00f0, B:47:0x00f6, B:29:0x0090, B:32:0x0099, B:34:0x00aa, B:36:0x00cf, B:38:0x00d5, B:40:0x00db, B:49:0x00fe, B:50:0x0105, B:51:0x0106, B:52:0x010d, B:53:0x010e, B:54:0x0137, B:25:0x0077), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6 A[Catch: all -> 0x0042, TryCatch #1 {all -> 0x0042, blocks: (B:13:0x003a, B:44:0x00f0, B:47:0x00f6, B:29:0x0090, B:32:0x0099, B:34:0x00aa, B:36:0x00cf, B:38:0x00d5, B:40:0x00db, B:49:0x00fe, B:50:0x0105, B:51:0x0106, B:52:0x010d, B:53:0x010e, B:54:0x0137, B:25:0x0077), top: B:60:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2, types: [io.ktor.http.cio.HttpParserKt$parseRequest$1] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x008d -> B:29:0x0090). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object parseRequest(io.ktor.utils.io.ByteReadChannel r14, kotlin.coroutines.Continuation<? super io.ktor.http.cio.Request> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseRequest(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d9 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:13:0x0038, B:36:0x00d5, B:38:0x00d9, B:40:0x00e1), top: B:46:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object parseResponse(io.ktor.utils.io.ByteReadChannel r14, kotlin.coroutines.Continuation<? super io.ktor.http.cio.Response> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseResponse(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object parseHeaders(io.ktor.utils.io.ByteReadChannel r8, kotlin.coroutines.Continuation<? super io.ktor.http.cio.HttpHeadersMap> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof io.ktor.http.cio.HttpParserKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.http.cio.HttpParserKt$parseHeaders$1 r0 = (io.ktor.http.cio.HttpParserKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.http.cio.HttpParserKt$parseHeaders$1 r0 = new io.ktor.http.cio.HttpParserKt$parseHeaders$1
            r0.<init>(r9)
        L19:
            r4 = r0
            java.lang.Object r9 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r4.L$0
            io.ktor.http.cio.internals.CharArrayBuilder r8 = (io.ktor.http.cio.internals.CharArrayBuilder) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L53
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.http.cio.internals.CharArrayBuilder r9 = new io.ktor.http.cio.internals.CharArrayBuilder
            r1 = 0
            r9.<init>(r1, r2, r1)
            r4.L$0 = r9
            r4.label = r2
            r3 = 0
            r5 = 4
            r6 = 0
            r1 = r8
            r2 = r9
            java.lang.Object r8 = parseHeaders$default(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L50
            return r0
        L50:
            r7 = r9
            r9 = r8
            r8 = r7
        L53:
            io.ktor.http.cio.HttpHeadersMap r9 = (io.ktor.http.cio.HttpHeadersMap) r9
            if (r9 != 0) goto L5c
            io.ktor.http.cio.HttpHeadersMap r9 = new io.ktor.http.cio.HttpHeadersMap
            r9.<init>(r8)
        L5c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseHeaders(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0078 A[Catch: all -> 0x00cd, TryCatch #2 {all -> 0x00cd, blocks: (B:23:0x0070, B:25:0x0078, B:27:0x007d, B:30:0x0091, B:31:0x00b1, B:32:0x00bc, B:33:0x00bd, B:35:0x00c9), top: B:47:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d A[Catch: all -> 0x00cd, TryCatch #2 {all -> 0x00cd, blocks: (B:23:0x0070, B:25:0x0078, B:27:0x007d, B:30:0x0091, B:31:0x00b1, B:32:0x00bc, B:33:0x00bd, B:35:0x00c9), top: B:47:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006c -> B:47:0x0070). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object parseHeaders(io.ktor.utils.io.ByteReadChannel r11, io.ktor.http.cio.internals.CharArrayBuilder r12, io.ktor.http.cio.internals.MutableRange r13, kotlin.coroutines.Continuation<? super io.ktor.http.cio.HttpHeadersMap> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseHeaders(io.ktor.utils.io.ByteReadChannel, io.ktor.http.cio.internals.CharArrayBuilder, io.ktor.http.cio.internals.MutableRange, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object parseHeaders$default(ByteReadChannel byteReadChannel, CharArrayBuilder charArrayBuilder, MutableRange mutableRange, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            mutableRange = new MutableRange(0, 0);
        }
        return parseHeaders(byteReadChannel, charArrayBuilder, mutableRange, continuation);
    }

    private static final void validateHostHeader(CharSequence charSequence) {
        if (StringsKt.endsWith$default(charSequence, (CharSequence) ":", false, 2, (Object) null)) {
            throw new ParserException("Host header with ':' should contains port: " + ((Object) charSequence));
        }
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            Set<Character> set = hostForbiddenSymbols;
            if (set.contains(Character.valueOf(cCharAt))) {
                throw new ParserException("Host cannot contain any of the following symbols: " + set);
            }
        }
    }

    private static final HttpMethod parseHttpMethod(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        HttpMethod httpMethod = (HttpMethod) CollectionsKt.singleOrNull(AsciiCharTree.search$default(CharsKt.getDefaultHttpMethods(), charSequence, mutableRange.getStart(), mutableRange.getEnd(), false, new Function2() { // from class: io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(HttpParserKt.parseHttpMethod$lambda$1(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            }
        }, 8, null));
        if (httpMethod != null) {
            mutableRange.setStart(mutableRange.getStart() + httpMethod.getValue().length());
            return httpMethod;
        }
        return parseHttpMethodFull(charSequence, mutableRange);
    }

    private static final HttpMethod parseHttpMethodFull(CharSequence charSequence, MutableRange mutableRange) {
        return new HttpMethod(TokenizerKt.nextToken(charSequence, mutableRange).toString());
    }

    private static final CharSequence parseUri(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        int start = mutableRange.getStart();
        int iFindSpaceOrEnd = TokenizerKt.findSpaceOrEnd(charSequence, mutableRange);
        int i = iFindSpaceOrEnd - start;
        if (i <= 0) {
            return "";
        }
        if (i == 1 && charSequence.charAt(start) == '/') {
            mutableRange.setStart(iFindSpaceOrEnd);
            return DomExceptionUtils.SEPARATOR;
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(start, iFindSpaceOrEnd);
        mutableRange.setStart(iFindSpaceOrEnd);
        return charSequenceSubSequence;
    }

    private static final CharSequence parseVersion(CharSequence charSequence, MutableRange mutableRange) {
        TokenizerKt.skipSpaces(charSequence, mutableRange);
        if (mutableRange.getStart() >= mutableRange.getEnd()) {
            throw new IllegalStateException(("Failed to parse version: " + ((Object) charSequence)).toString());
        }
        String str = (String) CollectionsKt.singleOrNull(AsciiCharTree.search$default(versions, charSequence, mutableRange.getStart(), mutableRange.getEnd(), false, new Function2() { // from class: io.ktor.http.cio.HttpParserKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(HttpParserKt.parseVersion$lambda$3(((Character) obj).charValue(), ((Integer) obj2).intValue()));
            }
        }, 8, null));
        if (str != null) {
            mutableRange.setStart(mutableRange.getStart() + str.length());
            return str;
        }
        unsupportedHttpVersion(TokenizerKt.nextToken(charSequence, mutableRange));
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
    
        r7.setStart(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int parseStatusCode(java.lang.CharSequence r6, io.ktor.http.cio.internals.MutableRange r7) {
        /*
            io.ktor.http.cio.internals.TokenizerKt.skipSpaces(r6, r7)
            int r0 = r7.getEnd()
            int r1 = r7.getStart()
            int r2 = r7.getEnd()
            r3 = 0
        L10:
            if (r1 >= r2) goto L77
            char r4 = r6.charAt(r1)
            r5 = 32
            if (r4 != r5) goto L3b
            boolean r6 = statusOutOfRange(r3)
            if (r6 != 0) goto L22
            r0 = r1
            goto L77
        L22:
            io.ktor.http.cio.ParserException r6 = new io.ktor.http.cio.ParserException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Status-code must be 3-digit. Status received: "
            r7.<init>(r0)
            r7.append(r3)
            r0 = 46
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L3b:
            r5 = 48
            if (r5 > r4) goto L4b
            r5 = 58
            if (r4 >= r5) goto L4b
            int r3 = r3 * 10
            int r4 = r4 + (-48)
            int r3 = r3 + r4
            int r1 = r1 + 1
            goto L10
        L4b:
            int r0 = r7.getStart()
            int r7 = io.ktor.http.cio.internals.TokenizerKt.findSpaceOrEnd(r6, r7)
            java.lang.CharSequence r6 = r6.subSequence(r0, r7)
            java.lang.String r6 = r6.toString()
            java.lang.NumberFormatException r7 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Illegal digit "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r1 = " in status code "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L77:
            r7.setStart(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.cio.HttpParserKt.parseStatusCode(java.lang.CharSequence, io.ktor.http.cio.internals.MutableRange):int");
    }

    public static final int parseHeaderName(CharArrayBuilder text, MutableRange range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int end = range.getEnd();
        for (int start = range.getStart(); start < end; start++) {
            char cCharAt = text.charAt(start);
            if (cCharAt == ':' && start != range.getStart()) {
                range.setStart(start + 1);
                return start;
            }
            if (isDelimiter(cCharAt)) {
                parseHeaderNameFailed(text, start, range.getStart(), cCharAt);
                throw new KotlinNothingValueException();
            }
        }
        noColonFound(text, range);
        throw new KotlinNothingValueException();
    }

    private static final Void parseHeaderNameFailed(CharArrayBuilder charArrayBuilder, int i, int i2, char c) {
        if (c == ':') {
            throw new ParserException("Empty header names are not allowed as per RFC7230.");
        }
        if (i == i2) {
            throw new ParserException("Multiline headers via line folding is not supported since it is deprecated as per RFC7230.");
        }
        characterIsNotAllowed(charArrayBuilder, c);
        throw new KotlinNothingValueException();
    }

    public static final void parseHeaderValue(CharArrayBuilder text, MutableRange range) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(range, "range");
        int start = range.getStart();
        int end = range.getEnd();
        int iSkipSpacesAndHorizontalTabs = TokenizerKt.skipSpacesAndHorizontalTabs(text, start, end);
        if (iSkipSpacesAndHorizontalTabs >= end) {
            range.setStart(end);
            return;
        }
        int i = iSkipSpacesAndHorizontalTabs;
        int i2 = i;
        while (i < end) {
            char cCharAt = text.charAt(i);
            if (cCharAt != '\t') {
                if (cCharAt == '\n' || cCharAt == '\r') {
                    characterIsNotAllowed(text, cCharAt);
                    throw new KotlinNothingValueException();
                }
                if (cCharAt != ' ') {
                    i2 = i;
                }
            }
            i++;
        }
        range.setStart(iSkipSpacesAndHorizontalTabs);
        range.setEnd(i2 + 1);
    }

    private static final Void noColonFound(CharSequence charSequence, MutableRange mutableRange) {
        throw new ParserException("No colon in HTTP header in " + charSequence.subSequence(mutableRange.getStart(), mutableRange.getEnd()).toString() + " in builder: \n" + ((Object) charSequence));
    }

    private static final Void characterIsNotAllowed(CharSequence charSequence, char c) {
        throw new ParserException("Character with code " + (c & 255) + " is not allowed in header names, \n" + ((Object) charSequence));
    }

    private static final boolean isDelimiter(char c) {
        return Intrinsics.compare((int) c, 32) <= 0 || StringsKt.contains$default((CharSequence) "\"(),/:;<=>?@[\\]{}", c, false, 2, (Object) null);
    }

    private static final Void unsupportedHttpVersion(CharSequence charSequence) {
        throw new ParserException("Unsupported HTTP version: " + ((Object) charSequence));
    }
}
