package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: LazyBeyondBoundsModifier.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ%\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J@\u0010\u001a\u001a\u0004\u0018\u0001H\u001b\"\u0004\b\u0000\u0010\u001b2\u0006\u0010\u0016\u001a\u00020\u00172\u0019\u0010\u001c\u001a\u0015\u0012\u0004\u0012\u00020\u001e\u0012\u0006\u0012\u0004\u0018\u0001H\u001b0\u001d¢\u0006\u0002\b\u001fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\b*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListBeyondBoundsModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/layout/BeyondBoundsLayout;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "reverseLayout", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;ZLandroidx/compose/ui/unit/LayoutDirection;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Landroidx/compose/ui/layout/BeyondBoundsLayout;", "addNextInterval", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "currentInterval", "direction", "Landroidx/compose/ui/layout/BeyondBoundsLayout$LayoutDirection;", "addNextInterval-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", TtmlNode.TAG_LAYOUT, "T", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/BeyondBoundsLayout$BeyondBoundsScope;", "Lkotlin/ExtensionFunctionType;", "layout-o7g1Pn8", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasMoreContent", "hasMoreContent-FR3nfPY", "(Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;I)Z", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class LazyListBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;
    private final LayoutDirection layoutDirection;
    private final boolean reverseLayout;
    private final LazyListState state;

    /* JADX INFO: compiled from: LazyBeyondBoundsModifier.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

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

    public LazyListBeyondBoundsModifierLocal(LazyListState state, LazyListBeyondBoundsInfo beyondBoundsInfo, boolean z, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.state = state;
        this.beyondBoundsInfo = beyondBoundsInfo;
        this.reverseLayout = z;
        this.layoutDirection = layoutDirection;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.getModifierLocalBeyondBoundsLayout();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public BeyondBoundsLayout getValue() {
        return this;
    }

    @Override // androidx.compose.ui.layout.BeyondBoundsLayout
    /* JADX INFO: renamed from: layout-o7g1Pn8, reason: not valid java name */
    public <T> T mo536layouto7g1Pn8(final int direction, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) this.beyondBoundsInfo.addInterval(this.state.getFirstVisibleItemIndex(), ((LazyListItemInfo) CollectionsKt.last((List) this.state.getLayoutInfo().getVisibleItemsInfo())).getIndex());
        T tInvoke = null;
        while (tInvoke == null && m535hasMoreContentFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, direction)) {
            T t = (T) m534addNextIntervalFR3nfPY((LazyListBeyondBoundsInfo.Interval) objectRef.element, direction);
            this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
            objectRef.element = t;
            Remeasurement remeasurement$foundation_release = this.state.getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            tInvoke = block.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal$layout$2
                @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                public boolean getHasMoreContent() {
                    return this.this$0.m535hasMoreContentFR3nfPY(objectRef.element, direction);
                }
            });
        }
        this.beyondBoundsInfo.removeInterval((LazyListBeyondBoundsInfo.Interval) objectRef.element);
        Remeasurement remeasurement$foundation_release2 = this.state.getRemeasurement$foundation_release();
        if (remeasurement$foundation_release2 != null) {
            remeasurement$foundation_release2.forceRemeasure();
        }
        return tInvoke;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /* JADX INFO: renamed from: addNextInterval-FR3nfPY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval m534addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo.Interval r5, int r6) {
        /*
            r4 = this;
            int r0 = r5.getStart()
            int r5 = r5.getEnd()
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.INSTANCE
            int r1 = r1.m3138getBeforehoxUOeE()
            boolean r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(r6, r1)
            if (r1 == 0) goto L18
        L14:
            int r0 = r0 + (-1)
            goto L97
        L18:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.INSTANCE
            int r1 = r1.m3137getAfterhoxUOeE()
            boolean r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(r6, r1)
            if (r1 == 0) goto L28
        L24:
            int r5 = r5 + 1
            goto L97
        L28:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.INSTANCE
            int r1 = r1.m3136getAbovehoxUOeE()
            boolean r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(r6, r1)
            if (r1 == 0) goto L39
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L14
            goto L24
        L39:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.INSTANCE
            int r1 = r1.m3139getBelowhoxUOeE()
            boolean r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(r6, r1)
            if (r1 == 0) goto L4a
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L24
            goto L14
        L4a:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.INSTANCE
            int r1 = r1.m3140getLefthoxUOeE()
            boolean r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(r6, r1)
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L71
            androidx.compose.ui.unit.LayoutDirection r6 = r4.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r1[r6]
            if (r6 == r3) goto L6c
            if (r6 == r2) goto L67
            goto L97
        L67:
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L24
            goto L14
        L6c:
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L14
            goto L24
        L71:
            androidx.compose.ui.layout.BeyondBoundsLayout$LayoutDirection$Companion r1 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.INSTANCE
            int r1 = r1.m3141getRighthoxUOeE()
            boolean r6 = androidx.compose.ui.layout.BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(r6, r1)
            if (r6 == 0) goto L9e
            androidx.compose.ui.unit.LayoutDirection r6 = r4.layoutDirection
            int[] r1 = androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r1[r6]
            if (r6 == r3) goto L91
            if (r6 == r2) goto L8c
            goto L97
        L8c:
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L14
            goto L24
        L91:
            boolean r6 = r4.reverseLayout
            if (r6 == 0) goto L24
            goto L14
        L97:
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo r6 = r4.beyondBoundsInfo
            androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval r5 = r6.addInterval(r0, r5)
            return r5
        L9e:
            androidx.compose.foundation.lazy.LazyBeyondBoundsModifierKt.access$unsupportedDirection()
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListBeyondBoundsModifierLocal.m534addNextIntervalFR3nfPY(androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval, int):androidx.compose.foundation.lazy.LazyListBeyondBoundsInfo$Interval");
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsBefore(LazyListBeyondBoundsInfo.Interval interval) {
        return interval.getStart() > 0;
    }

    private static final boolean hasMoreContent_FR3nfPY$hasMoreItemsAfter(LazyListBeyondBoundsInfo.Interval interval, LazyListBeyondBoundsModifierLocal lazyListBeyondBoundsModifierLocal) {
        return interval.getEnd() < lazyListBeyondBoundsModifierLocal.state.getLayoutInfo().getTotalItemsCount() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    public final boolean m535hasMoreContentFR3nfPY(LazyListBeyondBoundsInfo.Interval interval, int i) {
        if (BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3138getBeforehoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        if (BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3137getAfterhoxUOeE())) {
            return hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3136getAbovehoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        if (BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3139getBelowhoxUOeE())) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3140getLefthoxUOeE())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
            if (i2 == 1) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
            }
            if (i2 == 2) {
                return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
            }
            throw new NoWhenBranchMatchedException();
        }
        if (!BeyondBoundsLayout.LayoutDirection.m3132equalsimpl0(i, BeyondBoundsLayout.LayoutDirection.INSTANCE.m3141getRighthoxUOeE())) {
            LazyBeyondBoundsModifierKt.unsupportedDirection();
            throw new KotlinNothingValueException();
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.layoutDirection.ordinal()];
        if (i3 == 1) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval) : hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this);
        }
        if (i3 == 2) {
            return this.reverseLayout ? hasMoreContent_FR3nfPY$hasMoreItemsAfter(interval, this) : hasMoreContent_FR3nfPY$hasMoreItemsBefore(interval);
        }
        throw new NoWhenBranchMatchedException();
    }
}
