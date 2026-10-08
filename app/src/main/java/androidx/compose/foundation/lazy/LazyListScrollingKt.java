package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.ui.unit.Dp;
import com.adxcorp.ads.mediation.common.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: LazyListScrolling.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0082\b\u001a%\u0010\u000b\u001a\u00020\u0007*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0005\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"BoundDistance", "Landroidx/compose/ui/unit/Dp;", "F", "DEBUG", "", "TargetDistance", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "doSmoothScrollToItem", "Landroidx/compose/foundation/lazy/LazyListState;", FirebaseAnalytics.Param.INDEX, "", "scrollOffset", "(Landroidx/compose/foundation/lazy/LazyListState;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyListScrollingKt {
    private static final boolean DEBUG = false;
    private static final float TargetDistance = Dp.m3887constructorimpl(2500);
    private static final float BoundDistance = Dp.m3887constructorimpl(1500);

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LazyListItemInfo doSmoothScrollToItem$getTargetItem(LazyListState lazyListState, int i) {
        LazyListItemInfo lazyListItemInfo;
        List<LazyListItemInfo> visibleItemsInfo = lazyListState.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                lazyListItemInfo = null;
                break;
            }
            lazyListItemInfo = visibleItemsInfo.get(i2);
            if (lazyListItemInfo.getIndex() == i) {
                break;
            }
            i2++;
        }
        return lazyListItemInfo;
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListScrollingKt$doSmoothScrollToItem$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListScrolling.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.LazyListScrollingKt$doSmoothScrollToItem$3", f = "LazyListScrolling.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {114, Constants.NEXT_STEP}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "forward"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "I$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        final /* synthetic */ LazyListState $this_doSmoothScrollToItem;
        float F$0;
        float F$1;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(LazyListState lazyListState, int i, int i2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$this_doSmoothScrollToItem = lazyListState;
            this.$index = i;
            this.$scrollOffset = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_doSmoothScrollToItem, this.$index, this.$scrollOffset, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:31:0x0102, B:30:0x0100], limit reached: 75 */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00ac A[Catch: ItemFoundInScroll -> 0x01c3, TryCatch #2 {ItemFoundInScroll -> 0x01c3, blocks: (B:50:0x01b8, B:21:0x00a8, B:23:0x00ac, B:25:0x00b8, B:27:0x00cb, B:28:0x00da, B:34:0x0108, B:38:0x0148, B:42:0x0151), top: B:72:0x01b8 }] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00cb A[Catch: ItemFoundInScroll -> 0x01c3, LOOP:0: B:26:0x00c9->B:27:0x00cb, LOOP_END, TryCatch #2 {ItemFoundInScroll -> 0x01c3, blocks: (B:50:0x01b8, B:21:0x00a8, B:23:0x00ac, B:25:0x00b8, B:27:0x00cb, B:28:0x00da, B:34:0x0108, B:38:0x0148, B:42:0x0151), top: B:72:0x01b8 }] */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0143  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0146  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x014c  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x014f  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x01ae A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x01af  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x020d  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0236 A[RETURN] */
        /* JADX WARN: Type inference failed for: r10v1, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Type inference failed for: r7v23, types: [T, androidx.compose.animation.core.AnimationState] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01af -> B:72:0x01b8). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r32) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 579
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListScrollingKt.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$isOvershot(boolean z, LazyListState lazyListState, int i, int i2) {
            if (z) {
                if (lazyListState.getFirstVisibleItemIndex() <= i && (lazyListState.getFirstVisibleItemIndex() != i || lazyListState.getFirstVisibleItemScrollOffset() <= i2)) {
                    return false;
                }
            } else if (lazyListState.getFirstVisibleItemIndex() >= i && (lazyListState.getFirstVisibleItemIndex() != i || lazyListState.getFirstVisibleItemScrollOffset() >= i2)) {
                return false;
            }
            return true;
        }
    }

    public static final Object doSmoothScrollToItem(LazyListState lazyListState, int i, int i2, Continuation<? super Unit> continuation) {
        if (i < 0.0f) {
            throw new IllegalArgumentException(("Index should be non-negative (" + i + ')').toString());
        }
        Object objScroll$default = ScrollableState.CC.scroll$default(lazyListState, null, new AnonymousClass3(lazyListState, i, i2, null), continuation, 1, null);
        return objScroll$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objScroll$default : Unit.INSTANCE;
    }
}
