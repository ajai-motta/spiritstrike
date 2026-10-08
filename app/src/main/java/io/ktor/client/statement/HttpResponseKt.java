package io.ktor.client.statement;

import io.ktor.client.request.HttpRequest;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: HttpResponse.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a\"\u0010\b\u001a\u00020\u0007*\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a\u0014\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0086@¢\u0006\u0004\b\u000e\u0010\f\"\u001e\u0010\u0012\u001a\u00020\n*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0016\u001a\u00020\u0013*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lio/ktor/client/statement/HttpResponse;", "", "complete", "(Lio/ktor/client/statement/HttpResponse;)V", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "fallbackCharset", "", "bodyAsText", "(Lio/ktor/client/statement/HttpResponse;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", "bodyAsChannel", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "bodyAsBytes", "getContent", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/utils/io/ByteReadChannel;", "getContent$annotations", "content", "Lio/ktor/client/request/HttpRequest;", "getRequest", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/request/HttpRequest;", "request", "ktor-client-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HttpResponseKt {

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsBytes$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpResponse.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", i = {}, l = {147}, m = "bodyAsBytes", n = {}, s = {})
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
            return HttpResponseKt.bodyAsBytes(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpResponse.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", i = {}, l = {147}, m = "bodyAsChannel", n = {}, s = {})
    static final class C32901 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C32901(Continuation<? super C32901> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.bodyAsChannel(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpResponseKt$bodyAsText$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpResponse.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", i = {0}, l = {147}, m = "bodyAsText", n = {"decoder"}, s = {"L$0"})
    static final class C32911 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C32911(Continuation<? super C32911> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpResponseKt.bodyAsText(null, null, this);
        }
    }

    @Deprecated(message = "This method was renamed to readRawBytes() to reflect what it does.", replaceWith = @ReplaceWith(expression = "readRawBytes()", imports = {}))
    public static /* synthetic */ void getContent$annotations(HttpResponse httpResponse) {
    }

    public static final ByteReadChannel getContent(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        return httpResponse.getRawContent();
    }

    public static final HttpRequest getRequest(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        return httpResponse.getCall().getRequest();
    }

    public static final void complete(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Job job = JobKt.getJob(httpResponse.getCoroutineContext());
        Intrinsics.checkNotNull(job, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        ((CompletableJob) job).complete();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object bodyAsText(io.ktor.client.statement.HttpResponse r6, java.nio.charset.Charset r7, kotlin.coroutines.Continuation<? super java.lang.String> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.client.statement.HttpResponseKt.C32911
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = (io.ktor.client.statement.HttpResponseKt.C32911) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.client.statement.HttpResponseKt$bodyAsText$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsText$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r6 = r0.L$0
            java.nio.charset.CharsetDecoder r6 = (java.nio.charset.CharsetDecoder) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6c
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r6
            io.ktor.http.HttpMessage r8 = (io.ktor.http.HttpMessage) r8
            java.nio.charset.Charset r8 = io.ktor.http.HttpMessagePropertiesKt.charset(r8)
            if (r8 != 0) goto L44
            goto L45
        L44:
            r7 = r8
        L45:
            java.nio.charset.CharsetDecoder r7 = r7.newDecoder()
            io.ktor.client.call.HttpClientCall r6 = r6.getCall()
            java.lang.Class<kotlinx.io.Source> r8 = kotlinx.io.Source.class
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            java.lang.Class<kotlinx.io.Source> r2 = kotlinx.io.Source.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.typeOf(r2)     // Catch: java.lang.Throwable -> L5a
            goto L5b
        L5a:
            r2 = r3
        L5b:
            io.ktor.util.reflect.TypeInfo r5 = new io.ktor.util.reflect.TypeInfo
            r5.<init>(r8, r2)
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r6.bodyNullable(r5, r0)
            if (r8 != r1) goto L6b
            return r1
        L6b:
            r6 = r7
        L6c:
            if (r8 == 0) goto L7a
            kotlinx.io.Source r8 = (kotlinx.io.Source) r8
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            r7 = 0
            r0 = 2
            java.lang.String r6 = io.ktor.utils.io.charsets.EncodingKt.decode$default(r6, r8, r7, r0, r3)
            return r6
        L7a:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r7 = "null cannot be cast to non-null type kotlinx.io.Source"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.bodyAsText(io.ktor.client.statement.HttpResponse, java.nio.charset.Charset, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object bodyAsText$default(HttpResponse httpResponse, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return bodyAsText(httpResponse, charset, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object bodyAsChannel(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation<? super io.ktor.utils.io.ByteReadChannel> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpResponseKt.C32901
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1 r0 = (io.ktor.client.statement.HttpResponseKt.C32901) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsChannel$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L55
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.client.call.HttpClientCall r5 = r5.getCall()
            java.lang.Class<io.ktor.utils.io.ByteReadChannel> r6 = io.ktor.utils.io.ByteReadChannel.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            java.lang.Class<io.ktor.utils.io.ByteReadChannel> r2 = io.ktor.utils.io.ByteReadChannel.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.typeOf(r2)     // Catch: java.lang.Throwable -> L46
            goto L47
        L46:
            r2 = 0
        L47:
            io.ktor.util.reflect.TypeInfo r4 = new io.ktor.util.reflect.TypeInfo
            r4.<init>(r6, r2)
            r0.label = r3
            java.lang.Object r6 = r5.bodyNullable(r4, r0)
            if (r6 != r1) goto L55
            return r1
        L55:
            if (r6 == 0) goto L5a
            io.ktor.utils.io.ByteReadChannel r6 = (io.ktor.utils.io.ByteReadChannel) r6
            return r6
        L5a:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type io.ktor.utils.io.ByteReadChannel"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.bodyAsChannel(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object bodyAsBytes(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation<? super byte[]> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpResponseKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.statement.HttpResponseKt$bodyAsBytes$1 r0 = (io.ktor.client.statement.HttpResponseKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.statement.HttpResponseKt$bodyAsBytes$1 r0 = new io.ktor.client.statement.HttpResponseKt$bodyAsBytes$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L53
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.client.call.HttpClientCall r5 = r5.getCall()
            java.lang.Class<byte[]> r6 = byte[].class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            kotlin.reflect.KType r6 = kotlin.jvm.internal.Reflection.typeOf(r6)     // Catch: java.lang.Throwable -> L44
            goto L45
        L44:
            r6 = 0
        L45:
            io.ktor.util.reflect.TypeInfo r4 = new io.ktor.util.reflect.TypeInfo
            r4.<init>(r2, r6)
            r0.label = r3
            java.lang.Object r6 = r5.bodyNullable(r4, r0)
            if (r6 != r1) goto L53
            return r1
        L53:
            if (r6 == 0) goto L58
            byte[] r6 = (byte[]) r6
            return r6
        L58:
            java.lang.NullPointerException r5 = new java.lang.NullPointerException
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.ByteArray"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpResponseKt.bodyAsBytes(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
