package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentDrawScope.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ContentDrawScope extends DrawScope {
    void drawContent();

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.drawscope.ContentDrawScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: ContentDrawScope.kt */
    public final /* synthetic */ class CC {
    }

    /* JADX INFO: compiled from: ContentDrawScope.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m2094drawImageAZ2fEMs(ContentDrawScope contentDrawScope, ImageBitmap image, long j, long j2, long j3, long j4, float f, DrawStyle style, ColorFilter colorFilter, int i, int i2) {
            Intrinsics.checkNotNullParameter(image, "image");
            Intrinsics.checkNotNullParameter(style, "style");
            DrawScope.CC.m2109$default$drawImageAZ2fEMs(contentDrawScope, image, j, j2, j3, j4, f, style, colorFilter, i, i2);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m2095getCenterF1C5BW0(ContentDrawScope contentDrawScope) {
            return DrawScope.CC.m2110$default$getCenterF1C5BW0(contentDrawScope);
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m2096getSizeNHjbRc(ContentDrawScope contentDrawScope) {
            return DrawScope.CC.m2111$default$getSizeNHjbRc(contentDrawScope);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m2097roundToPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m3849$default$roundToPxR2X_6o(contentDrawScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m2098roundToPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m3850$default$roundToPx0680j_4(contentDrawScope, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m2099toDpGaN1DYA(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m3851$default$toDpGaN1DYA(contentDrawScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2100toDpu2uoSUM(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m3852$default$toDpu2uoSUM(contentDrawScope, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m2101toDpu2uoSUM(ContentDrawScope contentDrawScope, int i) {
            return Density.CC.m3853$default$toDpu2uoSUM((Density) contentDrawScope, i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m2102toDpSizekrfVVM(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m3854$default$toDpSizekrfVVM(contentDrawScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m2103toPxR2X_6o(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m3855$default$toPxR2X_6o(contentDrawScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m2104toPx0680j_4(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m3856$default$toPx0680j_4(contentDrawScope, f);
        }

        @Deprecated
        public static Rect toRect(ContentDrawScope contentDrawScope, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return Density.CC.$default$toRect(contentDrawScope, receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m2105toSizeXkaWNTQ(ContentDrawScope contentDrawScope, long j) {
            return Density.CC.m3857$default$toSizeXkaWNTQ(contentDrawScope, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m2106toSp0xMU5do(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m3858$default$toSp0xMU5do(contentDrawScope, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2107toSpkPz2Gy4(ContentDrawScope contentDrawScope, float f) {
            return Density.CC.m3859$default$toSpkPz2Gy4(contentDrawScope, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m2108toSpkPz2Gy4(ContentDrawScope contentDrawScope, int i) {
            return Density.CC.m3860$default$toSpkPz2Gy4((Density) contentDrawScope, i);
        }
    }
}
