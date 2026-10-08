package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class C {
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f2441a;
    public final MutableStateFlow<StateFlow<UInt>> b;
    public final StateFlow<UInt> c;

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ResettableCountdownSecondsStateFlow$countdownSecondsStateFlow$1", f = "CountdownFlow.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<ProducerScope<? super UInt>, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2442a;
        public /* synthetic */ Object b;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ResettableCountdownSecondsStateFlow$countdownSecondsStateFlow$1$1", f = "CountdownFlow.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0416a extends SuspendLambda implements Function2<StateFlow<? extends UInt>, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2443a;
            public /* synthetic */ Object b;
            public final /* synthetic */ ProducerScope<UInt> c;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C$a$a$a, reason: collision with other inner class name */
            public static final class C0417a<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ProducerScope<UInt> f2444a;

                /* JADX WARN: Multi-variable type inference failed */
                public C0417a(ProducerScope<? super UInt> producerScope) {
                    this.f2444a = producerScope;
                }

                public final Object a(int i, Continuation<? super Unit> continuation) {
                    Object objSend = this.f2444a.send(UInt.m7508boximpl(i), continuation);
                    return objSend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSend : Unit.INSTANCE;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return a(((UInt) obj).getData(), continuation);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0416a(ProducerScope<? super UInt> producerScope, Continuation<? super C0416a> continuation) {
                super(2, continuation);
                this.c = producerScope;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(StateFlow<UInt> stateFlow, Continuation<? super Unit> continuation) {
                return ((C0416a) create(stateFlow, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C0416a c0416a = new C0416a(this.c, continuation);
                c0416a.b = obj;
                return c0416a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f2443a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow stateFlow = (StateFlow) this.b;
                    C0417a c0417a = new C0417a(this.c);
                    this.f2443a = 1;
                    if (stateFlow.collect(c0417a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(ProducerScope<? super UInt> producerScope, Continuation<? super Unit> continuation) {
            return ((a) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = C.this.new a(continuation);
            aVar.b = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2442a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope = (ProducerScope) this.b;
                MutableStateFlow mutableStateFlow = C.this.b;
                C0416a c0416a = new C0416a(producerScope, null);
                this.f2442a = 1;
                if (FlowKt.collectLatest(mutableStateFlow, c0416a, this) == coroutine_suspended) {
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

    public /* synthetic */ C(int i, CoroutineScope coroutineScope, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, coroutineScope);
    }

    public C(int i, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f2441a = scope;
        MutableStateFlow<StateFlow<UInt>> MutableStateFlow = StateFlowKt.MutableStateFlow(C3026g.a(i, scope));
        this.b = MutableStateFlow;
        this.c = FlowKt.stateIn(FlowKt.channelFlow(new a(null)), scope, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 0L, 0L, 3, null), MutableStateFlow.getValue().getValue());
    }

    public final void a(int i) {
        this.b.setValue(C3026g.a(i, this.f2441a));
    }

    public final StateFlow<UInt> a() {
        return this.c;
    }
}
