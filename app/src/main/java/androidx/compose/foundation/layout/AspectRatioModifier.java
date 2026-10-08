package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: AspectRatio.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0019\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010\"\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J)\u0010$\u001a\u00020%*\u00020&2\u0006\u0010\u001f\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001c\u0010+\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010,\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J#\u0010-\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J#\u00101\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00100J#\u00103\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00100J#\u00105\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00100R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FZLkotlin/jvm/functions/Function1;)V", "getAspectRatio", "()F", "getMatchHeightConstraintsFirst", "()Z", "equals", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicWidth", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class AspectRatioModifier extends InspectorValueInfo implements LayoutModifier {
    private final float aspectRatio;
    private final boolean matchHeightConstraintsFirst;

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

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AspectRatioModifier(float f, boolean z, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
        if (f > 0.0f) {
            return;
        }
        throw new IllegalArgumentException(("aspectRatio " + f + " must be > 0").toString());
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo31measure3p2s80s(MeasureScope measure, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long jM389findSizeToXhtMw = m389findSizeToXhtMw(j);
        if (!IntSize.m4045equalsimpl0(jM389findSizeToXhtMw, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
            j = Constraints.INSTANCE.m3839fixedJhjzzOo(IntSize.m4047getWidthimpl(jM389findSizeToXhtMw), IntSize.m4046getHeightimpl(jM389findSizeToXhtMw));
        }
        final Placeable placeableMo3152measureBRTryo0 = measurable.mo3152measureBRTryo0(j);
        return MeasureScope.CC.layout$default(measure, placeableMo3152measureBRTryo0.getWidth(), placeableMo3152measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioModifier$measure$1
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
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i * this.aspectRatio);
        }
        return measurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i * this.aspectRatio);
        }
        return measurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i / this.aspectRatio);
        }
        return measurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable measurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(i / this.aspectRatio);
        }
        return measurable.maxIntrinsicHeight(i);
    }

    /* JADX INFO: renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m389findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long jM393tryMaxWidthJN0ABg$default = m393tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4045equalsimpl0(jM393tryMaxWidthJN0ABg$default, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM393tryMaxWidthJN0ABg$default;
            }
            long jM391tryMaxHeightJN0ABg$default = m391tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4045equalsimpl0(jM391tryMaxHeightJN0ABg$default, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM391tryMaxHeightJN0ABg$default;
            }
            long jM397tryMinWidthJN0ABg$default = m397tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4045equalsimpl0(jM397tryMinWidthJN0ABg$default, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM397tryMinWidthJN0ABg$default;
            }
            long jM395tryMinHeightJN0ABg$default = m395tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4045equalsimpl0(jM395tryMinHeightJN0ABg$default, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM395tryMinHeightJN0ABg$default;
            }
            long jM392tryMaxWidthJN0ABg = m392tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m4045equalsimpl0(jM392tryMaxWidthJN0ABg, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM392tryMaxWidthJN0ABg;
            }
            long jM390tryMaxHeightJN0ABg = m390tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m4045equalsimpl0(jM390tryMaxHeightJN0ABg, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM390tryMaxHeightJN0ABg;
            }
            long jM396tryMinWidthJN0ABg = m396tryMinWidthJN0ABg(j, false);
            if (!IntSize.m4045equalsimpl0(jM396tryMinWidthJN0ABg, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM396tryMinWidthJN0ABg;
            }
            long jM394tryMinHeightJN0ABg = m394tryMinHeightJN0ABg(j, false);
            if (!IntSize.m4045equalsimpl0(jM394tryMinHeightJN0ABg, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM394tryMinHeightJN0ABg;
            }
        } else {
            long jM391tryMaxHeightJN0ABg$default2 = m391tryMaxHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4045equalsimpl0(jM391tryMaxHeightJN0ABg$default2, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM391tryMaxHeightJN0ABg$default2;
            }
            long jM393tryMaxWidthJN0ABg$default2 = m393tryMaxWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4045equalsimpl0(jM393tryMaxWidthJN0ABg$default2, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM393tryMaxWidthJN0ABg$default2;
            }
            long jM395tryMinHeightJN0ABg$default2 = m395tryMinHeightJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4045equalsimpl0(jM395tryMinHeightJN0ABg$default2, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM395tryMinHeightJN0ABg$default2;
            }
            long jM397tryMinWidthJN0ABg$default2 = m397tryMinWidthJN0ABg$default(this, j, false, 1, null);
            if (!IntSize.m4045equalsimpl0(jM397tryMinWidthJN0ABg$default2, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM397tryMinWidthJN0ABg$default2;
            }
            long jM390tryMaxHeightJN0ABg2 = m390tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m4045equalsimpl0(jM390tryMaxHeightJN0ABg2, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM390tryMaxHeightJN0ABg2;
            }
            long jM392tryMaxWidthJN0ABg2 = m392tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m4045equalsimpl0(jM392tryMaxWidthJN0ABg2, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM392tryMaxWidthJN0ABg2;
            }
            long jM394tryMinHeightJN0ABg2 = m394tryMinHeightJN0ABg(j, false);
            if (!IntSize.m4045equalsimpl0(jM394tryMinHeightJN0ABg2, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM394tryMinHeightJN0ABg2;
            }
            long jM396tryMinWidthJN0ABg2 = m396tryMinWidthJN0ABg(j, false);
            if (!IntSize.m4045equalsimpl0(jM396tryMinWidthJN0ABg2, IntSize.INSTANCE.m4052getZeroYbymL2g())) {
                return jM396tryMinWidthJN0ABg2;
            }
        }
        return IntSize.INSTANCE.m4052getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m393tryMaxWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m392tryMaxWidthJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m392tryMaxWidthJN0ABg(long j, boolean z) {
        int iRoundToInt;
        int iM3831getMaxWidthimpl = Constraints.m3831getMaxWidthimpl(j);
        if (iM3831getMaxWidthimpl != Integer.MAX_VALUE && (iRoundToInt = MathKt.roundToInt(iM3831getMaxWidthimpl / this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iM3831getMaxWidthimpl, iRoundToInt);
            if (!z || ConstraintsKt.m3846isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m4052getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m391tryMaxHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m390tryMaxHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m390tryMaxHeightJN0ABg(long j, boolean z) {
        int iRoundToInt;
        int iM3830getMaxHeightimpl = Constraints.m3830getMaxHeightimpl(j);
        if (iM3830getMaxHeightimpl != Integer.MAX_VALUE && (iRoundToInt = MathKt.roundToInt(iM3830getMaxHeightimpl * this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iRoundToInt, iM3830getMaxHeightimpl);
            if (!z || ConstraintsKt.m3846isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m4052getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m397tryMinWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m396tryMinWidthJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m396tryMinWidthJN0ABg(long j, boolean z) {
        int iM3833getMinWidthimpl = Constraints.m3833getMinWidthimpl(j);
        int iRoundToInt = MathKt.roundToInt(iM3833getMinWidthimpl / this.aspectRatio);
        if (iRoundToInt > 0) {
            long jIntSize = IntSizeKt.IntSize(iM3833getMinWidthimpl, iRoundToInt);
            if (!z || ConstraintsKt.m3846isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m4052getZeroYbymL2g();
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    static /* synthetic */ long m395tryMinHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m394tryMinHeightJN0ABg(j, z);
    }

    /* JADX INFO: renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m394tryMinHeightJN0ABg(long j, boolean z) {
        int iM3832getMinHeightimpl = Constraints.m3832getMinHeightimpl(j);
        int iRoundToInt = MathKt.roundToInt(iM3832getMinHeightimpl * this.aspectRatio);
        if (iRoundToInt > 0) {
            long jIntSize = IntSizeKt.IntSize(iRoundToInt, iM3832getMinHeightimpl);
            if (!z || ConstraintsKt.m3846isSatisfiedBy4WqzIAM(j, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m4052getZeroYbymL2g();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        AspectRatioModifier aspectRatioModifier = other instanceof AspectRatioModifier ? (AspectRatioModifier) other : null;
        if (aspectRatioModifier == null) {
            return false;
        }
        return this.aspectRatio == aspectRatioModifier.aspectRatio && this.matchHeightConstraintsFirst == ((AspectRatioModifier) other).matchHeightConstraintsFirst;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.aspectRatio) * 31) + UByte$$ExternalSyntheticBackport0.m(this.matchHeightConstraintsFirst);
    }

    public String toString() {
        return "AspectRatioModifier(aspectRatio=" + this.aspectRatio + ')';
    }
}
