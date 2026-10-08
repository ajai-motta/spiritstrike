package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3021b extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g> {
    public static final int z = 8;
    public final Context h;
    public final com.moloco.sdk.internal.ortb.model.c i;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h j;
    public final r k;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z l;
    public final com.moloco.sdk.internal.A m;
    public final CoroutineScope n;
    public final com.moloco.sdk.internal.services.s o;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h p;
    public final String q;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i r;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g s;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x> t;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> u;
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> v;
    public final InterfaceC3018b w;
    public final MutableStateFlow<Boolean> x;
    public final StateFlow<Boolean> y;

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a */
    public static final class a implements InterfaceC3018b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutableStateFlow<Boolean> f2492a;
        public final StateFlow<Boolean> b;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a d;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0426a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2493a;

            static {
                int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.values().length];
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.f2440a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f2493a = iArr;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$b, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$load$1", f = "AggregatedBanner.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0427b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2494a;
            public final /* synthetic */ C3021b c;
            public final /* synthetic */ long d;
            public final /* synthetic */ InterfaceC3018b.a e;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$b$a, reason: collision with other inner class name */
            public static final class C0428a implements InterfaceC3018b.a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ InterfaceC3018b.a f2495a;
                public final /* synthetic */ C3021b b;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$b$a$a, reason: collision with other inner class name */
                public /* synthetic */ class C0429a {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f2496a;

                    static {
                        int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.values().length];
                        try {
                            iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.f2440a.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.b.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i.c.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        f2496a = iArr;
                    }
                }

                public C0428a(InterfaceC3018b.a aVar, C3021b c3021b) {
                    this.f2495a = aVar;
                    this.b = c3021b;
                }

                @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b.a
                public void a() {
                    InterfaceC3018b.a aVar = this.f2495a;
                    if (aVar != null) {
                        aVar.a();
                    }
                }

                @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b.a
                public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a timeoutError) {
                    Intrinsics.checkNotNullParameter(timeoutError, "timeoutError");
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i creativeType = this.b.getCreativeType();
                    int i = creativeType == null ? -1 : C0429a.f2496a[creativeType.ordinal()];
                    if (i == -1) {
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, this.b.q, "creativeType is null", new Throwable(), false, 8, null);
                        return;
                    }
                    if (i == 1) {
                        InterfaceC3018b.a aVar = this.f2495a;
                        if (aVar != null) {
                            aVar.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.h);
                            return;
                        }
                        return;
                    }
                    if (i == 2) {
                        InterfaceC3018b.a aVar2 = this.f2495a;
                        if (aVar2 != null) {
                            aVar2.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.i);
                            return;
                        }
                        return;
                    }
                    if (i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InterfaceC3018b.a aVar3 = this.f2495a;
                    if (aVar3 != null) {
                        aVar3.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.j);
                    }
                }

                @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b.a
                public void a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c internalError) {
                    Intrinsics.checkNotNullParameter(internalError, "internalError");
                    InterfaceC3018b.a aVar = this.f2495a;
                    if (aVar != null) {
                        aVar.a(internalError);
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0427b(C3021b c3021b, long j, InterfaceC3018b.a aVar, Continuation<? super C0427b> continuation) {
                super(2, continuation);
                this.c = c3021b;
                this.d = j;
                this.e = aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0427b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return a.this.new C0427b(this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f2494a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    a aVar = a.this;
                    this.f2494a = 1;
                    if (aVar.a(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C bannerImpl = this.c.getBannerImpl();
                if (bannerImpl != null) {
                    bannerImpl.a(this.d, new C0428a(this.e, this.c));
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$c */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1", f = "AggregatedBanner.kt", i = {0}, l = {151}, m = "prepareBanner", n = {"this"}, s = {"L$0"})
        public static final class c extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f2497a;
            public /* synthetic */ Object b;
            public int d;

            public c(Continuation<? super c> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.d |= Integer.MIN_VALUE;
                return a.this.a(this);
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$d */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$prepareBanner$2", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class d extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2498a;
            public /* synthetic */ boolean b;

            public d(Continuation<? super d> continuation) {
                super(2, continuation);
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                return ((d) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                d dVar = a.this.new d(continuation);
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
                if (this.f2498a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                a.this.f2492a.setValue(Boxing.boxBoolean(this.b));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$e */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$prepareBanner$3", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class e extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2499a;
            public /* synthetic */ boolean b;
            public final /* synthetic */ C3021b c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(C3021b c3021b, Continuation<? super e> continuation) {
                super(2, continuation);
                this.c = c3021b;
            }

            public final Object a(boolean z, Continuation<? super Unit> continuation) {
                return ((e) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                e eVar = new e(this.c, continuation);
                eVar.b = ((Boolean) obj).booleanValue();
                return eVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                return a(bool.booleanValue(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f2499a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.c.x.setValue(Boxing.boxBoolean(this.b));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$a$f */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$adLoader$1$prepareBanner$crType$1", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2500a;
            public final /* synthetic */ C3021b b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(C3021b c3021b, Continuation<? super f> continuation) {
                super(2, continuation);
                this.b = c3021b;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i> continuation) {
                return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new f(this.b, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f2500a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i iVarC = C3027h.f2529a.c(this.b.i.getAdm());
                this.b.r = iVarC;
                return iVarC;
            }
        }

        public a(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar) {
            this.d = aVar;
            MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
            this.f2492a = MutableStateFlow;
            this.b = FlowKt.asStateFlow(MutableStateFlow);
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b
        public StateFlow<Boolean> isLoaded() {
            return this.b;
        }

        @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b
        public void a(long j, InterfaceC3018b.a aVar) {
            BuildersKt__Builders_commonKt.launch$default(C3021b.this.n, null, null, new C0427b(C3021b.this, j, aVar, null), 3, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x012b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r19) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 469
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3021b.a.a(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.b$b, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.AggregatedBanner$destroy$1", f = "AggregatedBanner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0430b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2501a;

        public C0430b(Continuation<? super C0430b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0430b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3021b.this.new C0430b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2501a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            C3021b.super.destroy();
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C bannerImpl = C3021b.this.getBannerImpl();
            if (bannerImpl != null) {
                bannerImpl.destroy();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3021b(Context context, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i iVar, com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h options, r externalLinkHandler, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z watermark, com.moloco.sdk.internal.A viewLifecycleOwner, CoroutineScope scope, com.moloco.sdk.internal.services.s clickthroughService, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h buttonTracker) {
        super(context, scope);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(externalLinkHandler, "externalLinkHandler");
        Intrinsics.checkNotNullParameter(watermark, "watermark");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(clickthroughService, "clickthroughService");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        this.h = context;
        this.i = bid;
        this.j = options;
        this.k = externalLinkHandler;
        this.l = watermark;
        this.m = viewLifecycleOwner;
        this.n = scope;
        this.o = clickthroughService;
        this.p = buttonTracker;
        this.q = "AggregatedBanner";
        setTag("MolocoAggregatedBannerView");
        this.r = iVar;
        this.w = new a(customUserEventBuilderService);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.x = MutableStateFlow;
        this.y = FlowKt.asStateFlow(MutableStateFlow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<?> getBannerImpl() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x> c = this.t;
        if (c != null) {
            return c;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> c2 = this.u;
        return c2 == null ? this.v : c2;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        BuildersKt__Builders_commonKt.launch$default(this.n, null, null, new C0430b(null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public InterfaceC3018b getAdLoader() {
        return this.w;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.j
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i getCreativeType() {
        return this.r;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g getAdShowListener() {
        return this.s;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public void k() {
        setAdView(getBannerImpl());
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3017a
    public StateFlow<Boolean> l() {
        return this.y;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C
    public void setAdShowListener(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.g gVar) {
        this.s = gVar;
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.x> c = this.t;
        if (c != null) {
            c.setAdShowListener(gVar);
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.C<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.e> c2 = this.u;
        if (c2 == null) {
            c2 = this.v;
        }
        if (c2 != null) {
            c2.setAdShowListener(gVar);
        }
    }
}
