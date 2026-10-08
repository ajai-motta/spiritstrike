package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
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

/* JADX INFO: compiled from: LazyListMeasure.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u008c\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002\u001aØ\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2/\u0010+\u001a+\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0-¢\u0006\u0002\b0\u0012\u0004\u0012\u0002010,H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"calculateItemsOffsets", "", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", FirebaseAnalytics.Param.ITEMS, "", "Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "firstVisibleItemIndex", "Landroidx/compose/foundation/lazy/DataIndex;", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "headerIndexes", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", TtmlNode.TAG_LAYOUT, "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-7Xnphek", "(ILandroidx/compose/foundation/lazy/LazyMeasuredItemProvider;IIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: measureLazyList-7Xnphek, reason: not valid java name */
    public static final LazyListMeasureResult m546measureLazyList7Xnphek(int i, LazyMeasuredItemProvider itemProvider, int i2, int i3, int i4, int i5, int i6, float f, long j, boolean z, List<Integer> headerIndexes, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyListItemPlacementAnimator placementAnimator, LazyListBeyondBoundsInfo beyondBoundsInfo, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> layout) {
        int i7;
        int i8;
        int iM515constructorimpl;
        int i9;
        int i10;
        int i11;
        LazyMeasuredItem lazyMeasuredItem;
        ArrayList arrayListEmptyList;
        List listEmptyList;
        LazyMeasuredItem lazyMeasuredItem2;
        int i12;
        int i13;
        LazyListPositionedItem lazyListPositionedItemFindOrComposeLazyListHeader;
        List<LazyListPositionedItem> list;
        Intrinsics.checkNotNullParameter(itemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(headerIndexes, "headerIndexes");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(placementAnimator, "placementAnimator");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (i3 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (i <= 0) {
            return new LazyListMeasureResult(null, 0, false, 0.0f, layout.invoke(Integer.valueOf(Constraints.m3833getMinWidthimpl(j)), Integer.valueOf(Constraints.m3832getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$1
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope invoke) {
                    Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4);
        }
        int iM515constructorimpl2 = i5;
        if (iM515constructorimpl2 >= i) {
            iM515constructorimpl2 = DataIndex.m515constructorimpl(i - 1);
            i7 = 0;
        } else {
            i7 = i6;
        }
        int iRoundToInt = MathKt.roundToInt(f);
        int i14 = i7 - iRoundToInt;
        if (DataIndex.m518equalsimpl0(iM515constructorimpl2, DataIndex.m515constructorimpl(0)) && i14 < 0) {
            iRoundToInt += i14;
            i14 = 0;
        }
        ArrayList arrayList = new ArrayList();
        int sizeWithSpacings = i14 - i3;
        int i15 = -i3;
        int iMax = 0;
        while (sizeWithSpacings < 0 && iM515constructorimpl2 - DataIndex.m515constructorimpl(0) > 0) {
            int iM515constructorimpl3 = DataIndex.m515constructorimpl(iM515constructorimpl2 - 1);
            LazyMeasuredItem lazyMeasuredItemM557getAndMeasureZjPyQlc = itemProvider.m557getAndMeasureZjPyQlc(iM515constructorimpl3);
            arrayList.add(0, lazyMeasuredItemM557getAndMeasureZjPyQlc);
            iMax = Math.max(iMax, lazyMeasuredItemM557getAndMeasureZjPyQlc.getCrossAxisSize());
            sizeWithSpacings += lazyMeasuredItemM557getAndMeasureZjPyQlc.getSizeWithSpacings();
            iM515constructorimpl2 = iM515constructorimpl3;
        }
        if (sizeWithSpacings < i15) {
            iRoundToInt += sizeWithSpacings;
            sizeWithSpacings = i15;
        }
        int i16 = sizeWithSpacings + i3;
        int i17 = i2 + i4;
        int i18 = iM515constructorimpl2;
        int i19 = iMax;
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i17, 0);
        int sizeWithSpacings2 = -i16;
        int size = arrayList.size();
        int iM515constructorimpl4 = i18;
        for (int i20 = 0; i20 < size; i20++) {
            LazyMeasuredItem lazyMeasuredItem3 = (LazyMeasuredItem) arrayList.get(i20);
            iM515constructorimpl4 = DataIndex.m515constructorimpl(iM515constructorimpl4 + 1);
            sizeWithSpacings2 += lazyMeasuredItem3.getSizeWithSpacings();
        }
        int sizeWithSpacings3 = i16;
        int i21 = i19;
        int sizeWithSpacings4 = sizeWithSpacings2;
        int iM515constructorimpl5 = iM515constructorimpl4;
        while (true) {
            if ((sizeWithSpacings4 > iCoerceAtLeast && !arrayList.isEmpty()) || iM515constructorimpl5 >= i) {
                break;
            }
            int i22 = iCoerceAtLeast;
            LazyMeasuredItem lazyMeasuredItemM557getAndMeasureZjPyQlc2 = itemProvider.m557getAndMeasureZjPyQlc(iM515constructorimpl5);
            sizeWithSpacings4 += lazyMeasuredItemM557getAndMeasureZjPyQlc2.getSizeWithSpacings();
            if (sizeWithSpacings4 <= i15) {
                i8 = i15;
                if (iM515constructorimpl5 != i - 1) {
                    iM515constructorimpl = DataIndex.m515constructorimpl(iM515constructorimpl5 + 1);
                    sizeWithSpacings3 -= lazyMeasuredItemM557getAndMeasureZjPyQlc2.getSizeWithSpacings();
                }
                iM515constructorimpl5 = DataIndex.m515constructorimpl(iM515constructorimpl5 + 1);
                i18 = iM515constructorimpl;
                iCoerceAtLeast = i22;
                i15 = i8;
            } else {
                i8 = i15;
            }
            int iMax2 = Math.max(i21, lazyMeasuredItemM557getAndMeasureZjPyQlc2.getCrossAxisSize());
            arrayList.add(lazyMeasuredItemM557getAndMeasureZjPyQlc2);
            i21 = iMax2;
            iM515constructorimpl = i18;
            iM515constructorimpl5 = DataIndex.m515constructorimpl(iM515constructorimpl5 + 1);
            i18 = iM515constructorimpl;
            iCoerceAtLeast = i22;
            i15 = i8;
        }
        int i23 = i15;
        if (sizeWithSpacings4 < i2) {
            int i24 = i2 - sizeWithSpacings4;
            sizeWithSpacings3 -= i24;
            sizeWithSpacings4 += i24;
            int iMax3 = i21;
            int iM515constructorimpl6 = i18;
            while (sizeWithSpacings3 < i3 && iM515constructorimpl6 - DataIndex.m515constructorimpl(0) > 0) {
                iM515constructorimpl6 = DataIndex.m515constructorimpl(iM515constructorimpl6 - 1);
                LazyMeasuredItem lazyMeasuredItemM557getAndMeasureZjPyQlc3 = itemProvider.m557getAndMeasureZjPyQlc(iM515constructorimpl6);
                arrayList.add(0, lazyMeasuredItemM557getAndMeasureZjPyQlc3);
                iMax3 = Math.max(iMax3, lazyMeasuredItemM557getAndMeasureZjPyQlc3.getCrossAxisSize());
                sizeWithSpacings3 += lazyMeasuredItemM557getAndMeasureZjPyQlc3.getSizeWithSpacings();
            }
            iRoundToInt += i24;
            if (sizeWithSpacings3 < 0) {
                iRoundToInt += sizeWithSpacings3;
                i21 = iMax3;
                i9 = sizeWithSpacings4 + sizeWithSpacings3;
                sizeWithSpacings3 = 0;
            } else {
                i21 = iMax3;
                i9 = sizeWithSpacings4;
            }
        } else {
            i9 = sizeWithSpacings4;
        }
        float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(iRoundToInt) || Math.abs(MathKt.roundToInt(f)) < Math.abs(iRoundToInt)) ? f : iRoundToInt;
        int i25 = -sizeWithSpacings3;
        LazyMeasuredItem lazyMeasuredItem4 = (LazyMeasuredItem) CollectionsKt.first((List) arrayList);
        if (i3 > 0) {
            int size2 = arrayList.size();
            LazyMeasuredItem lazyMeasuredItem5 = lazyMeasuredItem4;
            int i26 = sizeWithSpacings3;
            int i27 = 0;
            while (i27 < size2) {
                int sizeWithSpacings5 = ((LazyMeasuredItem) arrayList.get(i27)).getSizeWithSpacings();
                if (i26 == 0 || sizeWithSpacings5 > i26) {
                    break;
                }
                i10 = i21;
                if (i27 == CollectionsKt.getLastIndex(arrayList)) {
                    break;
                }
                i26 -= sizeWithSpacings5;
                i27++;
                lazyMeasuredItem5 = (LazyMeasuredItem) arrayList.get(i27);
                i21 = i10;
            }
            i10 = i21;
            i11 = i26;
            lazyMeasuredItem = lazyMeasuredItem5;
        } else {
            i10 = i21;
            i11 = sizeWithSpacings3;
            lazyMeasuredItem = lazyMeasuredItem4;
        }
        if (beyondBoundsInfo.hasIntervals() && ((LazyMeasuredItem) CollectionsKt.first((List) arrayList)).getIndex() > measureLazyList_7Xnphek$startIndex(beyondBoundsInfo, i)) {
            arrayListEmptyList = new ArrayList();
            int index = ((LazyMeasuredItem) CollectionsKt.first((List) arrayList)).getIndex() - 1;
            int iMeasureLazyList_7Xnphek$startIndex = measureLazyList_7Xnphek$startIndex(beyondBoundsInfo, i);
            if (iMeasureLazyList_7Xnphek$startIndex <= index) {
                while (true) {
                    arrayListEmptyList.add(itemProvider.m557getAndMeasureZjPyQlc(DataIndex.m515constructorimpl(index)));
                    if (index == iMeasureLazyList_7Xnphek$startIndex) {
                        break;
                    }
                    index--;
                }
            }
            Unit unit = Unit.INSTANCE;
        } else {
            arrayListEmptyList = CollectionsKt.emptyList();
        }
        List list2 = arrayListEmptyList;
        if (beyondBoundsInfo.hasIntervals() && ((LazyMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex() < measureLazyList_7Xnphek$endIndex(beyondBoundsInfo, i)) {
            ArrayList arrayList2 = new ArrayList();
            int index2 = ((LazyMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex();
            int iMeasureLazyList_7Xnphek$endIndex = measureLazyList_7Xnphek$endIndex(beyondBoundsInfo, i);
            while (index2 < iMeasureLazyList_7Xnphek$endIndex) {
                index2++;
                arrayList2.add(itemProvider.m557getAndMeasureZjPyQlc(DataIndex.m515constructorimpl(index2)));
            }
            Unit unit2 = Unit.INSTANCE;
            listEmptyList = arrayList2;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        boolean z3 = Intrinsics.areEqual(lazyMeasuredItem, CollectionsKt.first((List) arrayList)) && list2.isEmpty() && listEmptyList.isEmpty();
        int iM3845constrainWidthK40F9xA = ConstraintsKt.m3845constrainWidthK40F9xA(j, z ? i10 : i9);
        int iM3844constrainHeightK40F9xA = ConstraintsKt.m3844constrainHeightK40F9xA(j, z ? i9 : i10);
        final List<LazyListPositionedItem> listCalculateItemsOffsets = calculateItemsOffsets(arrayList, list2, listEmptyList, iM3845constrainWidthK40F9xA, iM3844constrainHeightK40F9xA, i9, i2, i25, z, vertical, horizontal, z2, density);
        if (!headerIndexes.isEmpty()) {
            lazyMeasuredItem2 = lazyMeasuredItem;
            i12 = 0;
            i13 = i23;
            lazyListPositionedItemFindOrComposeLazyListHeader = LazyListHeadersKt.findOrComposeLazyListHeader(listCalculateItemsOffsets, itemProvider, headerIndexes, i3, iM3845constrainWidthK40F9xA, iM3844constrainHeightK40F9xA);
        } else {
            lazyMeasuredItem2 = lazyMeasuredItem;
            i12 = 0;
            i13 = i23;
            lazyListPositionedItemFindOrComposeLazyListHeader = null;
        }
        final LazyListPositionedItem lazyListPositionedItem = lazyListPositionedItemFindOrComposeLazyListHeader;
        placementAnimator.onMeasured((int) f2, iM3845constrainWidthK40F9xA, iM3844constrainHeightK40F9xA, z2, listCalculateItemsOffsets, itemProvider);
        boolean z4 = i9 > i2 ? 1 : i12;
        MeasureResult measureResultInvoke = layout.invoke(Integer.valueOf(iM3845constrainWidthK40F9xA), Integer.valueOf(iM3844constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
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
                List<LazyListPositionedItem> list3 = listCalculateItemsOffsets;
                LazyListPositionedItem lazyListPositionedItem2 = lazyListPositionedItem;
                int size3 = list3.size();
                for (int i28 = 0; i28 < size3; i28++) {
                    LazyListPositionedItem lazyListPositionedItem3 = list3.get(i28);
                    if (lazyListPositionedItem3 != lazyListPositionedItem2) {
                        lazyListPositionedItem3.place(invoke);
                    }
                }
                LazyListPositionedItem lazyListPositionedItem4 = lazyListPositionedItem;
                if (lazyListPositionedItem4 != null) {
                    lazyListPositionedItem4.place(invoke);
                }
            }
        });
        if (z3) {
            list = listCalculateItemsOffsets;
        } else {
            ArrayList arrayList3 = new ArrayList(listCalculateItemsOffsets.size());
            int size3 = listCalculateItemsOffsets.size();
            while (i12 < size3) {
                LazyListPositionedItem lazyListPositionedItem2 = listCalculateItemsOffsets.get(i12);
                LazyListPositionedItem lazyListPositionedItem3 = lazyListPositionedItem2;
                if ((lazyListPositionedItem3.getIndex() >= ((LazyMeasuredItem) CollectionsKt.first((List) arrayList)).getIndex() && lazyListPositionedItem3.getIndex() <= ((LazyMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex()) || lazyListPositionedItem3 == lazyListPositionedItem) {
                    arrayList3.add(lazyListPositionedItem2);
                }
                i12++;
            }
            list = arrayList3;
        }
        return new LazyListMeasureResult(lazyMeasuredItem2, i11, z4, f2, measureResultInvoke, list, i13, i17, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4);
    }

    private static final int measureLazyList_7Xnphek$startIndex(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i) {
        return Math.min(lazyListBeyondBoundsInfo.getStart(), i - 1);
    }

    private static final int measureLazyList_7Xnphek$endIndex(LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, int i) {
        return Math.min(lazyListBeyondBoundsInfo.getEnd(), i - 1);
    }

    private static final List<LazyListPositionedItem> calculateItemsOffsets(List<LazyMeasuredItem> list, List<LazyMeasuredItem> list2, List<LazyMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = i3 < Math.min(i6, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr[i7] = list.get(calculateItemsOffsets$reverseAware(i7, z2, size)).getSize();
            }
            int[] iArr2 = new int[size];
            for (int i8 = 0; i8 < size; i8++) {
                iArr2[i8] = 0;
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
                    int size2 = iArr2[first];
                    LazyMeasuredItem lazyMeasuredItem = list.get(calculateItemsOffsets$reverseAware(first, z2, size));
                    if (z2) {
                        size2 = (i6 - size2) - lazyMeasuredItem.getSize();
                    }
                    arrayList.add(lazyMeasuredItem.position(size2, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size();
            int sizeWithSpacings = i5;
            for (int i9 = 0; i9 < size3; i9++) {
                LazyMeasuredItem lazyMeasuredItem2 = list2.get(i9);
                sizeWithSpacings -= lazyMeasuredItem2.getSizeWithSpacings();
                arrayList.add(lazyMeasuredItem2.position(sizeWithSpacings, i, i2));
            }
            int size4 = list.size();
            int sizeWithSpacings2 = i5;
            for (int i10 = 0; i10 < size4; i10++) {
                LazyMeasuredItem lazyMeasuredItem3 = list.get(i10);
                arrayList.add(lazyMeasuredItem3.position(sizeWithSpacings2, i, i2));
                sizeWithSpacings2 += lazyMeasuredItem3.getSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i11 = 0; i11 < size5; i11++) {
                LazyMeasuredItem lazyMeasuredItem4 = list3.get(i11);
                arrayList.add(lazyMeasuredItem4.position(sizeWithSpacings2, i, i2));
                sizeWithSpacings2 += lazyMeasuredItem4.getSizeWithSpacings();
            }
        }
        return arrayList;
    }
}
