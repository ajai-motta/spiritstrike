package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.DecayAnimationSpec;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u0004*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/gestures/DefaultFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "performFling", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialVelocity", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DefaultFlingBehavior implements FlingBehavior {
    private final DecayAnimationSpec<Float> flingDecay;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior", f = "Scrollable.kt", i = {0}, l = {496}, m = "performFling", n = {"velocityLeft"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DefaultFlingBehavior.this.performFling(null, 0.0f, this);
        }
    }

    public DefaultFlingBehavior(DecayAnimationSpec<Float> flingDecay) {
        Intrinsics.checkNotNullParameter(flingDecay, "flingDecay");
        this.flingDecay = flingDecay;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object performFling(final androidx.compose.foundation.gestures.ScrollScope r18, float r19, kotlin.coroutines.Continuation<? super java.lang.Float> r20) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof androidx.compose.foundation.gestures.DefaultFlingBehavior.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r1
            androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$1 r2 = (androidx.compose.foundation.gestures.DefaultFlingBehavior.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$1 r2 = new androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$1
            r2.<init>(r1)
        L1d:
            r7 = r2
            java.lang.Object r1 = r7.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r7.label
            r4 = 1
            if (r3 == 0) goto L3b
            if (r3 != r4) goto L33
            java.lang.Object r2 = r7.L$0
            kotlin.jvm.internal.Ref$FloatRef r2 = (kotlin.jvm.internal.Ref.FloatRef) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L84
        L33:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3b:
            kotlin.ResultKt.throwOnFailure(r1)
            float r1 = java.lang.Math.abs(r19)
            r3 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L87
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r3 = r19
            r1.element = r3
            kotlin.jvm.internal.Ref$FloatRef r5 = new kotlin.jvm.internal.Ref$FloatRef
            r5.<init>()
            r15 = 28
            r16 = 0
            r8 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r9 = r19
            androidx.compose.animation.core.AnimationState r3 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r8, r9, r10, r12, r14, r15, r16)
            androidx.compose.animation.core.DecayAnimationSpec<java.lang.Float> r6 = r0.flingDecay
            androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2 r8 = new androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2
            r9 = r18
            r8.<init>()
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r7.L$0 = r1
            r7.label = r4
            r5 = 0
            r9 = 2
            r10 = 0
            r4 = r6
            r6 = r8
            r8 = r9
            r9 = r10
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateDecay$default(r3, r4, r5, r6, r7, r8, r9)
            if (r3 != r2) goto L83
            return r2
        L83:
            r2 = r1
        L84:
            float r1 = r2.element
            goto L8a
        L87:
            r3 = r19
            r1 = r3
        L8a:
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DefaultFlingBehavior.performFling(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
