package com.moloco.sdk.acm.http;

import com.moloco.sdk.MetricsRequest;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpTimeoutConfig;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpClient f2003a;
    public final String b;
    public final String c;

    @DebugMetadata(c = "com.moloco.sdk.acm.http.PostMetricsRequestImpl", f = "PostMetricsRequest.kt", i = {}, l = {54}, m = "execute-0E7RQCE", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f2004a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.f2004a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objA = f.this.a(null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7414boximpl(objA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.http.PostMetricsRequestImpl", f = "PostMetricsRequest.kt", i = {0, 1, 1}, l = {145, 82}, m = "makeMetricsRequest-BWLJW6A", n = {"this", "this", "responseStatus"}, s = {"L$0", "L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2005a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object objA = f.this.a(0L, null, null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7414boximpl(objA);
        }
    }

    public f(HttpClient httpClient, String apiUrl) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        Intrinsics.checkNotNullParameter(apiUrl, "apiUrl");
        this.f2003a = httpClient;
        this.b = apiUrl;
        this.c = "PostMetricsRequest";
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.http.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(com.moloco.sdk.acm.http.d r8, kotlin.jvm.functions.Function1<? super io.ktor.http.HeadersBuilder, kotlin.Unit> r9, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.moloco.sdk.acm.http.f.a
            if (r0 == 0) goto L13
            r0 = r10
            com.moloco.sdk.acm.http.f$a r0 = (com.moloco.sdk.acm.http.f.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.acm.http.f$a r0 = new com.moloco.sdk.acm.http.f$a
            r0.<init>(r10)
        L18:
            r6 = r0
            java.lang.Object r10 = r6.f2004a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.c
            r2 = 1
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r8 = r10.getValue()
            goto L49
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L38:
            kotlin.ResultKt.throwOnFailure(r10)
            r6.c = r2
            r2 = 5000(0x1388, double:2.4703E-320)
            r1 = r7
            r4 = r8
            r5 = r9
            java.lang.Object r8 = r1.a(r2, r4, r5, r6)
            if (r8 != r0) goto L49
            return r0
        L49:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.http.f.a(com.moloco.sdk.acm.http.d, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0105 A[Catch: Exception -> 0x003f, TryCatch #0 {Exception -> 0x003f, blocks: (B:13:0x003a, B:49:0x00f7, B:51:0x0105, B:52:0x0122), top: B:59:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0122 A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:13:0x003a, B:49:0x00f7, B:51:0x0105, B:52:0x0122), top: B:59:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(final long r16, com.moloco.sdk.acm.http.d r18, kotlin.jvm.functions.Function1<? super io.ktor.http.HeadersBuilder, kotlin.Unit> r19, kotlin.coroutines.Continuation<? super kotlin.Result<java.lang.String>> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.http.f.a(long, com.moloco.sdk.acm.http.d, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Unit a(long j, HttpTimeoutConfig timeout) {
        Intrinsics.checkNotNullParameter(timeout, "$this$timeout");
        timeout.setRequestTimeoutMillis(Long.valueOf(j));
        return Unit.INSTANCE;
    }

    public final byte[] a(d dVar) {
        MetricsRequest.PostMetricsRequest postMetricsRequestBuild = MetricsRequest.PostMetricsRequest.newBuilder().addAllCounts(dVar.a()).addAllDurations(dVar.b()).build();
        Intrinsics.checkNotNullExpressionValue(postMetricsRequestBuild, "build(...)");
        byte[] byteArray = postMetricsRequestBuild.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        return byteArray;
    }
}
