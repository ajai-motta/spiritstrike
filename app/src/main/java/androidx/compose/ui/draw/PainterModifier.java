package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PainterModifier.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BX\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0017\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\b\u0014¢\u0006\u0002\u0010\u0015J\u001d\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0002J\b\u0010,\u001a\u00020-H\u0016J\u001d\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010(J\b\u00102\u001a\u000203H\u0016J\f\u00104\u001a\u00020\u0013*\u000205H\u0016J\u0019\u00106\u001a\u00020\u0007*\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u00108J\u0019\u00109\u001a\u00020\u0007*\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u00108J\u001c\u0010;\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0016J\u001c\u0010@\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020-H\u0016J)\u0010B\u001a\u00020C*\u00020D2\u0006\u0010=\u001a\u00020E2\u0006\u00100\u001a\u00020/H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010GJ\u001c\u0010H\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020-H\u0016J\u001c\u0010I\u001a\u00020-*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010A\u001a\u00020-H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"Landroidx/compose/ui/draw/PainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;Lkotlin/jvm/functions/Function1;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getAlpha", "()F", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "getSizeToIntrinsics", "()Z", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "equals", "other", "", "hashCode", "", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", InAppPurchaseConstants.METHOD_TO_STRING, "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicWidth", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class PainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;
    private final boolean sizeToIntrinsics;

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(Function1 function1) {
        return Modifier.Element.CC.$default$all(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(Function1 function1) {
        return Modifier.Element.CC.$default$any(this, function1);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldIn(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return Modifier.Element.CC.$default$foldOut(this, obj, function2);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return Modifier.CC.$default$then(this, modifier);
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public /* synthetic */ PainterModifier(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter, function1);
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PainterModifier(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(painter, "painter");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.getIntrinsicSize() != Size.INSTANCE.m1485getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable placeableMo3152measureBRTryo0 = measurable.mo3152measureBRTryo0(m1335modifyConstraintsZezNO4M(j));
        return MeasureScope.CC.layout$default(measure, placeableMo3152measureBRTryo0.getWidth(), placeableMo3152measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterModifier$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope layout) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Placeable.PlacementScope.placeRelative$default(layout, placeableMo3152measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long jM1335modifyConstraintsZezNO4M = m1335modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m3833getMinWidthimpl(jM1335modifyConstraintsZezNO4M), measurable.minIntrinsicWidth(i));
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long jM1335modifyConstraintsZezNO4M = m1335modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m3833getMinWidthimpl(jM1335modifyConstraintsZezNO4M), measurable.maxIntrinsicWidth(i));
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long jM1335modifyConstraintsZezNO4M = m1335modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m3832getMinHeightimpl(jM1335modifyConstraintsZezNO4M), measurable.minIntrinsicHeight(i));
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (getUseIntrinsicSize()) {
            long jM1335modifyConstraintsZezNO4M = m1335modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m3832getMinHeightimpl(jM1335modifyConstraintsZezNO4M), measurable.maxIntrinsicHeight(i));
        }
        return measurable.maxIntrinsicHeight(i);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m1332calculateScaledSizeE7KxVPU(long dstSize) {
        float fM1477getWidthimpl;
        float fM1474getHeightimpl;
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        if (!m1334hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize())) {
            fM1477getWidthimpl = Size.m1477getWidthimpl(dstSize);
        } else {
            fM1477getWidthimpl = Size.m1477getWidthimpl(this.painter.getIntrinsicSize());
        }
        if (!m1333hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize())) {
            fM1474getHeightimpl = Size.m1474getHeightimpl(dstSize);
        } else {
            fM1474getHeightimpl = Size.m1474getHeightimpl(this.painter.getIntrinsicSize());
        }
        long jSize = SizeKt.Size(fM1477getWidthimpl, fM1474getHeightimpl);
        if (Size.m1477getWidthimpl(dstSize) != 0.0f && Size.m1474getHeightimpl(dstSize) != 0.0f) {
            return ScaleFactorKt.m3228timesUQTWf7w(jSize, this.contentScale.mo3143computeScaleFactorH7hwNQA(jSize, dstSize));
        }
        return Size.INSTANCE.m1486getZeroNHjbRc();
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m1335modifyConstraintsZezNO4M(long constraints) {
        int iM3833getMinWidthimpl;
        int iM3832getMinHeightimpl;
        boolean z = Constraints.m3827getHasBoundedWidthimpl(constraints) && Constraints.m3826getHasBoundedHeightimpl(constraints);
        boolean z2 = Constraints.m3829getHasFixedWidthimpl(constraints) && Constraints.m3828getHasFixedHeightimpl(constraints);
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.m3822copyZbe2FdA$default(constraints, Constraints.m3831getMaxWidthimpl(constraints), 0, Constraints.m3830getMaxHeightimpl(constraints), 0, 10, null);
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (m1334hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            iM3833getMinWidthimpl = MathKt.roundToInt(Size.m1477getWidthimpl(intrinsicSize));
        } else {
            iM3833getMinWidthimpl = Constraints.m3833getMinWidthimpl(constraints);
        }
        if (m1333hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            iM3832getMinHeightimpl = MathKt.roundToInt(Size.m1474getHeightimpl(intrinsicSize));
        } else {
            iM3832getMinHeightimpl = Constraints.m3832getMinHeightimpl(constraints);
        }
        long jM1332calculateScaledSizeE7KxVPU = m1332calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m3845constrainWidthK40F9xA(constraints, iM3833getMinWidthimpl), ConstraintsKt.m3844constrainHeightK40F9xA(constraints, iM3832getMinHeightimpl)));
        return Constraints.m3822copyZbe2FdA$default(constraints, ConstraintsKt.m3845constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m1477getWidthimpl(jM1332calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m3844constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m1474getHeightimpl(jM1332calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        float fM1477getWidthimpl;
        float fM1474getHeightimpl;
        long jM1486getZeroNHjbRc;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (m1334hasSpecifiedAndFiniteWidthuvyYCjk(intrinsicSize)) {
            fM1477getWidthimpl = Size.m1477getWidthimpl(intrinsicSize);
        } else {
            fM1477getWidthimpl = Size.m1477getWidthimpl(contentDrawScope.mo2064getSizeNHjbRc());
        }
        if (m1333hasSpecifiedAndFiniteHeightuvyYCjk(intrinsicSize)) {
            fM1474getHeightimpl = Size.m1474getHeightimpl(intrinsicSize);
        } else {
            fM1474getHeightimpl = Size.m1474getHeightimpl(contentDrawScope.mo2064getSizeNHjbRc());
        }
        long jSize = SizeKt.Size(fM1477getWidthimpl, fM1474getHeightimpl);
        if (Size.m1477getWidthimpl(contentDrawScope.mo2064getSizeNHjbRc()) != 0.0f && Size.m1474getHeightimpl(contentDrawScope.mo2064getSizeNHjbRc()) != 0.0f) {
            jM1486getZeroNHjbRc = ScaleFactorKt.m3228timesUQTWf7w(jSize, this.contentScale.mo3143computeScaleFactorH7hwNQA(jSize, contentDrawScope.mo2064getSizeNHjbRc()));
        } else {
            jM1486getZeroNHjbRc = Size.INSTANCE.m1486getZeroNHjbRc();
        }
        long j = jM1486getZeroNHjbRc;
        long jMo1316alignKFBX0sM = this.alignment.mo1316alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m1477getWidthimpl(j)), MathKt.roundToInt(Size.m1474getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m1477getWidthimpl(contentDrawScope.mo2064getSizeNHjbRc())), MathKt.roundToInt(Size.m1474getHeightimpl(contentDrawScope.mo2064getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float fM4005getXimpl = IntOffset.m4005getXimpl(jMo1316alignKFBX0sM);
        float fM4006getYimpl = IntOffset.m4006getYimpl(jMo1316alignKFBX0sM);
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        contentDrawScope2.getDrawContext().getTransform().translate(fM4005getXimpl, fM4006getYimpl);
        this.painter.m2222drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
        contentDrawScope2.getDrawContext().getTransform().translate(-fM4005getXimpl, -fM4006getYimpl);
        contentDrawScope.drawContent();
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m1334hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (!Size.m1473equalsimpl0(j, Size.INSTANCE.m1485getUnspecifiedNHjbRc())) {
            float fM1477getWidthimpl = Size.m1477getWidthimpl(j);
            if (!Float.isInfinite(fM1477getWidthimpl) && !Float.isNaN(fM1477getWidthimpl)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m1333hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (!Size.m1473equalsimpl0(j, Size.INSTANCE.m1485getUnspecifiedNHjbRc())) {
            float fM1474getHeightimpl = Size.m1474getHeightimpl(j);
            if (!Float.isInfinite(fM1474getHeightimpl) && !Float.isNaN(fM1474getHeightimpl)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.painter.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.sizeToIntrinsics)) * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.floatToIntBits(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return iHashCode + (colorFilter != null ? colorFilter.hashCode() : 0);
    }

    public boolean equals(Object other) {
        PainterModifier painterModifier = other instanceof PainterModifier ? (PainterModifier) other : null;
        return painterModifier != null && Intrinsics.areEqual(this.painter, painterModifier.painter) && this.sizeToIntrinsics == painterModifier.sizeToIntrinsics && Intrinsics.areEqual(this.alignment, painterModifier.alignment) && Intrinsics.areEqual(this.contentScale, painterModifier.contentScale) && this.alpha == painterModifier.alpha && Intrinsics.areEqual(this.colorFilter, painterModifier.colorFilter);
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
