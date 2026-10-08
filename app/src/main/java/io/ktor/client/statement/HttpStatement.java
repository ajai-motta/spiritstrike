package io.ktor.client.statement;

import androidx.compose.material.TextFieldImplKt;
import androidx.core.app.NotificationCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: HttpStatement.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JI\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b21\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0010\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u0010\u0010\u0012J\u0018\u0010\u0013\u001a\u00028\u0000\"\u0006\b\u0000\u0010\b\u0018\u0001H\u0086H¢\u0006\u0004\b\u0013\u0010\u0012JS\u0010\u0013\u001a\u00028\u0001\"\u0006\b\u0000\u0010\b\u0018\u0001\"\u0004\b\u0001\u0010\u001423\b\u0004\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0086H¢\u0006\u0004\b\u0013\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0015\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\nH\u0081@¢\u0006\u0004\b\u0016\u0010\u0012J\u0014\u0010\u0018\u001a\u00020\u0017*\u00020\nH\u0081@¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR \u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "builder", "Lio/ktor/client/HttpClient;", "client", "<init>", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", "T", "Lkotlin/Function2;", "Lio/ktor/client/statement/HttpResponse;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "block", "execute", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TtmlNode.TAG_BODY, "R", "fetchStreamingResponse", "fetchResponse", "", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lio/ktor/client/request/HttpRequestBuilder;", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "getClient$annotations", "()V", "ktor-client-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$cleanup$1, reason: invalid class name */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {}, l = {ModuleDescriptor.MODULE_VERSION}, m = "cleanup", n = {}, s = {})
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
            return HttpStatement.this.cleanup(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$execute$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {0, 1}, l = {54, 57, 59, 59}, m = "execute", n = {"block", "response"}, s = {"L$0", "L$0"})
    static final class C32921<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C32921(Continuation<? super C32921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$fetchResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {1, 2}, l = {162, 165, 166}, m = "fetchResponse", n = {NotificationCompat.CATEGORY_CALL, "result"}, s = {"L$0", "L$0"})
    static final class C32931 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C32931(Continuation<? super C32931> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchResponse(this);
        }
    }

    /* JADX INFO: renamed from: io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HttpStatement.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {}, l = {TextFieldImplKt.AnimationDuration}, m = "fetchStreamingResponse", n = {}, s = {})
    static final class C32941 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C32941(Continuation<? super C32941> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpStatement.this.fetchStreamingResponse(this);
        }
    }

    public static /* synthetic */ void getClient$annotations() {
    }

    public HttpStatement(HttpRequestBuilder builder, HttpClient client) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Intrinsics.checkNotNullParameter(client, "client");
        this.builder = builder;
        this.client = client;
    }

    public final HttpClient getClient() {
        return this.client;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:52|(1:(1:(1:(1:(2:14|15)(3:16|17|48))(3:19|20|57))(5:22|55|23|39|(1:41)(2:42|43)))(2:27|28))(3:30|31|(1:33))|34|53|35|(1:37)(3:38|39|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0085, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0090, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T> java.lang.Object execute(kotlin.jvm.functions.Function2<? super io.ktor.client.statement.HttpResponse, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super T> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.client.statement.HttpStatement.C32921
            if (r0 == 0) goto L14
            r0 = r10
            io.ktor.client.statement.HttpStatement$execute$1 r0 = (io.ktor.client.statement.HttpStatement.C32921) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            io.ktor.client.statement.HttpStatement$execute$1 r0 = new io.ktor.client.statement.HttpStatement$execute$1
            r0.<init>(r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L5a
            if (r2 == r6) goto L52
            if (r2 == r5) goto L45
            if (r2 == r4) goto L3f
            if (r2 == r3) goto L37
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L37:
            java.lang.Object r9 = r0.L$0
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.util.concurrent.CancellationException -> L92
            goto L91
        L3f:
            java.lang.Object r9 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.util.concurrent.CancellationException -> L92
            goto L84
        L45:
            java.lang.Object r9 = r0.L$0
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L4d
            goto L78
        L4d:
            r10 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L86
        L52:
            java.lang.Object r9 = r0.L$0
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.util.concurrent.CancellationException -> L92
            goto L68
        L5a:
            kotlin.ResultKt.throwOnFailure(r10)
            r0.L$0 = r9     // Catch: java.util.concurrent.CancellationException -> L92
            r0.label = r6     // Catch: java.util.concurrent.CancellationException -> L92
            java.lang.Object r10 = r8.fetchStreamingResponse(r0)     // Catch: java.util.concurrent.CancellationException -> L92
            if (r10 != r1) goto L68
            return r1
        L68:
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10     // Catch: java.util.concurrent.CancellationException -> L92
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L85
            r0.label = r5     // Catch: java.lang.Throwable -> L85
            java.lang.Object r9 = r9.invoke(r10, r0)     // Catch: java.lang.Throwable -> L85
            if (r9 != r1) goto L75
            return r1
        L75:
            r7 = r10
            r10 = r9
            r9 = r7
        L78:
            r0.L$0 = r10     // Catch: java.util.concurrent.CancellationException -> L92
            r0.label = r4     // Catch: java.util.concurrent.CancellationException -> L92
            java.lang.Object r9 = r8.cleanup(r9, r0)     // Catch: java.util.concurrent.CancellationException -> L92
            if (r9 != r1) goto L83
            return r1
        L83:
            r9 = r10
        L84:
            return r9
        L85:
            r9 = move-exception
        L86:
            r0.L$0 = r9     // Catch: java.util.concurrent.CancellationException -> L92
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> L92
            java.lang.Object r10 = r8.cleanup(r10, r0)     // Catch: java.util.concurrent.CancellationException -> L92
            if (r10 != r1) goto L91
            return r1
        L91:
            throw r9     // Catch: java.util.concurrent.CancellationException -> L92
        L92:
            r9 = move-exception
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Throwable r9 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r9)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.execute(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object execute(Continuation<? super HttpResponse> continuation) {
        return fetchResponse(continuation);
    }

    public final /* synthetic */ <T> Object body(Continuation<? super T> continuation) throws Throwable {
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object objFetchStreamingResponse = fetchStreamingResponse(null);
            InlineMarker.mark(1);
            HttpResponse httpResponse = (HttpResponse) objFetchStreamingResponse;
            try {
                InlineMarker.mark(3);
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(4, "T");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "T");
                } catch (Throwable unused) {
                }
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, null);
                InlineMarker.mark(0);
                Object objBodyNullable = call.bodyNullable(typeInfo, null);
                InlineMarker.mark(1);
                Intrinsics.reifiedOperationMarker(1, "T");
                Object obj = objBodyNullable;
                return objBodyNullable;
            } finally {
                InlineMarker.finallyStart(1);
                HttpResponseKt.complete(httpResponse);
                InlineMarker.finallyEnd(1);
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    public final /* synthetic */ <T, R> Object body(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) throws Throwable {
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object objFetchStreamingResponse = fetchStreamingResponse(null);
            InlineMarker.mark(1);
            HttpResponse httpResponse = (HttpResponse) objFetchStreamingResponse;
            try {
                InlineMarker.mark(3);
                HttpClientCall call = httpResponse.getCall();
                Intrinsics.reifiedOperationMarker(4, "T");
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
                try {
                    Intrinsics.reifiedOperationMarker(6, "T");
                } catch (Throwable unused) {
                }
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, null);
                InlineMarker.mark(0);
                Object objBodyNullable = call.bodyNullable(typeInfo, null);
                InlineMarker.mark(1);
                Intrinsics.reifiedOperationMarker(1, "T");
                Object obj = objBodyNullable;
                InlineMarker.mark(3);
                return function2.invoke(objBodyNullable, null);
            } finally {
                InlineMarker.finallyStart(1);
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                cleanup(httpResponse, null);
                InlineMarker.mark(1);
                InlineMarker.finallyEnd(1);
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchStreamingResponse(kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.client.statement.HttpStatement.C32941
            if (r0 == 0) goto L14
            r0 = r5
            io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1 r0 = (io.ktor.client.statement.HttpStatement.C32941) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1 r0 = new io.ktor.client.statement.HttpStatement$fetchStreamingResponse$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.util.concurrent.CancellationException -> L55
            goto L4e
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            io.ktor.client.request.HttpRequestBuilder r5 = new io.ktor.client.request.HttpRequestBuilder     // Catch: java.util.concurrent.CancellationException -> L55
            r5.<init>()     // Catch: java.util.concurrent.CancellationException -> L55
            io.ktor.client.request.HttpRequestBuilder r2 = r4.builder     // Catch: java.util.concurrent.CancellationException -> L55
            io.ktor.client.request.HttpRequestBuilder r5 = r5.takeFromWithExecutionContext(r2)     // Catch: java.util.concurrent.CancellationException -> L55
            io.ktor.client.plugins.DoubleReceivePluginKt.skipSaveBody(r5)     // Catch: java.util.concurrent.CancellationException -> L55
            io.ktor.client.HttpClient r2 = r4.client     // Catch: java.util.concurrent.CancellationException -> L55
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> L55
            java.lang.Object r5 = r2.execute$ktor_client_core(r5, r0)     // Catch: java.util.concurrent.CancellationException -> L55
            if (r5 != r1) goto L4e
            return r1
        L4e:
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5     // Catch: java.util.concurrent.CancellationException -> L55
            io.ktor.client.statement.HttpResponse r5 = r5.getResponse()     // Catch: java.util.concurrent.CancellationException -> L55
            return r5
        L55:
            r5 = move-exception
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.Throwable r5 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.fetchStreamingResponse(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchResponse(kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.ktor.client.statement.HttpStatement.C32931
            if (r0 == 0) goto L14
            r0 = r7
            io.ktor.client.statement.HttpStatement$fetchResponse$1 r0 = (io.ktor.client.statement.HttpStatement.C32931) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            io.ktor.client.statement.HttpStatement$fetchResponse$1 r0 = new io.ktor.client.statement.HttpStatement$fetchResponse$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L48
            if (r2 == r5) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r0 = r0.L$0
            io.ktor.client.statement.HttpResponse r0 = (io.ktor.client.statement.HttpResponse) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.util.concurrent.CancellationException -> L86
            goto L85
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            java.lang.Object r2 = r0.L$0
            io.ktor.client.call.HttpClientCall r2 = (io.ktor.client.call.HttpClientCall) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.util.concurrent.CancellationException -> L86
            goto L6f
        L44:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.util.concurrent.CancellationException -> L86
            goto L61
        L48:
            kotlin.ResultKt.throwOnFailure(r7)
            io.ktor.client.request.HttpRequestBuilder r7 = new io.ktor.client.request.HttpRequestBuilder     // Catch: java.util.concurrent.CancellationException -> L86
            r7.<init>()     // Catch: java.util.concurrent.CancellationException -> L86
            io.ktor.client.request.HttpRequestBuilder r2 = r6.builder     // Catch: java.util.concurrent.CancellationException -> L86
            io.ktor.client.request.HttpRequestBuilder r7 = r7.takeFromWithExecutionContext(r2)     // Catch: java.util.concurrent.CancellationException -> L86
            io.ktor.client.HttpClient r2 = r6.client     // Catch: java.util.concurrent.CancellationException -> L86
            r0.label = r5     // Catch: java.util.concurrent.CancellationException -> L86
            java.lang.Object r7 = r2.execute$ktor_client_core(r7, r0)     // Catch: java.util.concurrent.CancellationException -> L86
            if (r7 != r1) goto L61
            return r1
        L61:
            r2 = r7
            io.ktor.client.call.HttpClientCall r2 = (io.ktor.client.call.HttpClientCall) r2     // Catch: java.util.concurrent.CancellationException -> L86
            r0.L$0 = r2     // Catch: java.util.concurrent.CancellationException -> L86
            r0.label = r4     // Catch: java.util.concurrent.CancellationException -> L86
            java.lang.Object r7 = io.ktor.client.call.SavedCallKt.save(r2, r0)     // Catch: java.util.concurrent.CancellationException -> L86
            if (r7 != r1) goto L6f
            return r1
        L6f:
            io.ktor.client.call.HttpClientCall r7 = (io.ktor.client.call.HttpClientCall) r7     // Catch: java.util.concurrent.CancellationException -> L86
            io.ktor.client.statement.HttpResponse r7 = r7.getResponse()     // Catch: java.util.concurrent.CancellationException -> L86
            io.ktor.client.statement.HttpResponse r2 = r2.getResponse()     // Catch: java.util.concurrent.CancellationException -> L86
            r0.L$0 = r7     // Catch: java.util.concurrent.CancellationException -> L86
            r0.label = r3     // Catch: java.util.concurrent.CancellationException -> L86
            java.lang.Object r0 = r6.cleanup(r2, r0)     // Catch: java.util.concurrent.CancellationException -> L86
            if (r0 != r1) goto L84
            return r1
        L84:
            r0 = r7
        L85:
            return r0
        L86:
            r7 = move-exception
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            java.lang.Throwable r7 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r7)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.fetchResponse(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object cleanup(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpStatement.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = (io.ktor.client.statement.HttpStatement.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = new io.ktor.client.statement.HttpStatement$cleanup$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.CompletableJob r5 = (kotlinx.coroutines.CompletableJob) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L5f
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.getCoroutineContext()
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.INSTANCE
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            kotlinx.coroutines.CompletableJob r6 = (kotlinx.coroutines.CompletableJob) r6
            r6.complete()
            io.ktor.utils.io.ByteReadChannel r5 = r5.getRawContent()     // Catch: java.lang.Throwable -> L54
            io.ktor.utils.io.ByteReadChannelKt.cancel(r5)     // Catch: java.lang.Throwable -> L54
        L54:
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r6.join(r0)
            if (r5 != r1) goto L5f
            return r1
        L5f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.cleanup(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl() + AbstractJsonLexerKt.END_LIST;
    }
}
