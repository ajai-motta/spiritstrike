package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u0006\u0010+\u001a\u00020\u0005J1\u0010,\u001a\u00020'*\u00020-2\u0006\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u00010'2\u0006\u00100\u001a\u000201ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020'*\u00020'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u0010*J\n\u00104\u001a\u00020$*\u00020$J\u0017\u00106\u001a\u00020$*\u00020'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J\u0017\u00106\u001a\u00020$*\u00020\u001dø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u00108J\u001a\u0010:\u001a\u00020'*\u00020$ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b;\u0010<J\u001a\u0010=\u001a\u00020\u001d*\u00020$ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b>\u0010<J\u001f\u0010?\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010@\u001a\u00020$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u0010BR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006C"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", AdUnitActivity.EXTRA_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/OverscrollEffect;)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "getNestedScrollDispatcher", "()Landroidx/compose/runtime/State;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverscrollEffect", "()Landroidx/compose/foundation/OverscrollEffect;", "getReverseDirection", "()Z", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "axisVelocity", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "shouldScrollImmediately", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollDelta", "pointerPosition", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-f0eR0lY", "(Landroidx/compose/foundation/gestures/ScrollScope;JLandroidx/compose/ui/geometry/Offset;I)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "update", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ScrollingLogic {
    private final FlingBehavior flingBehavior;
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;
    private final Orientation orientation;
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic", f = "Scrollable.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {378, 383, 385, 387, 393}, m = "onDragStopped", n = {"this", "axisVelocity", "this", "velocity", "this", "available", "this", "velocityLeft"}, s = {"L$0", "F$0", "L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScrollingLogic.this.onDragStopped(0.0f, this);
        }
    }

    public ScrollingLogic(Orientation orientation, boolean z, State<NestedScrollDispatcher> nestedScrollDispatcher, ScrollableState scrollableState, FlingBehavior flingBehavior, OverscrollEffect overscrollEffect) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior, "flingBehavior");
        this.orientation = orientation;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.overscrollEffect = overscrollEffect;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m332toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.INSTANCE.m1424getZeroF1C5BW0();
        }
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m333toVelocityadjELrA(float f) {
        return this.orientation == Orientation.Horizontal ? VelocityKt.Velocity(f, 0.0f) : VelocityKt.Velocity(0.0f, f);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m331toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1408getXimpl(j) : Offset.m1409getYimpl(j);
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m330toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4112getXimpl(j) : Velocity.m4113getYimpl(j);
    }

    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m334updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4108copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m4108copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m329reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m1415timestuRUvjQ(j, -1.0f) : j;
    }

    /* JADX INFO: renamed from: dispatchScroll-f0eR0lY, reason: not valid java name */
    public final long m326dispatchScrollf0eR0lY(ScrollScope dispatchScroll, long j, Offset offset, int i) {
        long jM1424getZeroF1C5BW0;
        Intrinsics.checkNotNullParameter(dispatchScroll, "$this$dispatchScroll");
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (overscrollEffect != null && overscrollEffect.isEnabled()) {
            jM1424getZeroF1C5BW0 = this.overscrollEffect.mo170consumePreScrollA0NYTsA(j, offset, i);
        } else {
            jM1424getZeroF1C5BW0 = Offset.INSTANCE.m1424getZeroF1C5BW0();
        }
        long jM1412minusMKHz9U = Offset.m1412minusMKHz9U(j, jM1424getZeroF1C5BW0);
        NestedScrollDispatcher value = this.nestedScrollDispatcher.getValue();
        long jM1412minusMKHz9U2 = Offset.m1412minusMKHz9U(jM1412minusMKHz9U, value.m2915dispatchPreScrollOzD1aCk(jM1412minusMKHz9U, i));
        long jM329reverseIfNeededMKHz9U = m329reverseIfNeededMKHz9U(m332toOffsettuRUvjQ(dispatchScroll.scrollBy(m331toFloatk4lQ0M(m329reverseIfNeededMKHz9U(jM1412minusMKHz9U2)))));
        long jM1412minusMKHz9U3 = Offset.m1412minusMKHz9U(jM1412minusMKHz9U2, jM329reverseIfNeededMKHz9U);
        long jM2913dispatchPostScrollDzOQY0M = value.m2913dispatchPostScrollDzOQY0M(jM329reverseIfNeededMKHz9U, jM1412minusMKHz9U3, i);
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (overscrollEffect2 != null && overscrollEffect2.isEnabled()) {
            this.overscrollEffect.mo168consumePostScrolll7mfB5k(jM1412minusMKHz9U2, Offset.m1412minusMKHz9U(jM1412minusMKHz9U3, jM2913dispatchPostScrollDzOQY0M), offset, i);
        }
        return jM1412minusMKHz9U3;
    }

    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m328performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m1424getZeroF1C5BW0();
        }
        return m332toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m331toFloatk4lQ0M(scroll)))));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object onDragStopped(float r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.onDragStopped(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m327doFlingAnimationQWom1Mo(long r12, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L14
            r0 = r14
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r11, r14)
        L19:
            r4 = r0
            java.lang.Object r14 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r12 = r4.L$0
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            kotlin.ResultKt.throwOnFailure(r14)
            goto L5e
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L37:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r12
            androidx.compose.foundation.gestures.ScrollableState r1 = r11.scrollableState
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r3 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r3
            r6 = r11
            r7 = r14
            r8 = r12
            r5.<init>(r6, r7, r8, r10)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4.L$0 = r14
            r4.label = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r12 = androidx.compose.foundation.gestures.ScrollableState.CC.scroll$default(r1, r2, r3, r4, r5, r6)
            if (r12 != r0) goto L5d
            return r0
        L5d:
            r12 = r14
        L5e:
            long r12 = r12.element
            androidx.compose.ui.unit.Velocity r12 = androidx.compose.ui.unit.Velocity.m4103boximpl(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m327doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        OverscrollEffect overscrollEffect;
        return this.scrollableState.isScrollInProgress() || ((overscrollEffect = this.overscrollEffect) != null && overscrollEffect.isInProgress());
    }
}
