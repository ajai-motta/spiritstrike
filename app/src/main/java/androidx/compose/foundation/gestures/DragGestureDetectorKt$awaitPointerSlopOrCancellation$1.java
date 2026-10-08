package androidx.compose.foundation.gestures;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: DragGestureDetector.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt", f = "DragGestureDetector.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {103, 132}, m = "awaitPointerSlopOrCancellation-gDDlDlE", n = {"$this$awaitPointerSlopOrCancellation_u2dgDDlDlE", "onPointerSlopReached", "pointer", TypedValues.CycleType.S_WAVE_OFFSET, "touchSlop", "$this$awaitPointerSlopOrCancellation_u2dgDDlDlE", "onPointerSlopReached", "pointer", "dragEvent", TypedValues.CycleType.S_WAVE_OFFSET, "touchSlop"}, s = {"L$0", "L$1", "L$2", "J$0", "F$0", "L$0", "L$1", "L$2", "L$3", "J$0", "F$0"})
final class DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 extends ContinuationImpl {
    float F$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    DragGestureDetectorKt$awaitPointerSlopOrCancellation$1(Continuation<? super DragGestureDetectorKt$awaitPointerSlopOrCancellation$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return DragGestureDetectorKt.m260awaitPointerSlopOrCancellationgDDlDlE(null, 0L, 0, null, this);
    }
}
