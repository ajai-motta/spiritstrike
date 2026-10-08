package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Velocity;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001a!\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001aa\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t*\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00030\r2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00100\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aO\u0010\u0016\u001a\u00020\u000e*\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aô\u0001\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020 0\u0010¢\u0006\u0002\b!2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102>\b\u0002\u0010%\u001a8\b\u0001\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0&¢\u0006\u0002\b.2>\b\u0002\u0010/\u001a8\b\u0001\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(0\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0&¢\u0006\u0002\b.2\b\b\u0002\u0010\u001b\u001a\u00020\u000eH\u0000ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00101\u001aÏ\u0001\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0006\u00102\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2>\b\u0002\u0010%\u001a8\b\u0001\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0&¢\u0006\u0002\b.2>\b\u0002\u0010/\u001a8\b\u0001\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(0\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0&¢\u0006\u0002\b.2\b\b\u0002\u0010\u001b\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00103\u001a!\u00104\u001a\u00020\u0004*\u00020(2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\u001a!\u00104\u001a\u00020\u0004*\u0002072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00106\u001a\u001c\u00109\u001a\u00020(*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000¢\u0006\u0002\u0010:\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "awaitDownAndSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "canDrag", "Landroidx/compose/runtime/State;", "", "startDragImmediately", "Lkotlin/Function0;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", AdUnitActivity.EXTRA_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDrag", "dragStart", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/compose/foundation/gestures/DragEvent;", "reverseDirection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/Pair;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Lkotlinx/coroutines/channels/SendChannel;ZLandroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggable", "Landroidx/compose/ui/Modifier;", "stateFactory", "Landroidx/compose/foundation/gestures/PointerAwareDraggableState;", "Landroidx/compose/runtime/Composable;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "velocity", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "state", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "toOffset", "(FLandroidx/compose/foundation/gestures/Orientation;)J", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DraggableKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt", f = "Draggable.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 2, 3}, l = {315, 324, 333, 335}, m = "awaitDownAndSlop", n = {"$this$awaitDownAndSlop", "canDrag", "startDragImmediately", "velocityTracker", AdUnitActivity.EXTRA_ORIENTATION, "$this$awaitDownAndSlop", "velocityTracker", AdUnitActivity.EXTRA_ORIENTATION, "initialDelta", "initialDelta"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DraggableKt.awaitDownAndSlop(null, null, null, null, null, this);
        }
    }

    public static final DraggableState DraggableState(Function1<? super Float, Unit> onDelta) {
        Intrinsics.checkNotNullParameter(onDelta, "onDelta");
        return new DefaultDraggableState(onDelta);
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> onDelta, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(onDelta, "onDelta");
        composer.startReplaceableGroup(-183245213);
        ComposerKt.sourceInformation(composer, "C(rememberDraggableState)136@5769L29,137@5810L61:Draggable.kt#8bwon0");
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onDelta, composer, i & 14);
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = DraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$rememberDraggableState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                    invoke(f.floatValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(float f) {
                    stateRememberUpdatedState.getValue().invoke(Float.valueOf(f));
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DraggableState draggableState = (DraggableState) objRememberedValue;
        composer.endReplaceableGroup();
        return draggableState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$1", f = "Draggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C06221 extends SuspendLambda implements Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> {
        int label;

        C06221(Continuation<? super C06221> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Offset offset, Continuation<? super Unit> continuation) {
            return m281invoked4ec7I(coroutineScope, offset.getPackedValue(), continuation);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m281invoked4ec7I(CoroutineScope coroutineScope, long j, Continuation<? super Unit> continuation) {
            return new C06221(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$2, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$2", f = "Draggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
            return invoke(coroutineScope, f.floatValue(), continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public static final Modifier draggable(Modifier modifier, final DraggableState state, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, final boolean z2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean z3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        return draggable(modifier, new Function2<Composer, Integer, PointerAwareDraggableState>() { // from class: androidx.compose.foundation.gestures.DraggableKt.draggable.3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ PointerAwareDraggableState invoke(Composer composer, Integer num) {
                return invoke(composer, num.intValue());
            }

            public final PointerAwareDraggableState invoke(Composer composer, int i) {
                composer.startReplaceableGroup(830271906);
                ComposerKt.sourceInformation(composer, "C183@8441L54:Draggable.kt#8bwon0");
                DraggableState draggableState = state;
                composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean zChanged = composer.changed(draggableState);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new IgnorePointerDraggableState(draggableState);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                composer.endReplaceableGroup();
                return (IgnorePointerDraggableState) objRememberedValue;
            }
        }, new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableKt.draggable.4
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(PointerInputChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return true;
            }
        }, orientation, z, mutableInteractionSource, new Function0<Boolean>() { // from class: androidx.compose.foundation.gestures.DraggableKt.draggable.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(z2);
            }
        }, onDragStarted, onDragStopped, z3);
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$6, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$6", f = "Draggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Offset offset, Continuation<? super Unit> continuation) {
            return m282invoked4ec7I(coroutineScope, offset.getPackedValue(), continuation);
        }

        /* JADX INFO: renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m282invoked4ec7I(CoroutineScope coroutineScope, long j, Continuation<? super Unit> continuation) {
            return new AnonymousClass6(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$7, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$7", f = "Draggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
            return invoke(coroutineScope, f.floatValue(), continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
            return new AnonymousClass7(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean>> r10, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function0<java.lang.Boolean>> r11, androidx.compose.ui.input.pointer.util.VelocityTracker r12, androidx.compose.foundation.gestures.Orientation r13, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.ui.input.pointer.util.VelocityTracker, androidx.compose.foundation.gestures.Orientation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object awaitDrag(AwaitPointerEventScope awaitPointerEventScope, Pair<PointerInputChange, Float> pair, final VelocityTracker velocityTracker, final SendChannel<? super DragEvent> sendChannel, final boolean z, final Orientation orientation, Continuation<? super Boolean> continuation) {
        float fFloatValue = pair.getSecond().floatValue();
        PointerInputChange first = pair.getFirst();
        long jM1412minusMKHz9U = Offset.m1412minusMKHz9U(first.getPosition(), Offset.m1415timestuRUvjQ(toOffset(fFloatValue, orientation), Math.signum(m279toFloat3MmeM6k(first.getPosition(), orientation))));
        sendChannel.mo7333trySendJP2dKIU(new DragEvent.DragStarted(jM1412minusMKHz9U, null));
        if (z) {
            fFloatValue *= -1;
        }
        sendChannel.mo7333trySendJP2dKIU(new DragEvent.DragDelta(fFloatValue, jM1412minusMKHz9U, null));
        Function1<PointerInputChange, Unit> function1 = new Function1<PointerInputChange, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$awaitDrag$dragTick$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PointerInputChange pointerInputChange) {
                invoke2(pointerInputChange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PointerInputChange event) {
                Intrinsics.checkNotNullParameter(event, "event");
                VelocityTrackerKt.addPointerInputChange(velocityTracker, event);
                float fM279toFloat3MmeM6k = DraggableKt.m279toFloat3MmeM6k(PointerEventKt.positionChange(event), orientation);
                event.consume();
                SendChannel<DragEvent> sendChannel2 = sendChannel;
                if (z) {
                    fM279toFloat3MmeM6k *= -1;
                }
                sendChannel2.mo7333trySendJP2dKIU(new DragEvent.DragDelta(fM279toFloat3MmeM6k, event.getPosition(), null));
            }
        };
        if (orientation == Orientation.Vertical) {
            return DragGestureDetectorKt.m271verticalDragjO51t88(awaitPointerEventScope, first.getId(), function1, continuation);
        }
        return DragGestureDetectorKt.m268horizontalDragjO51t88(awaitPointerEventScope, first.getId(), function1, continuation);
    }

    private static final long toOffset(float f, Orientation orientation) {
        return orientation == Orientation.Vertical ? OffsetKt.Offset(0.0f, f) : OffsetKt.Offset(f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-3MmeM6k, reason: not valid java name */
    public static final float m279toFloat3MmeM6k(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m1409getYimpl(j) : Offset.m1408getXimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: toFloat-sF-c-tU, reason: not valid java name */
    public static final float m280toFloatsFctU(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m4113getYimpl(j) : Velocity.m4112getXimpl(j);
    }

    public static final Modifier draggable(Modifier modifier, final Function2<? super Composer, ? super Integer, ? extends PointerAwareDraggableState> stateFactory, final Function1<? super PointerInputChange, Boolean> canDrag, final Orientation orientation, final boolean z, final MutableInteractionSource mutableInteractionSource, final Function0<Boolean> startDragImmediately, final Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, final Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, final boolean z2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(stateFactory, "stateFactory");
        Intrinsics.checkNotNullParameter(canDrag, "canDrag");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(startDragImmediately, "startDragImmediately");
        Intrinsics.checkNotNullParameter(onDragStarted, "onDragStarted");
        Intrinsics.checkNotNullParameter(onDragStopped, "onDragStopped");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("draggable");
                inspectorInfo.getProperties().set("canDrag", canDrag);
                inspectorInfo.getProperties().set(AdUnitActivity.EXTRA_ORIENTATION, orientation);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("startDragImmediately", startDragImmediately);
                inspectorInfo.getProperties().set("onDragStarted", onDragStarted);
                inspectorInfo.getProperties().set("onDragStopped", onDragStopped);
                inspectorInfo.getProperties().set("stateFactory", stateFactory);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.gestures.DraggableKt.draggable.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(-1487259950);
                ComposerKt.sourceInformation(composer, "C218@9877L8,219@9915L57,220@9977L274,228@10270L61,229@10364L42,230@10430L29,231@10481L114,234@10600L1017:Draggable.kt#8bwon0");
                PointerAwareDraggableState pointerAwareDraggableStateInvoke = stateFactory.invoke(composer, 0);
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                final MutableState mutableState = (MutableState) objRememberedValue;
                MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource;
                EffectsKt.DisposableEffect(mutableInteractionSource2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.gestures.DraggableKt.draggable.9.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                        final MutableState<DragInteraction.Start> mutableState2 = mutableState;
                        final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                        return new DisposableEffectResult() { // from class: androidx.compose.foundation.gestures.DraggableKt$draggable$9$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                DragInteraction.Start start = (DragInteraction.Start) mutableState2.getValue();
                                if (start != null) {
                                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                    if (mutableInteractionSource5 != null) {
                                        mutableInteractionSource5.tryEmit(new DragInteraction.Cancel(start));
                                    }
                                    mutableState2.setValue(null);
                                }
                            }
                        };
                    }
                }, composer, 0);
                composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                Channel channel = (Channel) objRememberedValue2;
                State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(startDragImmediately, composer, 0);
                State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(canDrag, composer, 0);
                EffectsKt.LaunchedEffect(pointerAwareDraggableStateInvoke, new AnonymousClass2(channel, pointerAwareDraggableStateInvoke, SnapshotStateKt.rememberUpdatedState(new DragLogic(onDragStarted, onDragStopped, mutableState, mutableInteractionSource), composer, 0), null), composer, 0);
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput((Modifier) Modifier.INSTANCE, new Object[]{orientation, Boolean.valueOf(z), Boolean.valueOf(z2)}, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass3(z, stateRememberUpdatedState2, stateRememberUpdatedState, orientation, channel, z2, null));
                composer.endReplaceableGroup();
                return modifierPointerInput;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: invoke$lambda-2, reason: not valid java name */
            public static final DragLogic m284invoke$lambda2(State<DragLogic> state) {
                return state.getValue();
            }

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$3, reason: invalid class name */
            /* JADX INFO: compiled from: Draggable.kt */
            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3", f = "Draggable.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass3 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ State<Function1<PointerInputChange, Boolean>> $canDragState;
                final /* synthetic */ Channel<DragEvent> $channel;
                final /* synthetic */ boolean $enabled;
                final /* synthetic */ Orientation $orientation;
                final /* synthetic */ boolean $reverseDirection;
                final /* synthetic */ State<Function0<Boolean>> $startImmediatelyState;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass3(boolean z, State<? extends Function1<? super PointerInputChange, Boolean>> state, State<? extends Function0<Boolean>> state2, Orientation orientation, Channel<DragEvent> channel, boolean z2, Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                    this.$enabled = z;
                    this.$canDragState = state;
                    this.$startImmediatelyState = state2;
                    this.$orientation = orientation;
                    this.$channel = channel;
                    this.$reverseDirection = z2;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$enabled, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, continuation);
                    anonymousClass3.L$0 = obj;
                    return anonymousClass3;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1, reason: invalid class name */
                /* JADX INFO: compiled from: Draggable.kt */
                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1", f = "Draggable.kt", i = {0}, l = {265}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PointerInputScope $$this$pointerInput;
                    final /* synthetic */ State<Function1<PointerInputChange, Boolean>> $canDragState;
                    final /* synthetic */ Channel<DragEvent> $channel;
                    final /* synthetic */ Orientation $orientation;
                    final /* synthetic */ boolean $reverseDirection;
                    final /* synthetic */ State<Function0<Boolean>> $startImmediatelyState;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(PointerInputScope pointerInputScope, State<? extends Function1<? super PointerInputChange, Boolean>> state, State<? extends Function0<Boolean>> state2, Orientation orientation, Channel<DragEvent> channel, boolean z, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$$this$pointerInput = pointerInputScope;
                        this.$canDragState = state;
                        this.$startImmediatelyState = state2;
                        this.$orientation = orientation;
                        this.$channel = channel;
                        this.$reverseDirection = z;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$pointerInput, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: Draggable.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1", f = "Draggable.kt", i = {0, 0, 1, 1, 1}, l = {268, 276}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "velocityTracker", "$this$awaitPointerEventScope", "velocityTracker", "isDragSuccessful"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
                    static final class C00151 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ CoroutineScope $$this$coroutineScope;
                        final /* synthetic */ State<Function1<PointerInputChange, Boolean>> $canDragState;
                        final /* synthetic */ Channel<DragEvent> $channel;
                        final /* synthetic */ Orientation $orientation;
                        final /* synthetic */ boolean $reverseDirection;
                        final /* synthetic */ State<Function0<Boolean>> $startImmediatelyState;
                        int I$0;
                        private /* synthetic */ Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        boolean Z$0;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        C00151(CoroutineScope coroutineScope, State<? extends Function1<? super PointerInputChange, Boolean>> state, State<? extends Function0<Boolean>> state2, Orientation orientation, Channel<DragEvent> channel, boolean z, Continuation<? super C00151> continuation) {
                            super(2, continuation);
                            this.$$this$coroutineScope = coroutineScope;
                            this.$canDragState = state;
                            this.$startImmediatelyState = state2;
                            this.$orientation = orientation;
                            this.$channel = channel;
                            this.$reverseDirection = z;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            C00151 c00151 = new C00151(this.$$this$coroutineScope, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, continuation);
                            c00151.L$0 = obj;
                            return c00151;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                            return ((C00151) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Can't wrap try/catch for region: R(7:25|75|26|27|71|28|(1:30)(7:31|32|(0)(0)|40|54|17|(2:67|68)(0))) */
                        /* JADX WARN: Code restructure failed: missing block: B:41:0x00f4, code lost:
                        
                            r0 = th;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:43:0x00f6, code lost:
                        
                            r0 = e;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:47:0x00ff, code lost:
                        
                            r6 = r15;
                            r4 = r17;
                            r2 = r18;
                            r5 = r19;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:50:0x0110, code lost:
                        
                            r7 = r14;
                            r6 = r15;
                            r3 = r16;
                            r4 = r17;
                            r2 = r18;
                            r5 = r19;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:53:0x0120, code lost:
                        
                            r5.mo7333trySendJP2dKIU(androidx.compose.foundation.gestures.DragEvent.DragCancelled.INSTANCE);
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:55:0x012a, code lost:
                        
                            throw r0;
                         */
                        /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
                        /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
                        /* JADX WARN: Removed duplicated region for block: B:34:0x00d4  */
                        /* JADX WARN: Removed duplicated region for block: B:39:0x00eb  */
                        /* JADX WARN: Removed duplicated region for block: B:53:0x0120  */
                        /* JADX WARN: Removed duplicated region for block: B:55:0x012a A[Catch: all -> 0x012b, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x012b, blocks: (B:51:0x011a, B:55:0x012a), top: B:69:0x011a }] */
                        /* JADX WARN: Removed duplicated region for block: B:58:0x012e  */
                        /* JADX WARN: Removed duplicated region for block: B:63:0x0144  */
                        /* JADX WARN: Removed duplicated region for block: B:66:0x014d  */
                        /* JADX WARN: Removed duplicated region for block: B:67:0x0150  */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00c1 -> B:32:0x00cc). Please report as a decompilation issue!!! */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0120 -> B:54:0x0127). Please report as a decompilation issue!!! */
                        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:66:0x014d -> B:17:0x005c). Please report as a decompilation issue!!! */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
                            /*
                                Method dump skipped, instruction units count: 339
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.AnonymousClass9.AnonymousClass3.AnonymousClass1.C00151.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
                        /*
                            r13 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r13.label
                            r2 = 1
                            if (r1 == 0) goto L1d
                            if (r1 != r2) goto L15
                            java.lang.Object r0 = r13.L$0
                            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                            kotlin.ResultKt.throwOnFailure(r14)     // Catch: java.util.concurrent.CancellationException -> L13
                            goto L52
                        L13:
                            r14 = move-exception
                            goto L4c
                        L15:
                            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r14.<init>(r0)
                            throw r14
                        L1d:
                            kotlin.ResultKt.throwOnFailure(r14)
                            java.lang.Object r14 = r13.L$0
                            kotlinx.coroutines.CoroutineScope r14 = (kotlinx.coroutines.CoroutineScope) r14
                            androidx.compose.ui.input.pointer.PointerInputScope r1 = r13.$$this$pointerInput     // Catch: java.util.concurrent.CancellationException -> L48
                            androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1 r11 = new androidx.compose.foundation.gestures.DraggableKt$draggable$9$3$1$1     // Catch: java.util.concurrent.CancellationException -> L48
                            androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean>> r5 = r13.$canDragState     // Catch: java.util.concurrent.CancellationException -> L48
                            androidx.compose.runtime.State<kotlin.jvm.functions.Function0<java.lang.Boolean>> r6 = r13.$startImmediatelyState     // Catch: java.util.concurrent.CancellationException -> L48
                            androidx.compose.foundation.gestures.Orientation r7 = r13.$orientation     // Catch: java.util.concurrent.CancellationException -> L48
                            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.DragEvent> r8 = r13.$channel     // Catch: java.util.concurrent.CancellationException -> L48
                            boolean r9 = r13.$reverseDirection     // Catch: java.util.concurrent.CancellationException -> L48
                            r10 = 0
                            r3 = r11
                            r4 = r14
                            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L48
                            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch: java.util.concurrent.CancellationException -> L48
                            r3 = r13
                            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch: java.util.concurrent.CancellationException -> L48
                            r13.L$0 = r14     // Catch: java.util.concurrent.CancellationException -> L48
                            r13.label = r2     // Catch: java.util.concurrent.CancellationException -> L48
                            java.lang.Object r14 = r1.awaitPointerEventScope(r11, r3)     // Catch: java.util.concurrent.CancellationException -> L48
                            if (r14 != r0) goto L52
                            return r0
                        L48:
                            r0 = move-exception
                            r12 = r0
                            r0 = r14
                            r14 = r12
                        L4c:
                            boolean r0 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)
                            if (r0 == 0) goto L55
                        L52:
                            kotlin.Unit r14 = kotlin.Unit.INSTANCE
                            return r14
                        L55:
                            throw r14
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.AnonymousClass9.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                        if (!this.$enabled) {
                            return Unit.INSTANCE;
                        }
                        this.label = 1;
                        if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(pointerInputScope, this.$canDragState, this.$startImmediatelyState, this.$orientation, this.$channel, this.$reverseDirection, null), this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$2, reason: invalid class name */
            /* JADX INFO: compiled from: Draggable.kt */
            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$2", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {237, 239, 241, 251, 253, 257}, m = "invokeSuspend", n = {"$this$LaunchedEffect", "event", "$this$LaunchedEffect", "event", "$this$LaunchedEffect", "event", "$this$LaunchedEffect", "$this$LaunchedEffect", "$this$LaunchedEffect"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Channel<DragEvent> $channel;
                final /* synthetic */ State<DragLogic> $dragLogic$delegate;
                final /* synthetic */ PointerAwareDraggableState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(Channel<DragEvent> channel, PointerAwareDraggableState pointerAwareDraggableState, State<DragLogic> state, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$channel = channel;
                    this.$state = pointerAwareDraggableState;
                    this.$dragLogic$delegate = state;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$channel, this.$state, this.$dragLogic$delegate, continuation);
                    anonymousClass2.L$0 = obj;
                    return anonymousClass2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DraggableKt$draggable$9$2$2, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Draggable.kt */
                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableKt$draggable$9$2$2", f = "Draggable.kt", i = {0}, l = {246}, m = "invokeSuspend", n = {"$this$drag"}, s = {"L$0"})
                static final class C00142 extends SuspendLambda implements Function2<PointerAwareDragScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Channel<DragEvent> $channel;
                    final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00142(Ref.ObjectRef<DragEvent> objectRef, Channel<DragEvent> channel, Continuation<? super C00142> continuation) {
                        super(2, continuation);
                        this.$event = objectRef;
                        this.$channel = channel;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00142 c00142 = new C00142(this.$event, this.$channel, continuation);
                        c00142.L$0 = obj;
                        return c00142;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PointerAwareDragScope pointerAwareDragScope, Continuation<? super Unit> continuation) {
                        return ((C00142) create(pointerAwareDragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0061 -> B:22:0x0064). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
                        /*
                            r6 = this;
                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                            int r1 = r6.label
                            r2 = 1
                            if (r1 == 0) goto L1f
                            if (r1 != r2) goto L17
                            java.lang.Object r1 = r6.L$1
                            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                            java.lang.Object r3 = r6.L$0
                            androidx.compose.foundation.gestures.PointerAwareDragScope r3 = (androidx.compose.foundation.gestures.PointerAwareDragScope) r3
                            kotlin.ResultKt.throwOnFailure(r7)
                            goto L64
                        L17:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r0)
                            throw r7
                        L1f:
                            kotlin.ResultKt.throwOnFailure(r7)
                            java.lang.Object r7 = r6.L$0
                            androidx.compose.foundation.gestures.PointerAwareDragScope r7 = (androidx.compose.foundation.gestures.PointerAwareDragScope) r7
                            r3 = r7
                        L27:
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r7 = r6.$event
                            T r7 = r7.element
                            boolean r7 = r7 instanceof androidx.compose.foundation.gestures.DragEvent.DragStopped
                            if (r7 != 0) goto L67
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r7 = r6.$event
                            T r7 = r7.element
                            boolean r7 = r7 instanceof androidx.compose.foundation.gestures.DragEvent.DragCancelled
                            if (r7 != 0) goto L67
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r7 = r6.$event
                            T r7 = r7.element
                            boolean r1 = r7 instanceof androidx.compose.foundation.gestures.DragEvent.DragDelta
                            if (r1 == 0) goto L42
                            androidx.compose.foundation.gestures.DragEvent$DragDelta r7 = (androidx.compose.foundation.gestures.DragEvent.DragDelta) r7
                            goto L43
                        L42:
                            r7 = 0
                        L43:
                            if (r7 == 0) goto L50
                            float r1 = r7.getDelta()
                            long r4 = r7.getPointerPosition()
                            r3.mo285dragByUv8p0NA(r1, r4)
                        L50:
                            kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.foundation.gestures.DragEvent> r1 = r6.$event
                            kotlinx.coroutines.channels.Channel<androidx.compose.foundation.gestures.DragEvent> r7 = r6.$channel
                            r4 = r6
                            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                            r6.L$0 = r3
                            r6.L$1 = r1
                            r6.label = r2
                            java.lang.Object r7 = r7.receive(r4)
                            if (r7 != r0) goto L64
                            return r0
                        L64:
                            r1.element = r7
                            goto L27
                        L67:
                            kotlin.Unit r7 = kotlin.Unit.INSTANCE
                            return r7
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.AnonymousClass9.AnonymousClass2.C00142.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:57:0x00e0, code lost:
                
                    r1 = r3;
                 */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
                /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
                /* JADX WARN: Removed duplicated region for block: B:32:0x00c0 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x00cd A[Catch: CancellationException -> 0x0036, TryCatch #1 {CancellationException -> 0x0036, blocks: (B:30:0x00a3, B:33:0x00c1, B:35:0x00cd, B:40:0x00e3, B:42:0x00e9, B:12:0x0031), top: B:55:0x0031 }] */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00e3 A[Catch: CancellationException -> 0x0036, TryCatch #1 {CancellationException -> 0x0036, blocks: (B:30:0x00a3, B:33:0x00c1, B:35:0x00cd, B:40:0x00e3, B:42:0x00e9, B:12:0x0031), top: B:55:0x0031 }] */
                /* JADX WARN: Removed duplicated region for block: B:48:0x010d A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:49:0x010e  */
                /* JADX WARN: Removed duplicated region for block: B:50:0x0111  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00f7 -> B:18:0x005c). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x010b -> B:39:0x00e0). Please report as a decompilation issue!!! */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x010e -> B:18:0x005c). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 294
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.AnonymousClass9.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }
        });
    }
}
