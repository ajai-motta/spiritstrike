package com.moloco.sdk.internal.services.init;

import android.net.Uri;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.C3009j;
import com.moloco.sdk.internal.services.InterfaceC3010k;
import com.moloco.sdk.internal.services.init.j;
import com.moloco.sdk.internal.services.x;
import com.moloco.sdk.internal.services.y;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MediationInfo;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpRequestTimeoutException;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HeadersBuilder;
import io.ktor.util.reflect.TypeInfo;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements d {
    public static final int j = 8;
    public final y c;
    public final InterfaceC3010k d;
    public final com.moloco.sdk.internal.services.usertracker.f e;
    public final String f;
    public final long g;
    public final HttpClient h;
    public final Uri i;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitApiImpl", f = "InitApi.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {67, 153, 95}, m = "invoke", n = {"this", "appKey", "mediationInfo", "metricsRecorder", "httpRequestTimerEvent", "deviceInfo", "appInfo", "this", "metricsRecorder", "httpRequestTimerEvent", "this", "metricsRecorder", "httpRequestTimerEvent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2364a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public /* synthetic */ Object h;
        public int j;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return e.this.a(null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitApiImpl$invoke$2", f = "InitApi.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Init.SDKInitResponse>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2365a;
        public final /* synthetic */ HttpResponse b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HttpResponse httpResponse, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = httpResponse;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Init.SDKInitResponse> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            KType kTypeTypeOf;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2365a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, f.f2366a, "Successful Init", null, false, 12, null);
                HttpClientCall call = this.b.getCall();
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(byte[].class);
                try {
                    kTypeTypeOf = Reflection.typeOf(byte[].class);
                } catch (Throwable unused) {
                    kTypeTypeOf = null;
                }
                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kTypeTypeOf);
                this.f2365a = 1;
                obj = call.bodyNullable(typeInfo, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (obj != null) {
                return Init.SDKInitResponse.parseFrom((byte[]) obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
        }
    }

    public e(y deviceInfoService, InterfaceC3010k appInfoService, com.moloco.sdk.internal.services.usertracker.f userTrackerService, String sdkVersion, String endpoint, long j2, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(deviceInfoService, "deviceInfoService");
        Intrinsics.checkNotNullParameter(appInfoService, "appInfoService");
        Intrinsics.checkNotNullParameter(userTrackerService, "userTrackerService");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.c = deviceInfoService;
        this.d = appInfoService;
        this.e = userTrackerService;
        this.f = sdkVersion;
        this.g = j2;
        this.h = httpClient;
        this.i = Uri.parse(endpoint);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0159 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001f  */
    @Override // com.moloco.sdk.internal.services.init.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.lang.String r24, com.moloco.sdk.publisher.MediationInfo r25, com.moloco.sdk.acm.recorder.MetricsRecorder r26, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 600
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.init.e.a(java.lang.String, com.moloco.sdk.publisher.MediationInfo, com.moloco.sdk.acm.recorder.MetricsRecorder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Unit a(e eVar, x xVar, MediationInfo mediationInfo, C3009j c3009j, HeadersBuilder headers) {
        Intrinsics.checkNotNullParameter(headers, "$this$headers");
        com.moloco.sdk.internal.n.a(headers, eVar.f, xVar.x(), mediationInfo);
        headers.append("X-Moloco-App-Bundle", c3009j.b());
        return Unit.INSTANCE;
    }

    public final v<Init.SDKInitResponse, j> a(Exception exc, TimerEvent timerEvent, MetricsRecorder metricsRecorder) {
        com.moloco.sdk.internal.services.init.b bVar;
        if (exc instanceof HttpRequestTimeoutException) {
            bVar = com.moloco.sdk.internal.services.init.b.f2360a;
        } else if (exc instanceof SSLHandshakeException) {
            bVar = com.moloco.sdk.internal.services.init.b.d;
        } else if (exc instanceof SocketException) {
            bVar = com.moloco.sdk.internal.services.init.b.c;
        } else {
            bVar = exc instanceof UnknownHostException ? com.moloco.sdk.internal.services.init.b.b : com.moloco.sdk.internal.services.init.b.f;
        }
        MolocoLogger.error$default(MolocoLogger.INSTANCE, f.f2366a, "SDK Init failed with client exception", exc, false, 8, null);
        metricsRecorder.recordTimerEvent(timerEvent.withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), bVar.name()));
        return new v.a(new j.a(bVar));
    }
}
