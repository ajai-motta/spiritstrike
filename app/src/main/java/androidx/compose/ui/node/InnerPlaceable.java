package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InnerPlaceable.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ^2\u00020\u00012\u00020\u0002:\u0001^B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J{\u0010\u0014\u001a\u00020\u0015\"\u0014\b\u0000\u0010\u0016*\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\b\u0001\u0010\u0019\"\b\b\u0002\u0010\u0018*\u00020\u001a2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u0002H\u00180\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00190 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0010\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0016J\u001d\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011H\u0016J\u0010\u00101\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0016J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0016J@\u00105\u001a\u00020\u00152\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00072\u0019\u00109\u001a\u0015\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0015\u0018\u00010:¢\u0006\u0002\b<H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u0010>J\u001a\u0010?\u001a\u00020\u0011*\u00020@H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bA\u0010BJ\u001a\u0010?\u001a\u00020\u0011*\u00020CH\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010EJ\u001a\u0010F\u001a\u00020@*\u00020CH\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010HJ\u001d\u0010F\u001a\u00020@*\u00020\u0007H\u0097\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bI\u0010JJ\u001d\u0010F\u001a\u00020@*\u00020\u0011H\u0097\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\bI\u0010KJ\u001a\u0010L\u001a\u00020M*\u00020NH\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010PJ\u001a\u0010Q\u001a\u00020\u0007*\u00020@H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010JJ\u001a\u0010Q\u001a\u00020\u0007*\u00020CH\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bS\u0010HJ\r\u0010T\u001a\u00020U*\u00020VH\u0097\u0001J\u001a\u0010W\u001a\u00020N*\u00020MH\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bX\u0010PJ\u001a\u0010Y\u001a\u00020C*\u00020@H\u0097\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bZ\u0010[J\u001d\u0010Y\u001a\u00020C*\u00020\u0007H\u0097\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\\\u0010[J\u001d\u0010Y\u001a\u00020C*\u00020\u0011H\u0097\u0001ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\\\u0010]R\u0014\u0010\u0006\u001a\u00020\u00078\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006_"}, d2 = {"Landroidx/compose/ui/node/InnerPlaceable;", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "Landroidx/compose/ui/unit/Density;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "measureScope", "Landroidx/compose/ui/layout/MeasureScope;", "getMeasureScope", "()Landroidx/compose/ui/layout/MeasureScope;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "hitTestChild", "", "T", "Landroidx/compose/ui/node/LayoutNodeEntity;", "M", "C", "Landroidx/compose/ui/Modifier;", "hitTestSource", "Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "hitTestChild-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNodeWrapper$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "maxIntrinsicHeight", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "maxIntrinsicWidth", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicHeight", "minIntrinsicWidth", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", k.M, "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InnerPlaceable extends LayoutNodeWrapper implements Density {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Paint innerBoundsPaint;
    private final /* synthetic */ MeasureScope $$delegate_0;

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public int mo310roundToPxR2X_6o(long j) {
        return this.$$delegate_0.mo310roundToPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public int mo311roundToPx0680j_4(float f) {
        return this.$$delegate_0.mo311roundToPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public float mo312toDpGaN1DYA(long j) {
        return this.$$delegate_0.mo312toDpGaN1DYA(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo313toDpu2uoSUM(float f) {
        return this.$$delegate_0.mo313toDpu2uoSUM(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public float mo314toDpu2uoSUM(int i) {
        return this.$$delegate_0.mo314toDpu2uoSUM(i);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public long mo315toDpSizekrfVVM(long j) {
        return this.$$delegate_0.mo315toDpSizekrfVVM(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public float mo316toPxR2X_6o(long j) {
        return this.$$delegate_0.mo316toPxR2X_6o(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public float mo317toPx0680j_4(float f) {
        return this.$$delegate_0.mo317toPx0680j_4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    public Rect toRect(DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.$$delegate_0.toRect(dpRect);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public long mo318toSizeXkaWNTQ(long j) {
        return this.$$delegate_0.mo318toSizeXkaWNTQ(j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public long mo319toSp0xMU5do(float f) {
        return this.$$delegate_0.mo319toSp0xMU5do(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo320toSpkPz2Gy4(float f) {
        return this.$$delegate_0.mo320toSpkPz2Gy4(f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public long mo321toSpkPz2Gy4(int i) {
        return this.$$delegate_0.mo321toSpkPz2Gy4(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerPlaceable(LayoutNode layoutNode) {
        super(layoutNode);
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.$$delegate_0 = layoutNode.getMeasureScope();
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public MeasureScope getMeasureScope() {
        return getLayoutNode().getMeasureScope();
    }

    @Override // androidx.compose.ui.layout.Measurable
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo3152measureBRTryo0(long constraints) {
        m3193setMeasurementConstraintsBRTryo0(constraints);
        MutableVector<LayoutNode> mutableVector = getLayoutNode().get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i = 0;
            do {
                content[i].setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                i++;
            } while (i < size);
        }
        getLayoutNode().handleMeasureResult$ui_release(getLayoutNode().getMeasurePolicy().mo16measure3p2s80s(getLayoutNode().getMeasureScope(), getLayoutNode().getChildren$ui_release(), constraints));
        onMeasured();
        return this;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        return getLayoutNode().getIntrinsicsPolicy().minIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        return getLayoutNode().getIntrinsicsPolicy().minIntrinsicHeight(width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        return getLayoutNode().getIntrinsicsPolicy().maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        return getLayoutNode().getIntrinsicsPolicy().maxIntrinsicHeight(width);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.node.LayoutNodeWrapper, androidx.compose.ui.layout.Placeable
    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public void mo3153placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.mo3153placeAtf8xVGno(position, zIndex, layerBlock);
        LayoutNodeWrapper wrappedBy$ui_release = getWrappedBy();
        if (wrappedBy$ui_release == null || !wrappedBy$ui_release.getIsShallowPlacing()) {
            onPlaced();
            getLayoutNode().onNodePlaced$ui_release();
        }
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        Integer num = getLayoutNode().calculateAlignmentLines$ui_release().get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Owner ownerRequireOwner = LayoutNodeKt.requireOwner(getLayoutNode());
        MutableVector<LayoutNode> zSortedChildren = getLayoutNode().getZSortedChildren();
        int size = zSortedChildren.getSize();
        if (size > 0) {
            LayoutNode[] content = zSortedChildren.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode = content[i];
                if (layoutNode.getIsPlaced()) {
                    layoutNode.draw$ui_release(canvas);
                }
                i++;
            } while (i < size);
        }
        if (ownerRequireOwner.getShowLayoutBounds()) {
            drawBorder(canvas, innerBoundsPaint);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    @Override // androidx.compose.ui.node.LayoutNodeWrapper
    /* JADX INFO: renamed from: hitTestChild-YqVAtuI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T extends androidx.compose.ui.node.LayoutNodeEntity<T, M>, C, M extends androidx.compose.ui.Modifier> void mo3273hitTestChildYqVAtuI(androidx.compose.ui.node.LayoutNodeWrapper.HitTestSource<T, C, M> r18, long r19, androidx.compose.ui.node.HitTestResult<C> r21, boolean r22, boolean r23) {
        /*
            r17 = this;
            r0 = r17
            r8 = r18
            r9 = r19
            r11 = r21
            java.lang.String r1 = "hitTestSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "hitTestResult"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            androidx.compose.ui.node.LayoutNode r1 = r17.getLayoutNode()
            boolean r1 = r8.shouldHitTestChildren(r1)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L40
            boolean r1 = r0.m3310withinLayerBoundsk4lQ0M(r9)
            if (r1 == 0) goto L28
            r12 = r23
        L26:
            r3 = r2
            goto L42
        L28:
            if (r22 == 0) goto L40
            long r4 = r17.m3304getMinimumTouchTargetSizeNHjbRc()
            float r1 = r0.m3301distanceInMinimumTouchTargettz77jQw(r9, r4)
            boolean r4 = java.lang.Float.isInfinite(r1)
            if (r4 != 0) goto L40
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L40
            r12 = r3
            goto L26
        L40:
            r12 = r23
        L42:
            if (r3 == 0) goto L91
            int r13 = androidx.compose.ui.node.HitTestResult.access$getHitDepth$p(r21)
            androidx.compose.ui.node.LayoutNode r1 = r17.getLayoutNode()
            androidx.compose.runtime.collection.MutableVector r1 = r1.getZSortedChildren()
            int r3 = r1.getSize()
            if (r3 <= 0) goto L8e
            int r3 = r3 - r2
            java.lang.Object[] r14 = r1.getContent()
            r15 = r3
        L5c:
            r1 = r14[r15]
            r16 = r1
            androidx.compose.ui.node.LayoutNode r16 = (androidx.compose.ui.node.LayoutNode) r16
            boolean r1 = r16.getIsPlaced()
            if (r1 == 0) goto L8a
            r1 = r18
            r2 = r16
            r3 = r19
            r5 = r21
            r6 = r22
            r7 = r12
            r1.mo3311childHitTestYqVAtuI(r2, r3, r5, r6, r7)
            boolean r1 = r21.hasHit()
            if (r1 != 0) goto L7d
            goto L8a
        L7d:
            androidx.compose.ui.node.LayoutNodeWrapper r1 = r16.getOuterLayoutNodeWrapper$ui_release()
            boolean r1 = r1.shouldSharePointerInputWithSiblings()
            if (r1 == 0) goto L8e
            r21.acceptHits()
        L8a:
            int r15 = r15 + (-1)
            if (r15 >= 0) goto L5c
        L8e:
            androidx.compose.ui.node.HitTestResult.access$setHitDepth$p(r11, r13)
        L91:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.InnerPlaceable.mo3273hitTestChildYqVAtuI(androidx.compose.ui.node.LayoutNodeWrapper$HitTestSource, long, androidx.compose.ui.node.HitTestResult, boolean, boolean):void");
    }

    /* JADX INFO: compiled from: InnerPlaceable.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/node/InnerPlaceable$Companion;", "", "()V", "innerBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getInnerBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getInnerBoundsPaint() {
            return InnerPlaceable.innerBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo1529setColor8_81llA(Color.INSTANCE.m1679getRed0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.mo1533setStylek9PVt8s(PaintingStyle.INSTANCE.m1880getStrokeTiuSbCo());
        innerBoundsPaint = Paint;
    }
}
