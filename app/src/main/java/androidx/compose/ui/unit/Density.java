package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: Density.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0013\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0013\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0015J\f\u0010!\u001a\u00020\"*\u00020#H\u0017J\u0019\u0010$\u001a\u00020\u001b*\u00020\u001aH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u001dJ\u0019\u0010&\u001a\u00020\u0010*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\u0003H\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b)\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\fH\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007ø\u0001\u0003\u0082\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006+À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "fontScale", "getFontScale$annotations", "getFontScale", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Density {
    float getDensity();

    float getFontScale();

    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    int mo310roundToPxR2X_6o(long j);

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    int mo311roundToPx0680j_4(float f);

    /* JADX INFO: renamed from: toDp-GaN1DYA */
    float mo312toDpGaN1DYA(long j);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo313toDpu2uoSUM(float f);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo314toDpu2uoSUM(int i);

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    long mo315toDpSizekrfVVM(long j);

    /* JADX INFO: renamed from: toPx--R2X_6o */
    float mo316toPxR2X_6o(long j);

    /* JADX INFO: renamed from: toPx-0680j_4 */
    float mo317toPx0680j_4(float f);

    Rect toRect(DpRect dpRect);

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    long mo318toSizeXkaWNTQ(long j);

    /* JADX INFO: renamed from: toSp-0xMU5do */
    long mo319toSp0xMU5do(float f);

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo320toSpkPz2Gy4(float f);

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo321toSpkPz2Gy4(int i);

    /* JADX INFO: renamed from: androidx.compose.ui.unit.Density$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: Density.kt */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$toPx-0680j_4, reason: not valid java name */
        public static float m3856$default$toPx0680j_4(Density _this, float f) {
            return f * _this.getDensity();
        }

        /* JADX INFO: renamed from: $default$roundToPx-0680j_4, reason: not valid java name */
        public static int m3850$default$roundToPx0680j_4(Density _this, float f) {
            float fMo317toPx0680j_4 = _this.mo317toPx0680j_4(f);
            if (Float.isInfinite(fMo317toPx0680j_4)) {
                return Integer.MAX_VALUE;
            }
            return MathKt.roundToInt(fMo317toPx0680j_4);
        }

        /* JADX INFO: renamed from: $default$toSp-0xMU5do, reason: not valid java name */
        public static long m3858$default$toSp0xMU5do(Density _this, float f) {
            return TextUnitKt.getSp(f / _this.getFontScale());
        }

        /* JADX INFO: renamed from: $default$toPx--R2X_6o, reason: not valid java name */
        public static float m3855$default$toPxR2X_6o(Density _this, long j) {
            if (!TextUnitType.m4096equalsimpl0(TextUnit.m4067getTypeUIouoOA(j), TextUnitType.INSTANCE.m4101getSpUIouoOA())) {
                throw new IllegalStateException("Only Sp can convert to Px".toString());
            }
            return TextUnit.m4068getValueimpl(j) * _this.getFontScale() * _this.getDensity();
        }

        /* JADX INFO: renamed from: $default$roundToPx--R2X_6o, reason: not valid java name */
        public static int m3849$default$roundToPxR2X_6o(Density _this, long j) {
            return MathKt.roundToInt(_this.mo316toPxR2X_6o(j));
        }

        /* JADX INFO: renamed from: $default$toDp-GaN1DYA, reason: not valid java name */
        public static float m3851$default$toDpGaN1DYA(Density _this, long j) {
            if (!TextUnitType.m4096equalsimpl0(TextUnit.m4067getTypeUIouoOA(j), TextUnitType.INSTANCE.m4101getSpUIouoOA())) {
                throw new IllegalStateException("Only Sp can convert to Px".toString());
            }
            return Dp.m3887constructorimpl(TextUnit.m4068getValueimpl(j) * _this.getFontScale());
        }

        /* JADX INFO: renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m3853$default$toDpu2uoSUM(Density _this, int i) {
            return Dp.m3887constructorimpl(i / _this.getDensity());
        }

        /* JADX INFO: renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m3860$default$toSpkPz2Gy4(Density _this, int i) {
            return TextUnitKt.getSp(i / (_this.getFontScale() * _this.getDensity()));
        }

        /* JADX INFO: renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m3852$default$toDpu2uoSUM(Density _this, float f) {
            return Dp.m3887constructorimpl(f / _this.getDensity());
        }

        /* JADX INFO: renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m3859$default$toSpkPz2Gy4(Density _this, float f) {
            return TextUnitKt.getSp(f / (_this.getFontScale() * _this.getDensity()));
        }

        public static Rect $default$toRect(Density _this, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(dpRect, "<this>");
            return new Rect(_this.mo317toPx0680j_4(dpRect.m3970getLeftD9Ej5fM()), _this.mo317toPx0680j_4(dpRect.m3972getTopD9Ej5fM()), _this.mo317toPx0680j_4(dpRect.m3971getRightD9Ej5fM()), _this.mo317toPx0680j_4(dpRect.m3969getBottomD9Ej5fM()));
        }

        /* JADX INFO: renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m3857$default$toSizeXkaWNTQ(Density _this, long j) {
            if (j != DpSize.INSTANCE.m3994getUnspecifiedMYxV2XQ()) {
                return SizeKt.Size(_this.mo317toPx0680j_4(DpSize.m3985getWidthD9Ej5fM(j)), _this.mo317toPx0680j_4(DpSize.m3983getHeightD9Ej5fM(j)));
            }
            return Size.INSTANCE.m1485getUnspecifiedNHjbRc();
        }

        /* JADX INFO: renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3854$default$toDpSizekrfVVM(Density _this, long j) {
            if (j != Size.INSTANCE.m1485getUnspecifiedNHjbRc()) {
                return DpKt.m3909DpSizeYgX7TsA(_this.mo313toDpu2uoSUM(Size.m1477getWidthimpl(j)), _this.mo313toDpu2uoSUM(Size.m1474getHeightimpl(j)));
            }
            return DpSize.INSTANCE.m3994getUnspecifiedMYxV2XQ();
        }
    }

    /* JADX INFO: compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m3880toPx0680j_4(Density density, float f) {
            return CC.m3856$default$toPx0680j_4(density, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m3874roundToPx0680j_4(Density density, float f) {
            return CC.m3850$default$roundToPx0680j_4(density, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m3882toSp0xMU5do(Density density, float f) {
            return CC.m3858$default$toSp0xMU5do(density, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m3879toPxR2X_6o(Density density, long j) {
            return CC.m3855$default$toPxR2X_6o(density, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m3873roundToPxR2X_6o(Density density, long j) {
            return CC.m3849$default$roundToPxR2X_6o(density, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m3875toDpGaN1DYA(Density density, long j) {
            return CC.m3851$default$toDpGaN1DYA(density, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3877toDpu2uoSUM(Density density, int i) {
            return CC.m3853$default$toDpu2uoSUM(density, i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3884toSpkPz2Gy4(Density density, int i) {
            return CC.m3860$default$toSpkPz2Gy4(density, i);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m3876toDpu2uoSUM(Density density, float f) {
            return CC.m3852$default$toDpu2uoSUM(density, f);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m3883toSpkPz2Gy4(Density density, float f) {
            return CC.m3859$default$toSpkPz2Gy4(density, f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect receiver) {
            Intrinsics.checkNotNullParameter(receiver, "receiver");
            return CC.$default$toRect(density, receiver);
        }

        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m3881toSizeXkaWNTQ(Density density, long j) {
            return CC.m3857$default$toSizeXkaWNTQ(density, j);
        }

        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m3878toDpSizekrfVVM(Density density, long j) {
            return CC.m3854$default$toDpSizekrfVVM(density, j);
        }
    }
}
