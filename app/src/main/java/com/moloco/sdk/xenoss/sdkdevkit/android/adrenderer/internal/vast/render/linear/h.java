package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.r;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class h implements g {
    public static final int h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2977a;
    public C d;
    public Job e;
    public int f;
    public final String b = "LinearGoNextActionImpl";
    public final CoroutineScope c = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
    public final MutableStateFlow<d.a> g = StateFlowKt.MutableStateFlow(d.a.c.b);

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearGoNextActionImpl$startTimer$1", f = "LinearGoNextAction.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2978a;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.h$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.LinearGoNextActionImpl$startTimer$1$1", f = "LinearGoNextAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0515a extends SuspendLambda implements Function2<UInt, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2979a;
            public /* synthetic */ int b;
            public final /* synthetic */ h c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0515a(h hVar, Continuation<? super C0515a> continuation) {
                super(2, continuation);
                this.c = hVar;
            }

            public final Object a(int i, Continuation<? super Unit> continuation) {
                return ((C0515a) create(UInt.m7508boximpl(i), continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C0515a c0515a = new C0515a(this.c, continuation);
                c0515a.b = ((UInt) obj).getData();
                return c0515a;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(UInt uInt, Continuation<? super Unit> continuation) {
                return a(uInt.getData(), continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f2979a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                int i = this.b;
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, this.c.b, "Updating countdown to " + ((Object) UInt.m7560toStringimpl(i)), null, false, 12, null);
                this.c.f = i;
                MolocoLogger.info$default(molocoLogger, this.c.b, "Propagating state: " + i.b(i), null, false, 12, null);
                this.c.l().setValue(i.b(i));
                return Unit.INSTANCE;
            }
        }

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return h.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            StateFlow<UInt> stateFlowA;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2978a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (h.this.d == null) {
                    h.this.d = new C(h.this.f, h.this.c, null);
                } else {
                    C c = h.this.d;
                    if (c != null) {
                        c.a(h.this.f);
                    }
                }
                C c2 = h.this.d;
                if (c2 != null && (stateFlowA = c2.a()) != null) {
                    C0515a c0515a = new C0515a(h.this, null);
                    this.f2978a = 1;
                    if (FlowKt.collectLatest(stateFlowA, c0515a, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    public h(r rVar) {
        this.f2977a = rVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.g
    public void H() {
        l().setValue(d.a.c.b);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public MutableStateFlow<d.a> l() {
        return this.g;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.g
    public void pause() {
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.b, "Canceling timer", null, false, 12, null);
        Job job = this.e;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.g
    public void s() {
        if (Integer.compare(this.f ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE) > 0) {
            a(((long) this.f) & 4294967295L);
        }
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.g
    public void a(int i, int i2) {
        double d = (((double) i) / ((double) i2)) * ((double) 100);
        if (i >= i2) {
            l().setValue(d.a.C0513a.b);
            return;
        }
        if (this.f2977a == null) {
            l().setValue(d.a.c.b);
            return;
        }
        if (this.e == null) {
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.info$default(molocoLogger, this.b, "Starting timer", null, false, 12, null);
            r rVar = this.f2977a;
            if (rVar instanceof r.a) {
                MolocoLogger.info$default(molocoLogger, this.b, "Offset Percents detected", null, false, 12, null);
                a(((long) i.b(new IntRange((int) d, ((r.a) this.f2977a).a()), i2)) & 4294967295L);
            } else {
                if (rVar instanceof r.b) {
                    MolocoLogger.info$default(molocoLogger, this.b, "Offset Millis detected", null, false, 12, null);
                    a(i.b(((r.b) this.f2977a).a()));
                    return;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public final void a(long j) {
        if (i.b(this.e)) {
            this.f = UInt.m7514constructorimpl((int) j);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, this.b, "Start timer for duration: " + j + " seconds", null, false, 12, null);
            this.e = BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new a(null), 3, null);
        }
    }
}
