package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.util.Patterns;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3041a = "HttpRequestClient";
    public static final long b = 5000;
    public static final int c = 5;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt", f = "HttpRequestClient.kt", i = {}, l = {36}, m = "sendGetRequest", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3042a;
        public int b;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f3042a = obj;
            this.b |= Integer.MIN_VALUE;
            return e.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt$sendGetRequest$2", f = "HttpRequestClient.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3043a;
        public final /* synthetic */ HttpClient b;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HttpClient httpClient, String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = httpClient;
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3043a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HttpClient httpClient = this.b;
                String str = this.c;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                HttpRequestKt.url(httpRequestBuilder, str);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, 5000L);
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                this.f3043a = 1;
                obj = httpStatement.execute(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            HttpStatusCode status = ((HttpResponse) obj).getStatus();
            HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
            return Boxing.boxBoolean(status.compareTo(companion.getOK()) >= 0 && status.compareTo(companion.getBadRequest()) < 0);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt", f = "HttpRequestClient.kt", i = {}, l = {52}, m = "sendPostRequest", n = {}, s = {})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f3044a;
        public int b;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f3044a = obj;
            this.b |= Integer.MIN_VALUE;
            return e.a(null, null, null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.HttpRequestClientKt$sendPostRequest$2", f = "HttpRequestClient.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3045a;
        public final /* synthetic */ HttpClient b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ byte[] e;
        public final /* synthetic */ ContentType f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(HttpClient httpClient, String str, String str2, byte[] bArr, ContentType contentType, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = httpClient;
            this.c = str;
            this.d = str2;
            this.e = bArr;
            this.f = contentType;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, this.e, this.f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f3045a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                HttpClient httpClient = this.b;
                String str = this.c;
                final String str2 = this.d;
                byte[] bArr = this.e;
                ContentType contentType = this.f;
                HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                HttpRequestKt.url(httpRequestBuilder, str);
                if (str2 != null && (!StringsKt.isBlank(str2))) {
                    HttpRequestKt.headers(httpRequestBuilder, new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$d$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return e.d.a(str2, (HeadersBuilder) obj2);
                        }
                    });
                }
                KType kTypeTypeOf = null;
                if (bArr == null) {
                    httpRequestBuilder.setBody(NullBody.INSTANCE);
                    KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                    try {
                        kTypeTypeOf = Reflection.typeOf(byte[].class);
                    } catch (Throwable unused) {
                    }
                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kTypeTypeOf));
                } else if (bArr instanceof OutgoingContent) {
                    httpRequestBuilder.setBody(bArr);
                    httpRequestBuilder.setBodyType(null);
                } else {
                    httpRequestBuilder.setBody(bArr);
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(byte[].class);
                    try {
                        kTypeTypeOf = Reflection.typeOf(byte[].class);
                    } catch (Throwable unused2) {
                    }
                    httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kTypeTypeOf));
                }
                HttpMessagePropertiesKt.contentType(httpRequestBuilder, contentType);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.a.a(httpRequestBuilder, 5000L);
                httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getPost());
                HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
                this.f3045a = 1;
                obj = httpStatement.execute(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            HttpStatusCode status = ((HttpResponse) obj).getStatus();
            MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, "HttpClient", "Response status: " + status + " for url: " + this.c, false, 4, null);
            HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
            return Boxing.boxBoolean(status.compareTo(companion.getOK()) >= 0 && status.compareTo(companion.getBadRequest()) < 0);
        }

        public static final Unit a(String str, HeadersBuilder headersBuilder) {
            headersBuilder.append(HttpHeaders.INSTANCE.getContentEncoding(), str);
            return Unit.INSTANCE;
        }
    }

    public static final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean zMatches = Patterns.WEB_URL.matcher(str).matches();
        if (!zMatches) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, f3041a, "URL is invalid. " + str, null, false, 12, null);
        }
        return zMatches;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(io.ktor.client.HttpClient r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.b = r1
            goto L18
        L13:
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f3042a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L52
            goto L4b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            com.moloco.sdk.internal.scheduling.DispatcherProvider r7 = com.moloco.sdk.internal.scheduling.b.a()     // Catch: java.lang.Exception -> L52
            kotlin.coroutines.CoroutineContext r7 = r7.getIo()     // Catch: java.lang.Exception -> L52
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$b r2 = new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$b     // Catch: java.lang.Exception -> L52
            r4 = 0
            r2.<init>(r5, r6, r4)     // Catch: java.lang.Exception -> L52
            r0.b = r3     // Catch: java.lang.Exception -> L52
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r2, r0)     // Catch: java.lang.Exception -> L52
            if (r7 != r1) goto L4b
            return r1
        L4b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Exception -> L52
            boolean r5 = r7.booleanValue()     // Catch: java.lang.Exception -> L52
            goto L53
        L52:
            r5 = 0
        L53:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a(io.ktor.client.HttpClient, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(io.ktor.client.HttpClient r12, java.lang.String r13, byte[] r14, io.ktor.http.ContentType r15, java.lang.String r16, kotlin.coroutines.Continuation<? super java.lang.Boolean> r17) throws java.lang.Throwable {
        /*
            r0 = r17
            boolean r1 = r0 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.c
            if (r1 == 0) goto L15
            r1 = r0
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$c r1 = (com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.c) r1
            int r2 = r1.b
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.b = r2
            goto L1a
        L15:
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$c r1 = new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$c
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.f3044a
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.b
            r4 = 1
            if (r3 == 0) goto L33
            if (r3 != r4) goto L2b
            kotlin.ResultKt.throwOnFailure(r0)     // Catch: java.lang.Exception -> L5b
            goto L54
        L2b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L33:
            kotlin.ResultKt.throwOnFailure(r0)
            com.moloco.sdk.internal.scheduling.DispatcherProvider r0 = com.moloco.sdk.internal.scheduling.b.a()     // Catch: java.lang.Exception -> L5b
            kotlin.coroutines.CoroutineContext r0 = r0.getIo()     // Catch: java.lang.Exception -> L5b
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$d r3 = new com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e$d     // Catch: java.lang.Exception -> L5b
            r11 = 0
            r5 = r3
            r6 = r12
            r7 = r13
            r8 = r16
            r9 = r14
            r10 = r15
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L5b
            r1.b = r4     // Catch: java.lang.Exception -> L5b
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r3, r1)     // Catch: java.lang.Exception -> L5b
            if (r0 != r2) goto L54
            return r2
        L54:
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Exception -> L5b
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Exception -> L5b
            goto L5c
        L5b:
            r0 = 0
        L5c:
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a(io.ktor.client.HttpClient, java.lang.String, byte[], io.ktor.http.ContentType, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object a(HttpClient httpClient, String str, byte[] bArr, ContentType contentType, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = null;
        }
        return a(httpClient, str, bArr, contentType, str2, continuation);
    }
}
