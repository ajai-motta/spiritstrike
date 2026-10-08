package com.moloco.sdk.internal.publisher;

import androidx.compose.material.TextFieldImplKt;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.InterfaceC2985a;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.MolocoInitStatus;
import com.moloco.sdk.service_locator.a;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class v {
    public static final a f = new a(null);
    public static final int g = 8;
    public static final MolocoInitStatus h;
    public static final MolocoInitStatus i;
    public static final String j = "InitializationHandler";
    public static final String k = "Moloco SDK failed to initialize due to unexpected app key";
    public static final String l = "Moloco SDK failed to initialize due to unexpected app key during existing initialization";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final I f2259a;
    public final MutableStateFlow<Initialization> b;
    public final StateFlow<Initialization> c;
    public Init.SDKInitResponse d;
    public final MutableStateFlow<InterfaceC2985a> e;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MolocoInitStatus a() {
            return v.h;
        }

        public final MolocoInitStatus b() {
            return v.i;
        }

        public a() {
        }

        public final MolocoInitStatus a(String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            return new MolocoInitStatus(Initialization.FAILURE, errorMessage);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler", f = "InitializationHandler.kt", i = {}, l = {85}, m = "awaitAdFactory", n = {}, s = {})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f2260a;
        public int c;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2260a = obj;
            this.c |= Integer.MIN_VALUE;
            return v.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler$awaitAdFactory$adFactory$1", f = "InitializationHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<InterfaceC2985a, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2261a;
        public /* synthetic */ Object b;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC2985a interfaceC2985a, Continuation<? super Boolean> continuation) {
            return ((c) create(interfaceC2985a, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2261a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(((InterfaceC2985a) this.b) != null);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler", f = "InitializationHandler.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3}, l = {TextFieldImplKt.AnimationDuration, 153, 183, 184, PsExtractor.AUDIO_STREAM}, m = "handleInitializationResult", n = {"result", "trackingApi", "metricsRecorder", "initTimerEvent", "latency", "result", "metricsRecorder", "initTimerEvent", "this", "trackingApi", "metricsRecorder", "initTimerEvent", "$this$handleInitializationResult_u24lambda_u240", "latency", "this", "metricsRecorder", "initTimerEvent", "$this$handleInitializationResult_u24lambda_u240"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2262a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public long f;
        public /* synthetic */ Object g;
        public int i;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return v.this.a((com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>) null, 0L, (com.moloco.sdk.internal.services.init.n) null, (MetricsRecorder) null, (TimerEvent) null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler", f = "InitializationHandler.kt", i = {0, 0, 0, 1}, l = {112, 116, 120}, m = MobileAdsBridgeBase.initializeMethodName, n = {"this", "metricsRecorder", "clientFailureType", "clientFailureType"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2263a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return v.this.a(null, null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InitializationHandler$startInitialization$2", f = "InitializationHandler.kt", i = {0, 0, 1}, l = {TsExtractor.TS_STREAM_TYPE_SPLICE_INFO, TsExtractor.TS_STREAM_TYPE_DTS}, m = "invokeSuspend", n = {"acmInitTimer", "startTime", "result"}, s = {"L$0", "J$0", "L$0"})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2264a;
        public long b;
        public int c;
        public final /* synthetic */ MetricsRecorder d;
        public final /* synthetic */ v e;
        public final /* synthetic */ String f;
        public final /* synthetic */ MediationInfo g;
        public final /* synthetic */ com.moloco.sdk.internal.services.init.n h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MetricsRecorder metricsRecorder, v vVar, String str, MediationInfo mediationInfo, com.moloco.sdk.internal.services.init.n nVar, Continuation<? super f> continuation) {
            super(2, continuation);
            this.d = metricsRecorder;
            this.e = vVar;
            this.f = str;
            this.g = mediationInfo;
            this.h = nVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.d, this.e, this.f, this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            TimerEvent timerEvent;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, v.j, "startInitialization switch to Dispatchers.IO", null, false, 12, null);
                TimerEvent timerEventStartTimerEvent = this.d.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.b.c());
                long jA = this.e.f().a();
                com.moloco.sdk.internal.services.init.k kVarB = a.f.f2424a.b();
                String str = this.f;
                MediationInfo mediationInfo = this.g;
                this.f2264a = timerEventStartTimerEvent;
                this.b = jA;
                this.c = 1;
                obj = kVarB.a(str, mediationInfo, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                timerEvent = timerEventStartTimerEvent;
                j = jA;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) this.f2264a;
                    ResultKt.throwOnFailure(obj);
                    return vVar;
                }
                j = this.b;
                TimerEvent timerEvent2 = (TimerEvent) this.f2264a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
            }
            com.moloco.sdk.internal.v vVar2 = (com.moloco.sdk.internal.v) obj;
            long jA2 = this.e.f().a() - j;
            v vVar3 = this.e;
            com.moloco.sdk.internal.services.init.n nVar = this.h;
            MetricsRecorder metricsRecorder = this.d;
            this.f2264a = vVar2;
            this.c = 2;
            return vVar3.a((com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>) vVar2, jA2, nVar, metricsRecorder, timerEvent, this) == coroutine_suspended ? coroutine_suspended : vVar2;
        }
    }

    static {
        Initialization initialization = Initialization.SUCCESS;
        h = new MolocoInitStatus(initialization, "Already Initialized");
        i = new MolocoInitStatus(initialization, "Initialized");
    }

    public v(I timeProviderService) {
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.f2259a = timeProviderService;
        MutableStateFlow<Initialization> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.b = MutableStateFlow;
        this.c = FlowKt.asStateFlow(MutableStateFlow);
        this.e = StateFlowKt.MutableStateFlow(null);
    }

    public final boolean c() {
        return g();
    }

    public final StateFlow<Initialization> d() {
        return this.c;
    }

    public final Init.SDKInitResponse e() {
        return this.d;
    }

    public final I f() {
        return this.f2259a;
    }

    public final boolean g() {
        try {
            a.i.f2427a.c();
            return true;
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public final Object b(String str, MediationInfo mediationInfo, com.moloco.sdk.internal.services.init.n nVar, MetricsRecorder metricsRecorder, Continuation<? super com.moloco.sdk.internal.v<Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new f(metricsRecorder, this, str, mediationInfo, nVar, null), continuation);
    }

    public final Object b(Continuation<? super Unit> continuation) {
        this.d = null;
        this.e.setValue(null);
        this.b.setValue(null);
        Object objA = a.f.f2424a.b().a(continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.InterfaceC2985a> r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.moloco.sdk.internal.publisher.v.b
            if (r0 == 0) goto L13
            r0 = r12
            com.moloco.sdk.internal.publisher.v$b r0 = (com.moloco.sdk.internal.publisher.v.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.v$b r0 = new com.moloco.sdk.internal.publisher.v$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f2260a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r12)
            goto L53
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L31:
            kotlin.ResultKt.throwOnFailure(r12)
            com.moloco.sdk.internal.MolocoLogger r4 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            r9 = 12
            r10 = 0
            java.lang.String r5 = "InitializationHandler"
            java.lang.String r6 = "Moloco SDK awaiting init to receive AdFactory"
            r7 = 0
            r8 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r4, r5, r6, r7, r8, r9, r10)
            kotlinx.coroutines.flow.MutableStateFlow<com.moloco.sdk.internal.a> r12 = r11.e
            com.moloco.sdk.internal.publisher.v$c r2 = new com.moloco.sdk.internal.publisher.v$c
            r4 = 0
            r2.<init>(r4)
            r0.c = r3
            java.lang.Object r12 = kotlinx.coroutines.flow.FlowKt.first(r12, r2, r0)
            if (r12 != r1) goto L53
            return r1
        L53:
            java.lang.String r0 = "null cannot be cast to non-null type com.moloco.sdk.internal.AdFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r0)
            com.moloco.sdk.internal.a r12 = (com.moloco.sdk.internal.InterfaceC2985a) r12
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            r5 = 12
            r6 = 0
            java.lang.String r1 = "InitializationHandler"
            java.lang.String r2 = "Moloco SDK init completed, AdFactory received"
            r3 = 0
            r4 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r0, r1, r2, r3, r4, r5, r6)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.v.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r17, com.moloco.sdk.publisher.MediationInfo r18, com.moloco.sdk.internal.services.init.n r19, com.moloco.sdk.acm.recorder.MetricsRecorder r20, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.v.a(java.lang.String, com.moloco.sdk.publisher.MediationInfo, com.moloco.sdk.internal.services.init.n, com.moloco.sdk.acm.recorder.MetricsRecorder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0109 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0254 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.moloco.sdk.internal.v<com.moloco.sdk.Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j> r24, long r25, com.moloco.sdk.internal.services.init.n r27, com.moloco.sdk.acm.recorder.MetricsRecorder r28, com.moloco.sdk.acm.TimerEvent r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.v.a(com.moloco.sdk.internal.v, long, com.moloco.sdk.internal.services.init.n, com.moloco.sdk.acm.recorder.MetricsRecorder, com.moloco.sdk.acm.TimerEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
