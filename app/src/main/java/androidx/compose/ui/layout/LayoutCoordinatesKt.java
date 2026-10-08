package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LayoutCoordinates.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0012\u0010\t\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0012\u0010\n\u001a\u00020\u0007*\u00020\u0002ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRoot", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.mo3156localToRootMKHz9U(Offset.INSTANCE.m1424getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return layoutCoordinates.mo3157localToWindowMKHz9U(Offset.INSTANCE.m1424getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return LayoutCoordinates.CC.localBoundingBoxOf$default(findRoot(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates layoutCoordinatesFindRoot = findRoot(layoutCoordinates);
        Rect rectBoundsInRoot = boundsInRoot(layoutCoordinates);
        long jMo3157localToWindowMKHz9U = layoutCoordinatesFindRoot.mo3157localToWindowMKHz9U(OffsetKt.Offset(rectBoundsInRoot.getLeft(), rectBoundsInRoot.getTop()));
        long jMo3157localToWindowMKHz9U2 = layoutCoordinatesFindRoot.mo3157localToWindowMKHz9U(OffsetKt.Offset(rectBoundsInRoot.getRight(), rectBoundsInRoot.getTop()));
        long jMo3157localToWindowMKHz9U3 = layoutCoordinatesFindRoot.mo3157localToWindowMKHz9U(OffsetKt.Offset(rectBoundsInRoot.getRight(), rectBoundsInRoot.getBottom()));
        long jMo3157localToWindowMKHz9U4 = layoutCoordinatesFindRoot.mo3157localToWindowMKHz9U(OffsetKt.Offset(rectBoundsInRoot.getLeft(), rectBoundsInRoot.getBottom()));
        return new Rect(ComparisonsKt.minOf(Offset.m1408getXimpl(jMo3157localToWindowMKHz9U), Offset.m1408getXimpl(jMo3157localToWindowMKHz9U2), Offset.m1408getXimpl(jMo3157localToWindowMKHz9U4), Offset.m1408getXimpl(jMo3157localToWindowMKHz9U3)), ComparisonsKt.minOf(Offset.m1409getYimpl(jMo3157localToWindowMKHz9U), Offset.m1409getYimpl(jMo3157localToWindowMKHz9U2), Offset.m1409getYimpl(jMo3157localToWindowMKHz9U4), Offset.m1409getYimpl(jMo3157localToWindowMKHz9U3)), ComparisonsKt.maxOf(Offset.m1408getXimpl(jMo3157localToWindowMKHz9U), Offset.m1408getXimpl(jMo3157localToWindowMKHz9U2), Offset.m1408getXimpl(jMo3157localToWindowMKHz9U4), Offset.m1408getXimpl(jMo3157localToWindowMKHz9U3)), ComparisonsKt.maxOf(Offset.m1409getYimpl(jMo3157localToWindowMKHz9U), Offset.m1409getYimpl(jMo3157localToWindowMKHz9U2), Offset.m1409getYimpl(jMo3157localToWindowMKHz9U4), Offset.m1409getYimpl(jMo3157localToWindowMKHz9U3)));
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo3155localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m1424getZeroF1C5BW0()) : Offset.INSTANCE.m1424getZeroF1C5BW0();
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect rectLocalBoundingBoxOf$default;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectLocalBoundingBoxOf$default = LayoutCoordinates.CC.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, IntSize.m4047getWidthimpl(layoutCoordinates.mo3154getSizeYbymL2g()), IntSize.m4046getHeightimpl(layoutCoordinates.mo3154getSizeYbymL2g())) : rectLocalBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRoot(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        LayoutNodeWrapper layoutNodeWrapper = layoutCoordinates2 instanceof LayoutNodeWrapper ? (LayoutNodeWrapper) layoutCoordinates2 : null;
        if (layoutNodeWrapper == null) {
            return layoutCoordinates2;
        }
        LayoutNodeWrapper wrappedBy$ui_release = layoutNodeWrapper.getWrappedBy();
        while (true) {
            LayoutNodeWrapper layoutNodeWrapper2 = wrappedBy$ui_release;
            LayoutNodeWrapper layoutNodeWrapper3 = layoutNodeWrapper;
            layoutNodeWrapper = layoutNodeWrapper2;
            if (layoutNodeWrapper != null) {
                wrappedBy$ui_release = layoutNodeWrapper.getWrappedBy();
            } else {
                return layoutNodeWrapper3;
            }
        }
    }
}
