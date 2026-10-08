package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.N;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.VastActivity;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
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
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class N implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2478a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i c;
    public final CoroutineScope d;
    public final K e;
    public final MutableStateFlow<Boolean> f;
    public final StateFlow<Boolean> g;
    public final MutableStateFlow<Boolean> h;
    public final StateFlow<Boolean> i;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastFullscreenAdImpl$show$1", f = "VastFullscreenAd.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2479a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x c;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y d;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.N$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0425a extends FunctionReferenceImpl implements Function0<Unit> {
            public C0425a(Object obj) {
                super(0, obj, N.class, "onClose", "onClose()V", 0);
            }

            public final void a() {
                ((N) this.receiver).n();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y yVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = xVar;
            this.d = yVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return N.this.new a(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2479a;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> vVarA = N.this.e.a();
                    if (vVarA instanceof v.a) {
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVarA).a();
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar = this.c;
                        if (xVar != null) {
                            xVar.a(cVar);
                        }
                        return Unit.INSTANCE;
                    }
                    if (!(vVarA instanceof v.b)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a) ((v.b) vVarA).a();
                    if (!aVar.j().j().exists()) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, "VastFullscreenAdImpl", "VAST ad media file does not exist", null, false, 12, null);
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar2 = this.c;
                        if (xVar2 != null) {
                            xVar2.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l.d);
                        }
                        return Unit.INSTANCE;
                    }
                    VastActivity.Companion companion = VastActivity.INSTANCE;
                    Context context = N.this.f2478a;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y yVar = this.d;
                    C0425a c0425a = new C0425a(N.this);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z zVar = N.this.b;
                    final N n = N.this;
                    final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar3 = this.c;
                    Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b, Unit> function1 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.N$a$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return N.a.a(n, xVar3, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b) obj2);
                        }
                    };
                    this.f2479a = 1;
                    if (companion.a(aVar, context, yVar, c0425a, zVar, function1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                N.this.f.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            } catch (Throwable th) {
                N.this.f.setValue(Boxing.boxBoolean(false));
                throw th;
            }
        }

        public static final Unit a(N n, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
            n.a(bVar, xVar);
            return Unit.INSTANCE;
        }
    }

    public N(Context context, com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, InterfaceC3032m decLoader, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(loadVast, "loadVast");
        Intrinsics.checkNotNullParameter(decLoader, "decLoader");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        this.f2478a = context;
        this.b = watermark;
        this.c = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.f2440a;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.d = CoroutineScope;
        this.e = new K(bid, CoroutineScope, loadVast, decLoader, z);
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.f = MutableStateFlow;
        this.g = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.h = MutableStateFlow2;
        this.i = MutableStateFlow2;
    }

    public static Object f(N n) {
        return Reflection.property0(new PropertyReference0Impl(n.e, K.class, "isLoaded", "isLoaded()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        this.h.setValue(Boolean.TRUE);
        this.f.setValue(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.d, null, 1, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.c;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b
    public StateFlow<Boolean> isLoaded() {
        return this.e.isLoaded();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m
    public StateFlow<Boolean> k() {
        return this.i;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3017a
    public StateFlow<Boolean> l() {
        return this.g;
    }

    public final void p() {
        this.f.setValue(Boolean.TRUE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b
    public void a(long j, InterfaceC3018b.a aVar) {
        this.e.a(j, aVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y options, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar) {
        Intrinsics.checkNotNullParameter(options, "options");
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new a(xVar, options, null), 3, null);
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x xVar) {
        if (Intrinsics.areEqual(bVar, b.g.b)) {
            p();
            return;
        }
        if (Intrinsics.areEqual(bVar, b.C0489b.b)) {
            p();
            return;
        }
        if (Intrinsics.areEqual(bVar, b.d.b)) {
            p();
            return;
        }
        if (Intrinsics.areEqual(bVar, b.i.b)) {
            if (xVar != null) {
                xVar.a(true);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(bVar, b.c.b)) {
            if (xVar != null) {
                xVar.a(false);
            }
        } else if (Intrinsics.areEqual(bVar, b.a.b)) {
            if (xVar != null) {
                xVar.a();
            }
        } else if (bVar instanceof b.f) {
            if (xVar != null) {
                xVar.a(((b.f) bVar).a());
            }
        } else if (!Intrinsics.areEqual(bVar, b.h.b) && !Intrinsics.areEqual(bVar, b.e.b)) {
            throw new NoWhenBranchMatchedException();
        }
    }
}
