package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.S;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class S {

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$collectLatestIsAttachedWindow$2", f = "ViewVisibilityTracker.kt", i = {}, l = {46, 49}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2482a;
        public /* synthetic */ boolean b;
        public final /* synthetic */ ProducerScope<Boolean> c;
        public final /* synthetic */ View d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = producerScope;
            this.d = view;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((a) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.c, this.d, continuation);
            aVar.b = ((Boolean) obj).booleanValue();
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2482a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.b) {
                    ProducerScope<Boolean> producerScope = this.c;
                    View view = this.d;
                    this.f2482a = 1;
                    if (S.f(producerScope, view, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    ProducerScope<Boolean> producerScope2 = this.c;
                    Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                    this.f2482a = 2;
                    if (producerScope2.send(boolBoxBoolean, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$collectLatestIsEnoughAreaVisible$2", f = "ViewVisibilityTracker.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2483a;
        public /* synthetic */ boolean b;
        public final /* synthetic */ ProducerScope<Boolean> c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(ProducerScope<? super Boolean> producerScope, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = producerScope;
        }

        public final Object a(boolean z, Continuation<? super Unit> continuation) {
            return ((b) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.c, continuation);
            bVar.b = ((Boolean) obj).booleanValue();
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return a(bool.booleanValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2483a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boolean z = this.b;
                ProducerScope<Boolean> producerScope = this.c;
                Boolean boolBoxBoolean = Boxing.boxBoolean(z);
                this.f2483a = 1;
                if (producerScope.send(boolBoxBoolean, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$collectLatestIsLifecycleResumed$2", f = "ViewVisibilityTracker.kt", i = {}, l = {59, 62}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2484a;
        public /* synthetic */ Object b;
        public final /* synthetic */ ProducerScope<Boolean> c;
        public final /* synthetic */ View d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super c> continuation) {
            super(2, continuation);
            this.c = producerScope;
            this.d = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
            return ((c) create(bool, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            c cVar = new c(this.c, this.d, continuation);
            cVar.b = obj;
            return cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2484a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Intrinsics.areEqual((Boolean) this.b, Boxing.boxBoolean(false))) {
                    ProducerScope<Boolean> producerScope = this.c;
                    Boolean boolBoxBoolean = Boxing.boxBoolean(false);
                    this.f2484a = 2;
                    if (producerScope.send(boolBoxBoolean, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    ProducerScope<Boolean> producerScope2 = this.c;
                    View view = this.d;
                    this.f2484a = 1;
                    if (S.e(producerScope2, view, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1 && i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isAttachedToWindowFlow$1", f = "ViewVisibilityTracker.kt", i = {0}, l = {75, 91}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
    public static final class d extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2485a;
        public /* synthetic */ Object b;
        public final /* synthetic */ View c;

        public static final class a implements View.OnAttachStateChangeListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ProducerScope<Boolean> f2486a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(ProducerScope<? super Boolean> producerScope) {
                this.f2486a = producerScope;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                this.f2486a.mo7333trySendJP2dKIU(Boolean.TRUE);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View p0) {
                Intrinsics.checkNotNullParameter(p0, "p0");
                this.f2486a.mo7333trySendJP2dKIU(Boolean.FALSE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(View view, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
            return ((d) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.c, continuation);
            dVar.b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            ProducerScope producerScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2485a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                producerScope = (ProducerScope) this.b;
                Boolean boolBoxBoolean = Boxing.boxBoolean(this.c.isAttachedToWindow());
                this.b = producerScope;
                this.f2485a = 1;
                if (producerScope.send(boolBoxBoolean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                producerScope = (ProducerScope) this.b;
                ResultKt.throwOnFailure(obj);
            }
            final a aVar = new a(producerScope);
            this.c.addOnAttachStateChangeListener(aVar);
            final View view = this.c;
            Function0 function0 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.S$d$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return S.d.a(view, aVar);
                }
            };
            this.b = null;
            this.f2485a = 2;
            if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        public static final Unit a(View view, a aVar) {
            view.removeOnAttachStateChangeListener(aVar);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isEnoughAreaVisibleFlow$1", f = "ViewVisibilityTracker.kt", i = {0, 0, 1, 1}, l = {133, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO}, m = "invokeSuspend", n = {"$this$flow", "rect", "$this$flow", "rect"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class e extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2487a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ View d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(View view, Continuation<? super e> continuation) {
            super(2, continuation);
            this.d = view;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
            return ((e) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            e eVar = new e(this.d, continuation);
            eVar.c = obj;
            return eVar;
        }

        /* JADX WARN: Path cross not found for [B:13:0x0044, B:16:0x004e], limit reached: 23 */
        /* JADX WARN: Path cross not found for [B:16:0x004e, B:13:0x0044], limit reached: 23 */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006e A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006c -> B:11:0x003c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r8.b
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r8.f2487a
                android.graphics.Rect r1 = (android.graphics.Rect) r1
                java.lang.Object r5 = r8.c
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.ResultKt.throwOnFailure(r9)
                goto L3c
            L1b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L23:
                java.lang.Object r1 = r8.f2487a
                android.graphics.Rect r1 = (android.graphics.Rect) r1
                java.lang.Object r5 = r8.c
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.ResultKt.throwOnFailure(r9)
                goto L60
            L2f:
                kotlin.ResultKt.throwOnFailure(r9)
                java.lang.Object r9 = r8.c
                r5 = r9
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                android.graphics.Rect r1 = new android.graphics.Rect
                r1.<init>(r4, r4, r4, r4)
            L3c:
                android.view.View r9 = r8.d
                boolean r9 = r9.isShown()
                if (r9 == 0) goto L4e
                android.view.View r9 = r8.d
                boolean r9 = r9.getGlobalVisibleRect(r1)
                if (r9 == 0) goto L4e
                r9 = r3
                goto L4f
            L4e:
                r9 = r4
            L4f:
                java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
                r8.c = r5
                r8.f2487a = r1
                r8.b = r3
                java.lang.Object r9 = r5.emit(r9, r8)
                if (r9 != r0) goto L60
                return r0
            L60:
                r8.c = r5
                r8.f2487a = r1
                r8.b = r2
                r6 = 500(0x1f4, double:2.47E-321)
                java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r6, r8)
                if (r9 != r0) goto L3c
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.S.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isLifecycleResumedFlow$1", f = "ViewVisibilityTracker.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<ProducerScope<? super Boolean>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2488a;
        public /* synthetic */ Object b;
        public final /* synthetic */ Lifecycle c;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f2489a;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f2489a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Lifecycle lifecycle, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = lifecycle;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super Boolean> producerScope, Continuation<? super Unit> continuation) {
            return ((f) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(this.c, continuation);
            fVar.b = obj;
            return fVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2488a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProducerScope producerScope = (ProducerScope) this.b;
                final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.S$f$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        S.f.a(producerScope, lifecycleOwner, event);
                    }
                };
                this.c.addObserver(lifecycleEventObserver);
                final Lifecycle lifecycle = this.c;
                Function0 function0 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.S$f$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return S.f.a(lifecycle, lifecycleEventObserver);
                    }
                };
                this.f2488a = 1;
                if (ProduceKt.awaitClose(producerScope, function0, this) == coroutine_suspended) {
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

        public static final void a(ProducerScope producerScope, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            int i = a.f2489a[event.ordinal()];
            if (i == 1) {
                ChannelResult.m8951boximpl(producerScope.mo7333trySendJP2dKIU(Boolean.FALSE));
            } else if (i != 2) {
                Unit unit = Unit.INSTANCE;
            } else {
                ChannelResult.m8951boximpl(producerScope.mo7333trySendJP2dKIU(Boolean.TRUE));
            }
        }

        public static final Unit a(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
            lifecycle.removeObserver(lifecycleEventObserver);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ViewVisibilityTrackerKt$isLifecycleResumedFlow$lifecycle$1", f = "ViewVisibilityTracker.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2490a;
        public /* synthetic */ Object b;

        public g(Continuation<? super g> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super Boolean> flowCollector, Continuation<? super Unit> continuation) {
            return ((g) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            g gVar = new g(continuation);
            gVar.b = obj;
            return gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2490a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.b;
                this.f2490a = 1;
                if (flowCollector.emit(null, this) == coroutine_suspended) {
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

    public static final Object d(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super Unit> continuation) {
        Object objCollectLatest = FlowKt.collectLatest(a(view), new a(producerScope, view, null), continuation);
        return objCollectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollectLatest : Unit.INSTANCE;
    }

    public static final Object e(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super Unit> continuation) {
        Object objCollectLatest = FlowKt.collectLatest(b(view), new b(producerScope, null), continuation);
        return objCollectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollectLatest : Unit.INSTANCE;
    }

    public static final Object f(ProducerScope<? super Boolean> producerScope, View view, Continuation<? super Unit> continuation) {
        Object objCollectLatest = FlowKt.collectLatest(a(ViewTreeLifecycleOwner.get(view)), new c(producerScope, view, null), continuation);
        return objCollectLatest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollectLatest : Unit.INSTANCE;
    }

    public static final Flow<Boolean> b(View view) {
        return b(FlowKt.flow(new e(view, null)));
    }

    public static final Flow<Boolean> a(View view) {
        return b(FlowKt.callbackFlow(new d(view, null)));
    }

    public static final <T> Flow<T> b(Flow<? extends T> flow) {
        return FlowKt.flowOn(FlowKt.distinctUntilChanged(FlowKt.conflate(flow)), com.moloco.sdk.internal.scheduling.b.a().getMain());
    }

    public static final Flow<Boolean> a(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            return b(FlowKt.callbackFlow(new f(lifecycle, null)));
        }
        return FlowKt.flow(new g(null));
    }
}
