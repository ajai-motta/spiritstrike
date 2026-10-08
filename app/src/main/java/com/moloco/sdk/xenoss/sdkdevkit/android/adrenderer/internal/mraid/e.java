package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import android.content.Context;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.u;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k {
    public static final int m = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2569a;
    public final r b;
    public Function0<Unit> c;
    public Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r e;
    public final boolean f;
    public final f g;
    public final String h;
    public final CoroutineScope i;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c j;
    public t k;
    public final u l;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$loadAndReadyMraid$2", f = "MraidBaseAd.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_AC4}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2570a;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c cVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2570a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                f fVarH = e.this.H();
                String str = e.this.f2569a;
                this.f2570a = 1;
                obj = fVarH.a(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.internal.v vVar = (com.moloco.sdk.internal.v) obj;
            boolean z = vVar instanceof v.a;
            if (z) {
                return vVar;
            }
            f fVarH2 = e.this.H();
            e eVar = e.this;
            fVarH2.a(false, false, false, false, true);
            fVarH2.a(eVar.b);
            fVarH2.a(eVar.l.l().getValue().booleanValue());
            fVarH2.a(eVar.l.k().getValue().a());
            eVar.b(t.c);
            eVar.U();
            eVar.V();
            eVar.W();
            fVarH2.j();
            e eVar2 = e.this;
            if (vVar instanceof v.b) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, eVar2.h, "Mraid Html data successfully loaded", null, false, 12, null);
                cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) ((v.b) vVar).a();
            } else {
                if (!z) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.error$default(MolocoLogger.INSTANCE, eVar2.h, "Mraid Html data load failed.", null, false, 12, null);
                cVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c(null, 1, null);
            }
            eVar2.j = cVar;
            return vVar;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToErrors$1", f = "MraidBaseAd.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2571a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2572a;

            static {
                int[] iArr = new int[r.values().length];
                try {
                    iArr[r.c.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[r.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f2572a = iArr;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e$b$b, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToErrors$1$error$1", f = "MraidBaseAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0439b extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2573a;
            public /* synthetic */ Object b;

            public C0439b(Continuation<? super C0439b> continuation) {
                super(2, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar, Continuation<? super Boolean> continuation) {
                return ((C0439b) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C0439b c0439b = new C0439b(continuation);
                c0439b.b = obj;
                return c0439b;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f2573a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) this.b) != null);
            }
        }

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2571a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> stateFlowW = e.this.H().w();
                C0439b c0439b = new C0439b(null);
                this.f2571a = 1;
                obj = FlowKt.first(stateFlowW, c0439b, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) obj;
            if (dVar != null) {
                e eVar = e.this;
                int i2 = a.f2572a[eVar.b.ordinal()];
                if (i2 == 1) {
                    eVar.R().invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.b(dVar));
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    eVar.R().invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.a(dVar));
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToMraidJsCommands$1", f = "MraidBaseAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<n, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2574a;
        public /* synthetic */ Object b;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(n nVar, Continuation<? super Unit> continuation) {
            return ((c) create(nVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = e.this.new c(continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2574a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            n nVar = (n) this.b;
            if (Intrinsics.areEqual(nVar, n.a.i)) {
                e.this.S();
            } else if (nVar instanceof n.d) {
                e.this.a((n.d) nVar);
            } else if (!(nVar instanceof n.f)) {
                if (nVar instanceof n.c) {
                    e.this.a((n.c) nVar);
                } else {
                    e.this.H().a(nVar, "unsupported command: " + nVar.a());
                }
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToVisualMetricsChanges$1", f = "MraidBaseAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2575a;
        public /* synthetic */ boolean b;

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((d) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = e.this.new d(continuation);
            dVar.b = ((Boolean) obj).booleanValue();
            return dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2575a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e.this.H().a(this.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e$e, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidBaseAd$startListeningToVisualMetricsChanges$2", f = "MraidBaseAd.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0440e extends SuspendLambda implements Function2<u.a, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2576a;
        public /* synthetic */ Object b;

        public C0440e(Continuation<? super C0440e> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(u.a aVar, Continuation<? super Unit> continuation) {
            return ((C0440e) create(aVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0440e c0440e = e.this.new C0440e(continuation);
            c0440e.b = obj;
            return c0440e;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2576a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            e.this.H().a(((u.a) this.b).a());
            return Unit.INSTANCE;
        }
    }

    public e(Context context, String adm, r mraidPlacementType, Function0<Unit> onClick, Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> onError, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r externalLinkHandler, boolean z, f mraidBridge) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(mraidPlacementType, "mraidPlacementType");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(mraidBridge, "mraidBridge");
        this.f2569a = adm;
        this.b = mraidPlacementType;
        this.c = onClick;
        this.d = onError;
        this.e = externalLinkHandler;
        this.f = z;
        this.g = mraidBridge;
        this.h = "MraidBaseAd";
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.i = CoroutineScope;
        this.l = new u(mraidBridge.c(), context, CoroutineScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l() {
        return Unit.INSTANCE;
    }

    public final f H() {
        return this.g;
    }

    public final Function0<Unit> I() {
        return this.c;
    }

    public final Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> R() {
        return this.d;
    }

    public final void S() {
        if (this.l.l().getValue().booleanValue()) {
            s();
        } else {
            this.g.a(n.a.i, "Can't close ad when mraid container is not visible to the user");
        }
    }

    public void T() {
    }

    public final void U() {
        BuildersKt__Builders_commonKt.launch$default(this.i, null, null, new b(null), 3, null);
    }

    public final void V() {
        FlowKt.launchIn(FlowKt.onEach(this.g.v(), new c(null)), this.i);
    }

    public final void W() {
        FlowKt.launchIn(FlowKt.onEach(this.l.l(), new d(null)), this.i);
        FlowKt.launchIn(FlowKt.onEach(this.l.k(), new C0440e(null)), this.i);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.i, null, 1, null);
        this.g.destroy();
        this.l.destroy();
    }

    public void s() {
        if (this.k == t.e) {
            b(t.c);
        }
    }

    public final void b(t tVar) {
        this.k = tVar;
        if (tVar != null) {
            this.g.a(tVar);
        }
    }

    public final Object b(Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d>> continuation) {
        return BuildersKt__Builders_commonKt.async$default(this.i, null, null, new a(null), 3, null).await(continuation);
    }

    public final void a(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.c = function0;
    }

    public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void a(Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.d = function1;
    }

    public final void a(n.d dVar) {
        if (this.l.l().getValue().booleanValue()) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar = this.e;
            String string = dVar.b().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            rVar.a(string);
            this.c.invoke();
            return;
        }
        this.g.a(dVar, "Can't open links when mraid container is not visible to the user");
    }

    public final void a(n.c cVar) {
        if (this.f) {
            this.g.a(cVar, "expand() is force blocked for the current ad");
            return;
        }
        if (!this.l.l().getValue().booleanValue()) {
            this.g.a(cVar, "Can't expand() when mraid container is not visible to the user");
            return;
        }
        if (this.k != t.c) {
            this.g.a(cVar, "In order to expand() mraid ad, container must be in Default view state");
            return;
        }
        if (this.b == r.c) {
            this.g.a(cVar, "expand() is not supported for interstitials");
        } else if (cVar.b() != null) {
            this.g.a(cVar, "Two-part expand is not supported yet");
        } else {
            T();
            b(t.e);
        }
    }

    public /* synthetic */ e(Context context, String str, r rVar, Function0 function0, Function1 function1, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar2, boolean z, f fVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, rVar, (i & 8) != 0 ? new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return e.l();
            }
        } : function0, (i & 16) != 0 ? new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return e.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) obj);
            }
        } : function1, rVar2, (i & 64) != 0 ? false : z, fVar);
    }
}
