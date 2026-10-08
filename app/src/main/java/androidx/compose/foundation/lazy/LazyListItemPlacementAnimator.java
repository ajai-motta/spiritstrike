package androidx.compose.foundation.lazy;

import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: LazyListItemPlacementAnimator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J[\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#J;\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+J<\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u00020!022\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020-J\u0018\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\fH\u0002J\"\u00109\u001a\u00020\t*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010:\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001c\u0010;\u001a\u00020\u0014*\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b<\u0010=R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t*\u00020\u00148BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/ItemInfo;", "positionedKeys", "", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", FirebaseAnalytics.Param.INDEX, "sizeWithSpacings", "averageItemsSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", "fallback", "visibleItems", "", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "calculateExpectedOffset-diAxcj4", "(IIIJZIILjava/util/List;)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "item", "itemInfo", "getItemSize", "itemIndex", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LazyListItemPlacementAnimator {
    private final boolean isVertical;
    private Map<Object, Integer> keyToIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap;
    private final Set<Object> positionedKeys;
    private final CoroutineScope scope;
    private int viewportEndItemIndex;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex;
    private int viewportStartItemNotVisiblePartSize;

    public LazyListItemPlacementAnimator(CoroutineScope scope, boolean z) {
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
    public final long m540getAnimatedOffsetYT5a7pE(Object key, int placeableIndex, int minOffset, int maxOffset, long rawOffset) {
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
        if (placeableInfo.getInProgress() && ((m538getMainAxisgyyYBs(jIntOffset2) < minOffset && m538getMainAxisgyyYBs(jIntOffset) < minOffset) || (m538getMainAxisgyyYBs(jIntOffset2) > maxOffset && m538getMainAxisgyyYBs(jIntOffset) > maxOffset))) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, null), 3, null);
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

    /* JADX INFO: renamed from: calculateExpectedOffset-diAxcj4, reason: not valid java name */
    private final int m537calculateExpectedOffsetdiAxcj4(int index, int sizeWithSpacings, int averageItemsSize, long scrolledBy, boolean reverseLayout, int mainAxisLayoutSize, int fallback, List<LazyListPositionedItem> visibleItems) {
        IntRange intRangeUntil;
        IntRange intRangeUntil2;
        int itemSize = 0;
        int i = this.viewportEndItemIndex;
        boolean z = reverseLayout ? i > index : i < index;
        int i2 = this.viewportStartItemIndex;
        boolean z2 = reverseLayout ? i2 < index : i2 > index;
        if (z) {
            if (!reverseLayout) {
                intRangeUntil2 = RangesKt.until(this.viewportEndItemIndex + 1, index);
            } else {
                intRangeUntil2 = RangesKt.until(index + 1, this.viewportEndItemIndex);
            }
            int first = intRangeUntil2.getFirst();
            int last = intRangeUntil2.getLast();
            if (first <= last) {
                while (true) {
                    itemSize += getItemSize(visibleItems, first, averageItemsSize);
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            return mainAxisLayoutSize + this.viewportEndItemNotVisiblePartSize + itemSize + m538getMainAxisgyyYBs(scrolledBy);
        }
        if (!z2) {
            return fallback;
        }
        if (!reverseLayout) {
            intRangeUntil = RangesKt.until(index + 1, this.viewportStartItemIndex);
        } else {
            intRangeUntil = RangesKt.until(this.viewportStartItemIndex + 1, index);
        }
        int first2 = intRangeUntil.getFirst();
        int last2 = intRangeUntil.getLast();
        if (first2 <= last2) {
            while (true) {
                sizeWithSpacings += getItemSize(visibleItems, first2, averageItemsSize);
                if (first2 == last2) {
                    break;
                }
                first2++;
            }
        }
        return (this.viewportStartItemNotVisiblePartSize - sizeWithSpacings) + m538getMainAxisgyyYBs(scrolledBy);
    }

    private final int getItemSize(List<LazyListPositionedItem> list, int i, int i2) {
        if (!list.isEmpty() && i >= ((LazyListPositionedItem) CollectionsKt.first((List) list)).getIndex() && i <= ((LazyListPositionedItem) CollectionsKt.last((List) list)).getIndex()) {
            if (i - ((LazyListPositionedItem) CollectionsKt.first((List) list)).getIndex() < ((LazyListPositionedItem) CollectionsKt.last((List) list)).getIndex() - i) {
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    LazyListPositionedItem lazyListPositionedItem = list.get(i3);
                    if (lazyListPositionedItem.getIndex() == i) {
                        return lazyListPositionedItem.getSizeWithSpacings();
                    }
                    if (lazyListPositionedItem.getIndex() > i) {
                        break;
                    }
                }
            } else {
                for (int lastIndex = CollectionsKt.getLastIndex(list); -1 < lastIndex; lastIndex--) {
                    LazyListPositionedItem lazyListPositionedItem2 = list.get(lastIndex);
                    if (lazyListPositionedItem2.getIndex() == i) {
                        return lazyListPositionedItem2.getSizeWithSpacings();
                    }
                    if (lazyListPositionedItem2.getIndex() < i) {
                        break;
                    }
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startAnimationsIfNeeded(androidx.compose.foundation.lazy.LazyListPositionedItem r18, androidx.compose.foundation.lazy.ItemInfo r19) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListItemPlacementAnimator.startAnimationsIfNeeded(androidx.compose.foundation.lazy.LazyListPositionedItem, androidx.compose.foundation.lazy.ItemInfo):void");
    }

    /* JADX INFO: renamed from: toOffset-Bjo55l4, reason: not valid java name */
    private final long m539toOffsetBjo55l4(int i) {
        boolean z = this.isVertical;
        int i2 = z ? 0 : i;
        if (!z) {
            i = 0;
        }
        return IntOffsetKt.IntOffset(i2, i);
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m538getMainAxisgyyYBs(long j) {
        return this.isVertical ? IntOffset.m4006getYimpl(j) : IntOffset.m4005getXimpl(j);
    }

    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, boolean reverseLayout, List<LazyListPositionedItem> positionedItems, LazyMeasuredItemProvider itemProvider) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int iM538getMainAxisgyyYBs;
        long j;
        ItemInfo itemInfo;
        LazyListPositionedItem lazyListPositionedItem;
        int iM537calculateExpectedOffsetdiAxcj4;
        long jM4001copyiSbpLlY$default;
        LazyMeasuredItemProvider itemProvider2 = itemProvider;
        Intrinsics.checkNotNullParameter(positionedItems, "positionedItems");
        Intrinsics.checkNotNullParameter(itemProvider2, "itemProvider");
        int size = positionedItems.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            if (positionedItems.get(i4).getHasAnimations()) {
                int i5 = this.isVertical ? layoutHeight : layoutWidth;
                long jM539toOffsetBjo55l4 = m539toOffsetBjo55l4(reverseLayout ? -consumedScroll : consumedScroll);
                LazyListPositionedItem lazyListPositionedItem2 = (LazyListPositionedItem) CollectionsKt.first((List) positionedItems);
                LazyListPositionedItem lazyListPositionedItem3 = (LazyListPositionedItem) CollectionsKt.last((List) positionedItems);
                int size2 = positionedItems.size();
                int i6 = i3;
                int sizeWithSpacings = i6;
                while (i6 < size2) {
                    LazyListPositionedItem lazyListPositionedItem4 = positionedItems.get(i6);
                    ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyListPositionedItem4.getKey());
                    if (itemInfo2 != null) {
                        itemInfo2.setIndex(lazyListPositionedItem4.getIndex());
                    }
                    sizeWithSpacings += lazyListPositionedItem4.getSizeWithSpacings();
                    i6++;
                }
                int size3 = sizeWithSpacings / positionedItems.size();
                this.positionedKeys.clear();
                int size4 = positionedItems.size();
                int i7 = i3;
                while (i7 < size4) {
                    LazyListPositionedItem lazyListPositionedItem5 = positionedItems.get(i7);
                    this.positionedKeys.add(lazyListPositionedItem5.getKey());
                    ItemInfo itemInfo3 = this.keyToItemInfoMap.get(lazyListPositionedItem5.getKey());
                    if (itemInfo3 == null) {
                        if (lazyListPositionedItem5.getHasAnimations()) {
                            ItemInfo itemInfo4 = new ItemInfo(lazyListPositionedItem5.getIndex());
                            Integer num = this.keyToIndexMap.get(lazyListPositionedItem5.getKey());
                            long jM548getOffsetBjo55l4 = lazyListPositionedItem5.m548getOffsetBjo55l4(i3);
                            int mainAxisSize = lazyListPositionedItem5.getMainAxisSize(i3);
                            if (num == null) {
                                iM537calculateExpectedOffsetdiAxcj4 = m538getMainAxisgyyYBs(jM548getOffsetBjo55l4);
                                j = jM548getOffsetBjo55l4;
                                itemInfo = itemInfo4;
                                lazyListPositionedItem = lazyListPositionedItem5;
                                i = i7;
                                i2 = size4;
                            } else {
                                if (!reverseLayout) {
                                    iM538getMainAxisgyyYBs = m538getMainAxisgyyYBs(jM548getOffsetBjo55l4);
                                } else {
                                    iM538getMainAxisgyyYBs = (m538getMainAxisgyyYBs(jM548getOffsetBjo55l4) - lazyListPositionedItem5.getSizeWithSpacings()) + mainAxisSize;
                                }
                                j = jM548getOffsetBjo55l4;
                                itemInfo = itemInfo4;
                                lazyListPositionedItem = lazyListPositionedItem5;
                                i = i7;
                                i2 = size4;
                                iM537calculateExpectedOffsetdiAxcj4 = m537calculateExpectedOffsetdiAxcj4(num.intValue(), lazyListPositionedItem5.getSizeWithSpacings(), size3, jM539toOffsetBjo55l4, reverseLayout, i5, iM538getMainAxisgyyYBs, positionedItems) + (reverseLayout ? lazyListPositionedItem.getSize() - mainAxisSize : i3);
                            }
                            if (this.isVertical) {
                                jM4001copyiSbpLlY$default = IntOffset.m4001copyiSbpLlY$default(j, 0, iM537calculateExpectedOffsetdiAxcj4, 1, null);
                            } else {
                                jM4001copyiSbpLlY$default = IntOffset.m4001copyiSbpLlY$default(j, iM537calculateExpectedOffsetdiAxcj4, 0, 2, null);
                            }
                            int placeablesCount = lazyListPositionedItem.getPlaceablesCount();
                            for (int i8 = i3; i8 < placeablesCount; i8++) {
                                LazyListPositionedItem lazyListPositionedItem6 = lazyListPositionedItem;
                                long jM548getOffsetBjo55l42 = lazyListPositionedItem6.m548getOffsetBjo55l4(i8);
                                long jIntOffset = IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(jM548getOffsetBjo55l42) - IntOffset.m4005getXimpl(j), IntOffset.m4006getYimpl(jM548getOffsetBjo55l42) - IntOffset.m4006getYimpl(j));
                                itemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(jM4001copyiSbpLlY$default) + IntOffset.m4005getXimpl(jIntOffset), IntOffset.m4006getYimpl(jM4001copyiSbpLlY$default) + IntOffset.m4006getYimpl(jIntOffset)), lazyListPositionedItem6.getMainAxisSize(i8), null));
                                Unit unit = Unit.INSTANCE;
                            }
                            LazyListPositionedItem lazyListPositionedItem7 = lazyListPositionedItem;
                            ItemInfo itemInfo5 = itemInfo;
                            this.keyToItemInfoMap.put(lazyListPositionedItem7.getKey(), itemInfo5);
                            startAnimationsIfNeeded(lazyListPositionedItem7, itemInfo5);
                        } else {
                            i = i7;
                            i2 = size4;
                        }
                    } else {
                        i = i7;
                        i2 = size4;
                        if (lazyListPositionedItem5.getHasAnimations()) {
                            long notAnimatableDelta = itemInfo3.getNotAnimatableDelta();
                            itemInfo3.m528setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(notAnimatableDelta) + IntOffset.m4005getXimpl(jM539toOffsetBjo55l4), IntOffset.m4006getYimpl(notAnimatableDelta) + IntOffset.m4006getYimpl(jM539toOffsetBjo55l4)));
                            startAnimationsIfNeeded(lazyListPositionedItem5, itemInfo3);
                        } else {
                            this.keyToItemInfoMap.remove(lazyListPositionedItem5.getKey());
                        }
                    }
                    i7 = i + 1;
                    size4 = i2;
                    i3 = 0;
                }
                if (!reverseLayout) {
                    this.viewportStartItemIndex = lazyListPositionedItem2.getIndex();
                    this.viewportStartItemNotVisiblePartSize = lazyListPositionedItem2.getOffset();
                    this.viewportEndItemIndex = lazyListPositionedItem3.getIndex();
                    this.viewportEndItemNotVisiblePartSize = (lazyListPositionedItem3.getOffset() + lazyListPositionedItem3.getSizeWithSpacings()) - i5;
                } else {
                    this.viewportStartItemIndex = lazyListPositionedItem3.getIndex();
                    this.viewportStartItemNotVisiblePartSize = (i5 - lazyListPositionedItem3.getOffset()) - lazyListPositionedItem3.getSize();
                    this.viewportEndItemIndex = lazyListPositionedItem2.getIndex();
                    this.viewportEndItemNotVisiblePartSize = (-lazyListPositionedItem2.getOffset()) + (lazyListPositionedItem2.getSizeWithSpacings() - lazyListPositionedItem2.getSize());
                }
                Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, ItemInfo> next = it.next();
                    if (!this.positionedKeys.contains(next.getKey())) {
                        ItemInfo value = next.getValue();
                        long notAnimatableDelta2 = value.getNotAnimatableDelta();
                        value.m528setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(notAnimatableDelta2) + IntOffset.m4005getXimpl(jM539toOffsetBjo55l4), IntOffset.m4006getYimpl(notAnimatableDelta2) + IntOffset.m4006getYimpl(jM539toOffsetBjo55l4)));
                        Integer num2 = itemProvider.getKeyToIndexMap().get(next.getKey());
                        List<PlaceableInfo> placeables = value.getPlaceables();
                        int size5 = placeables.size();
                        int i9 = 0;
                        while (true) {
                            if (i9 >= size5) {
                                z = false;
                                break;
                            }
                            PlaceableInfo placeableInfo = placeables.get(i9);
                            long targetOffset = placeableInfo.getTargetOffset();
                            long notAnimatableDelta3 = value.getNotAnimatableDelta();
                            long jIntOffset2 = IntOffsetKt.IntOffset(IntOffset.m4005getXimpl(targetOffset) + IntOffset.m4005getXimpl(notAnimatableDelta3), IntOffset.m4006getYimpl(targetOffset) + IntOffset.m4006getYimpl(notAnimatableDelta3));
                            if (m538getMainAxisgyyYBs(jIntOffset2) + placeableInfo.getSize() > 0 && m538getMainAxisgyyYBs(jIntOffset2) < i5) {
                                z = true;
                                break;
                            }
                            i9++;
                        }
                        List<PlaceableInfo> placeables2 = value.getPlaceables();
                        int size6 = placeables2.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size6) {
                                z2 = false;
                                break;
                            } else {
                                if (placeables2.get(i10).getInProgress()) {
                                    z2 = true;
                                    break;
                                }
                                i10++;
                            }
                        }
                        boolean z3 = !z2;
                        if ((!z && z3) || num2 == null || value.getPlaceables().isEmpty()) {
                            it.remove();
                        } else {
                            LazyMeasuredItem lazyMeasuredItemM557getAndMeasureZjPyQlc = itemProvider2.m557getAndMeasureZjPyQlc(DataIndex.m515constructorimpl(num2.intValue()));
                            int iM537calculateExpectedOffsetdiAxcj42 = m537calculateExpectedOffsetdiAxcj4(num2.intValue(), lazyMeasuredItemM557getAndMeasureZjPyQlc.getSizeWithSpacings(), size3, jM539toOffsetBjo55l4, reverseLayout, i5, i5, positionedItems);
                            if (reverseLayout) {
                                iM537calculateExpectedOffsetdiAxcj42 = (i5 - iM537calculateExpectedOffsetdiAxcj42) - lazyMeasuredItemM557getAndMeasureZjPyQlc.getSize();
                            }
                            LazyListPositionedItem lazyListPositionedItemPosition = lazyMeasuredItemM557getAndMeasureZjPyQlc.position(iM537calculateExpectedOffsetdiAxcj42, layoutWidth, layoutHeight);
                            positionedItems.add(lazyListPositionedItemPosition);
                            startAnimationsIfNeeded(lazyListPositionedItemPosition, value);
                        }
                    }
                    itemProvider2 = itemProvider;
                }
                this.keyToIndexMap = itemProvider.getKeyToIndexMap();
                return;
            }
            i4++;
            itemProvider2 = itemProvider;
            i3 = 0;
        }
        reset();
    }
}
