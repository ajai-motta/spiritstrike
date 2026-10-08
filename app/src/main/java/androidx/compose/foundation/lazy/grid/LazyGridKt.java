package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LazyGrid.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u009e\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\fH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010 \u001a\u0018\u0010!\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u009c\u0001\u0010&\u001a\u0019\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020(0\u0007¢\u0006\u0002\b\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#2#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0007¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010)\u001a\u00020*H\u0003ø\u0001\u0000¢\u0006\u0002\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"LazyGrid", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "slotSizesSums", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/Constraints;", "", "", "Lkotlin/ExtensionFunctionType;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "isVertical", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridScope;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/grid/LazyGridState;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "ScrollPositionUpdater", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/runtime/Composer;I)V", "refreshOverscrollInfo", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "result", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "rememberLazyGridMeasurePolicy", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureResult;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridState;Landroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;ZZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function2;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LazyGridKt {
    /* JADX WARN: Removed duplicated region for block: B:107:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void LazyGrid(androidx.compose.ui.Modifier r35, final androidx.compose.foundation.lazy.grid.LazyGridState r36, final kotlin.jvm.functions.Function2<? super androidx.compose.ui.unit.Density, ? super androidx.compose.ui.unit.Constraints, ? extends java.util.List<java.lang.Integer>> r37, androidx.compose.foundation.layout.PaddingValues r38, boolean r39, final boolean r40, androidx.compose.foundation.gestures.FlingBehavior r41, final boolean r42, final androidx.compose.foundation.layout.Arrangement.Vertical r43, final androidx.compose.foundation.layout.Arrangement.Horizontal r44, final kotlin.jvm.functions.Function1<? super androidx.compose.foundation.lazy.grid.LazyGridScope, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 921
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridKt.LazyGrid(androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.grid.LazyGridState, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.PaddingValues, boolean, boolean, androidx.compose.foundation.gestures.FlingBehavior, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ScrollPositionUpdater(final LazyGridItemProvider lazyGridItemProvider, final LazyGridState lazyGridState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(950944068);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScrollPositionUpdater):LazyGrid.kt#7791vq");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(lazyGridItemProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(lazyGridState) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (lazyGridItemProvider.getItemCount() > 0) {
                lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider);
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt.ScrollPositionUpdater.1
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
                LazyGridKt.ScrollPositionUpdater(lazyGridItemProvider, lazyGridState, composer2, i | 1);
            }
        });
    }

    private static final Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> rememberLazyGridMeasurePolicy(final LazyGridItemProvider lazyGridItemProvider, final LazyGridState lazyGridState, final OverscrollEffect overscrollEffect, final Function2<? super Density, ? super Constraints, ? extends List<Integer>> function2, final PaddingValues paddingValues, final boolean z, final boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, final LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1958911962);
        ComposerKt.sourceInformation(composer, "C(rememberLazyGridMeasurePolicy)P(3,8,4,7!1,6,2!1,9)178@7377L8234:LazyGrid.kt#7791vq");
        final Arrangement.Horizontal horizontal2 = (i2 & 128) != 0 ? null : horizontal;
        final Arrangement.Vertical vertical2 = (i2 & 256) != 0 ? null : vertical;
        Object[] objArr = {lazyGridState, overscrollEffect, function2, paddingValues, Boolean.valueOf(z), Boolean.valueOf(z2), horizontal2, vertical2, lazyGridItemPlacementAnimator};
        composer.startReplaceableGroup(-568225417);
        ComposerKt.sourceInformation(composer, "C(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = false;
        for (int i3 = 0; i3 < 9; i3++) {
            zChanged |= composer.changed(objArr[i3]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function2) new Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ LazyGridMeasureResult invoke(LazyLayoutMeasureScope lazyLayoutMeasureScope, Constraints constraints) {
                    return m598invoke0kLqBqw(lazyLayoutMeasureScope, constraints.getValue());
                }

                /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                public final LazyGridMeasureResult m598invoke0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
                    int i4;
                    int i5;
                    int i6;
                    float spacing;
                    float spacing2;
                    int iM3831getMaxWidthimpl;
                    long jIntOffset;
                    int firstVisibleItemScrollOffset;
                    int iM614getLineIndexOfItem_Ze7BM;
                    Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "$this$null");
                    CheckScrollableContainerConstraintsKt.m190checkScrollableContainerConstraintsK40F9xA(j, z2 ? Orientation.Vertical : Orientation.Horizontal);
                    if (z2) {
                        i4 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(paddingValues.mo408calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i4 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    if (z2) {
                        i5 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(paddingValues.mo409calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
                    } else {
                        i5 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
                    }
                    int i7 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(paddingValues.getTop());
                    int i8 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(paddingValues.getBottom());
                    final int i9 = i7 + i8;
                    final int i10 = i4 + i5;
                    boolean z3 = z2;
                    int i11 = z3 ? i9 : i10;
                    if (z3 && !z) {
                        i6 = i7;
                    } else if (z3 && z) {
                        i6 = i8;
                    } else {
                        i6 = (z3 || z) ? i5 : i4;
                    }
                    final int i12 = i11 - i6;
                    long jM3847offsetNN6EwU = ConstraintsKt.m3847offsetNN6EwU(j, -i10, -i9);
                    lazyGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider);
                    final LazyGridSpanLayoutProvider spanLayoutProvider = lazyGridItemProvider.getSpanLayoutProvider();
                    final List<Integer> listInvoke = function2.invoke(lazyLayoutMeasureScope, Constraints.m3819boximpl(j));
                    spanLayoutProvider.setSlotsPerLine(listInvoke.size());
                    LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                    lazyGridState.setDensity$foundation_release(lazyLayoutMeasureScope2);
                    lazyGridState.setSlotsPerLine$foundation_release(listInvoke.size());
                    if (z2) {
                        Arrangement.Vertical vertical3 = vertical2;
                        if (vertical3 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = vertical3.getSpacing();
                    } else {
                        Arrangement.Horizontal horizontal3 = horizontal2;
                        if (horizontal3 == null) {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                        spacing = horizontal3.getSpacing();
                    }
                    int i13 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(spacing);
                    if (z2) {
                        Arrangement.Horizontal horizontal4 = horizontal2;
                        spacing2 = horizontal4 != null ? horizontal4.getSpacing() : Dp.m3887constructorimpl(0);
                    } else {
                        Arrangement.Vertical vertical4 = vertical2;
                        spacing2 = vertical4 != null ? vertical4.getSpacing() : Dp.m3887constructorimpl(0);
                    }
                    final int i14 = lazyLayoutMeasureScope.mo311roundToPx0680j_4(spacing2);
                    int itemCount = lazyGridItemProvider.getItemCount();
                    if (z2) {
                        iM3831getMaxWidthimpl = Constraints.m3830getMaxHeightimpl(j) - i9;
                    } else {
                        iM3831getMaxWidthimpl = Constraints.m3831getMaxWidthimpl(j) - i10;
                    }
                    int i15 = iM3831getMaxWidthimpl;
                    if (!z || i15 > 0) {
                        jIntOffset = IntOffsetKt.IntOffset(i4, i7);
                    } else {
                        boolean z4 = z2;
                        if (!z4) {
                            i4 += i15;
                        }
                        if (z4) {
                            i7 += i15;
                        }
                        jIntOffset = IntOffsetKt.IntOffset(i4, i7);
                    }
                    final long j2 = jIntOffset;
                    LazyGridItemProvider lazyGridItemProvider2 = lazyGridItemProvider;
                    final boolean z5 = z2;
                    final boolean z6 = z;
                    final LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator2 = lazyGridItemPlacementAnimator;
                    final int i16 = i6;
                    LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(lazyGridItemProvider2, lazyLayoutMeasureScope, i13, new MeasuredItemFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
                        @Override // androidx.compose.foundation.lazy.grid.MeasuredItemFactory
                        /* JADX INFO: renamed from: createItem-PU_OBEw, reason: not valid java name */
                        public final LazyMeasuredItem mo600createItemPU_OBEw(int i17, Object key, int i18, int i19, Placeable[] placeables) {
                            Intrinsics.checkNotNullParameter(key, "key");
                            Intrinsics.checkNotNullParameter(placeables, "placeables");
                            return new LazyMeasuredItem(i17, key, z5, i18, i19, z6, lazyLayoutMeasureScope.getLayoutDirection(), i16, i12, placeables, lazyGridItemPlacementAnimator2, j2, null);
                        }
                    });
                    final boolean z7 = z2;
                    final LazyMeasuredLineProvider lazyMeasuredLineProvider = new LazyMeasuredLineProvider(z7, listInvoke, i14, itemCount, i13, lazyMeasuredItemProvider, spanLayoutProvider, new MeasuredLineFactory() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
                        @Override // androidx.compose.foundation.lazy.grid.MeasuredLineFactory
                        /* JADX INFO: renamed from: createLine-H9FfpSk, reason: not valid java name */
                        public final LazyMeasuredLine mo601createLineH9FfpSk(int i17, LazyMeasuredItem[] items, List<GridItemSpan> spans, int i18) {
                            Intrinsics.checkNotNullParameter(items, "items");
                            Intrinsics.checkNotNullParameter(spans, "spans");
                            return new LazyMeasuredLine(i17, items, spans, z7, listInvoke.size(), lazyLayoutMeasureScope.getLayoutDirection(), i18, i14, null);
                        }
                    });
                    lazyGridState.setPrefetchInfoRetriever$foundation_release(new Function1<LineIndex, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ ArrayList<Pair<? extends Integer, ? extends Constraints>> invoke(LineIndex lineIndex) {
                            return m599invokebKFJvoY(lineIndex.m634unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-bKFJvoY, reason: not valid java name */
                        public final ArrayList<Pair<Integer, Constraints>> m599invokebKFJvoY(int i17) {
                            LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = spanLayoutProvider.getLineConfiguration(i17);
                            int iM572constructorimpl = ItemIndex.m572constructorimpl(lineConfiguration.getFirstItemIndex());
                            ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                            List<GridItemSpan> spans = lineConfiguration.getSpans();
                            LazyMeasuredLineProvider lazyMeasuredLineProvider2 = lazyMeasuredLineProvider;
                            int size = spans.size();
                            int i18 = 0;
                            for (int i19 = 0; i19 < size; i19++) {
                                int iM566getCurrentLineSpanimpl = GridItemSpan.m566getCurrentLineSpanimpl(spans.get(i19).getPackedValue());
                                arrayList.add(TuplesKt.to(Integer.valueOf(iM572constructorimpl), lazyMeasuredLineProvider2.getChildConstraints$foundation_release().invoke(Integer.valueOf(i18), Integer.valueOf(iM566getCurrentLineSpanimpl))));
                                iM572constructorimpl = ItemIndex.m572constructorimpl(iM572constructorimpl + 1);
                                i18 += iM566getCurrentLineSpanimpl;
                            }
                            return arrayList;
                        }
                    });
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LazyGridState lazyGridState2 = lazyGridState;
                    Snapshot snapshotCreateNonObservableSnapshot = companion.createNonObservableSnapshot();
                    try {
                        Snapshot snapshotMakeCurrent = snapshotCreateNonObservableSnapshot.makeCurrent();
                        try {
                            if (lazyGridState2.getFirstVisibleItemIndex() < itemCount || itemCount <= 0) {
                                int iM614getLineIndexOfItem_Ze7BM2 = spanLayoutProvider.m614getLineIndexOfItem_Ze7BM(lazyGridState2.getFirstVisibleItemIndex());
                                firstVisibleItemScrollOffset = lazyGridState2.getFirstVisibleItemScrollOffset();
                                iM614getLineIndexOfItem_Ze7BM = iM614getLineIndexOfItem_Ze7BM2;
                            } else {
                                firstVisibleItemScrollOffset = 0;
                                iM614getLineIndexOfItem_Ze7BM = spanLayoutProvider.m614getLineIndexOfItem_Ze7BM(itemCount - 1);
                            }
                            Unit unit = Unit.INSTANCE;
                            snapshotCreateNonObservableSnapshot.dispose();
                            LazyGridMeasureResult lazyGridMeasureResultM602measureLazyGridzIfe3eg = LazyGridMeasureKt.m602measureLazyGridzIfe3eg(itemCount, lazyMeasuredLineProvider, lazyMeasuredItemProvider, i15, listInvoke.size(), i6, i12, iM614getLineIndexOfItem_Ze7BM, firstVisibleItemScrollOffset, lazyGridState.getScrollToBeConsumed(), jM3847offsetNN6EwU, z2, vertical2, horizontal2, z, lazyLayoutMeasureScope2, lazyGridItemPlacementAnimator, new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1.3
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
                                    return lazyLayoutMeasureScope.layout(ConstraintsKt.m3845constrainWidthK40F9xA(j, i17 + i10), ConstraintsKt.m3844constrainHeightK40F9xA(j, i18 + i9), MapsKt.emptyMap(), placement);
                                }
                            });
                            LazyGridState lazyGridState3 = lazyGridState;
                            OverscrollEffect overscrollEffect2 = overscrollEffect;
                            lazyGridState3.applyMeasureResult$foundation_release(lazyGridMeasureResultM602measureLazyGridzIfe3eg);
                            LazyGridKt.refreshOverscrollInfo(overscrollEffect2, lazyGridMeasureResultM602measureLazyGridzIfe3eg);
                            return lazyGridMeasureResultM602measureLazyGridzIfe3eg;
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
        Function2<LazyLayoutMeasureScope, Constraints, MeasureResult> function22 = (Function2) objRememberedValue;
        composer.endReplaceableGroup();
        return function22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshOverscrollInfo(OverscrollEffect overscrollEffect, LazyGridMeasureResult lazyGridMeasureResult) {
        Object obj;
        LazyMeasuredItem[] items;
        boolean canScrollForward = lazyGridMeasureResult.getCanScrollForward();
        LazyMeasuredLine firstVisibleLine = lazyGridMeasureResult.getFirstVisibleLine();
        if (firstVisibleLine == null || (items = firstVisibleLine.getItems()) == null || (obj = (LazyMeasuredItem) ArraysKt.firstOrNull(items)) == null) {
            obj = 0;
        }
        overscrollEffect.setEnabled(canScrollForward || (!Intrinsics.areEqual(obj, (Object) 0) || lazyGridMeasureResult.getFirstVisibleLineScrollOffset() != 0));
    }
}
