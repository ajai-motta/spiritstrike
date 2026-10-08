package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.webkit.WebView;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class k implements j {
    public static final int i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2580a;
    public Function0<Unit> b;
    public final CoroutineScope c;
    public final WebView d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d e;
    public final MutableSharedFlow<l> f;
    public final SharedFlow<l> g;
    public final StateFlow<n.f> h;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidFullscreenContentControllerImpl$onEvent$1", f = "MraidFullscreenContentControllerImpl.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2581a;
        public final /* synthetic */ l c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = lVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return k.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2581a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = k.this.f;
                l lVar = this.c;
                this.f2581a = 1;
                if (mutableSharedFlow.emit(lVar, this) == coroutine_suspended) {
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

    public static final class b implements Flow<n.f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f2582a;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f2583a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$b$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidFullscreenContentControllerImpl$special$$inlined$mapNotNull$1$2", f = "MraidFullscreenContentControllerImpl.kt", i = {}, l = {52}, m = "emit", n = {}, s = {})
            public static final class C0441a extends ContinuationImpl {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f2584a;
                public int b;
                public Object c;

                public C0441a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f2584a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f2583a = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k.b.a.C0441a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$b$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k.b.a.C0441a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$b$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$b$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f2584a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.throwOnFailure(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f2583a
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n) r5
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n.f
                    if (r2 == 0) goto L3f
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n$f r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n.f) r5
                    goto L40
                L3f:
                    r5 = 0
                L40:
                    if (r5 == 0) goto L4b
                    r0.b = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k.b.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public b(Flow flow) {
            this.f2582a = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super n.f> flowCollector, Continuation continuation) {
            Object objCollect = this.f2582a.collect(new a(flowCollector), continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    public /* synthetic */ k(boolean z, Function0 function0, CoroutineScope coroutineScope, int i2, WebView webView, SharedFlow sharedFlow, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0, coroutineScope, i2, webView, sharedFlow);
    }

    public static Object b(k kVar) {
        return Reflection.property0(new PropertyReference0Impl(kVar.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.d.class, "goNextAction", "getGoNextAction()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    public static final Unit p() {
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    public void B() {
        a(l.f2585a);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean I() {
        return this.f2580a;
    }

    public final Function0<Unit> R() {
        return this.b;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public SharedFlow<l> a() {
        return this.g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    public WebView c() {
        return this.d;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        this.b.invoke();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j
    public StateFlow<n.f> e() {
        return this.h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<d.a> l() {
        return this.e.l();
    }

    public k(boolean z, Function0<Unit> closeFullscreenAdRepresentation, CoroutineScope scope, int i2, WebView webView, SharedFlow<? extends n> mraidJsCommands) {
        Intrinsics.checkNotNullParameter(closeFullscreenAdRepresentation, "closeFullscreenAdRepresentation");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(mraidJsCommands, "mraidJsCommands");
        this.f2580a = z;
        this.b = closeFullscreenAdRepresentation;
        this.c = scope;
        this.d = webView;
        this.e = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.f.a(i2, scope);
        MutableSharedFlow<l> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f = mutableSharedFlowMutableSharedFlow$default;
        this.g = mutableSharedFlowMutableSharedFlow$default;
        this.h = FlowKt.stateIn(new b(mraidJsCommands), scope, SharingStarted.INSTANCE.getEagerly(), null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void b(a.AbstractC0526a.f position) {
        Intrinsics.checkNotNullParameter(position, "position");
        a(l.b);
    }

    public final void a(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.b = function0;
    }

    public final Job a(l lVar) {
        return BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(lVar, null), 3, null);
    }

    public /* synthetic */ k(boolean z, Function0 function0, CoroutineScope coroutineScope, int i2, WebView webView, SharedFlow sharedFlow, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i3 & 2) != 0 ? new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.k$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return k.p();
            }
        } : function0, coroutineScope, i2, webView, sharedFlow, null);
    }
}
