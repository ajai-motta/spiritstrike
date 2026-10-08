package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LazyGridMeasure.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ap\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001aÒ\u0001\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(2/\u0010)\u001a+\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.\u0012\u0004\u0012\u00020/0*H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "lines", "", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "mainAxisAvailableSize", "slotsPerLine", "beforeContentPadding", "afterContentPadding", "firstVisibleLineIndex", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", TtmlNode.TAG_LAYOUT, "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-zIfe3eg", "(ILandroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX INFO: renamed from: measureLazyGrid-zIfe3eg, reason: not valid java name */
    public static final LazyGridMeasureResult m602measureLazyGridzIfe3eg(int i, LazyMeasuredLineProvider lazyMeasuredLineProvider, LazyMeasuredItemProvider measuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyGridItemPlacementAnimator placementAnimator, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int i8;
        int i9;
        int iM624constructorimpl;
        int i10;
        int i11;
        LazyMeasuredLine lazyMeasuredLine;
        int i12;
        int iM3845constrainWidthK40F9xA;
        int iM3830getMaxHeightimpl;
        LazyMeasuredLineProvider measuredLineProvider = lazyMeasuredLineProvider;
        Intrinsics.checkNotNullParameter(measuredLineProvider, "measuredLineProvider");
        Intrinsics.checkNotNullParameter(measuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(placementAnimator, "placementAnimator");
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (i4 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i <= 0) {
            return new LazyGridMeasureResult(null, 0, false, 0.0f, layout.invoke(Integer.valueOf(Constraints.m3833getMinWidthimpl(j)), Integer.valueOf(Constraints.m3832getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), CollectionsKt.emptyList(), -i4, i2 + i5, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i5);
        }
        int iRoundToInt = MathKt.roundToInt(f);
        int i13 = i7 - iRoundToInt;
        int iM624constructorimpl2 = i6;
        if (LineIndex.m627equalsimpl0(iM624constructorimpl2, LineIndex.m624constructorimpl(0)) && i13 < 0) {
            iRoundToInt += i13;
            i13 = 0;
        }
        ArrayList arrayList = new ArrayList();
        int mainAxisSizeWithSpacings = i13 - i4;
        int i14 = -i4;
        while (mainAxisSizeWithSpacings < 0 && iM624constructorimpl2 - LineIndex.m624constructorimpl(0) > 0) {
            iM624constructorimpl2 = LineIndex.m624constructorimpl(iM624constructorimpl2 - 1);
            LazyMeasuredLine lazyMeasuredLineM620getAndMeasurebKFJvoY = measuredLineProvider.m620getAndMeasurebKFJvoY(iM624constructorimpl2);
            arrayList.add(0, lazyMeasuredLineM620getAndMeasurebKFJvoY);
            mainAxisSizeWithSpacings += lazyMeasuredLineM620getAndMeasurebKFJvoY.getMainAxisSizeWithSpacings();
        }
        if (mainAxisSizeWithSpacings < i14) {
            i8 = iRoundToInt + mainAxisSizeWithSpacings;
            i9 = i14;
        } else {
            int i15 = mainAxisSizeWithSpacings;
            i8 = iRoundToInt;
            i9 = i15;
        }
        int i16 = i9 + i4;
        int i17 = i2 + i5;
        int i18 = iM624constructorimpl2;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i17, 0);
        int mainAxisSizeWithSpacings2 = -i16;
        int size = arrayList.size();
        int iM624constructorimpl3 = i18;
        int i19 = i17;
        for (int i20 = 0; i20 < size; i20++) {
            LazyMeasuredLine lazyMeasuredLine2 = (LazyMeasuredLine) arrayList.get(i20);
            iM624constructorimpl3 = LineIndex.m624constructorimpl(iM624constructorimpl3 + 1);
            mainAxisSizeWithSpacings2 += lazyMeasuredLine2.getMainAxisSizeWithSpacings();
        }
        int mainAxisSizeWithSpacings3 = i16;
        int iM624constructorimpl4 = iM624constructorimpl3;
        while (true) {
            if (mainAxisSizeWithSpacings2 > iCoerceAtLeast && !arrayList.isEmpty()) {
                break;
            }
            int i21 = iCoerceAtLeast;
            LazyMeasuredLine lazyMeasuredLineM620getAndMeasurebKFJvoY2 = measuredLineProvider.m620getAndMeasurebKFJvoY(iM624constructorimpl4);
            if (!lazyMeasuredLineM620getAndMeasurebKFJvoY2.isEmpty()) {
                int i22 = i14;
                int i23 = i19;
                mainAxisSizeWithSpacings2 += lazyMeasuredLineM620getAndMeasurebKFJvoY2.getMainAxisSizeWithSpacings();
                if (mainAxisSizeWithSpacings2 > i22 || ((LazyMeasuredItem) ArraysKt.last(lazyMeasuredLineM620getAndMeasurebKFJvoY2.getItems())).getIndex() == i - 1) {
                    arrayList.add(lazyMeasuredLineM620getAndMeasurebKFJvoY2);
                    iM624constructorimpl = i18;
                } else {
                    iM624constructorimpl = LineIndex.m624constructorimpl(iM624constructorimpl4 + 1);
                    mainAxisSizeWithSpacings3 -= lazyMeasuredLineM620getAndMeasurebKFJvoY2.getMainAxisSizeWithSpacings();
                }
                iM624constructorimpl4 = LineIndex.m624constructorimpl(iM624constructorimpl4 + 1);
                i18 = iM624constructorimpl;
                i14 = i22;
                iCoerceAtLeast = i21;
                i19 = i23;
                measuredLineProvider = lazyMeasuredLineProvider;
            } else {
                LineIndex.m624constructorimpl(iM624constructorimpl4 - 1);
                break;
            }
        }
        if (mainAxisSizeWithSpacings2 < i2) {
            int i24 = i2 - mainAxisSizeWithSpacings2;
            mainAxisSizeWithSpacings3 -= i24;
            mainAxisSizeWithSpacings2 += i24;
            int iM624constructorimpl5 = i18;
            while (true) {
                if (mainAxisSizeWithSpacings3 >= i4) {
                    i10 = i14;
                    i11 = 0;
                    break;
                }
                if (iM624constructorimpl5 - LineIndex.m624constructorimpl(0) <= 0) {
                    i11 = 0;
                    i10 = i14;
                    break;
                }
                iM624constructorimpl5 = LineIndex.m624constructorimpl(iM624constructorimpl5 - 1);
                int i25 = i14;
                LazyMeasuredLine lazyMeasuredLineM620getAndMeasurebKFJvoY3 = measuredLineProvider.m620getAndMeasurebKFJvoY(iM624constructorimpl5);
                arrayList.add(0, lazyMeasuredLineM620getAndMeasurebKFJvoY3);
                mainAxisSizeWithSpacings3 += lazyMeasuredLineM620getAndMeasurebKFJvoY3.getMainAxisSizeWithSpacings();
                i14 = i25;
            }
            i8 += i24;
            if (mainAxisSizeWithSpacings3 < 0) {
                i8 += mainAxisSizeWithSpacings3;
                mainAxisSizeWithSpacings2 += mainAxisSizeWithSpacings3;
                mainAxisSizeWithSpacings3 = i11;
            }
        } else {
            i10 = i14;
            i11 = 0;
        }
        float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(i8) || Math.abs(MathKt.roundToInt(f)) < Math.abs(i8)) ? f : i8;
        int i26 = -mainAxisSizeWithSpacings3;
        LazyMeasuredLine lazyMeasuredLine3 = (LazyMeasuredLine) CollectionsKt.first((List) arrayList);
        if (i4 > 0) {
            int size2 = arrayList.size();
            int i27 = mainAxisSizeWithSpacings3;
            LazyMeasuredLine lazyMeasuredLine4 = lazyMeasuredLine3;
            int i28 = i11;
            while (i28 < size2) {
                int mainAxisSizeWithSpacings4 = ((LazyMeasuredLine) arrayList.get(i28)).getMainAxisSizeWithSpacings();
                if (i27 == 0 || mainAxisSizeWithSpacings4 > i27 || i28 == CollectionsKt.getLastIndex(arrayList)) {
                    break;
                }
                i27 -= mainAxisSizeWithSpacings4;
                i28++;
                lazyMeasuredLine4 = (LazyMeasuredLine) arrayList.get(i28);
            }
            lazyMeasuredLine = lazyMeasuredLine4;
            i12 = i27;
        } else {
            lazyMeasuredLine = lazyMeasuredLine3;
            i12 = mainAxisSizeWithSpacings3;
        }
        if (z) {
            iM3845constrainWidthK40F9xA = Constraints.m3831getMaxWidthimpl(j);
        } else {
            iM3845constrainWidthK40F9xA = ConstraintsKt.m3845constrainWidthK40F9xA(j, mainAxisSizeWithSpacings2);
        }
        int i29 = iM3845constrainWidthK40F9xA;
        if (z) {
            iM3830getMaxHeightimpl = ConstraintsKt.m3844constrainHeightK40F9xA(j, mainAxisSizeWithSpacings2);
        } else {
            iM3830getMaxHeightimpl = Constraints.m3830getMaxHeightimpl(j);
        }
        int i30 = iM3830getMaxHeightimpl;
        int i31 = i19;
        float f3 = f2;
        int i32 = i10;
        final List<LazyGridPositionedItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayList, i29, i30, mainAxisSizeWithSpacings2, i2, i26, z, vertical, horizontal, z2, density);
        int i33 = mainAxisSizeWithSpacings2;
        placementAnimator.onMeasured((int) f3, i29, i30, i3, z2, listCalculateItemsOffsets, measuredItemProvider);
        return new LazyGridMeasureResult(lazyMeasuredLine, i12, i33 > i2, f3, layout.invoke(Integer.valueOf(i29), Integer.valueOf(i30), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                List<LazyGridPositionedItem> list = listCalculateItemsOffsets;
                int size3 = list.size();
                for (int i34 = 0; i34 < size3; i34++) {
                    list.get(i34).place(invoke);
                }
            }
        }), listCalculateItemsOffsets, i32, i31, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i5);
    }

    private static final List<LazyGridPositionedItem> calculateItemsOffsets(List<LazyMeasuredLine> list, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int size = list.size();
        int length = 0;
        for (int i7 = 0; i7 < size; i7++) {
            length += list.get(i7).getItems().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (z3) {
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i8 = 0; i8 < size2; i8++) {
                iArr[i8] = list.get(calculateItemsOffsets$reverseAware(i8, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            for (int i9 = 0; i9 < size2; i9++) {
                iArr2[i9] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                vertical.arrange(density, i6, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int mainAxisSize = iArr2[first];
                    LazyMeasuredLine lazyMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        mainAxisSize = (i6 - mainAxisSize) - lazyMeasuredLine.getMainAxisSize();
                    }
                    arrayList.addAll(lazyMeasuredLine.position(mainAxisSize, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list.size();
            int mainAxisSizeWithSpacings = i5;
            for (int i10 = 0; i10 < size3; i10++) {
                LazyMeasuredLine lazyMeasuredLine2 = list.get(i10);
                arrayList.addAll(lazyMeasuredLine2.position(mainAxisSizeWithSpacings, i, i2));
                mainAxisSizeWithSpacings += lazyMeasuredLine2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }
}
