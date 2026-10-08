package com.moloco.sdk.internal.publisher;

import android.content.Context;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.ortb.model.C2988a;
import com.moloco.sdk.internal.publisher.u;
import com.moloco.sdk.internal.services.InterfaceC3005f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.FullscreenAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3017a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class u<T extends AdShowListener> implements FullscreenAd<T>, r {
    public static final int t = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2251a;
    public final InterfaceC3005f b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c;
    public final String d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i e;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r f;
    public final Function1<com.moloco.sdk.internal.ortb.model.v, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h> g;
    public final t<T> h;
    public final AdFormatType i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z j;
    public final C2990a k;
    public final MetricsRecorder l;
    public final CoroutineScope m;
    public final TimerEvent n;
    public TimerEvent o;
    public final AdLoad p;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h q;
    public C2988a r;
    public Function1<? super Boolean, Unit> s;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Long, Duration> {
        public a(Object obj) {
            super(1, obj, C2990a.class, "calculateTimeout", "calculateTimeout-5sfh64U(J)J", 0);
        }

        public final long a(long j) {
            return ((C2990a) this.receiver).a(j);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Duration invoke(Long l) {
            return Duration.m8777boximpl(a(l.longValue()));
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<com.moloco.sdk.internal.ortb.model.c, InterfaceC3018b> {
        public b(Object obj) {
            super(1, obj, u.class, "recreateXenossAd", "recreateXenossAd(Lcom/moloco/sdk/internal/ortb/model/Bid;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/AdLoad;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC3018b invoke(com.moloco.sdk.internal.ortb.model.c p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((u) this.receiver).a(p0);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1", f = "FullscreenAdImpl.kt", i = {}, l = {267, 269}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2252a;
        public final /* synthetic */ InterfaceC3017a b;
        public final /* synthetic */ y c;
        public final /* synthetic */ u<T> d;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1$1", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2253a;
            public /* synthetic */ boolean b;

            public a(Continuation<? super a> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Boolean> continuation) {
                return ((a) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(continuation);
                aVar.b = ((Boolean) obj).booleanValue();
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f2253a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(this.b);
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$listenToAdDisplayState$1$1$2", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2254a;
            public /* synthetic */ boolean b;

            public b(Continuation<? super b> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Boolean> continuation) {
                return ((b) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                b bVar = new b(continuation);
                bVar.b = ((Boolean) obj).booleanValue();
                return bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f2254a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(!this.b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(InterfaceC3017a interfaceC3017a, y yVar, u<? super T> uVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = interfaceC3017a;
            this.c = yVar;
            this.d = uVar;
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

        /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.f2252a
                r2 = 6
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L20
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                kotlin.ResultKt.throwOnFailure(r7)
                goto L5c
            L14:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1c:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L37
            L20:
                kotlin.ResultKt.throwOnFailure(r7)
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a r7 = r6.b
                kotlinx.coroutines.flow.StateFlow r7 = r7.l()
                com.moloco.sdk.internal.publisher.u$c$a r1 = new com.moloco.sdk.internal.publisher.u$c$a
                r1.<init>(r5)
                r6.f2252a = r4
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.first(r7, r1, r6)
                if (r7 != r0) goto L37
                return r0
            L37:
                com.moloco.sdk.internal.publisher.y r7 = r6.c
                if (r7 == 0) goto L48
                com.moloco.sdk.internal.publisher.u<T extends com.moloco.sdk.publisher.AdShowListener> r1 = r6.d
                java.lang.String r1 = com.moloco.sdk.internal.publisher.u.d(r1)
                com.moloco.sdk.publisher.MolocoAd r1 = com.moloco.sdk.publisher.MolocoAdKt.createAdInfo$default(r1, r5, r5, r2, r5)
                r7.onAdShowSuccess(r1)
            L48:
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.a r7 = r6.b
                kotlinx.coroutines.flow.StateFlow r7 = r7.l()
                com.moloco.sdk.internal.publisher.u$c$b r1 = new com.moloco.sdk.internal.publisher.u$c$b
                r1.<init>(r5)
                r6.f2252a = r3
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.first(r7, r1, r6)
                if (r7 != r0) goto L5c
                return r0
            L5c:
                com.moloco.sdk.internal.publisher.y r7 = r6.c
                if (r7 == 0) goto L6d
                com.moloco.sdk.internal.publisher.u<T extends com.moloco.sdk.publisher.AdShowListener> r0 = r6.d
                java.lang.String r0 = com.moloco.sdk.internal.publisher.u.d(r0)
                com.moloco.sdk.publisher.MolocoAd r0 = com.moloco.sdk.publisher.MolocoAdKt.createAdInfo$default(r0, r5, r5, r2, r5)
                r7.onAdHidden(r0)
            L6d:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.u.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$load$1", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2255a;
        public final /* synthetic */ u<T> b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AdLoad.Listener d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(u<? super T> uVar, String str, AdLoad.Listener listener, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = uVar;
            this.c = str;
            this.d = listener;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2255a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.p.load(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    public static final class f implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u<T> f2257a;
        public final /* synthetic */ y b;

        /* JADX WARN: Multi-variable type inference failed */
        public f(u<? super T> uVar, y yVar) {
            this.f2257a = uVar;
            this.b = yVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            u<T> uVar = this.f2257a;
            uVar.a(com.moloco.sdk.internal.t.a(uVar.d, MolocoAdError.ErrorType.AD_SHOW_ERROR, internalShowError));
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a() {
            y yVar = this.b;
            if (yVar != null) {
                yVar.onAdClicked(MolocoAdKt.createAdInfo$default(this.f2257a.d, null, null, 6, null));
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.FullscreenAdImpl$show$2", f = "FullscreenAdImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2258a;
        public final /* synthetic */ T b;
        public final /* synthetic */ u<T> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(T t, u<? super T> uVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = t;
            this.c = uVar;
        }

        public static final j b(u uVar) {
            return uVar.a();
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2258a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            InterfaceC3017a interfaceC3017a = null;
            if (this.b != null) {
                t tVar = this.c.h;
                T t = this.b;
                InterfaceC3005f interfaceC3005f = this.c.b;
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = this.c.c;
                final u<T> uVar = this.c;
                Function0 function0 = new Function0() { // from class: com.moloco.sdk.internal.publisher.u$g$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return u.g.a(uVar);
                    }
                };
                final u<T> uVar2 = this.c;
                tVar.a(new C(t, interfaceC3005f, aVar, function0, new Function0() { // from class: com.moloco.sdk.internal.publisher.u$g$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return u.g.b(uVar2);
                    }
                }, this.c.i, this.c.l));
            } else {
                this.c.h.a((y) null);
            }
            y yVarD = this.c.h.d();
            if (this.c.h.a() instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVarA = this.c.h.a();
                if (lVarA instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) {
                    interfaceC3017a = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) lVarA;
                }
            } else {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVarA2 = this.c.h.a();
                if (lVarA2 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p) {
                    interfaceC3017a = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p) lVarA2;
                }
            }
            if (interfaceC3017a == null || !this.c.isLoaded()) {
                if (yVarD != null) {
                    yVarD.a(com.moloco.sdk.internal.t.a(this.c.d, MolocoAdError.ErrorType.AD_SHOW_ERROR_NOT_LOADED, com.moloco.sdk.internal.o.d));
                }
                return Unit.INSTANCE;
            }
            if (interfaceC3017a.l().getValue().booleanValue()) {
                if (yVarD != null) {
                    yVarD.a(com.moloco.sdk.internal.t.a(this.c.d, MolocoAdError.ErrorType.AD_SHOW_ERROR_ALREADY_DISPLAYING, com.moloco.sdk.internal.o.e));
                }
                return Unit.INSTANCE;
            }
            this.c.a(interfaceC3017a, yVarD);
            if (interfaceC3017a instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.w) interfaceC3017a).a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u(), this.c.b(yVarD));
            } else if (interfaceC3017a instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p) {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.p) interfaceC3017a).a(this.c.q, this.c.a(yVarD));
            }
            return Unit.INSTANCE;
        }

        public static final com.moloco.sdk.internal.ortb.model.x a(u uVar) {
            return uVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Context context, InterfaceC3005f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adUnitId, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r externalLinkHandler, Function1<? super com.moloco.sdk.internal.ortb.model.v, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h> generateAggregatedOptions, t<T> adDataHolder, AdFormatType adFormatType, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C2990a adCreateLoadTimeoutManager, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(generateAggregatedOptions, "generateAggregatedOptions");
        Intrinsics.checkNotNullParameter(adDataHolder, "adDataHolder");
        Intrinsics.checkNotNullParameter(adFormatType, "adFormatType");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f2251a = context;
        this.b = appLifecycleTrackerService;
        this.c = customUserEventBuilderService;
        this.d = adUnitId;
        this.e = persistentHttpRequest;
        this.f = externalLinkHandler;
        this.g = generateAggregatedOptions;
        this.h = adDataHolder;
        this.i = adFormatType;
        this.j = watermark;
        this.k = adCreateLoadTimeoutManager;
        this.l = metricsRecorder;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.m = CoroutineScope;
        TimerEvent timerEventStartTimerEvent = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.q.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.d.c.c();
        String lowerCase = adFormatType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.n = timerEventStartTimerEvent.withTag(strC, lowerCase);
        this.p = C2994e.a(CoroutineScope, new a(adCreateLoadTimeoutManager), adUnitId, new b(this), adFormatType, a.C0415a.f2419a.b(), metricsRecorder);
        this.q = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h) generateAggregatedOptions.invoke(null);
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.m, null, 1, null);
        a(this, null, 1, null);
        this.s = null;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.k.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.p.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        this.l.recordTimerEvent(this.n);
        this.o = this.l.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.p.c());
        BuildersKt__Builders_commonKt.launch$default(this.m, null, null, new d(this, bidResponseJson, listener, null), 3, null);
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.k.setCreateAdObjectStartTime(j);
    }

    @Override // com.moloco.sdk.publisher.FullscreenAd
    public void show(T t2) {
        TimerEvent timerEvent = this.o;
        if (timerEvent != null) {
            MetricsRecorder metricsRecorder = this.l;
            String strC = com.moloco.sdk.internal.client_metrics_data.d.c.c();
            String lowerCase = this.i.name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            metricsRecorder.recordTimerEvent(timerEvent.withTag(strC, lowerCase));
        }
        MetricsRecorder metricsRecorder2 = this.l;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.A.c());
        String strC2 = com.moloco.sdk.internal.client_metrics_data.d.c.c();
        String lowerCase2 = this.i.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        metricsRecorder2.recordCountEvent(countEvent.withTag(strC2, lowerCase2));
        BuildersKt__Builders_commonKt.launch$default(this.m, null, null, new g(t2, this, null), 3, null);
    }

    public final com.moloco.sdk.internal.ortb.model.x c() {
        return this.h.e();
    }

    public final Function1<Boolean, Unit> d() {
        return this.s;
    }

    public final Boolean e() {
        StateFlow<Boolean> stateFlowK;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVarA = this.h.a();
        if (lVarA == null || (stateFlowK = lVarA.k()) == null) {
            return null;
        }
        return stateFlowK.getValue();
    }

    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i b() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVarA = this.h.a();
        if (lVarA != null) {
            return lVarA.getCreativeType();
        }
        return null;
    }

    public final f b(y yVar) {
        return new f(this, yVar);
    }

    public final j a() {
        return this.h.c();
    }

    public static /* synthetic */ void a(u uVar, com.moloco.sdk.internal.s sVar, int i, Object obj) {
        if ((i & 1) != 0) {
            sVar = null;
        }
        uVar.a(sVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(com.moloco.sdk.internal.s sVar) {
        StateFlow<Boolean> stateFlowL;
        t<T> tVar = this.h;
        Job jobB = tVar.b();
        if (jobB != null) {
            Job.DefaultImpls.cancel$default(jobB, (CancellationException) null, 1, (Object) null);
        }
        tVar.a((Job) null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVarA = this.h.a();
        boolean z = (lVarA == null || (stateFlowL = lVarA.l()) == null || !stateFlowL.getValue().booleanValue()) ? false : true;
        t<T> tVar2 = this.h;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVarA2 = tVar2.a();
        if (lVarA2 != null) {
            lVarA2.destroy();
        }
        tVar2.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?>) null);
        t<T> tVar3 = this.h;
        y yVarD = tVar3.d();
        tVar3.a((y) null);
        if (sVar != null && yVarD != null) {
            yVarD.a(sVar);
        }
        if (z && yVarD != null) {
            yVarD.onAdHidden(MolocoAdKt.createAdInfo$default(this.d, null, null, 6, null));
        }
        this.h.a((com.moloco.sdk.internal.ortb.model.x) null);
        this.h.a((j) null);
    }

    public static final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u<T> f2256a;
        public final /* synthetic */ y b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(u<? super T> uVar, y yVar) {
            this.f2256a = uVar;
            this.b = yVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x
        public void a(boolean z) {
            String strC;
            C2988a c2988a = this.f2256a.r;
            if (c2988a != null) {
                u<T> uVar = this.f2256a;
                if (c2988a.getEnabled() && ((!z || c2988a.getOnSkip()) && (strC = c2988a.getEventLink()) != null)) {
                    uVar.e.a(strC);
                }
            }
            Function1<Boolean, Unit> function1D = this.f2256a.d();
            if (function1D != null) {
                function1D.invoke(Boolean.valueOf(z));
            }
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            u<T> uVar = this.f2256a;
            uVar.a(com.moloco.sdk.internal.t.a(uVar.d, MolocoAdError.ErrorType.AD_SHOW_ERROR, internalShowError));
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a() {
            y yVar = this.b;
            if (yVar != null) {
                yVar.onAdClicked(MolocoAdKt.createAdInfo$default(this.f2256a.d, null, null, 6, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InterfaceC3018b a(com.moloco.sdk.internal.ortb.model.c cVar) {
        com.moloco.sdk.internal.ortb.model.v player;
        a(this, null, 1, null);
        com.moloco.sdk.internal.ortb.model.t configs = cVar.getExt().getConfigs();
        if (configs != null && Intrinsics.areEqual(configs.getServerRenderingEnabled(), Boolean.TRUE)) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.v, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.u> lVarA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.n.a(this.f2251a, cVar.getAdm(), new com.moloco.sdk.internal.services.t(this.f, this.c), this.j, this.l);
            t<T> tVar = this.h;
            tVar.a(lVarA);
            com.moloco.sdk.internal.ortb.model.d ext = cVar.getExt();
            tVar.a(ext != null ? ext.getSdkEvents() : null);
            tVar.a(cVar.getBurl() != null ? new j(cVar.getBurl(), Float.valueOf(cVar.getPrice())) : null);
            return lVarA;
        }
        Function1<com.moloco.sdk.internal.ortb.model.v, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h> function1 = this.g;
        com.moloco.sdk.internal.ortb.model.d ext2 = cVar.getExt();
        this.q = function1.invoke(ext2 != null ? ext2.getPlayer() : null);
        com.moloco.sdk.internal.ortb.model.d ext3 = cVar.getExt();
        this.r = (ext3 == null || (player = ext3.getPlayer()) == null) ? null : player.getAutoStore();
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<?, ?> lVarA2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.n.a(this.f2251a, this.c, null, cVar, this.f, this.j, 4, null);
        t<T> tVar2 = this.h;
        tVar2.a(lVarA2);
        com.moloco.sdk.internal.ortb.model.d ext4 = cVar.getExt();
        tVar2.a(ext4 != null ? ext4.getSdkEvents() : null);
        tVar2.a(cVar.getBurl() != null ? new j(cVar.getBurl(), Float.valueOf(cVar.getPrice())) : null);
        return lVarA2;
    }

    public final void a(InterfaceC3017a interfaceC3017a, y yVar) {
        t<T> tVar = this.h;
        Job jobB = tVar.b();
        if (jobB != null) {
            Job.DefaultImpls.cancel$default(jobB, (CancellationException) null, 1, (Object) null);
        }
        tVar.a(BuildersKt__Builders_commonKt.launch$default(this.m, null, null, new c(interfaceC3017a, yVar, this, null), 3, null));
    }

    public final void a(Function1<? super Boolean, Unit> function1) {
        this.s = function1;
    }

    public final e a(y yVar) {
        return new e(this, yVar);
    }

    public /* synthetic */ u(Context context, InterfaceC3005f interfaceC3005f, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, String str, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, Function1 function1, t tVar, AdFormatType adFormatType, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar, C2990a c2990a, MetricsRecorder metricsRecorder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, interfaceC3005f, aVar, str, iVar, rVar, function1, (i & 128) != 0 ? new t(null, null, null, null, null, 31, null) : tVar, adFormatType, zVar, c2990a, metricsRecorder);
    }
}
