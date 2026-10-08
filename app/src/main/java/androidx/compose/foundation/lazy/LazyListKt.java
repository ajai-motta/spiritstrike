package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyList.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u008e\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0017\u0010\u0016\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u001d\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002\u001a\u0097\u0001\u0010$\u001a\u0019\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(0%¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020,H\u0003ø\u0001\u0000¢\u0006\u0002\u0010-\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"LazyList", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "rememberLazyListMeasurePolicy", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/LazyListItemProvider;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;Landroidx/compose/runtime/Composer;III)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyListKt {
    /* JADX WARN: Removed duplicated region for block: B:106:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LazyList(final androidx.compose.ui.Modifier r34, final androidx.compose.foundation.lazy.LazyListState r35, final androidx.compose.foundation.layout.PaddingValues r36, final boolean r37, final boolean r38, final androidx.compose.foundation.gestures.FlingBehavior r39, final boolean r40, androidx.compose.ui.Alignment.Horizontal r41, androidx.compose.foundation.layout.Arrangement.Vertical r42, androidx.compose.ui.Alignment.Vertical r43, androidx.compose.foundation.layout.Arrangement.Horizontal r44, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.LazyListScope, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 967
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListKt.LazyList(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.LazyListState, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.ui.Alignment$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalFoundationApi
    public static final void ScrollPositionUpdater(final LazyListItemProvider lazyListItemProvider, final LazyListState lazyListState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(3173830);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollPositionUpdater):LazyList.kt#428nma");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(lazyListItemProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyListState) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (lazyListItemProvider.getItemCount() > 0) {
                lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider);
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListKt.ScrollPositionUpdater.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i3) {
                LazyListKt.ScrollPositionUpdater(lazyListItemProvider, lazyListState, composer2, i | 1);
            }
        });
    }

    @ExperimentalFoundationApi
    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyListMeasurePolicy(final LazyListItemProvider lazyListItemProvider, final LazyListState lazyListState, final LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, final OverscrollEffect overscrollEffect, final PaddingValues paddingValues, final boolean z, final boolean z2, Alignment.Horizontal horizontal, Alignment.Vertical vertical, Arrangement.Horizontal horizontal2, Arrangement.Vertical vertical2, final LazyListItemPlacementAnimator lazyListItemPlacementAnimator, Composer composer, int i, int i2, int i3) {
        composer.startReplaceableGroup(-1404987696);
        ComposerKt.sourceInformation(composer, "C(rememberLazyListMeasurePolicy)P(5,9!1,6!1,8,4!1,10!1,11)183@7919L6558:LazyList.kt#428nma");
        final Alignment.Horizontal horizontal3 = (i3 & 128) != 0 ? null : horizontal;
        final Alignment.Vertical vertical3 = (i3 & 256) != 0 ? null : vertical;
        final Arrangement.Horizontal horizontal4 = (i3 & 512) != 0 ? null : horizontal2;
        final Arrangement.Vertical vertical4 = (i3 & 1024) != 0 ? null : vertical2;
        Object[] objArr = {lazyListState, lazyListBeyondBoundsInfo, overscrollEffect, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal3, vertical3, horizontal4, vertical4, lazyListItemPlacementAnimator};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = false;
        for (int i4 = 0; i4 < 11; i4++) {
            zChanged |= composer.changed(objArr[i4]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyListMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m541invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyListMeasureResult m541invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i5;
                    int i6;
                    int i7;
                    float spacing;
                    int iM3831getMaxWidthimpl;
                    long jIntOffset;
                    Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
                    CheckScrollableContainerConstraintsKt.m190checkScrollableContainerConstraintsK40F9xA(j, z2 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z2) {
                        i5 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(paddingValues.mo408calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z2) {
                        i6 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(paddingValues.mo409calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i6 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i8 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(paddingValues.getTop());
                    int i9 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(paddingValues.getBottom());
                    final int i10 = i8 + i9;
                    final int i11 = i5 + i6;
                    boolean z3 = z2;
                    int i12 = z3 ? i10 : i11;
                    if (z3 && !z) {
                        i7 = i8;
                    } else if (z3 && z) {
                        i7 = i9;
                    } else {
                        i7 = (z3 || z) ? i6 : i5;
                    }
                    final int i13 = i12 - i7;
                    long jM3847offsetNN6EwU = ConstraintsKt.m3847offsetNN6EwU(j, -i11, -i10);
                    lazyListState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider);
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    lazyListState.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    lazyListItemProvider.getItemScope().m532setMaxWidth0680j_4(lazyLayoutMeasureScope.mo314toDpu2uoSUM(Constraints.m3831getMaxWidthimpl(jM3847offsetNN6EwU)));
                    lazyListItemProvider.getItemScope().m531setMaxHeight0680j_4(lazyLayoutMeasureScope.mo314toDpu2uoSUM(Constraints.m3830getMaxHeightimpl(jM3847offsetNN6EwU)));
                    if (z2) {
                        Arrangement.Vertical vertical5 = vertical4;
                        if (vertical5 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = vertical5.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal5 = horizontal4;
                        if (horizontal5 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = horizontal5.getSpacing();
                    }
                    final int i14 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(spacing);
                    final int itemCount = lazyListItemProvider.getItemCount();
                    if (z2) {
                        iM3831getMaxWidthimpl = Constraints.m3830getMaxHeightimpl(j) - i10;
                    } else {
                        iM3831getMaxWidthimpl = Constraints.m3831getMaxWidthimpl(j) - i11;
                    }
                    int i15 = iM3831getMaxWidthimpl;
                    if (!z || i15 > 0) {
                        jIntOffset = IntOffsetKt.IntOffset(i5, i8);
                    } else {
                        boolean z4 = z2;
                        if (!z4) {
                            i5 += i15;
                        }
                        if (z4) {
                            i8 += i15;
                        }
                        jIntOffset = IntOffsetKt.IntOffset(i5, i8);
                    }
                    final long j2 = jIntOffset;
                    final boolean z5 = z2;
                    LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
                    final Alignment.Horizontal horizontal6 = horizontal3;
                    final Alignment.Vertical vertical6 = vertical3;
                    final boolean z6 = z;
                    final LazyListItemPlacementAnimator lazyListItemPlacementAnimator2 = lazyListItemPlacementAnimator;
                    final int i16 = i7;
                    LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(jM3847offsetNN6EwU, z5, lazyListItemProvider2, lazyLayoutMeasureScope, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
                        @Override // androidx.compose.foundation.lazy.MeasuredItemFactory
                        /* JADX INFO: renamed from: createItem-HK0c1C0, reason: not valid java name */
                        public final LazyMeasuredItem mo542createItemHK0c1C0(int i17, Object key, Placeable[] placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyMeasuredItem(i17, placeables, z5, horizontal6, vertical6, lazyLayoutMeasureScope.getLayoutDirection(), z6, i16, i13, lazyListItemPlacementAnimator2, i17 == itemCount + (-1) ? 0 : i14, j2, key, null);
                        }
                    }, null);
                    lazyListState.m556setPremeasureConstraintsBRTryo0$foundation_release(lazyMeasuredItemProvider.getChildConstraints());
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyListState lazyListState2 = lazyListState;
                    Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                        try {
                            int iM515constructorimpl = DataIndex.m515constructorimpl(lazyListState2.getFirstVisibleItemIndex());
                            int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
                            Unit unit = Unit.INSTANCE;
                            snapshotCreateNonObservableSnapshot.dispose();
                            LazyListMeasureResult lazyListMeasureResultM546measureLazyList7Xnphek = LazyListMeasureKt.m546measureLazyList7Xnphek(itemCount, lazyMeasuredItemProvider, i15, i7, i13, iM515constructorimpl, firstVisibleItemScrollOffset, lazyListState.getScrollToBeConsumed(), jM3847offsetNN6EwU, z2, lazyListItemProvider.getHeaderIndexes(), vertical4, horizontal4, z, lazyLayoutMeasureScope2, lazyListItemPlacementAnimator, lazyListBeyondBoundsInfo, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ MeasureResult invoke(Integer num, Integer num2, Function1<? super Placeable.PlacementScope, ? extends Unit> function1) {
                                    return invoke(num.intValue(), num2.intValue(), (Function1<? super Placeable.PlacementScope, Unit>) function1);
                                }

                                public final MeasureResult invoke(int i17, int i18, Function1<? super Placeable.PlacementScope, Unit> placement) {
                                    Intrinsics.checkNotNullParameter(placement, "placement");
                                    return lazyLayoutMeasureScope.layout(ConstraintsKt.m3845constrainWidthK40F9xA(j, i17 + i11), ConstraintsKt.m3844constrainHeightK40F9xA(j, i18 + i10), MapsKt.emptyMap(), placement);
                                }
                            });
                            LazyListState lazyListState3 = lazyListState;
                            OverscrollEffect overscrollEffect2 = overscrollEffect;
                            lazyListState3.applyMeasureResult$foundation_release(lazyListMeasureResultM546measureLazyList7Xnphek);
                            LazyListKt.refreshOverscrollInfo(overscrollEffect2, lazyListMeasureResultM546measureLazyList7Xnphek);
                            return lazyListMeasureResultM546measureLazyList7Xnphek;
                        } finally {
                            snapshotCreateNonObservableSnapshot.restoreCurrent(snapshotMakeCurrent);
                        }
                    } catch (Throwable th) {
                        snapshotCreateNonObservableSnapshot.dispose();
                        throw th;
                    }
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function2 = (Function2) objRememberedValue;
        composer.endReplaceableGroup();
        return function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyListMeasureResult lazyListMeasureResult) {
        boolean canScrollForward = lazyListMeasureResult.getCanScrollForward();
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        overscrollEffect.setEnabled(canScrollForward || ((firstVisibleItem != null && firstVisibleItem.getIndex() != 0) || lazyListMeasureResult.getFirstVisibleItemScrollOffset() != 0));
    }
}
