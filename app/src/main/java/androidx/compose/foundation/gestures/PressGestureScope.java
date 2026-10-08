package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TapGestureDetector.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004ø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PressGestureScope extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.PressGestureScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: TapGestureDetector.kt */
    public final /* synthetic */ class CC {
    }

    /* JADX INFO: compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m298roundToPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m3849$default$roundToPxR2X_6o(pressGestureScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m299roundToPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m3850$default$roundToPx0680j_4(pressGestureScope, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m300toDpGaN1DYA(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m3851$default$toDpGaN1DYA(pressGestureScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m301toDpu2uoSUM(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m3852$default$toDpu2uoSUM(pressGestureScope, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m302toDpu2uoSUM(PressGestureScope pressGestureScope, int i) {
            return Density.CC.m3853$default$toDpu2uoSUM((Density) pressGestureScope, i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m303toDpSizekrfVVM(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m3854$default$toDpSizekrfVVM(pressGestureScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m304toPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m3855$default$toPxR2X_6o(pressGestureScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m305toPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m3856$default$toPx0680j_4(pressGestureScope, f);
        }

        @Deprecated
        public static Rect toRect(PressGestureScope pressGestureScope, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return Density.CC.$default$toRect(pressGestureScope, receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m306toSizeXkaWNTQ(PressGestureScope pressGestureScope, long j) {
            return Density.CC.m3857$default$toSizeXkaWNTQ(pressGestureScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m307toSp0xMU5do(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m3858$default$toSp0xMU5do(pressGestureScope, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m308toSpkPz2Gy4(PressGestureScope pressGestureScope, float f) {
            return Density.CC.m3859$default$toSpkPz2Gy4(pressGestureScope, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m309toSpkPz2Gy4(PressGestureScope pressGestureScope, int i) {
            return Density.CC.m3860$default$toSpkPz2Gy4((Density) pressGestureScope, i);
        }
    }
}
