package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3026g {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g$a */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.CountdownFlowKt$countdownSecondsFlow$1", f = "CountdownFlow.kt", i = {0, 0, 1, 1, 2, 2}, l = {26, 29, 30}, m = "invokeSuspend", n = {"$this$flow", "secondsLeft", "$this$flow", "secondsLeft", "$this$flow", "secondsLeft"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    public static final class a extends SuspendLambda implements Function2<FlowCollector<? super UInt>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2526a;
        public int b;
        public /* synthetic */ Object c;
        public final /* synthetic */ int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Continuation<? super a> continuation) {
            super(2, continuation);
            this.d = i;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super UInt> flowCollector, Continuation<? super Unit> continuation) {
            return ((a) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.d, continuation);
            aVar.c = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0075 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0073 -> B:16:0x0049). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2e
                if (r1 == r4) goto L24
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L24
            L12:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1a:
                int r1 = r7.f2526a
                java.lang.Object r4 = r7.c
                kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.ResultKt.throwOnFailure(r8)
                goto L5f
            L24:
                int r1 = r7.f2526a
                java.lang.Object r4 = r7.c
                kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.ResultKt.throwOnFailure(r8)
                goto L49
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                java.lang.Object r8 = r7.c
                kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                int r1 = r7.d
                kotlin.UInt r5 = kotlin.UInt.m7508boximpl(r1)
                r7.c = r8
                r7.f2526a = r1
                r7.b = r4
                java.lang.Object r4 = r8.emit(r5, r7)
                if (r4 != r0) goto L48
                return r0
            L48:
                r4 = r8
            L49:
                r8 = 0
                int r8 = kotlin.UByte$$ExternalSyntheticBackport0.m(r1, r8)
                if (r8 <= 0) goto L76
                r7.c = r4
                r7.f2526a = r1
                r7.b = r3
                r5 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r7)
                if (r8 != r0) goto L5f
                return r0
            L5f:
                int r1 = r1 + (-1)
                int r1 = kotlin.UInt.m7514constructorimpl(r1)
                kotlin.UInt r8 = kotlin.UInt.m7508boximpl(r1)
                r7.c = r4
                r7.f2526a = r1
                r7.b = r2
                java.lang.Object r8 = r4.emit(r8, r7)
                if (r8 != r0) goto L49
                return r0
            L76:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3026g.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g$b */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.CountdownFlowKt$countdownSecondsStateFlow$1", f = "CountdownFlow.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<FlowCollector<? super UInt>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2527a;
        public /* synthetic */ Object b;
        public final /* synthetic */ Ref.IntRef c;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.g$b$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.IntRef f2528a;
            public final /* synthetic */ FlowCollector<UInt> b;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Ref.IntRef intRef, FlowCollector<? super UInt> flowCollector) {
                this.f2528a = intRef;
                this.b = flowCollector;
            }

            public final Object a(int i, Continuation<? super Unit> continuation) {
                this.f2528a.element = i;
                Object objEmit = this.b.emit(UInt.m7508boximpl(i), continuation);
                return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return a(((UInt) obj).getData(), continuation);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Ref.IntRef intRef, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = intRef;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super UInt> flowCollector, Continuation<? super Unit> continuation) {
            return ((b) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            b bVar = new b(this.c, continuation);
            bVar.b = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2527a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.b;
                Flow<UInt> flowA = C3026g.a(this.c.element);
                a aVar = new a(this.c, flowCollector);
                this.f2527a = 1;
                if (flowA.collect(aVar, this) == coroutine_suspended) {
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

    public static final Flow<UInt> a(int i) {
        return FlowKt.flow(new a(i, null));
    }

    public static final StateFlow<UInt> a(int i, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        return FlowKt.stateIn(FlowKt.flow(new b(intRef, null)), scope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), UInt.m7508boximpl(i));
    }
}
