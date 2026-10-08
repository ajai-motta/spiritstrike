package com.moloco.sdk.internal.publisher;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.ortb.model.C2989b;
import com.moloco.sdk.internal.services.InterfaceC3005f;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.BannerAdShowListener;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoAdKt;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3017a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
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
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class m<L extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x> extends Banner implements r {
    public static final a w = new a(null);
    public static final int x = 8;
    public static final int y = 12;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2188a;
    public final InterfaceC3005f b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c;
    public final String d;
    public final boolean e;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r f;
    public final Function8<Context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z, com.moloco.sdk.internal.A, com.moloco.sdk.internal.services.s, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L>> g;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z h;
    public final C2990a i;
    public final com.moloco.sdk.internal.A j;
    public final com.moloco.sdk.internal.i k;
    public final com.moloco.sdk.internal.services.s l;
    public final MetricsRecorder m;
    public final TimerEvent n;
    public TimerEvent o;
    public final CoroutineScope p;
    public final k<L> q;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h r;
    public B s;
    public BannerAdShowListener t;
    public final AdLoad u;
    public final L v;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Long, Duration> {
        public b(Object obj) {
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

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1<com.moloco.sdk.internal.ortb.model.c, InterfaceC3018b> {
        public c(Object obj) {
            super(1, obj, m.class, "recreateXenossAd", "recreateXenossAd(Lcom/moloco/sdk/internal/ortb/model/Bid;)Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/AdLoad;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final InterfaceC3018b invoke(com.moloco.sdk.internal.ortb.model.c p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return ((m) this.receiver).a(p0);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$listenToAdDisplayState$1$1", f = "Banner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2189a;
        public /* synthetic */ boolean b;

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Boolean> continuation) {
            return ((d) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(continuation);
            dVar.b = ((Boolean) obj).booleanValue();
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Boolean> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2189a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(!this.b);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$listenToAdDisplayState$1$2", f = "Banner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2190a;
        public /* synthetic */ boolean b;
        public final /* synthetic */ m<L> c;
        public final /* synthetic */ k<L> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(m<L> mVar, k<L> kVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = mVar;
            this.d = kVar;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((e) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e eVar = new e(this.c, this.d, continuation);
            eVar.b = ((Boolean) obj).booleanValue();
            return eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L> cF;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2190a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z = this.b;
            if (this.c.q.g() && (cF = this.c.q.f()) != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.moloco.sdk.internal.j.a(this.c.k.b()), com.moloco.sdk.internal.j.a(this.c.k.a()));
                layoutParams.gravity = this.c.getCurrentBannerGravity();
                cF.setLayoutParams(layoutParams);
            }
            if (z) {
                TimerEvent timerEvent = this.c.o;
                if (timerEvent != null) {
                    MetricsRecorder metricsRecorder = this.c.m;
                    String strC = com.moloco.sdk.internal.client_metrics_data.d.c.c();
                    String lowerCase = "BANNER".toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    metricsRecorder.recordTimerEvent(timerEvent.withTag(strC, lowerCase));
                }
                B b = this.c.s;
                if (b != null) {
                    b.onAdShowSuccess(MolocoAdKt.createAdInfo$default(this.c.d, null, null, 6, null));
                }
            } else {
                B b2 = this.c.s;
                if (b2 != null) {
                    b2.onAdHidden(MolocoAdKt.createAdInfo$default(this.c.d, null, null, 6, null));
                }
                Job jobA = this.d.a();
                if (jobA != null) {
                    Job.DefaultImpls.cancel$default(jobA, (CancellationException) null, 1, (Object) null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$load$1", f = "Banner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2191a;
        public final /* synthetic */ m<L> b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AdLoad.Listener d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(m<L> mVar, String str, AdLoad.Listener listener, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = mVar;
            this.c = str;
            this.d = listener;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2191a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.u.load(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$recreateXenossAd$touchInterceptor$1$1", f = "Banner.kt", i = {}, l = {257}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2192a;
        public final /* synthetic */ SharedFlow<Unit> b;
        public final /* synthetic */ m<L> c;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ m<L> f2193a;

            public a(m<L> mVar) {
                this.f2193a = mVar;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                this.f2193a.v.a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(SharedFlow<Unit> sharedFlow, m<L> mVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = sharedFlow;
            this.c = mVar;
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
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2192a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<Unit> sharedFlow = this.b;
                a aVar = new a(this.c);
                this.f2192a = 1;
                if (sharedFlow.collect(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BannerViewImpl$recreateXenossAd$touchInterceptor$1$2$1", f = "Banner.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2194a;
        public final /* synthetic */ MotionEvent b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v c;
        public final /* synthetic */ m<L> d;
        public final /* synthetic */ MutableSharedFlow<Unit> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(MotionEvent motionEvent, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v vVar, m<L> mVar, MutableSharedFlow<Unit> mutableSharedFlow, Continuation<? super h> continuation) {
            super(2, continuation);
            this.b = motionEvent;
            this.c = vVar;
            this.d = mVar;
            this.e = mutableSharedFlow;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new h(this.b, this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2194a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MotionEvent motionEvent = this.b;
                if (motionEvent != null) {
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v vVar = this.c;
                    m<L> mVar = this.d;
                    MutableSharedFlow<Unit> mutableSharedFlow = this.e;
                    com.moloco.sdk.internal.services.s sVar = mVar.l;
                    String strC = mVar.q.c();
                    String strD = mVar.q.d();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h hVar = mVar.r;
                    this.f2194a = 1;
                    if (vVar.a(motionEvent, sVar, strC, strD, hVar, mutableSharedFlow, (64 & 64) != 0 ? com.moloco.sdk.internal.y.b() : null, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public static final class i implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m<L> f2195a;

        public i(m<L> mVar) {
            this.f2195a = mVar;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x
        public void a(boolean z) {
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalShowError) {
            Intrinsics.checkNotNullParameter(internalShowError, "internalShowError");
            m<L> mVar = this.f2195a;
            mVar.a(com.moloco.sdk.internal.t.a(mVar.d, MolocoAdError.ErrorType.AD_SHOW_ERROR, internalShowError));
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e
        public void a() {
            B b = this.f2195a.s;
            if (b != null) {
                b.onAdClicked(MolocoAdKt.createAdInfo$default(this.f2195a.d, null, null, 6, null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public m(Context context, InterfaceC3005f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, String adUnitId, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r externalLinkHandler, Function8<? super Context, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a, ? super com.moloco.sdk.internal.ortb.model.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z, ? super com.moloco.sdk.internal.A, ? super com.moloco.sdk.internal.services.s, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L>> createXenossBannerView, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, ? extends L> createXenossBannerAdShowListener, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, C2990a adCreateLoadTimeoutManager, com.moloco.sdk.internal.A viewLifecycleOwner, com.moloco.sdk.internal.i bannerSize, com.moloco.sdk.internal.services.s clickthroughService, MetricsRecorder metricsRecorder) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(createXenossBannerView, "createXenossBannerView");
        Intrinsics.checkNotNullParameter(createXenossBannerAdShowListener, "createXenossBannerAdShowListener");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(adCreateLoadTimeoutManager, "adCreateLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(bannerSize, "bannerSize");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f2188a = context;
        this.b = appLifecycleTrackerService;
        this.c = customUserEventBuilderService;
        this.d = adUnitId;
        this.e = z;
        this.f = externalLinkHandler;
        this.g = createXenossBannerView;
        this.h = watermark;
        this.i = adCreateLoadTimeoutManager;
        this.j = viewLifecycleOwner;
        this.k = bannerSize;
        this.l = clickthroughService;
        this.m = metricsRecorder;
        if (getLayoutParams() == null) {
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        }
        TimerEvent timerEventStartTimerEvent = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.q.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.d.c.c();
        String lowerCase = "BANNER".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.n = timerEventStartTimerEvent.withTag(strC, lowerCase);
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.p = CoroutineScope;
        this.q = new k<>(null, null, null, null, null, null, false, 127, null);
        this.r = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j.a();
        this.u = C2994e.a(CoroutineScope, new b(adCreateLoadTimeoutManager), adUnitId, new c(this), AdFormatType.BANNER, a.C0415a.f2419a.b(), metricsRecorder);
        this.v = createXenossBannerAdShowListener.invoke(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getCurrentBannerGravity() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 0;
    }

    public static final com.moloco.sdk.internal.ortb.model.x l(m mVar) {
        return mVar.q.e();
    }

    public static final j m(m mVar) {
        return mVar.q.b();
    }

    @Override // com.moloco.sdk.publisher.Destroyable
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.p, null, 1, null);
        a(this, null, 1, null);
        setAdShowListener(null);
        this.s = null;
    }

    @Override // com.moloco.sdk.publisher.Banner
    public BannerAdShowListener getAdShowListener() {
        return this.t;
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public long getCreateAdObjectStartTime() {
        return this.i.getCreateAdObjectStartTime();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public boolean isLoaded() {
        return this.u.isLoaded();
    }

    @Override // com.moloco.sdk.publisher.AdLoad
    public void load(String bidResponseJson, AdLoad.Listener listener) {
        Intrinsics.checkNotNullParameter(bidResponseJson, "bidResponseJson");
        this.m.recordTimerEvent(this.n);
        this.o = this.m.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.p.c());
        BuildersKt__Builders_commonKt.launch$default(this.p, null, null, new f(this, bidResponseJson, listener, null), 3, null);
    }

    @Override // com.moloco.sdk.publisher.Banner
    public void setAdShowListener(BannerAdShowListener bannerAdShowListener) {
        B bA = a(bannerAdShowListener);
        this.s = bA;
        this.t = bA.a();
    }

    @Override // com.moloco.sdk.internal.publisher.r
    public void setCreateAdObjectStartTime(long j) {
        this.i.setCreateAdObjectStartTime(j);
    }

    public final B a(BannerAdShowListener bannerAdShowListener) {
        return new B(bannerAdShowListener, this.b, this.c, new Function0() { // from class: com.moloco.sdk.internal.publisher.m$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return m.l(this.f$0);
            }
        }, new Function0() { // from class: com.moloco.sdk.internal.publisher.m$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return m.m(this.f$0);
            }
        }, AdFormatType.BANNER, this.m);
    }

    public static /* synthetic */ void a(m mVar, com.moloco.sdk.internal.s sVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sVar = null;
        }
        mVar.a(sVar);
    }

    public final void a(com.moloco.sdk.internal.s sVar) {
        B b2;
        B b3;
        k<L> kVar = this.q;
        Job jobA = kVar.a();
        if (jobA != null) {
            Job.DefaultImpls.cancel$default(jobA, (CancellationException) null, 1, (Object) null);
        }
        kVar.a((Job) null);
        boolean zBooleanValue = a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C) this.q.f()).getValue().booleanValue();
        k<L> kVar2 = this.q;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L> cF = kVar2.f();
        if (cF != null) {
            cF.destroy();
        }
        kVar2.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C) null);
        if (sVar != null && (b3 = this.s) != null) {
            b3.a(sVar);
        }
        if (zBooleanValue && (b2 = this.s) != null) {
            b2.onAdHidden(MolocoAdKt.createAdInfo$default(this.d, null, null, 6, null));
        }
        this.q.a((com.moloco.sdk.internal.ortb.model.x) null);
        this.q.a((j) null);
    }

    public final InterfaceC3018b a(com.moloco.sdk.internal.ortb.model.c cVar) {
        C2989b bannerClickMetaData;
        C2989b bannerClickMetaData2;
        a(this, null, 1, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L> cInvoke = this.g.invoke(this.f2188a, this.c, cVar, this.f, this.h, this.j, this.l, this.r);
        k<L> kVar = this.q;
        kVar.a(cInvoke);
        kVar.a(cVar.getExt().getSdkEvents());
        kVar.a(cVar.getBurl() != null ? new j(cVar.getBurl(), Float.valueOf(cVar.getPrice())) : null);
        com.moloco.sdk.internal.ortb.model.s molocoSdkClickMetaData = cVar.getExt().getMolocoSdkClickMetaData();
        kVar.b((molocoSdkClickMetaData == null || (bannerClickMetaData2 = molocoSdkClickMetaData.getBannerClickMetaData()) == null) ? null : bannerClickMetaData2.getClickThrough());
        com.moloco.sdk.internal.ortb.model.s molocoSdkClickMetaData2 = cVar.getExt().getMolocoSdkClickMetaData();
        kVar.a((molocoSdkClickMetaData2 == null || (bannerClickMetaData = molocoSdkClickMetaData2.getBannerClickMetaData()) == null) ? null : bannerClickMetaData.getClickTracking());
        com.moloco.sdk.internal.ortb.model.s molocoSdkClickMetaData3 = cVar.getExt().getMolocoSdkClickMetaData();
        kVar.a((molocoSdkClickMetaData3 != null ? molocoSdkClickMetaData3.getBannerClickMetaData() : null) != null);
        cInvoke.setAdShowListener(this.v);
        a((InterfaceC3017a) cInvoke);
        addView(cInvoke, new FrameLayout.LayoutParams(com.moloco.sdk.internal.j.a(this.k.b()), com.moloco.sdk.internal.j.a(this.k.a())));
        if (this.q.g()) {
            final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v vVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v(this.f2188a);
            final MutableSharedFlow mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
            BuildersKt__Builders_commonKt.launch$default(this.p, null, null, new g(mutableSharedFlowMutableSharedFlow$default, this, null), 3, null);
            vVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.moloco.sdk.internal.publisher.m$$ExternalSyntheticLambda2
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return m.a(this.f$0, vVar, mutableSharedFlowMutableSharedFlow$default, view, motionEvent);
                }
            });
            addView(vVar, new FrameLayout.LayoutParams(-1, com.moloco.sdk.internal.j.a(this.k.a())));
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.b bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.b(this.f, this.f2188a, null, 0, 12, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = BadgeDrawable.BOTTOM_START;
        bVar.setPadding(12, 0, 0, 12);
        bVar.setPrivacyUrl(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a.f2675a);
        bVar.setOnButtonRenderedListener(new Function1() { // from class: com.moloco.sdk.internal.publisher.m$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return m.a(this.f$0, (a.AbstractC0526a.c) obj);
            }
        });
        bVar.setLayoutParams(layoutParams);
        addView(bVar);
        return cInvoke;
    }

    public static final boolean a(m mVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.v vVar, MutableSharedFlow mutableSharedFlow, View view, MotionEvent motionEvent) {
        BuildersKt__Builders_commonKt.launch$default(mVar.p, null, null, new h(motionEvent, vVar, mVar, mutableSharedFlow, null), 3, null);
        return false;
    }

    public static final Unit a(m mVar, a.AbstractC0526a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        mVar.r.a(button);
        return Unit.INSTANCE;
    }

    public final StateFlow<Boolean> a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<L> c2) {
        if (!this.e && c2 != null) {
            return c2.l();
        }
        return isViewShown();
    }

    public final void a(InterfaceC3017a interfaceC3017a) {
        k<L> kVar = this.q;
        Job jobA = kVar.a();
        if (jobA != null) {
            Job.DefaultImpls.cancel$default(jobA, (CancellationException) null, 1, (Object) null);
        }
        kVar.a(FlowKt.launchIn(FlowKt.onEach(FlowKt.dropWhile(a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C) this.q.f()), new d(null)), new e(this, kVar, null)), this.p));
    }
}
