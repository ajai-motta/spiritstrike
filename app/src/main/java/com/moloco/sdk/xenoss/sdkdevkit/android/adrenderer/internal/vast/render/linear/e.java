package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import android.content.Context;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.y;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.p;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class e implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c {
    public static final int A = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f f2972a;
    public final boolean b;
    public final boolean c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a d;
    public final r e;
    public final CoroutineScope f;
    public final MutableSharedFlow<d> g;
    public final Flow<d> h;
    public final String i;
    public final MutableStateFlow<Boolean> j;
    public final StateFlow<Boolean> k;
    public final MutableStateFlow<m<Long>> l;
    public final StateFlow<m<Long>> m;
    public final boolean n;
    public final String o;
    public final boolean p;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.b q;
    public final n r;
    public final MutableStateFlow<Boolean> s;
    public final StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> t;
    public final MutableStateFlow<Boolean> u;
    public final StateFlow<Boolean> v;
    public final j w;
    public final g x;
    public boolean y;
    public int z;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearControllerImpl$1", f = "LinearControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2973a;
        public /* synthetic */ boolean b;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((a) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = e.this.new a(continuation);
            aVar.b = ((Boolean) obj).booleanValue();
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2973a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.b) {
                e.this.w.d(Boxing.boxInt(e.this.Q()), e.this.i);
            } else {
                e.this.w.c(Boxing.boxInt(e.this.Q()), e.this.i);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearControllerImpl$onEvent$1", f = "LinearControllerImpl.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2974a;
        public final /* synthetic */ d c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d dVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = dVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return e.this.new b(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2974a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = e.this.g;
                d dVar = this.c;
                this.f2974a = 1;
                if (mutableSharedFlow.emit(dVar, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearControllerImpl$vastPrivacyIcon$1", f = "LinearControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function3<Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2975a;
        public /* synthetic */ boolean b;
        public /* synthetic */ Object c;

        public c(Continuation<? super c> continuation) {
            super(3, continuation);
        }

        public final Object a(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> continuation) {
            c cVar = new c(continuation);
            cVar.b = z;
            cVar.c = jVar;
            return cVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> continuation) {
            return a(bool.booleanValue(), jVar, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2975a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            boolean z = this.b;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j jVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j) this.c;
            if (z) {
                return jVar;
            }
            return null;
        }
    }

    public e(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f linear, int i, boolean z, Boolean bool, int i2, boolean z2, boolean z3, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, r externalLinkHandler) {
        String absolutePath;
        Intrinsics.checkNotNullParameter(linear, "linear");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        this.f2972a = linear;
        this.b = z2;
        this.c = z3;
        this.d = customUserEventBuilderService;
        this.e = externalLinkHandler;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.f = CoroutineScope;
        MutableSharedFlow<d> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.g = mutableSharedFlowMutableSharedFlow$default;
        this.h = mutableSharedFlowMutableSharedFlow$default;
        this.i = linear.l();
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.valueOf(z));
        this.j = MutableStateFlow;
        this.k = MutableStateFlow;
        MutableStateFlow<m<Long>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(new m(Long.valueOf(i)));
        this.l = MutableStateFlow2;
        this.m = FlowKt.asStateFlow(MutableStateFlow2);
        this.n = a.g.f2425a.b().h();
        if (K()) {
            absolutePath = linear.l();
        } else {
            absolutePath = linear.j().getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        }
        this.o = absolutePath;
        this.p = linear.h() != null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI = linear.i();
        List<String> listB = eVarI != null ? eVarI.b() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI2 = linear.i();
        this.q = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.b(listB, eVarI2 != null ? eVarI2.g() : null, null, 4, null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI3 = linear.i();
        y yVarF = eVarI3 != null ? eVarI3.f() : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI4 = linear.i();
        Integer numValueOf = eVarI4 != null ? Integer.valueOf(eVarI4.h()) : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI5 = linear.i();
        Integer numValueOf2 = eVarI5 != null ? Integer.valueOf(eVarI5.d()) : null;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e eVarI6 = linear.i();
        n nVarA = p.a(yVarF, numValueOf, numValueOf2, eVarI6 != null ? eVarI6.a() : null, CoroutineScope, context, customUserEventBuilderService, externalLinkHandler, new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.e$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return e.e(this.f$0);
            }
        }, new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.e$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return e.f(this.f$0);
            }
        });
        this.r = nVarA;
        Boolean bool2 = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(bool2);
        this.s = MutableStateFlow3;
        this.t = FlowKt.stateIn(FlowKt.combine(MutableStateFlow3, nVarA.N(), new c(null)), CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), null);
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(bool2);
        this.u = MutableStateFlow4;
        this.v = MutableStateFlow4;
        this.w = j.p.a(linear.n(), customUserEventBuilderService);
        FlowKt.launchIn(FlowKt.onEach(isPlaying(), new a(null)), CoroutineScope);
        this.x = i.a(bool, i2, linear.m());
    }

    public static final Unit e(e eVar) {
        eVar.q.a(Integer.valueOf(eVar.Q()), eVar.i);
        return Unit.INSTANCE;
    }

    public static final Unit f(e eVar) {
        eVar.q.b(Integer.valueOf(eVar.Q()), eVar.i);
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void D() {
        this.x.s();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void E() {
        this.x.pause();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public String F() {
        return this.o;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public boolean I() {
        return this.p;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public boolean K() {
        return this.n;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public StateFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j> N() {
        return this.t;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public StateFlow<m<Long>> P() {
        return this.m;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    public int Q() {
        return this.z;
    }

    public final void R() {
        this.s.setValue(Boolean.FALSE);
    }

    public final void S() {
        if (this.c) {
            a(false, f.a());
        }
    }

    public final void T() {
        if (this.b) {
            a(false, f.a());
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void d(boolean z) {
        this.u.setValue(Boolean.valueOf(z));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.f, null, 1, null);
        this.r.destroy();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void h() {
        this.y = true;
        this.w.f(Integer.valueOf(Q()), this.i);
        a(d.e.b);
        T();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void i() {
        this.r.i();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    public StateFlow<Boolean> isPlaying() {
        return this.v;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<d.a> l() {
        return this.x.l();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public StateFlow<Boolean> q() {
        return this.k;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    public void r() {
        if (!isPlaying().getValue().booleanValue() && this.l.getValue().a().longValue() == 0 && Q() == 0) {
            return;
        }
        this.l.setValue(new m<>(0L));
        this.w.e(Integer.valueOf(Q()), this.i);
        this.y = false;
        this.z = 0;
        this.x.H();
        R();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.n
    public void u() {
        this.r.u();
    }

    public static Object d(e eVar) {
        return Reflection.property0(new PropertyReference0Impl(eVar.x, g.class, "goNextAction", "getGoNextAction()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c
    public Flow<d> a() {
        return this.h;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.b
    public void b(a.AbstractC0526a.f position) {
        Intrinsics.checkNotNullParameter(position, "position");
        a(true, position);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void c(boolean z) {
        this.j.setValue(Boolean.valueOf(z));
        j jVar = this.w;
        if (z) {
            jVar.b(Integer.valueOf(Q()), this.i);
        } else {
            jVar.g(Integer.valueOf(Q()), this.i);
        }
    }

    public final Job a(d dVar) {
        return BuildersKt__Builders_commonKt.launch$default(this.f, null, null, new b(dVar, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void b() {
        a(d.c.b);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0526a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.w.a(button);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(int r9, int r10) {
        /*
            r8 = this;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.f r0 = r8.f2972a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.e r0 = r0.i()
            if (r0 != 0) goto L9
            return
        L9:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r r1 = r0.e()
            java.lang.Long r0 = r0.c()
            boolean r2 = r1 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r.a
            r3 = 0
            if (r2 == 0) goto L20
            int r2 = r10 / 100
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r$a r1 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r.a) r1
            int r1 = r1.a()
            int r2 = r2 * r1
            goto L2d
        L20:
            boolean r2 = r1 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r.b
            if (r2 == 0) goto L2c
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r$b r1 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r.b) r1
            long r1 = r1.a()
            int r2 = (int) r1
            goto L2d
        L2c:
            r2 = r3
        L2d:
            kotlin.ranges.IntRange r1 = new kotlin.ranges.IntRange
            r1.<init>(r3, r10)
            int r10 = kotlin.ranges.RangesKt.coerceIn(r2, r1)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r1 = r8.s
            if (r0 != 0) goto L3d
            if (r9 < r10) goto L4d
            goto L4c
        L3d:
            long r4 = (long) r10
            long r6 = r0.longValue()
            long r6 = r6 + r4
            long r9 = (long) r9
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 > 0) goto L4d
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 > 0) goto L4d
        L4c:
            r3 = 1
        L4d:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r3)
            r1.setValue(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.e.b(int, int):void");
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0526a.c.EnumC0528a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.w.a(buttonType);
    }

    public final void a(boolean z, a.AbstractC0526a.f fVar) {
        String strH = this.f2972a.h();
        if (strH != null) {
            if (z) {
                this.w.a(fVar, Integer.valueOf(Q()), this.i);
            }
            this.e.a(strH);
            a(d.a.b);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l error) {
        Intrinsics.checkNotNullParameter(error, "error");
        a(new d.C0514d(error));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress) {
        Pair pair;
        Intrinsics.checkNotNullParameter(progress, "progress");
        boolean z = progress instanceof i.a;
        if (z) {
            int iA = (int) ((i.a) progress).a();
            pair = TuplesKt.to(Integer.valueOf(iA), Integer.valueOf(iA));
        } else if (progress instanceof i.c) {
            i.c cVar = (i.c) progress;
            pair = TuplesKt.to(Integer.valueOf((int) cVar.c()), Integer.valueOf((int) cVar.d()));
        } else if (progress instanceof i.d) {
            pair = TuplesKt.to(0, Integer.valueOf((int) ((i.d) progress).b()));
        } else {
            if (!Intrinsics.areEqual(progress, i.b.b)) {
                throw new NoWhenBranchMatchedException();
            }
            return;
        }
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        this.z = iIntValue;
        if (!this.y && !(progress instanceof i.d)) {
            this.w.a(this.i, iIntValue, iIntValue2);
        }
        if (z) {
            if (!this.y) {
                a(d.b.b);
                S();
            }
            this.y = false;
        }
        this.x.a(iIntValue, iIntValue2);
        b(iIntValue, iIntValue2);
    }
}
