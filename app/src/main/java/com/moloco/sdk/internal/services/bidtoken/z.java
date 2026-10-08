package com.moloco.sdk.internal.services.bidtoken;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes6.dex */
public final class z implements y {
    public static final int i = 8;
    public final InterfaceC3000a b;
    public final CoroutineScope c;
    public final v d;
    public final String e;
    public boolean f;
    public final Mutex g;
    public Job h;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$bidToken$2", f = "ServerBidTokenService.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, 215}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function1<Continuation<? super k>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2336a;
        public final /* synthetic */ MetricsRecorder c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MetricsRecorder metricsRecorder, Continuation<? super a> continuation) {
            super(1, continuation);
            this.c = metricsRecorder;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super k> continuation) {
            return ((a) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return z.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2336a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                z.this.b("[Thread: " + Thread.currentThread().getName() + "] Acquired lock, fetching status of current token");
                v vVar = z.this.d;
                this.f2336a = 1;
                obj = vVar.a(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            B b = (B) obj;
            z.this.a("[Thread: " + Thread.currentThread().getName() + "] bidToken status: " + b);
            if (!b.b()) {
                z.this.b("[Thread: " + Thread.currentThread().getName() + "] bidToken needs refresh, fetching new token");
                z zVar = z.this;
                MetricsRecorder metricsRecorder = this.c;
                k kVarB = e.b();
                this.f2336a = 2;
                obj = zVar.a(metricsRecorder, kVarB, false, false, this);
                return obj == coroutine_suspended ? coroutine_suspended : obj;
            }
            MetricsRecorder metricsRecorder2 = this.c;
            CountEvent countEventWithTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.v.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), "true").withTag("initial_fetch", "false");
            B b2 = B.b;
            metricsRecorder2.recordCountEvent(countEventWithTag.withTag("expiring", b != b2 ? "false" : "true"));
            k kVarA = z.this.d.a();
            if (b == b2) {
                z.this.a("[Thread: " + Thread.currentThread().getName() + "] bidToken is expiring, returning cached, and refreshing async");
                z.this.a(this.c);
            } else {
                z.this.a("[Thread: " + Thread.currentThread().getName() + "] bidToken doesn't need refresh, returning cached");
            }
            return kVarA;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl", f = "ServerBidTokenService.kt", i = {0, 0, 0, 0, 0, 0, 1, 1}, l = {TsExtractor.TS_STREAM_TYPE_AC3, TTAdConstant.IMAGE_MODE_VERTICAL_IMG_173}, m = "fetchServerBidToken$moloco_sdk_release", n = {"this", "metricsRecorder", "defaultTokenOnError", "bidTokenTimer", "asyncFetch", "wasExpiring", "this", "bidTokenFetchResult"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2337a;
        public Object b;
        public Object c;
        public Object d;
        public boolean e;
        public boolean f;
        public /* synthetic */ Object g;
        public int i;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return z.this.a(null, null, false, false, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$fetchServerBidToken$bidTokenComponents$1", f = "ServerBidTokenService.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2338a;
        public final /* synthetic */ com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.internal.v<k, com.moloco.sdk.internal.m> vVar, Continuation<? super c> continuation) {
            super(1, continuation);
            this.c = vVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((c) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return z.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2338a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                v vVar = z.this.d;
                k kVar = (k) ((v.b) this.c).a();
                this.f2338a = 1;
                if (vVar.a(kVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenServiceImpl$refreshTokenAsyncOnExpiry$1", f = "ServerBidTokenService.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2339a;
        public final /* synthetic */ MetricsRecorder c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(MetricsRecorder metricsRecorder, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = metricsRecorder;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return z.this.new d(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2339a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                z.this.b("[Thread: " + Thread.currentThread().getName() + "] Fetching token from server");
                z zVar = z.this;
                MetricsRecorder metricsRecorder = this.c;
                k kVarB = e.b();
                this.f2339a = 1;
                if (zVar.a(metricsRecorder, kVarB, true, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            z.this.b("[Thread: " + Thread.currentThread().getName() + "] Finished fetching token from server");
            return Unit.INSTANCE;
        }
    }

    public z(InterfaceC3000a bidTokenApi, CoroutineScope scope, v tokenCache) {
        Intrinsics.checkNotNullParameter(bidTokenApi, "bidTokenApi");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(tokenCache, "tokenCache");
        this.b = bidTokenApi;
        this.c = scope;
        this.d = tokenCache;
        this.e = "ServerBidTokenServiceImpl";
        this.f = true;
        this.g = MutexKt.Mutex$default(false, 1, null);
    }

    public final void b(String str) {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.e, "[Thread: " + Thread.currentThread().getName() + "][sbt] " + str, null, false, 12, null);
    }

    public final void a(MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        b("[Thread: " + Thread.currentThread().getName() + "] Refreshing token async");
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.x.c());
        Job job = this.h;
        metricsRecorder.recordCountEvent(countEvent.withTag("async", String.valueOf(job != null ? job.isActive() : false)));
        Job job2 = this.h;
        if (job2 != null && job2.isActive()) {
            b("[Thread: " + Thread.currentThread().getName() + "] Async refresh already in progress. Returning");
            return;
        }
        b("[Thread: " + Thread.currentThread().getName() + "] Scheduling to fetch token from server");
        this.h = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new d(metricsRecorder, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.moloco.sdk.acm.recorder.MetricsRecorder r20, com.moloco.sdk.internal.services.bidtoken.k r21, boolean r22, boolean r23, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.services.bidtoken.k> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 589
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.z.a(com.moloco.sdk.acm.recorder.MetricsRecorder, com.moloco.sdk.internal.services.bidtoken.k, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.y
    public Object a(MetricsRecorder metricsRecorder, Continuation<? super k> continuation) {
        b("[Thread: " + Thread.currentThread().getName() + "] Fetching bidToken(), acquiring lock");
        return com.moloco.sdk.internal.utils.a.a(this.g, new a(metricsRecorder, null), continuation);
    }

    public final void a(String str) {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.e, "[Thread: " + Thread.currentThread().getName() + "] " + str, false, 4, null);
    }
}
