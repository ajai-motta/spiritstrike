package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class K implements InterfaceC3018b {
    public static final int j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.ortb.model.c f2467a;
    public final CoroutineScope b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d c;
    public final InterfaceC3032m d;
    public final boolean e;
    public com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> f;
    public final MutableStateFlow<Boolean> g;
    public final StateFlow<Boolean> h;
    public Job i;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1", f = "VastAdLoad.kt", i = {0}, l = {80, 94}, m = "invokeSuspend", n = {"decDeferred"}, s = {"L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2468a;
        public /* synthetic */ Object b;
        public final /* synthetic */ InterfaceC3018b.a d;
        public final /* synthetic */ long e;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$decDeferred$1", f = "VastAdLoad.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0421a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3028i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2469a;
            public final /* synthetic */ long b;
            public final /* synthetic */ C3028i c;
            public final /* synthetic */ K d;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K$a$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$decDeferred$1$1", f = "VastAdLoad.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0422a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3028i>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2470a;
                public final /* synthetic */ C3028i b;
                public final /* synthetic */ K c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0422a(C3028i c3028i, K k, Continuation<? super C0422a> continuation) {
                    super(2, continuation);
                    this.b = c3028i;
                    this.c = k;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3028i> continuation) {
                    return ((C0422a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0422a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f2470a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        C3028i c3028i = this.b;
                        if (c3028i == null) {
                            return null;
                        }
                        K k = this.c;
                        InterfaceC3032m interfaceC3032m = k.d;
                        com.moloco.sdk.internal.ortb.model.d ext = k.f2467a.getExt();
                        String mtid = ext != null ? ext.getMtid() : null;
                        this.f2470a = 1;
                        obj = interfaceC3032m.a(c3028i, mtid, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (C3028i) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0421a(long j, C3028i c3028i, K k, Continuation<? super C0421a> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = c3028i;
                this.d = k;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3028i> continuation) {
                return ((C0421a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0421a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f2469a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0422a c0422a = new C0422a(this.c, this.d, null);
                    this.f2469a = 1;
                    obj = TimeoutKt.m8935withTimeoutOrNullKLykuaI(j, c0422a, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                C3028i c3028i = (C3028i) obj;
                return c3028i == null ? this.c : c3028i;
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$vastAdDeferred$1", f = "VastAdLoad.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2471a;
            public final /* synthetic */ long b;
            public final /* synthetic */ K c;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K$a$b$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$fullLoad$1$vastAdDeferred$1$1", f = "VastAdLoad.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0423a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2472a;
                public final /* synthetic */ K b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0423a(K k, Continuation<? super C0423a> continuation) {
                    super(2, continuation);
                    this.b = k;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
                    return ((C0423a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0423a(this.b, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f2472a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d dVar = this.b.c;
                        String adm = this.b.f2467a.getAdm();
                        String strA = com.moloco.sdk.internal.ortb.model.f.a(this.b.f2467a);
                        this.f2472a = 1;
                        obj = dVar.a(adm, strA, false, this);
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
            public b(long j, K k, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = k;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f2471a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0423a c0423a = new C0423a(this.c, null);
                    this.f2471a = 1;
                    obj = TimeoutKt.m8934withTimeoutKLykuaI(j, c0423a, this);
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
        public a(InterfaceC3018b.a aVar, long j, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = aVar;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = K.this.new a(this.d, this.e, continuation);
            aVar.b = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:39:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x011b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 289
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1", f = "VastAdLoad.kt", i = {0, 1, 1}, l = {118, 133, TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend", n = {"$this$launch", "vastAdDeferred", "decDeferred"}, s = {"L$0", "L$0", "L$1"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2473a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ InterfaceC3018b.a e;
        public final /* synthetic */ long f;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1$decDeferred$1", f = "VastAdLoad.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3028i>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2474a;
            public final /* synthetic */ long b;
            public final /* synthetic */ C3028i c;
            public final /* synthetic */ K d;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K$b$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.VastAdLoad$streamedLoad$1$decDeferred$1$1", f = "VastAdLoad.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0424a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C3028i>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f2475a;
                public final /* synthetic */ C3028i b;
                public final /* synthetic */ K c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0424a(C3028i c3028i, K k, Continuation<? super C0424a> continuation) {
                    super(2, continuation);
                    this.b = c3028i;
                    this.c = k;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3028i> continuation) {
                    return ((C0424a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0424a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f2475a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        C3028i c3028i = this.b;
                        if (c3028i == null) {
                            return null;
                        }
                        K k = this.c;
                        InterfaceC3032m interfaceC3032m = k.d;
                        String mtid = k.f2467a.getExt().getMtid();
                        this.f2475a = 1;
                        obj = interfaceC3032m.a(c3028i, mtid, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return (C3028i) obj;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(long j, C3028i c3028i, K k, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = j;
                this.c = c3028i;
                this.d = k;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super C3028i> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f2474a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    long j = this.b;
                    C0424a c0424a = new C0424a(this.c, this.d, null);
                    this.f2474a = 1;
                    obj = TimeoutKt.m8935withTimeoutOrNullKLykuaI(j, c0424a, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                C3028i c3028i = (C3028i) obj;
                return c3028i == null ? this.c : c3028i;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC3018b.a aVar, long j, Continuation<? super b> continuation) {
            super(2, continuation);
            this.e = aVar;
            this.f = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = K.this.new b(this.e, this.f, continuation);
            bVar.c = obj;
            return bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00dc  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0124  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 386
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public K(com.moloco.sdk.internal.ortb.model.c bid, CoroutineScope scope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d loadVast, InterfaceC3032m decLoader, boolean z) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(loadVast, "loadVast");
        Intrinsics.checkNotNullParameter(decLoader, "decLoader");
        this.f2467a = bid;
        this.b = scope;
        this.c = loadVast;
        this.d = decLoader;
        this.e = z;
        this.f = new v.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.f2523a);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(Boolean.FALSE);
        this.g = MutableStateFlow;
        this.h = FlowKt.asStateFlow(MutableStateFlow);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b
    public StateFlow<Boolean> isLoaded() {
        return this.h;
    }

    public final void c(long j2, InterfaceC3018b.a aVar) {
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.i = BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new b(aVar, j2, null), 3, null);
    }

    public final com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> a() {
        return this.f;
    }

    public final void b(long j2, InterfaceC3018b.a aVar) {
        Job job = this.i;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.i = BuildersKt__Builders_commonKt.launch$default(this.b, null, null, new a(aVar, j2, null), 3, null);
    }

    public final void a(com.moloco.sdk.internal.v<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c> vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<set-?>");
        this.f = vVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.InterfaceC3018b
    public void a(long j2, InterfaceC3018b.a aVar) {
        if (this.e) {
            c(j2, aVar);
        } else {
            b(j2, aVar);
        }
    }

    public final void b(Deferred<C3028i> deferred, InterfaceC3018b.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a aVar2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.a.b;
        this.f = new v.a(cVar);
        if (aVar != null) {
            aVar.a(aVar2);
        }
    }

    public final void a(Deferred<C3028i> deferred, InterfaceC3018b.a aVar, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        MolocoLogger.error$default(MolocoLogger.INSTANCE, L.f2476a, "Vast AD failed to load: " + cVar, null, false, 12, null);
        Job.DefaultImpls.cancel$default((Job) deferred, (CancellationException) null, 1, (Object) null);
        this.f = new v.a(cVar);
        if (aVar != null) {
            aVar.a(cVar);
        }
    }
}
