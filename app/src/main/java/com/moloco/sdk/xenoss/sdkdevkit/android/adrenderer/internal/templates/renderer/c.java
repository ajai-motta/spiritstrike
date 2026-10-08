package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer;

import android.graphics.Bitmap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewClientCompat;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.client_metrics_data.e;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.h;
import io.ktor.http.HttpStatusCode;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class c extends WebViewClientCompat {
    public static final a r = new a(null);
    public static final int s = 8;
    public static final String t = "TemplateWebViewClientImpl";
    public static final int u = 5;
    public static final long v = 1000;
    public static final long w = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f2648a;
    public final MetricsRecorder b;
    public final CoroutineScope c;
    public final MutableStateFlow<Boolean> d;
    public final StateFlow<Boolean> e;
    public final MutableStateFlow<Boolean> f;
    public final StateFlow<Boolean> g;
    public final MutableStateFlow<l> h;
    public final StateFlow<l> i;
    public int j;
    public Job k;
    public Job l;
    public final MutableStateFlow<Boolean> m;
    public Job n;
    public TimerEvent o;
    public TimerEvent p;
    public String q;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebViewClientImpl$handleRetry$1", f = "TemplateWebviewClientImpl.kt", i = {}, l = {244}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2649a;
        public final /* synthetic */ WebView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WebView webView, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = webView;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2649a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = (((long) c.this.j) * 1000) + 1000;
                this.f2649a = 1;
                if (DelayKt.delay(j, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) c.this.d.getValue()).booleanValue()) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, c.t, "Skip reload; content already loaded after backoff", null, false, 12, null);
                return Unit.INSTANCE;
            }
            Job job = c.this.n;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Job job2 = c.this.l;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            this.c.reload();
            MolocoLogger.info$default(MolocoLogger.INSTANCE, c.t, "Reload attempt: " + c.this.j, null, false, 12, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c$c, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebViewClientImpl$onPageFinished$1", f = "TemplateWebviewClientImpl.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0461c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2650a;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c$c$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f2651a;

            public a(c cVar) {
                this.f2651a = cVar;
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, c.t, "Webview page pending error resolution: " + z, null, false, 12, null);
                if (!z) {
                    this.f2651a.d();
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        }

        public C0461c(Continuation<? super C0461c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0461c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new C0461c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2650a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = c.this.m;
                a aVar = new a(c.this);
                this.f2650a = 1;
                if (mutableStateFlow.collect(aVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.TemplateWebViewClientImpl$pageFinished$3", f = "TemplateWebviewClientImpl.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2652a;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f2653a;

            public a(c cVar) {
                this.f2653a = cVar;
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, c.t, "Content loaded event received, isSuccess: " + z, null, false, 12, null);
                this.f2653a.d.setValue(Boxing.boxBoolean(z));
                Job job = this.f2653a.n;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                MetricsRecorder metricsRecorder = this.f2653a.b;
                CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.P.c());
                com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
                metricsRecorder.recordCountEvent(countEvent.withTag(dVar.c(), z ? "success" : LoginLogger.EVENT_EXTRAS_FAILURE));
                TimerEvent timerEvent = this.f2653a.p;
                if (timerEvent != null) {
                    this.f2653a.b.recordTimerEvent(timerEvent.withTag(dVar.c(), z ? "success" : LoginLogger.EVENT_EXTRAS_FAILURE));
                }
                if (z) {
                    Job job2 = this.f2653a.k;
                    if (job2 != null) {
                        Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                    }
                    this.f2653a.k = null;
                    this.f2653a.j = 0;
                }
                return Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((Boolean) obj).booleanValue(), continuation);
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2652a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharedFlow<Boolean> sharedFlowC = c.this.f2648a.c();
                a aVar = new a(c.this);
                this.f2652a = 1;
                if (sharedFlowC.collect(aVar, this) == coroutine_suspended) {
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

    public c(h contentLoadedEventHandler, MetricsRecorder metricsRecorder) {
        Intrinsics.checkNotNullParameter(contentLoadedEventHandler, "contentLoadedEventHandler");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        this.f2648a = contentLoadedEventHandler;
        this.b = metricsRecorder;
        this.c = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.d = MutableStateFlow;
        this.e = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.f = MutableStateFlow2;
        this.g = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<l> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this.h = MutableStateFlow3;
        this.i = FlowKt.asStateFlow(MutableStateFlow3);
        this.m = StateFlowKt.MutableStateFlow(bool);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, "Webview page finished loading has pending error: " + this.m.getValue().booleanValue(), null, false, 12, null);
        this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.O.c()).withTag("pending_error", String.valueOf(this.m.getValue().booleanValue())));
        if (this.m.getValue().booleanValue()) {
            this.l = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new C0461c(null), 3, null);
        } else {
            d();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, "HTML Page started loading", null, false, 12, null);
        this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.M.c()));
        this.o = this.b.startTimerEvent(e.u.c());
        this.p = this.b.startTimerEvent(e.v.c());
    }

    @Override // androidx.webkit.WebViewClientCompat
    public void onReceivedError(final WebView view, WebResourceRequest request, final WebResourceErrorCompat error) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(error, "error");
        this.m.setValue(Boolean.TRUE);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, "Received error: " + error.getErrorCode() + ", with description: " + ((Object) error.getDescription()) + " for url: " + request.getUrl() + " ad isLoaded: " + this.e.getValue().booleanValue() + ", isPageFinished: " + this.g.getValue().booleanValue(), null, false, 12, null);
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        StringBuilder sb = new StringBuilder("ContentChecker.isRequiredContent('");
        sb.append(string);
        sb.append("');");
        view.evaluateJavascript(sb.toString(), new ValueCallback() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c$$ExternalSyntheticLambda0
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                c.a(this.f$0, error, view, (String) obj);
            }
        });
        super.onReceivedError(view, request, error);
    }

    @Override // androidx.webkit.WebViewClientCompat, android.webkit.WebViewClient, org.chromium.support_lib_boundary.WebViewClientBoundaryInterface
    public void onReceivedHttpError(final WebView view, WebResourceRequest request, final WebResourceResponse errorResponse) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
        this.m.setValue(Boolean.TRUE);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, "[" + Thread.currentThread().getName() + "] Received HTTP error: " + Integer.valueOf(errorResponse.getStatusCode()) + ", with description: " + errorResponse.getReasonPhrase() + " for url: " + request.getUrl(), null, false, 12, null);
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        StringBuilder sb = new StringBuilder("ContentChecker.isRequiredContent('");
        sb.append(string);
        sb.append("');");
        view.evaluateJavascript(sb.toString(), new ValueCallback() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.c$$ExternalSyntheticLambda1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                c.a(this.f$0, errorResponse, view, (String) obj);
            }
        });
        super.onReceivedHttpError(view, request, errorResponse);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail renderProcessGoneDetail) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.H.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), "render_process_gone_error").withTag("is_loaded", String.valueOf(this.e.getValue().booleanValue())));
        this.h.setValue(l.e);
        MolocoLogger.error$default(MolocoLogger.INSTANCE, t, "onRenderProcessGone", null, false, 12, null);
        this.m.setValue(Boolean.FALSE);
        return true;
    }

    public final StateFlow<Boolean> b() {
        return this.e;
    }

    public final StateFlow<Boolean> c() {
        return this.g;
    }

    public final void d() {
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("HTML Page finished loading is success: ");
        sb.append(this.i.getValue() == null);
        MolocoLogger.info$default(molocoLogger, t, sb.toString(), null, false, 12, null);
        this.f.setValue(Boolean.TRUE);
        if (this.i.getValue() == null) {
            MolocoLogger.info$default(molocoLogger, t, "Waiting for content HTML assets to load or error out", null, false, 12, null);
            MetricsRecorder metricsRecorder = this.b;
            CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.N.c());
            com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
            metricsRecorder.recordCountEvent(countEvent.withTag(dVar.c(), "success"));
            TimerEvent timerEvent = this.o;
            if (timerEvent != null) {
                this.b.recordTimerEvent(timerEvent.withTag(dVar.c(), "success"));
            }
            this.n = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new d(null), 3, null);
            return;
        }
        MolocoLogger.info$default(molocoLogger, t, "Unrecoverable error occurred, not setting isLoaded to true", null, false, 12, null);
        this.d.setValue(Boolean.FALSE);
        Job job = this.n;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.k;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.k = null;
        MetricsRecorder metricsRecorder2 = this.b;
        CountEvent countEvent2 = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.N.c());
        com.moloco.sdk.internal.client_metrics_data.d dVar2 = com.moloco.sdk.internal.client_metrics_data.d.d;
        CountEvent countEventWithTag = countEvent2.withTag(dVar2.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
        com.moloco.sdk.internal.client_metrics_data.d dVar3 = com.moloco.sdk.internal.client_metrics_data.d.b;
        String strC = dVar3.c();
        String str = this.q;
        if (str == null) {
            str = "unknown";
        }
        metricsRecorder2.recordCountEvent(countEventWithTag.withTag(strC, str));
        TimerEvent timerEvent2 = this.o;
        if (timerEvent2 != null) {
            MetricsRecorder metricsRecorder3 = this.b;
            TimerEvent timerEventWithTag = timerEvent2.withTag(dVar2.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
            String strC2 = dVar3.c();
            String str2 = this.q;
            metricsRecorder3.recordTimerEvent(timerEventWithTag.withTag(strC2, str2 != null ? str2 : "unknown"));
        }
    }

    public final boolean e() {
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("retryCount: ");
        sb.append(this.j);
        sb.append(", MAX_RETRY_LIMIT: 5, retryCount < MAX_RETRY_LIMIT: ");
        sb.append(this.j < 5);
        MolocoLogger.debug$default(molocoLogger, t, sb.toString(), false, 4, null);
        return this.j < 5;
    }

    public final StateFlow<l> a() {
        return this.i;
    }

    public static final void a(c cVar, WebResourceErrorCompat webResourceErrorCompat, WebView webView, String str) {
        boolean z = Boolean.parseBoolean(str);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, t, "[" + Thread.currentThread().getName() + "] Content type with webview error is required: " + z, null, false, 12, null);
        if (z) {
            if (!cVar.e.getValue().booleanValue()) {
                if (!com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.h.a(webResourceErrorCompat.getDescription().toString()).e()) {
                    if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.h.a(webResourceErrorCompat.getDescription().toString()).f() && cVar.e()) {
                        cVar.a(webResourceErrorCompat.getDescription().toString(), webResourceErrorCompat.getErrorCode(), webView);
                    } else {
                        cVar.a(webResourceErrorCompat.getDescription().toString(), webResourceErrorCompat.getErrorCode(), l.c);
                    }
                } else {
                    cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.J.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("required", "true").withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), String.valueOf(webResourceErrorCompat.getDescription())).withTag("status_code", String.valueOf(webResourceErrorCompat.getErrorCode())).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
                    MolocoLogger.info$default(molocoLogger, t, "Ignoring error: " + ((Object) webResourceErrorCompat.getDescription()) + " with code: " + webResourceErrorCompat.getErrorCode() + " since it's marked to be ignored pre load", null, false, 12, null);
                }
            } else {
                MolocoLogger.info$default(molocoLogger, t, "Webview is already showing and received error: " + ((Object) webResourceErrorCompat.getDescription()), null, false, 12, null);
                if (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.errors.h.a(webResourceErrorCompat.getDescription().toString()).g()) {
                    cVar.a(webResourceErrorCompat.getDescription().toString(), webResourceErrorCompat.getErrorCode(), l.c);
                } else {
                    cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.J.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("required", "true").withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), String.valueOf(webResourceErrorCompat.getDescription())).withTag("status_code", String.valueOf(webResourceErrorCompat.getErrorCode())).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
                    MolocoLogger.info$default(molocoLogger, t, "Webview is already showing but received " + ((Object) webResourceErrorCompat.getDescription()) + ", not setting unrecoverable error", null, false, 12, null);
                }
            }
        } else {
            MolocoLogger.info$default(molocoLogger, t, "Content is not required, not setting unrecoverable error", null, false, 12, null);
            cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.H.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("required", "false").withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), String.valueOf(webResourceErrorCompat.getDescription())).withTag("status_code", String.valueOf(webResourceErrorCompat.getErrorCode())).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
        }
        cVar.m.setValue(Boolean.FALSE);
    }

    public final void a(String str, int i, WebView webView) {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, t, "Retrying error... Attempt: " + (this.j + 1), null, false, 12, null);
        this.j = this.j + 1;
        this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.I.c()).withTag("required", "true").withTag(com.moloco.sdk.internal.client_metrics_data.d.f.c(), String.valueOf(this.j)).withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), String.valueOf(str)).withTag("status_code", String.valueOf(i)));
        Job job = this.k;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.k = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(webView, null), 3, null);
    }

    public final void a(String str, int i, l lVar) {
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, t, "Setting unrecoverable error with description: " + str + ", code: " + i + ", errorType: " + lVar, null, false, 12, null);
        this.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.H.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("required", "true").withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), String.valueOf(str)).withTag("status_code", String.valueOf(i)).withTag("is_loaded", String.valueOf(this.e.getValue().booleanValue())));
        this.q = str;
        this.h.setValue(lVar);
    }

    public static final void a(c cVar, WebResourceResponse webResourceResponse, WebView webView, String str) {
        boolean z = Boolean.parseBoolean(str);
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, t, "[" + Thread.currentThread().getName() + "] Content isRequired with http error: " + z, null, false, 12, null);
        if (z) {
            if (cVar.e.getValue().booleanValue()) {
                cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.J.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("required", "true").withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), String.valueOf(webResourceResponse.getStatusCode())).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
                MolocoLogger.info$default(molocoLogger, t, "Webview is already showing but received HTTP " + webResourceResponse.getStatusCode() + ", not setting unrecoverable error", null, false, 12, null);
            } else if (cVar.a(webResourceResponse.getStatusCode()) && cVar.e()) {
                cVar.a(String.valueOf(webResourceResponse.getStatusCode()), webResourceResponse.getStatusCode(), webView);
            } else {
                cVar.a(String.valueOf(webResourceResponse.getStatusCode()), webResourceResponse.getStatusCode(), l.d);
                MolocoLogger.warn$default(molocoLogger, t, "Setting unrecoverable error: " + cVar.i.getValue(), null, false, 12, null);
            }
        } else {
            MolocoLogger.info$default(molocoLogger, t, "Content is not required, not setting unrecoverable error", null, false, 12, null);
            cVar.b.recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.H.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.d.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("required", "false").withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), String.valueOf(webResourceResponse.getStatusCode())).withTag("is_loaded", String.valueOf(cVar.e.getValue().booleanValue())));
        }
        cVar.m.setValue(Boolean.FALSE);
    }

    public final boolean a(int i) {
        HttpStatusCode.Companion companion = HttpStatusCode.INSTANCE;
        return i == companion.getTooManyRequests().getValue() || i == companion.getRequestTimeout().getValue() || i < 400 || i >= 500;
    }
}
