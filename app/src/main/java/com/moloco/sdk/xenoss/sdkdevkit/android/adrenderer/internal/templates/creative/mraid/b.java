package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid;

import android.content.Context;
import android.webkit.WebView;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.p;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.u;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a {
    public static final int k = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2630a;
    public final WebView b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.b c;
    public final CoroutineScope d;
    public final e e;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.c f;
    public t g;
    public final u h;
    public final MutableStateFlow<n.f> i;
    public final StateFlow<n.f> j;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.MraidCommunicationHubImpl$handleMraidJsCommandSetOrientationProperties$1", f = "MraidCommunicationHub.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2631a;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ p d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z, p pVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = z;
            this.d = pVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new a(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2631a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow = b.this.i;
                n.f fVar = new n.f(this.c, this.d);
                this.f2631a = 1;
                if (mutableStateFlow.emit(fVar, this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.b$b, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.MraidCommunicationHubImpl$startListeningToVisualMetricsChanges$1", f = "MraidCommunicationHub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0453b extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2632a;
        public /* synthetic */ boolean b;

        public C0453b(Continuation<? super C0453b> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((C0453b) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0453b c0453b = b.this.new C0453b(continuation);
            c0453b.b = ((Boolean) obj).booleanValue();
            return c0453b;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2632a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b.this.e.a(this.b);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.MraidCommunicationHubImpl$startListeningToVisualMetricsChanges$2", f = "MraidCommunicationHub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<u.a, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2633a;
        public /* synthetic */ Object b;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(u.a aVar, Continuation<? super Unit> continuation) {
            return ((c) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = b.this.new c(continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2633a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b.this.e.a(((u.a) this.b).a());
            return Unit.INSTANCE;
        }
    }

    public b(Context context, WebView webView, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.renderer.events.handlers.b clickthroughEventHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(clickthroughEventHandler, "clickthroughEventHandler");
        this.f2630a = context;
        this.b = webView;
        this.c = clickthroughEventHandler;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.d = CoroutineScope;
        this.e = new e(webView);
        this.f = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.c(context, this);
        this.g = t.c;
        this.h = new u(webView, context, CoroutineScope);
        MutableStateFlow<n.f> MutableStateFlow = StateFlowKt.MutableStateFlow(new n.f(true, p.d));
        this.i = MutableStateFlow;
        this.j = MutableStateFlow;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a
    public void c() {
        this.g = t.e;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a
    public void d() {
        this.g = t.c;
        this.e.a(false, false, false, false, true);
        this.e.a(this.g);
        this.e.a(r.c);
        this.e.a(this.h.k().getValue().a());
        f();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a
    public StateFlow<n.f> e() {
        return this.j;
    }

    public final void f() {
        FlowKt.launchIn(FlowKt.onEach(this.h.l(), new C0453b(null)), this.d);
        FlowKt.launchIn(FlowKt.onEach(this.h.k(), new c(null)), this.d);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a
    public void remove() {
        this.b.removeJavascriptInterface("AndroidMraid");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a
    public void a(String url) throws JSONException {
        Intrinsics.checkNotNullParameter(url, "url");
        JSONObject jSONObject = new JSONObject();
        String strB = b(url);
        jSONObject.put("event", "clickthrough");
        jSONObject.put("contentType", "mraid");
        jSONObject.put("url", strB);
        try {
            this.c.a(jSONObject);
            this.e.a("open");
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, "TAG", "Ad clicked: " + strB, false, 4, null);
        } catch (Exception unused) {
            this.e.a("open", "Can't open links when mraid container is not visible to the user");
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a
    public void b() {
        this.b.addJavascriptInterface(this.f, "AndroidMraid");
    }

    public final String b(String str) {
        return StringsKt.startsWith$default(str, "itms-apps://", false, 2, (Object) null) ? StringsKt.replace$default(str, "itms-apps://", "https://", false, 4, (Object) null) : str;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a
    public void a() {
        if (this.g == t.e) {
            this.g = t.c;
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.templates.creative.mraid.a
    public void a(boolean z, p forceOrientation) {
        Intrinsics.checkNotNullParameter(forceOrientation, "forceOrientation");
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new a(z, forceOrientation, null), 3, null);
    }
}
