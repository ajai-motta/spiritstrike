package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.x;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class f implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a {
    public static final int l = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<k> f2850a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h b;
    public final CoroutineScope c;
    public final MutableStateFlow<k> d;
    public final StateFlow<i.a> e;
    public final StateFlow<Boolean> f;
    public final Flow<Boolean> g;
    public final StateFlow<Boolean> h;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.c i;
    public final MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> j;
    public final Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> k;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$1", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2851a;
        public /* synthetic */ Object b;
        public final /* synthetic */ k d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k kVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = kVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar, Continuation<? super Unit> continuation) {
            return ((a) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = f.this.new a(this.d, continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2851a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.b) this.b;
            if (bVar instanceof b.d) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = f.this.b;
                if (hVar != null) {
                    hVar.a(x.j);
                }
                f.this.a(new b.f(((b.d) bVar).b()));
            } else if (bVar instanceof b.a) {
                f.this.a(b.a.b);
            } else if (bVar instanceof b.c) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar2 = f.this.b;
                if (hVar2 != null) {
                    Boxing.boxBoolean(hVar2.b());
                }
                f.this.a(b.C0489b.b);
            } else {
                if (!(bVar instanceof b.C0496b)) {
                    throw new NoWhenBranchMatchedException();
                }
                ((k.a) this.d).a().destroy();
                Unit unit = Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$2", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2852a;
        public /* synthetic */ Object b;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar, Continuation<? super Unit> continuation) {
            return ((b) create(dVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = f.this.new b(continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2852a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d dVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d) this.b;
            if (dVar instanceof d.C0514d) {
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = f.this.b;
                if (hVar != null) {
                    hVar.a(x.g);
                }
                f.this.a(new b.f(((d.C0514d) dVar).b()));
            } else if (Intrinsics.areEqual(dVar, d.a.b)) {
                f.this.a(b.a.b);
            } else if (Intrinsics.areEqual(dVar, d.e.b)) {
                f.this.a(b.i.b);
                f.this.S();
                Unit unit = Unit.INSTANCE;
            } else if (Intrinsics.areEqual(dVar, d.b.b)) {
                f.this.a(b.c.b);
                Boxing.boxBoolean(f.this.R());
            } else {
                if (!Intrinsics.areEqual(dVar, d.c.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar2 = f.this.b;
                if (hVar2 != null) {
                    Boxing.boxBoolean(hVar2.b());
                }
                f.this.a(b.g.b);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$3", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2853a;
        public /* synthetic */ Object b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2854a;

            static {
                int[] iArr = new int[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b.values().length];
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b.b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b.f2952a.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f2854a = iArr;
            }
        }

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b bVar, Continuation<? super Unit> continuation) {
            return ((c) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = f.this.new c(continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2853a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = a.f2854a[((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.b) this.b).ordinal()];
            if (i == 1) {
                f.this.a(b.a.b);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = f.this.b;
                if (hVar != null) {
                    Boxing.boxBoolean(hVar.b());
                }
                f.this.a(b.d.b);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$4", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<l, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2855a;
        public /* synthetic */ Object b;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2856a;

            static {
                int[] iArr = new int[l.values().length];
                try {
                    iArr[l.f2585a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[l.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f2856a = iArr;
            }
        }

        public d(Continuation<? super d> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(l lVar, Continuation<? super Unit> continuation) {
            return ((d) create(lVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = f.this.new d(continuation);
            dVar.b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2855a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = a.f2856a[((l) this.b).ordinal()];
            if (i == 1) {
                f.this.a(b.i.b);
                f.this.S();
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                f.this.a(b.a.b);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$canReplay$1", f = "AdPlaylistControllerImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function3<k, Boolean, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2857a;
        public /* synthetic */ Object b;
        public /* synthetic */ Object c;

        public e(Continuation<? super e> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(k kVar, Boolean bool, Continuation<? super Boolean> continuation) {
            e eVar = f.this.new e(continuation);
            eVar.b = kVar;
            eVar.c = bool;
            return eVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r3) throws java.lang.Throwable {
            /*
                r2 = this;
                kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r2.f2857a
                if (r0 != 0) goto L36
                kotlin.ResultKt.throwOnFailure(r3)
                java.lang.Object r3 = r2.b
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k r3 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k) r3
                java.lang.Object r0 = r2.c
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                if (r3 == 0) goto L30
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f r1 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.this
                java.util.List r1 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.b(r1)
                java.lang.Object r1 = kotlin.collections.CollectionsKt.last(r1)
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r1)
                if (r3 == 0) goto L30
                r3 = 1
                java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                if (r0 != 0) goto L30
                goto L31
            L30:
                r3 = 0
            L31:
                java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                return r3
            L36:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r0)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$f, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$onEvent$1", f = "AdPlaylistControllerImpl.kt", i = {}, l = {239}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0490f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2858a;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0490f(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar, Continuation<? super C0490f> continuation) {
            super(2, continuation);
            this.c = bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0490f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return f.this.new C0490f(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2858a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableSharedFlow mutableSharedFlow = f.this.j;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar = this.c;
                this.f2858a = 1;
                if (mutableSharedFlow.emit(bVar, this) == coroutine_suspended) {
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

    public static final class g implements Flow<i.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f2859a;
        public final /* synthetic */ f b;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f2860a;
            public final /* synthetic */ f b;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$g$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$special$$inlined$map$1$2", f = "AdPlaylistControllerImpl.kt", i = {}, l = {50}, m = "emit", n = {}, s = {})
            public static final class C0491a extends ContinuationImpl {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f2861a;
                public int b;
                public Object c;

                public C0491a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f2861a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector, f fVar) {
                this.f2860a = flowCollector;
                this.b = fVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlinx.coroutines.flow.FlowCollector
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.g.a.C0491a
                    if (r0 == 0) goto L13
                    r0 = r7
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$g$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.g.a.C0491a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$g$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$g$a$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.f2861a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L92
                L29:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L31:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r5.f2860a
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f r2 = r5.b
                    java.util.List r2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.b(r2)
                    java.lang.Object r2 = kotlin.collections.CollectionsKt.lastOrNull(r2)
                    boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r6)
                    boolean r4 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.a
                    if (r4 == 0) goto L56
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$a r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$a
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$a r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.a) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a r6 = r6.a()
                    r4.<init>(r6, r2)
                    goto L89
                L56:
                    boolean r4 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.c
                    if (r4 == 0) goto L66
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$c r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$c
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$c r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.c) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c r6 = r6.a()
                    r4.<init>(r6, r2)
                    goto L89
                L66:
                    boolean r4 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.b
                    if (r4 == 0) goto L76
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$b r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$b
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$b r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.b) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a r6 = r6.a()
                    r4.<init>(r6, r2)
                    goto L89
                L76:
                    boolean r4 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.d
                    if (r4 == 0) goto L86
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$d r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$d
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$d r6 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.d) r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j r6 = r6.a()
                    r4.<init>(r6, r2)
                    goto L89
                L86:
                    if (r6 != 0) goto L95
                    r4 = 0
                L89:
                    r0.b = r3
                    java.lang.Object r6 = r7.emit(r4, r0)
                    if (r6 != r1) goto L92
                    return r1
                L92:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                L95:
                    kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
                    r6.<init>()
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.g.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public g(Flow flow, f fVar) {
            this.f2859a = flow;
            this.b = fVar;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super i.a> flowCollector, Continuation continuation) {
            Object objCollect = this.f2859a.collect(new a(flowCollector, this.b), continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    public static final class h implements Flow<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Flow f2862a;

        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlowCollector f2863a;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$h$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.AdPlaylistControllerImpl$special$$inlined$map$2$2", f = "AdPlaylistControllerImpl.kt", i = {}, l = {50}, m = "emit", n = {}, s = {})
            public static final class C0492a extends ContinuationImpl {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f2864a;
                public int b;
                public Object c;

                public C0492a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f2864a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.f2863a = flowCollector;
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
                    boolean r0 = r6 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.h.a.C0492a
                    if (r0 == 0) goto L13
                    r0 = r6
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$h$a$a r0 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.h.a.C0492a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L18
                L13:
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$h$a$a r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f$h$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f2864a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L70
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    kotlin.ResultKt.throwOnFailure(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.f2863a
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k) r5
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.a
                    if (r2 == 0) goto L47
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$a r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.a) r5
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a r5 = r5.a()
                    boolean r5 = r5.I()
                    goto L63
                L47:
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.c
                    if (r2 == 0) goto L56
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k$c r5 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.c) r5
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c r5 = r5.a()
                    boolean r5 = r5.I()
                    goto L63
                L56:
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.b
                    if (r2 == 0) goto L5b
                    goto L62
                L5b:
                    boolean r2 = r5 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k.d
                    if (r2 == 0) goto L60
                    goto L62
                L60:
                    if (r5 != 0) goto L73
                L62:
                    r5 = 0
                L63:
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                    r0.b = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L70
                    return r1
                L70:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                L73:
                    kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
                    r5.<init>()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.f.h.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public h(Flow flow) {
            this.f2862a = flow;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
            Object objCollect = this.f2862a.collect(new a(flowCollector), continuation);
            return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends k> playlist, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar) {
        Flow flowOnEach;
        Intrinsics.checkNotNullParameter(playlist, "playlist");
        this.f2850a = playlist;
        this.b = hVar;
        CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
        this.c = CoroutineScope;
        MutableStateFlow<k> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.d = MutableStateFlow;
        g gVar = new g(MutableStateFlow, this);
        SharingStarted.Companion companion = SharingStarted.INSTANCE;
        this.e = FlowKt.stateIn(gVar, CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), null);
        h hVar2 = new h(MutableStateFlow);
        SharingStarted sharingStartedWhileSubscribed$default = SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null);
        Boolean bool = Boolean.FALSE;
        this.f = FlowKt.stateIn(hVar2, CoroutineScope, sharingStartedWhileSubscribed$default, bool);
        Flow<Boolean> flowB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b((Flow<? extends k>) MutableStateFlow, CoroutineScope);
        this.g = flowB;
        this.h = FlowKt.stateIn(FlowKt.combine(MutableStateFlow, flowB, new e(null)), CoroutineScope, SharingStarted.Companion.WhileSubscribed$default(companion, 0L, 0L, 3, null), bool);
        this.i = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.e.a(MutableStateFlow, CoroutineScope);
        MutableSharedFlow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> mutableSharedFlowMutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this.j = mutableSharedFlowMutableSharedFlow$default;
        this.k = mutableSharedFlowMutableSharedFlow$default;
        for (k kVar : playlist) {
            if (kVar instanceof k.a) {
                flowOnEach = FlowKt.onEach(((k.a) kVar).a().a(), new a(kVar, null));
            } else if (kVar instanceof k.c) {
                flowOnEach = FlowKt.onEach(((k.c) kVar).a().a(), new b(null));
            } else if (kVar instanceof k.b) {
                flowOnEach = FlowKt.onEach(((k.b) kVar).a().a(), new c(null));
            } else {
                if (!(kVar instanceof k.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                flowOnEach = FlowKt.onEach(((k.d) kVar).a().a(), new d(null));
            }
            FlowKt.launchIn(flowOnEach, this.c);
        }
    }

    public static Object f(f fVar) {
        return Reflection.property0(new PropertyReference0Impl(fVar.i, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.c.class, "goNextAction", "getGoNextAction()Lkotlinx/coroutines/flow/StateFlow;", 0));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public void A() {
        k value = this.d.getValue();
        if (value instanceof k.a) {
            ((k.a) value).a().b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.f.a());
            return;
        }
        if (value instanceof k.c) {
            ((k.c) value).a().b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.f.a());
            return;
        }
        if (value instanceof k.b) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f2865a, "Empty CTA DEC playlist item reached", null, false, 12, null);
        } else if (value instanceof k.d) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f2865a, "Empty CTA Mraid playlist item reached", null, false, 12, null);
        } else {
            if (value != null) {
                throw new NoWhenBranchMatchedException();
            }
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f2865a, "Empty CTA playlist item reached", null, false, 12, null);
        }
    }

    public final void I() {
        k kVar = (k) CollectionsKt.firstOrNull((List) this.f2850a);
        if (kVar == null) {
            return;
        }
        a(kVar);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public StateFlow<Boolean> O() {
        return this.h;
    }

    public final boolean R() {
        List<k> list = this.f2850a;
        k kVar = (k) CollectionsKt.getOrNull(list, CollectionsKt.indexOf((List<? extends k>) list, this.d.getValue()) + 1);
        if (kVar == null) {
            return false;
        }
        a(kVar);
        return true;
    }

    public final void S() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a aVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b((List<? extends k>) this.f2850a, this.d.getValue());
        if (aVarB != null) {
            aVarB.t();
        }
        if (R()) {
            return;
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.h hVar = this.b;
        if (hVar != null) {
            hVar.a();
        }
        a(b.e.b);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.k
    public void destroy() {
        CoroutineScopeKt.cancel$default(this.c, null, 1, null);
        for (k kVar : this.f2850a) {
            if (kVar instanceof k.a) {
                ((k.a) kVar).a().destroy();
            } else if (kVar instanceof k.c) {
                ((k.c) kVar).a().destroy();
            } else if (kVar instanceof k.b) {
                ((k.b) kVar).a().destroy();
            } else {
                if (!(kVar instanceof k.d)) {
                    throw new NoWhenBranchMatchedException();
                }
                ((k.d) kVar).a().destroy();
            }
        }
        a((k) null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public StateFlow<i.a> k() {
        return this.e;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    public StateFlow<d.a> l() {
        return this.i.l();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public StateFlow<Boolean> n() {
        return this.f;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public void x() {
        if (l().getValue() instanceof d.a.C0513a) {
            k value = this.d.getValue();
            k.c cVar = value instanceof k.c ? (k.c) value : null;
            if (cVar != null) {
                cVar.a().h();
            } else {
                S();
            }
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i
    public void z() {
        I();
        a(b.h.b);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a
    public void d() {
        I();
    }

    public final void a(k kVar) {
        this.d.setValue(kVar);
        if (kVar instanceof k.c) {
            ((k.c) kVar).a().r();
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.a
    public Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b> a() {
        return this.k;
    }

    public final Job a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.b bVar) {
        return BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new C0490f(bVar, null), 3, null);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0526a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        a.AbstractC0526a.c cVarB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b((List<? extends k>) this.f2850a, this.d.getValue(), button);
        k value = this.d.getValue();
        if (value instanceof k.c) {
            ((k.c) value).a().a(cVarB);
            return;
        }
        if (value instanceof k.a) {
            ((k.a) value).a().a(cVarB);
            return;
        }
        if (value instanceof k.b) {
            ((k.b) value).a().a(cVarB);
            return;
        }
        if (value instanceof k.d) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f2865a, "Empty onButtonRendered MRAID playlist item reached", null, false, 12, null);
            return;
        }
        if (value == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f2865a, "Displaying " + cVarB.d() + " at position: " + cVarB.e() + " of size: " + cVarB.f() + " in unknown playlist item type", null, false, 12, null);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.g
    public void a(a.AbstractC0526a.c.EnumC0528a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        a.AbstractC0526a.c.EnumC0528a enumC0528aB = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.b((List<? extends k>) this.f2850a, this.d.getValue(), buttonType);
        k value = this.d.getValue();
        if (value instanceof k.c) {
            ((k.c) value).a().a(enumC0528aB);
            return;
        }
        if (value instanceof k.a) {
            ((k.a) value).a().a(enumC0528aB);
            return;
        }
        if (value instanceof k.b) {
            ((k.b) value).a().a(enumC0528aB);
            return;
        }
        if (value instanceof k.d) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f2865a, "Empty onButtonUnRendered MRAID playlist item reached", null, false, 12, null);
            return;
        }
        if (value == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.g.f2865a, "Unrendering " + enumC0528aB + " in unknown playlist item type", null, false, 12, null);
            return;
        }
        throw new NoWhenBranchMatchedException();
    }
}
