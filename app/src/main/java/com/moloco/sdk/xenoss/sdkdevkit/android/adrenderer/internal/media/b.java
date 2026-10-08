package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.u;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpRequestRetryConfig;
import io.ktor.client.plugins.HttpRequestRetryKt;
import io.ktor.client.plugins.HttpRetryDelayContext;
import io.ktor.client.plugins.HttpRetryModifyRequestContext;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import java.io.File;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a {
    public static final int f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f2534a;
    public final u b;
    public final com.moloco.sdk.internal.error.b c;
    public final HttpClient d;
    public final String e;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl", f = "ChunkedMediaDownloader.kt", i = {0, 0, 0, 1, 1, 1}, l = {294, 294}, m = "downloadFullFile", n = {"this", "dstFile", "response", "this", "dstFile", "response"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2535a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return b.this.a((File) null, (HttpResponse) null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$b, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl$downloadMedia$2", f = "ChunkedMediaDownloader.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3}, l = {95, 106, TsExtractor.TS_STREAM_TYPE_DTS, 149}, m = "invokeSuspend", n = {"previousEtag", "maxRange", "remainingBytes", "previousBytes", "chunk", "previousEtag", "maxRange", "remainingBytes", "previousBytes", "chunk", "previousEtag", "maxRange", "hasMoreData", "remainingBytes", "previousBytes", "chunk", "previousEtag", "maxRange", "remainingBytes", "previousBytes", "chunk"}, s = {"L$0", "I$0", "I$1", "J$0", "I$2", "L$0", "I$0", "I$1", "J$0", "I$2", "L$0", "I$0", "I$1", "I$2", "J$0", "I$3", "L$0", "I$0", "I$1", "J$0", "I$2"})
    public static final class C0434b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2536a;
        public int b;
        public int c;
        public int d;
        public long e;
        public Object f;
        public int g;
        public final /* synthetic */ String i;
        public final /* synthetic */ File j;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a k;
        public final /* synthetic */ String l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0434b(String str, File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar, String str2, Continuation<? super C0434b> continuation) {
            super(2, continuation);
            this.i = str;
            this.j = file;
            this.k = aVar;
            this.l = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i.a> continuation) {
            return ((C0434b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0434b(this.i, this.j, this.k, this.l, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x0413 A[Catch: Exception -> 0x041e, TRY_LEAVE, TryCatch #0 {Exception -> 0x041e, blocks: (B:9:0x002d, B:46:0x0167, B:50:0x0186, B:52:0x018e, B:54:0x0192, B:55:0x019c, B:57:0x019f, B:61:0x01f7, B:64:0x0208, B:66:0x0263, B:68:0x02bd, B:70:0x02c4, B:76:0x030e, B:80:0x0343, B:84:0x0361, B:86:0x0365, B:89:0x037d, B:90:0x0393, B:75:0x02f0, B:92:0x03af, B:93:0x03b4, B:94:0x03b5, B:100:0x0413, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b0, B:27:0x00ba, B:29:0x00ce, B:31:0x00d6, B:37:0x00fb, B:39:0x00ff, B:40:0x0108, B:42:0x0136, B:44:0x0156, B:35:0x00de), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0167 A[Catch: Exception -> 0x041e, TryCatch #0 {Exception -> 0x041e, blocks: (B:9:0x002d, B:46:0x0167, B:50:0x0186, B:52:0x018e, B:54:0x0192, B:55:0x019c, B:57:0x019f, B:61:0x01f7, B:64:0x0208, B:66:0x0263, B:68:0x02bd, B:70:0x02c4, B:76:0x030e, B:80:0x0343, B:84:0x0361, B:86:0x0365, B:89:0x037d, B:90:0x0393, B:75:0x02f0, B:92:0x03af, B:93:0x03b4, B:94:0x03b5, B:100:0x0413, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b0, B:27:0x00ba, B:29:0x00ce, B:31:0x00d6, B:37:0x00fb, B:39:0x00ff, B:40:0x0108, B:42:0x0136, B:44:0x0156, B:35:0x00de), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x018e A[Catch: Exception -> 0x041e, TryCatch #0 {Exception -> 0x041e, blocks: (B:9:0x002d, B:46:0x0167, B:50:0x0186, B:52:0x018e, B:54:0x0192, B:55:0x019c, B:57:0x019f, B:61:0x01f7, B:64:0x0208, B:66:0x0263, B:68:0x02bd, B:70:0x02c4, B:76:0x030e, B:80:0x0343, B:84:0x0361, B:86:0x0365, B:89:0x037d, B:90:0x0393, B:75:0x02f0, B:92:0x03af, B:93:0x03b4, B:94:0x03b5, B:100:0x0413, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b0, B:27:0x00ba, B:29:0x00ce, B:31:0x00d6, B:37:0x00fb, B:39:0x00ff, B:40:0x0108, B:42:0x0136, B:44:0x0156, B:35:0x00de), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x019f A[Catch: Exception -> 0x041e, TryCatch #0 {Exception -> 0x041e, blocks: (B:9:0x002d, B:46:0x0167, B:50:0x0186, B:52:0x018e, B:54:0x0192, B:55:0x019c, B:57:0x019f, B:61:0x01f7, B:64:0x0208, B:66:0x0263, B:68:0x02bd, B:70:0x02c4, B:76:0x030e, B:80:0x0343, B:84:0x0361, B:86:0x0365, B:89:0x037d, B:90:0x0393, B:75:0x02f0, B:92:0x03af, B:93:0x03b4, B:94:0x03b5, B:100:0x0413, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b0, B:27:0x00ba, B:29:0x00ce, B:31:0x00d6, B:37:0x00fb, B:39:0x00ff, B:40:0x0108, B:42:0x0136, B:44:0x0156, B:35:0x00de), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0207 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0208 A[Catch: Exception -> 0x041e, TryCatch #0 {Exception -> 0x041e, blocks: (B:9:0x002d, B:46:0x0167, B:50:0x0186, B:52:0x018e, B:54:0x0192, B:55:0x019c, B:57:0x019f, B:61:0x01f7, B:64:0x0208, B:66:0x0263, B:68:0x02bd, B:70:0x02c4, B:76:0x030e, B:80:0x0343, B:84:0x0361, B:86:0x0365, B:89:0x037d, B:90:0x0393, B:75:0x02f0, B:92:0x03af, B:93:0x03b4, B:94:0x03b5, B:100:0x0413, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b0, B:27:0x00ba, B:29:0x00ce, B:31:0x00d6, B:37:0x00fb, B:39:0x00ff, B:40:0x0108, B:42:0x0136, B:44:0x0156, B:35:0x00de), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0365 A[Catch: Exception -> 0x041e, TryCatch #0 {Exception -> 0x041e, blocks: (B:9:0x002d, B:46:0x0167, B:50:0x0186, B:52:0x018e, B:54:0x0192, B:55:0x019c, B:57:0x019f, B:61:0x01f7, B:64:0x0208, B:66:0x0263, B:68:0x02bd, B:70:0x02c4, B:76:0x030e, B:80:0x0343, B:84:0x0361, B:86:0x0365, B:89:0x037d, B:90:0x0393, B:75:0x02f0, B:92:0x03af, B:93:0x03b4, B:94:0x03b5, B:100:0x0413, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b0, B:27:0x00ba, B:29:0x00ce, B:31:0x00d6, B:37:0x00fb, B:39:0x00ff, B:40:0x0108, B:42:0x0136, B:44:0x0156, B:35:0x00de), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0379  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x037d A[Catch: Exception -> 0x041e, TryCatch #0 {Exception -> 0x041e, blocks: (B:9:0x002d, B:46:0x0167, B:50:0x0186, B:52:0x018e, B:54:0x0192, B:55:0x019c, B:57:0x019f, B:61:0x01f7, B:64:0x0208, B:66:0x0263, B:68:0x02bd, B:70:0x02c4, B:76:0x030e, B:80:0x0343, B:84:0x0361, B:86:0x0365, B:89:0x037d, B:90:0x0393, B:75:0x02f0, B:92:0x03af, B:93:0x03b4, B:94:0x03b5, B:100:0x0413, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b0, B:27:0x00ba, B:29:0x00ce, B:31:0x00d6, B:37:0x00fb, B:39:0x00ff, B:40:0x0108, B:42:0x0136, B:44:0x0156, B:35:0x00de), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0393 A[Catch: Exception -> 0x041e, TryCatch #0 {Exception -> 0x041e, blocks: (B:9:0x002d, B:46:0x0167, B:50:0x0186, B:52:0x018e, B:54:0x0192, B:55:0x019c, B:57:0x019f, B:61:0x01f7, B:64:0x0208, B:66:0x0263, B:68:0x02bd, B:70:0x02c4, B:76:0x030e, B:80:0x0343, B:84:0x0361, B:86:0x0365, B:89:0x037d, B:90:0x0393, B:75:0x02f0, B:92:0x03af, B:93:0x03b4, B:94:0x03b5, B:100:0x0413, B:14:0x004d, B:17:0x0067, B:20:0x0080, B:24:0x008f, B:25:0x00b0, B:27:0x00ba, B:29:0x00ce, B:31:0x00d6, B:37:0x00fb, B:39:0x00ff, B:40:0x0108, B:42:0x0136, B:44:0x0156, B:35:0x00de), top: B:107:0x0017, inners: #1 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x0409 -> B:98:0x040b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r40) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1112
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.C0434b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.ChunkedMediaDownloaderImpl", f = "ChunkedMediaDownloader.kt", i = {0, 0, 1, 1, 1}, l = {276, 278}, m = "writeChunkToFile", n = {"this", "dstFile", "this", "dstFile", "channel"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2537a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return b.this.b(null, null, this);
        }
    }

    public b(l mediaConfig, u connectivityService, com.moloco.sdk.internal.error.b errorReportingService, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(connectivityService, "connectivityService");
        Intrinsics.checkNotNullParameter(errorReportingService, "errorReportingService");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.f2534a = mediaConfig;
        this.b = connectivityService;
        this.c = errorReportingService;
        this.d = httpClient;
        this.e = "ChunkedMediaDownloader";
    }

    public static final long a(HttpRetryDelayContext delayMillis, int i) {
        Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
        return 100L;
    }

    public final String d(File file) {
        File fileC = c(file);
        if (fileC.exists()) {
            return FilesKt.readText$default(fileC, null, 1, null);
        }
        return null;
    }

    public final String e(File file) {
        File fileF = f(file);
        if (fileF.exists()) {
            return FilesKt.readText$default(fileF, null, 1, null);
        }
        return null;
    }

    public final File f(File file) {
        return new File(file.getParent(), file.getName() + ".range");
    }

    public final void g(File file) {
        c(file).delete();
    }

    public final void h(File file) {
        f(file).delete();
    }

    public final File c(File file) {
        return new File(file.getParent(), file.getName() + ".etag");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public boolean b(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.exists() && !f(file).exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[LOOP:0: B:27:0x0083->B:29:0x0089, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007e -> B:26:0x0081). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.io.File r13, io.ktor.client.statement.HttpResponse r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.c
            if (r0 == 0) goto L13
            r0 = r15
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$c r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.c) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$c r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$c
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4c
            if (r2 == r4) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r13 = r0.c
            io.ktor.utils.io.ByteReadChannel r13 = (io.ktor.utils.io.ByteReadChannel) r13
            java.lang.Object r14 = r0.b
            java.io.File r14 = (java.io.File) r14
            java.lang.Object r2 = r0.f2537a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b r2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L81
        L38:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L40:
            java.lang.Object r13 = r0.b
            java.io.File r13 = (java.io.File) r13
            java.lang.Object r14 = r0.f2537a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b r14 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L5d
        L4c:
            kotlin.ResultKt.throwOnFailure(r15)
            r0.f2537a = r12
            r0.b = r13
            r0.f = r4
            java.lang.Object r15 = io.ktor.client.statement.HttpResponseKt.bodyAsChannel(r14, r0)
            if (r15 != r1) goto L5c
            return r1
        L5c:
            r14 = r12
        L5d:
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            r2 = r14
            r14 = r13
            r13 = r15
        L62:
            boolean r15 = r13.isClosedForRead()
            if (r15 != 0) goto Lb4
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.l r15 = r2.f2534a
            int r15 = r15.e()
            long r4 = (long) r15
            r6 = 2
            long r4 = r4 * r6
            r0.f2537a = r2
            r0.b = r14
            r0.c = r13
            r0.f = r3
            java.lang.Object r15 = io.ktor.utils.io.ByteReadChannelOperationsKt.readRemaining(r13, r4, r0)
            if (r15 != r1) goto L81
            return r1
        L81:
            kotlinx.io.Source r15 = (kotlinx.io.Source) r15
        L83:
            boolean r4 = io.ktor.utils.io.core.PacketKt.isEmpty(r15)
            if (r4 != 0) goto L62
            byte[] r4 = io.ktor.utils.io.core.StringsKt.readBytes(r15)
            kotlin.io.FilesKt.appendBytes(r14, r4)
            com.moloco.sdk.internal.MolocoLogger r5 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.String r6 = r2.e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "dst file length: "
            r4.<init>(r7)
            long r7 = r14.length()
            r4.append(r7)
            java.lang.String r7 = " bytes"
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            r10 = 12
            r11 = 0
            r8 = 0
            r9 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r5, r6, r7, r8, r9, r10, r11)
            goto L83
        Lb4:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.b(java.io.File, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public boolean a(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return file.exists() && f(file).exists();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a
    public Object a(String str, File file, String str2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar, Continuation<? super i.a> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new C0434b(str, file, aVar, str2, null), continuation);
    }

    public final i.a a(File file, HttpResponse httpResponse, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar) {
        int value = httpResponse.getStatus().getValue();
        if (400 <= value && value < 500) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.e, "Failed to fetch media from url: " + HttpResponseKt.getRequest(httpResponse).getUrl() + ", status: " + httpResponse.getStatus(), null, false, 12, null);
            if (aVar != null) {
                aVar.a(new c.b(i.a.AbstractC0435a.e.c));
            }
            return i.a.AbstractC0435a.e.c;
        }
        if (500 <= value && value < 600) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, this.e, "Failed to fetch media from url: " + HttpResponseKt.getRequest(httpResponse).getUrl() + ", status: " + httpResponse.getStatus(), null, false, 12, null);
            if (aVar != null) {
                aVar.a(new c.b(i.a.AbstractC0435a.h.c));
            }
            return i.a.AbstractC0435a.h.c;
        }
        return new i.a.b(file);
    }

    public final i.a a(File file, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.a aVar) {
        g(file);
        h(file);
        if (aVar != null) {
            aVar.a(new c.a(file));
        }
        return new i.a.b(file);
    }

    public final Object a(String str, final long j, final int i, final String str2, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.d;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        HttpRequestRetryKt.retry(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return b.a(this.f$0, (HttpRequestRetryConfig) obj);
            }
        });
        HttpRequestKt.headers(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return b.a(j, this, i, str2, (HeadersBuilder) obj);
            }
        });
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Unit a(final b bVar, HttpRequestRetryConfig retry) {
        Intrinsics.checkNotNullParameter(retry, "$this$retry");
        retry.setMaxRetries(10);
        HttpRequestRetryConfig.delayMillis$default(retry, false, new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Long.valueOf(b.a((HttpRetryDelayContext) obj, ((Integer) obj2).intValue()));
            }
        }, 1, null);
        retry.retryOnException(10, true);
        retry.retryOnServerErrors(10);
        retry.modifyRequest(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return b.a(this.f$0, (HttpRetryModifyRequestContext) obj, (HttpRequestBuilder) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    public static final Unit a(b bVar, HttpRetryModifyRequestContext modifyRequest, HttpRequestBuilder it) {
        Intrinsics.checkNotNullParameter(modifyRequest, "$this$modifyRequest");
        Intrinsics.checkNotNullParameter(it, "it");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, bVar.e, "Retry attempt #" + modifyRequest.getRetryCount() + " for " + modifyRequest.getRequest().getUrl(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    public static final Unit a(long j, b bVar, int i, String str, HeadersBuilder headers) {
        Intrinsics.checkNotNullParameter(headers, "$this$headers");
        String str2 = "bytes=" + j + '-' + Math.min(j + ((long) bVar.f2534a.e()), i);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        String str3 = bVar.e;
        StringBuilder sb = new StringBuilder("Adding ");
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        sb.append(httpHeaders.getRange());
        sb.append(" header: ");
        sb.append(str2);
        MolocoLogger.info$default(molocoLogger, str3, sb.toString(), null, false, 12, null);
        headers.append(httpHeaders.getRange(), str2);
        if (str != null) {
            MolocoLogger.info$default(molocoLogger, bVar.e, "Adding " + httpHeaders.getIfRange() + " header: " + str, null, false, 12, null);
            headers.append(httpHeaders.getIfRange(), str);
            MolocoLogger.info$default(molocoLogger, bVar.e, "Adding " + httpHeaders.getETag() + " header: " + str, null, false, 12, null);
            headers.append(httpHeaders.getETag(), str);
        }
        return Unit.INSTANCE;
    }

    public final void a(File file, String str) {
        FilesKt.writeText$default(f(file), str, null, 2, null);
    }

    public final void a(File file, HttpResponse httpResponse) {
        Headers headers = httpResponse.getHeaders();
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        String str = headers.get(httpHeaders.getETag());
        if (str != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.e, httpHeaders.getETag() + ": " + str, null, false, 12, null);
            FilesKt.writeText$default(c(file), str, null, 2, null);
            return;
        }
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, this.e, "No " + httpHeaders.getETag() + " in header", null, false, 12, null);
        g(file);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.io.File r18, io.ktor.client.statement.HttpResponse r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.b.a(java.io.File, io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
