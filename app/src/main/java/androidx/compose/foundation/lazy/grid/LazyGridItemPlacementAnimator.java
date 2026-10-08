package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyGridItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JM\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J;\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)JD\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020+J\u0018\u00105\u001a\u00020+2\u0006\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\fH\u0002J\u001c\u00108\u001a\u00020\u0015*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b9\u0010:R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\t*\u00020\u00158BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "positionedKeys", "", "slotsPerLine", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", FirebaseAnalytics.Param.INDEX, "mainAxisSizeWithSpacings", "averageLineMainAxisSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", "fallback", "calculateExpectedOffset-tGxSNXI", "(IIIJZII)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "item", "itemInfo", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LazyGridItemPlacementAnimator {
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap;
    private final Set<Object> positionedKeys;
    private final CoroutineScope scope;
    private int slotsPerLine;
    private int viewportEndItemIndex;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex;
    private int viewportStartItemNotVisiblePartSize;

    public LazyGridItemPlacementAnimator(CoroutineScope scope, boolean z) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.isVertical = z;
        this.keyToItemInfoMap = new LinkedHashMap();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportEndItemIndex = -1;
        this.positionedKeys = new LinkedHashSet();
    }

    /* JADX INFO: renamed from: getAnimatedOffset-YT5a7pE, reason: not valid java name */
    public final long m596getAnimatedOffsetYT5a7pE(Object key, int placeableIndex, int minOffset, int maxOffset, long rawOffset) {
        Intrinsics.checkNotNullParameter(key, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null) {
            return rawOffset;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(placeableIndex);
        long packedValue = placeableInfo.getAnimatedOffset().getValue().getPackedValue();
        long notAnimatableDelta = itemInfo.getNotAnimatableDelta();
        long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(packedValue) + IntOffset.m4005getXimpl(notAnimatableDelta), IntOffset.m4006getYimpl(packedValue) + IntOffset.m4006getYimpl(notAnimatableDelta));
        long targetOffset = placeableInfo.getTargetOffset();
        long notAnimatableDelta2 = itemInfo.getNotAnimatableDelta();
        long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(targetOffset) + IntOffset.m4005getXimpl(notAnimatableDelta2), IntOffset.m4006getYimpl(targetOffset) + IntOffset.m4006getYimpl(notAnimatableDelta2));
        if (placeableInfo.getInProgress() && ((m594getMainAxisgyyYBs(jIntOffset2) < minOffset && m594getMainAxisgyyYBs(jIntOffset) < minOffset) || (m594getMainAxisgyyYBs(jIntOffset2) > maxOffset && m594getMainAxisgyyYBs(jIntOffset) > maxOffset))) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyGridItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, null);
        }
        return jIntOffset;
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportStartItemNotVisiblePartSize = 0;
        this.viewportEndItemIndex = -1;
        this.viewportEndItemNotVisiblePartSize = 0;
    }

    /* JADX INFO: renamed from: calculateExpectedOffset-tGxSNXI, reason: not valid java name */
    private final int m593calculateExpectedOffsettGxSNXI(int index, int mainAxisSizeWithSpacings, int averageLineMainAxisSize, long scrolledBy, boolean reverseLayout, int mainAxisLayoutSize, int fallback) {
        if (this.slotsPerLine == 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        boolean z = false;
        int i = this.viewportEndItemIndex;
        boolean z2 = reverseLayout ? i > index : i < index;
        if (reverseLayout ? this.viewportStartItemIndex < index : this.viewportStartItemIndex > index) {
            z = true;
        }
        if (z2) {
            int iAbs = Math.abs(index - this.viewportEndItemIndex);
            int i2 = this.slotsPerLine;
            return mainAxisLayoutSize + this.viewportEndItemNotVisiblePartSize + (averageLineMainAxisSize * ((((iAbs + i2) - 1) / i2) - 1)) + m594getMainAxisgyyYBs(scrolledBy);
        }
        if (!z) {
            return fallback;
        }
        int iAbs2 = Math.abs(this.viewportStartItemIndex - index);
        int i3 = this.slotsPerLine;
        return ((this.viewportStartItemNotVisiblePartSize - mainAxisSizeWithSpacings) - (averageLineMainAxisSize * ((((iAbs2 + i3) - 1) / i3) - 1))) + m594getMainAxisgyyYBs(scrolledBy);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startAnimationsIfNeeded(androidx.compose.foundation.lazy.grid.LazyGridPositionedItem r18, androidx.compose.foundation.lazy.grid.ItemInfo r19) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator.startAnimationsIfNeeded(androidx.compose.foundation.lazy.grid.LazyGridPositionedItem, androidx.compose.foundation.lazy.grid.ItemInfo):void");
    }

    /* JADX INFO: renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m595toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m594getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m4006getYimpl(j) : IntOffset.m4005getXimpl(j);
    }

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, int slotsPerLine, boolean reverseLayout, final List<LazyGridPositionedItem> positionedItems, LazyMeasuredItemProvider measuredItemProvider) {
        boolean z;
        boolean z2;
        long jM3840fixedHeightOenEA2s;
        int i;
        int i2;
        int iM594getMainAxisgyyYBs;
        long j;
        ItemInfo itemInfo;
        LazyGridPositionedItem lazyGridPositionedItem;
        int iM593calculateExpectedOffsettGxSNXI;
        long jM4001copyiSbpLlY$default;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(measuredItemProvider, "measuredItemProvider");
        int size = positionedItems.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (positionedItems.get(i3).getHasAnimations()) {
                this.slotsPerLine = slotsPerLine;
                int i4 = this.isVertical ? layoutHeight : layoutWidth;
                long jM595toOffsetBjo55l4 = m595toOffsetBjo55l4(reverseLayout ? -consumedScroll : consumedScroll);
                LazyGridPositionedItem lazyGridPositionedItem2 = (LazyGridPositionedItem) CollectionsKt.first((List) positionedItems);
                LazyGridPositionedItem lazyGridPositionedItem3 = (LazyGridPositionedItem) CollectionsKt.last((List) positionedItems);
                int size2 = positionedItems.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    LazyGridPositionedItem lazyGridPositionedItem4 = positionedItems.get(i5);
                    ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyGridPositionedItem4.getKey());
                    if (itemInfo2 != null) {
                        itemInfo2.setIndex(lazyGridPositionedItem4.getIndex());
                        itemInfo2.setCrossAxisSize(lazyGridPositionedItem4.getCrossAxisSize());
                        itemInfo2.setCrossAxisOffset(lazyGridPositionedItem4.getCrossAxisOffset());
                    }
                }
                Function1<Integer, Integer> function1 = new Function1<Integer, Integer>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Integer invoke(int i6) {
                        return Integer.valueOf(this.$this_run.isVertical ? positionedItems.get(i6).getRow() : positionedItems.get(i6).getColumn());
                    }
                };
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (i6 < positionedItems.size()) {
                    int iIntValue = function1.invoke(Integer.valueOf(i6)).intValue();
                    if (iIntValue == -1) {
                        i6++;
                    } else {
                        int iMax = 0;
                        while (i6 < positionedItems.size() && function1.invoke(Integer.valueOf(i6)).intValue() == iIntValue) {
                            iMax = Math.max(iMax, positionedItems.get(i6).getMainAxisSizeWithSpacings());
                            i6++;
                        }
                        i7 += iMax;
                        i8++;
                    }
                }
                int i9 = i7 / i8;
                this.positionedKeys.clear();
                int i10 = 0;
                for (int size3 = positionedItems.size(); i10 < size3; size3 = i2) {
                    LazyGridPositionedItem lazyGridPositionedItem5 = positionedItems.get(i10);
                    this.positionedKeys.add(lazyGridPositionedItem5.getKey());
                    ItemInfo itemInfo3 = this.keyToItemInfoMap.get(lazyGridPositionedItem5.getKey());
                    if (itemInfo3 == null) {
                        if (lazyGridPositionedItem5.getHasAnimations()) {
                            ItemInfo itemInfo4 = new ItemInfo(lazyGridPositionedItem5.getIndex(), lazyGridPositionedItem5.getCrossAxisSize(), lazyGridPositionedItem5.getCrossAxisOffset());
                            Integer num = this.keyToIndexMap.get(lazyGridPositionedItem5.getKey());
                            long placeableOffset = lazyGridPositionedItem5.getPlaceableOffset();
                            if (num == null) {
                                iM593calculateExpectedOffsettGxSNXI = m594getMainAxisgyyYBs(placeableOffset);
                                j = placeableOffset;
                                itemInfo = itemInfo4;
                                lazyGridPositionedItem = lazyGridPositionedItem5;
                                i = i10;
                                i2 = size3;
                            } else {
                                if (!reverseLayout) {
                                    iM594getMainAxisgyyYBs = m594getMainAxisgyyYBs(placeableOffset);
                                } else {
                                    iM594getMainAxisgyyYBs = m594getMainAxisgyyYBs(placeableOffset) - lazyGridPositionedItem5.getMainAxisSizeWithSpacings();
                                }
                                j = placeableOffset;
                                itemInfo = itemInfo4;
                                lazyGridPositionedItem = lazyGridPositionedItem5;
                                i = i10;
                                i2 = size3;
                                iM593calculateExpectedOffsettGxSNXI = m593calculateExpectedOffsettGxSNXI(num.intValue(), lazyGridPositionedItem5.getMainAxisSizeWithSpacings(), i9, jM595toOffsetBjo55l4, reverseLayout, i4, iM594getMainAxisgyyYBs);
                            }
                            if (this.isVertical) {
                                jM4001copyiSbpLlY$default = IntOffset.m4001copyiSbpLlY$default(j, 0, iM593calculateExpectedOffsettGxSNXI, 1, null);
                            } else {
                                jM4001copyiSbpLlY$default = IntOffset.m4001copyiSbpLlY$default(j, iM593calculateExpectedOffsettGxSNXI, 0, 2, null);
                            }
                            int placeablesCount = lazyGridPositionedItem.getPlaceablesCount();
                            for (int i11 = 0; i11 < placeablesCount; i11++) {
                                itemInfo.getPlaceables().add(new PlaceableInfo(jM4001copyiSbpLlY$default, lazyGridPositionedItem.getMainAxisSize(i11), null));
                                Unit unit = Unit.INSTANCE;
                            }
                            LazyGridPositionedItem lazyGridPositionedItem6 = lazyGridPositionedItem;
                            ItemInfo itemInfo5 = itemInfo;
                            this.keyToItemInfoMap.put(lazyGridPositionedItem6.getKey(), itemInfo5);
                            startAnimationsIfNeeded(lazyGridPositionedItem6, itemInfo5);
                        } else {
                            i = i10;
                            i2 = size3;
                        }
                    } else {
                        i = i10;
                        i2 = size3;
                        if (lazyGridPositionedItem5.getHasAnimations()) {
                            long notAnimatableDelta = itemInfo3.getNotAnimatableDelta();
                            itemInfo3.m584setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(notAnimatableDelta) + IntOffset.m4005getXimpl(jM595toOffsetBjo55l4), IntOffset.m4006getYimpl(notAnimatableDelta) + IntOffset.m4006getYimpl(jM595toOffsetBjo55l4)));
                            startAnimationsIfNeeded(lazyGridPositionedItem5, itemInfo3);
                        } else {
                            this.keyToItemInfoMap.remove(lazyGridPositionedItem5.getKey());
                        }
                    }
                    i10 = i + 1;
                }
                if (!reverseLayout) {
                    this.viewportStartItemIndex = lazyGridPositionedItem2.getIndex();
                    this.viewportStartItemNotVisiblePartSize = m594getMainAxisgyyYBs(lazyGridPositionedItem2.getOffset());
                    this.viewportEndItemIndex = lazyGridPositionedItem3.getIndex();
                    this.viewportEndItemNotVisiblePartSize = (m594getMainAxisgyyYBs(lazyGridPositionedItem3.getOffset()) + lazyGridPositionedItem3.getLineMainAxisSizeWithSpacings()) - i4;
                } else {
                    this.viewportStartItemIndex = lazyGridPositionedItem3.getIndex();
                    this.viewportStartItemNotVisiblePartSize = (i4 - m594getMainAxisgyyYBs(lazyGridPositionedItem3.getOffset())) - lazyGridPositionedItem3.getLineMainAxisSize();
                    this.viewportEndItemIndex = lazyGridPositionedItem2.getIndex();
                    this.viewportEndItemNotVisiblePartSize = (-m594getMainAxisgyyYBs(lazyGridPositionedItem2.getOffset())) + (lazyGridPositionedItem2.getLineMainAxisSizeWithSpacings() - (this.isVertical ? IntSize.m4046getHeightimpl(lazyGridPositionedItem2.getSize()) : IntSize.m4047getWidthimpl(lazyGridPositionedItem2.getSize())));
                }
                Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, ItemInfo> next = it.next();
                    if (!this.positionedKeys.contains(next.getKey())) {
                        ItemInfo value = next.getValue();
                        long notAnimatableDelta2 = value.getNotAnimatableDelta();
                        value.m584setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(notAnimatableDelta2) + IntOffset.m4005getXimpl(jM595toOffsetBjo55l4), IntOffset.m4006getYimpl(notAnimatableDelta2) + IntOffset.m4006getYimpl(jM595toOffsetBjo55l4)));
                        Integer num2 = measuredItemProvider.getKeyToIndexMap().get(next.getKey());
                        List<PlaceableInfo> placeables = value.getPlaceables();
                        int size4 = placeables.size();
                        int i12 = 0;
                        while (true) {
                            if (i12 >= size4) {
                                z = false;
                                break;
                            }
                            PlaceableInfo placeableInfo = placeables.get(i12);
                            long targetOffset = placeableInfo.getTargetOffset();
                            long notAnimatableDelta3 = value.getNotAnimatableDelta();
                            long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(targetOffset) + IntOffset.m4005getXimpl(notAnimatableDelta3), IntOffset.m4006getYimpl(targetOffset) + IntOffset.m4006getYimpl(notAnimatableDelta3));
                            if (m594getMainAxisgyyYBs(jIntOffset) + placeableInfo.getMainAxisSize() > 0 && m594getMainAxisgyyYBs(jIntOffset) < i4) {
                                z = true;
                                break;
                            }
                            i12++;
                        }
                        List<PlaceableInfo> placeables2 = value.getPlaceables();
                        int size5 = placeables2.size();
                        int i13 = 0;
                        while (true) {
                            if (i13 >= size5) {
                                z2 = false;
                                break;
                            } else {
                                if (placeables2.get(i13).getInProgress()) {
                                    z2 = true;
                                    break;
                                }
                                i13++;
                            }
                        }
                        boolean z3 = !z2;
                        if ((!z && z3) || num2 == null || value.getPlaceables().isEmpty()) {
                            it.remove();
                        } else {
                            int iM572constructorimpl = ItemIndex.m572constructorimpl(num2.intValue());
                            if (this.isVertical) {
                                jM3840fixedHeightOenEA2s = Constraints.INSTANCE.m3841fixedWidthOenEA2s(value.getCrossAxisSize());
                            } else {
                                jM3840fixedHeightOenEA2s = Constraints.INSTANCE.m3840fixedHeightOenEA2s(value.getCrossAxisSize());
                            }
                            LazyMeasuredItem lazyMeasuredItemM617getAndMeasureednRnyU$default = LazyMeasuredItemProvider.m617getAndMeasureednRnyU$default(measuredItemProvider, iM572constructorimpl, 0, jM3840fixedHeightOenEA2s, 2, null);
                            int iM593calculateExpectedOffsettGxSNXI2 = m593calculateExpectedOffsettGxSNXI(num2.intValue(), lazyMeasuredItemM617getAndMeasureednRnyU$default.getMainAxisSizeWithSpacings(), i9, jM595toOffsetBjo55l4, reverseLayout, i4, i4);
                            if (reverseLayout) {
                                iM593calculateExpectedOffsettGxSNXI2 = (i4 - iM593calculateExpectedOffsettGxSNXI2) - lazyMeasuredItemM617getAndMeasureednRnyU$default.getMainAxisSize();
                            }
                            LazyGridPositionedItem lazyGridPositionedItemPosition = lazyMeasuredItemM617getAndMeasureednRnyU$default.position(iM593calculateExpectedOffsettGxSNXI2, value.getCrossAxisOffset(), layoutWidth, layoutHeight, -1, -1, lazyMeasuredItemM617getAndMeasureednRnyU$default.getMainAxisSize());
                            positionedItems.add(lazyGridPositionedItemPosition);
                            startAnimationsIfNeeded(lazyGridPositionedItemPosition, value);
                        }
                    }
                }
                this.keyToIndexMap = measuredItemProvider.getKeyToIndexMap();
                return;
            }
        }
        reset();
    }
}
