package androidx.compose.ui.graphics;

import android.graphics.PorterDuff;
import android.os.Build;
import kotlin.Metadata;

/* JADX INFO: compiled from: AndroidBlendMode.android.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AndroidBlendMode_androidKt {
    /* JADX INFO: renamed from: isSupported-s9anfk8, reason: not valid java name */
    public static final boolean m1499isSupporteds9anfk8(int i) {
        return Build.VERSION.SDK_INT >= 29 || BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1589getSrcOver0nO6VwU()) || m1501toPorterDuffModes9anfk8(i) != PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toPorterDuffMode-s9anfk8, reason: not valid java name */
    public static final PorterDuff.Mode m1501toPorterDuffModes9anfk8(int i) {
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1562getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1585getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1568getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1589getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1572getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1587getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1570getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1588getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1571getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1586getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1569getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1590getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1581getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1583getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1580getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1566getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1576getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1578getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    /* JADX INFO: renamed from: toAndroidBlendMode-s9anfk8, reason: not valid java name */
    public static final android.graphics.BlendMode m1500toAndroidBlendModes9anfk8(int i) {
        return BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1562getClear0nO6VwU()) ? android.graphics.BlendMode.CLEAR : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1585getSrc0nO6VwU()) ? android.graphics.BlendMode.SRC : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1568getDst0nO6VwU()) ? android.graphics.BlendMode.DST : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1589getSrcOver0nO6VwU()) ? android.graphics.BlendMode.SRC_OVER : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1572getDstOver0nO6VwU()) ? android.graphics.BlendMode.DST_OVER : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1587getSrcIn0nO6VwU()) ? android.graphics.BlendMode.SRC_IN : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1570getDstIn0nO6VwU()) ? android.graphics.BlendMode.DST_IN : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1588getSrcOut0nO6VwU()) ? android.graphics.BlendMode.SRC_OUT : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1571getDstOut0nO6VwU()) ? android.graphics.BlendMode.DST_OUT : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1586getSrcAtop0nO6VwU()) ? android.graphics.BlendMode.SRC_ATOP : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1569getDstAtop0nO6VwU()) ? android.graphics.BlendMode.DST_ATOP : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1590getXor0nO6VwU()) ? android.graphics.BlendMode.XOR : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1581getPlus0nO6VwU()) ? android.graphics.BlendMode.PLUS : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1578getModulate0nO6VwU()) ? android.graphics.BlendMode.MODULATE : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1583getScreen0nO6VwU()) ? android.graphics.BlendMode.SCREEN : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1580getOverlay0nO6VwU()) ? android.graphics.BlendMode.OVERLAY : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1566getDarken0nO6VwU()) ? android.graphics.BlendMode.DARKEN : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1576getLighten0nO6VwU()) ? android.graphics.BlendMode.LIGHTEN : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1565getColorDodge0nO6VwU()) ? android.graphics.BlendMode.COLOR_DODGE : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1564getColorBurn0nO6VwU()) ? android.graphics.BlendMode.COLOR_BURN : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1574getHardlight0nO6VwU()) ? android.graphics.BlendMode.HARD_LIGHT : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1584getSoftlight0nO6VwU()) ? android.graphics.BlendMode.SOFT_LIGHT : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1567getDifference0nO6VwU()) ? android.graphics.BlendMode.DIFFERENCE : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1573getExclusion0nO6VwU()) ? android.graphics.BlendMode.EXCLUSION : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1579getMultiply0nO6VwU()) ? android.graphics.BlendMode.MULTIPLY : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1575getHue0nO6VwU()) ? android.graphics.BlendMode.HUE : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1582getSaturation0nO6VwU()) ? android.graphics.BlendMode.SATURATION : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1563getColor0nO6VwU()) ? android.graphics.BlendMode.COLOR : BlendMode.m1558equalsimpl0(i, BlendMode.INSTANCE.m1577getLuminosity0nO6VwU()) ? android.graphics.BlendMode.LUMINOSITY : android.graphics.BlendMode.SRC_OVER;
    }
}
