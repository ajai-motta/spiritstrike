package com.moloco.sdk.internal.publisher;

import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.K;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdErrorKt;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Result;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C2993d implements AdLoad {
    public static final a o = new a(null);
    public static final int p = 8;
    public static final String q = "AdLoad";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Long, Duration> f2173a;
    public final String b;
    public final Function1<com.moloco.sdk.internal.ortb.model.c, InterfaceC3018b> c;
    public final com.moloco.sdk.internal.ortb.a d;
    public final p e;
    public final AdFormatType f;
    public final K g;
    public final MetricsRecorder h;
    public final CoroutineScope i;
    public boolean j;
    public String k;
    public com.moloco.sdk.internal.ortb.model.e l;
    public final TimerEvent m;
    public Job n;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$b */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$load$2", f = "AdLoad.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2174a;
        public final /* synthetic */ String c;
        public final /* synthetic */ AdLoad.Listener d;
        public final /* synthetic */ long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, AdLoad.Listener listener, long j, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = listener;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C2993d.this.new b(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.moloco.sdk.internal.ortb.model.d ext;
            com.moloco.sdk.internal.ortb.model.d ext2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2174a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                C2993d c2993d = C2993d.this;
                String str = this.c;
                this.f2174a = 1;
                obj = c2993d.a(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            String str2 = (String) obj;
            if (str2 == null) {
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, "AdLoadImpl", "Could not pre-process the bid response. Failing the load() call.", null, false, 12, null);
                AdLoad.Listener listener = this.d;
                if (listener != null) {
                    listener.onAdLoadFailed(MolocoAdErrorKt.createAdErrorInfo(C2993d.this.b, MolocoAdError.ErrorType.AD_BID_PARSE_ERROR));
                }
                MetricsRecorder metricsRecorder = C2993d.this.h;
                TimerEvent timerEventWithTag = C2993d.this.m.withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
                com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.b;
                String strC = dVar.c();
                MolocoAdError.ErrorType errorType = MolocoAdError.ErrorType.AD_BID_PARSE_ERROR;
                TimerEvent timerEventWithTag2 = timerEventWithTag.withTag(strC, String.valueOf(errorType.getErrorCode()));
                com.moloco.sdk.internal.client_metrics_data.d dVar2 = com.moloco.sdk.internal.client_metrics_data.d.c;
                String strC2 = dVar2.c();
                String strName = C2993d.this.f.name();
                Locale locale = Locale.ROOT;
                String lowerCase = strName.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                metricsRecorder.recordTimerEvent(timerEventWithTag2.withTag(strC2, lowerCase));
                MetricsRecorder metricsRecorder2 = C2993d.this.h;
                CountEvent countEventWithTag = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.m.c()).withTag(dVar.c(), String.valueOf(errorType.getErrorCode()));
                String strC3 = dVar2.c();
                String lowerCase2 = C2993d.this.f.name().toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                metricsRecorder2.recordCountEvent(countEventWithTag.withTag(strC3, lowerCase2));
                return Unit.INSTANCE;
            }
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.info$default(molocoLogger, C2993d.q, "Processed the bidResponse, proceeding with the load() call.", null, false, 12, null);
            x xVarA = C2996g.a(this.d, C2993d.this.m, C2993d.this.f, C2993d.this.h);
            if (Intrinsics.areEqual(C2993d.this.k, str2)) {
                if (C2993d.this.isLoaded()) {
                    com.moloco.sdk.internal.ortb.model.x sdkEvents = null;
                    MolocoAd molocoAdCreateAdInfo$default = MolocoAdKt.createAdInfo$default(C2993d.this.b, null, null, 6, null);
                    long j = this.e;
                    C2993d c2993d2 = C2993d.this;
                    com.moloco.sdk.internal.ortb.model.c cVarA = c2993d2.a(c2993d2.l);
                    xVarA.a(molocoAdCreateAdInfo$default, j, (cVarA == null || (ext2 = cVarA.getExt()) == null) ? null : ext2.getSdkEvents());
                    C2993d c2993d3 = C2993d.this;
                    com.moloco.sdk.internal.ortb.model.c cVarA2 = c2993d3.a(c2993d3.l);
                    if (cVarA2 != null && (ext = cVarA2.getExt()) != null) {
                        sdkEvents = ext.getSdkEvents();
                    }
                    xVarA.a(molocoAdCreateAdInfo$default, sdkEvents);
                    return Unit.INSTANCE;
                }
                Job job = C2993d.this.n;
                if (job != null && job.isActive()) {
                    MolocoLogger.info$default(molocoLogger, C2993d.q, "Already loading ad " + C2993d.this.f + ' ' + C2993d.this.b + ". Returning", null, false, 12, null);
                    return Unit.INSTANCE;
                }
            }
            C2993d.this.a(str2, this.e, xVarA);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$c */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl", f = "AdLoad.kt", i = {0}, l = {162}, m = "processBidResponse", n = {"bidResponseJson"}, s = {"L$0"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2175a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return C2993d.this.a((String) null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1", f = "AdLoad.kt", i = {0}, l = {183}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C0393d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2176a;
        public /* synthetic */ Object b;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ x f;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d$a */
        public static final class a implements InterfaceC3018b.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C2993d f2177a;
            public final /* synthetic */ x b;
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c c;

            /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoad$1", f = "AdLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0394a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2178a;
                public final /* synthetic */ C2993d b;
                public final /* synthetic */ x c;
                public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0394a(C2993d c2993d, x xVar, com.moloco.sdk.internal.ortb.model.c cVar, Continuation<? super C0394a> continuation) {
                    super(2, continuation);
                    this.b = c2993d;
                    this.c = xVar;
                    this.d = cVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0394a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0394a(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    com.moloco.sdk.internal.ortb.model.d ext;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f2178a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.b.j = true;
                    x xVar = this.c;
                    MolocoAd molocoAdCreateAdInfo = MolocoAdKt.createAdInfo(this.b.b, Boxing.boxFloat(this.d.getPrice()), this.d.getCrid());
                    C2993d c2993d = this.b;
                    com.moloco.sdk.internal.ortb.model.c cVarA = c2993d.a(c2993d.l);
                    xVar.a(molocoAdCreateAdInfo, (cVarA == null || (ext = cVarA.getExt()) == null) ? null : ext.getSdkEvents());
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d$a$b */
            @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoadError$1", f = "AdLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2179a;
                public final /* synthetic */ C2993d b;
                public final /* synthetic */ x c;
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public b(C2993d c2993d, x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar, Continuation<? super b> continuation) {
                    super(2, continuation);
                    this.b = c2993d;
                    this.c = xVar;
                    this.d = cVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new b(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    com.moloco.sdk.internal.ortb.model.d ext;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f2179a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.b.j = false;
                    x xVar = this.c;
                    com.moloco.sdk.internal.s sVarA = com.moloco.sdk.internal.t.a(this.b.b, MolocoAdError.ErrorType.AD_LOAD_FAILED, this.d);
                    C2993d c2993d = this.b;
                    com.moloco.sdk.internal.ortb.model.c cVarA = c2993d.a(c2993d.l);
                    xVar.a(sVarA, (cVarA == null || (ext = cVarA.getExt()) == null) ? null : ext.getSdkEvents());
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.d$d$a$c */
            @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdLoadImpl$startLoadJob$1$2$onLoadTimeout$1", f = "AdLoad.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2180a;
                public final /* synthetic */ C2993d b;
                public final /* synthetic */ x c;
                public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public c(C2993d c2993d, x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar, Continuation<? super c> continuation) {
                    super(2, continuation);
                    this.b = c2993d;
                    this.c = xVar;
                    this.d = aVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new c(this.b, this.c, this.d, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    com.moloco.sdk.internal.ortb.model.d ext;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f2180a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.b.j = false;
                    x xVar = this.c;
                    com.moloco.sdk.internal.s sVarA = com.moloco.sdk.internal.t.a(this.b.b, MolocoAdError.ErrorType.AD_LOAD_TIMEOUT_ERROR, this.d);
                    C2993d c2993d = this.b;
                    com.moloco.sdk.internal.ortb.model.c cVarA = c2993d.a(c2993d.l);
                    xVar.a(sVarA, (cVarA == null || (ext = cVarA.getExt()) == null) ? null : ext.getSdkEvents());
                    return Unit.INSTANCE;
                }
            }

            public a(C2993d c2993d, x xVar, com.moloco.sdk.internal.ortb.model.c cVar) {
                this.f2177a = c2993d;
                this.b = xVar;
                this.c = cVar;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b.a
            public void a() {
                BuildersKt__Builders_commonKt.launch$default(this.f2177a.i, null, null, new C0394a(this.f2177a, this.b, this.c, null), 3, null);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                Intrinsics.checkNotNullParameter(timeoutError, "timeoutError");
                BuildersKt__Builders_commonKt.launch$default(this.f2177a.i, null, null, new c(this.f2177a, this.b, timeoutError, null), 3, null);
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b.a
            public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                Intrinsics.checkNotNullParameter(internalError, "internalError");
                BuildersKt__Builders_commonKt.launch$default(this.f2177a.i, null, null, new b(this.f2177a, this.b, internalError, null), 3, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0393d(String str, long j, x xVar, Continuation<? super C0393d> continuation) {
            super(2, continuation);
            this.d = str;
            this.e = j;
            this.f = xVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0393d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0393d c0393d = C2993d.this.new C0393d(this.d, this.e, this.f, continuation);
            c0393d.b = obj;
            return c0393d;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00cc  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x00f6  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 295
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.C2993d.C0393d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2993d(CoroutineScope scope, Function1<? super Long, Duration> timeout, String adUnitId, Function1<? super com.moloco.sdk.internal.ortb.model.c, ? extends InterfaceC3018b> recreateXenossAdLoader, com.moloco.sdk.internal.ortb.a parseBidResponse, p adLoadPreprocessor, AdFormatType adFormatType, K webViewChecker, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(recreateXenossAdLoader, "recreateXenossAdLoader");
        Intrinsics.checkNotNullParameter(parseBidResponse, "parseBidResponse");
        Intrinsics.checkNotNullParameter(adLoadPreprocessor, "adLoadPreprocessor");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(webViewChecker, "webViewChecker");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f2173a = timeout;
        this.b = adUnitId;
        this.c = recreateXenossAdLoader;
        this.d = parseBidResponse;
        this.e = adLoadPreprocessor;
        this.f = adFormatType;
        this.g = webViewChecker;
        this.h = metricsRecorder;
        this.i = CoroutineScopeKt.plus(scope, com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.m = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.j.c());
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.j;
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(this.g.a());
        if (thM7418exceptionOrNullimpl != null) {
            MolocoLogger.INSTANCE.error(q, "WebView Error: " + thM7418exceptionOrNullimpl.getMessage(), thM7418exceptionOrNullimpl, true);
            if (listener != null) {
                listener.onAdLoadFailed(MolocoAdErrorKt.createAdErrorInfo(this.b, MolocoAdError.ErrorType.AD_LOAD_WEBVIEW_FAILED));
                return;
            }
            return;
        }
        long jA = a.h.f2426a.h().a();
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "AdLoadImpl", "load() called with bidResponseJson: " + bidResponseJson, false, 4, null);
        this.m.startTimer();
        MetricsRecorder metricsRecorder = this.h;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.k.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.d.c.c();
        String lowerCase = this.f.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordCountEvent(countEvent.withTag(strC, lowerCase));
        BuildersKt__Builders_commonKt.launch$default(this.i, null, null, new b(bidResponseJson, listener, jA, null), 3, null);
    }

    public final com.moloco.sdk.internal.ortb.model.c a(com.moloco.sdk.internal.ortb.model.e eVar) {
        List<com.moloco.sdk.internal.ortb.model.y> listB;
        com.moloco.sdk.internal.ortb.model.y yVar;
        List<com.moloco.sdk.internal.ortb.model.c> listB2;
        if (eVar == null || (listB = eVar.b()) == null || (yVar = listB.get(0)) == null || (listB2 = yVar.b()) == null) {
            return null;
        }
        return listB2.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r5, kotlin.coroutines.Continuation<? super java.lang.String> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.moloco.sdk.internal.publisher.C2993d.c
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.internal.publisher.d$c r0 = (com.moloco.sdk.internal.publisher.C2993d.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.d$c r0 = new com.moloco.sdk.internal.publisher.d$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f2175a
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r6)
            com.moloco.sdk.internal.publisher.p r6 = r4.e
            r0.f2175a = r5
            r0.d = r3
            java.lang.Object r6 = r6.a(r5, r0)
            if (r6 != r1) goto L45
            return r1
        L45:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L4a
            return r6
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.C2993d.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(String str, long j, x xVar) {
        Job job = this.n;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.n = BuildersKt__Builders_commonKt.launch$default(this.i, null, null, new C0393d(str, j, xVar, null), 3, null);
    }
}
