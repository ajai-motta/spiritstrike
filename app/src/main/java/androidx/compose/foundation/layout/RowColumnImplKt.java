package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0012\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u0018\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u0019\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u001a\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001ad\u0010\u001b\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u001d\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u001d\u0010 \u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001aE\u0010#\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u001d\u0010\u001d\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0015H\u0002\u001at\u0010%\u001a\u00020\u00152\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u001d\u0010&\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u001d\u0010'\u001a\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001e¢\u0006\u0002\b\u001f2\u0006\u0010$\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0017H\u0002\u001aa\u0010*\u001a\u00020+2\u0006\u0010\u0016\u001a\u00020\u00172*\u0010,\u001a&\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u0002010-2\u0006\u00102\u001a\u0002032\u0006\u0010 \u001a\u0002042\u0006\u0010\u0000\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\"\u001c\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001a\u0010\r\u001a\u00020\n*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\f\"\u001a\u0010\u000e\u001a\u00020\u000f*\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "data", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", ReportUtil.EVENT_TYPE_FILL, "", "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "isRelative", "weight", "", "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", "MaxIntrinsicHeightMeasureBlock", "Lkotlin/Function3;", "", "", AdUnitActivity.EXTRA_ORIENTATION, "Landroidx/compose/foundation/layout/LayoutOrientation;", "MaxIntrinsicWidthMeasureBlock", "MinIntrinsicHeightMeasureBlock", "MinIntrinsicWidthMeasureBlock", "intrinsicCrossAxisSize", "children", "mainAxisSize", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "crossAxisSize", "mainAxisAvailable", "mainAxisSpacing", "intrinsicMainAxisSize", "crossAxisAvailable", "intrinsicSize", "intrinsicMainSize", "intrinsicCrossSize", "layoutOrientation", "intrinsicOrientation", "rowColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "arrangement", "Lkotlin/Function5;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/foundation/layout/SizeMode;", "rowColumnMeasurePolicy-TDGSqEk", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RowColumnImplKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* JADX INFO: renamed from: rowColumnMeasurePolicy-TDGSqEk, reason: not valid java name */
    public static final MeasurePolicy m449rowColumnMeasurePolicyTDGSqEk(final LayoutOrientation orientation, final Function5<? super Integer, ? super int[], ? super LayoutDirection, ? super Density, ? super int[], Unit> arrangement, final float f, final SizeMode crossAxisSize, final CrossAxisAlignment crossAxisAlignment) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(arrangement, "arrangement");
        Intrinsics.checkNotNullParameter(crossAxisSize, "crossAxisSize");
        Intrinsics.checkNotNullParameter(crossAxisAlignment, "crossAxisAlignment");
        return new MeasurePolicy() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo16measure3p2s80s(final MeasureScope measure, final List<? extends Measurable> list, long j) {
                int mainAxisMin;
                int iMax;
                int iCoerceAtMost;
                float f2;
                int i;
                int i2;
                int iMax2;
                int iMax3;
                int i3;
                int i4;
                RowColumnParentData[] rowColumnParentDataArr;
                List<? extends Measurable> measurables = list;
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(j, orientation, null);
                int i5 = measure.mo311roundToPx0680j_4(f);
                int size = list.size();
                final Placeable[] placeableArr = new Placeable[size];
                int size2 = list.size();
                RowColumnParentData[] rowColumnParentDataArr2 = new RowColumnParentData[size2];
                for (int i6 = 0; i6 < size2; i6++) {
                    rowColumnParentDataArr2[i6] = RowColumnImplKt.getData(measurables.get(i6));
                }
                int size3 = list.size();
                int i7 = 0;
                int iMax4 = 0;
                int i8 = 0;
                int i9 = 0;
                int iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize = 0;
                boolean z = false;
                float f3 = 0.0f;
                while (true) {
                    if (i8 >= size3) {
                        break;
                    }
                    Measurable measurable = measurables.get(i8);
                    RowColumnParentData rowColumnParentData = rowColumnParentDataArr2[i8];
                    float weight = RowColumnImplKt.getWeight(rowColumnParentData);
                    if (weight > 0.0f) {
                        f3 += weight;
                        i9++;
                        i3 = i8;
                        i4 = size3;
                        rowColumnParentDataArr = rowColumnParentDataArr2;
                    } else {
                        int mainAxisMax = orientationIndependentConstraints.getMainAxisMax();
                        i3 = i8;
                        i4 = size3;
                        rowColumnParentDataArr = rowColumnParentDataArr2;
                        Placeable placeableMo3152measureBRTryo0 = measurable.mo3152measureBRTryo0(OrientationIndependentConstraints.copy$default(orientationIndependentConstraints, 0, mainAxisMax != Integer.MAX_VALUE ? mainAxisMax - iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize : Integer.MAX_VALUE, 0, 0, 8, null).m420toBoxConstraintsOenEA2s(orientation));
                        int iMin = Math.min(i5, (mainAxisMax - iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize) - RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeableMo3152measureBRTryo0, orientation));
                        iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeableMo3152measureBRTryo0, orientation) + iMin;
                        iMax4 = Math.max(iMax4, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeableMo3152measureBRTryo0, orientation));
                        boolean z2 = z || RowColumnImplKt.isRelative(rowColumnParentData);
                        placeableArr[i3] = placeableMo3152measureBRTryo0;
                        i7 = iMin;
                        z = z2;
                    }
                    i8 = i3 + 1;
                    rowColumnParentDataArr2 = rowColumnParentDataArr;
                    size3 = i4;
                }
                int i10 = iMax4;
                final RowColumnParentData[] rowColumnParentDataArr3 = rowColumnParentDataArr2;
                if (i9 == 0) {
                    iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize -= i7;
                    iMax = i10;
                    iCoerceAtMost = 0;
                } else {
                    if (f3 > 0.0f && orientationIndependentConstraints.getMainAxisMax() != Integer.MAX_VALUE) {
                        mainAxisMin = orientationIndependentConstraints.getMainAxisMax();
                    } else {
                        mainAxisMin = orientationIndependentConstraints.getMainAxisMin();
                    }
                    int i11 = i5 * (i9 - 1);
                    int i12 = (mainAxisMin - iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize) - i11;
                    float f4 = f3 > 0.0f ? i12 / f3 : 0.0f;
                    int iRoundToInt = 0;
                    for (int i13 = 0; i13 < size2; i13++) {
                        iRoundToInt += MathKt.roundToInt(RowColumnImplKt.getWeight(rowColumnParentDataArr3[i13]) * f4);
                    }
                    int size4 = list.size();
                    int i14 = i12 - iRoundToInt;
                    iMax = i10;
                    int i15 = 0;
                    int iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize2 = 0;
                    while (i15 < size4) {
                        if (placeableArr[i15] == null) {
                            Measurable measurable2 = measurables.get(i15);
                            RowColumnParentData rowColumnParentData2 = rowColumnParentDataArr3[i15];
                            float weight2 = RowColumnImplKt.getWeight(rowColumnParentData2);
                            if (weight2 <= 0.0f) {
                                throw new IllegalStateException("All weights <= 0 should have placeables".toString());
                            }
                            int sign = MathKt.getSign(i14);
                            int i16 = i14 - sign;
                            int iMax5 = Math.max(0, MathKt.roundToInt(weight2 * f4) + sign);
                            f2 = f4;
                            if (!RowColumnImplKt.getFill(rowColumnParentData2) || iMax5 == Integer.MAX_VALUE) {
                                i = size4;
                                i2 = 0;
                            } else {
                                i2 = iMax5;
                                i = size4;
                            }
                            Placeable placeableMo3152measureBRTryo02 = measurable2.mo3152measureBRTryo0(new OrientationIndependentConstraints(i2, iMax5, 0, orientationIndependentConstraints.getCrossAxisMax()).m420toBoxConstraintsOenEA2s(orientation));
                            iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize2 += RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeableMo3152measureBRTryo02, orientation);
                            iMax = Math.max(iMax, RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeableMo3152measureBRTryo02, orientation));
                            boolean z3 = z || RowColumnImplKt.isRelative(rowColumnParentData2);
                            placeableArr[i15] = placeableMo3152measureBRTryo02;
                            z = z3;
                            i14 = i16;
                        } else {
                            f2 = f4;
                            i = size4;
                        }
                        i15++;
                        measurables = list;
                        f4 = f2;
                        size4 = i;
                    }
                    iCoerceAtMost = RangesKt.coerceAtMost(iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize2 + i11, orientationIndependentConstraints.getMainAxisMax() - iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize);
                }
                final Ref.IntRef intRef = new Ref.IntRef();
                if (z) {
                    iMax2 = 0;
                    for (int i17 = 0; i17 < size; i17++) {
                        Placeable placeable = placeableArr[i17];
                        Intrinsics.checkNotNull(placeable);
                        CrossAxisAlignment crossAxisAlignment2 = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentDataArr3[i17]);
                        Integer numCalculateAlignmentLinePosition$foundation_layout_release = crossAxisAlignment2 != null ? crossAxisAlignment2.calculateAlignmentLinePosition$foundation_layout_release(placeable) : null;
                        if (numCalculateAlignmentLinePosition$foundation_layout_release != null) {
                            int i18 = intRef.element;
                            Integer num = numCalculateAlignmentLinePosition$foundation_layout_release;
                            int iIntValue = num.intValue();
                            if (iIntValue == Integer.MIN_VALUE) {
                                iIntValue = 0;
                            }
                            intRef.element = Math.max(i18, iIntValue);
                            int iRowColumnMeasurePolicy_TDGSqEk$crossAxisSize = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, orientation);
                            LayoutOrientation layoutOrientation = orientation;
                            int iIntValue2 = num.intValue();
                            if (iIntValue2 == Integer.MIN_VALUE) {
                                iIntValue2 = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable, layoutOrientation);
                            }
                            iMax2 = Math.max(iMax2, iRowColumnMeasurePolicy_TDGSqEk$crossAxisSize - iIntValue2);
                        }
                    }
                } else {
                    iMax2 = 0;
                }
                final int iMax6 = Math.max(iRowColumnMeasurePolicy_TDGSqEk$mainAxisSize + iCoerceAtMost, orientationIndependentConstraints.getMainAxisMin());
                if (orientationIndependentConstraints.getCrossAxisMax() != Integer.MAX_VALUE && crossAxisSize == SizeMode.Expand) {
                    iMax3 = orientationIndependentConstraints.getCrossAxisMax();
                } else {
                    iMax3 = Math.max(iMax, Math.max(orientationIndependentConstraints.getCrossAxisMin(), intRef.element + iMax2));
                }
                final int i19 = iMax3;
                int i20 = orientation == LayoutOrientation.Horizontal ? iMax6 : i19;
                int i21 = orientation == LayoutOrientation.Horizontal ? i19 : iMax6;
                int size5 = list.size();
                final int[] iArr = new int[size5];
                for (int i22 = 0; i22 < size5; i22++) {
                    iArr[i22] = 0;
                }
                final Function5<Integer, int[], LayoutDirection, Density, int[], Unit> function5 = arrangement;
                final LayoutOrientation layoutOrientation2 = orientation;
                final CrossAxisAlignment crossAxisAlignment3 = crossAxisAlignment;
                return MeasureScope.CC.layout$default(measure, i20, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RowColumnImplKt$rowColumnMeasurePolicy$1$measure$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        LayoutDirection layoutDirection;
                        int i23;
                        int[] iArr2;
                        int i24;
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        int size6 = list.size();
                        int[] iArr3 = new int[size6];
                        int i25 = 0;
                        for (int i26 = 0; i26 < size6; i26++) {
                            Placeable placeable2 = placeableArr[i26];
                            Intrinsics.checkNotNull(placeable2);
                            iArr3[i26] = RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$mainAxisSize(placeable2, layoutOrientation2);
                        }
                        function5.invoke(Integer.valueOf(iMax6), iArr3, measure.getLayoutDirection(), measure, iArr);
                        Placeable[] placeableArr2 = placeableArr;
                        RowColumnParentData[] rowColumnParentDataArr4 = rowColumnParentDataArr3;
                        CrossAxisAlignment crossAxisAlignment4 = crossAxisAlignment3;
                        int i27 = i19;
                        LayoutOrientation layoutOrientation3 = layoutOrientation2;
                        MeasureScope measureScope = measure;
                        Ref.IntRef intRef2 = intRef;
                        int[] iArr4 = iArr;
                        int length = placeableArr2.length;
                        int i28 = 0;
                        while (i25 < length) {
                            Placeable placeable3 = placeableArr2[i25];
                            int i29 = i28 + 1;
                            Intrinsics.checkNotNull(placeable3);
                            CrossAxisAlignment crossAxisAlignment5 = RowColumnImplKt.getCrossAxisAlignment(rowColumnParentDataArr4[i28]);
                            if (crossAxisAlignment5 == null) {
                                crossAxisAlignment5 = crossAxisAlignment4;
                            }
                            int iRowColumnMeasurePolicy_TDGSqEk$crossAxisSize2 = i27 - RowColumnImplKt.rowColumnMeasurePolicy_TDGSqEk$crossAxisSize(placeable3, layoutOrientation3);
                            if (layoutOrientation3 == LayoutOrientation.Horizontal) {
                                layoutDirection = LayoutDirection.Ltr;
                            } else {
                                layoutDirection = measureScope.getLayoutDirection();
                            }
                            Placeable[] placeableArr3 = placeableArr2;
                            int iAlign$foundation_layout_release = crossAxisAlignment5.align$foundation_layout_release(iRowColumnMeasurePolicy_TDGSqEk$crossAxisSize2, layoutDirection, placeable3, intRef2.element);
                            if (layoutOrientation3 == LayoutOrientation.Horizontal) {
                                i23 = length;
                                iArr2 = iArr4;
                                i24 = i25;
                                Placeable.PlacementScope.place$default(layout, placeable3, iArr4[i28], iAlign$foundation_layout_release, 0.0f, 4, null);
                            } else {
                                i23 = length;
                                iArr2 = iArr4;
                                i24 = i25;
                                Placeable.PlacementScope.place$default(layout, placeable3, iAlign$foundation_layout_release, iArr2[i28], 0.0f, 4, null);
                            }
                            i25 = i24 + 1;
                            i28 = i29;
                            placeableArr2 = placeableArr3;
                            iArr4 = iArr2;
                            length = i23;
                        }
                    }
                }, 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return ((Number) RowColumnImplKt.MinIntrinsicWidthMeasureBlock(orientation).invoke(measurables, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.mo311roundToPx0680j_4(f)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return ((Number) RowColumnImplKt.MinIntrinsicHeightMeasureBlock(orientation).invoke(measurables, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.mo311roundToPx0680j_4(f)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return ((Number) RowColumnImplKt.MaxIntrinsicWidthMeasureBlock(orientation).invoke(measurables, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.mo311roundToPx0680j_4(f)))).intValue();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int i) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return ((Number) RowColumnImplKt.MaxIntrinsicHeightMeasureBlock(orientation).invoke(measurables, Integer.valueOf(i), Integer.valueOf(intrinsicMeasureScope.mo311roundToPx0680j_4(f)))).intValue();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RowColumnParentData getData(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        if (parentData instanceof RowColumnParentData) {
            return (RowColumnParentData) parentData;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float getWeight(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getWeight();
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getFill(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getFill();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CrossAxisAlignment getCrossAxisAlignment(RowColumnParentData rowColumnParentData) {
        if (rowColumnParentData != null) {
            return rowColumnParentData.getCrossAxisAlignment();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isRelative(RowColumnParentData rowColumnParentData) {
        CrossAxisAlignment crossAxisAlignment = getCrossAxisAlignment(rowColumnParentData);
        if (crossAxisAlignment != null) {
            return crossAxisAlignment.isRelative$foundation_layout_release();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicWidthMeasureBlock(LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinWidth();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMinWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MinIntrinsicHeightMeasureBlock(LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMinHeight();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMinHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicWidthMeasureBlock(LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxWidth();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3<List<? extends IntrinsicMeasurable>, Integer, Integer, Integer> MaxIntrinsicHeightMeasureBlock(LayoutOrientation layoutOrientation) {
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return IntrinsicMeasureBlocks.INSTANCE.getHorizontalMaxHeight();
        }
        return IntrinsicMeasureBlocks.INSTANCE.getVerticalMaxHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int intrinsicSize(List<? extends IntrinsicMeasurable> list, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22, int i, int i2, LayoutOrientation layoutOrientation, LayoutOrientation layoutOrientation2) {
        if (layoutOrientation == layoutOrientation2) {
            return intrinsicMainAxisSize(list, function2, i, i2);
        }
        return intrinsicCrossAxisSize(list, function22, function2, i, i2);
    }

    private static final int intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function22, int i, int i2) {
        int iRoundToInt;
        int iMin = Math.min((list.size() - 1) * i2, i);
        int size = list.size();
        int iMax = 0;
        float f = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i3);
            float weight = getWeight(getData(intrinsicMeasurable));
            if (weight == 0.0f) {
                int iMin2 = Math.min(function2.invoke(intrinsicMeasurable, Integer.MAX_VALUE).intValue(), i - iMin);
                iMin += iMin2;
                iMax = Math.max(iMax, function22.invoke(intrinsicMeasurable, Integer.valueOf(iMin2)).intValue());
            } else if (weight > 0.0f) {
                f += weight;
            }
        }
        if (f == 0.0f) {
            iRoundToInt = 0;
        } else {
            iRoundToInt = i == Integer.MAX_VALUE ? Integer.MAX_VALUE : MathKt.roundToInt(Math.max(i - iMin, 0) / f);
        }
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            IntrinsicMeasurable intrinsicMeasurable2 = list.get(i4);
            float weight2 = getWeight(getData(intrinsicMeasurable2));
            if (weight2 > 0.0f) {
                iMax = Math.max(iMax, function22.invoke(intrinsicMeasurable2, Integer.valueOf(iRoundToInt != Integer.MAX_VALUE ? MathKt.roundToInt(iRoundToInt * weight2) : Integer.MAX_VALUE)).intValue());
            }
        }
        return iMax;
    }

    private static final int intrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2, int i, int i2) {
        int size = list.size();
        int iMax = 0;
        int i3 = 0;
        float f = 0.0f;
        for (int i4 = 0; i4 < size; i4++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i4);
            float weight = getWeight(getData(intrinsicMeasurable));
            int iIntValue = function2.invoke(intrinsicMeasurable, Integer.valueOf(i)).intValue();
            if (weight == 0.0f) {
                i3 += iIntValue;
            } else if (weight > 0.0f) {
                f += weight;
                iMax = Math.max(iMax, MathKt.roundToInt(iIntValue / weight));
            }
        }
        return MathKt.roundToInt(iMax * f) + i3 + ((list.size() - 1) * i2);
    }
}
