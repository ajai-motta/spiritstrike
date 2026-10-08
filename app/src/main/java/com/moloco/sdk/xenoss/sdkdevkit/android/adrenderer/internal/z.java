package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.MraidActivity;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class z implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3025a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z b;
    public final x c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e d;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j e;
    public final MraidActivity.Companion f;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i g;
    public final CoroutineScope h;
    public InterfaceC3018b.a i;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e j;
    public boolean k;
    public final MutableStateFlow<Boolean> l;
    public final StateFlow<Boolean> m;
    public final MutableStateFlow<Boolean> n;
    public final StateFlow<Boolean> o;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d, Unit> {
        public a(Object obj) {
            super(1, obj, z.class, "onError", "onError(Lcom/moloco/sdk/xenoss/sdkdevkit/android/adrenderer/internal/errors/MraidAdError;)V", 0);
        }

        public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((z) this.receiver).a(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar) {
            a(dVar);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Unit> {
        public b(Object obj) {
            super(0, obj, z.class, "destroy", "destroy()V", 0);
        }

        public final void a() {
            ((z) this.receiver).destroy();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<Unit> {
        public c(Object obj) {
            super(0, obj, z.class, "onForciblyClosed", "onForciblyClosed()V", 0);
        }

        public final void a() {
            ((z) this.receiver).n();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public z(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, x mraidAdLoader, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.e mraidBaseAd, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j mraidFullscreenController, MraidActivity.Companion mraidActivity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(mraidAdLoader, "mraidAdLoader");
        Intrinsics.checkNotNullParameter(mraidBaseAd, "mraidBaseAd");
        Intrinsics.checkNotNullParameter(mraidFullscreenController, "mraidFullscreenController");
        Intrinsics.checkNotNullParameter(mraidActivity, "mraidActivity");
        this.f3025a = context;
        this.b = watermark;
        this.c = mraidAdLoader;
        this.d = mraidBaseAd;
        this.e = mraidFullscreenController;
        this.f = mraidActivity;
        this.g = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.b;
        this.h = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        Boolean bool = Boolean.FALSE;
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(bool);
        this.l = MutableStateFlow;
        this.m = MutableStateFlow;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(bool);
        this.n = MutableStateFlow2;
        this.o = MutableStateFlow2;
    }

    public static Object b(z zVar) {
        return Reflection.property0(new PropertyReference0Impl(zVar.c, x.class, "isLoaded", "isLoaded()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.h, null, 1, null);
        this.d.destroy();
        this.l.setValue(Boolean.FALSE);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b
    public StateFlow<Boolean> isLoaded() {
        return this.c.isLoaded();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.m
    public StateFlow<Boolean> k() {
        return this.o;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3017a
    public StateFlow<Boolean> l() {
        return this.m;
    }

    public final void n() {
        this.n.setValue(Boolean.TRUE);
    }

    public static final Unit b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar) {
        if (eVar != null) {
            eVar.a();
        }
        return Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b
    public void a(long j, InterfaceC3018b.a aVar) {
        this.i = aVar;
        this.d.a(new a(this));
        this.c.a(j, aVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.l
    public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f options, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.d.a(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return z.b(eVar);
            }
        });
        this.j = eVar;
        this.k = true;
        com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d> vVarA = this.c.a();
        if (vVarA instanceof v.a) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d) ((v.a) vVarA).a();
            if (eVar != null) {
                eVar.a(dVar);
                return;
            }
            return;
        }
        if (vVarA instanceof v.b) {
            if (this.f.a((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.c) ((v.b) vVarA).a(), this.e, this.f3025a, options, this.b, new b(this), new c(this), this.d.I())) {
                this.l.setValue(Boolean.TRUE);
                return;
            } else {
                if (eVar != null) {
                    eVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d.j);
                    return;
                }
                return;
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.d dVar) {
        if (this.k) {
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e eVar = this.j;
            if (eVar != null) {
                eVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.b(dVar));
                return;
            }
            return;
        }
        InterfaceC3018b.a aVar = this.i;
        if (aVar != null) {
            aVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.e.b(dVar));
        }
    }
}
