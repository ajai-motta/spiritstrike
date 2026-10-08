package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.common_adapter_internal.AdapterAccess;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.client_metrics_data.d;
import com.moloco.sdk.internal.client_metrics_data.e;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.h;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends WebView {
    public static final a i = new a(null);
    public static final int j = 8;
    public static final String k = "TemplateWebView";
    public static final String l = "webview_version";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f2638a;
    public final g b;
    public final MetricsRecorder c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c d;
    public final CoroutineScope e;
    public final MutableStateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b> f;
    public final StateFlow<l> g;
    public final StateFlow<Boolean> h;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$b, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$loadHtml$2", f = "TemplateWebView.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"timerEvent", "webViewVersion"}, s = {"L$0", "L$1"})
    public static final class C0455b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v<Unit, l>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2639a;
        public Object b;
        public int c;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$b$a */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$loadHtml$2$isLoadOperationTimedOut$1", f = "TemplateWebView.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends l>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2640a;
            public final /* synthetic */ b b;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$b$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$loadHtml$2$isLoadOperationTimedOut$1$1", f = "TemplateWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0456a extends SuspendLambda implements Function3<Boolean, l, Continuation<? super Pair<? extends Boolean, ? extends l>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2641a;
                public /* synthetic */ boolean b;
                public /* synthetic */ Object c;

                public C0456a(Continuation<? super C0456a> continuation) {
                    super(3, continuation);
                }

                public final Object a(boolean z, l lVar, Continuation<? super Pair<Boolean, ? extends l>> continuation) {
                    C0456a c0456a = new C0456a(continuation);
                    c0456a.b = z;
                    c0456a.c = lVar;
                    return c0456a.invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Boolean bool, l lVar, Continuation<? super Pair<? extends Boolean, ? extends l>> continuation) {
                    return a(bool.booleanValue(), lVar, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f2641a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    boolean z = this.b;
                    return TuplesKt.to(Boxing.boxBoolean(z), (l) this.c);
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$b$a$b, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$loadHtml$2$isLoadOperationTimedOut$1$2", f = "TemplateWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0457b extends SuspendLambda implements Function2<Pair<? extends Boolean, ? extends l>, Continuation<? super Boolean>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2642a;
                public /* synthetic */ Object b;

                public C0457b(Continuation<? super C0457b> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Pair<Boolean, ? extends l> pair, Continuation<? super Boolean> continuation) {
                    return ((C0457b) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C0457b c0457b = new C0457b(continuation);
                    c0457b.b = obj;
                    return c0457b;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f2642a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    Pair pair = (Pair) this.b;
                    return Boxing.boxBoolean(((Boolean) pair.component1()).booleanValue() || ((l) pair.component2()) != null);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<Boolean, ? extends l>> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f2640a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow flowFlowCombine = FlowKt.flowCombine(this.b.d.b(), this.b.d.a(), new C0456a(null));
                    C0457b c0457b = new C0457b(null);
                    this.f2640a = 1;
                    obj = FlowKt.first(flowFlowCombine, c0457b, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0455b(String str, long j, Continuation<? super C0455b> continuation) {
            super(2, continuation);
            this.e = str;
            this.f = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super v<Unit, l>> continuation) {
            return ((C0455b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0455b(this.e, this.f, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            TimerEvent timerEventStartTimerEvent;
            Object objM8935withTimeoutOrNullKLykuaI;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                timerEventStartTimerEvent = b.this.c.startTimerEvent(e.r.c());
                String strB = b.this.b();
                MolocoLogger.info$default(MolocoLogger.INSTANCE, b.k, "Loading ad in webView, with webview version: " + strB, null, false, 12, null);
                try {
                    b.this.loadDataWithBaseURL(null, this.e, "text/html", "UTF-8", null);
                    long j = this.f;
                    a aVar = new a(b.this, null);
                    this.f2639a = timerEventStartTimerEvent;
                    this.b = strB;
                    this.c = 1;
                    objM8935withTimeoutOrNullKLykuaI = TimeoutKt.m8935withTimeoutOrNullKLykuaI(j, aVar, this);
                    if (objM8935withTimeoutOrNullKLykuaI == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = strB;
                } catch (Exception e) {
                    MolocoLogger.error$default(MolocoLogger.INSTANCE, b.k, "loadHtml failed to load the provided html", e, false, 8, null);
                    MetricsRecorder metricsRecorder = b.this.c;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.G.c());
                    d dVar = d.d;
                    CountEvent countEventWithTag = countEvent.withTag(dVar.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
                    d dVar2 = d.b;
                    metricsRecorder.recordCountEvent(countEventWithTag.withTag(dVar2.c(), "invalid_url").withTag(b.l, strB));
                    b.this.c.recordTimerEvent(timerEventStartTimerEvent.withTag(dVar.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(dVar2.c(), "invalid_url").withTag(b.l, strB));
                    return new v.a(l.b);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.b;
                timerEventStartTimerEvent = (TimerEvent) this.f2639a;
                ResultKt.throwOnFailure(obj);
                objM8935withTimeoutOrNullKLykuaI = obj;
            }
            if (objM8935withTimeoutOrNullKLykuaI == null) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, b.k, "Ad failed to load due to timeout", null, false, 12, null);
                MetricsRecorder metricsRecorder2 = b.this.c;
                CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.G.c());
                d dVar3 = d.d;
                CountEvent countEventWithTag2 = countEvent2.withTag(dVar3.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
                d dVar4 = d.b;
                metricsRecorder2.recordCountEvent(countEventWithTag2.withTag(dVar4.c(), "timeout_error").withTag(b.l, str));
                b.this.c.recordTimerEvent(timerEventStartTimerEvent.withTag(dVar3.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(dVar4.c(), "timeout_error").withTag(b.l, str));
                return new v.a(l.f);
            }
            boolean zBooleanValue = b.this.d.b().getValue().booleanValue();
            l value = b.this.d.a().getValue();
            if (value != null) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, b.k, "Ad failed to load due to unrecoverable error: " + value.name(), null, false, 12, null);
                MetricsRecorder metricsRecorder3 = b.this.c;
                CountEvent countEvent3 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.G.c());
                d dVar5 = d.d;
                CountEvent countEventWithTag3 = countEvent3.withTag(dVar5.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
                d dVar6 = d.b;
                metricsRecorder3.recordCountEvent(countEventWithTag3.withTag(dVar6.c(), value.name()).withTag(b.l, str));
                b.this.c.recordTimerEvent(timerEventStartTimerEvent.withTag(dVar5.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(dVar6.c(), value.name()).withTag(b.l, str));
                return new v.a(value);
            }
            if (zBooleanValue) {
                MetricsRecorder metricsRecorder4 = b.this.c;
                CountEvent countEvent4 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.G.c());
                d dVar7 = d.d;
                metricsRecorder4.recordCountEvent(countEvent4.withTag(dVar7.c(), "success").withTag(b.l, str));
                b.this.c.recordTimerEvent(timerEventStartTimerEvent.withTag(dVar7.c(), "success").withTag(b.l, str));
                return new v.b(Unit.INSTANCE);
            }
            MetricsRecorder metricsRecorder5 = b.this.c;
            CountEvent countEvent5 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.G.c());
            d dVar8 = d.d;
            CountEvent countEventWithTag4 = countEvent5.withTag(dVar8.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
            d dVar9 = d.b;
            metricsRecorder5.recordCountEvent(countEventWithTag4.withTag(dVar9.c(), "unknown_error").withTag(b.l, str));
            b.this.c.recordTimerEvent(timerEventStartTimerEvent.withTag(dVar8.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(dVar9.c(), "unknown_error").withTag(b.l, str));
            return new v.a(l.f2655a);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$startCollectingPlaylistItemDisplaying$1", f = "TemplateWebView.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2643a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a c;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f2644a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a b;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$c$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$startCollectingPlaylistItemDisplaying$1$1$1", f = "TemplateWebView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0458a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2645a;
                public final /* synthetic */ b b;
                public final /* synthetic */ g.a c;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$c$a$a$a, reason: collision with other inner class name */
                public /* synthetic */ class C0459a {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f2646a;

                    static {
                        int[] iArr = new int[g.a.values().length];
                        try {
                            iArr[g.a.d.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[g.a.c.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        f2646a = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0458a(b bVar, g.a aVar, Continuation<? super C0458a> continuation) {
                    super(2, continuation);
                    this.b = bVar;
                    this.c = aVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0458a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0458a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f2645a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    WebSettings settings = this.b.getSettings();
                    int i = C0459a.f2646a[this.c.ordinal()];
                    settings.setMediaPlaybackRequiresUserGesture(i != 1 ? i != 2 ? this.b.getSettings().getMediaPlaybackRequiresUserGesture() : false : true);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b$c$a$b, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebView$startCollectingPlaylistItemDisplaying$1$1", f = "TemplateWebView.kt", i = {0, 0}, l = {85}, m = "emit", n = {"this", "creativeType"}, s = {"L$0", "L$1"})
            public static final class C0460b extends ContinuationImpl {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public Object f2647a;
                public Object b;
                public /* synthetic */ Object c;
                public final /* synthetic */ a<T> d;
                public int e;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public C0460b(a<? super T> aVar, Continuation<? super C0460b> continuation) {
                    super(continuation);
                    this.d = aVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.c = obj;
                    this.e |= Integer.MIN_VALUE;
                    return this.d.emit(null, this);
                }
            }

            public a(b bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a aVar) {
                this.f2644a = bVar;
                this.b = aVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g.a r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 245
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.b.c.a.emit(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.g$a, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a aVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2643a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    MutableSharedFlow<g.a> mutableSharedFlowC = b.this.b.c();
                    a aVar = new a(b.this, this.c);
                    this.f2643a = 1;
                    if (mutableSharedFlowC.collect(aVar, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            } catch (Exception e) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, b.k, "Error collecting playlist item displaying events", e, false, 8, null);
                return Unit.INSTANCE;
            }
        }
    }

    public /* synthetic */ b(Context context, h hVar, g gVar, MetricsRecorder metricsRecorder, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c cVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, hVar, gVar, metricsRecorder, (i2 & 16) != 0 ? new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c(hVar, metricsRecorder) : cVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        removeAllViews();
        super.destroy();
    }

    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b> getOrientation$moloco_sdk_release() {
        return this.f;
    }

    public final StateFlow<l> getUnrecoverableError() {
        return this.g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.e, null, 1, null);
    }

    public final StateFlow<Boolean> a() {
        return this.h;
    }

    public final String b() {
        String str;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
                if (currentWebViewPackage != null && (str = currentWebViewPackage.versionName) != null) {
                    return str;
                }
                return "unknown";
            }
            PackageManager packageManager = getContext().getPackageManager();
            for (String str2 : CollectionsKt.listOf((Object[]) new String[]{"com.google.android.webview", "com.android.webview", "com.android.chrome"})) {
                PackageInfo packageInfo = packageManager.getPackageInfo(str2, 0);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, k, "Pre-O, legacy webview version: " + str2 + " → " + packageInfo.versionName, null, false, 12, null);
                String versionName = packageInfo.versionName;
                Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
                if (versionName.length() > 0) {
                    String versionName2 = packageInfo.versionName;
                    Intrinsics.checkNotNullExpressionValue(versionName2, "versionName");
                    return versionName2;
                }
            }
            return "unknown";
        } catch (Exception e) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, k, "WebView version retrieval exception", e, false, 8, null);
            return "unknown";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, h contentLoadedEventHandler, g playListItemDisplayingEventHandler, MetricsRecorder metricsRecorder, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c webViewClientImpl) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentLoadedEventHandler, "contentLoadedEventHandler");
        Intrinsics.checkNotNullParameter(playListItemDisplayingEventHandler, "playListItemDisplayingEventHandler");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        Intrinsics.checkNotNullParameter(webViewClientImpl, "webViewClientImpl");
        this.f2638a = contentLoadedEventHandler;
        this.b = playListItemDisplayingEventHandler;
        this.c = metricsRecorder;
        this.d = webViewClientImpl;
        this.e = CoroutineScopeKt.CoroutineScope(AdapterAccess.INSTANCE.DispatcherProvider().getMain());
        this.f = StateFlowKt.MutableStateFlow(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.ad.orientation.a.d, false, 2, null));
        setWebViewClient(webViewClientImpl);
        setScrollBarStyle(0);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        WebSettings settings = getSettings();
        settings.setSupportZoom(false);
        settings.setJavaScriptEnabled(true);
        setSaveEnabled(false);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        setBackgroundColor(0);
        this.g = webViewClientImpl.a();
        this.h = webViewClientImpl.c();
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a mraidCommunicationHub) {
        Intrinsics.checkNotNullParameter(mraidCommunicationHub, "mraidCommunicationHub");
        BuildersKt__Builders_commonKt.launch$default(this.e, null, null, new c(mraidCommunicationHub, null), 3, null);
    }

    public final Object a(String str, long j2, Continuation<? super v<Unit, l>> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new C0455b(str, j2, null), continuation);
    }
}
