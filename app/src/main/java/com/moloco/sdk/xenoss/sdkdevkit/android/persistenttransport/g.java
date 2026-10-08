package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import io.ktor.client.HttpClient;
import io.ktor.http.ContentType;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements f {
    public static final int d = 8;
    public final HttpClient b;
    public final CoroutineScope c;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.NonPersistentHttpRequestImpl$send$1", f = "NonPersistentHttpRequest.kt", i = {0, 1}, l = {46, 50}, m = "invokeSuspend", n = {"runAttemptCount", "runAttemptCount"}, s = {"I$0", "I$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3046a;
        public int b;
        public final /* synthetic */ String d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return g.this.new a(this.d, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0080 -> B:26:0x0083). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.b
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L23
                if (r1 == r4) goto L1d
                if (r1 != r2) goto L15
                int r1 = r12.f3046a
                kotlin.ResultKt.throwOnFailure(r13)
                goto L83
            L15:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L1d:
                int r1 = r12.f3046a
                kotlin.ResultKt.throwOnFailure(r13)
                goto L69
            L23:
                kotlin.ResultKt.throwOnFailure(r13)
                r1 = r3
            L27:
                r13 = 5
                if (r1 >= r13) goto L85
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                r5 = 0
                android.content.Context r5 = com.moloco.sdk.internal.android_context.b.a(r5, r4, r5)
                boolean r13 = r13.a(r5)
                com.moloco.sdk.internal.MolocoLogger r5 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "Network available: "
                r6.<init>(r7)
                r6.append(r13)
                java.lang.String r7 = " for non persistent request"
                r6.append(r7)
                java.lang.String r7 = r6.toString()
                r10 = 12
                r11 = 0
                java.lang.String r6 = "NonPersistentRequest"
                r8 = 0
                r9 = 0
                com.moloco.sdk.internal.MolocoLogger.info$default(r5, r6, r7, r8, r9, r10, r11)
                if (r13 == 0) goto L70
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                io.ktor.client.HttpClient r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.a(r13)
                java.lang.String r5 = r12.d
                r12.f3046a = r1
                r12.b = r4
                java.lang.Object r13 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a(r13, r5, r12)
                if (r13 != r0) goto L69
                return r0
            L69:
                java.lang.Boolean r13 = (java.lang.Boolean) r13
                boolean r13 = r13.booleanValue()
                goto L71
            L70:
                r13 = r3
            L71:
                if (r13 == 0) goto L76
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            L76:
                r12.f3046a = r1
                r12.b = r2
                r5 = 10000(0x2710, double:4.9407E-320)
                java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r5, r12)
                if (r13 != r0) goto L83
                return r0
            L83:
                int r1 = r1 + r4
                goto L27
            L85:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.NonPersistentHttpRequestImpl$sendPost$1", f = "NonPersistentHttpRequest.kt", i = {0, 1}, l = {61, 65}, m = "invokeSuspend", n = {"runAttemptCount", "runAttemptCount"}, s = {"I$0", "I$0"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3047a;
        public int b;
        public final /* synthetic */ String d;
        public final /* synthetic */ byte[] e;
        public final /* synthetic */ ContentType f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, byte[] bArr, ContentType contentType, Continuation<? super b> continuation) {
            super(2, continuation);
            this.d = str;
            this.e = bArr;
            this.f = contentType;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return g.this.new b(this.d, this.e, this.f, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008a -> B:26:0x008d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.b
                r2 = 2
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L24
                if (r1 == r4) goto L1e
                if (r1 != r2) goto L16
                int r1 = r13.f3047a
                kotlin.ResultKt.throwOnFailure(r14)
                goto L8d
            L16:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L1e:
                int r1 = r13.f3047a
                kotlin.ResultKt.throwOnFailure(r14)
                goto L73
            L24:
                kotlin.ResultKt.throwOnFailure(r14)
                r1 = r3
            L28:
                r14 = 5
                if (r1 >= r14) goto L8f
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r14 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                r5 = 0
                android.content.Context r5 = com.moloco.sdk.internal.android_context.b.a(r5, r4, r5)
                boolean r14 = r14.a(r5)
                com.moloco.sdk.internal.MolocoLogger r5 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "Network available: "
                r6.<init>(r7)
                r6.append(r14)
                java.lang.String r7 = " for non persistent request"
                r6.append(r7)
                java.lang.String r7 = r6.toString()
                r10 = 12
                r11 = 0
                java.lang.String r6 = "NonPersistentRequest"
                r8 = 0
                r9 = 0
                com.moloco.sdk.internal.MolocoLogger.info$default(r5, r6, r7, r8, r9, r10, r11)
                if (r14 == 0) goto L7a
                com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g r14 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.this
                io.ktor.client.HttpClient r5 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.a(r14)
                java.lang.String r6 = r13.d
                byte[] r7 = r13.e
                io.ktor.http.ContentType r8 = r13.f
                r13.f3047a = r1
                r13.b = r4
                r11 = 8
                r12 = 0
                r9 = 0
                r10 = r13
                java.lang.Object r14 = com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.e.a(r5, r6, r7, r8, r9, r10, r11, r12)
                if (r14 != r0) goto L73
                return r0
            L73:
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r14 = r14.booleanValue()
                goto L7b
            L7a:
                r14 = r3
            L7b:
                if (r14 == 0) goto L80
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            L80:
                r13.f3047a = r1
                r13.b = r2
                r5 = 10000(0x2710, double:4.9407E-320)
                java.lang.Object r14 = kotlinx.coroutines.DelayKt.delay(r5, r13)
                if (r14 != r0) goto L8d
                return r0
            L8d:
                int r1 = r1 + r4
                goto L28
            L8f:
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.g.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public g(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.b = httpClient;
        this.c = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getDefault());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(url, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.d
    public void a(String url, byte[] body, ContentType contentType, String str) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(url, body, contentType, null), 3, null);
    }

    public final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3);
    }
}
